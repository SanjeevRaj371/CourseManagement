package com.example.RevampSb12.Repository;

import com.example.RevampSb12.Model.CourseModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel,Integer>{
    @Transactional
    @Modifying
    @Query("Update CourseModel c SET c.disCountedFee = c.disCountedFee - c.disCountedFee * :offer where c.courseName Like CONCAT('%',:name,'%')")
    void giveCourseOffer(double offer, String name);

    @Query("Select c from CourseModel c where c.courseFee < :amount")
    List<CourseModel> getCLesserThanAmount(double amount);

    @Query("Select c from CourseModel c where c.courseName = :name")
    List<CourseModel>searchCourse(String name);

    @Query("Select c from CourseModel c ORDER BY c.courseName ASC")
    List<CourseModel>sortByCName();
}
