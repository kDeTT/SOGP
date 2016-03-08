package bd.ufjf.sogp.model.controller;

import bd.ufjf.sogp.model.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis Augusto
 */
@Controller
@Repository
public class FilmeJpaController extends AbstractJpaController<Filme>
{
    public FilmeJpaController()
    {
        super();
        super.setEntityClass(Filme.class);
    }
}
