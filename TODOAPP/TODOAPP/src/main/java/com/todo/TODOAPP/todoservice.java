package com.todo.TODOAPP;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.persistence.EntityNotFoundException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
@Service
public class todoservice {
	@Autowired 
	private todorepo repo;

	public todoent post(todoent ent) {
		
		return repo.save(ent);
	}

	public Optional<todoent> getById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public List<todoent> getevery() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public todoent update(Long id, todoent ent) {
		// TODO Auto-generated method stub
		todoent en=repo.findById(id).orElseThrow(()->new EntityNotFoundException("ENTITY WITH GIVEN ID IS NOT FOUND"));
		en.setId(ent.getId());
		en.setStatus(ent.getStatus());
		en.setTitle(ent.getTitle());
		
		return repo.save(en);
	
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		 repo.deleteById(id);
	}
	
	public byte[] generatereport() throws JRException {
		Collection<todoent> entity=repo.findAll();
		
JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\Dell\\Downloads\\TODOAPP\\TODOAPP\\src\\main\\resources\\templates\\list.jrxml");
JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(entity);

// Fill the report with data and parameters

// JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

// Export the report to a byte array
return JasperExportManager.exportReportToPdf(jasperPrint);
	
		
		
	}
}
