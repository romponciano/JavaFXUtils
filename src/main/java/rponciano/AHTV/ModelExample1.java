package rponciano.AHTV;

import java.io.Serializable;

/**
 * Obs.: só é preciso ter os métodos GET
 */
public class ModelExample1 implements Serializable {
	
	private static final long serialVersionUID = -7730075641033556437L;
	
	private Long id;
	private String name; 
	
	public ModelExample1(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}	
}
