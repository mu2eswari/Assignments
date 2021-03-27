package week3.Day1.Interface;

public class CallIphone {

	public static void main(String[] args) {

		IPhone iphone = new IPhone();
		
		//Method in iphone
		iphone.CurrentClass();
		
		//Methods in IOS
		iphone.OperatingSystem();
		iphone.Developers();
	}

}
