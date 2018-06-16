package bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "trainsite", schema = "mydatebase", catalog = "")
@IdClass(TrainsiteEntityPK.class)
public class TrainsiteEntity {
    private String trainName;
    private int siteOrder;
    private String stationName;

    @Id
    @Column(name = "trainName")
    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    @Id
    @Column(name = "siteOrder")
    public int getSiteOrder() {
        return siteOrder;
    }

    public void setSiteOrder(int siteOrder) {
        this.siteOrder = siteOrder;
    }

    @Basic
    @Column(name = "stationName")
    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainsiteEntity that = (TrainsiteEntity) o;
        return siteOrder == that.siteOrder &&
                Objects.equals(trainName, that.trainName) &&
                Objects.equals(stationName, that.stationName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(trainName, siteOrder, stationName);
    }
}
