package bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TrainsiteEntityPK implements Serializable {
    private String trainName;
    private int siteOrder;

    @Column(name = "trainName")
    @Id
    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    @Column(name = "siteOrder")
    @Id
    public int getSiteOrder() {
        return siteOrder;
    }

    public void setSiteOrder(int siteOrder) {
        this.siteOrder = siteOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainsiteEntityPK that = (TrainsiteEntityPK) o;
        return siteOrder == that.siteOrder &&
                Objects.equals(trainName, that.trainName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(trainName, siteOrder);
    }
}
