package com.jhonchaves.models;

import jakarta.persistence.*;


import java.io.Serializable;


@Entity
public class UsuarioModel implements  Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    private String userName;

    private String password;

    public UsuarioModel(){}

    public UsuarioModel(Long id,String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName(){return userName;}


    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword(){return  password;}

}
