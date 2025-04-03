package com.mrlonis.time.repository;

import com.mrlonis.time.entity.TestEntity1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEntity1Repository extends JpaRepository<TestEntity1, Long> {}
