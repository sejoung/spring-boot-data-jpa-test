package com.github.sejoung.repositories;

import com.github.sejoung.domain.SummaryKCP;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryKCPRepository extends PagingAndSortingRepository<SummaryKCP, String> {

	List<SummaryKCP> findAllList();

}
