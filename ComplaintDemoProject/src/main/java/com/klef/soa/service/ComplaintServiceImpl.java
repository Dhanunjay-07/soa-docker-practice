package com.klef.soa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Complaint;
import com.klef.soa.repository.ComplaintRepository;

@Service
public class ComplaintServiceImpl implements ComplaintService 
{
    @Autowired
	private ComplaintRepository repo;
	@Override
	public Complaint addComplaint(Complaint complaint) {
		return repo.save(complaint);
	}

	@Override
	public List<Complaint> displayAllComplaints()
	{
		return repo.findAll();
	}

	@Override
	public Complaint updateComplaint(Long id,Complaint complaint ) 
	{
		Complaint comp=repo.findById(id).orElse(null);
		if(comp!=null)
		{
		comp.setName(complaint.getName());
		comp.setType(complaint.getType());
		comp.setLocation(complaint.getLocation());
		comp.setStatus(complaint.isStatus());
		return repo.save(comp);
		}
		return null;
	}

	@Override
	public Complaint displayComplaintById(Long id)
	{
		return repo.findById(id).orElse(null);
	}

	@Override
	public String deleteComplaintById(Long id) 
	{
		
		Complaint complaint=repo.findById(id).orElse(null);
		repo.delete(complaint);
		return "Succesfully Deleted ";
	}

	@Override
	public List<Complaint> displayComplaintByName(String name)
	{
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}

	@Override
	public List<Complaint> displayComplaintByType(String type) {
		// TODO Auto-generated method stub
		return repo.findByType(type);
	}

}
