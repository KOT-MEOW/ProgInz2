package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Grade;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IGradesFilteringService;

@Service
public class GradeFilterServiceImpl implements IGradesFilteringService{

	@Autowired
	private IGradeRepo gradeRepo;
	@Autowired
	private IStudentRepo studRepo;
	@Autowired
	private ICourseRepo courseRepo;
	
	
	@Override
	public ArrayList<Grade> selectFailedGrades() throws Exception {

		ArrayList<Grade> result = gradeRepo.findByGrvalueLessThan(4);
		
		if(result.isEmpty()) throw new Exception("No failed grades");
		
		return result;
	}

	@Override
	public ArrayList<Grade> allGradesByStudentID(int id) throws Exception {
		
		if(id < 1) throw new Exception("ID should be positive");
		
		if(!studRepo.existsById(id)) throw new Exception("Student with " + id + " doesn't exists");
		
		ArrayList<Grade> result = gradeRepo.findByStudentIds(id);
		
		if(result.isEmpty()) throw new Exception("There is no grades linkage to this Student");
		
		return result;
	}

	@Override
	public float calculateAVGGradeInCourseID(int id) throws Exception {
		
		if(id < 1) throw new Exception("ID should be positive");
		
		if(!courseRepo.existsById(id)) throw new Exception("Course with " + id + " doesn't exists");
		
		float result = gradeRepo.calculateAVGGradeInCourseById(id);
		
		if(result == 0) throw new Exception("There is no grade for this course");
		
		return result;
	}

}
