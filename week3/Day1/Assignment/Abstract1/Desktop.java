package week3.Day1.Assignment.Abstract1;

public class Desktop implements Hardware,Software {

	public void desktopModel()
	{
		System.out.println("This is a workstation");
	}
	public static void main(String[] args) {
		
		Desktop desktop = new Desktop();
		desktop.softwareResources();
		desktop.hardwareResources();
		desktop.desktopModel();
	}
	public void softwareResources() {
		System.out.println("Software Resources method");
	}
	public void hardwareResources() {
		System.out.println("Hardware Resources method");
		
	}

}
