package com.phutl.repository.impl;

import com.phutl.model.KhamBenhMedicine;
import com.phutl.repository.KhamBenhMedicineRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class KhamBenhMedicineRepositoryImpl implements KhamBenhMedicineRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public List<KhamBenhMedicine> selectByKhamBenhId(int khamBenhId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM KhamBenhMedicine kbm where kbm.khamBenh.khamBenh_Id = "+khamBenhId);
        return q.getResultList();
    }

    @Override
    @Transactional
    public boolean addOrUpdateKhamBenhMedicine(KhamBenhMedicine kbm) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(kbm);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
