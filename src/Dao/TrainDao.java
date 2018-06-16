package Dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainDao extends GetSession {
    //写Hql语句

    public List list(String trainName)
    {
        String hql = "from TrainEntity train where train.trainName = ?";
        return getSession().createQuery(hql).setParameter(0,trainName).list();
    }


}
