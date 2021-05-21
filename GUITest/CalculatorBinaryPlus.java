import java.util.ArrayList;
import java.util.Scanner;

public class CalculatorBinaryPlus {

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
     

    
    
      if(operator.equals("+")) {   //연산자가 + 일 때 => 덧셈
    	  
    	    if(number1.size() >= number2.size()) {      //자릿수가 적은 곳에 0으로 채워서 자릿수(배열 크기) 맞추기
    	        for(int i =0 ; i < num1.length() -num2.length(); i++)
    	         number2.add(0);
    	     }
    	    else {
    	         for(int i = 0; i < num2.length() - num1.length(); i++)
    	            number1.add(0);
    	      }
    	      
    	  
    	    System.out.println(number1);

    	    System.out.println(number2);
    	    
    	  
        number1.add(0); number2.add(0);         //최고 자리에서 올림수가 발생할 수 있으므로 맨 앞자리에 0추가
        

        for(int i = 0; i < number1.size(); i++) {   //자릿수만큼 두 배열을 더함. carryNum값은 10이상의 값이 나왔을 경우 1, 10 미만이면 0으로 초기화, 두 수(배열)의 자릿수를 맞춰줘서 number1, number2 아무거나 써도 됨
        	result.add((carryNum+number1.get(i)+number2.get(i))%2);
        	if(carryNum+number1.get(i)+number2.get(i)>=2)
        		carryNum=1;
        	else {
        		carryNum=0;
        	}
       
       }
	
         if(result.get(result.size() - 1) == 0)      //결과값의 맨 앞자리가 0이면 0삭제
           result.remove(result.size() - 1);
         
        
      for(int i = 0; i < result.size(); i++)   //결과값 출력
         System.out.print(result.get(result.size() - i - 1));   //1의 자리부터 저장했으므로 반대로 출력 
   }
  
      input.close();
   		}
   }
