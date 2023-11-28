package net.springboot.pkg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.pkg.exception.ResourceNotFoundException;
import net.springboot.pkg.model.Subject;
import net.springboot.pkg.repository.SubjectRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class SubjectController {

	@Autowired
	private SubjectRepository subjectRepository;
	
	// get all subjects
	@GetMapping("subjects")
	public List<Subject> getAllSubject(){
		return subjectRepository.findAll();
	}		
	
	// create subject rest API
	@PostMapping("subjects")
	public Subject createSubject(@RequestBody Subject subject) {
		return subjectRepository.save(subject);
	}
	
	// get subject by id rest API
	@GetMapping("subjects/{id}")
	public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {
		Subject subject = subjectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Subject not exist with id :" + id));
		return ResponseEntity.ok(subject);
	}
	
	// update subject rest API
	
	@PutMapping("subjects/{id}")
	public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject subjectDetails){
		Subject subject = subjectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Subject not exist with id :" + id));
		
		subject.setSubjectName(subjectDetails.getSubjectName());
		subject.setRoomName(subjectDetails.getRoomName());
		subject.setOnSite(subjectDetails.getOnSite());
		
		Subject updatedSubject = subjectRepository.save(subject);
		return ResponseEntity.ok(updatedSubject);
	}
	
	// delete subject rest API
	@DeleteMapping("subjects/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSubject(@PathVariable Long id){
		Subject subject = subjectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Subject not exist with id :" + id));
		
		subjectRepository.delete(subject);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}