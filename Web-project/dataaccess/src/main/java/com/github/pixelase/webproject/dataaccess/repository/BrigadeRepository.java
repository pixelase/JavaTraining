package com.github.pixelase.webproject.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.pixelase.webproject.dataaccess.model.Brigade;

public interface BrigadeRepository extends JpaRepository<Brigade, Integer> {

}