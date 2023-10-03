package com.sleimanelhajj;

import java.util.Scanner;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Main {
	public static void main(String[] args) throws EmailException {
		String user, userPassword, clientEmail, subject, body;
		Scanner scan = new Scanner(System.in);

		// new email object
		Email email = new SimpleEmail();

		// get info from user

		System.out.println("Enter your outlook email: ");
		user = scan.nextLine();

		System.out.println("Enter your outlook password: ");
		userPassword = scan.nextLine();

		System.out.println("Enter the clients email: ");
		clientEmail = scan.nextLine();

		System.out.println("Enter the subject of this email: ");
		subject = scan.nextLine();

		System.out.println("Enter the body of this email: ");
		body = scan.nextLine();

		// Account that is sending the email
		email.setAuthenticator(new DefaultAuthenticator(user, userPassword));

		// establish a connection
		email.setStartTLSRequired(true);

		// set the server name and port number to the desired server in this case it is outlook
		email.setHostName("smtp.office365.com");
		email.setSmtpPort(587);

		// set the subject and the body of the email
		email.setSubject(subject);
		email.setMsg(body);

		// from who
		email.setFrom(user);

		// send to
		email.addTo(clientEmail);

		// send the email
		email.send();
		System.out.println("Email sent(wait a couple of seconds)");
		scan.close();

	}
}
