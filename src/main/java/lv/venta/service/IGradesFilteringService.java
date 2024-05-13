package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Grade;

public interface IGradesFilteringService {
	
	public abstract ArrayList<Grade> selectFailedGrades() throws Exception;
	
	public abstract ArrayList<Grade> allGradesByStudentID(int id) throws Exception;
	
	public abstract float calculateAVGGradeInCourseID(int id) throws Exception;
	
}
