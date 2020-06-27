package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Users {
    private int idUsers;
    private String username;
    private String password;
    private Integer idManager;
    private Integer idTrainer;
    private Integer idClient;

    @Id
    @Column(name = "IdUsers")
    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "IdManager")
    public Integer getIdManager() {
        return idManager;
    }

    public void setIdManager(Integer idManager) {
        this.idManager = idManager;
    }

    @Basic
    @Column(name = "IdTrainer")
    public Integer getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(Integer idTrainer) {
        this.idTrainer = idTrainer;
    }

    @Basic
    @Column(name = "IdClient")
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return idUsers == users.idUsers &&
                Objects.equals(username, users.username) &&
                Objects.equals(password, users.password) &&
                Objects.equals(idManager, users.idManager) &&
                Objects.equals(idTrainer, users.idTrainer) &&
                Objects.equals(idClient, users.idClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsers, username, password, idManager, idTrainer, idClient);
    }

    @Override
    public String toString() {
        return "Users{" + username + " " + password + " " + idManager + " " + idTrainer + " " + idClient + '}';
    }
}
