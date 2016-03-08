package bd.ufjf.sogp.model.controller;

import bd.ufjf.sogp.model.PessoaFisica;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis Augusto
 */
@Controller
@Repository
public class PessoaFisicaJpaController extends AbstractJpaController<PessoaFisica>
{
    public PessoaFisicaJpaController()
    {
        super();
        super.setEntityClass(PessoaFisica.class);
    }
}
