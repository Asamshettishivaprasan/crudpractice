package com.vcube.Crudprac.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.Crudprac.Dao.Hotelrepointerface;
import com.vcube.Crudprac.Model.Hoteldto;
@Service
public class Hotelservice {
	@Autowired
	Hotelrepointerface  rep;
	//insert details
	public Hoteldto insertDet(Hoteldto hot) {
		return rep.save(hot);		
	}
	public List<Hoteldto>  getDet() {
		return rep.findAll();
	}
	public Hoteldto getbyId(int id) { //1
		return rep.findById(id).orElse(null);
	}
	
	public Hoteldto getbyhname(String hname) {
		return rep.getByhname(hname);
	}
	
    public Hoteldto updateHoteldet(Hoteldto obj,int id) {
    	Hoteldto ex=rep.findById(id).orElse(null);
    	ex.setHid(obj.getHid());
    	ex.setHname(obj.getHname());
    	ex.setHowner(obj.getHowner());
       return rep.save(ex);
    }
    
    public Hoteldto singleUpdate(Hoteldto obj,int id) {
    	Hoteldto singleup=rep.findById(id).orElse(null);
    	singleup.setHname(obj.getHname());
    	return rep.save(singleup);
    }
	
    public String delete(int id) {
    	rep.deleteById(id);
    	return +id+" record deleted successfully";
    }
	

}

//1
// ✅ Why Optional is Used?
//Optional is used because:
//👉 The record may or may not exist in the database.
//👉 If ID is not present, it avoids NullPointer
//Exception.
//✔️ Method 1 (Most Common – Use .orElse(null))
//
//public Hoteldto getbyId(int id) {
//    return rep.findById(id).orElse(null);
//}
//
//Method 2 (Better Practice – Throw Exception)
//
//public Hoteldto getbyId(int id) {
//    return rep.findById(id)
//              .orElseThrow(() -> new RuntimeException("Hotel not found"));
//}
//
//Method 3 (Return Optional Directly)
//public Optional<Hoteldto> getbyId(int id) {
//    return rep.findById(id);
//}

