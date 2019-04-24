package com.github.sejoung.repositories;

import com.github.sejoung.domain.SummaryKCP;
import com.github.sejoung.domain.SummaryPay;
import com.github.sejoung.domain.SummaryPayKey;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryKCPRepository extends PagingAndSortingRepository<SummaryKCP, String> {


}
