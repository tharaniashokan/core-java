package com.springprogram.demospringprogram;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springprogram.demospringprogram.Laptop;
import  com.springprogram.demospringprogram.LaptopServices;
@RestController
@RequestMapping("/api/computer")
public class LaptopController {
	private LaptopServices laptopService;

	public  LaptopController( LaptopServices  LaptopService) {
		super();
		this. laptopService = laptopService;
	}
	
	@PostMapping
	public ResponseEntity< Laptop> saveLaptop(@RequestBody Laptop laptop) {
		return new ResponseEntity< Laptop>(laptopService.saveLaptop(laptop),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Laptop> getAllLaptop()
	{
		return laptopService.getAllLaptop();
	}
	@GetMapping("{id}")
	public ResponseEntity<Laptop>getLaptopById(@PathVariable("id") long id) {
		return new ResponseEntity(laptopService.getLaptopById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Laptop> updateLaptop(@PathVariable("id") long id, @RequestBody  Laptop laptop){
		
		return new ResponseEntity<Laptop>(laptopService.updateLaptop(laptop, id),HttpStatus.OK);
		
	}
	
}
