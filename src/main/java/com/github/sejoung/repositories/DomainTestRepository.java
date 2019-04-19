package com.github.sejoung.repositories;

import com.github.sejoung.domain.DomainTest;
import com.github.sejoung.model.DomainTestStatistics;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainTestRepository extends PagingAndSortingRepository<DomainTest, Long> {


	@Query(value = "SELECT new com.github.sejoung.model.DomainTestStatistics(dt.title , count(title) , min(dt.createDateTime)) from DomainTest as dt group by dt.title order by min(dt.createDateTime) desc ")
	List<DomainTestStatistics> getMinCreateDateGroupByTitle();


}
