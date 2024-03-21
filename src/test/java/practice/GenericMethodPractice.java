package practice;

public class GenericMethodPractice {

	public static void main(String[] args) { //test script//caller Function
		
		int sum = add(10,20);
		System.out.println(sum);
		
		add(100,30);
		add(90,87);
		add(30,56);

	}
	                  //parameterisation - 1
	public static int add(int a, int b) //called method/function- generic/reusable
	{
		int c = a+b;
		return c;
		//return the output to caller - 2
	}

}
