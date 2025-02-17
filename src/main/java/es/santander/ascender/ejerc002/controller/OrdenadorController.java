package es.santander.ascender.ejerc002.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejerc002.service.OrdenadorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ordenador")
public class OrdenadorController {

    @Autowired
    private OrdenadorService ordenadorService;

    @GetMapping("/{id}")
    public Ordenador read(@PathVariable("id") Long id) {
        return ordenadorService.read(id);
    }

    @GetMapping
    public List<Ordenador> list() {
        return ordenadorService.read();
    }

    @PostMapping
    public Ordenador create(@Valid @RequestBody Ordenador ordenador) {
        return ordenadorService.create(ordenador);
    }

    @PutMapping
    public Ordenador update(@Valid @RequestBody Ordenador ordenador) {
        return ordenadorService.update(ordenador);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        ordenadorService.delete(id);
    }
}
