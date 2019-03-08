package com.github.sejoung.repositories;

import com.github.sejoung.domain.DomainTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestRepositoryDomainDomainTest {

    @Resource
    private DomainTestRepository repository;

    @Test
    public void insertTest() {

        var dt = DomainTest.builder().title("test").build();
        var saveDt = repository.save(dt);

        var selectDtOptional = repository.findById(saveDt.getId());

        //Assert.isTrue(selectDtOptional.isPresent(), "값이 정확히 들어감");
        log.debug(saveDt.getCreateDateTime().toString());
        log.debug(selectDtOptional.get().getCreateDateTime().toString());

        repository.delete(saveDt);
    }

}