package railwayTicketReservationSystem;

import java.util.ArrayList;

public class Train {
	ArrayList<Ticket> confirmedTickets = new ArrayList<Ticket>();
	ArrayList<Ticket> racTickets = new ArrayList<Ticket>();
	ArrayList<Ticket> waitingListTickets = new ArrayList<Ticket>();
	Berth berth = new Berth();

	public void bookTicket(Ticket ticket) {
		if (ticket.age > 5) {
			if (confirmedTickets.size() < 63) {
				berth.allocateBerth(ticket);
				confirmedTickets.add(ticket);
			} else if (racTickets.size() < 18) {
				ticket.setConfirmationStatus("In RAC");
				racTickets.add(ticket);
			} else if (waitingListTickets.size() < 10) {
				ticket.setConfirmationStatus("In Waiting list");
				waitingListTickets.add(ticket);
			} else {
				System.out.println("No Tickets Available");
				return;
			}
			displayTicket(ticket);
		} else {
			System.out.println("No ticket for children,It's free !");
			return;
		}
	}

	public void cancelTicket(Ticket ticket) {

		if (removeTicket(ticket, confirmedTickets)) {
			if (!racTickets.isEmpty()) {
				confirmedTickets.add(confirmedTickets.size() - 1, racTickets.get(0));
				racTickets.remove(0);
				if (!waitingListTickets.isEmpty()) {
					racTickets.add(racTickets.size() - 1, waitingListTickets.get(0));
					waitingListTickets.remove(0);
				}
			}
			return;
		} else if (removeTicket(ticket, racTickets)) {
			if (!waitingListTickets.isEmpty()) {
				racTickets.add(racTickets.size() - 1, waitingListTickets.get(0));
				waitingListTickets.remove(0);
			}
			return;
		} else if (removeTicket(ticket, waitingListTickets)) {
			return;
		} else {
			System.out.println("your search does not match");
			return;
		}
	}

	private boolean removeTicket(Ticket ticket, ArrayList<Ticket> ticketBookings) {
		for (Ticket tickets : ticketBookings) {
			displayTicket(tickets);
			displayTicket(ticket);
			if (tickets.name.equals(ticket.name) && tickets.age == ticket.age && tickets.gender.equals(ticket.gender)) {
				ticketBookings.remove(tickets);
				System.out.println("Ticket cancelled suceesfully");
				return true;
			}
		}
		return false;
	}

	private ArrayList<Ticket> findTicketStatus(Ticket ticket) {
		if (confirmedTickets.contains(ticket))
			return confirmedTickets;
		else if (racTickets.contains(ticket))
			return racTickets;
		else {
			return waitingListTickets;
		}
	}

	public void displayTicket(Ticket ticket) {
		System.out.println(ticket.name + "\n" + ticket.age + "\n" + ticket.gender + "\n"
				+ ticket.getConfirmationStatus() + " " + (findTicketStatus(ticket).indexOf(ticket) + 1));
	}

	public void displayAllTickets() {
		for (Ticket ticket : confirmedTickets) {
			System.out.println(ticket.name + "\n" + ticket.age + "\n" + ticket.gender + "\n"
					+ ticket.getConfirmationStatus() + " " + findTicketStatus(ticket).indexOf(ticket) + 1);
		}
		for (Ticket ticket : racTickets) {
			System.out.println(ticket.name + "\n" + ticket.age + "\n" + ticket.gender + "\n"
					+ ticket.getConfirmationStatus() + " " + (findTicketStatus(ticket).indexOf(ticket) + 1));
		}
		for (Ticket ticket : waitingListTickets) {
			System.out.println(ticket.name + "\n" + ticket.age + "\n" + ticket.gender + "\n"
					+ ticket.getConfirmationStatus() + " " + (findTicketStatus(ticket).indexOf(ticket) + 1));
		}
	}

	public void availabelTickets() {
		System.out.println("Confirm available tickets are " + (63 - confirmedTickets.size()));
		System.out.println("Rac available tickets are " + (18 - racTickets.size()));
		System.out.println("Waiting list available tickets are " + (10 - waitingListTickets.size()));
	}
}
