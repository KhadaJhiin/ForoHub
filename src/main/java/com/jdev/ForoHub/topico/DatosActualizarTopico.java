package com.jdev.ForoHub.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long idUsuario,
        String mensaje,
        String nombreCurso
) {
}
