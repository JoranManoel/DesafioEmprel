package br.com.desafio.entidade;

@Entity
@Table(name = "pessoas")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private int posicaoFila;
    
    
    // construtores, getters e setters
    
	public Pessoa(Long id, String nome, int idade, int posicaoFila) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.posicaoFila = posicaoFila;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getPosicaoFila() {
		return posicaoFila;
	}
	public void setPosicaoFila(int posicaoFila) {
		this.posicaoFila = posicaoFila;
	}
    
}

