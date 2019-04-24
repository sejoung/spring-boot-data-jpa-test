package com.github.sejoung.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "TB_SUMMARY_KCP")// 명시적으로 테이블을 지정할수 있음
public class SummaryKCP extends AbstractTimeEntity {

  @Id
  private String day;

  @Column
  private Long cnt;

  @Column
  private Long amount;

  @Column
  private Long cancelCnt;

  @Column
  private Long cancelAmount;

  @Builder
  private SummaryKCP(String day, Long cnt, Long amount, Long cancelCnt, Long cancelAmount) {
    this.day = day;
    this.cnt = cnt;
    this.amount = amount;
    this.cancelCnt = cancelCnt;
    this.cancelAmount = cancelAmount;
  }
}
