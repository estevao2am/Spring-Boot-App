package com.backoff.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backoff.models.clients;

public interface clientRepository extends JpaRepository<clients,Long> {
	@Query(value="select id from clients where id =:id",nativeQuery=true)
	public Long exist(Long id);

}
