package bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "staple", schema = "mydatebase", catalog = "")
public class StapleEntity {
    private int id;
    private String stapleName;
    private String staplephone;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "stapleName")
    public String getStapleName() {
        return stapleName;
    }

    public void setStapleName(String stapleName) {
        this.stapleName = stapleName;
    }

    @Basic
    @Column(name = "staplephone")
    public String getStaplephone() {
        return staplephone;
    }

    public void setStaplephone(String staplephone) {
        this.staplephone = staplephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StapleEntity that = (StapleEntity) o;
        return id == that.id &&
                Objects.equals(stapleName, that.stapleName) &&
                Objects.equals(staplephone, that.staplephone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, stapleName, staplephone);
    }
}
