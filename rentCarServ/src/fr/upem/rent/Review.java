package fr.upem.rent;

public class Review {
	private final IClient client;
	private final Long idVehicle;
	private final short mark;
	private final String comment;
	
	
	public Review(IClient client, Long idVehicle, short mark, String comment) {
		this.client = client;
		this.idVehicle = idVehicle;
		this.mark = mark;
		this.comment = comment;
	}
	
	public IClient getClient() {
		return client;
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
