package com.guilherme.crud_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.guilherme.crud_backend.model.Aluno;
import com.guilherme.crud_backend.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public ResponseEntity<Aluno> createOnService(Aluno aluno) {
        alunoRepository.save(aluno);
        return ResponseEntity.ok().body(aluno);

    }

    public ResponseEntity<Aluno> updateOnService(Aluno aluno, Integer id) {
        return alunoRepository.findById(id)
           .map(registro -> {
               registro.setNome(aluno.getNome());
               registro.setEmail(aluno.getEmail());
               registro.setCurso(aluno.getCurso());
               Aluno updatedAluno = alunoRepository.save(registro);
               return ResponseEntity.ok().body(updatedAluno);
           }).orElse(ResponseEntity.notFound().build());

    }

    public List<Aluno> readAllOnService() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> readOneOnService(Integer id) {
        if(alunoRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return alunoRepository.findById(id);

    }

    public ResponseEntity<?> deleteOnService(Integer id) {
        if(alunoRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        alunoRepository.deleteById(id);
        return ResponseEntity.ok("Aluno"+id+"removido com sucesso");
    }

    
}
