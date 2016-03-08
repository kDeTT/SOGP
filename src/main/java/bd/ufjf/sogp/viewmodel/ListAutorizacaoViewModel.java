package bd.ufjf.sogp.viewmodel;

import bd.ufjf.sogp.controller.GlobalPropertySystem;
import bd.ufjf.sogp.model.Pessoa;
import bd.ufjf.sogp.model.controller.PessoaJpaController;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;

/**
 *
 * @author Luis Augusto
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ListAutorizacaoViewModel 
{
    private List<Pessoa> autorizadosList;
    private Pessoa autorizadoSelected;
    private String autorizadosLabelCount;
    
    @WireVariable
    private PessoaJpaController pessoaJpaController;
    
    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view)
    {
        Selectors.wireComponents(view, this, false);
        
        try
        {
            String login = GlobalPropertySystem.USERNAME;
            Pessoa p = this.pessoaJpaController.findByNamedQuerySingle("Pessoa.findByLogin", "login", login);
            this.autorizadosList = p.getPessoaList();
            this.autorizadosLabelCount = String.format("Total de autorizados: %s", this.autorizadosList.size());
        }
        catch(NonUniqueResultException | NoResultException | IllegalArgumentException ex)
        {
            Messagebox.show(ex.getMessage(), "Erro", Messagebox.OK, Messagebox.ERROR);
        }
    }

    /**
     * @return the autorizadosList
     */
    public List<Pessoa> getAutorizadosList() {
        return autorizadosList;
    }

    /**
     * @param autorizadosList the autorizadosList to set
     */
    public void setAutorizadosList(List<Pessoa> autorizadosList) {
        this.autorizadosList = autorizadosList;
    }

    /**
     * @return the autorizadoSelected
     */
    public Pessoa getAutorizadoSelected() {
        return autorizadoSelected;
    }

    /**
     * @param autorizadoSelected the autorizadoSelected to set
     */
    public void setAutorizadoSelected(Pessoa autorizadoSelected) {
        this.autorizadoSelected = autorizadoSelected;
    }

    /**
     * @return the autorizadosCount
     */
    public String getAutorizadosLabelCount() {
        return autorizadosLabelCount;
    }

    /**
     * @param autorizadosCount the autorizadosCount to set
     */
    public void setAutorizadosLabelCount(String autorizadosCount) {
        this.autorizadosLabelCount = autorizadosCount;
    }
}
