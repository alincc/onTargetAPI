package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.Countries;

public interface CountriesRepository extends JpaRepository<Countries,Integer>{

}
