/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.repository.impl;

/**
 *
 * @author Hau Exoty
 */
import com.ttp.pojos.TypeReport;
import com.ttp.repository.TypeReportRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TypeReportRepositoryImpl implements TypeReportRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<TypeReport> getTypeReports() {
        Session session = sessionFactory.getObject().getCurrentSession();
        List<TypeReport> typeReports = session.createQuery("FROM TypeReport").getResultList();
        return typeReports;
    }

    @Override
    public boolean addTypeReport(TypeReport typeReport) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(typeReport);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public TypeReport getTypeReportById(Integer id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(TypeReport.class, id);
    }
}
