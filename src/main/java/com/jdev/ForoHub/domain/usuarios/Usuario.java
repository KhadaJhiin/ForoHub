package com.jdev.ForoHub.domain.usuarios;

import jakarta.persistence.*;

import java.util.Objects;

@Table(name="usuarios")
@Entity(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String login;
    private String clave;


    public Usuario(Long idUsuario, String login, String clave) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.clave = clave;
    }

    public Usuario() {
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public String getClave() {
        return clave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(idUsuario, usuario.idUsuario) && Objects.equals(login, usuario.login) && Objects.equals(clave, usuario.clave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, login, clave);
    }
}
