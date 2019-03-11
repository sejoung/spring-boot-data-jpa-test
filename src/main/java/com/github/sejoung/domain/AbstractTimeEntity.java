package com.github.sejoung.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
  private void preUpdate() {
    LocalDateTime now = LocalDateTime.now();
    this.setUpdateDateTime(now);
  }
}
