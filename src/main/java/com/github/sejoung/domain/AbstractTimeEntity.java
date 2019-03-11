package com.github.sejoung.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@MappedSuperclass
public abstract class AbstractTimeEntity {

  @CreationTimestamp
  @Column(nullable = false)
  private LocalDateTime createDateTime;

  @UpdateTimestamp
  @Column(nullable = false)
  private LocalDateTime updateDateTime;



}
