package bd.ufjf.sogp.model.controller;

import bd.ufjf.sogp.model.PessoaJuridica;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis Augusto
 */
@Controller
@Repository
public class PessoaJuridicaJpaController extends AbstractJpaController<PessoaJuridica>
{
    public PessoaJuridicaJpaController()
    {
        super();
        super.setEntityClass(PessoaJuridica.class);
    }
}