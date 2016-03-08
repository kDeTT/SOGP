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
@Table(name = "musica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musica.findAll", query = "SELECT m FROM Musica m"),
    @NamedQuery(name = "Musica.findByCodPertence", query = "SELECT m FROM Musica m WHERE m.codPertence = :codPertence"),
    @NamedQuery(name = "Musica.findByTitulo", query = "SELECT m FROM Musica m WHERE m.titulo = :titulo"),
    @NamedQuery(name = "Musica.findByAlbum", query = "SELECT m FROM Musica m WHERE m.album = :album"),
    @NamedQuery(name = "Musica.findByAno", query = "SELECT m FROM Musica m WHERE m.ano = :ano"),
    @NamedQuery(name = "Musica.findByArtista", query = "SELECT m FROM Musica m WHERE m.artista = :artista"),
    @NamedQuery(name = "Musica.findByBanda", query = "SELECT m FROM Musica m WHERE m.banda = :banda"),
    @NamedQuery(name = "Musica.findByCompositor", query = "SELECT m FROM Musica m WHERE m.compositor = :compositor"),
    @NamedQuery(name = "Musica.findByGravadora", query = "SELECT m FROM Musica m WHERE m.gravadora = :gravadora"),
    @NamedQuery(name = "Musica.findByGenero", query = "SELECT m FROM Musica m WHERE m.genero = :genero"),
    @NamedQuery(name = "Musica.findByDuracao", query = "SELECT m FROM Musica m WHERE m.duracao = :duracao"),
    @NamedQuery(name = "Musica.findByQualidade", query = "SELECT m FROM Musica m WHERE m.qualidade = :qualidade"),
    @NamedQuery(name = "Musica.findByIdioma", query = "SELECT m FROM Musica m WHERE m.idioma = :idioma")})
public class Musica implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "album")
    private String album;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano")
    private String ano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "artista")
    private String artista;
    @Size(max = 128)
    @Column(name = "banda")
    private String banda;
    @Size(max = 255)
    @Column(name = "compositor")
    private String compositor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "gravadora")
    private String gravadora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "duracao")
    private String duracao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qualidade")
    private int qualidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "idioma")
    private String idioma;
    @JoinColumn(name = "codPertence", referencedColumnName = "codPertence", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pertence pertence;

    public Musica() {
    }

    public Musica(Integer codPertence) {
        this.codPertence = codPertence;
    }

    public Musica(Integer codPertence, String titulo, String album, String ano, String artista, String gravadora, String genero, String duracao, int qualidade, String idioma) {
        this.codPertence = codPertence;
        this.titulo = titulo;
        this.album = album;
        this.ano = ano;
        this.artista = artista;
        this.gravadora = gravadora;
        this.genero = genero;
        this.duracao = duracao;
        this.qualidade = qualidade;
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public String getGravadora() {
        return gravadora;
    }

    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public int getQualidade() {
        return qualidade;
    }

    public void setQualidade(int qualidade) {
        this.qualidade = qualidade;
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
        if (!(object instanceof Musica)) {
            return false;
        }
        Musica other = (Musica) object;
        if ((this.codPertence == null && other.codPertence != null) || (this.codPertence != null && !this.codPertence.equals(other.codPertence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.ufjf.sogp.model.Musica[ codPertence=" + codPertence + " ]";
    }

}
