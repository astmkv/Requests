package com.example.db;

import jakarta.persistence.*;
@Entity
@NamedQuery(name = "get_starts_with_string",
        query = "SELECT e " +
                "FROM ReqTableEntity e " +
                "WHERE e.name like :name")

@NamedQuery(name = "get_req_by_phone_starts_with_string",
        query = "SELECT e " +
                "FROM ReqTableEntity e " +
                "WHERE e.name like :name")


@Table(name = "req_table", schema = "db_req", catalog = "")
public class ReqTableEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_req")
    private Integer idReq;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "ph_number")
    private String phNumber;
    @Basic
    @Column(name = "adress")
    private String adress;

    public Integer getIdReq() {
        return idReq;
    }

    public void setIdReq(Integer idReq) {
        this.idReq = idReq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object e) {
        if (this == e) return true;
        if (e == null || getClass() != e.getClass()) return false;

        ReqTableEntity that = (ReqTableEntity) e;

        if (idReq != null ? !idReq.equals(that.idReq) : that.idReq != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phNumber != null ? !phNumber.equals(that.phNumber) : that.phNumber != null) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReq != null ? idReq.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phNumber != null ? phNumber.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReqTableEntity{" +
                "idReq=" + idReq +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phNumber='" + phNumber + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
