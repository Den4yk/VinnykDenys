package DAO;

import Models.RoomsEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.spi.PersistenceProvider;
import java.util.List;

public class RoomDAO implements ModelDAO<RoomsEntity> {
    public EntityManager em = Persistence.createEntityManagerFactory("NewPersistenceUnit").createEntityManager();

    public RoomsEntity add(RoomsEntity obj) {
        em.getTransaction().begin();
        RoomsEntity rs = em.merge(obj);
        em.getTransaction().commit();

        return rs;
    }

    public RoomsEntity get(long id) {
        return em.find(RoomsEntity.class, id);
    }

    public void delete(long id) {
        em.getTransaction().begin();
        em.remove(this.get(id));
        em.getTransaction().commit();
    }

    public void update(RoomsEntity obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();

    }

    public List<RoomsEntity> getAll() {
        TypedQuery<RoomsEntity> nameQuery = em.createNamedQuery("RoomsEntity.getAll", RoomsEntity.class);
        return nameQuery.getResultList();
    }
}
