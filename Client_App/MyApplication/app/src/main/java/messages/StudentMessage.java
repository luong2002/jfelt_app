package messages;

import com.example.felipe.safe_drive_app.entities.Student;

import java.io.Serializable;

public class StudentMessage implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Student owner;
	private String message;

	/*
	 * Constructior of the {@link StudentMessage} class
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-25
	 * @param Student owner of the message
	 * @param String message that will be sent and read
	 */
	public StudentMessage(Student owner, String message) {
		this.owner = owner;
		this.message = message;
	}

	/**
	 * Gets the message that was stored in the class
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-25
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the owner of the message, null if sent by the server
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-25
	 */
	public Student getOwner() {
		return owner;
	}
}
