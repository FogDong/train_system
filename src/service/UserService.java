package service;

import Dao.*;
import bean.*;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private LoginDao loginDao;
    @Autowired
    private TrainDao trainDao;
    @Autowired
    private TrainSiteDao trainSiteDao;
    @Autowired
    private TrainStationDao trainStationDao;
    @Autowired
    private StapleDao stapleDao;


    public int LoginIN(String username,String password){
        try {
            System.out.println(username+","+password);
            String pwd = loginDao.Seach(username);
            System.out.println(pwd);
            if(pwd!=null&&pwd.equals(password))
            {
                return 0;
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int updatePwd(String username,String newpwd){
        loginDao.update(username,newpwd);
        return 0;
    }

    public int deletusr(String username)
    {
        loginDao.delete(username);
        return 0;
    }

    public int addusr(String username,String password,String phone)
    {
        loginDao.add(username,password,phone);
        return 0;
    }

    public List liststaple(String username)
    {
        List user = loginDao.list(username);
        LoginEntity loginEntity = (LoginEntity) user.get(0);
        List staple = stapleDao.list(loginEntity.getId());
        return staple;
    }

    public int addTrain(String trainName, int seqNum,String stationName1,String stationName2,int distance,int price1, int price2, int price3){
        trainStationDao.addTrain(trainName,seqNum,Englishname(stationName1),Englishname(stationName2),distance,price1,price2,price3);
        return 0;
    }

    public int deleteTrain(String trainName, int seqNum)
    {
        trainStationDao.deleteTrain(trainName,seqNum);
        return 0;
    }


    public String rename(String station){

        String newname = null;
        switch (station)
        {
            case "beijing": newname = "北京";break;
            case "tianjin": newname = "天津";break;
            case "dezhou": newname = "德州";break;
            case "jinan": newname = "济南";break;
            case "xuzhou": newname = "徐州";break;
            case "hangzhou": newname = "杭州";break;
            case "shanghai": newname = "上海";break;
            case "shijiazhuang": newname = "石家庄";break;
            case "zhenzhou": newname = "郑州";break;
            case "suqian": newname = "宿迁";break;
            case "yangzhou": newname = "扬州";break;
            case "nanjing": newname = "南京";break;
            case "hefei": newname = "合肥";break;
            default:newname = station;break;
        }
        return newname;
    }

    public String Englishname(String station)
    {
        String newname = null;
        switch (station)
        {
            case "北京": newname = "beijing";break;
            case "天津": newname = "tianjin";break;
            case "德州": newname = "dezhou";break;
            case "济南": newname = "jinan";break;
            case "徐州": newname = "xuzhou";break;
            case "杭州": newname = "hangzhou";break;
            case "上海": newname = "shanghai";break;
            case "石家庄": newname = "shijiazhuang";break;
            case "郑州": newname = "zhenzhou";break;
            case "宿迁": newname = "suqian";break;
            case "扬州": newname = "yangzhou";break;
            case "南京": newname = "nanjing";break;
            case "合肥": newname = "hefei";break;
            default:newname = station;break;
        }
        return newname;
    }


    public List calucu(String startStation, String endStation, String trainName)//计算表三中的两站之间的距离和价钱
    {
        List train = trainStationDao.list(trainName);
        int st=-1;
        int flag=0;
        int distance=0;
        int price1=0, price2=0, price3=0;
        Train temp = new Train();
        List trainInfo = new ArrayList();

        for(int i=0; i<train.size(); i++)
        {
            TrainstationEntity trainstationEntity = (TrainstationEntity) train.get(i);

            if(trainstationEntity.getStationName1().equals(startStation))
            {
                st=trainstationEntity.getSeqNum();//记录以startStation为起始站S的站段编号st
                flag=1;
            }
            if(flag ==1 && trainstationEntity.getSeqNum()>st)
            {
                distance += trainstationEntity.getDistance();
                price1 += trainstationEntity.getPirce1();
                price2 += trainstationEntity.getPrice2();
                price3 += trainstationEntity.getPrice3();
            }

            if(trainstationEntity.getStationName2().equals(endStation))
            {
                break;
            }
        }
        temp.setDistance(distance);
        temp.setPrice3(price3);
        temp.setPrice2(price2);
        temp.setPrice1(price1);
        trainInfo.add(temp);
        return trainInfo;
    }


    public List straightList(String StartStation, String EndStation){
        List trainInfo = new ArrayList();
        String startStation = Englishname(StartStation);
        String endStation = Englishname(EndStation);
        List startStationlist = trainSiteDao.list(startStation);
        List endStationlist = trainSiteDao.list(endStation);

        System.out.println(startStationlist);
        System.out.println(endStationlist);

        for(int i=0; i<startStationlist.size(); i++)
        {
            String trainName1 = (String) startStationlist.get(i);
            for(int j=0; j<endStationlist.size(); j++) {
                String trainName2 = (String) endStationlist.get(j);
                if (trainName1.equals(trainName2)) {
                    Train temp = new Train();
                    List ta = trainDao.list(trainName1);
                    TrainEntity trainEntity = (TrainEntity) ta.get(0);

                    temp.setTrainName(trainName1);
                    temp.setStartStation(StartStation);
                    temp.setEndStation(EndStation);
                    temp.setStartTime(trainEntity.getStartTime());
                    temp.setEndtTime(trainEntity.getEndtTime());
                    temp.setDuration(trainEntity.getDuration());

                    List dip = calucu(startStation, endStation, trainName1);
                    Train dsp = (Train) dip.get(0);
                    temp.setPrice1(dsp.getPrice1());
                    temp.setPrice2(dsp.getPrice2());
                    temp.setPrice3(dsp.getPrice3());
                    temp.setDistance(dsp.getDistance());
                    trainInfo.add(temp);
                }
            }
        }
        return trainInfo;

    }

    public List Cheapest(String StartStation, String EndStation)
    {
        List trains = straightList(StartStation,EndStation);
        List cheapTrain = new ArrayList();
        int price = 100000;
        int count = -1;

        for(int i=0; i<trains.size(); i++)
        {
            Train train = (Train) trains.get(i);
            System.out.println(train);
            if(price>train.getPrice3())
            {
                price = train.getPrice3();
                count = i;
            }
        }
        if(count == -1)
        {
            return cheapTrain;
        }

        Train train = (Train) trains.get(count);
        Train temp = new Train();
        temp.setTrainName(train.getTrainName());
        temp.setStartStation(StartStation);
        temp.setEndStation(EndStation);

        temp.setStartTime(train.getStartTime());
        temp.setEndtTime(train.getEndtTime());
        temp.setDuration(train.getDuration());

        temp.setPrice1(train.getPrice1());
        temp.setPrice2(train.getPrice2());
        temp.setPrice3(train.getPrice3());
        temp.setDistance(train.getDistance());

        cheapTrain.add(temp);

        return cheapTrain;
    }


   public List ShortestWay(String StartStation, String EndStation)
    {
        String startStation = Englishname(StartStation);
        String endStation = Englishname(EndStation);
        String station = startStation;

        String []stations = new String[12];//存站点名
        stations[0] = startStation;//第一个站为输入站

        int []distance = new int[12];//存距离
        distance[0]=0;//输入站与自己的距离为0

        int []pre = new int[12];//每个站的前导站的标号
        pre[0] = -1;//出发站没有前导站，所以为-1

        List unitTrain = new ArrayList();

        String trainName = "null";//车次
        String station1,station2;

        int p=0,q=0,end=-1;//p为存了多少站，q为从哪站开始找下一站，end为目的地在数组中的位置

        while(true) {
            List train = trainStationDao.startlist(station);
            System.out.println(train);
            for (int i = 0; i < train.size(); i++)//分支
            {
                TrainstationEntity trainEntity = (TrainstationEntity) train.get(i);

                int sign = 1;

                if(end!=-1&&distance[end]<distance[q]+trainEntity.getDistance())
                {
                    continue;
                }

                for (int j = 0; j <= p; j++) {
                    if (stations[j].equals(trainEntity.getStationName2())) {
                        sign = 0;
                        int temp = trainEntity.getDistance() + distance[p];
                        if (distance[j] > temp) {
                            pre[j] = p;
                            distance[j] = temp;
                            break;
                        }
                        break;
                    }
                }

                if (sign == 1) {
                    ++p;
                    if(trainEntity.getStationName2().equals(endStation))
                    {
                        end = p;
                    }
                    distance[p] = distance[q]+trainEntity.getDistance();
                    stations[p] = trainEntity.getStationName2();
                    System.out.println(stations[q]+"->"+stations[p]+",dis="+distance[p]);
                    pre[p] = q;
                }
            }//for


            if(p==q||(end!=-1&&p>end))
            {
                break;
            }
            station = stations[++q];
        }//while


        if(end == -1)
        {
            return unitTrain;
        }

        for(int i=0; i<=p; i++)
        {
            System.out.println(i+"="+stations[i]);
            System.out.println("前导地址："+pre[i]);
        }

        int []later=new int[12];
        p=end;

        while (true)
        {
            later[pre[p]] = p;
            p = pre[p];
            if(p==0)
            {
                break;
            }
        }

        p=later[0];
        station2 = stations[p];
        station1 = startStation;

        String []trainames = new String[10];
        String []freights = new String[10];
        int tr=-1,fr=-1;

        while(true)//找出中转站和换乘的车次
        {
            List  trainname = trainStationDao.getTrainName(station1,station2);
            System.out.println("station1="+station1+",station2="+station2);
            if(trainname.size()==1)
            {
                TrainstationEntity trainEntity = (TrainstationEntity) trainname.get(0);
                if(trainName.equals(trainEntity.getTrainName())==false)
                {
                    trainName = trainEntity.getTrainName();
                    trainames[++tr]=trainEntity.getTrainName();
                    freights[++fr] = station1;

                }
            }

            if(p==end)
            {
                break;
            }

            station1 = station2;
            p = later[p];
            station2 = stations[p];
        }

        freights[++fr] = endStation;

        for(int i=0; i<=tr; i++)
        {
            Train ttemp = new Train();
            List train = trainDao.list(trainames[i]);
            TrainEntity trainEntity = (TrainEntity) train.get(0);

            ttemp.setTrainName(trainames[i]);
            ttemp.setStartTime(trainEntity.getStartTime());
            ttemp.setEndtTime(trainEntity.getEndtTime());
            ttemp.setDuration(trainEntity.getDuration());

            ttemp.setStartStation(rename(freights[i]));
            ttemp.setEndStation(rename(freights[i+1]));

            List dip = calucu(freights[i],freights[i+1],trainames[i]);
            Train dsp = (Train) dip.get(0);
            ttemp.setPrice1(dsp.getPrice1());
            ttemp.setPrice2(dsp.getPrice2());
            ttemp.setPrice3(dsp.getPrice3());
            ttemp.setDistance(dsp.getDistance());
            unitTrain.add(ttemp);

        }

        return unitTrain;
    }

    public List Transfer(String StartStation, String EndStation,String Transtation)
    {
        System.out.println(Transtation);
        String startStation = Englishname(StartStation);
        String endStation = Englishname(EndStation);
        String transtation = Englishname(Transtation);
        List trainInfo = new ArrayList();
        List startStationlist = trainSiteDao.list(startStation);
        List endStationlist = trainSiteDao.list(endStation);
        List tranStationlist = trainSiteDao.list(transtation);
        String []trains = new String[2];

        for(int i=0; i<startStationlist.size(); i++)
        {
            String trainName1 = (String) startStationlist.get(i);
            for(int j=0; j<tranStationlist.size(); j++) {
                String trainName2 = (String) tranStationlist.get(j);
                if(trainName1.equals(trainName2))
                {
                    trains[0] = trainName1;
                    break;
                }
            }
        }

        if(trains[0]==null)
        {
            return trainInfo;
        }

        for(int i=0; i<endStationlist.size(); i++)
        {
            String trainName3 = (String) endStationlist.get(i);
            for(int j=0; j<tranStationlist.size(); j++)
            {
                String trainName2 = (String) tranStationlist.get(j);
                if(trainName2.equals(trainName3))
                {
                    trains[1] = trainName2;
                    break;
                }
            }
        }

        if(trains[1]==null)
        {
            return trainInfo;
        }

        for(int i=0; i<2; i++)
        {
            Train temp = new Train();
            List ta = trainDao.list(trains[i]);
            TrainEntity trainEntity = (TrainEntity) ta.get(0);
            List dip = new ArrayList();

            temp.setTrainName(trains[i]);
            if(i==0)
            {
                temp.setStartStation(StartStation);
                temp.setEndStation(Transtation);
                dip = calucu(startStation, transtation, trains[i]);
            }
            else
            {
                temp.setStartStation(Transtation);
                temp.setEndStation(EndStation);
                dip = calucu(transtation, endStation, trains[i]);
            }

            Train dsp = (Train) dip.get(0);
            temp.setPrice1(dsp.getPrice1());
            temp.setPrice2(dsp.getPrice2());
            temp.setPrice3(dsp.getPrice3());
            temp.setDistance(dsp.getDistance());

            temp.setStartTime(trainEntity.getStartTime());
            temp.setEndtTime(trainEntity.getEndtTime());
            temp.setDuration(trainEntity.getDuration());

            trainInfo.add(temp);
        }

        return trainInfo;
    }

    public List listByST(String StartStation, String EndStation,int STsign)
    {
        String startStation = Englishname(StartStation);
        String endStation = Englishname(EndStation);
        List<Train> train = straightList(startStation,endStation);
        List trainInfo = new ArrayList();

        sortClass sort = new sortClass();
        Collections.sort(train,sort);

        if(STsign == 1)
        {
            for(int i=train.size()-1; i>=0;i--)
            {
                Train temp = new Train();
                Train trainEntity = train.get(i);
                temp.setTrainName(trainEntity.getTrainName());
                temp.setStartStation(rename(trainEntity.getStartStation()));
                temp.setEndStation(rename(trainEntity.getEndStation()));
                temp.setStartTime(trainEntity.getStartTime());
                temp.setEndtTime(trainEntity.getEndtTime());
                temp.setDuration(trainEntity.getDuration());
                temp.setNote(trainEntity.getNote());
                System.out.println("TrainName:" + temp.getTrainName());
                trainInfo.add(temp);
            }
        }

        if(STsign == -1) {
            for (int i = 0; i < train.size(); i++) {
                Train temp = new Train();
                Train trainEntity = train.get(i);
                temp.setTrainName(trainEntity.getTrainName());
                temp.setStartStation(rename(trainEntity.getStartStation()));
                temp.setEndStation(rename(trainEntity.getEndStation()));
                temp.setStartTime(trainEntity.getStartTime());
                temp.setEndtTime(trainEntity.getEndtTime());
                temp.setDuration(trainEntity.getDuration());
                temp.setNote(trainEntity.getNote());
                System.out.println("TrainName:" + temp.getTrainName());
                trainInfo.add(temp);
                System.out.println(trainInfo);
            }
        }

        return trainInfo;
    }

    public List listByET(String startStation, String endStation,int ETsign)
    {
        List<Train> train = straightList(startStation, endStation);
        List trainInfos = new ArrayList();

        EsortClass sort = new EsortClass();
        Collections.sort(train,sort);
        if(ETsign == 1) {
            for (int i = train.size()-1; i >= 0; i--) {
                Train temp = new Train();
                Train trainEntity = train.get(i);
                temp.setStartTime(trainEntity.getStartTime());
                temp.setEndtTime(trainEntity.getEndtTime());
                temp.setTrainName(trainEntity.getTrainName());
                temp.setStartStation(rename(trainEntity.getStartStation()));
                temp.setEndStation(rename(trainEntity.getEndStation()));
                temp.setDuration(trainEntity.getDuration());
                temp.setNote(trainEntity.getNote());
                trainInfos.add(temp);
            }
        }

        if(ETsign == -1) {
            for (int i = 0; i < train.size(); i++) {
                Train temp = new Train();
                Train trainEntity = train.get(i);
                temp.setTrainName(trainEntity.getTrainName());
                temp.setStartStation(rename(trainEntity.getStartStation()));
                temp.setEndStation(rename(trainEntity.getEndStation()));
                temp.setDuration(trainEntity.getDuration());
                temp.setStartTime(trainEntity.getStartTime());
                temp.setEndtTime(trainEntity.getEndtTime());
                temp.setNote(trainEntity.getNote());
                System.out.println("TrainName:" + temp.getTrainName());
                trainInfos.add(temp);
            }
        }

        return trainInfos;
    }

    public List listByDT(String startStation, String endStation, int DTsign)
    {
        List<Train> train = straightList(startStation, endStation);
        List trainInfos = new ArrayList();

        DsortClass sort = new DsortClass();
        Collections.sort(train,sort);

        if(DTsign == -1){
            for (int i = train.size()-1; i >= 0; i--) {
                Train temp = new Train();
                Train trainEntity = train.get(i);
                temp.setDuration(trainEntity.getDuration());
                temp.setStartTime(trainEntity.getStartTime());
                temp.setEndtTime(trainEntity.getEndtTime());
                temp.setTrainName(trainEntity.getTrainName());
                temp.setStartStation(rename(trainEntity.getStartStation()));
                temp.setEndStation(rename(trainEntity.getEndStation()));
                temp.setNote(trainEntity.getNote());
                trainInfos.add(temp);
            }
        }

        if(DTsign == 0) {
            for (int i = 0; i < train.size(); i++) {
                Train temp = new Train();
                Train trainEntity = train.get(i);
                temp.setDuration(trainEntity.getDuration());
                temp.setStartTime(trainEntity.getStartTime());
                temp.setEndtTime(trainEntity.getEndtTime());
                temp.setNote(trainEntity.getNote());
                temp.setTrainName(trainEntity.getTrainName());
                temp.setStartStation(rename(trainEntity.getStartStation()));
                temp.setEndStation(rename(trainEntity.getEndStation()));
                trainInfos.add(temp);
            }
        }

        return trainInfos;

    }
}
