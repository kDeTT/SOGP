package bd.ufjf.sogp.model.controller;

import bd.ufjf.sogp.model.Pertence;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis Augusto
 */
@Controller
@Repository
public class PertenceJpaController extends AbstractJpaController<Pertence>
{
    public PertenceJpaController()
    {
        super();
        super.setEntityClass(Pertence.class);
    }
}