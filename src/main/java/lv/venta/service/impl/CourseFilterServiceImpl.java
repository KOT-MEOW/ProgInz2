package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.ICourseFilteringService;

@Service
public class CourseFilterServiceImpl implements ICourseFilteringService{

	@Autowired
	private ICourseRepo courseRepo;
	@Autowired
	private IProfessorRepo profRepo;
	@Autowired
	private IStudentRepo studRepo;
	
	
	@Override
	public ArrayList<Course> selectCoursesByCreditpoints(int creditpoints) throws Exception {
		
		if(creditpoints < 1 || creditpoints > 20) throw new Exception("MIN creditpoints 1 MAX creditpoints 20");
		
		ArrayList<Course> result = courseRepo.findByCreditpoints(creditpoints);
		
		if(result.isEmpty()) throw new Exception("No courses with " + creditpoints + " creditpoints");
		
		return result;
	}

	@Override
	public Course selectCourseByProfessorID(int id) throws Exception {
		
		if(id < 1) throw new Exception("ID should be positive");
		
		if(!profRepo.existsById(id)) throw new Exception("Professor with " + id + " doesn't exists");
		
		Course result = courseRepo.findByProfessorIdp(id);
		
		if(result == null) throw new Exception("There is no course linkage to this Professor");
		
		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByStudentID(int id) throws Exception {
		
		if(id < 1) throw new Exception("ID should be positive");
		
		if(!studRepo.existsById(id)) throw new Exception("Student with " + id + " doesn't exists");
		
		ArrayList<Course> result = courseRepo.findByGradeStudentIds(id);
		
		if(result.isEmpty()) throw new Exception("There is no course linkage to this Student");
		
		return result;
	}

	
	
}
