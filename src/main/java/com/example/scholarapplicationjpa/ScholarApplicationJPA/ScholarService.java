package com.example.scholarapplicationjpa.ScholarApplicationJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScholarService
{

    @Autowired
    private  ScholarRepository scholarRepository;

    public String addScholar(ScholarDetails scholar){
        scholarRepository.save(scholar);
        return "successfully added!......";
    }

    public String updateScholar(String id,String name){
       ScholarDetails scholar = scholarRepository.findByScholarId(id);
       scholar.setScholarName(name);
       scholarRepository.save(scholar);
        return "successfully updated!......";
    }

    public String deleteScholar(String id){
        scholarRepository.deleteByScholarId(id);
        return "successfully removed!......";
    }

    public List<ScholarDetails> getScholars(){
        return scholarRepository.findAll();
    }

    public ScholarDetails getScholar(String id)
    {
        return scholarRepository.findByScholarId(id);
    }

}
