package test;


import bean.Train;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContent.xml")
public class test {
    @Autowired
    UserService userService;

    @Test
    public void testLogin()
    {
        System.out.println(userService.LoginIN("张三","123456"));
    }

    @Test
    public void addLogin()
    {
        System.out.println(userService.addusr("王五","147258","123"));
    }

    @Test
    public void TestlistTrain()
    {
        System.out.println(userService.straightList("石家庄","上海"));
    }

    @Test
    public void CheaplistTest()
    {
        System.out.println(userService.Cheapest("石家庄","上海"));
    }

    @Test
    public void ShortestTest()
    {
        System.out.println(userService.ShortestWay("北京","南京"));
    }


    @Test
    public void TransTest()
    {
        System.out.println(userService.Transfer("北京","南京","济南"));
    }

    @Test
    public void CheapestTest(){
        //System.out.println(userService.CheapWay("shijiazhuang","shanghai"));
    }

    @Test
    public void addTrainTest(){
        System.out.println(userService.addTrain("K000",1,"beijing","tianjing",40,100,50,20));
    }

    @Test
    public void TeststaTimeList(){
        List<Train> train =userService.listByST("shijiazhuang","shanghai",1);
        for(int i=0;i<train.size(); i++)
        {
            Train t = train.get(i);
            System.out.println(t.getTrainName()+","+t.getStartStation()+","+t.getEndStation()+","+t.getStartTime()+","+t.getEndtTime()
            +","+t.getDuration()+","+t.getNote());
        }

    }

    @Test
    public void TestETimeList(){
        List<Train> train =userService.listByET("shijiazhuang","shanghai",-1);
        for(int i=0;i<train.size(); i++)
        {
            Train t = train.get(i);
            System.out.println(t.getTrainName()+","+t.getStartStation()+","+t.getEndStation()+","+t.getStartTime()+","+t.getEndtTime()
                    +","+t.getDuration()+","+t.getNote());
        }

    }

    @Test
    public void TestDTimeList(){
        List<Train> train =userService.listByDT("shijiazhuang","shanghai",1);
        for(int i=0;i<train.size(); i++)
        {
            Train t = train.get(i);
            System.out.println(t.getTrainName()+","+t.getStartStation()+","+t.getEndStation()+","+t.getStartTime()+","+t.getEndtTime()
                    +","+t.getDuration()+","+t.getNote());
        }

    }
}
