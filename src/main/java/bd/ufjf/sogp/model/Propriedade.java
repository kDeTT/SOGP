/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bd.ufjf.sogp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Augusto
 */
@Entity
@Table(name = "propriedade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propriedade.findAll", query = "SELECT p FROM Propriedade p"),
    @NamedQuery(name = "Propriedade.findByCodPessoa", query = "SELECT p FROM Propriedade p WHERE p.propriedadePK.codPessoa = :codPessoa"),
    @NamedQuery(name = "Propriedade.findByCodPertence", query = "SELECT p FROM Propriedade p WHERE p.propriedadePK.codPertence = :codPertence"),
    @NamedQuery(name = "Propriedade.findByPorcentPropriedade", query = "SELECT p FROM Propriedade p WHERE p.porcentPropriedade = :porcentPropriedade")})
public class Propriedade implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PropriedadePK propriedadePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentPropriedade")
    private Float porcentPropriedade;
    @JoinColumn(name = "codPessoa", referencedColumnName = "codPessoa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pessoa pessoa;
    @JoinColumn(name = "codPertence", referencedColumnName = "codPertence", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pertence pertence;
    @JoinColumn(name = "codStatus", referencedColumnName = "codStatus")
    @OneToOne(optional = false)
    private Status codStatus;
    @JoinColumn(name = "codAquis", referencedColumnName = "codAquis")
    @OneToOne(optional = false)
    private Aquisicao codAquis;

    public Propriedade() {
    }

    public Propriedade(PropriedadePK propriedadePK) {
        this.propriedadePK = propriedadePK;
    }

    public Propriedade(int codPessoa, int codPertence) {
        this.propriedadePK = new PropriedadePK(codPessoa, codPertence);
    }

    public PropriedadePK getPropriedadePK() {
        return propriedadePK;
    }

    public void setPropriedadePK(PropriedadePK propriedadePK) {
        this.propriedadePK = propriedadePK;
    }

    public Float getPorcentPropriedade() {
        return porcentPropriedade;
    }

    public void setPorcentPropriedade(Float porcentPropriedade) {
        this.porcentPropriedade = porcentPropriedade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pertence getPertence() {
        return pertence;
    }

    public void setPertence(Pertence pertence) {
        this.pertence = pertence;
    }

    public Status getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(Status codStatus) {
        this.codStatus = codStatus;
    }

    public Aquisicao getCodAquis() {
        return codAquis;
    }

    public void setCodAquis(Aquisicao codAquis) {
        this.codAquis = codAquis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propriedadePK != null ? propriedadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propriedade)) {
            return false;
        }
        Propriedade other = (Propriedade) object;
        if ((this.propriedadePK == null && other.propriedadePK != null) || (this.propriedadePK != null && !this.propriedadePK.equals(other.propriedadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.ufjf.sogp.model.Propriedade[ propriedadePK=" + propriedadePK + " ]";
    }

}
