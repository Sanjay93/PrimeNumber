package com.prime;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sanjay
 */

public class FindPrime {
	private int i, x;
	private String no, msg;
	private boolean flag = true, flag1 = true;
	
	public void input() throws NumberFormatException {
		System.out.println("Enter the number to be prime or not");
		 //Testprime t = new Testprime();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		no = in.next();
		boolean check = validate(no);
		if (check == true) {
			try {
				x = Integer.parseInt(no);
				x = Math.abs(x);
			} catch (Exception e) {
				System.out.println("Please enter valid number 0-----10000");
				input();
			}

			boolean number = validateNo(x);
			if (number == true) {
				calculate(x);

				System.out.println("Do u want to continue (yes or no)");
				Scanner in1 = new Scanner(System.in);
				do {
					msg = in1.next();
					if (msg.equals("yes")) {
						input();
						flag1 = true;
					} else if (msg.equals("no")) {
						System.exit(1);

					} else {
						System.out.println("Enter yes or no");
						flag1 = false;
					}
				} while (flag1 == false);
			} else {
				input();
			}
		} else {
			System.out.println("please enter valid value");
			input();
		}
	}

	public boolean validateNo(int d) {
		if (d > 10000) {
			System.out.println("Please enter no below 10000");
			return false;
		} else {
			return true;

		}
	}

	public boolean validate(String z) {
		String regex = "^[-]?\\d+$";
		Pattern r = Pattern.compile(regex);
		Matcher m = r.matcher(z);
		if (m.find()) {
			return true;
		}

		else {
			return false;
		}
	}

	public void calculate(int y) {
		if (y == 1) {
			System.out.println("It is neither prime nor composite");
		}
		for (i = 2; i <= (y - 1); i++) {
			if (y % i == 0) {
				flag = false;
			}
		}
		if (flag == true) {
			System.out.println("It s a prime number");
		} else {
			System.out.println("It is not prime number");
		}

	}
}

