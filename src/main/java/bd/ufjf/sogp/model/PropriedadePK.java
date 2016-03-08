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

/**
 *
 * @author Luis Augusto
 */
@Embeddable
public class PropriedadePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "codPessoa")
    private int codPessoa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codPertence")
    private int codPertence;

    public PropriedadePK() {
    }

    public PropriedadePK(int codPessoa, int codPertence) {
        this.codPessoa = codPessoa;
        this.codPertence = codPertence;
    }

    public int getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(int codPessoa) {
        this.codPessoa = codPessoa;
    }

    public int getCodPertence() {
        return codPertence;
    }

    public void setCodPertence(int codPertence) {
        this.codPertence = codPertence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codPessoa;
        hash += (int) codPertence;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PropriedadePK)) {
            return false;
        }
        PropriedadePK other = (PropriedadePK) object;
        if (this.codPessoa != other.codPessoa) {
            return false;
        }
        if (this.codPertence != other.codPertence) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.ufjf.sogp.model.PropriedadePK[ codPessoa=" + codPessoa + ", codPertence=" + codPertence + " ]";
    }

}
