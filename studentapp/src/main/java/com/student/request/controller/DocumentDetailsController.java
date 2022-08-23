package com.student.request.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.request.services.DocumentService;
import com.student.request.models.DocumentDetails;
import com.student.request.modelsDto.DocumentDto;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DocumentDetailsController {
	
	@Autowired
	DocumentService docSer;
	
	
	@GetMapping("/docDetails")
	public Optional<DocumentDetails> getDocDet(@RequestParam(value="id", required = true) int id){
		return docSer.getDet(id);
		
	}
	
	@PutMapping("/docDetails")
	public String putDocDet( @RequestBody DocumentDetails docDetails ,@RequestParam(value="id", required=true) int id) {
		return docSer.putDet(docDetails, id);
	}
	
	@PostMapping("/docDetails")
	public String postDocDet(@RequestBody DocumentDto docDet, @RequestParam(value ="id" , required = true) int appId) {
		return docSer.postDet(docDet,appId);
	}
	
	@DeleteMapping("/docDetails")
	public String deleteDocDet(@RequestParam(value="id", required = true) int id) {
		return docSer.deleteDet(id);
	}

}
