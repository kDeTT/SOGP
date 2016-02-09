package bd.ufjf.sogp.viewmodel;

import bd.ufjf.sogp.model.SogpdbTest;
import bd.ufjf.sogp.model.controller.SogpdbTestJpaController;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;

/**
 *
 * @author Luis Augusto
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class IndexViewModel 
{
    @WireVariable
    private SogpdbTestJpaController sogpdbTestJpaController;
    
    @Command
    public void sayHello()
    {
        if(sogpdbTestJpaController == null)
        {
            Messagebox.show("Controller is null!");
            return;
        }
        
        SogpdbTest entity = new SogpdbTest();
        entity.setDescription("Hello");
        
        this.sogpdbTestJpaController.persist(entity);
        
        Messagebox.show("Created!");
    }
}
