package com.example.RevampSb12.Repository;

import com.example.RevampSb12.Model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel,Integer>{
}
