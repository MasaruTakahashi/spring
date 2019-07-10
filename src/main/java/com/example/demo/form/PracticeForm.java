package com.example.demo.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class PracticeForm implements Serializable{

	private Long id;
	@NotEmpty
	private String title;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


}
