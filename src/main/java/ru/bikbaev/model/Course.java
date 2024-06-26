package ru.bikbaev.model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private  int id;

    private String title;

    private String duration;




    public Course(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }


    public Course() {
    }

}
