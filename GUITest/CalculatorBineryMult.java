import java.util.ArrayList;
import java.util.Scanner;

public class CalculatorBineryMult {

	public static void main(String[] args) {
		
		String num1, num2, operator;
	      ArrayList<Integer> number1 = new ArrayList<Integer>();   //num1�� �� �迭
	      ArrayList<Integer> number2 = new ArrayList<Integer>();   //num2�� �� �迭
	      ArrayList<Integer> result = new ArrayList<Integer>();  	//�ø������� ���� ���� ��
	      
	      int carryNum=0; //�ø��� ���

	      Scanner input = new Scanner(System.in);
	      System.out.print("num1�� �Է��Ͻÿ�: ");
	      num1 = input.nextLine();
	      System.out.print("�����ڸ� �Է��Ͻÿ�: ");
	      operator = input.nextLine();
	      System.out.print("num2�� �Է��Ͻÿ�: ");
	      num2 = input.nextLine();
	      
	     
	      for(int i = 0; i < num1.length(); i++) //num1�� ���ڸ����� �迭number1�� ����
	         number1.add( num1.charAt(num1.length() - 1 - i)-'0');

	    
	    for(int i = 0; i < num2.length(); i++) //num2�� ���ڸ����� �迭number2�� ����
	         number2.add( num2.charAt(num2.length() - 1 - i)-'0');
	     
		
	    if(operator.equals==("/")) {
	    	System.out.println("sad");
	    }

	}

}
