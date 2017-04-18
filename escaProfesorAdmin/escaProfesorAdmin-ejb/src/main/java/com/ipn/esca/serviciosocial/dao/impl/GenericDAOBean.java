package com.ipn.esca.serviciosocial.dao.impl;

import com.ipn.esca.serviciosocial.dao.GenericDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDAOBean<T, Long> implements GenericDAO<T, Long> {
    @PersistenceContext(name = "serviciosocial_ds")
    protected EntityManager em;
}
