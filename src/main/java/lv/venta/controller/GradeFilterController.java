package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import lv.venta.model.Grade;
import lv.venta.service.IGradesFilteringService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/grade/filter")
public class GradeFilterController {

	@Autowired
	private IGradesFilteringService gradeFilterService;
	
	@GetMapping("/failed") // localhost:8080/grade/filter/failed
	public String getGradesFiltredByFailedGrades(Model model) {
		try {
			ArrayList<Grade> selectGrades = gradeFilterService.selectFailedGrades();
			model.addAttribute("mydata", selectGrades);
			model.addAttribute("msg", "Failed grades");
			return "grades-show-all-page";
		} catch (Exception e) {
			model.addAttribute("", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/student/{id}") // localhost:8080/grade/filter/student/{id}
	public String getAllGradesByStudentID(@PathVariable("id") int id, Model model) {
		try {
			ArrayList<Grade> selectGrades = gradeFilterService.allGradesByStudentID(id);
			model.addAttribute("mydata", selectGrades);
			model.addAttribute("msg", "All student grades");
			return "grades-show-all-page";
		} catch (Exception e) {
			model.addAttribute("", e.getMessage());
			return "error-page";
		}
	}
	
	

	@GetMapping("/avg/course/{id}") //localhost:8080/grade/filter/avg/course/{id}
	public String getGradeFilterAVGByCourseId(@PathVariable("id") int id, Model model) {
		try
		{
			float avgGrades = gradeFilterService.calculateAVGGradeInCourseID(id);
			model.addAttribute("msg", "Avg grade: " + avgGrades);
			return "grades-show-all-page";
		}
		catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";

		}
	}
	
	
}
