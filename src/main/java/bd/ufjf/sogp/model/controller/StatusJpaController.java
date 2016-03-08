package bd.ufjf.sogp.model.controller;

import bd.ufjf.sogp.model.Status;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis Augusto
 */
@Controller
@Repository
public class StatusJpaController extends AbstractJpaController<Status>
{
    public StatusJpaController()
    {
        super();
        super.setEntityClass(Status.class);
    }
}