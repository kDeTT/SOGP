package bd.ufjf.sogp.model.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Luis Augusto
 */
@Component
@Repository
public abstract class AbstractJpaController<T extends Serializable>
{
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;
    
    private Class<T> entityClass;
    
    /**
     * @return the em
     */
    public EntityManager getEntityManager() 
    {
        return em;
    }
    
    public void setEntityClass(Class<T> entityClass)
    {
        this.entityClass = entityClass;
    }
    
    private List<Object> findEntities(boolean all, int maxResults, int firstResult)
    {
        CriteriaQuery cq = this.em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        Query q = this.em.createQuery(cq);

        if (!all)
        {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }

        return q.getResultList();
    }

    @Transactional
    public void create(Object entity) throws EntityExistsException, IllegalArgumentException, TransactionRequiredException
    {
        this.em.persist(entity);
        this.em.flush();
    }

    @Transactional
    public void edit(Object entity) throws IllegalArgumentException, TransactionRequiredException
    {
        this.em.merge(entity);
        this.em.flush();
    }

    @Transactional
    public void destroy(Object id) throws IllegalArgumentException, TransactionRequiredException, EntityNotFoundException
    {
        T entity = this.em.getReference(entityClass, id);
        this.em.remove(entity);
        this.em.flush();
    }

    public int getEntityCount() 
    {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<T> rt = cq.from(entityClass);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        
        return ((Long) q.getSingleResult()).intValue();
    }

    public Object findEntity(Object id)
    {
        return this.em.find(entityClass, id);
    }

    public List findAllEntities() 
    {
        return this.findEntities(true, -1, -1);
    }

    public List findRangeEntities(int maxResults, int firstResult) 
    {
        return this.findEntities(false, maxResults, firstResult);
    }

    public <T> T findByNamedQuerySingle(String namedQuery, String parameterName, Object parameter) 
            throws NonUniqueResultException, NoResultException, IllegalArgumentException
    {
        TypedQuery<T> q = this.em.createNamedQuery(namedQuery, (Class<T>) entityClass);
        q.setParameter(parameterName, parameter);

        return q.getSingleResult();
    }

    public <T> T findByNamedQuerySingle(String namedQuery, HashMap<String, Object> paramList) 
            throws NonUniqueResultException, NoResultException, IllegalArgumentException
    {
        TypedQuery<T> q = this.em.createNamedQuery(namedQuery, (Class<T>) entityClass);

        Set<String> keyList = paramList.keySet();

        for (String paramName : keyList) 
        {
            q.setParameter(paramName, paramList.get(paramName));
        }

        return q.getSingleResult();
    }

    public <T> List<T> findByNamedQueryList(String namedQuery)
    {
        TypedQuery<T> q = this.em.createNamedQuery(namedQuery, (Class<T>)entityClass);
        return q.getResultList();
    }

    public <T> List<T> findByNamedQueryList(String namedQuery, String parameterName, Object parameter)
    {
        TypedQuery<T> q = this.em.createNamedQuery(namedQuery, (Class<T>)entityClass);
        q.setParameter(parameterName, parameter);

        return q.getResultList();
    }

    public <T> List<T> findByNamedQueryList(String namedQuery, HashMap<String, Object> paramList)
    {
        TypedQuery<T> q = this.em.createNamedQuery(namedQuery, (Class<T>)entityClass);
        
        Set<String> keyList = paramList.keySet();
                    
        for (String paramName : keyList) 
        {
            q.setParameter(paramName, paramList.get(paramName));
        }

        return q.getResultList();
    }

    @Transactional
    public Object executeNativeQuery(String nativeQuery) 
    {
        Query q = this.em.createNativeQuery(nativeQuery);
        return q.getSingleResult();
    }

    @Transactional
    public Object executeNativeQuery(String nativeQuery, Object parameter)
    {
        Query q = this.em.createNativeQuery(nativeQuery);
        q.setParameter(1, parameter);
        return q.getSingleResult();
    }
    
    
}
