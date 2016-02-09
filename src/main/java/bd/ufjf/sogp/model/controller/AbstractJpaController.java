package bd.ufjf.sogp.model.controller;

import bd.ufjf.sogp.model.SogpdbTest;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Luis Augusto
 */
@Component
@Repository
public abstract class AbstractJpaController 
{
    @PersistenceContext
    private EntityManager em;
 
    @Transactional
    public void persist(SogpdbTest product) 
    {
        em.persist(product);
    }
 
    public List<SogpdbTest> findAll() 
    {
        return em.createQuery("SELECT p FROM SogpdbTest p").getResultList();
    }
}
