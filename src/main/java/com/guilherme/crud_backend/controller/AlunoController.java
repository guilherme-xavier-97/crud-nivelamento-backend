package com.guilherme.crud_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.crud_backend.model.Aluno;
import com.guilherme.crud_backend.service.AlunoService;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> createOnController(@RequestBody Aluno aluno) {
        alunoService.createOnService(aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @GetMapping
    public List<Aluno> readAllOnController() {
        return alunoService.readAllOnService();
    }

    @GetMapping("/{id}")
    public Optional<Aluno> readOneOnController(@PathVariable Integer id) {
        return alunoService.readOneOnService(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOnController(@PathVariable Integer id) {
        alunoService.deleteOnService(id);
        return ResponseEntity.ok().body("Aluno "+id+" removido com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateOnController(@RequestBody Aluno aluno, @PathVariable Integer id) {
        return alunoService.updateOnService(aluno, id);
    }
}
