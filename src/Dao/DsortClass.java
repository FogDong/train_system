package Dao;

import bean.TrainEntity;

import java.util.Comparator;

public class DsortClass implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        TrainEntity trainEntity1 = (TrainEntity) o1;
        TrainEntity trainEntity2 = (TrainEntity) o2;
        int flag = trainEntity1.getDuration().compareTo(trainEntity2.getDuration());
        return flag;
    }
}