package railwayTicketReservationSystem;

public class Ticket {
	String name;
	int age;
	String gender;
	String birthPreference;
	String confirmationStatus;

	public Ticket(String name, int age, String gender, String birthPreference) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birthPreference = birthPreference;
	}

	public String getConfirmationStatus() {
		return confirmationStatus;
	}

	public void setConfirmationStatus(String confirmationStatus) {
		this.confirmationStatus = confirmationStatus;
	}
}
