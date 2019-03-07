package com.github.sejoung.repositories;

import com.github.sejoung.domain.DomainTest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainTestRepository extends PagingAndSortingRepository<DomainTest,Long> {

}
