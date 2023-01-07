package com.example.scholarapplicationjpa.ScholarApplicationJPA;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ScholarDetails {
    @Id
    @Column(name = "id",
        nullable = false)
    private long id;
    private String scholarId;
    private String scholarName;
    private int scholarAge;

}