package week3.Day1.Assignment.college.org.Student;

import week3.Day1.Assignment.college.org.department.Department;

public class Student extends Department{


	public void studentName()
	{
		System.out.println("Student Name : Mutheswari");
	}
	
	public void studentDept()
	{
		System.out.println("Student dept. : ECE");
	}
	
	public void studentId()
	{
		System.out.println("Student Id : 653");;
	}
	
	public static void main(String[] args)
	{
		Student student = new Student();
		
		student.collegeName();
		System.out.println("College code : "+Student.collegeCode());
		System.out.println("College rank : " +Student.collegeRank());

		student.deptName();
		
		student.studentName();
		student.studentDept();
		student.studentId();
	}

		
}
