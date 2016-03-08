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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Augusto
 */
@Entity
@Table(name = "sociedade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sociedade.findAll", query = "SELECT s FROM Sociedade s"),
    @NamedQuery(name = "Sociedade.findByCodPessoa", query = "SELECT s FROM Sociedade s WHERE s.codPessoa = :codPessoa"),
    @NamedQuery(name = "Sociedade.findByNomeProprietario", query = "SELECT s FROM Sociedade s WHERE s.nomeProprietario = :nomeProprietario"),
    @NamedQuery(name = "Sociedade.findByCodPertence", query = "SELECT s FROM Sociedade s WHERE s.codPertence = :codPertence"),
    @NamedQuery(name = "Sociedade.findByNomePertence", query = "SELECT s FROM Sociedade s WHERE s.nomePertence = :nomePertence"),
    @NamedQuery(name = "Sociedade.findByPorcentPropriedade", query = "SELECT s FROM Sociedade s WHERE s.porcentPropriedade = :porcentPropriedade"),
    @NamedQuery(name = "Sociedade.findByCodStatus", query = "SELECT s FROM Sociedade s WHERE s.codStatus = :codStatus"),
    @NamedQuery(name = "Sociedade.findByTipoStatus", query = "SELECT s FROM Sociedade s WHERE s.tipoStatus = :tipoStatus"),
    @NamedQuery(name = "Sociedade.findByCodAquis", query = "SELECT s FROM Sociedade s WHERE s.codAquis = :codAquis"),
    @NamedQuery(name = "Sociedade.findByTipoAquisicao", query = "SELECT s FROM Sociedade s WHERE s.tipoAquisicao = :tipoAquisicao")})
public class Sociedade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codPessoa")
    private int codPessoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nomeProprietario")
    private String nomeProprietario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codPertence")
    private int codPertence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nomePertence")
    private String nomePertence;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentPropriedade")
    private Float porcentPropriedade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codStatus")
    private int codStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "tipoStatus")
    private String tipoStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codAquis")
    private int codAquis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "tipoAquisicao")
    private String tipoAquisicao;

    public Sociedade() {
    }

    public int getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(int codPessoa) {
        this.codPessoa = codPessoa;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public int getCodPertence() {
        return codPertence;
    }

    public void setCodPertence(int codPertence) {
        this.codPertence = codPertence;
    }

    public String getNomePertence() {
        return nomePertence;
    }

    public void setNomePertence(String nomePertence) {
        this.nomePertence = nomePertence;
    }

    public Float getPorcentPropriedade() {
        return porcentPropriedade;
    }

    public void setPorcentPropriedade(Float porcentPropriedade) {
        this.porcentPropriedade = porcentPropriedade;
    }

    public int getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(int codStatus) {
        this.codStatus = codStatus;
    }

    public String getTipoStatus() {
        return tipoStatus;
    }

    public void setTipoStatus(String tipoStatus) {
        this.tipoStatus = tipoStatus;
    }

    public int getCodAquis() {
        return codAquis;
    }

    public void setCodAquis(int codAquis) {
        this.codAquis = codAquis;
    }

    public String getTipoAquisicao() {
        return tipoAquisicao;
    }

    public void setTipoAquisicao(String tipoAquisicao) {
        this.tipoAquisicao = tipoAquisicao;
    }

}
