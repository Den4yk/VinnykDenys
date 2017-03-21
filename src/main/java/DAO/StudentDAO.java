package DAO;

import Models.StudentsEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentDAO implements ModelDAO<StudentsEntity> {
    public EntityManager em = Persistence.createEntityManagerFactory("NewPersistenceUnit").createEntityManager();

    public StudentsEntity add(StudentsEntity obj) {
        em.getTransaction().begin();
        StudentsEntity rs = em.merge(obj);
        em.getTransaction().commit();

        return rs;
    }

    public StudentsEntity get(long id) {
        return em.find(StudentsEntity.class, id);
    }

    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(this.get(id));
        em.getTransaction().commit();
    }

    public void update(StudentsEntity obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();

    }

    public List<StudentsEntity> getAll() {
        TypedQuery<StudentsEntity> nameQuery = em.createNamedQuery("StudentsEntity.getAll", StudentsEntity.class);
        return nameQuery.getResultList();
    }
}
