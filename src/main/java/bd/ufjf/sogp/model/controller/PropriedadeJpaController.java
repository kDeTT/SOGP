package bd.ufjf.sogp.model.controller;

import bd.ufjf.sogp.model.Propriedade;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis Augusto
 */
@Controller
@Repository
public class PropriedadeJpaController extends AbstractJpaController<Propriedade>
{
    public PropriedadeJpaController()
    {
        super();
        super.setEntityClass(Propriedade.class);
    }
}