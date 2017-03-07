package org.andys.repository;

import java.util.Date;

import org.andys.domain.Record;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends CrudRepository<Record,Long> {

	@Cacheable("byInterval")
	@Query("SELECT o FROM Record o WHERE o.date BETWEEN :from AND :to ORDER BY id")
	Iterable<Record> findByInterval(@Param("from") @Temporal Date from, @Param("to") @Temporal Date to);


}
