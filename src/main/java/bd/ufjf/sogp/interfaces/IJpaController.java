package bd.ufjf.sogp.interfaces;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Luis Augusto
 */
public interface IJpaController 
{
    public void create(Object entity);
    public void edit(Object entity);
    public void destroy(Object id);
    public Object findEntity(Object id);
    public List findAllEntities();
    public List findRangeEntities(int maxResults, int firstResult);
    public int getEntityCount();
    public <T> T findByNamedQuerySingle(String namedQuery, String parameterName, Object parameter);
    public <T> T findByNamedQuerySingle(String namedQuery, HashMap<String, Object> paramList);
    public <T> List<T> findByNamedQueryList(String namedQuery);
    public <T> List<T> findByNamedQueryList(String namedQuery, String parameterName, Object parameter);
    public <T> List<T> findByNamedQueryList(String namedQuery, HashMap<String, Object> paramList);
    public Object executeNativeQuery(String nativeQuery);
    public Object executeNativeQuery(String nativeQuery, Object parameter);
}
