package bd.ufjf.sogp.model.controller;

import bd.ufjf.sogp.model.Musica;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis Augusto
 */
@Controller
@Repository
public class MusicaJpaController extends AbstractJpaController<Musica>
{
    public MusicaJpaController()
    {
        super();
        super.setEntityClass(Musica.class);
    }
}