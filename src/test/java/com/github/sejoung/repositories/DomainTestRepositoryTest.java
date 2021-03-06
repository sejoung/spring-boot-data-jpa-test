package com.github.sejoung.repositories;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import com.github.sejoung.domain.DomainTest;
import java.util.stream.IntStream;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest // the test slice
@Slf4j
public class DomainTestRepositoryTest {

	@Resource
	private DomainTestRepository repository;

	@Resource
	private TestEntityManager testEntityManager;

	@Test
	public void 조회테스트() {

		// given
		IntStream.range(1, 10).forEach((i) -> {

		});
		var dt = DomainTest.builder().title("test").build();
		testEntityManager.persistAndFlush(dt);

		//when
		var saveDt = repository.findById(dt.getId()).orElseThrow();

		//then
		assertThat(saveDt.getTitle()).as("타이틀이 저장된 값과 조회된 값이 같아야 된다.").isEqualTo("test");
		assertThat(saveDt.getId()).as("id가 있어야 된다.").isNotNull();
		assertThat(saveDt.getCreateDateTime().toLocalDate()).as("저장된 생성일자와 조회된 생성일자가 같아야 된다.")
				.isEqualTo(dt.getCreateDateTime().toLocalDate());

		Assert.assertThat("타이틀이 저장된 값과 조회된 값이 같아야 된다.", saveDt.getTitle(), is("test"));
	}

	@Test
	public void 통계조회테스트() {

		// given
		IntStream.range(1, 10).forEach((i) -> {
			var dt = DomainTest.builder().title("test").build();
			testEntityManager.persistAndFlush(dt);
		});

		//when
		var data = repository.getMinCreateDateGroupByTitle().get(0);

		//then
		assertThat(data.getTitle()).as("타이틀이 저장된 값과 조회된 값이 같아야 된다.").isEqualTo("test");
		assertThat(data.getSuccessCount()).as("조회된 count는 9이여야 한다.").isEqualTo(9);


	}


}