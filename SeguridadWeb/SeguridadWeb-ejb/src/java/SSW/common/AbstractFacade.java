/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SSW.common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author jsalazar
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    @SuppressWarnings("unchecked")
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        //A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS
        getEntityManager().clear();
        getEntityManager().flush();
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        //FIN ---> A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<T> findRange(int[] range) {
        //A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS
        getEntityManager().clear();
        getEntityManager().flush();
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        //FIN ---> A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
    public int count() {
        //A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS
        getEntityManager().clear();
        getEntityManager().flush();
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        //FIN ---> A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public int contador(String sql, Map<String, Object> parametros) {

        //A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS
        getEntityManager().clear();
        getEntityManager().flush();
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        //FIN ---> A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS

        Query q = getEntityManager().createNamedQuery(sql);
        if (parametros != null) {
            Iterator i = parametros.entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry valores = (Map.Entry) i.next();
                q.setParameter(valores.getKey().toString(), valores.getValue());
            }
        }
        return ((Long) q.getSingleResult()).intValue();

    }

    @SuppressWarnings("unchecked")
    public T oneResult(String sql, Map<String, Object> parametros) {
        T t = null;

        //A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS
        getEntityManager().clear();
        getEntityManager().flush();
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        //FIN ---> A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS

        Query q = getEntityManager().createNamedQuery(sql);
        try {
            if (parametros != null) {
                Iterator i = parametros.entrySet().iterator();
                while (i.hasNext()) {
                    Map.Entry valores = (Map.Entry) i.next();
                    q.setParameter(valores.getKey().toString(), valores.getValue());
                }
            }
            t = ((T) q.getSingleResult());
        } catch (javax.persistence.NoResultException e) {
            System.out.println("persistencia error " + e);
            return null;
        }
        return t;
    }

    @SuppressWarnings("unchecked")
    public List<T> manyResult(String sql, Map<String, Object> parametros) {
        //A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS
        getEntityManager().clear();
        getEntityManager().flush();
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        //FIN ---> A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS

        Query q = getEntityManager().createNamedQuery(sql);
        if (parametros != null) {
            Iterator i = parametros.entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry valores = (Map.Entry) i.next();
                q.setParameter(valores.getKey().toString(), valores.getValue());
            }
        }
        return ((List<T>) q.getResultList());
    }

    @SuppressWarnings("unchecked")
    public int maxResult(String sql) {
        //A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS
        getEntityManager().clear();
        getEntityManager().flush();
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        //FIN ---> A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS        

        int max = 0;
        try {
            Query q = getEntityManager().createNamedQuery(sql);
            max = (Integer) q.getSingleResult();
        } catch (Exception e) {
            max = 0;
        } finally {
            return max;
        }
    }

    @SuppressWarnings("unchecked")
    public int maxResult(String sql, Map<String, Object> parametros) {
        //A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS
        getEntityManager().clear();
        getEntityManager().flush();
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        //FIN ---> A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS

        int max = 0;
        try {
            Query q = getEntityManager().createNamedQuery(sql);
            if (parametros != null) {
                Iterator i = parametros.entrySet().iterator();
                while (i.hasNext()) {
                    Map.Entry valores = (Map.Entry) i.next();
                    q.setParameter(valores.getKey().toString(), valores.getValue());
                }
            }
            max = (Integer) q.getSingleResult();
        } catch (Exception e) {
            max = 0;
        } finally {
            return max;
        }
    }

    @SuppressWarnings("unchecked")
    public String stringResult(String sql, Map<String, Object> parametros) {
        //A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS
        getEntityManager().clear();
        getEntityManager().flush();
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        //FIN ---> A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS

        Query q = getEntityManager().createNamedQuery(sql);
        try {
            if (parametros != null) {
                Iterator i = parametros.entrySet().iterator();
                while (i.hasNext()) {
                    Map.Entry valores = (Map.Entry) i.next();
                    q.setParameter(valores.getKey().toString(), valores.getValue());
                }
            }
        } catch (NoResultException e) {
            return "";
        }
        return ((String) q.getSingleResult());
    }

    @SuppressWarnings("unchecked")
    public List<String> listStringResult(String sql, Map<String, Object> parametros) {
        //A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS
        getEntityManager().clear();
        getEntityManager().flush();
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        //FIN ---> A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS

        Query q = getEntityManager().createNamedQuery(sql);
        try {
            if (parametros != null) {
                Iterator i = parametros.entrySet().iterator();
                while (i.hasNext()) {
                    Map.Entry valores = (Map.Entry) i.next();
                    q.setParameter(valores.getKey().toString(), valores.getValue());
                }
            }
        } catch (NoResultException e) {
            return null;
        }
        return ((List<String>) q.getResultList());
    }

    @SuppressWarnings("unchecked")
    public List storeProcedure(String sql, Map<String, Object> parametros) {
        //A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS
        getEntityManager().clear();
        getEntityManager().flush();
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        //FIN ---> A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS

        Query q = getEntityManager().createNamedQuery(sql);
        if (parametros != null) {
            Iterator i = parametros.entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry valores = (Map.Entry) i.next();
                q.setParameter(valores.getKey().toString(), valores.getValue());
            }
        }
        return ((List) q.getResultList());
    }
    
    @SuppressWarnings("unchecked")
    public int storeProcedureVoid(String sql, Map<String, Object> parametros) {
        //A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS
        getEntityManager().clear();
        getEntityManager().flush();
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        //FIN ---> A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS

        Query q = getEntityManager().createNamedQuery(sql);
        if (parametros != null) {
            Iterator i = parametros.entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry valores = (Map.Entry) i.next();
                q.setParameter(valores.getKey().toString(), valores.getValue());
            }
        }
        return q.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public T unResultado(String sql, Map<String, Object> parametros) {
        //A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS
        getEntityManager().clear();
        getEntityManager().flush();
        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        //FIN ---> A LOS PROCEDIMIENTOS DE SELECCION Y LLAMADO DE STORED PROCEDURES PONERLES ESTAS LINEAS
        T t = null;
        Query q = getEntityManager().createNamedQuery(sql);
        try {
            if (parametros != null) {
                Iterator i = parametros.entrySet().iterator();
                while (i.hasNext()) {
                    Map.Entry valores = (Map.Entry) i.next();
                    q.setParameter(valores.getKey().toString(), valores.getValue());
                }
            }
            t = ((T) q.getSingleResult());
        } catch (javax.persistence.NoResultException e) {
            System.out.println("presistencia error " + e);
            return null;
        }
        return t;
    }

public String Obtener_Sequencia_MOC(String seq_name) {

String num_sq = getEntityManager().createNativeQuery("SELECT "+seq_name+".nextval FROM dual").getSingleResult().toString();

return num_sq;

}
   
}
