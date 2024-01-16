package classes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity//mapeia a classe como uma tabela no banco de dados
@Table(name = "produto")//coloca o nome da tabela como "produto"
public class Produto {
	
	@Id //define como chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private int preco;
	private String descricao;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Categoria categoria;
	
	public Produto(String nome, int preco, String descricao, Categoria categoria) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.categoria = categoria;
	}
	
	public Produto() {
		
	}
	
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

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}