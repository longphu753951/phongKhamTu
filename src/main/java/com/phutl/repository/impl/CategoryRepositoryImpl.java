package com.phutl.repository.impl;

import com.phutl.model.Category;
import com.phutl.repository.CategoryRepository;
import java.util.List;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    @Transactional
    public List<Category> getCategories() {
        Session session = this.sessionFactory
                .getObject()
                .getCurrentSession();
        Query q = session.createQuery("FROM Category");
        return q.getResultList();
    }

    @Override
    @Transactional
    public boolean addOrUpdateCategory(Category p) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            if(p.getCategoryId() != null){
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
    public boolean deleteCategory(int categoryId) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            session.delete(session.get(Category.class, categoryId));

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    @Transactional
    public Category getCategoryById(int categoryId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Category.class, categoryId);
    }
}
