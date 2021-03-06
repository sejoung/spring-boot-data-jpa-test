package com.github.sejoung.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Entity// 같은 엔티티가 2개 있을때 구분을 위해 이름을 선언함
@Table(name = "TB_TEST")// 명시적으로 테이블을 지정할수 있음
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
