package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Course;
import lv.venta.service.ICourseFilteringService;

@Controller
@RequestMapping("/course")
public class CourseFilterController {

	@Autowired
	private ICourseFilteringService courseFilterService;
	
	@GetMapping("/filter/creditpoints/{param}") // localhost:8080/course/filter/creditpoints/{param}
	public String getCourseFilterByCreditpoints(@PathVariable("param") int param, Model model) {
		try {
			ArrayList<Course> selectedCourses = courseFilterService.selectCoursesByCreditpoints(param);
			model.addAttribute("mydata", selectedCourses);
			model.addAttribute("msg", "Courses filtered by creditpoints");
			return "course-show-all-page";
		} catch (Exception e) {
			model.addAttribute("", e.getMessage());
			return "error-page";
		}
	}
	

	@GetMapping("/filter/professor/{id}") //localhost:8080/course/filter/professor/{id}
	public String getCourseFilterByProfessorId(@PathVariable("id") int id, Model model) {

		try
		{
			Course selectedCourse = courseFilterService.selectCourseByProfessorID(id);
			model.addAttribute("mydata", selectedCourse);
			model.addAttribute("msg", "Course filtered by professor");
			return "course-show-one-page";
		}catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}

	}
	
	
	@GetMapping("/filter/student/{id}") // localhost:8080/course/filter/student/{id}
	public String getCoursesFiltredByStudentId(@PathVariable("id") int id, Model model) {
		try {
			ArrayList<Course> selectedCourses = courseFilterService.selectCoursesByStudentID(id);
			model.addAttribute("mydata", selectedCourses);
			model.addAttribute("msg", "Courses filtered by student id");
			return "course-show-all-page";
		} catch (Exception e) {
			model.addAttribute("", e.getMessage());
			return "error-page";
		}
	}
	
	
	
}
