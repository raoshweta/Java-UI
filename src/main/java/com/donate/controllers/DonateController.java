package com.donate.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.donate.constants.Status;
import com.donate.model.DonateItems;
import com.donate.repository.DonateItemsRepo;

@Controller
public class DonateController {
	
	@Autowired
	DonateItemsRepo donateItemsRepo;

	 @RequestMapping(value = "/v1/create",method = RequestMethod.POST,produces="application/json",consumes="application/json")
	    public ResponseEntity<?> create(@RequestBody DonateItems donateItems){
		 donateItems.setName(donateItems.getName());
		 donateItems.setActive(true);
		 donateItems.setDescription(donateItems.getDescription());
		 donateItems.setStatus(Status.APPROVED);
		 donateItems.setTargetAge(donateItems.getTargetAge());
		 donateItems.setUpdatedOn(new Date());
		 donateItems.setCreatedDateTime(new Date());
		 donateItems = donateItemsRepo.save(donateItems);
		 HttpHeaders headers = new HttpHeaders();
		 headers.set("result", "success");
		 return new ResponseEntity<Object>(donateItems, headers, HttpStatus.OK);
		 
		    
	    }

	 @RequestMapping("/read/{id}")
	 public ResponseEntity<?> read(@PathVariable("id") Long id) {
		 DonateItems donateItems = donateItemsRepo.findOne(id);
		 HttpHeaders headers = new HttpHeaders();
		 headers.set("result", "success");
		 return new ResponseEntity<Object>(donateItems, headers, HttpStatus.OK);
	     
	 }
	 
	 @RequestMapping("/update/{id}/")
	 public ResponseEntity<?> update(@PathVariable("id") Long bookingId, @RequestParam String psngrName) {
		 DonateItems donateItems = donateItemsRepo.findOne(bookingId);
		 donateItems.setName(psngrName);
		 donateItems = donateItemsRepo.save(donateItems);
		 HttpHeaders headers = new HttpHeaders();
		 headers.set("result", "success");
		 return new ResponseEntity<Object>(donateItems, headers, HttpStatus.OK);
	 }
	 
	 @RequestMapping("/delete/{id}")
	 public String delete(@PathVariable("id") Long id) {
		 donateItemsRepo.delete(id);
	     return "booking #"+id+" deleted successfully";
	 }
	 
	 @RequestMapping("/read/")
	 public ResponseEntity<?> read() {
		 Iterable<DonateItems> donateItems = donateItemsRepo.findAll();
		 HttpHeaders headers = new HttpHeaders();
		 headers.set("result", "success");
		 return new ResponseEntity<Object>(donateItems, headers, HttpStatus.OK);
	     
	 }
	 
	 @RequestMapping("/map")
	    public String greeting() {
	        return "index";}


}
