/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bd.ufjf.sogp.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Augusto
 */
@Entity
@Table(name = "livro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l"),
    @NamedQuery(name = "Livro.findByCodPertence", query = "SELECT l FROM Livro l WHERE l.codPertence = :codPertence"),
    @NamedQuery(name = "Livro.findByTitulo", query = "SELECT l FROM Livro l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Livro.findBySubtitulo", query = "SELECT l FROM Livro l WHERE l.subtitulo = :subtitulo"),
    @NamedQuery(name = "Livro.findByGenero", query = "SELECT l FROM Livro l WHERE l.genero = :genero"),
    @NamedQuery(name = "Livro.findByAutor", query = "SELECT l FROM Livro l WHERE l.autor = :autor"),
    @NamedQuery(name = "Livro.findByCoautor", query = "SELECT l FROM Livro l WHERE l.coautor = :coautor"),
    @NamedQuery(name = "Livro.findByEditora", query = "SELECT l FROM Livro l WHERE l.editora = :editora"),
    @NamedQuery(name = "Livro.findByNumPaginas", query = "SELECT l FROM Livro l WHERE l.numPaginas = :numPaginas"),
    @NamedQuery(name = "Livro.findByIsbn", query = "SELECT l FROM Livro l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Livro.findByIdioma", query = "SELECT l FROM Livro l WHERE l.idioma = :idioma")})
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codPertence")
    private Integer codPertence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 255)
    @Column(name = "subtitulo")
    private String subtitulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "autor")
    private String autor;
    @Size(max = 255)
    @Column(name = "coautor")
    private String coautor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "editora")
    private String editora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numPaginas")
    private int numPaginas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "isbn")
    private String isbn;
    @Lob
    @Size(max = 65535)
    @Column(name = "resenha")
    private String resenha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "idioma")
    private String idioma;
    @JoinColumn(name = "codPertence", referencedColumnName = "codPertence", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pertence pertence;

    public Livro() {
    }

    public Livro(Integer codPertence) {
        this.codPertence = codPertence;
    }

    public Livro(Integer codPertence, String titulo, String genero, String autor, String editora, int numPaginas, String isbn, String idioma) {
        this.codPertence = codPertence;
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.editora = editora;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.idioma = idioma;
    }

    public Integer getCodPertence() {
        return codPertence;
    }

    public void setCodPertence(Integer codPertence) {
        this.codPertence = codPertence;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCoautor() {
        return coautor;
    }

    public void setCoautor(String coautor) {
        this.coautor = coautor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String resenha) {
        this.resenha = resenha;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Pertence getPertence() {
        return pertence;
    }

    public void setPertence(Pertence pertence) {
        this.pertence = pertence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPertence != null ? codPertence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.codPertence == null && other.codPertence != null) || (this.codPertence != null && !this.codPertence.equals(other.codPertence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.ufjf.sogp.model.Livro[ codPertence=" + codPertence + " ]";
    }

}
