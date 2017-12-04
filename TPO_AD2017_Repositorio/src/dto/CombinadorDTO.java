package dto;

import java.io.Serializable;
import java.util.List;


public class CombinadorDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4076114728695091338L;
	private String id;
	
	public CombinadorDTO(){}
 
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public CombinadorDTO(String id) {
		super();
		this.id = id;
	}
	
	


	
	
}
