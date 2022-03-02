package com.springprogram.demospringprogram;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import  com.springprogram.demospringprogram.Laptop;
import  com.springprogram.demospringprogram.ResourceNotFound; 

import  com.springprogram.demospringprogram.LaptopRepository;
import  com.springprogram.demospringprogram.LaptopServices;


@Service
public class LaptopServiceImpl implements LaptopServices
{

	private  LaptopRepository laptopRepository;
	
	
	public LaptopServiceImpl(LaptopRepository laptopRepository) {
		super();
		this. laptopRepository = laptopRepository;
	}


	@Override
	public Laptop saveLaptop( Laptop  laptop) {
		return laptopRepository.save(laptop);
	}


	@Override
	public List< Laptop> getAllLaptop() {
		return laptopRepository.findAll();
		
	}


	@Override
	public  Laptop getLaptopById(long id) {
		Optional< Laptop>  laptop = laptopRepository.findById(id);
		if(laptop.isPresent()) {
			return laptop.get();
		}
		else {
          
			throw new ResourceNotFound(" Laptop","Id",id);
		}
		
	}


	@Override
	public Laptop updateLaptop( Laptop laptop, long id) {
		Laptop lap = new Laptop();
		 
	 try {
		   lap = laptopRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFound(" Laptop","Id",id));
	} catch (ResourceNotFound e) {
		
		e.printStackTrace();
	}
	 lap.setFirstName(laptop.getFirstName());
	 lap.setLastName( laptop.getLastName());
	 lap.setEmail(laptop.getEmail());
	 
	 laptopRepository.save(lap);
	return lap;
	}


	

}
