package modelos;

public class Libros {

//-----Variables de la clase 
	private int isbn;
	private String titulo;
	private String autor;
	private int paginas;
	
//-----Constructor con parámetros
	public Libros(int isbn, String titulo, String autor, int paginas){
		this.isbn=isbn;
		this.titulo=titulo;
		this.autor=autor;
		this.paginas=paginas;
	}

//-----Getters and Setters
	public int getIsbn() {return isbn;}

	public void setIsbn(int isbn) {this.isbn = isbn;}

	public String getTitulo() {return titulo;}

	public void setTitulo(String titulo) {this.titulo = titulo;}

	public String getAutor() {return autor;}

	public void setAutor(String autor) {this.autor = autor;}

	public int getPaginas() {return paginas;}

	public void setPaginas(int paginas) {this.paginas = paginas;}

//-----Redefinimos el método toString
	@Override
	public String toString() {
		return"Título:" + titulo+"\n"
				+ "	ISBN: " + isbn+"\n"
				+ "	Autor: " + autor +"\n"
				+ "	Páginas: " + paginas+"\n";
		}
}
