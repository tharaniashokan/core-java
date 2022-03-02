package com.springprogram.demospringprogram;

import java.util.List;

import  com.springprogram.demospringprogram.Laptop;

public interface LaptopServices {
	Laptop saveLaptop(Laptop laptop);
	 List <Laptop>getAllLaptop();
	 Laptop getLaptopById(long id);
	 Laptop updateLaptop (Laptop laptop , long id);
	 
	 
}
