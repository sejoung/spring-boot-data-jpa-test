package com.github.sejoung.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@MappedSuperclass
public abstract class AbstractTimeEntity {

  @Setter(value = AccessLevel.PRIVATE)
  @Column(nullable = false)
  private LocalDateTime createDateTime;

  @Setter(value = AccessLevel.PRIVATE)
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
