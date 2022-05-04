package com.example.hellospring.api;

import com.example.hellospring.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentApi {
    private  static List<Student> listStudent;
    static {
        listStudent = new ArrayList<>();
        listStudent.add(new Student("A001", "GIANG", "giagn2210@gmail.com",  "hadajd",1));
        listStudent.add(new Student("A002", "HUNG.", "giagn2210@gmail.com",  "fafasfs",2));
        listStudent.add(new Student("A003", "manh", "giagn2210@gmail.com",  "fsfsf",3));
        listStudent.add(new Student("A004", "son", "giagn2210@gmail.com",  "fsfsd",4));
        listStudent.add(new Student("A005", "tung", "giagn2210@gmail.com",  "fsfsf",5));
    }
    @RequestMapping(method = RequestMethod.GET)
    public  List<Student> getList( @RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "10") int limit){
        System.out.println("Page" +page);
        System.out.println("Limit" +limit);
        return listStudent;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/{rollNumber}")
    public  Student getDetail(@PathVariable String rollNumber){
        Student found= null;
        for (Student student:
                listStudent) {
            if (student.getRollNumber().equals(rollNumber)){
                found = student;
                break;
            }
        }
        return found;
    }

    @RequestMapping(method = RequestMethod.POST)
    public  Student save(@RequestBody Student student){
        listStudent.add(student);
        return student;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{rollNumber}")
    public  Student update(@PathVariable String rollNumber, @RequestBody Student updateStudent){
        Student found= null;
        for (Student student:
                listStudent) {
            if (student.getRollNumber().equals(rollNumber)){
                found = student;
                break;
            }
        }
        if (found!= null){
            found.setFullname(updateStudent.getFullname());
            found.setAddress(updateStudent.getAddress());
            found.setStatus(updateStudent.getStatus());
            found.setEmail(updateStudent.getEmail());
        }
        return found;
    }





    @RequestMapping(method = RequestMethod.DELETE, path = "/{rollNumber}")
    public  String delete(@PathVariable String rollNumber){
        Student found= null;
        for (Student student:
                listStudent) {
            if (student.getRollNumber().equals(rollNumber)){
                found = student;
                break;
            }
        }
        if (found!= null){
            listStudent.remove(found);
        }
        return "0kie";
    }

}