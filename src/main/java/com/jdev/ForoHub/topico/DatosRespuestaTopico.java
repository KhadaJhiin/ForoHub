package com.jdev.ForoHub.topico;

public record DatosRespuestaTopico(
        Long idUsuario,
        String mensaje,
        String nombreCurso,
        String titulo
) {
}
