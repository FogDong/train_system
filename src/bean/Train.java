package bean;

import java.sql.Time;
import java.sql.Timestamp;

public class Train {
    private int listnum;
    private String trainName;
    private String startStation;
    private String endStation;
    private Timestamp startTime;
    private Timestamp endtTime;
    private Time duration;
    private String note;

    private int siteOrder;
    private String stationName;

    private int id;
    private int seqNum;
    private String stationName1;
    private String stationName2;
    private int distance;
    private Integer price1;
    private Integer price2;
    private Integer price3;

    public int getListnum() {
        return listnum;
    }

    public void setListnum(int listnum) {
        this.listnum = listnum;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndtTime() {
        return endtTime;
    }

    public void setEndtTime(Timestamp endtTime) {
        this.endtTime = endtTime;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getSiteOrder() {
        return siteOrder;
    }

    public void setSiteOrder(int siteOrder) {
        this.siteOrder = siteOrder;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(int seqNum) {
        this.seqNum = seqNum;
    }

    public String getStationName1() {
        return stationName1;
    }

    public void setStationName1(String stationName1) {
        this.stationName1 = stationName1;
    }

    public String getStationName2() {
        return stationName2;
    }

    public void setStationName2(String stationName2) {
        this.stationName2 = stationName2;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Integer getPrice1() {
        return price1;
    }

    public void setPrice1(Integer price1) {
        this.price1 = price1;
    }

    public Integer getPrice2() {
        return price2;
    }

    public void setPrice2(Integer price2) {
        this.price2 = price2;
    }

    public Integer getPrice3() {
        return price3;
    }

    public void setPrice3(Integer price3) {
        this.price3 = price3;
    }

    @Override
    public String toString() {
        return "Train{" +
                "listnum=" + listnum +
                ", trainName='" + trainName + '\'' +
                ", startStation='" + startStation + '\'' +
                ", endStation='" + endStation + '\'' +
                ", startTime=" + startTime +
                ", endtTime=" + endtTime +
                ", duration=" + duration +
                ", note='" + note + '\'' +
                ", siteOrder=" + siteOrder +
                ", stationName='" + stationName + '\'' +
                ", id=" + id +
                ", seqNum=" + seqNum +
                ", stationName1='" + stationName1 + '\'' +
                ", stationName2='" + stationName2 + '\'' +
                ", distance=" + distance +
                ", price1=" + price1 +
                ", price2=" + price2 +
                ", price3=" + price3 +
                '}';
    }
}
