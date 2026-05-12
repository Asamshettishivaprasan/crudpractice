package com.vcube.Crudprac.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.Crudprac.Model.Hoteldto;
import com.vcube.Crudprac.Service.Hotelservice;

@RestController
@RequestMapping("api/v1")
public class Hotelcontroller {
	@Autowired
	Hotelservice serv;
	@PostMapping("inserthotel")
	Hoteldto insertHotel(@RequestBody Hoteldto hot) {
		return serv.insertDet(hot);	
	}
	@GetMapping("alldetails")
	List<Hoteldto> getallDetails(){
		return serv.getDet();
	}
	
	@GetMapping("getbyid/{hid}")
	Hoteldto getbyId(@PathVariable("hid") int hid) {
		return serv. getbyId(hid);
	}
	@GetMapping("getbyname/{hname}")
	Hoteldto getbyName(@PathVariable("hname") String hname){
		return serv.getbyhname(hname);	
	}
	
	@PostMapping("updateAll/{hid}")
	Hoteldto updateAll(@RequestBody Hoteldto hot,@PathVariable("hid") int hid){
		return serv.updateHoteldet(hot, hid);
	}
	
	@PatchMapping("updatebyid/{hid}")  //it is used for just updating single value instead of all data
	Hoteldto updateByID(@RequestBody Hoteldto hot,@PathVariable("hid") int hid) {
		return serv.singleUpdate(hot,hid);
	}
	@DeleteMapping("deletebyid/{hid}")
	String deleteByid(@PathVariable("hid") int hid) {
		return serv.delete(hid);
	}

	
}
