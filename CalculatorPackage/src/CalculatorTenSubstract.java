import java.util.ArrayList;
import java.util.Scanner;
public class CalculatorTenSubstract {

	public static void main(String[] args) {
	      String num1, num2, operator;
	      ArrayList<Integer> number1 = new ArrayList<Integer>();   //num1�� �� �迭
	      ArrayList<Integer> number2 = new ArrayList<Integer>();   //num2�� �� �迭
	      ArrayList<Integer> result = new ArrayList<Integer>(); 
	      
	      
	      ArrayList<Integer> bigNum=new ArrayList<Integer>();  //������ ���� ū ���� �� �迭
	      ArrayList<Integer> smallNum=new ArrayList<Integer>();
	      
	      int highDigit,preventDigit=0;  //highDigit�� ���� ��� �ڸ������� ���ڸ� ���� ��, prevent�� ���� ��� �ڸ���
	      Scanner input = new Scanner(System.in);
	      System.out.print("num1�� �Է��Ͻÿ�: ");
	      num1 = input.nextLine();
	      System.out.print("�����ڸ� �Է��Ͻÿ�: ");
	      operator = input.nextLine();
	      System.out.print("num2�� �Է��Ͻÿ�: ");
	      num2 = input.nextLine();
	      
	      int flag=0; //�������� ������� flag�� 1�� ��
	      
	      for(int i = 0; i < num1.length(); i++) //num1�� ���ڸ����� �迭number1�� ����
	          number1.add( num1.charAt(num1.length() - 1 - i)-'0');

	     
	     for(int i = 0; i < num2.length(); i++) //num2�� ���ڸ����� �迭number2�� ����
	          number2.add( num2.charAt(num2.length() - 1 - i)-'0');
	      
	     if(operator.equals("-"))
	     {
	    	 if(num1.length()>num2.length())        //ū �� �� if��
	    	 {
	    		 bigNum=number1;
	    		 smallNum=number2;
	    	 }
	    	 else if(num2.length()>num1.length()) //�ڿ� �Է��� num2�� �� ũ�ٸ� flag���� 1�� �ٲ㼭 �������� ������ �����
	    	 {
	    		 bigNum=number2;
	    		 smallNum=number1;
	    		 flag=1; //���� ������ ū ���� ���� ������ flag=1
	    	 }
	    	 else  {
	    		 int i=1;  //�ڸ�����ŭ �ݺ����� ���ư��� ��
	    		 while(true) {
	    			 if(i>=num1.length()) {   //��� �ڸ����� ������ ��. �μ��� ���� ��� bigNum�� �����̵� �������
	    				 bigNum=number1;
		    			 smallNum=number2;
		    			 break;
	    			 }
	    			 
	    		 if(number1.get(num1.length()-i)>number2.get(num2.length()-i)) { //number1�� number2���� ū���
	    			 bigNum=number1;
	    			 smallNum=number2;
	    			 break;
	    		 }
	    		 else if(number2.get(num1.length()-i)>number1.get(num1.length()-i)) {//number2�� number1���� ū���
	    			 bigNum=number2;
	    			 smallNum=number1;
	    			 break;
	    		 }
	    		 else {   // �ڸ��� �񱳿��� ���� ��� ���� �ڸ����� ����
	    			 i++;
	    			 continue;
	    		 }
	    	
	    		 			}
	    		 }
	    	 
	   
	    	for(int j=smallNum.size();j<bigNum.size();j++) {   //��Ȱ�� ����� ���� ���� ���� 0�� �־ ū���� �ڸ����� ������
	    		smallNum.add(0);
	    	
	    	}
	    	
	    	
	    	System.out.println(smallNum);
	    	System.out.println(bigNum);
	    
	    	for(int j=0;j<smallNum.size();j++)  //�����ϴ� ����
	    	{
	    		if(bigNum.get(j)-smallNum.get(j)>=0) {    //�������� �ʿ���� ū���� ���������� �ڸ����� Ŭ��
	    			result.add(bigNum.get(j)-smallNum.get(j));
	    		}
	    		else {                              //�������� �ʿ��ϴٸ� ���� �ڸ������� +10�� ���༭ ����ϰ� �� �ڸ����� -1�� �Ѵ�.
	    			preventDigit=bigNum.get(j);
	    			preventDigit+=10;
	    			bigNum.set(j, preventDigit);
	    			
	    			highDigit=bigNum.get(j+1);
	    			highDigit--;
	    			bigNum.set(j+1,highDigit);
	    			
	    			result.add(bigNum.get(j)-smallNum.get(j));
	    		}
	    	}
	    	 
	    	 
	     }
	     
			
			  int k=1; //�� ���ڸ��� 0�� ������ ���� ����
			  do {
			  if(result.get(result.size()-k)==0)
			  {
				  result.remove(result.size()-k); 
			  }
			  else {
				  break;
			  }
			  }while(result.size()>k);
	     
			  
	     if(flag==0) {
	     for(int i = 0; i < result.size(); i++)   //����� ���
	         System.out.print(result.get(result.size() - i - 1));   //1�� �ڸ����� ���������Ƿ� �ݴ�� ���
	     }
	     else {
	    	 System.out.print("-");
	    	 for(int i = 0; i < result.size(); i++)
	    	 System.out.print(result.get(result.size() - i - 1));
	     }
	     

	     input.close();
	}

}
