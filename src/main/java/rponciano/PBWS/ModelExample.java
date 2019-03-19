package rponciano.PBWS;

import java.io.Serializable;

public class ModelExample implements Serializable {

	private static final long serialVersionUID = -7723900292789828710L;
	
	private Long id;
	private String name; 
	
	public ModelExample(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
