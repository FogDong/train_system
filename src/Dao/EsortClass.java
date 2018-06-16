package Dao;

import bean.TrainEntity;
import org.springframework.stereotype.Repository;

import java.util.Comparator;

@Repository
public class EsortClass implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        TrainEntity trainEntity1 = (TrainEntity) o1;
        TrainEntity trainEntity2 = (TrainEntity) o2;
        int flag = trainEntity1.getEndtTime().compareTo(trainEntity2.getEndtTime());
        return flag;
    }
}
