package com.backoff.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backoff.models.Categoria;

public interface categoriaRepository extends JpaRepository<Categoria, Long> {

}
