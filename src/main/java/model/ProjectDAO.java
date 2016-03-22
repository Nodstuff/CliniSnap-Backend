package model;

/**
 * Created by tmeaney on 22/03/16.
 */

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nodstuff on 13/10/15.
 */
@Slf4j
public class ProjectDAO implements DAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Save individual hibernate entity
    @Override
    public int save(Object o) {
        Session session = this.sessionFactory.openSession();

        int id = -1;

        try {
            Transaction tx = session.beginTransaction();
            id = (Integer)session.save(o);
            tx.commit();
        } catch (Exception e) {
            log.error("Error saving entry "+o.getClass(),e);
        }

        if (session!=null) {
            session.close();
        }
        else{
            log.debug("Session was null");
        }
        return id;
    }

    // Update individual hibernate entity
    @Override
    public void update(Object o) {
        Session session = this.sessionFactory.openSession();

        try {
            Transaction tx = session.beginTransaction();
            session.update(o);
            tx.commit();
        } catch (Exception e) {
            log.error("Error updating entry",e);
        }

        if (session!=null) {
            session.close();
        }
        else{
            log.debug("Session was null");
        }
    }

    // Delete individual hibernate entity
    @Override
    public void delete(Object o) {
        Session session = this.sessionFactory.openSession();

        try {
            Transaction tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
        } catch (Exception e) {
            log.error("Error deleting entry",e);
        }

        if (session!=null) {
            session.close();
        }
        else{
            log.debug("Session was null");
        }
    }

    // Retrieve any entity from any table using its ID
    @Override
    public Object getWithId(int id, Class c) {
        Session session = this.sessionFactory.openSession();

        Object o = null;

        try {
            o = c.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("Error getting instance of class",e);
        }

        try {
            session.beginTransaction();
            session.load(o, id);
            session.save(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("Error retrieving with ID: "+id,e);
        }

        if(session!=null){
            session.close();
        }
        else{
            log.debug("Session was null");
        }

        return o;
    }


    public List<Patient> getList() {
        log.debug("Class: " + this.getClass().getName() + "; Method: getListPatients; Message: entering method");

        //Open Hibernate Session
        Session session = this.sessionFactory.openSession();

        List<Patient> objList = new ArrayList<>();

        try {
            session.beginTransaction();

            Criteria crit = session.createCriteria(Patient.class);

            objList = crit.list();

            session.getTransaction().commit();

        } catch (Exception e) {

            log.error("Class: " + this.getClass().getName() + "; Method: getListParticipations; Message: Cannot retrieve list of Participants", e);

            session.getTransaction().rollback();

        } finally {

            session.close();

        }

        log.debug("Class: " + this.getClass().getName() + "; Method: getListParticipations; Message: leaving method");

        return objList;
    }

    // Check if an entry exists in a table, added due to spec but not used because the database already has this
    // functionality built in and is more efficient.
    // set a field as unique and the DB won't allow duplicate entries.
    public boolean exists(Class c, int exhibitId) {
        Session s = this.sessionFactory.openSession();
        boolean exists = s.get(c,exhibitId) != null;
        s.close();
        return exists;

    }

    public boolean exists(Class c, String uname) {
        Session s = this.sessionFactory.openSession();
        boolean exists = s.get(c,uname) != null;
        s.close();
        return exists;

    }
}