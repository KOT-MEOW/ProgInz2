package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;

@SpringBootApplication
public class ProgInzSem2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgInzSem2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner testDB(IProfessorRepo profRepo, IStudentRepo studRepo, ICourseRepo courseRepo, IGradeRepo gradeRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				Professor p1 = new Professor("Ilja", "Avlass", Degree.phd);
				Professor p2 = new Professor("Nikita", "Rezkov", Degree.mg);
				Professor p3 = new Professor("Amina", "Kazanceva", Degree.bsc);
				profRepo.save(p1);
				profRepo.save(p2);
				profRepo.save(p3);
				
				Student s1 = new Student("Evgenij", "Lskep");
				Student s2 = new Student("Kirill", "Vosmoj");
				Student s3 = new Student("Oksana", "Bakalova");
				studRepo.save(s1);
				studRepo.save(s2);
				studRepo.save(s3);
				
				Course c1 = new Course("Datu strukturas un algoritmi", 2, p1);
				Course c2 = new Course("Datubazes", 2, p2);
				Course c3 = new Course("Programmaturas inzenerija", 4, p3);
				courseRepo.save(c1);
				courseRepo.save(c2);
				courseRepo.save(c3);
				
				gradeRepo.save(new Grade(7, c1, s1));
				gradeRepo.save(new Grade(6, c1, s2));
				gradeRepo.save(new Grade(7, c1, s3));
				
				gradeRepo.save(new Grade(5, c2, s1));
				gradeRepo.save(new Grade(7, c2, s2));
				gradeRepo.save(new Grade(8, c2, s3));
				
				gradeRepo.save(new Grade(9, c3, s1));
				gradeRepo.save(new Grade(7, c3, s2));
				gradeRepo.save(new Grade(10, c3, s3));
				
				
			}
		};
	}
	
	

}
