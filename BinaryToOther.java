import java.util.Scanner;

class Functions {
	public static char flip(char i) {
		return i == '0' ? '1' : '0';
	}

	public static String complements(String binary) {
		String ones = "", twos = "";
		int i;
		for (i = 0; i < binary.length(); i++)
			ones += flip(binary.charAt(i));
		twos = ones;
		for (i = binary.length() - 1; i >= 0; i--) {
			if (ones.charAt(i) == '1') {
				twos = twos.substring(0, i) + '0' + twos.substring(i + 1);
			} else {
				twos = twos.substring(0, i) + '1' + twos.substring(i + 1);
				break;
			}
		}
		if (i == -1) {
			twos = '1' + twos;
		}
		return twos;
	}

	public static int convertor(String binary) {
		int number = 0;
		for (int i = 0; i < binary.length(); i++) {
			int base = binary.charAt(i) - '0';
			number = base * (int) Math.pow(2, binary.length() - i - 1) + number;
		}
		return number;
	}
}

class BinaryToAnything extends Functions {
	public static void binaryToInteger() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter your Integer (keep negative sign in front if it is negative number) : ");
		int binary = s.nextInt();
		int number = 0;
		int sign = 0;
		if (binary < 0) {
			sign = 1;
			binary *= -1;
		}
		String binaryStr = String.valueOf(binary);
		if (sign == 1) {
			String numberStr = complements(binaryStr);
			number = convertor(numberStr);
			number *= -1;
		} else {
			number = convertor(binaryStr);
		}

		System.out.println(binary + " in the integer is " + number);

	}

	public static void binaryToFloat() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your binary float String (separate each char (binary set) by a space) : ");
		String binaryString = s.nextLine();
		int intBits = (int) Long.parseLong(binaryString, 2);

		float floatValue = Float.intBitsToFloat(intBits);

		System.out.println("The float value is: " + floatValue);
	}

	public static void binaryToString() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your binary String (separate each char (binary set) by a space) : ");
		String binary = s.nextLine();
		String[] binarySet = binary.split(" ");
		String text = "";
		for (String binaryText : binarySet) {
			int asciiValue = convertor(binaryText);
			text += new Character((char) asciiValue).toString();
		}
		System.out.println(binary + " as the string is " + text);

	}
}

public class BinaryToOther {

	public static void binaryTo() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter\n1---->To get in Integer\n2---->To get in float\n3---->To get in String ");
		int choice = s.nextInt();
		switch (choice) {
			case 1:
				BinaryToAnything.binaryToInteger();
				break;
			case 2:
				BinaryToAnything.binaryToFloat();
				break;
			case 3:
				BinaryToAnything.binaryToString();
				break;
		}

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int primaryChoice = 0;
		while (primaryChoice != 2) {
			System.out.println("Enter\n1:To convert binary to anything\n2:To Exit");
			primaryChoice = s.nextInt();
			if (primaryChoice == 1)
				binaryTo();
			else if (primaryChoice == 2)
				System.out.println("Exiting successfully");
			else
				System.out.println("Wrong input");

		}
	}

}
