package bd.ufjf.sogp.model.controller;

import bd.ufjf.sogp.model.PalavraChave;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis Augusto
 */
@Controller
@Repository
public class PalavraChaveJpaController extends AbstractJpaController<PalavraChave>
{
    public PalavraChaveJpaController()
    {
        super();
        super.setEntityClass(PalavraChave.class);
    }
}
