package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;
@Repository
public class MusicRepository implements IMusicRepository<Music> {
    @Override
    public Music findById(int id) {
       TypedQuery<Music> query = ConnecDB.entityManager.createQuery("select m from music m where id= ?1",Music.class);
       query.setParameter(1,id);
       return query.getSingleResult();
    }

    @Override
    public List<Music> findAll() {
       List<Music> musicList= ConnecDB.entityManager.createQuery("select m from music m",Music.class).getResultList();
        return musicList;
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = ConnecDB.entityManager.getTransaction();
        entityTransaction.begin();
        ConnecDB.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction = ConnecDB.entityManager.getTransaction();
        entityTransaction.begin();
        ConnecDB.entityManager.merge(music);
        entityTransaction.commit();
    }


    @Override
    public void removeById(int id) {
        EntityTransaction entityTransaction = ConnecDB.entityManager.getTransaction();
        entityTransaction.begin();
        ConnecDB.entityManager.remove(ConnecDB.entityManager.find(Music.class,id));
        entityTransaction.commit();
    }

    @Override
    public List<Music> findByName(String name) {
        TypedQuery<Music> query = ConnecDB.entityManager.createQuery("select m from music m where name like concat('%',?1,'%') ",Music.class);
        query.setParameter(1,name);
        return query.getResultList();
    }
}
