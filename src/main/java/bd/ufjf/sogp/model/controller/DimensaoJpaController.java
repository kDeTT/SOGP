package bd.ufjf.sogp.model.controller;

import bd.ufjf.sogp.model.Dimensao;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis Augusto
 */
@Controller
@Repository
public class DimensaoJpaController extends AbstractJpaController<Dimensao>
{
    public DimensaoJpaController()
    {
        super();
        super.setEntityClass(Dimensao.class);
    }
}
