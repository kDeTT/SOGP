package bd.ufjf.sogp.model.controller;

import bd.ufjf.sogp.model.Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis Augusto
 */
@Controller
@Repository
public class PessoaJpaController extends AbstractJpaController<Pessoa>
{
    public PessoaJpaController()
    {
        super();
        super.setEntityClass(Pessoa.class);
    }
}
