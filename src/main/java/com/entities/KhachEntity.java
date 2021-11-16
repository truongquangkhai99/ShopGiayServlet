package com.entities;


import javax.persistence.*;

@Entity
@Table(name = "khach")
public class KhachEntity {

    private int idkhach;
    private String userName;
    private  String passWord;

    public KhachEntity()
    {

    }
    public KhachEntity(int id, String user, String pass)
    {
        this.idkhach = id;
        this.userName = user;
        this.passWord = pass;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getIdkhach() {
        return idkhach;
    }

    public void setIdkhach(int idkhach) {
        this.idkhach = idkhach;
    }
}