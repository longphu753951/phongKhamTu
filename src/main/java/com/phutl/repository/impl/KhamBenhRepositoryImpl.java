package com.phutl.repository.impl;

import com.phutl.model.KhamBenh;
import com.phutl.model.Medicine;
import com.phutl.repository.KhamBenhRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class KhamBenhRepositoryImpl implements KhamBenhRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public List<KhamBenh> khamBenhLists() {
        Session session = this.sessionFactory
                .getObject()
                .getCurrentSession();
        Query q = session.createQuery("FROM KhamBenh ");
        return q.getResultList();
    }

    @Override
    @Transactional
    public boolean addOrUpdateKhamBenh(KhamBenh k) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            if(k.getKhamBenh_Id() != null){
                session.update(k);
            } else {
                session.save(k);
            }

            return true;
        } catch (HibernateException ex){
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    @Transactional
    public KhamBenh getKhamBenhById(int id) {

        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(KhamBenh.class, id);
    }

    @Override
    @Transactional
    public List<KhamBenh> khamBenhByDay() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM KhamBenh where ngayKham = current_date and tinhTrang = 0 order by gioKham asc");
        return q.getResultList();
    }
}
