import java.io.*;
import java.util.*;
class Bookings {
	public String name;
	public int count;
	public double fare;
}
//NemoReefTours
class NemoReefTours{
	public static void main(String args[]){
		System.out.println("Welcome to the Nemo Reef Tours Management Systems\n\n");
		System.out.println("Please enter number of bookings");
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt();
		int k=N;
		Bookings min= new Bookings();
		Bookings max= new Bookings();
		int minCnt=999999,maxCnt=-1;
		double totalFare=0;
		double avgMembers=0;
		while(N>0)
		{
			int cnt=k-N+1;
			String none=sc.nextLine(); 
			System.out.println("Please enter booking name "+cnt);
			String bookingName = sc.nextLine();
			while(bookingName.equals("")|| bookingName.equals(" "))
			{
				System.out.println("ERROR Booking name cannot be empty");
				System.out.println("Please enter booking name "+cnt);
				bookingName = sc.nextLine();
			}
			System.out.println("Please enter number of passengers for "+ bookingName);
			int bookingCount=sc.nextInt();
			while(bookingCount<=0)
			{
				System.out.println("ERROR Number of passengers should be greater than zero");
				System.out.println("Please enter number of passengers for "+ bookingName);
				bookingCount=sc.nextInt();
			}
			double fare;
			int disc=0;
			if(bookingCount>2 && bookingCount<6)
			{
				disc=10;
			}
			if(bookingCount>5 && bookingCount<11)
			{
				disc=15;
			}
			if(bookingCount>10)
			{
				disc=20;
			}

			double bookingFare=85.50-(85.50*disc)/100;
			bookingFare*=bookingCount;
			System.out.printf("The tour charges for %s for %d passenger(s) is $%.2f\n\n",bookingName,bookingCount,bookingFare);

			if(minCnt>bookingCount){
				min.name=bookingName;
				min.count=bookingCount;
				min.fare=bookingFare;
				minCnt=bookingCount;
			}
			if(maxCnt<bookingCount){
				max.name=bookingName;
				max.count=bookingCount;
				max.fare=bookingFare;
				maxCnt=bookingCount;
			}
			avgMembers+=bookingCount;
			totalFare+=bookingFare;
			N-=1;
		}
		System.out.println("Statistical information for Nemo Reef Tours");
		avgMembers=avgMembers/k;
		System.out.println("Booking :"+min.name+" has the minimum number of "+min.count+" passengers(s)");
		System.out.println("Booking :"+max.name+" has the maximum number of "+max.count+" passengers(s)");
		System.out.printf("Average number of passengers per booking is : %.2f passengers(s)\n", avgMembers);
		System.out.printf("Total charges collected is : $%.2f\n\n", totalFare);
		System.out.println("Thankyou for using the Nemo Reef Tours Management Systems");
	}
}
