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
@Table(name = "dimensao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dimensao.findAll", query = "SELECT d FROM Dimensao d"),
    @NamedQuery(name = "Dimensao.findByCodPertence", query = "SELECT d FROM Dimensao d WHERE d.codPertence = :codPertence"),
    @NamedQuery(name = "Dimensao.findByAltura", query = "SELECT d FROM Dimensao d WHERE d.altura = :altura"),
    @NamedQuery(name = "Dimensao.findByLargura", query = "SELECT d FROM Dimensao d WHERE d.largura = :largura"),
    @NamedQuery(name = "Dimensao.findByComprimento", query = "SELECT d FROM Dimensao d WHERE d.comprimento = :comprimento"),
    @NamedQuery(name = "Dimensao.findByUnidade", query = "SELECT d FROM Dimensao d WHERE d.unidade = :unidade"),
    @NamedQuery(name = "Dimensao.findByPeso", query = "SELECT d FROM Dimensao d WHERE d.peso = :peso")})
public class Dimensao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codPertence")
    private Integer codPertence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "altura")
    private float altura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "largura")
    private float largura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comprimento")
    private float comprimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "unidade")
    private String unidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Float peso;
    @JoinColumn(name = "codPertence", referencedColumnName = "codPertence", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pertence pertence;

    public Dimensao() {
    }

    public Dimensao(Integer codPertence) {
        this.codPertence = codPertence;
    }

    public Dimensao(Integer codPertence, float altura, float largura, float comprimento, String unidade) {
        this.codPertence = codPertence;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.unidade = unidade;
    }

    public Integer getCodPertence() {
        return codPertence;
    }

    public void setCodPertence(Integer codPertence) {
        this.codPertence = codPertence;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
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
        if (!(object instanceof Dimensao)) {
            return false;
        }
        Dimensao other = (Dimensao) object;
        if ((this.codPertence == null && other.codPertence != null) || (this.codPertence != null && !this.codPertence.equals(other.codPertence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.ufjf.sogp.model.Dimensao[ codPertence=" + codPertence + " ]";
    }

}
