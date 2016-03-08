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
@Table(name = "filme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filme.findAll", query = "SELECT f FROM Filme f"),
    @NamedQuery(name = "Filme.findByCodPertence", query = "SELECT f FROM Filme f WHERE f.codPertence = :codPertence"),
    @NamedQuery(name = "Filme.findByTitulo", query = "SELECT f FROM Filme f WHERE f.titulo = :titulo"),
    @NamedQuery(name = "Filme.findByElenco", query = "SELECT f FROM Filme f WHERE f.elenco = :elenco"),
    @NamedQuery(name = "Filme.findByDiretor", query = "SELECT f FROM Filme f WHERE f.diretor = :diretor"),
    @NamedQuery(name = "Filme.findByProdutor", query = "SELECT f FROM Filme f WHERE f.produtor = :produtor"),
    @NamedQuery(name = "Filme.findByDistribuidor", query = "SELECT f FROM Filme f WHERE f.distribuidor = :distribuidor"),
    @NamedQuery(name = "Filme.findByGenero", query = "SELECT f FROM Filme f WHERE f.genero = :genero"),
    @NamedQuery(name = "Filme.findByDuracao", query = "SELECT f FROM Filme f WHERE f.duracao = :duracao"),
    @NamedQuery(name = "Filme.findByIdioma", query = "SELECT f FROM Filme f WHERE f.idioma = :idioma")})
public class Filme implements Serializable {
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
    @Column(name = "elenco")
    private String elenco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "diretor")
    private String diretor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "produtor")
    private String produtor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "distribuidor")
    private String distribuidor;
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
    @Lob
    @Size(max = 65535)
    @Column(name = "sinopse")
    private String sinopse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "idioma")
    private String idioma;
    @JoinColumn(name = "codPertence", referencedColumnName = "codPertence", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pertence pertence;

    public Filme() {
    }

    public Filme(Integer codPertence) {
        this.codPertence = codPertence;
    }

    public Filme(Integer codPertence, String titulo, String elenco, String diretor, String produtor, String distribuidor, String genero, String duracao, String idioma) {
        this.codPertence = codPertence;
        this.titulo = titulo;
        this.elenco = elenco;
        this.diretor = diretor;
        this.produtor = produtor;
        this.distribuidor = distribuidor;
        this.genero = genero;
        this.duracao = duracao;
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

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
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

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
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
        if (!(object instanceof Filme)) {
            return false;
        }
        Filme other = (Filme) object;
        if ((this.codPertence == null && other.codPertence != null) || (this.codPertence != null && !this.codPertence.equals(other.codPertence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.ufjf.sogp.model.Filme[ codPertence=" + codPertence + " ]";
    }

}
