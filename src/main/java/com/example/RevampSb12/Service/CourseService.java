package com.example.RevampSb12.Service;

import com.example.RevampSb12.Model.CourseModel;
import com.example.RevampSb12.Repository.CourseRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public CourseModel createCourse(CourseModel courseModel){
        return courseRepository.save(courseModel);
    }

    public String createCourseDetails(CourseModel courseModel){
        courseRepository.save(courseModel);
        return "Course Added Successfully";
    }
    public List<CourseModel> addAllCourse(List<CourseModel> courseModels){
        return courseRepository.saveAll(courseModels);
    }
    public String deleteCourseDetailsById(int Id){
        courseRepository.deleteById(Id);
        return "Course Deleted Successfully";
    }
    public String deleteAllCourse(){
        courseRepository.deleteAll();
        return "All Deleted";
    }
    public CourseModel getCourseDetails(int Id){
        return courseRepository.findById(Id).orElse(null);
    }
    public List<CourseModel> getAll(){
        return courseRepository.findAll();
    }
    public CourseModel updateCourse(int id,CourseModel newData){
        CourseModel oldData=courseRepository.findById(id).orElse(null);
        oldData.setCourseName(newData.getCourseName());
        oldData.setCourseDesc(newData.getCourseDesc());
        oldData.setCourseDuration(newData.getCourseDuration());
        oldData.setCourseFee(newData.getCourseFee());
        oldData.setCourseRatings(newData.getCourseRatings());

        return courseRepository.save(oldData);

    }
}
