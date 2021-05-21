import java.util.ArrayList;
import java.util.Scanner;
public class CalculatorTenSubstract {

	public static void main(String[] args) {
	      String num1, num2, operator;
	      ArrayList<Integer> number1 = new ArrayList<Integer>();   //num1이 들어갈 배열
	      ArrayList<Integer> number2 = new ArrayList<Integer>();   //num2가 들어갈 배열
	      ArrayList<Integer> result = new ArrayList<Integer>(); 
	      
	      
	      ArrayList<Integer> bigNum=new ArrayList<Integer>();  //뺄셈을 위한 큰 수가 들어갈 배열
	      ArrayList<Integer> smallNum=new ArrayList<Integer>();
	      
	      int highDigit,preventDigit=0;  //highDigit은 현재 계산 자리수보다 한자리 높은 수, prevent는 현재 계산 자릿수
	      Scanner input = new Scanner(System.in);
	      System.out.print("num1을 입력하시오: ");
	      num1 = input.nextLine();
	      System.out.print("연산자를 입력하시오: ");
	      operator = input.nextLine();
	      System.out.print("num2을 입력하시오: ");
	      num2 = input.nextLine();
	      
	      int flag=0; //최종값이 음수라면 flag를 1로 둠
	      
	      for(int i = 0; i < num1.length(); i++) //num1의 뒷자리부터 배열number1에 저장
	          number1.add( num1.charAt(num1.length() - 1 - i)-'0');

	     
	     for(int i = 0; i < num2.length(); i++) //num2의 뒷자리부터 배열number2에 저장
	          number2.add( num2.charAt(num2.length() - 1 - i)-'0');
	      
	     if(operator.equals("-"))
	     {
	    	 if(num1.length()>num2.length())        //큰 수 비교 if문
	    	 {
	    		 bigNum=number1;
	    		 smallNum=number2;
	    	 }
	    	 else if(num2.length()>num1.length()) //뒤에 입력한 num2가 더 크다면 flag값을 1로 바꿔서 마지막에 음수로 출력함
	    	 {
	    		 bigNum=number2;
	    		 smallNum=number1;
	    		 flag=1; //작은 값에서 큰 값을 빼기 때문에 flag=1
	    	 }
	    	 else  {
	    		 int i=1;  //자릿수만큼 반복문이 돌아갔을 때
	    		 while(true) {
	    			 if(i>=num1.length()) {   //모든 자릿수를 비교했을 때. 두수가 같을 경우 bigNum이 무엇이든 상관없음
	    				 bigNum=number1;
		    			 smallNum=number2;
		    			 break;
	    			 }
	    			 
	    		 if(number1.get(num1.length()-i)>number2.get(num2.length()-i)) { //number1이 number2보다 큰경우
	    			 bigNum=number1;
	    			 smallNum=number2;
	    			 break;
	    		 }
	    		 else if(number2.get(num1.length()-i)>number1.get(num1.length()-i)) {//number2이 number1보다 큰경우
	    			 bigNum=number2;
	    			 smallNum=number1;
	    			 break;
	    		 }
	    		 else {   // 자릿수 비교에서 같을 경우 낮은 자리수를 비교함
	    			 i++;
	    			 continue;
	    		 }
	    	
	    		 			}
	    		 }
	    	 
	   
	    	for(int j=smallNum.size();j<bigNum.size();j++) {   //원활한 계산을 위해 작은 수에 0을 넣어서 큰수와 자릿수를 맞춰줌
	    		smallNum.add(0);
	    	
	    	}
	    	
	    	
	    	System.out.println(smallNum);
	    	System.out.println(bigNum);
	    
	    	for(int j=0;j<smallNum.size();j++)  //뺄셈하는 과정
	    	{
	    		if(bigNum.get(j)-smallNum.get(j)>=0) {    //내림수가 필요없이 큰수가 작은수보다 자릿수가 클때
	    			result.add(bigNum.get(j)-smallNum.get(j));
	    		}
	    		else {                              //내림수가 필요하다면 현재 자릿수에는 +10을 해줘서 계산하고 윗 자리수에 -1을 한다.
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
	     
			
			  int k=1; //맨 앞자리에 0이 나오는 것을 방지
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
	     for(int i = 0; i < result.size(); i++)   //결과값 출력
	         System.out.print(result.get(result.size() - i - 1));   //1의 자리부터 저장했으므로 반대로 출력
	     }
	     else {
	    	 System.out.print("-");
	    	 for(int i = 0; i < result.size(); i++)
	    	 System.out.print(result.get(result.size() - i - 1));
	     }
	     

	     input.close();
	}

}
