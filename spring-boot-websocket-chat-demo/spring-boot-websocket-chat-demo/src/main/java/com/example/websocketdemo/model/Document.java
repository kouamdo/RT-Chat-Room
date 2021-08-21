package com.example.websocketdemo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documents")
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	@Column (nullable = false , unique =true , length = 512)
	private String name ;
	
	private String coment;
	
	private String canal;
	


	public Document(long id, String name, String coment, String canal) {
		super();
		this.id = id;
		this.name = name;
		this.coment = coment;
		this.canal = canal;
	}

	private long size ;
	
	@Column(name = "upload_time")
	private Date Uploaddate ;
	
	
	private byte[] content ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getUploaddate() {
		return Uploaddate;
	}

	public void setUploaddate(Date uploaddate) {
		Uploaddate = uploaddate;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getComent() {
		return coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}
	
}
