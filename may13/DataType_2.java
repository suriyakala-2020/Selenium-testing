package may13;

public class DataType_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Input = "1. It is Work from Home Not Work for Home";
		int digit=0, upper=0, lower=0, space=0;
		char[] c = Input.toCharArray();
		for (char ch : c) {
		switch(Character.getType(ch)) {
		case 9:
			digit++;
			break;
		case 12:
			space++;
			break;
		case 1:
			upper++;
			break;
		case 2:
			lower++;
			break;
		default:
			break;
		}
			
		}
		System.out.println("Numbers : "+digit);
		System.out.println("Uppercase : "+upper);
		System.out.println("Lowercase : "+lower);
		System.out.println("Space : "+space);			
	}

}
