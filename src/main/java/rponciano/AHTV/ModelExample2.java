package rponciano.AHTV;

import java.io.Serializable;
import java.util.Date;

public class ModelExample2 implements Serializable {
	
	private static final long serialVersionUID = -7730075641033556437L;
	
	private Long id;
	private String name; 
	private String description;
	private Date date;
	
	public ModelExample2() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/**
	 * Obs.: Repare que o nome da coluna <b> não será o nome do atributo, mas sim será igual ao nome do método menos a palavra "get".
	 */
	public String getDesc() {
		return description;
	}

	public Date getDate() {
		return date;
	}
}
