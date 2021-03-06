package bd.ufjf.sogp.viewmodel;

import bd.ufjf.sogp.controller.GlobalPropertySystem;
import org.springframework.security.core.context.SecurityContextHolder;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;

/**
 *
 * @author Luis Augusto
 */
public class TopBarViewModel 
{
    private String username;
    
    @AfterCompose
    public void doAfterCompose(@ContextParam(ContextType.VIEW) Component view)
    {
        Selectors.wireComponents(view, this, false);
        
        GlobalPropertySystem.USERNAME = SecurityContextHolder.getContext().getAuthentication().getName();
        this.username = GlobalPropertySystem.USERNAME.toUpperCase();
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
