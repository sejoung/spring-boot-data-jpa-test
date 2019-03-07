package com.github.sejoung.repositories;

import com.github.sejoung.domain.DomainTest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestRepositoryDomainDomainTest {

    @Autowired
    private  DomainTestRepository repository;


    @Test
    public void insertTest(){

        var dt = DomainTest.builder().title("test").build();

        var saveDt = repository.save(dt);

        var selectDt = repository.findById(saveDt.getId());

        Assert.isTrue(selectDt.isPresent(),"값이 정확히 들어감");



    }

}