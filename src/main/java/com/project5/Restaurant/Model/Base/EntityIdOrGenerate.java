package com.project5.Restaurant.Model.Base;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

public class EntityIdOrGenerate extends IdentityGenerator {

    public Serializable generate(SessionImplementor session, Object obj) throws HibernateException {
        if (obj == null) {
            throw new HibernateException(new NullPointerException());
        }

        if (((EntityBase<?>) obj).getId() == null) {
            Serializable id = super.generate(session, obj);
            return id;
        } else {
            return ((EntityBase<?>) obj).getId();
        }
    }
}
