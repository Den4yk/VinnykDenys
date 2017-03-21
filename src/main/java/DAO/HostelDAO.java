package DAO;

import Models.HostelsEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class HostelDAO implements ModelDAO<HostelsEntity> {
    public EntityManager em = Persistence.createEntityManagerFactory("NewPersistenceUnit").createEntityManager();

    public HostelsEntity add(HostelsEntity obj) {
        em.getTransaction().begin();
        HostelsEntity rs = em.merge(obj);
        em.getTransaction().commit();

        return rs;
    }

    public HostelsEntity get(long id) {
        return em.find(HostelsEntity.class, id);
    }

    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(this.get(id));
        em.getTransaction().commit();
    }

    public void update(HostelsEntity obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();

    }

    public List<HostelsEntity> getAll() {
        TypedQuery<HostelsEntity> nameQuery = em.createNamedQuery("HostelsEntity.getAll", HostelsEntity.class);
        return nameQuery.getResultList();
    }
}
