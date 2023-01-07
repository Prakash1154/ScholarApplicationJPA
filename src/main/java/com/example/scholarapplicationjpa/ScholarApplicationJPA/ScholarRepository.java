package com.example.scholarapplicationjpa.ScholarApplicationJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ScholarRepository extends JpaRepository<ScholarDetails,Long>
{
    ScholarDetails findByScholarId(String id);

    @Modifying
    @Transactional
    public void deleteByScholarId(String id);

}
