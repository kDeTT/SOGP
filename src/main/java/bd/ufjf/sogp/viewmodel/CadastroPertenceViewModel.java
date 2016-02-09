package bd.ufjf.sogp.viewmodel;

import bd.ufjf.sogp.interfaces.IDialog;
import java.util.HashMap;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;

/**
 *
 * @author Luis Augusto
 */
public class CadastroPertenceViewModel extends DialogViewModel implements IDialog
{
    @Command
    public void openNew()
    {
        HashMap<String, String> paramList = new HashMap<>();
        paramList.put("zulFile", "cadastro-pertence.zul");

        Executions.createComponents("dialog.zul", null, paramList);
    }
    
    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
