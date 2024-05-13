package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer>{

	ArrayList<Course> findByCreditpoints(int creditpoints);

	Course findByProfessorIdp(int id);

	ArrayList<Course> findByGradeStudentIds(int id);

}
