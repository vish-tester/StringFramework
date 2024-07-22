package supportingAPIClasses;

public class BookingPojo {
	
	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	private String additionalneed;
	private BookingDatesPojo bookingdates;
	
	
	
	
	
	public BookingPojo(String firstname, String lastname, int totalprice, boolean depositpaid, String additionalneed,
			BookingDatesPojo bookingdates) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		this.additionalneed = additionalneed;
		this.bookingdates = bookingdates;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public boolean isDepositpaid() {
		return depositpaid;
	}
	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}
	public String getAdditionalneed() {
		return additionalneed;
	}
	public void setAdditionalneed(String additionalneed) {
		this.additionalneed = additionalneed;
	}
	public BookingDatesPojo getBookingdates() {
		return bookingdates;
	}
	public void setBookingdates(BookingDatesPojo bookingdates) {
		this.bookingdates = bookingdates;
	}
	
	@Override
	public String toString() {
		return "BookingPojo [firstname=" + firstname + ", lastname=" + lastname + ", totalprice=" + totalprice
				+ ", depositpaid=" + depositpaid + ", additionalneed=" + additionalneed + ", bookingdates="
				+ bookingdates + "]";
	}
	
	
	
}
