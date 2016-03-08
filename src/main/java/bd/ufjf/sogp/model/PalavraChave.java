/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bd.ufjf.sogp.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Augusto
 */
@Entity
@Table(name = "palavrachave")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PalavraChave.findAll", query = "SELECT p FROM PalavraChave p"),
    @NamedQuery(name = "PalavraChave.findByCodPertence", query = "SELECT p FROM PalavraChave p WHERE p.palavraChavePK.codPertence = :codPertence"),
    @NamedQuery(name = "PalavraChave.findByPalavra", query = "SELECT p FROM PalavraChave p WHERE p.palavraChavePK.palavra = :palavra")})
public class PalavraChave implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PalavraChavePK palavraChavePK;
    @JoinColumn(name = "codPertence", referencedColumnName = "codPertence", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pertence pertence;

    public PalavraChave() {
    }

    public PalavraChave(PalavraChavePK palavraChavePK) {
        this.palavraChavePK = palavraChavePK;
    }

    public PalavraChave(int codPertence, String palavra) {
        this.palavraChavePK = new PalavraChavePK(codPertence, palavra);
    }

    public PalavraChavePK getPalavraChavePK() {
        return palavraChavePK;
    }

    public void setPalavraChavePK(PalavraChavePK palavraChavePK) {
        this.palavraChavePK = palavraChavePK;
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
        hash += (palavraChavePK != null ? palavraChavePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PalavraChave)) {
            return false;
        }
        PalavraChave other = (PalavraChave) object;
        if ((this.palavraChavePK == null && other.palavraChavePK != null) || (this.palavraChavePK != null && !this.palavraChavePK.equals(other.palavraChavePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.ufjf.sogp.model.PalavraChave[ palavraChavePK=" + palavraChavePK + " ]";
    }

}
