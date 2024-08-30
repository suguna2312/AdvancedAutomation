package practise;

import java.util.Date;

public class ToGenerateDateAndTime {
	public static void main(String[] args) {
		
		Date d=new Date();
		System.out.println(d);
		String date[] = d.toString().split(" ");
		String day = date[0];
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		String finalDate = day+" "+month+" "+date1+" "+time+" "+year;
		System.out.println(finalDate);
		
		
	}

}
