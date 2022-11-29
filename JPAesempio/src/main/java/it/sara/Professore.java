package it.sara;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professore")
public class Professore {

	@Id
	@Column(name = "id", unique = true)
	private int id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name= "cognome", nullable = false)
	private String cognome;
	
	@Column(name = "materia_insegnata", nullable = false)
	private String materia_insegnata;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMateria_insegnata() {
		return materia_insegnata;
	}

	public void setMateria_insegnata(String materia_insegnata) {
		this.materia_insegnata = materia_insegnata;
	}
	
	@Override
	public String toString() {
		return "Professore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + " , materia insegnata=" + materia_insegnata + "]";
	}
	
}
