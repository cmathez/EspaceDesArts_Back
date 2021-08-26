package com.inti.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="EVAL")
public class Evaluation extends Message {
	private int note;

	//association avec espace exposition
	@ManyToOne
	@JoinColumn(name = "idEspaceExposition", referencedColumnName = "idEspaceExposition")
	private EspaceExposition espaceExposition;
	
	
	public Evaluation() {
		super();
	}

	public Evaluation(Long idMessage, String commentaire, Date date, int note) {
		super(idMessage, commentaire, date);
		this.note = note;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public EspaceExposition getEspaceExposition() {
		return espaceExposition;
	}

	public void setEspaceExposition(EspaceExposition espaceExposition) {
		this.espaceExposition = espaceExposition;
	}
	
	
}
