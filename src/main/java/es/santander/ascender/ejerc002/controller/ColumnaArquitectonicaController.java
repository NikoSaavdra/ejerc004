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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejerc002.model.ColumnaArquitectonica;
import es.santander.ascender.ejerc002.service.ColumnaArquitectonicaService;

@RestController
@RequestMapping("/api/columna")
public class ColumnaArquitectonicaController {

    @Autowired
    private ColumnaArquitectonicaService columnaArquitectonicaService;

    @PostMapping
    public ColumnaArquitectonica create(@RequestBody ColumnaArquitectonica columnaArquitectonica) {
        return columnaArquitectonicaService.create(columnaArquitectonica);
    }

    @GetMapping("/{id}")
    public ColumnaArquitectonica read(@PathVariable("id") Long id) {
        return columnaArquitectonicaService.read(id);
    }
    
    @GetMapping
    public List<ColumnaArquitectonica> list() {
        return columnaArquitectonicaService.read();
    }

    @PutMapping
    public ColumnaArquitectonica update(@RequestBody ColumnaArquitectonica columnaArquitectonica) {
        return columnaArquitectonicaService.update(columnaArquitectonica);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        columnaArquitectonicaService.delete(id);
    }
}
