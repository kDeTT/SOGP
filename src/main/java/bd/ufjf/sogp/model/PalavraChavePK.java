/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bd.ufjf.sogp.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Luis Augusto
 */
@Embeddable
public class PalavraChavePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "codPertence")
    private int codPertence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 48)
    @Column(name = "palavra")
    private String palavra;

    public PalavraChavePK() {
    }

    public PalavraChavePK(int codPertence, String palavra) {
        this.codPertence = codPertence;
        this.palavra = palavra;
    }

    public int getCodPertence() {
        return codPertence;
    }

    public void setCodPertence(int codPertence) {
        this.codPertence = codPertence;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codPertence;
        hash += (palavra != null ? palavra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PalavraChavePK)) {
            return false;
        }
        PalavraChavePK other = (PalavraChavePK) object;
        if (this.codPertence != other.codPertence) {
            return false;
        }
        if ((this.palavra == null && other.palavra != null) || (this.palavra != null && !this.palavra.equals(other.palavra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.ufjf.sogp.model.PalavraChavePK[ codPertence=" + codPertence + ", palavra=" + palavra + " ]";
    }

}
