package may13;

public class ReverseString_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String Input = "When the world realise its own mistake, corona will dissolve automatically";
		  String[] In = Input.split(" ");
		  for (int i = 0; i < In.length; i++) {
				if (i%2!=0) {
					StringBuilder s = new StringBuilder(In[i]);
					s.reverse();
					System.out.print(s+ " ");
				}else {
					System.out.print(In[i] + " ");
				}
			}
				}

			}
