package Dao;

import bean.Train;
import org.springframework.stereotype.Repository;

import java.util.Comparator;

@Repository
public class sortClass implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Train trainEntity1 = (Train) o1;
        Train trainEntity2 = (Train) o2;
        int flag = trainEntity1.getStartTime().compareTo(trainEntity2.getStartTime());
        return flag;
    }
}
