package week3.Day1.Assignment.Abstract2;

public class College extends University{

	public static void main(String[] args) {
		
		College col = new College();
		col.ug();
		col.pg();
		
	}

	@Override
	public void ug() {
		System.out.println("In method body in College class");
	}

}
