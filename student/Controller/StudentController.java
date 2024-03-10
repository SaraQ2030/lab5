package org.example.student.Controller;
import org.example.student.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    ArrayList<Student> students=new ArrayList<>();

    @GetMapping("/display")
    public ArrayList<Student> getStudent(){
        return students;
    }
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Student added successfully ";

    }
    @PutMapping("/update/{index}")
    public String updateStudent(@PathVariable int index ,@RequestBody Student s){
        students.set(index,s);
        return "Student Updated successfully ";
    }

    @DeleteMapping("/delete/{index}")
    public String deleteStudent(@PathVariable int index){
        students.remove(index);
        return "Student deleted successfully ";
    }
    @GetMapping("/search/name/{name}")
    public String searchNameStudent(@PathVariable String name){
        for (Student s:students){
            if (s.getName().equalsIgnoreCase(name)){
                return "Name found "+ "\n"+"The name :"+s.getName()+"\n"+"The degree :"+s.getDegree()+"\n"+"The Age :"+s.getAge()+"\n"+"The Status :"+s.getStatus();
                       }
        }
        return "Name of student not found ";
    }

    @GetMapping("/search/age/{age}")
    public String searchAgeStudent(@PathVariable int age){
        for (Student s:students){
            if (s.getAge()==age){
                return "Age is found "+ s;
            }
        }
        return "Try Again";
    }

    @GetMapping("/degree/{degree}")
    public String searchDegree(@PathVariable String degree){
        for (Student s:students){
           if (s.getDegree().equalsIgnoreCase(degree)){
                return "the degree found : "+s;
            }
        }
return "the degree not found ";
    }

    @GetMapping("/search/{st}/{name}")
    public String searchStatus(@PathVariable String st,@PathVariable String name){

            for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                if (s.getStatus().equalsIgnoreCase(st)) {
                    return "true  " + s + "\n";
                } else {
                    return "false  " + s + "\n";
                }
            }}
                return "not found ";
    }


}
