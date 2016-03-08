/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bd.ufjf.sogp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis Augusto
 */
@Entity
@Table(name = "pertence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pertence.findAll", query = "SELECT p FROM Pertence p"),
    @NamedQuery(name = "Pertence.findByCodPertence", query = "SELECT p FROM Pertence p WHERE p.codPertence = :codPertence"),
    @NamedQuery(name = "Pertence.findByNome", query = "SELECT p FROM Pertence p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pertence.findByDescricao", query = "SELECT p FROM Pertence p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Pertence.findByRua", query = "SELECT p FROM Pertence p WHERE p.rua = :rua"),
    @NamedQuery(name = "Pertence.findByNumero", query = "SELECT p FROM Pertence p WHERE p.numero = :numero"),
    @NamedQuery(name = "Pertence.findByCep", query = "SELECT p FROM Pertence p WHERE p.cep = :cep"),
    @NamedQuery(name = "Pertence.findByEstado", query = "SELECT p FROM Pertence p WHERE p.estado = :estado"),
    @NamedQuery(name = "Pertence.findByCidade", query = "SELECT p FROM Pertence p WHERE p.cidade = :cidade"),
    @NamedQuery(name = "Pertence.findByPais", query = "SELECT p FROM Pertence p WHERE p.pais = :pais"),
    @NamedQuery(name = "Pertence.findByQuantidade", query = "SELECT p FROM Pertence p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "Pertence.findByValorAtual", query = "SELECT p FROM Pertence p WHERE p.valorAtual = :valorAtual"),
    @NamedQuery(name = "Pertence.findByValorAntigo", query = "SELECT p FROM Pertence p WHERE p.valorAntigo = :valorAntigo"),
    @NamedQuery(name = "Pertence.findByDataAvaliacao", query = "SELECT p FROM Pertence p WHERE p.dataAvaliacao = :dataAvaliacao")})
public class Pertence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codPertence")
    private Integer codPertence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 128)
    @Column(name = "rua")
    private String rua;
    @Size(max = 15)
    @Column(name = "numero")
    private String numero;
    @Size(max = 10)
    @Column(name = "cep")
    private String cep;
    @Size(max = 50)
    @Column(name = "estado")
    private String estado;
    @Size(max = 50)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 50)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorAtual")
    private BigDecimal valorAtual;
    @Column(name = "valorAntigo")
    private BigDecimal valorAntigo;
    @Column(name = "dataAvaliacao")
    @Temporal(TemporalType.DATE)
    private Date dataAvaliacao;
    @JoinTable(name = "classificacao", joinColumns = {
        @JoinColumn(name = "codPertence", referencedColumnName = "codPertence")}, inverseJoinColumns = {
        @JoinColumn(name = "codTipo", referencedColumnName = "codTipo")})
    @ManyToMany
    private List<Tipo> tipoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pertence")
    private List<PalavraChave> palavraChaveList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pertence")
    private List<Propriedade> propriedadeList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pertence")
    private Filme filme;
    @JoinColumn(name = "codAvaliador", referencedColumnName = "codPessoa")
    @ManyToOne
    private Pessoa codAvaliador;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pertence")
    private Livro livro;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pertence")
    private Dimensao dimensao;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pertence")
    private Musica musica;

    public Pertence() {
    }

    public Pertence(Integer codPertence) {
        this.codPertence = codPertence;
    }

    public Pertence(Integer codPertence, String nome, int quantidade, BigDecimal valorAtual) {
        this.codPertence = codPertence;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorAtual = valorAtual;
    }

    public Integer getCodPertence() {
        return codPertence;
    }

    public void setCodPertence(Integer codPertence) {
        this.codPertence = codPertence;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(BigDecimal valorAtual) {
        this.valorAtual = valorAtual;
    }

    public BigDecimal getValorAntigo() {
        return valorAntigo;
    }

    public void setValorAntigo(BigDecimal valorAntigo) {
        this.valorAntigo = valorAntigo;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    @XmlTransient
    public List<Tipo> getTipoList() {
        return tipoList;
    }

    public void setTipoList(List<Tipo> tipoList) {
        this.tipoList = tipoList;
    }

    @XmlTransient
    public List<PalavraChave> getPalavraChaveList() {
        return palavraChaveList;
    }

    public void setPalavraChaveList(List<PalavraChave> palavraChaveList) {
        this.palavraChaveList = palavraChaveList;
    }

    @XmlTransient
    public List<Propriedade> getPropriedadeList() {
        return propriedadeList;
    }

    public void setPropriedadeList(List<Propriedade> propriedadeList) {
        this.propriedadeList = propriedadeList;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Pessoa getCodAvaliador() {
        return codAvaliador;
    }

    public void setCodAvaliador(Pessoa codAvaliador) {
        this.codAvaliador = codAvaliador;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Dimensao getDimensao() {
        return dimensao;
    }

    public void setDimensao(Dimensao dimensao) {
        this.dimensao = dimensao;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
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
        if (!(object instanceof Pertence)) {
            return false;
        }
        Pertence other = (Pertence) object;
        if ((this.codPertence == null && other.codPertence != null) || (this.codPertence != null && !this.codPertence.equals(other.codPertence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.ufjf.sogp.model.Pertence[ codPertence=" + codPertence + " ]";
    }

}
