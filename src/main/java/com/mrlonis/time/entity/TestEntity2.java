package com.mrlonis.time.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TEST_TABLE_2")
@Entity
public class TestEntity2 {
    @Id
    @Column(name = "ID", nullable = false, insertable = false, updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CREATED_DATETIME", nullable = false, insertable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdDatetime;

    @Column(name = "CREATED_USER", nullable = false, updatable = false)
    private String createdUser;

    @Column(name = "UPDATED_DATETIME", nullable = false, insertable = false)
    @UpdateTimestamp
    private ZonedDateTime updatedDatetime;

    @Column(name = "UPDATED_USER", nullable = false)
    private String updatedUser;
}
