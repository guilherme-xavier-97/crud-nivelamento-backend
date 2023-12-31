package com.guilherme.crud_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guilherme.crud_backend.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    
}
