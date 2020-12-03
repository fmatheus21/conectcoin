package com.firecode.app.model.repository;

import com.firecode.app.model.entity.BancoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends JpaRepository<BancoEntity, Integer> {

}
