package com.poslovna.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poslovna.model.Bank;
import com.poslovna.model.Clearing;
import com.poslovna.service.ClearingService;
import com.poslovna.service.ClearingXml;



@CrossOrigin
@RestController
@RequestMapping(value = "/clearing")
public class ClearingController {

	
	
	@Autowired
	private ClearingService clearingService;
	
	
	@PostMapping("/generateClearing")
	public ResponseEntity<Void> generateClearing( @RequestBody Bank bank) throws JAXBException{
		
		List<Clearing> clearings = clearingService.getClearings();
		for(Clearing clearing : clearings) {
			if(!clearing.isDone() && (clearing.getBankfrom().getId() == bank.getId() || clearing.getBankto().getId() == bank.getId())) {
				generateClearingXml(clearing);
				clearing.setDone(true);
				clearingService.saveClearing(clearing);
			}
		}
		return new ResponseEntity<Void>(HttpStatus.OK);		
	}
	
	
	private void generateClearingXml(Clearing clearing) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(ClearingXml.class);
		Marshaller m = jaxbContext.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		File file =new File("filesxml//clearing//clearing" +clearing.getId()+".xml");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		m.marshal(new ClearingXml(clearing), file );
	}
	
	
	
	
}
