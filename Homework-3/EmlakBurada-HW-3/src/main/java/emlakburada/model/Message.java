package main.java.emlakburada.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

	private int id;
	private String title;
	private String message;
	private Date sentDate;
	private Date readDate;
	private boolean statusOfRead;
	private User sender;
	private User receiver;


}
