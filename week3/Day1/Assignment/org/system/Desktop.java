package week3.Day1.Assignment.org.system;

public class Desktop extends Computer {

	public void desktopSize()
	{
		System.out.println("The size of desktop 21 Inch");
	}
	
	
	public static void main(String[] args)
	{
		
		Desktop desktop = new Desktop();
		
		desktop.computerModel();
		desktop.desktopSize();
	}
	
}
