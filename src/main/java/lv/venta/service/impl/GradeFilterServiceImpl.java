package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Grade;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IGradesFilteringService;

@Service
public class GradeFilterServiceImpl implements IGradesFilteringService{

	@Autowired
	private IGradeRepo gradeRepo;
	@Autowired
	private IStudentRepo studRepo;
	
	
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
		
		// add code here >
		
		return null;
	}

	@Override
	public float calculateAVGGradeInCourseID(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
