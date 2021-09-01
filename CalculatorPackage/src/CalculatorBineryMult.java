import java.util.ArrayList;
import java.util.Scanner;




public class CalculatorBineryMult {

	public static void main(String[] args) {
		
		   String num1, num2, operator;
		   
		   Scanner input = new Scanner(System.in);
		      System.out.print("num1을 입력하시오: ");
		      num1 = input.nextLine();
		      System.out.print("연산자를 입력하시오: ");
		      operator = input.nextLine();
		      System.out.print("num2를 입력하시오: ");
		      num2 = input.nextLine();
		
		     if(operator.equals("+")) {
		    	 
		    	 System.out.println(add(num1,num2));
		     }
		     if(operator.equals("-")) {
		    	System.out.println(sub(num1,num2));
		     }
		
	   

	}
//	public static String mul(String num1, String num2){
//		String result;
//		String subResult;
//		
//		
//		
//		
//		
//		
//		return ;
//	}
	public static String sub(String num1,String num2) {

		String finalResult=new String();
		 ArrayList<Integer> number1 = new ArrayList<Integer>();   //num1�� �� �迭
	      ArrayList<Integer> number2 = new ArrayList<Integer>();   //num2�� �� �迭
	      ArrayList<Integer> result = new ArrayList<Integer>();
		
		  ArrayList<Integer> carryNumber1 = new ArrayList<Integer>();
		  ArrayList<Integer>  number2_complement = new ArrayList<Integer>();
		
		  int flag=0;//num1과 num2를 비교해서 num2가 크면 flag를 1로 num1과 num2가 같으면 flag를 2로 초기화
		  int preventDigit,highDigit;
		  int carryNum;
		  
		  for(int i = 0; i < num1.length(); i++) //num1을 number1 배열에 1의자리 수부터 넣음 
		         number1.add( num1.charAt(num1.length() - 1 - i)-'0');
		    for(int i = 0; i < num2.length(); i++) //num2를 number2 배열에 1의자리 수부터 넣음 
		         number2.add( num2.charAt(num2.length() - 1 - i)-'0');
		  
		    if(num1.length()>num2.length()) {
	    		  flag=0;
	    	  }
	    	  else if(num1.length()<num2.length()) {
	    		  flag=1;
	    	  }
	    	  else {
	    	
	    			  int i1=1;
	    			  while(true) {
	 	    			 if(i1>=num1.length()) {   //두수가 완전히 같음 flag=2
	 	    				 flag=2;
	 	    				 break;
	 	    			 }
	 	    			 
	 	    		 if(number1.get(number1.size()-i1)>number2.get(number2.size()-i1)) { //number1�� number2���� ū���
	 	    			flag=0;
	 	    			 break;
	 	    		 }
	 	    		 else if(number2.get(number2.size()-i1)>number1.get(number1.size()-i1)) {//number2�� number1���� ū���
	 	    			
	 	    			 flag=1;
	 	    			 break;
	 	    		 }
	 	    		 i1++;
	    		  }
	    	  }
	  	    if(number1.size() >= number2.size()) {      //�ڸ����� ���� ���� 0���� ä���� �ڸ���(�迭 ũ��) ���߱�
		        for(int i =0 ; i < num1.length() -num2.length(); i++)
		         number2.add(0);
		     }
		    else {
		         for(int i = 0; i < num2.length() - num1.length(); i++)
		            number1.add(0);
		      }
		      
			
	    	 
	    	 
	    	  //number1이 number2보다 클 때
	    	  if(flag==0) {
	    		
	    		   	for(int j=0;j<number1.size();j++)  //�����ϴ� ����
	    	    	{
	    	    		if(number1.get(j)-number2.get(j)>=0) {    //�������� �ʿ���� ū���� ���������� �ڸ����� Ŭ��
	    	    			result.add(number1.get(j)-number2.get(j));
	    	    		}
	    	    		else {                              //�������� �ʿ��ϴٸ� ���� �ڸ������� +2�� ���༭ ����ϰ� �� �ڸ����� -1�� �Ѵ�.
	    	    			preventDigit=number1.get(j);
	    	    			preventDigit+=2;
	    	    			number1.set(j, preventDigit);
	    	    			
	    	    			highDigit=number1.get(j+1);
	    	    			highDigit--;
	    	    			number1.set(j+1,highDigit);
	    	    			
	    	    			result.add(number1.get(j)-number2.get(j));
	    	    		}
	    	    	}
	    		   	
	    		   	if(result.get(result.size()-1)==0)
	    		   		result.remove(result.size()-1);
	    		  
	    	  }
	    	//number2가 number1보다 클 때
	    	  else if(flag==1){
	 
	    		  
	    		  int cycle=number2.size();
	    		 for(int i=0;i<64-cycle;i++)  //64비트로 맞춰줌 
	    		 {
	    			 number1.add(0); 
	    			 number2.add(0);
	    		 }
	    		  
	    
	    		   // number2 1의 보수로 바꿔줌
	    		  for(int i=0;i<number2.size();i++) {   
	    			  if(number2.get(i)==0) {
	    				  number2.set(i,1);
	    			  }
	    			  else if(number2.get(i)==1) {
	    				  number2.set(i, 0);
	    			  }
	    		  }
	    	
	    	 
	    		  carryNumber1.add(1);
	    		    for(int i = 1; i < number2.size(); i++) //  number2 size��ŭ�� �ڸ����� 0���� �ʱ�ȭ 
	    		         carryNumber1.add(0);
					
	    		 
	    		
						  carryNum=0;
						  
	    		  for(int i =  0; i <number2.size() ; i++) {   //1의 보수에 +1
	    			  number2_complement.add((carryNum+number2.get(i)+carryNumber1.get(i))%2);
	    	        	if(carryNum+carryNumber1.get(i)+number2.get(i)>=2) {
	    	        		carryNum=1;
	    	        	}
	    	        	else {
	    	        		carryNum=0;
	    	        	}
	    	  
	    	       }


	    		  
	    		  
	    		  carryNum=0;
	    		
	    		  for(int i = 0; i < number2.size(); i++) {   //number1과 2의보수 취해준 number2와의 덧셈
	    			  result.add((carryNum+number1.get(i)+ number2_complement.get(i))%2);
	    	        	if(carryNum+number1.get(i)+ number2_complement.get(i)>=2)
	    	        		carryNum=1;
	    	        	else {
	    	        		carryNum=0;
	    	        	}
	    	       
	    	       }
	    		  
	    		  

	    			 }

	    		

	    		  
	    	  
	    	  
	    	
	    	  else if(flag==2) { //두 수가 완전히 같을 때

	    		  result.add(0);
	    	  }
		    
	    	  for(int i=0;i<result.size();i++)
	    	  finalResult+=result.get(result.size() - i - 1);
	    	  
	    	  
		return finalResult;
	}
	public static String add(String num1,String num2) {
		
		String finalResult=new String();
		 ArrayList<Integer> number1 = new ArrayList<Integer>();   //num1�� �� �迭
	      ArrayList<Integer> number2 = new ArrayList<Integer>();   //num2�� �� �迭
	      ArrayList<Integer> result = new ArrayList<Integer>();
	     
	      int carryNum=0; //덧셈 계산시 올림수를 저장함
	      int preventDigit,highDigit;
	      
	      for(int i = 0; i < num1.length(); i++) //num1을 number1 배열에 1의자리 수부터 넣음 
	         number1.add( num1.charAt(num1.length() - 1 - i)-'0');
	    for(int i = 0; i < num2.length(); i++) //num2를 number2 배열에 1의자리 수부터 넣음 
	         number2.add( num2.charAt(num2.length() - 1 - i)-'0');
	      
	    
	    if(number1.size() >= number2.size()) {      //�ڸ����� ���� ���� 0���� ä���� �ڸ���(�迭 ũ��) ���߱�
	        for(int i =0 ; i < num1.length() -num2.length(); i++)
	         number2.add(0);
	     }
	    else {
	         for(int i = 0; i < num2.length() - num1.length(); i++)
	            number1.add(0);
	      }
	    
	    number1.add(0); number2.add(0); 
	    
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
	    
	    
         for(int i=0;i<result.size();i++) {
        	 finalResult+=result.get(result.size() - i - 1);
         }
         
         return finalResult;
	}
	
	
	
	
}
