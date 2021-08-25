package com.inti.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="EVAL")
public class Evaluation extends Message {
	private int note;

	public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evaluation(Long idMessage, String commentaire, Date date, int note) {
		super(idMessage, commentaire, date);
		this.note = note;
		// TODO Auto-generated constructor stub
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}
	
	
}
