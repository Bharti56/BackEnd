package com.doctorservice.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctorservice.entity.Doctor;

import com.doctorservice.service.DoctorService;

@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {
	
	
	
	@Autowired
    private DoctorService doctorService;
	

	
    @PostMapping("/")//ADD DOCTOR
    public String registerDoctor(@RequestBody Doctor doctor) {
    	return doctorService.registerDoctor(doctor);
        
    }
    
    
  
    
    @GetMapping("/getAllDoctors") //GETALLDOCTOR
    public List<Doctor> findAllDoctors() {
        return doctorService.findAll();
    }
    
   
    
    @GetMapping("/{id}") //GET BY DOCTOR
	public Doctor fetchDoctorById(@PathVariable("id")Long doctId){
		
		return doctorService.fetchDoctorById(doctId);
		
	}
    
    @GetMapping("/docName/{docName}")//GET DOCTOR BY NAME
	public Doctor fetchDoctorByName(@PathVariable("docName")String docName){
		
		return doctorService.fetchDoctorByName(docName);
		}
    
  
    
    @PutMapping("/{id}")//UPDATE DOCTOR INFORMATION
   	public Doctor updateDoctor(@PathVariable("id") Long doctId, 
   											@RequestBody Doctor doctor) {
   		 
   		 return doctorService.updateDoctor(doctId,doctor);
   		 	}
    
    @DeleteMapping("/{id}")//Delete a Doctor
	public List<Doctor> deleteDoctorById(@PathVariable("id")Long doctId) {
		return doctorService.deleteDoctorById(doctId);
		
	}
    
    
    

}
