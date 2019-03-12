package com.github.sejoung.repositories;


import com.github.sejoung.domain.DomainTest;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest // the test slice
@Slf4j
public class TestRepositoryDomainDomainTest {

  @Resource
  private DomainTestRepository repository;

  @Resource
  private TestEntityManager testEntityManager;

  @Test
  public void 조회테스트() {

    // given
    var dt = DomainTest.builder().title("test").build();
    testEntityManager.persistAndFlush(dt);

    //when
    var saveDt = repository.findById(dt.getId()).orElseThrow();

    //then
    //assertThat("같은 데이터를 가지고옴",isData,is(true));

    //초기화
    //repository.delete(saveDt);

    assertThat(saveDt).as("잘저장됨").isNotNull();

    assertThat(saveDt.getTitle()).as("타이틀").isEqualTo("test");
    assertThat(saveDt.getId()).as("id가 있어야 된다.").isEqualTo(1);
    assertThat(saveDt.getCreateDateTime()).as("생성일자가 있어야 된다").isNotNull();


  }

}