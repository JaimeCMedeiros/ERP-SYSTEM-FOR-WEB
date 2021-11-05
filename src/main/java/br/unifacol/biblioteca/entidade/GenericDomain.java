package br.unifacol.biblioteca.entidade;

/*Jaime Costa Medeiros Junior
 * */
import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")  
@MappedSuperclass 

public abstract class GenericDomain implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	
	private Long id; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}