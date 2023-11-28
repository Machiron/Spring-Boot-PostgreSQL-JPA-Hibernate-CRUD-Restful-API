package net.springboot.pkg.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "subject_name")
	private String subjectName;

	@Column(name = "room_name")
	private String roomName;
	
	@Column(name = "OnSite")
	private String onSite;
	
	public Subject() {
		
	}
	
	public Subject(String subjectName, String roomName, String onSite) {
		super();
		this.subjectName = subjectName;
		this.roomName = roomName;
		this.onSite = onSite;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getOnSite() {
		return onSite;
	}
	public void setOnSite(String onSite) {
		this.onSite = onSite;
	}
}