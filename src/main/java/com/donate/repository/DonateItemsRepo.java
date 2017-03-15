package com.donate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.donate.model.DonateItems;

@Repository
public interface DonateItemsRepo extends CrudRepository<DonateItems,Long> {

//	   public EmailTemplate findById(long id);
	
}
