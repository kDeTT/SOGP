package bd.ufjf.sogp.model.controller;

import bd.ufjf.sogp.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis Augusto
 */
@Controller
@Repository
public class LivroJpaController extends AbstractJpaController<Livro>
{
    public LivroJpaController()
    {
        super();
        super.setEntityClass(Livro.class);
    }
}
