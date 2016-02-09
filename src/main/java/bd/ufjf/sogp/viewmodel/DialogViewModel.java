package bd.ufjf.sogp.viewmodel;

import java.util.HashMap;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author Luis Augusto
 */
public class DialogViewModel
{
    private String titleWindow;
    private static Window wnd;

    @Wire
    private Window windowMenu;
    
    @Wire
    private Div divContent;

    @AfterCompose
    public void doAfterCompose(@ContextParam(ContextType.VIEW) Component view, @ExecutionArgParam("zulFile") String zulFile, @ExecutionArgParam("objParam") Object objParam)
    {
        Selectors.wireComponents(view, this, false);
        
        try
        {
            wnd = windowMenu;
            
            HashMap<String, Object> paramList = new HashMap<>();
            
            paramList.put("windowMenu", windowMenu);
            paramList.put("objParam", objParam);
            
            divContent.getChildren().clear();
            divContent.getChildren().add(Executions.createComponents(zulFile, null, paramList));
        }
        catch(Exception ex)
        {
            Messagebox.show(ex.getMessage(), "Erro", Messagebox.OK, Messagebox.ERROR);
        }
    }

    @Command
    public void close()
    {
        wnd.detach();
    }

    /**
     * @return the titleWindow
     */
    public String getTitleWindow() {
        return titleWindow;
    }

    /**
     * @param titleWindow the titleWindow to set
     */
    public void setTitleWindow(String titleWindow) {
        this.titleWindow = titleWindow;
    }
}
