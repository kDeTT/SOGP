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
@Table(name = "status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s"),
    @NamedQuery(name = "Status.findByCodStatus", query = "SELECT s FROM Status s WHERE s.codStatus = :codStatus"),
    @NamedQuery(name = "Status.findByTipoStatus", query = "SELECT s FROM Status s WHERE s.tipoStatus = :tipoStatus"),
    @NamedQuery(name = "Status.findByDataDisponivel", query = "SELECT s FROM Status s WHERE s.dataDisponivel = :dataDisponivel"),
    @NamedQuery(name = "Status.findByDataExclusao", query = "SELECT s FROM Status s WHERE s.dataExclusao = :dataExclusao"),
    @NamedQuery(name = "Status.findByMotivoExclusao", query = "SELECT s FROM Status s WHERE s.motivoExclusao = :motivoExclusao"),
    @NamedQuery(name = "Status.findByDataAluguel", query = "SELECT s FROM Status s WHERE s.dataAluguel = :dataAluguel"),
    @NamedQuery(name = "Status.findByDataAluguelFim", query = "SELECT s FROM Status s WHERE s.dataAluguelFim = :dataAluguelFim"),
    @NamedQuery(name = "Status.findByValorAluguel", query = "SELECT s FROM Status s WHERE s.valorAluguel = :valorAluguel"),
    @NamedQuery(name = "Status.findByDataEmprestimo", query = "SELECT s FROM Status s WHERE s.dataEmprestimo = :dataEmprestimo"),
    @NamedQuery(name = "Status.findByDataEmprestimoFim", query = "SELECT s FROM Status s WHERE s.dataEmprestimoFim = :dataEmprestimoFim"),
    @NamedQuery(name = "Status.findByDataVenda", query = "SELECT s FROM Status s WHERE s.dataVenda = :dataVenda"),
    @NamedQuery(name = "Status.findByValorVenda", query = "SELECT s FROM Status s WHERE s.valorVenda = :valorVenda")})
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codStatus")
    private Integer codStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "tipoStatus")
    private String tipoStatus;
    @Column(name = "dataDisponivel")
    @Temporal(TemporalType.DATE)
    private Date dataDisponivel;
    @Column(name = "dataExclusao")
    @Temporal(TemporalType.DATE)
    private Date dataExclusao;
    @Size(max = 255)
    @Column(name = "motivoExclusao")
    private String motivoExclusao;
    @Column(name = "dataAluguel")
    @Temporal(TemporalType.DATE)
    private Date dataAluguel;
    @Column(name = "dataAluguelFim")
    @Temporal(TemporalType.DATE)
    private Date dataAluguelFim;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorAluguel")
    private BigDecimal valorAluguel;
    @Column(name = "dataEmprestimo")
    @Temporal(TemporalType.DATE)
    private Date dataEmprestimo;
    @Column(name = "dataEmprestimoFim")
    @Temporal(TemporalType.DATE)
    private Date dataEmprestimoFim;
    @Column(name = "dataVenda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @Column(name = "valorVenda")
    private BigDecimal valorVenda;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "codStatus")
    private Propriedade propriedade;
    @JoinColumn(name = "codPessoa", referencedColumnName = "codPessoa")
    @ManyToOne
    private Pessoa codPessoa;

    public Status() {
    }

    public Status(Integer codStatus) {
        this.codStatus = codStatus;
    }

    public Status(Integer codStatus, String tipoStatus) {
        this.codStatus = codStatus;
        this.tipoStatus = tipoStatus;
    }

    public Integer getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(Integer codStatus) {
        this.codStatus = codStatus;
    }

    public String getTipoStatus() {
        return tipoStatus;
    }

    public void setTipoStatus(String tipoStatus) {
        this.tipoStatus = tipoStatus;
    }

    public Date getDataDisponivel() {
        return dataDisponivel;
    }

    public void setDataDisponivel(Date dataDisponivel) {
        this.dataDisponivel = dataDisponivel;
    }

    public Date getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(Date dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public String getMotivoExclusao() {
        return motivoExclusao;
    }

    public void setMotivoExclusao(String motivoExclusao) {
        this.motivoExclusao = motivoExclusao;
    }

    public Date getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(Date dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public Date getDataAluguelFim() {
        return dataAluguelFim;
    }

    public void setDataAluguelFim(Date dataAluguelFim) {
        this.dataAluguelFim = dataAluguelFim;
    }

    public BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(BigDecimal valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataEmprestimoFim() {
        return dataEmprestimoFim;
    }

    public void setDataEmprestimoFim(Date dataEmprestimoFim) {
        this.dataEmprestimoFim = dataEmprestimoFim;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }

    public Pessoa getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(Pessoa codPessoa) {
        this.codPessoa = codPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codStatus != null ? codStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.codStatus == null && other.codStatus != null) || (this.codStatus != null && !this.codStatus.equals(other.codStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.ufjf.sogp.model.Status[ codStatus=" + codStatus + " ]";
    }

}
