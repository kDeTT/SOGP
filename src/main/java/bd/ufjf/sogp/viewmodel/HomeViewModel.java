package bd.ufjf.sogp.viewmodel;

import java.util.HashMap;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;

/**
 *
 * @author Luis Augusto
 */
public class HomeViewModel
{
    @Command
    public void openCadastroPertence()
    {
        HashMap<String, String> paramList = new HashMap<>();
        paramList.put("zulFile", "cadastro-pertence.zul");

        Executions.createComponents("dialog.zul", null, paramList);
    }
}
