package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Course;

public interface ICourseFilteringService {
	
	public abstract ArrayList<Course> selectCoursesByCreditpoints(int creditpoints) throws Exception;
	
	public abstract Course selectCourseByProfessorID(int id) throws Exception;
	
	public abstract ArrayList<Course> selectCoursesByStudentID(int id) throws Exception;
	
	
	
}
