package com.github.sejoung;

import com.github.sejoung.network.NetworkInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

  @Autowired
  NetworkInfo networkInfo;

  @Test
  public void contextLoads() {

    System.out.println(networkInfo.getIps());

  }

}