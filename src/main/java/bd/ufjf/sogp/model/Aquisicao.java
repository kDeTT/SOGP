/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bd.ufjf.sogp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Augusto
 */
@Entity
@Table(name = "aquisicao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aquisicao.findAll", query = "SELECT a FROM Aquisicao a"),
    @NamedQuery(name = "Aquisicao.findByCodAquis", query = "SELECT a FROM Aquisicao a WHERE a.codAquis = :codAquis"),
    @NamedQuery(name = "Aquisicao.findByTipoAquisicao", query = "SELECT a FROM Aquisicao a WHERE a.tipoAquisicao = :tipoAquisicao"),
    @NamedQuery(name = "Aquisicao.findByDataFabricacao", query = "SELECT a FROM Aquisicao a WHERE a.dataFabricacao = :dataFabricacao"),
    @NamedQuery(name = "Aquisicao.findByDataCompra", query = "SELECT a FROM Aquisicao a WHERE a.dataCompra = :dataCompra"),
    @NamedQuery(name = "Aquisicao.findByValorCompra", query = "SELECT a FROM Aquisicao a WHERE a.valorCompra = :valorCompra"),
    @NamedQuery(name = "Aquisicao.findByDataHeranca", query = "SELECT a FROM Aquisicao a WHERE a.dataHeranca = :dataHeranca"),
    @NamedQuery(name = "Aquisicao.findByDataDoacao", query = "SELECT a FROM Aquisicao a WHERE a.dataDoacao = :dataDoacao")})
public class Aquisicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codAquis")
    private Integer codAquis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "tipoAquisicao")
    private String tipoAquisicao;
    @Column(name = "dataFabricacao")
    @Temporal(TemporalType.DATE)
    private Date dataFabricacao;
    @Column(name = "dataCompra")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorCompra")
    private BigDecimal valorCompra;
    @Column(name = "dataHeranca")
    @Temporal(TemporalType.DATE)
    private Date dataHeranca;
    @Column(name = "dataDoacao")
    @Temporal(TemporalType.DATE)
    private Date dataDoacao;
    @JoinColumn(name = "codPessoa", referencedColumnName = "codPessoa")
    @ManyToOne
    private Pessoa codPessoa;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "codAquis")
    private Propriedade propriedade;

    public Aquisicao() {
    }

    public Aquisicao(Integer codAquis) {
        this.codAquis = codAquis;
    }

    public Aquisicao(Integer codAquis, String tipoAquisicao) {
        this.codAquis = codAquis;
        this.tipoAquisicao = tipoAquisicao;
    }

    public Integer getCodAquis() {
        return codAquis;
    }

    public void setCodAquis(Integer codAquis) {
        this.codAquis = codAquis;
    }

    public String getTipoAquisicao() {
        return tipoAquisicao;
    }

    public void setTipoAquisicao(String tipoAquisicao) {
        this.tipoAquisicao = tipoAquisicao;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Date getDataHeranca() {
        return dataHeranca;
    }

    public void setDataHeranca(Date dataHeranca) {
        this.dataHeranca = dataHeranca;
    }

    public Date getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(Date dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public Pessoa getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(Pessoa codPessoa) {
        this.codPessoa = codPessoa;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAquis != null ? codAquis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aquisicao)) {
            return false;
        }
        Aquisicao other = (Aquisicao) object;
        if ((this.codAquis == null && other.codAquis != null) || (this.codAquis != null && !this.codAquis.equals(other.codAquis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.ufjf.sogp.model.Aquisicao[ codAquis=" + codAquis + " ]";
    }

}
