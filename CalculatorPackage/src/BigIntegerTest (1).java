import java.util.ArrayList;
import java.util.Scanner;

public class BigIntegerTest {
 
   public static void main(String[] args) {
      String num1, num2, operator;
      int count = 0;   //자릿수 카운트
      ArrayList<Integer> number1 = new ArrayList<Integer>();   //num1이 들어갈 배열
      ArrayList<Integer> number2 = new ArrayList<Integer>();   //num2가 들어갈 배열
      ArrayList<Integer> result = new ArrayList<Integer>();   //결과값
      
      Scanner input = new Scanner(System.in);
      System.out.print("num1을 입력하시오: ");
      num1 = input.nextLine();
      System.out.print("연산자를 입력하시오: ");
      operator = input.nextLine();
      System.out.print("num2을 입력하시오: ");
      num2 = input.nextLine();
      
      for(int i = 0; i < num1.length(); i++) //num1의 뒷자리부터 배열number1에 저장
         number1.add(num1.charAt(num1.length() - 1 - i) - '0');

      for(int i = 0; i < num2.length(); i++) //num2의 뒷자리부터 배열number2에 저장
         number2.add(num2.charAt(num2.length() - 1 - i) - '0');
      
      if(number1.size() >= number2.size()) {      //자릿수가 적은 곳에 0으로 채워서 자릿수(배열 크기) 맞추기
         for(int i = 0; i < (num1.length() - num2.length()); i++)
            number2.add(0);
      }
      else {
         for(int i = 0; i < (num2.length() - num1.length()); i++)
            number1.add(0);
      }
      
      if(operator.equals("+")) {   //연산자가 + 일 때 => 덧셈
         number1.add(0); number2.add(0);        //최고 자리에서 올림수가 발생할 수 있으므로 맨 앞자리에 0추가
         ArrayList<Integer> carry = new ArrayList<Integer>();   //올림수 배열 생성
         
         result.add(((number1.get(0) + number2.get(0)) % 10));   //1의 자리 먼저 계산(덧셈)
         carry.add((number1.get(0) + number2.get(0)) / 10);      //1의 자리 덧셈에서 발생한 올림수(0 또는 1)
         
         for(int i = 1; i < number1.size(); i++) {   //자릿수-1 만큼 반복문 실행(위에서 1의 자리 계산 먼저함), 두 수(배열)의 자릿수를 맞춰줘서 number1, number2 아무거나 써도 됨
            carry.add((number1.get(i) + number2.get(i) + carry.get(i - 1)) / 10);      //각 자릿수에서 발생한 올림수(0 또는 1)
            result.add(i, (number1.get(i) + number2.get(i) + carry.get(i - 1)) % 10);   //같은 자릿수의 합 + 앞에서 발생한 올림수
         }
         
         if(result.get(result.size() - 1) == 0)      //결과값의 맨 앞자리가 0이면 0삭제
            result.remove(result.size() - 1);
         
         for(int i = 0; i < result.size(); i++)   //결과값 출력
            System.out.print(result.get(result.size() - i - 1));   //1의 자리부터 저장했으므로 반대로 출력
      }
      
      else if(operator.equals("-")) {   //연산자가 - 일 때 => 뺄셈
         ArrayList<Integer> borrow = new ArrayList<Integer>();   //빌림수(?) 배열 생성
         
         borrow.add(0);      //계산의 편리함을 위해 첫 빌림수를 0으로 설정
         
         if(num1.length() > num2.length()) {   //num1 자릿수가 num2보다 클 때, 즉 num1 > num2 일 때
            for(int i = 0; i < num1.length(); i++) {
               if((number1.get(i) - borrow.get(i)) >= number2.get(i)) {   //같은 자릿수에서 num1 > num2 일 때(앞자리에서 내림이 발생하면 num1-1)
                  borrow.add(0);                  //다음 자릿수에서 빌려오는 수 없음
                  result.add(number1.get(i) - borrow.get(i) - number2.get(i));    //num1 - num2를 result에 저장, 앞자리에서 내림이 발생했으면 -1해줌
               }
               else {                     //같은 자릿수에서 num1 < num2 일 때
                  borrow.add(1);            //다음 자릿수에서 10빌려옴
                  result.add(10 + number1.get(i) - borrow.get(i) - number2.get(i));   //(10+num1)-num2를 result에 저장, 앞자리에서 내림이 발생했으면 -1해줌
               }
            }
         }
         else if(num1.length() ==  num2.length()) {   //num1과 num2의 자릿수가 같을 때
            for(int i = number1.size() - 1; i >= 0; i--) {   //높은 자릿수부터 크기비교
               if(number1.get(i) > number2.get(i)) {      //num1 > num2 일 때
                  for(int j = 0; j < num1.length(); j++) {      //60~69행과 동일
                       if((number1.get(j) - borrow.get(j)) >= number2.get(j)) {
                          borrow.add(0);
                          result.add(number1.get(j) - borrow.get(j) - number2.get(j));
                       }
                       else {
                          borrow.add(1);
                          result.add(10 + number1.get(j) - borrow.get(j) - number2.get(j));
                       }
                    }
                  break;
               }
               
               else if(number1.get(i) == number2.get(i)) {   //num1 = num2 일 때
                  count++;
                  if(count != number1.size())
                     continue;
                  
                  borrow.add(0);                     //빌림수 0
                  result.add(0);                     //result 0
               }
               else {                            //num1 < num2 일 때
                  for(int j = 0; j < number1.size(); j++) {      //60~69행과 동일 다만 num2 - num1으로 실행
                       if((number2.get(j) - borrow.get(j)) >= number1.get(j)) {
                          borrow.add(0);
                          result.add(number2.get(j) - borrow.get(j) - number1.get(j));
                       }
                       else {
                          borrow.add(1);
                          result.add(10 + number2.get(j) - borrow.get(j) - number1.get(j));
                       }
                    }
                  result.add((int) '-');
                  break;
               }
            }
         }
         else {   //num1 자릿수보다 num2 자릿수가 더 클 때, 즉 num1 < num2 일 때
            for(int i = 0; i < number1.size(); i++) {      //60~69행과 동일 다만 num2 - num1으로 실행
                 if((number2.get(i) - borrow.get(i)) >= number1.get(i)) {
                    borrow.add(0);
                    result.add(number2.get(i) - borrow.get(i) - number1.get(i));
                 }
                 else {
                    borrow.add(1);
                    result.add(10 + number2.get(i) - borrow.get(i) - number1.get(i));
                 }
              }
            result.add((int) '-');
         }
         if(result.size() != 1) {         //result가 한자리수가 아닐때
            int c = 0;
            if(result.get(result.size() - 1) == 45)   //result 맨 앞이 '-'이면
               c = 1;
               for(int i = result.size() - 1 - c; i > 0; i--) {   //result 맨 앞이 '-'이면 그 다음 자릿수부터~
                  if(result.get(i) == 0)      //결과값의 앞자리가 0이면 0삭제
                     result.remove(i);
                  else
                     break;
               }
         }
          
          for(int i = 0; i < result.size(); i++)  { //결과값 출력
             if(result.get(result.size() - i - 1) == 45)      //result 맨 앞자리에 45, 즉 '-'가 들어있으면
                System.out.print("-");                  //숫자45 대신 '-' 출력
             else
                System.out.print(result.get(result.size() - i - 1));   //1의 자리부터 저장했으므로 반대로 출력
          }
      }
      
      
      
   }

}