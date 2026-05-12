package com.vcube.Crudprac.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.Crudprac.Model.Hoteldto;
@Repository
public interface Hotelrepointerface extends JpaRepository<Hoteldto,Integer>{

	Hoteldto getByhname(String hname);
	

}
