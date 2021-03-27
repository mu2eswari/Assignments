package week3.Day1.Assignment.Polymorphism;

public class Calculator {

	public void add(int num1, int num2)
	{
		System.out.println("In method with two numbers to add");
		int sum = num1 + num2;
		System.out.println("Sum of two number is "+sum);
	}
	
	public void add(int num1, int num2, int num3)
	{
		System.out.println("In method with three numbers to add");
		int sum = num1 + num2+num3;
		System.out.println("Sum of two number is "+sum);
	}
	
	public void sub(int num1, int num2)
	{
		System.out.println("In method with two numbers to subtract");
		int sum = num1 - num2;
		System.out.println("difference of two number is "+sum);
	}

	public void sub(double num1, int num2)
	{
		System.out.println("In method with two numbers of different data type  to subtract");
		double dif = num1 - num2;
		System.out.println("difference of two number is "+dif);
	}	
	
	public void mul(int num1, int num2)
	{
		System.out.println("In method with two numbers to multiply");
		int sum = num1 * num2;
		System.out.println("Multiplication of two number is "+sum);
	}

	public void mul(double num1, int num2)
	{
		System.out.println("In method with two numbers of different data type  to multiply");
		double mul = num1 * num2;
		System.out.println("Multiplication of two number is "+mul);
	}	
	
	public void div(int num1, int num2)
	{
		System.out.println("In method with two numbers to div");
		int div = num1 / num2;
		System.out.println("Multiplication of two number is "+div);
	}

	public void div(double num1, int num2)
	{
		System.out.println("In method with two numbers of different data type  to divide");
		double div = num1 / num2;
		System.out.println("Multiplication of two number is "+div);
	}	
	
	
	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		cal.add(1, 2);
		cal.add(1, 2, 3);
		cal.sub(5, 3);
		cal.sub(12334343, 5);
		cal.mul(5, 10);
		cal.mul(2343242, 2);
		cal.div(50, 10);
		cal.div(3242342, 10);

	}

}
