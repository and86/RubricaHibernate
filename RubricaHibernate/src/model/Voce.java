package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Voce {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_voce;
	
	private String nome;
	private String cognome;
	private String telefono;
	
	@ManyToOne
	private Rubrica rubrica;
	
	public Voce() {

		this.nome = "";
		this.cognome = "";
		this.telefono="";
	}
			
	public Voce(String nome, String cognome, String telefono) {

		this.nome = nome;
		this.cognome = cognome;
		this.telefono=telefono;
	}

	public long getId_voce() {
		return id_voce;
	}

	public void setId_voce(long id_voce) {
		this.id_voce = id_voce;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	
	
	public Rubrica getRubrica() {
		return rubrica;
	}
	
	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}	
	

}
