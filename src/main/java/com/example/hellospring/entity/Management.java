package com.example.hellospring.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Management {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String title;
    private String description;
    private  int status;
    private  String thumbnail;
    private String category;
    private String content;

   @CreationTimestamp
   private Date createdAt;

   @CreationTimestamp
   private Date updatedAt;

    public Management(String title, String description, int status, String thumbnail, String category, String content) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.thumbnail = thumbnail;
        this.category = category;
        this.content = content;
    }
}
