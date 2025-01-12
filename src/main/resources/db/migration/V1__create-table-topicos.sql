CREATE TABLE topicos(
    idUsuario bigint NOT NULL auto_increment,
    mensaje VARCHAR(100) NOT NULL,
    nombreCurso VARCHAR(100) NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    PRIMARY KEY(idUsuario)
);