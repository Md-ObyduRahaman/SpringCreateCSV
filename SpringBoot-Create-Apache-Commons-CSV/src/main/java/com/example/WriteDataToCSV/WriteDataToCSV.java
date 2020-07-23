package com.example.WriteDataToCSV;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.example.model.Student;

public class WriteDataToCSV 
{
	public static void writeToCSV(PrintWriter writer, List<Student> students)
	{
		try(
			CSVPrinter csvPriner = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Roll","Name","Address"));
			){
			for(Student stud: students)
			{
				String str;
				List<String> data = Arrays.asList(
						str = String.valueOf(stud.getRoll()),
						stud.getSname(),
						stud.getAddress()
						);
						csvPriner.printRecord(data);
			}
			csvPriner.flush();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
