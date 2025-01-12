package com.jdev.ForoHub.domain.topico;

public record DatosRespuestaTopico(
        Long idUsuario,
        String mensaje,
        String nombreCurso,
        String titulo
) {
}
