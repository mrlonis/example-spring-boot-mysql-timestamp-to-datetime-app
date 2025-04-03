package com.mrlonis.time.repository;

import com.mrlonis.time.entity.TestEntity2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEntity2Repository extends JpaRepository<TestEntity2, Long> {}
