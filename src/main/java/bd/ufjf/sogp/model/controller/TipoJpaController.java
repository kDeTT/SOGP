package bd.ufjf.sogp.model.controller;

import bd.ufjf.sogp.model.Tipo;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis Augusto
 */
@Controller
@Repository
public class TipoJpaController extends AbstractJpaController<Tipo>
{
    public TipoJpaController()
    {
        super();
        super.setEntityClass(Tipo.class);
    }
}