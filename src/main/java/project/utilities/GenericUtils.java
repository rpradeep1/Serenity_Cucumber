package project.utilities;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Random;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class GenericUtils {

	public static String getDate_given_Format() {
		
		// String element = DA_PROJ_OR.LAST_SEARCH_TIME;
		String sExpectedTime = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		String[] words = sExpectedTime.split("\\s");
		System.out.println("System Date-->:- " + words[0]);

		String sExpectedDate = words[0];

		return sExpectedDate;
	}

	public static int generate_Random_Number_for_Given_Range(int range) {
		
		Random rand = new Random();
		int value = rand.nextInt(range);
		return value;
	}

	public static String decode(String value){
		
		byte[] decodedValue = null;
		try {
			decodedValue = Base64.getDecoder().decode(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new String(decodedValue, StandardCharsets.UTF_8);
	}

	public static void sendEmail() {
		
		try {
			
			Email email = new SimpleEmail();
			email.setHostName("ihtmail.ihealthtechnologies.com");
			email.setSmtpPort(25);
			email.setAuthenticator(new DefaultAuthenticator("nkatari", ""));
			email.setSSLOnConnect(false);
			email.setFrom("neelima.katari@cotiviti.com");
			email.setSubject("ExecutionMAil");
			email.setMsg("Script Execution");
			email.addTo("neelima.katari@cotiviti.com");
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	public static int GetRandomNumber() {
		
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
			
	
	}

