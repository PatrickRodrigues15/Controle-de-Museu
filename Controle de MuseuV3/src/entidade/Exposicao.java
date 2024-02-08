package entidade;

import java.util.Date;

public class Exposicao {

	private long id;
	private String Nome;
	private String artista;
	private double Preco;
	private double Custo;
	private int Sala;
	private String imagem;
	private String itinerante;
	private Date Inicio;
	private Date fim;
	

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public double getPreco() {
		return Preco;
	}

	public void setPreco(double preco) {
		Preco = preco;
	}

	public double getCusto() {
		return Custo;
	}

	public void setCusto(double custo) {
		Custo = custo;
	}

	public int getSala() {
		return Sala;
	}

	public void setSala(int sala) {
		Sala = sala;
	}

	public Date getInicio() {
		return Inicio;
	}

	public void setInicio(Date inicio) {
		Inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getItinerante() {
		return itinerante;
	}

	public void setItinerante(String itinerante) {
		this.itinerante = itinerante;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}
}
