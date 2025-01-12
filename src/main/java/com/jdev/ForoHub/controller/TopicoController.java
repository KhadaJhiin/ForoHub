package com.jdev.ForoHub.controller;
import java.util.List;

import com.jdev.ForoHub.topico.DatosActualizarTopico;
import com.jdev.ForoHub.topico.DatosRegistroTopico;
import com.jdev.ForoHub.topico.Topico;
import com.jdev.ForoHub.topico.TopicoRepository;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        topicoRepository.save(new Topico(datosRegistroTopico));
    }

    @GetMapping
    public Page<Topico> listadoTopicos(@PageableDefault(size = 3,sort = "idUsuario") Pageable paginacion){
        return topicoRepository.findAll(paginacion);
    }

    @PutMapping
    @Transactional
    public void updateTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.idUsuario());
        topico.actualizarDatos(datosActualizarTopico);
    }

    @DeleteMapping("/{idUsuario}")
    @Transactional
    public void deleteTopico(@PathVariable Long idUsuario){
        Topico topico = topicoRepository.getReferenceById(idUsuario);
        topicoRepository.delete(topico);
    }
}
