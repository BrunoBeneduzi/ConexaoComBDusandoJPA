package classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//mapeia a classe como uma tabela no banco de dados
@Table(name = "categoria")//coloca o nome da tabela como "categoria"
public class Categoria {
	
	@Id //define como chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomeCategoria;
	
	public Categoria(String nome) {
		this.nomeCategoria = nome;
	}
	
	public Categoria() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nomeCategoria;
	}
	public void setNome(String nome) {
		this.nomeCategoria = nome;
	}
}