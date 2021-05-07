package com.phutl.repository.impl;

import com.phutl.model.DangKy;
import com.phutl.repository.DangKyRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class DangKyRepositoryImpl implements DangKyRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public boolean addDangKy(DangKy p) {

        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    @Override
    @Transactional
    public boolean updateDangKy(DangKy p) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.update(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public DangKy selectDangKybyId(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(DangKy.class, id);
    }
}
