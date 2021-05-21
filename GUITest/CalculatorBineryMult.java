import java.util.ArrayList;
import java.util.Scanner;

public class CalculatorBineryMult {

	public static void main(String[] args) {
		
		String num1, num2, operator;
	      ArrayList<Integer> number1 = new ArrayList<Integer>();   //num1이 들어갈 배열
	      ArrayList<Integer> number2 = new ArrayList<Integer>();   //num2가 들어갈 배열
	      ArrayList<Integer> result = new ArrayList<Integer>();  	//올림수까지 더한 최종 값
	      
	      int carryNum=0; //올림수 계산

	      Scanner input = new Scanner(System.in);
	      System.out.print("num1을 입력하시오: ");
	      num1 = input.nextLine();
	      System.out.print("연산자를 입력하시오: ");
	      operator = input.nextLine();
	      System.out.print("num2을 입력하시오: ");
	      num2 = input.nextLine();
	      
	     
	      for(int i = 0; i < num1.length(); i++) //num1의 뒷자리부터 배열number1에 저장
	         number1.add( num1.charAt(num1.length() - 1 - i)-'0');

	    
	    for(int i = 0; i < num2.length(); i++) //num2의 뒷자리부터 배열number2에 저장
	         number2.add( num2.charAt(num2.length() - 1 - i)-'0');
	     
		
	    if(operator.equals==("/")) {
	    	System.out.println("sad");
	    }

	}

}
