package bd.ufjf.sogp.model.controller;

import bd.ufjf.sogp.model.Aquisicao;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis Augusto
 */
@Controller
@Repository
public class AquisicaoJpaController extends AbstractJpaController<Aquisicao>
{
    public AquisicaoJpaController()
    {
        super();
        super.setEntityClass(Aquisicao.class);
    }
}
