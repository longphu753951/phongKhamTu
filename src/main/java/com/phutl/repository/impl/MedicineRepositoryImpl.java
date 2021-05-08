package com.phutl.repository.impl;

import com.phutl.model.Medicine;
import com.phutl.model.User;
import com.phutl.repository.MedicineRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class MedicineRepositoryImpl implements MedicineRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public List<Medicine> getMedicines() {
        Session session = this.sessionFactory
                .getObject()
                .getCurrentSession();
        Query q = session.createQuery("FROM Medicine ");
        return q.getResultList();
    }

    @Override
    @Transactional
    public boolean addOrUpdateMedicine(Medicine p) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            if(p.getMedicineId() != null){
                session.update(p);
            } else {
                session.save(p);
            }

            return true;
        } catch (HibernateException ex){
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    @Transactional
    public boolean deleteMedicine(int medicineId) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            session.delete(session.get(Medicine.class, medicineId));

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    @Transactional
    public Medicine getMedicineById(int medicineId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Medicine.class, medicineId);
    }

    @Override
    @Transactional
    public List<Medicine> getMedicinesByName(String name) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Medicine> query = builder.createQuery(Medicine.class);
        Root root = query.from(Medicine.class);
        query.select(root);

        if (name != null && !name.isEmpty()) {
            Predicate p = builder.like(root.get("fullname").as(String.class),
                    String.format("%%%s%%", name));
            query = query.where(p);
        }

        Query q = session.createQuery(query);
        return q.getResultList();
    }
}
