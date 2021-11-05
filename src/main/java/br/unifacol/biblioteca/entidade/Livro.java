package br.unifacol.biblioteca.entidade;

/*Jaime Costa Medeiros Junior
 * */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "livro")
public class Livro{
	
	
	@Id
	 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	 
	private Long id; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(length = 45, nullable = false)
	private  String genero;
	@Column(length = 45, nullable = false)
	private String titulo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="autor_id")
	private Autor autor;
	@Column(length = 45, nullable = false,unique = true)
	private String identificador;
	
	public Livro(Autor autor, String genero, String titulo, String identificador) {
		super();
		this.genero = genero;
		this.titulo = titulo;
		this.identificador = identificador;
		this.autor = autor;
	}
	public Livro(String genero, String titulo, String identificador) {
		super();
		this.genero = genero;
		this.titulo = titulo;
		this.identificador = identificador;
	}
	
	public Livro(Long id, int idAutor,String genero, String titulo, String identificador) {
		super();
		this.genero = genero;
		this.titulo = titulo;
		this.identificador = identificador;
		this.autor = autor;
		this.setId(id);
	}
	public Livro() {
		
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}