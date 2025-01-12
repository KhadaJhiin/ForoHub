package com.jdev.ForoHub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        //Long idUsuario,
        @NotBlank
        String mensaje,
        @NotBlank
        String nombreCurso,
        @NotBlank
        String titulo) {
}
