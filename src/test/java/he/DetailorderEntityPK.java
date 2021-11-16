package he;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DetailorderEntityPK implements Serializable {
    private int oid;
    private int pid;

    @Column(name = "oid")
    @Id
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    @Column(name = "pid")
    @Id
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetailorderEntityPK that = (DetailorderEntityPK) o;

        if (oid != that.oid) return false;
        if (pid != that.pid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oid;
        result = 31 * result + pid;
        return result;
    }
}
