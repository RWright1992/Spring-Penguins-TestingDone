package com.qa.penguin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.penguin.model.Penguin;

public interface PengRepo extends JpaRepository<Penguin, Long> {

}
