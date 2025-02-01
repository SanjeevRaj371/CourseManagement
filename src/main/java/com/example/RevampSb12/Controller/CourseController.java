package com.example.RevampSb12.Controller;

import com.example.RevampSb12.Model.CourseModel;
import com.example.RevampSb12.Repository.CourseRepository;
import com.example.RevampSb12.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Course")
@RestController
public class CourseController {


    @Autowired
    CourseRepository courseRepository;
    //Bean Creation
    @Autowired
    CourseService courseService;

    @PostMapping("/addCourse")
    public CourseModel addCourse(@RequestBody CourseModel courseModel){
        return courseService.createCourse(courseModel);
    }
    @PostMapping("/addCourseDetails")
    public String addCourseDetails(@RequestBody CourseModel courseModel){
        return courseService.createCourseDetails(courseModel);
    }
    @PostMapping("/addAllCourse")
    public List<CourseModel> addAllCourse(@RequestBody List<CourseModel> courseModels){
        return courseService.addAllCourse(courseModels);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public String deleteCourseDetailsById(@PathVariable int id){
        return courseService.deleteCourseDetailsById(id);
    }
    @DeleteMapping("/deleteAllCourse")
    public String deleteAllCourse(){
        return courseService.deleteAllCourse();
    }
    @GetMapping("/getCourse/{id}")
    public CourseModel getCourseDetails(@PathVariable int id){
        return courseService.getCourseDetails(id);
    }
    @GetMapping("/getAll")
    public List<CourseModel> getAll(){
        return courseService.getAll();
    }
    @PostMapping("/update/{id}")
    public CourseModel updateCourse(@PathVariable int id,@RequestBody CourseModel courseModel){
        return  courseService.updateCourse(id,courseModel);
    }
    @PostMapping("/courseOffer/{offer}/{name}")
    public String giveCourseOffer(@PathVariable double offer,@PathVariable String name){
        courseRepository.giveCourseOffer(offer,name);
        return "Offer applied ";
    }
    @GetMapping("/getCLesserThanAmount/{amount}")
    public List<CourseModel> getCLesserThanAmount(@PathVariable double amount) {
        return courseRepository.getCLesserThanAmount(amount);
    }
    @GetMapping("/search/{name}")
    public List<CourseModel>searchCourse(@PathVariable String name){
        return courseRepository.searchCourse(name);
    }
    @GetMapping("/sortByCName")
    public List<CourseModel>sortByCName(){
        return courseRepository.sortByCName();
    }

}
