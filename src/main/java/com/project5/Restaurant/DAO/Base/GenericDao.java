package com.project5.Restaurant.DAO.Base;

import com.project5.Restaurant.Model.Base.EntityBase;
import org.hibernate.Criteria;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericDao<E extends EntityBase<PK>, PK extends Serializable> {
    private final Class<? extends E> entityClass;
    private final Class<? extends PK> pkClass;


    @Autowired
    SessionFactory sessionFactory;

    public GenericDao(Class<? extends E> entityClass, Class<? extends PK> pkClass) {
        this.entityClass = entityClass;
        this.pkClass = pkClass;

        Entity e = this.entityClass.getAnnotation(Entity.class);
        if (e == null) {
            throw new RuntimeException("Please specify the class Entity annotation of JPA is attached.");
        }

        if (!Serializable.class.isAssignableFrom(this.pkClass)) {
            throw new RuntimeException("Please specify the class PK extend from Serializable class.");
        }
    }

    private static <T> T newInstanceWithConvertRuntimeException(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public PK insert(E entity) {
        return (PK) getCurrentSession().save(entity);
    }

    public void update(E entity) {
        getCurrentSession().update(entity);
    }

    public PK insertOrUpdate(E entity) {
        getCurrentSession().saveOrUpdate(entity);
        return entity.getId();
    }

    public void updateField(PK pk, String fieldName, Object value) {
        Map<String, Object> valueMap = new HashMap<String, Object>(1);
        valueMap.put(fieldName, value);
        updateField(pk, fieldName, valueMap);
    }

    public void update(Collection<PK> pks, String fieldName, Object value) {
        Map<String, Object> valueMap = new HashMap<String, Object>(1);
        valueMap.put(fieldName, value);
        update(pks, fieldName, valueMap);
    }

    @SuppressWarnings({"rawtypes"})
    public void update(Collection<PK> pks, Map<String, Object> valueMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ").append(getEntityClassName()).append(" SET ");
        for (Map.Entry<String, ?> entry : valueMap.entrySet()) {
            sb.append(entry.getKey()).append(" = :" + entry.getKey() + ", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append("WHER id in :pks");
        Query query = getCurrentSession().createQuery(sb.toString());
        for (Map.Entry<String, ?> entry : valueMap.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        query.setParameter("pks", pks);
        query.executeUpdate();
    }

    @SuppressWarnings({"rawtypes"})
    public void updateFields(PK pk, Map<String, Object> valueMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ").append(getEntityClassName()).append(" SET ");
        for (Map.Entry<String, ?> entry : valueMap.entrySet()) {
            sb.append(entry.getKey()).append(" = :" + entry.getKey() + ", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append("WHERE id = :pk");
        Query query = getCurrentSession().createQuery(sb.toString());
        for (Map.Entry<String, ?> entry : valueMap.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        query.setParameter("pk", pk);
        query.executeUpdate();
    }

    public void delete(E entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteByPK(PK pk) {
        getCurrentSession().createQuery("DELETE FROM " + getEntityClassName() + "WHERE id = :pk")
                .setParameter("pk", pk).executeUpdate();
    }

    public void deleteByPKs(Collection<PK> pks) {
        deleteBy("id", pks);
    }

    public void deleteBy(String fieldName, Object value) {
        getCurrentSession().createQuery("DELETE FROM " + getEntityClassName() + " " + "WHERE" + fieldName + "= :value")
                .setParameter("value", value).executeUpdate();
    }

    public void deleteBy(String fieldaName, Collection<?> values) {
        if (CollectionUtils.isEmpty(values)) {
            return;
        }

        getCurrentSession()
                .createQuery("DELETE FROM" + getEntityClassName() + " " + "WHERE" + fieldaName + "in (:value)")
                .setParameterList("values", values).executeUpdate();
    }

    public E findByPK(PK pk) {
        return getCurrentSession().get(this.entityClass, pk);
    }

    @SuppressWarnings("unchecked")
    public List<E> findAll() {
        return createCriteria().list();
    }

    protected Criteria createCriteria() {
        // TODO Auto-generated method stub
        return getCurrentSession().createCriteria(this.entityClass);
    }

    public Class<? extends E> getEntityClass() {
        return this.entityClass;
    }

    public String getEntityClassName() {
        return getEntityClass().getSimpleName();
    }

    private Session getCurrentSession() {
        return this.getSessionFactory().getCurrentSession();
    }

    public E createEntity() {
        return newInstanceWithConvertRuntimeException(entityClass);
    }

    public PK createPK() {
        return newInstanceWithConvertRuntimeException(this.pkClass);
    }
}
