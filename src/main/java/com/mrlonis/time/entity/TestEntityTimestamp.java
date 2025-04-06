package com.mrlonis.time.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * This is a test entity that is used to test the application. It uses {@link Timestamp java.sql.Timestamp} as the data
 * type for the datetime fields.
 *
 * <p>This is done to show that the {@link Timestamp java.sql.Timestamp} data type is compatible with MySQL's TIMESTAMP
 * AND DATETIME data types. This is important because the application code does not need to change when the database
 * data type is changed from TIMESTAMP to DATETIME. Further evidence that this is a low-risk operation.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TEST_ENTITY_TIMESTAMP")
@Entity
public class TestEntityTimestamp {
    @Id
    @Column(name = "ID", nullable = false, insertable = false, updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CREATED_DATETIME", nullable = false, insertable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdDatetime;

    @Column(name = "CREATED_USER", nullable = false, updatable = false)
    private String createdUser;

    @Column(name = "UPDATED_DATETIME", nullable = false, insertable = false)
    @UpdateTimestamp
    private Timestamp updatedDatetime;

    @Column(name = "UPDATED_USER", nullable = false)
    private String updatedUser;
}
