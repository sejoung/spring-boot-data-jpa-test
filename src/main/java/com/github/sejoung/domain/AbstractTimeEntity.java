package com.github.sejoung.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractTimeEntity {

    @Column(nullable = false)
    private LocalDateTime createDateTime;

    @Column(nullable = false)
    private LocalDateTime updateDateTime;

    @PrePersist
    private void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.setCreateDateTime(now);
        this.setUpdateDateTime(now);
    }

    @PreUpdate
    private void preUpdate(){
        LocalDateTime now = LocalDateTime.now();
        this.setUpdateDateTime(now);
    }
}
