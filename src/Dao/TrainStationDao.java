package Dao;

import bean.TrainstationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainStationDao extends GetSession {
    public List list(String trainName){
        String hql = "from TrainstationEntity train where train.trainName = ?";
        return getSession().createQuery(hql).setParameter(0,trainName).list();
    }

    public List startlist(String startstation)
    {
        String hql = "from TrainstationEntity train where train.stationName1 = ?";
        return getSession().createQuery(hql).setParameter(0,startstation).list();
    }


    public List endlist(String endstation)
    {
        String hql = "from TrainstationEntity train where train.stationName2  = ?";
        return getSession().createQuery(hql).setParameter(0,endstation).list();
    }

    public List getTrainName(String startstation, String endstation)
    {
        String hql = "from TrainstationEntity train where train.stationName1 = ? and train.stationName2  = ?";
        return getSession().createQuery(hql).setParameter(0,startstation).setParameter(1,endstation).list();
    }

    public void addTrain(String trainName, int seqNum,String stationName1,String stationName2,int distance,int price1,int price2,int price3){
        TrainstationEntity trainstationEntity = new TrainstationEntity();
        trainstationEntity.setSeqNum(seqNum);
        trainstationEntity.setTrainName(trainName);
        trainstationEntity.setStationName1(stationName1);
        trainstationEntity.setStationName2(stationName2);
        trainstationEntity.setDistance(distance);
        trainstationEntity.setPirce1(price1);
        trainstationEntity.setPrice2(price2);
        trainstationEntity.setPrice3(price3);
        getSession().save(trainstationEntity);
    }

    public void deleteTrain(String trainName, int seqNum){
        String hql ="delete from TrainstationEntity train  where train.trainName = ? and train.seqNum = ?";
        getSession().createQuery(hql).setParameter(0,trainName).setParameter(1,seqNum).executeUpdate();

    }


}
