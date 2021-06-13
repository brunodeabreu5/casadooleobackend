package com.backend.casadooleobackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String user;
    private String password;

    public Usuario () {
    }

    public Usuario (int idUsuario, String user, String password) {
        this.idUsuario = idUsuario;
        this.user = user;
        this.password = password;
    }

    @Override
    public String toString () {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
