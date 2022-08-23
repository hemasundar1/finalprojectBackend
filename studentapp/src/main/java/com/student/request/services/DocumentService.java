package com.student.request.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.request.models.Application_details;
import com.student.request.models.DocumentDetails;
import com.student.request.modelsDto.DocumentDto;
import com.student.request.repository.DocumentRepository;

@Service
public class DocumentService {

	
	@Autowired
	DocumentRepository docRepo;
	
	public Optional<DocumentDetails> getDet( int id){
		return docRepo.findById(id);
	}
	
	public String postDet(DocumentDto docDet,int appId) {
		
		DocumentDetails doc = new DocumentDetails(docDet.getAdharNum(),docDet.getAccountNum(),docDet.getIfscNum(),docDet.getBranch(),docDet.getRollNum());
		doc.setApplication_details(new Application_details(appId));
		if(docRepo.save(doc)!=null){
		  return "Successfully added document details";	
		}
		else {
			return  "Not, added Successfully";
		}
	}
	
	public String putDet(  DocumentDetails docDetails , int id) {
		
		Optional<DocumentDetails> docDet = docRepo.findById(id);
		DocumentDetails result = docDet.get();
		result.setAccountNum(docDetails.getAccountNum());
		result.setAdharNum(docDetails.getAdharNum());
		result.setBranch(docDetails.getBranch());
		result.setIfscNum(docDetails.getIfscNum());
		result.setRollNum(docDetails.getRollNum());
		if(docRepo.save(result) !=null) {
			return "Updated Successfully";
		}
		else {
			return  "Not Updated, something went wrong";
		}
	}
	
	public String deleteDet(int id) {
		try {
			docRepo.deleteById(id);
			return "Successfully deleted";
		}
		catch(Exception e) {
			return "Not deleted Successfully";
		}
	}
	
}
