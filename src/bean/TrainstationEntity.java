package bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "trainstation", schema = "mydatebase", catalog = "")
public class TrainstationEntity {
    private int id;
    private int seqNum;
    private String trainName;
    private String stationName1;
    private String stationName2;
    private int distance;
    private int pirce1;
    private int price2;
    private int price3;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "seqNum")
    public int getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(int seqNum) {
        this.seqNum = seqNum;
    }

    @Basic
    @Column(name = "trainName")
    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    @Basic
    @Column(name = "stationName1")
    public String getStationName1() {
        return stationName1;
    }

    public void setStationName1(String stationName1) {
        this.stationName1 = stationName1;
    }

    @Basic
    @Column(name = "stationName2")
    public String getStationName2() {
        return stationName2;
    }

    public void setStationName2(String stationName2) {
        this.stationName2 = stationName2;
    }

    @Basic
    @Column(name = "distance")
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Basic
    @Column(name = "pirce1")
    public int getPirce1() {
        return pirce1;
    }

    public void setPirce1(int pirce1) {
        this.pirce1 = pirce1;
    }

    @Basic
    @Column(name = "price2")
    public int getPrice2() {
        return price2;
    }

    public void setPrice2(int price2) {
        this.price2 = price2;
    }

    @Basic
    @Column(name = "price3")
    public int getPrice3() {
        return price3;
    }

    public void setPrice3(int price3) {
        this.price3 = price3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainstationEntity that = (TrainstationEntity) o;
        return id == that.id &&
                seqNum == that.seqNum &&
                distance == that.distance &&
                pirce1 == that.pirce1 &&
                price2 == that.price2 &&
                price3 == that.price3 &&
                Objects.equals(trainName, that.trainName) &&
                Objects.equals(stationName1, that.stationName1) &&
                Objects.equals(stationName2, that.stationName2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, seqNum, trainName, stationName1, stationName2, distance, pirce1, price2, price3);
    }
}
