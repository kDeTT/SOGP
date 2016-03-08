package bd.ufjf.sogp.viewmodel;

import bd.ufjf.sogp.model.controller.PessoaJpaController;
import java.util.Map;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Div;
import org.zkoss.zul.Messagebox;

/**
 *
 * @author Luis Augusto
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class HomeViewModel
{
    @Wire
    private Div divContent;
    
    @WireVariable
    private PessoaJpaController pessoaJpaController;
    
    @Command
    public void sayHello()
    {
        if(pessoaJpaController == null)
        {
            Messagebox.show("Controller is null!");
            return;
        }
        
        Messagebox.show("Count: " + pessoaJpaController.getEntityCount());
    }
    
    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);
    }
    
    @Command
    @GlobalCommand
    public void openContent(@BindingParam("zulFile") String zulFile, @BindingParam("paramList") Map<String, Object> paramList)
    {
        divContent.getChildren().clear();
        divContent.getChildren().add(Executions.createComponents(zulFile, null, paramList));
        Clients.evalJavaScript("showHideMenuByResolution()");
    }
}
