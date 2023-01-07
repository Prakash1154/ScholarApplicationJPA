package com.example.scholarapplicationjpa.ScholarApplicationJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScholarController
{
    @Autowired
    private ScholarService scholarService;

    @GetMapping("getScholars")
    public List<ScholarDetails> getscholars(){
        return scholarService.getScholars();
    }
    @GetMapping("getScholar")
    public ScholarDetails getscholar(@RequestParam
                                         String id){
        return scholarService.getScholar(id);
    }
    @PostMapping("addScholars")
    public String addscholars(@RequestBody ScholarDetails scholar){
        return scholarService.addScholar(scholar);
    }
    @PutMapping("updateScholars")
    public String updatescholars(@RequestParam String id,String name){
        return scholarService.updateScholar(id,name);
    }
    @DeleteMapping("removeScholars")
    public String removeScholars(String id){
        return scholarService.deleteScholar(id);
    }



}
