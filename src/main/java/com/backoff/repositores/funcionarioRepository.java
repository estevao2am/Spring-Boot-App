package com.backoff.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backoff.models.funcionario;

public interface funcionarioRepository extends JpaRepository<funcionario,Long> {

}
