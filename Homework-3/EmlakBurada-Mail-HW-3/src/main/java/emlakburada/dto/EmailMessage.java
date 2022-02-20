package main.java.emlakburada.dto;

public class EmailMessage {

	private String email;



	public EmailMessage(String email) {
		this.email = email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString(

	) {
		return "EmailMessage [email=" + email + "]";
	}

}
