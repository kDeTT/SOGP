/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bd.ufjf.sogp.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis Augusto
 */
@Entity
@Table(name = "tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipo.findAll", query = "SELECT t FROM Tipo t"),
    @NamedQuery(name = "Tipo.findByCodTipo", query = "SELECT t FROM Tipo t WHERE t.codTipo = :codTipo"),
    @NamedQuery(name = "Tipo.findByNome", query = "SELECT t FROM Tipo t WHERE t.nome = :nome"),
    @NamedQuery(name = "Tipo.findByDescricao", query = "SELECT t FROM Tipo t WHERE t.descricao = :descricao")})
public class Tipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codTipo")
    private Integer codTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    @ManyToMany(mappedBy = "tipoList")
    private List<Pertence> pertenceList;
    @OneToMany(mappedBy = "codSupTipo")
    private List<Tipo> tipoList;
    @JoinColumn(name = "codSupTipo", referencedColumnName = "codTipo")
    @ManyToOne
    private Tipo codSupTipo;

    public Tipo() {
    }

    public Tipo(Integer codTipo) {
        this.codTipo = codTipo;
    }

    public Tipo(Integer codTipo, String nome) {
        this.codTipo = codTipo;
        this.nome = nome;
    }

    public Integer getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(Integer codTipo) {
        this.codTipo = codTipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Pertence> getPertenceList() {
        return pertenceList;
    }

    public void setPertenceList(List<Pertence> pertenceList) {
        this.pertenceList = pertenceList;
    }

    @XmlTransient
    public List<Tipo> getTipoList() {
        return tipoList;
    }

    public void setTipoList(List<Tipo> tipoList) {
        this.tipoList = tipoList;
    }

    public Tipo getCodSupTipo() {
        return codSupTipo;
    }

    public void setCodSupTipo(Tipo codSupTipo) {
        this.codSupTipo = codSupTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipo != null ? codTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipo)) {
            return false;
        }
        Tipo other = (Tipo) object;
        if ((this.codTipo == null && other.codTipo != null) || (this.codTipo != null && !this.codTipo.equals(other.codTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.ufjf.sogp.model.Tipo[ codTipo=" + codTipo + " ]";
    }

}
