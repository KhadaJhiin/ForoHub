package com.jdev.ForoHub.controller;
import java.net.URI;


import com.jdev.ForoHub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getIdUsuario(),topico.getMensaje(),topico.getNombreCurso(),topico.getTitulo());
        URI url = uriComponentsBuilder.path("/topicos/{idUsuario}").buildAndExpand(topico.getIdUsuario()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity< Page<Topico> > listadoTopicos(@PageableDefault(size = 3,sort = "idUsuario") Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion)) ;
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.idUsuario());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok
                (new DatosRespuestaTopico(topico.getIdUsuario(),topico.getMensaje(),topico.getNombreCurso(),topico.getTitulo()));
    }

    @DeleteMapping("/{idUsuario}")
    @Transactional
    public ResponseEntity deleteTopico(@PathVariable Long idUsuario){
        Topico topico = topicoRepository.getReferenceById(idUsuario);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatoTopico(@PathVariable Long idUsuario){
        Topico topico = topicoRepository.getReferenceById(idUsuario);
        var datosTopico = new DatosRespuestaTopico(topico.getIdUsuario(),topico.getMensaje(),topico.getNombreCurso(),topico.getTitulo());
        return ResponseEntity.ok(datosTopico);
    }
}
