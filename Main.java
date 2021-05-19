//		Write an application for booking railway ticket 
//	reservation system. The application should have four functionalities.
//
//	Book
//	Cancel
//	Print booked tickets (details with summary)
//	Print available tickets (details with summary)
//	Conditions for booking:
//
//		There are a total of 63 berths for 63 confirmed tickets, 
//	9 berths for 18 RAC tickets and 10 tickets in waiting-list.
//	If the waiting-list ticket count goes above 10, print as ‘No tickets available’. 
//	The following passenger details should be obtained from the user.
//
//		Name
//		Age
//		Gender
//		Berth Preference
//	The tickets should not be allocated for children below age 5.
//	But, their details should be stored. Lower berth should be 
//	allocated for persons whose age is above 60 and ladies with children 
//	if available. Side-lower berths should be allocated for RAC passengers.
//
//	Conditions for cancelling:
//
//		Whenever a ticket is cancelled, a ticket from RAC should 
//	be confirmed and a waiting-list ticket should move to RAC.
//
//	Conditions for printing booked tickets:
//
//		Print all the tickets that are filled along with the passenger 
//	details and at the end, print the total number of tickets that are filled.
//
//	Conditions for printing available tickets:
//
//		Print all the tickets that are unoccupied and at the end, print the total
//	number of tickets that are unoccupied.

package railwayTicketReservationSystem;

import java.util.*;

public class Main {
	static Scanner in = new Scanner(System.in);
	static Train train = new Train();

	public static void main(String[] args) {
		while (true) {
			System.out.println();
			System.out.println("1.Book Ticket");
			System.out.println("2.Cancel ticket");
			System.out.println("3.Booked Ticket");
			System.out.println("4.Available Ticket");
			System.out.println("5.Exit");
			System.out.print("Enter your choice : ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				train.bookTicket(generateTicket());
				break;
			case 2:
				train.cancelTicket(generateTicket());
				break;
			case 3:
				train.displayAllTickets();
				break;
			case 4:
				train.availabelTickets();
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Wrong choice");

			}

		}
	}

	public static Ticket generateTicket() {
		System.out.print("Name : ");
		String name = in.next();
		System.out.print("Age : ");
		int age = in.nextInt();
		System.out.print("Gender : ");
		String gender = in.next();
		System.out.print("Berth preference (LB,MB and UB) : ");
		String berthpref = in.next();
		return new Ticket(name, age, gender, berthpref);

	}
}
