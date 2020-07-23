package com.example.RestController;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WriteDataToCSV.WriteDataToCSV;
import com.example.model.Student;
import com.example.repo.StudentRepo;

@RestController
public class StudentCSVDownload {
	@Autowired
	private StudentRepo studentRepo;

	@GetMapping("/download/student.csv")
	public void downloadCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		response.setHeader("Content-Display", "attachment; file = student.csv");
		List<Student> list = studentRepo.findAll();
		WriteDataToCSV.writeToCSV(response.getWriter(), list);

	}
}
