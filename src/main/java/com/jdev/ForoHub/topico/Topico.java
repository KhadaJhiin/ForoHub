package com.jdev.ForoHub.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Table(name="topicos")
@Entity(name="topico")
//@Getter
//@AllArgsConstructor
//@EqualsAndHashCode(of = "idUsuario")

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String mensaje;
    @Column(name = "nombreCurso")
    private String nombreCurso;
    private String titulo;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.mensaje = datosRegistroTopico.mensaje();
        this.nombreCurso = datosRegistroTopico.nombreCurso();
        this.titulo = datosRegistroTopico.titulo();
    }
    public Topico(){}

    public Topico(Long idUsuario, String mensaje, String nombreCurso, String titulo) {
        this.idUsuario = idUsuario;
        this.mensaje = mensaje;
        this.nombreCurso = nombreCurso;
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topico topico = (Topico) o;
        return Objects.equals(idUsuario, topico.idUsuario) && Objects.equals(mensaje, topico.mensaje) && Objects.equals(nombreCurso, topico.nombreCurso) && Objects.equals(titulo, topico.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, mensaje, nombreCurso, titulo);
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.nombreCurso() != null){
            this.nombreCurso = datosActualizarTopico.nombreCurso();
        }
    }
}
