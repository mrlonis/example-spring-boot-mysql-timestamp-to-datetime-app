package com.mrlonis.time.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class BaseEntity<T> {
    @Id
    @Column(name = "ID", nullable = false, insertable = false, updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "TYPE", nullable = false, columnDefinition = "char(4)")
    private String type;

    @Column(name = "CODE", columnDefinition = "char(4)")
    private String code;

    @Column(name = "CREATED_DATETIME", nullable = false, insertable = false, updatable = false)
    @CreationTimestamp
    private T createdDatetime;

    @Column(name = "CREATED_USER", nullable = false, updatable = false)
    private String createdUser;

    @Column(name = "UPDATED_DATETIME", nullable = false, insertable = false)
    @UpdateTimestamp
    private T updatedDatetime;

    @Column(name = "UPDATED_USER", nullable = false)
    private String updatedUser;
}
