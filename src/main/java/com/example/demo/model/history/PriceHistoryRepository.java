package com.example.demo.model.history;

import org.springframework.data.repository.CrudRepository;

public interface PriceHistoryRepository extends CrudRepository<HistoricalPrice, Long> {
	

}