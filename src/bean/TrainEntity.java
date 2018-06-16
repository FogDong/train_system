package bean;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "train", schema = "mydatebase", catalog = "")
public class TrainEntity {
    private String trainName;
    private String startStation;
    private String endStation;
    private Timestamp startTime;
    private Timestamp endtTime;
    private Time duration;
    private String note;

    @Id
    @Column(name = "trainName")
    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    @Basic
    @Column(name = "startStation")
    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    @Basic
    @Column(name = "endStation")
    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    @Basic
    @Column(name = "startTime")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "endtTime")
    public Timestamp getEndtTime() {
        return endtTime;
    }

    public void setEndtTime(Timestamp endtTime) {
        this.endtTime = endtTime;
    }

    @Basic
    @Column(name = "duration")
    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainEntity that = (TrainEntity) o;
        return Objects.equals(trainName, that.trainName) &&
                Objects.equals(startStation, that.startStation) &&
                Objects.equals(endStation, that.endStation) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endtTime, that.endtTime) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {

        return Objects.hash(trainName, startStation, endStation, startTime, endtTime, duration, note);
    }
}
