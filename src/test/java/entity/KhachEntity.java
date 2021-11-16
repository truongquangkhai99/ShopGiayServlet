package entity;

import javax.persistence.*;

@Entity
@Table(name = "khach", schema = "shopgiaymaster", catalog = "")
public class KhachEntity {
    private int idkhach;
    private String userName;
    private String passWord;

    @Id
    @Column(name = "idkhach")
    public int getIdkhach() {
        return idkhach;
    }

    public void setIdkhach(int idkhach) {
        this.idkhach = idkhach;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "passWord")
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KhachEntity that = (KhachEntity) o;

        if (idkhach != that.idkhach) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (passWord != null ? !passWord.equals(that.passWord) : that.passWord != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idkhach;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (passWord != null ? passWord.hashCode() : 0);
        return result;
    }
}
