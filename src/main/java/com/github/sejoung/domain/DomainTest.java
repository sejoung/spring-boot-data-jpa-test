package com.github.sejoung.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Entity
public class DomainTest extends AbstractTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 50, nullable = false)
  private String title;

  @Builder
  private DomainTest(String title) {
    this.title = title;
  }
}
