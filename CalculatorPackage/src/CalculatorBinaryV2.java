import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.lang.*;

public class CalculatorBinaryV2 {

	public static void main(String[] args) {
		
		   String num1, num2, operator;
		   
		   Scanner input = new Scanner(System.in);
		      System.out.print("num1을 입력하시오: ");
		      num1 = input.nextLine();
		      System.out.print("연산자를 입력하시오: ");
		      operator = input.nextLine();
		      System.out.print("num2를 입력하시오: ");
		      num2 = input.nextLine();
		
		      int chk1=0,chk2=0;
		      
		     if(operator.equals("+")) {
		    	 System.out.println(BinAdd(num1,num2,chk1,chk2));
		     }
		     else if(operator.equals("-")) {
		    	System.out.println(BinSub(num1,num2));
		     }
		     else if(operator.equals("*")) {
			    	System.out.println(BinMul(num1,num2,chk1,chk2));
			     }
		     else if(operator.equals("/")) {
		    	 System.out.println("답:"+BinDiv(num1,num2,chk1,chk2));
		     }
	   

	}
	
	
	public static int compare(String num1,String num2) {  //두수 비교 메소드 (num1이 크면 1 num2가 크면 -1 같으면 0)
		ArrayList<Integer> number1=new ArrayList<Integer>();
		ArrayList<Integer> number2=new ArrayList<Integer>();
		
		if(num1.equals(num2)) {
			return 0;
		}
	
		for(int i = 0; i < num1.length(); i++) //num1을 number1 배열에 1의자리수 부터 넣음 
	         number1.add( num1.charAt(num1.length() - 1 - i)-'0');
	    for(int i = 0; i < num2.length(); i++) //num2를 number2 배열에 1의자리 수부터 넣음 
	         number2.add( num2.charAt(num2.length() - 1 - i)-'0');
		
		  if(num1.length()>num2.length()) { //num1이 num2보다 큰 수 일때 
		   		return 1;	}
			   
		   	  else if(num1.length()<num2.length()) {//num2이 num1보다 큰 수 일때 
		   		  return -1;		}
			    
			    
		   	  else {
		   			  int i1=1;
		   			  while(true) {
			    			 if(i1>num1.length()) {   //두수가 완전히 같음 flag=2
			    				 return 0;
			    			 }
			    			 
			    		 if(number1.get(number1.size()-i1)>number2.get(number2.size()-i1)) { //num1이 num2보다 큰 수 일때
			    			return 1;
			    		 }
			    		 else if(number2.get(number2.size()-i1)>number1.get(number1.size()-i1)) {//num2이 num1보다 큰 수 일때 
			    			 return -1;
			    		 }
			    		 i1++;
		   		  }
		   	  }
	    
		
	}
	
	public static String BinDiv(String num1,String num2, int chk1,int chk2) {
		int flag=0;
		
		if(num2.equals("0")) {
			return "0으로 나눌 수 없습니다.";
		}
			
		else if(num1.equals(num2))  //두수가 같을 때는 1
				return "1";
		
		if(num2.equals("1")) {
			return num1;
		}
		

	
		
		
		ArrayList<Integer> number1=new ArrayList<Integer>();
		ArrayList<Integer> number2=new ArrayList<Integer>();


		
		
		
		for(int i = 0; i < num1.length(); i++) //num1을 number1 배열에 가장 큰자리 수부터 넣음 
	         number1.add( num1.charAt(num1.length() - 1 - i)-'0');
	    for(int i = 0; i < num2.length(); i++) //num2를 number2 배열에 1의자리 수부터 넣음 
	         number2.add( num2.charAt(num2.length() - 1 - i)-'0');
	  
//		if(chk1==1) { //num1이 음수
//			num1=complement1(number1);
//			for(int i = 0; i < num1.length(); i++) //num1을 number1 배열에 가장 큰자리 수부터 넣음 
//		         number1.add( num1.charAt(num1.length() - 1 - i)-'0');
//		}
//		 
//		if(chk2==1) //num1 num2 둘 다 음수
//		{
//			num2=complement1(number2);
//			for(int i = 0; i < num2.length(); i++) //num1을 number1 배열에 가장 큰자리 수부터 넣음 
//		         number2.add( num2.charAt(num2.length() - 1 - i)-'0');
//		}
		
		
	   
		if(num1.length()>num2.length()) {//num1이 num2보다 큰 수 일때 
	   		  	flag=1;	}
	    
		else if(num1.length()<num2.length()) {//num2이 num1보다 큰 수 일때 
   		  return "0";		}
	    
	    
   	 	else {
   			  int i1=1;
   			  while(true) {
	    			 if(i1>num1.length()) {   //두수가 완전히 같음 flag=2
	    				 return "1";
	    			 }
	    			 
	    		 if(number1.get(number1.size()-i1)>number2.get(number2.size()-i1)) { //num1이 num2보다 큰 수 일 때
	    			 flag=1;
	    			 break;
	    		 }
	    		 else if(number2.get(number2.size()-i1)>number1.get(number1.size()-i1)) {//num2이 num1보다 큰 수 일때 
	    			 return "0";
	    		 }
	    		 i1++;
   		  }
   	  }
	    
	
	  Collections.reverse(number1);  //arraylist 순서 뒤집기. 배열 앞자리수부터 차례대로 들어감
	  Collections.reverse(number2);  
	    
	  ArrayList<Integer> dividend=new ArrayList<Integer>();
	  String strDividend=""; //제수를 자릿수대로 짜른 문자열

	  String strResult=""; //몫을 저장하는 문자열
	  int check=0; //몫이 최초로 1이나온 후 check=1로 해줘서 몫에 0도 나오게 함 
	  for(int i=0;i<number1.size();i++ ) {
		  dividend.add(number1.get(i));
		  strDividend+=dividend.get(i);
		
//		  System.out.println(strDividend);
		  
		  if(compare(num2,strDividend)==1&&check==0) {
			  continue;
		  }
		  else if(compare(num2,strDividend)==1&&check==1)
		  { 
			  strResult+="0";
		  }
		  else if(compare(num2,strDividend)==-1)
		  {		
			  strResult+="1";
			  strDividend=BinSub(strDividend,num2);
			  check=1;
		  }
		  else if(compare(num2,strDividend)==0) {
	
			  strResult+="1";
			  strDividend="";
			  check=1;
		  }
		  else {
			  strResult+="@";
		  }
		  
		  if(strDividend.equals("00")) {
			  strDividend="0";
		  }
	  }
	    
	  if(chk1==1&&chk2==1) {
		  return strResult;
	  }
	  else if(chk1==0&&chk2==0) {
		  return strResult;
	  }
	  else if(chk1==1||chk2==1) { //둘 중 하나만 음수면 최종 출력을 2의 보수로 바꿔줘야함 
		  ArrayList<Integer> toComplement=new ArrayList<Integer>();
			for(int i = 0; i < strResult.length(); i++) //num1을 number1 배열에 가장 큰자리 수부터 넣음 
				toComplement.add(strResult.charAt(strResult.length() - 1 - i)-'0');
		  return complement1(toComplement);
		  
	  }
	  
		
	  

		return "odd num";
		
	}
	
	
	public static String BinMul(String num1, String num2,int chk1,int chk2){
		
		if(num1.equals("0") || num2.equals("0"))
	        return "0";
		
	
	   
		
		String subResult;   //num2의 한자리수와 num1의 곱을 저장하는 문자열
		String finalResult=new String();  //최종 값을 저장하는 문자열
		
		
		
		// Number2의 길이 
		int lengthOfNumber2 = num2.length(); 
		

	
	      ArrayList<Integer> number1 = new ArrayList<Integer>(); 
	      ArrayList<Integer> number2 = new ArrayList<Integer>();   //num2를 받을 ArrayList
	      
	      
	      for(int i = 0; i < num1.length(); i++) //num2를 number2 배열에 1의자리 수부터 넣음 
		         number1.add( num1.charAt(num1.length() - 1 - i)-'0');
		    for(int i = 0; i < num2.length(); i++) //num2를 number2 배열에 1의자리 수부터 넣음 
		         number2.add( num2.charAt(num2.length() - 1 - i)-'0');
	      
			if(chk1==1) { //num1이 음수
				num1=complement1(number1);
				for(int i = 0; i < num1.length(); i++) //num2를 number2 배열에 1의자리 수부터 넣음 
			         number1.add( num1.charAt(num1.length() - 1 - i)-'0');
			}
			 
			if(chk2==1) //num2가 음수
			{
				num2=complement1(number2);
				  for(int i = 0; i < num2.length(); i++) //num2를 number2 배열에 1의자리 수부터 넣음 
				         number2.add( num2.charAt(num2.length() - 1 - i)-'0');
			}
		    
		    

				
				for(int i=0; i < lengthOfNumber2 ; i++)
				{
					//Number2의 한자리와 Number1의 곱
					subResult = BinSubMul(num1, number2.get(i));
					
					//자리수를 맞춰줌. (뒤에 0을 붙여줌.)
					for(int j=0; j< i ; j++) {
						subResult = subResult + "0";
					
					}

					finalResult = BinAdd(finalResult, subResult,0,0); 
				}		
		
				  if(chk1==1&&chk2==1) {
					  return finalResult;
				  }
				  else if(chk1==0&&chk2==0) {
					  return finalResult;
				  }
				  else if((chk1==1&&chk2==0)||(chk1==0&&chk2==1)) { //둘 중 하나만 음수면 최종 출력을 2의 보수로 바꿔줘야함 
					  ArrayList<Integer> toComplement=new ArrayList<Integer>();
						for(int i = 0; i < finalResult.length(); i++) //num1을 number1 배열에 가장 큰자리 수부터 넣음 
							toComplement.add(finalResult.charAt(finalResult.length() - 1 - i)-'0');
					 return  complement1(toComplement);
  
				  }
				return "-1";
	
	}
	
	
	
	public static String BinSubMul(String num1, int n) {  
		String finalResult="";
		int lengthOfNumber1=num1.length();
		
		ArrayList<Integer> number1 = new ArrayList<Integer>();
		ArrayList<Integer> subResult=new ArrayList<Integer>();
		
		   for(int i = 0; i < num1.length(); i++) //num1을 number1 배열에 1의자리 수부터 넣음 
		         number1.add( num1.charAt(num1.length() - 1 - i)-'0');
		   	
		   int[] carryNum=new int [lengthOfNumber1+1]; //올림수를 저장하는 배열
		carryNum[0]=0;
		   
		for(int i=0;i<lengthOfNumber1;i++) {
			subResult.add((carryNum[i]+number1.get(i)*n)%2); 
			carryNum[i+1]=(carryNum[i]+number1.get(i)*n)/2;
		}
		
		for(int i=0;i<subResult.size();i++) {
			finalResult+=subResult.get(subResult.size()-i-1);
		}
		
		
		return finalResult;
	}
	
	
	
	public static String BinSub(String num1,String num2) {

		String finalResult=new String();
		 ArrayList<Integer> number1 = new ArrayList<Integer>();   //num1
	      ArrayList<Integer> number2 = new ArrayList<Integer>();   //num2
	      ArrayList<Integer> result = new ArrayList<Integer>();
		
		  ArrayList<Integer> carryNumber1 = new ArrayList<Integer>(); //1을 저장한 배열
		  ArrayList<Integer>  number2_complement = new ArrayList<Integer>();
		
		  
		  int flag=0;//num1과 num2를 비교해서 num2가 크면 flag를 1로 num1과 num2가 같으면 flag를 2로 초기화
		  int preventDigit,highDigit;  //현재 자릿수와 현재자릿수보다 높은 자릿수 숫자
		  int carryNum;
		  
		  for(int i = 0; i < num1.length(); i++) //num1을 number1 배열에 1의자리 수부터 넣음 
		         number1.add( num1.charAt(num1.length() - 1 - i)-'0');
		    for(int i = 0; i < num2.length(); i++) //num2를 number2 배열에 1의자리 수부터 넣음 
		         number2.add( num2.charAt(num2.length() - 1 - i)-'0');
		  
		    if(num1.length()>num2.length()) { //num1이 num2보다 큰 수 일때 
	    		  flag=0;
	    	  }
	    	  else if(num1.length()<num2.length()) {//num2이 num1보다 큰 수 일때 
	    		  flag=1;
	    	  }
	    	  else {
	    	
	    			  int i1=1;
	    			  while(true) {
	 	    			 if(i1>num1.length()) {   //두수가 완전히 같음 flag=2
	 	    				 flag=2;
	 	    				 break;
	 	    			 }
	 	    			 
	 	    		 if(number1.get(number1.size()-i1)>number2.get(number2.size()-i1)) { //num1이 num2보다 큰 수 일때
	 	    			flag=0;
	 	    			 break;
	 	    		 }
	 	    		 else if(number2.get(number2.size()-i1)>number1.get(number1.size()-i1)) {//num2이 num1보다 큰 수 일때 
	 	    			
	 	    			 flag=1;
	 	    			 break;
	 	    		 }
	 	    		 i1++;
	    		  }
	    	  }
	  	    if(number1.size() >= number2.size()) {      //두 숫자의 자릿수를 맞추기위해 0을 넣어줌
		        for(int i =0 ; i < num1.length() -num2.length(); i++)
		         number2.add(0);
		     }
		    else {
		         for(int i = 0; i < num2.length() - num1.length(); i++)
		            number1.add(0);
		      }
		      
			
	    	 
	    	 
	    	  //number1이 number2보다 클 때
	    	  if(flag==0) {
	    		
	    		   	for(int j=0;j<number1.size();j++) 
	    	    	{
	    	    		if(number1.get(j)-number2.get(j)>=0) {    //자릿수 뺄셈할 때 num1이 더크면 일반 뺄셈
	    	    			result.add(number1.get(j)-number2.get(j));
	    	    		}
	    	    		else {                              //자릿수 뺄셈할 때 num2의 자릿수가 더 크면 num1의 앞자리에서 내림수 받음
	    	    			preventDigit=number1.get(j);
	    	    			preventDigit+=2;
	    	    			number1.set(j, preventDigit);
	    	    			
	    	    			highDigit=number1.get(j+1);
	    	    			highDigit--;
	    	    			number1.set(j+1,highDigit);
	    	    			
	    	    			result.add(number1.get(j)-number2.get(j));
	    	    		}
	    	    	}
	    		   	
	    	
	    		  
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
	    		    for(int i = 1; i < number2.size(); i++) //  number2에 1의 보수에 1을 더하기 위한 과정
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
	    		
	    		  for(int i = 0; i < number2.size(); i++) {   //number1과   2의보수 취해준 number2와의 덧셈
	    			  result.add((carryNum+number1.get(i)+ number2_complement.get(i))%2); //result에 자릿수+이전 자릿수 올림수 한다음 2로 나눈 나머지
	    	        	if(carryNum+number1.get(i)+ number2_complement.get(i)>=2)
	    	        		carryNum=(carryNum+number1.get(i)+ number2_complement.get(i))/2;
	    	        	else {
	    	        		carryNum=0;
	    	        	}
	    	       
	    	       }
	   
	    		 }


	    	  else if(flag==2) { //두 수가 완전히 같을 때

	    		  result.add(0);
	    	  }
		    
	    	  int cnt=result.size();
	    	  
	    	  for(int i=0;i<cnt-1;i++) {
	  	   	if(result.get(cnt-i-1)!=0)  //맨 앞자리가 0이면 0제거
		   		break;
	  	   	else {
	  	   		result.remove(cnt-i-1);
	  	   	}
	    	  }
	    	  
	    	  for(int i=0;i<result.size();i++) //거꾸로 있는 result를 거꾸로 입력받음
	    	  finalResult+=result.get(result.size() - i - 1);
	    	  
	    	
	    	  
		return finalResult;
	}
	
	
	public static String BinAdd(String num1,String num2, int chk1,int chk2) {
		
	
		String finalResult=new String();
		 ArrayList<Integer> number1 = new ArrayList<Integer>();   //num1을 넣는 배열
	      ArrayList<Integer> number2 = new ArrayList<Integer>();   //num2을 넣는 배열
	      ArrayList<Integer> result = new ArrayList<Integer>();
	     
	      int carryNum=0; //덧셈 계산시 올림수를 저장함
	      
	      for(int i = 0; i < num1.length(); i++) //num1을 number1 배열에 1의자리 수부터 넣음 
	         number1.add( num1.charAt(num1.length() - 1 - i)-'0');
	    for(int i = 0; i < num2.length(); i++) //num2를 number2 배열에 1의자리 수부터 넣음 
	         number2.add( num2.charAt(num2.length() - 1 - i)-'0');
	      
	    
	    if(number1.size() >= number2.size()) {      //두 배열의 사이즈를 맞춰줌
	        for(int i =0 ; i < num1.length() -num2.length(); i++)
	         number2.add(0);
	     }
	    else {
	         for(int i = 0; i < num2.length() - num1.length(); i++)
	            number1.add(0);
	      }
	    
	    
	    number1.add(0); number2.add(0);  //올림수가 생길 수 있으니 맨 앞자리에 0을 추가
	    
	    for(int i = 0; i < number1.size(); i++) {   //덧셈 하는 과정
        	result.add((carryNum+number1.get(i)+number2.get(i))%2);
        	if(carryNum+number1.get(i)+number2.get(i)>=2)
        		carryNum=(carryNum+number1.get(i)+number2.get(i))/2;
        	else {
        		carryNum=0;
        	}
       }
	
         if(result.get(result.size() - 1) == 0)      //결과값 맨 앞이 0일 경우 0지워줌
           result.remove(result.size() - 1);
	    
         
     	if (chk1==1&&chk2==1) //음수 더하기 음수일 경우
     	{
     		return complement1(result);
     	}

         for(int i=0;i<result.size();i++) {
        	 finalResult+=result.get(result.size() - i - 1);
         }
         
         
         
         
         return finalResult;
	}
	
	
	public static String complement1(ArrayList<Integer> num) {
        
        int carryNum;
        String s="";
        ArrayList<Integer> carryNumber1 = new ArrayList<Integer>(); //1을 저장한 배열
          ArrayList<Integer>  number2_complement = new ArrayList<Integer>();
          // number2 1의 보수로 바꿔줌
                 for(int i=0;i<num.size();i++) {   
                    if(num.get(i)==0) {
                       num.set(i,1);
                    }
                    else if(num.get(i)==1) {
                       num.set(i, 0);
                    }
                 }
            
             
                 carryNumber1.add(1);
                   for(int i = 1; i < num.size(); i++) //  number2에 1의 보수에 1을 더하기 위한 과정
                        carryNumber1.add(0);
                 
                
               
                      carryNum=0;
                      
                 for(int i =  0; i <num.size() ; i++) {   //1의 보수에 +1
                    number2_complement.add((carryNum+num.get(i)+carryNumber1.get(i))%2);
                       if(carryNum+carryNumber1.get(i)+num.get(i)>=2) {
                          carryNum=1;
                       }
                       else {
                          carryNum=0;
                       }
              
                   }
                 
                 int size= number2_complement.size();
         
                
                   for(int i=0;i<number2_complement.size();i++) {
                      s+=number2_complement.get(i);
                   }

                 return s;
     }

  
}
	

