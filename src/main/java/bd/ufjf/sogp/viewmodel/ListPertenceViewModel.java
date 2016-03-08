package bd.ufjf.sogp.viewmodel;

import bd.ufjf.sogp.controller.GlobalPropertySystem;
import bd.ufjf.sogp.model.Pertence;
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
public class ListPertenceViewModel 
{
    private List<Pertence> pertenceList;
    private Pertence pertenceSelected;
    private String pertenceLabelCount;
    
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
            this.pertenceList = p.getPertenceList();
            this.pertenceLabelCount = String.format("Total de pertences: %s", this.pertenceList.size());
        }
        catch(NonUniqueResultException | NoResultException | IllegalArgumentException ex)
        {
            Messagebox.show(ex.getMessage(), "Erro", Messagebox.OK, Messagebox.ERROR);
        }
    }

    /**
     * @return the pertenceList
     */
    public List<Pertence> getPertenceList() {
        return pertenceList;
    }

    /**
     * @param pertenceList the pertenceList to set
     */
    public void setPertenceList(List<Pertence> pertenceList) {
        this.pertenceList = pertenceList;
    }

    /**
     * @return the pertenceSelected
     */
    public Pertence getPertenceSelected() {
        return pertenceSelected;
    }

    /**
     * @param pertenceSelected the pertenceSelected to set
     */
    public void setPertenceSelected(Pertence pertenceSelected) {
        this.pertenceSelected = pertenceSelected;
    }

    /**
     * @return the pertenceLabelCount
     */
    public String getPertenceLabelCount() {
        return pertenceLabelCount;
    }

    /**
     * @param pertenceLabelCount the pertenceLabelCount to set
     */
    public void setPertenceLabelCount(String pertenceLabelCount) {
        this.pertenceLabelCount = pertenceLabelCount;
    }
}
