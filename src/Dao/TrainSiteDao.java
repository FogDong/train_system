package Dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainSiteDao extends GetSession{
    public List list(String stationName){
        String hql = "select trainName from TrainsiteEntity train where train.stationName = ?";
        return getSession().createQuery(hql).setParameter(0,stationName).list();
    }

}
