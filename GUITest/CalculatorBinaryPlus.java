import java.util.ArrayList;
import java.util.Scanner;

public class CalculatorBinaryPlus {

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
     

    
    
      if(operator.equals("+")) {   //�����ڰ� + �� �� => ����
    	  
    	    if(number1.size() >= number2.size()) {      //�ڸ����� ���� ���� 0���� ä���� �ڸ���(�迭 ũ��) ���߱�
    	        for(int i =0 ; i < num1.length() -num2.length(); i++)
    	         number2.add(0);
    	     }
    	    else {
    	         for(int i = 0; i < num2.length() - num1.length(); i++)
    	            number1.add(0);
    	      }
    	      
    	  
    	    System.out.println(number1);

    	    System.out.println(number2);
    	    
    	  
        number1.add(0); number2.add(0);         //�ְ� �ڸ����� �ø����� �߻��� �� �����Ƿ� �� ���ڸ��� 0�߰�
        

        for(int i = 0; i < number1.size(); i++) {   //�ڸ�����ŭ �� �迭�� ����. carryNum���� 10�̻��� ���� ������ ��� 1, 10 �̸��̸� 0���� �ʱ�ȭ, �� ��(�迭)�� �ڸ����� �����༭ number1, number2 �ƹ��ų� �ᵵ ��
        	result.add((carryNum+number1.get(i)+number2.get(i))%2);
        	if(carryNum+number1.get(i)+number2.get(i)>=2)
        		carryNum=1;
        	else {
        		carryNum=0;
        	}
       
       }
	
         if(result.get(result.size() - 1) == 0)      //������� �� ���ڸ��� 0�̸� 0����
           result.remove(result.size() - 1);
         
        
      for(int i = 0; i < result.size(); i++)   //����� ���
         System.out.print(result.get(result.size() - i - 1));   //1�� �ڸ����� ���������Ƿ� �ݴ�� ��� 
   }
  
      input.close();
   		}
   }
