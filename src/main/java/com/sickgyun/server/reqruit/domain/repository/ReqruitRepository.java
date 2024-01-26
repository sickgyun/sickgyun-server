package com.sickgyun.server.reqruit.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sickgyun.server.reqruit.domain.Reqruit;

public interface ReqruitRepository extends JpaRepository<Reqruit, Long> {
}
