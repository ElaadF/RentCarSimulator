package fr.upem.manage;

import java.io.Serializable;

public class Review implements Serializable{
	private long idClient;
	private Long idVehicle;
	private short mark;
	private String comment;
	
	
	public Review(long idClient, Long idVehicle, short mark, String comment) {
		this.idClient = idClient;
		this.idVehicle = idVehicle;
		this.mark = mark;
		this.comment = comment;
	}
	
	public Review() {
	}
	
	public long getClient() {
		return idClient;
	}
	
	public Long getIdVehicle() {
		return idVehicle;
	}
	
	public short getMark() {
		return mark;
	}
	
	public String getComment() {
		return comment;
	}
	
}
