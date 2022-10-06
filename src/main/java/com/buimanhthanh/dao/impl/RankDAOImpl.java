package com.buimanhthanh.dao.impl;

import com.buimanhthanh.dao.RankDAO;
import com.buimanhthanh.dto.RankDTO;
import com.buimanhthanh.entity.Rank;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RankDAOImpl implements RankDAO {
    @Autowired private SessionFactory session;

    @Override
    public Optional<List<RankDTO>> findAll() {
        return Optional.ofNullable(
                session.getCurrentSession().createQuery("select new com.buimanhthanh.dto.RankDTO(r.id,r.name,r.description,r.repersent,r.type) from Rank r",RankDTO.class)
                        .getResultList()
        );
    }

    @Override
    public Optional<RankDTO> findOne(Integer id) {
        return session.getCurrentSession().createQuery("select new com.buimanhthanh.dto.RankDTO(r.id,r.name,r.description,r.repersent,r.type) from Rank r where r.id =: i",RankDTO.class)
                        .setParameter("i",id).stream().findFirst();
    }

    @Override
    public boolean saveOrUpdate(Rank rank) {
        try {
            session.getCurrentSession().saveOrUpdate(rank);
            return true;
        }catch (HibernateException e){
            System.out.println("Can not save or update rank");
        }
        return false;
    }

    @Override
    public void saveOrUpdate(List<Rank> ranks) {
        ranks.forEach(this::saveOrUpdate);
    }

    @Override
    public void delete(Integer id) {
        session.getCurrentSession().createQuery("delete Rank r where r.id =:i").setParameter("i",id).executeUpdate();
    }

    @Override
    public void delete(List<Integer> ids) {
        ids.forEach(this::delete);
    }
}
