package may13;

public class SumNo_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Input ="asdf1qwer9as8d7";
		int n = 0;
		for (int i = 0; i < Input.length(); i++) {
			char c = Input.charAt(i);
			if(Character.isDigit(c)) {
			int m = Character.getNumericValue(c);
			System.out.print(m +"+");
			n = m+n;
			}
				}
		System.out.print("="+n);
	}

}
