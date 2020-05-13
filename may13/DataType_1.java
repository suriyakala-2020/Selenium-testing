package may13;

public class DataType_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String Input = "1. It* is Work from Home Not Work for Home";
	int digit=0, upper=0, lower=0, space =0;
	char[] in = Input.toCharArray();
	for (char c : in) {
		if(Character.isDigit(c)) {
			digit ++;
		}else if (Character.isUpperCase(c)) {
			upper ++;
		}else if (Character.isLowerCase(c)) {
			lower ++;
		}else if (Character.isWhitespace(c)) {
			space ++;
		}
	}
	System.out.println("Numbers : "+digit);
	System.out.println("Uppercase : "+upper);
	System.out.println("Lowercase : "+lower);
	System.out.println("Space : "+space);
	}

}
