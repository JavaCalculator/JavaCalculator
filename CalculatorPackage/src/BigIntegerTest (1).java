import java.util.ArrayList;
import java.util.Scanner;

public class BigIntegerTest {
 
   public static void main(String[] args) {
      String num1, num2, operator;
      int count = 0;   //�ڸ��� ī��Ʈ
      ArrayList<Integer> number1 = new ArrayList<Integer>();   //num1�� �� �迭
      ArrayList<Integer> number2 = new ArrayList<Integer>();   //num2�� �� �迭
      ArrayList<Integer> result = new ArrayList<Integer>();   //�����
      
      Scanner input = new Scanner(System.in);
      System.out.print("num1�� �Է��Ͻÿ�: ");
      num1 = input.nextLine();
      System.out.print("�����ڸ� �Է��Ͻÿ�: ");
      operator = input.nextLine();
      System.out.print("num2�� �Է��Ͻÿ�: ");
      num2 = input.nextLine();
      
      for(int i = 0; i < num1.length(); i++) //num1�� ���ڸ����� �迭number1�� ����
         number1.add(num1.charAt(num1.length() - 1 - i) - '0');

      for(int i = 0; i < num2.length(); i++) //num2�� ���ڸ����� �迭number2�� ����
         number2.add(num2.charAt(num2.length() - 1 - i) - '0');
      
      if(number1.size() >= number2.size()) {      //�ڸ����� ���� ���� 0���� ä���� �ڸ���(�迭 ũ��) ���߱�
         for(int i = 0; i < (num1.length() - num2.length()); i++)
            number2.add(0);
      }
      else {
         for(int i = 0; i < (num2.length() - num1.length()); i++)
            number1.add(0);
      }
      
      if(operator.equals("+")) {   //�����ڰ� + �� �� => ����
         number1.add(0); number2.add(0);        //�ְ� �ڸ����� �ø����� �߻��� �� �����Ƿ� �� ���ڸ��� 0�߰�
         ArrayList<Integer> carry = new ArrayList<Integer>();   //�ø��� �迭 ����
         
         result.add(((number1.get(0) + number2.get(0)) % 10));   //1�� �ڸ� ���� ���(����)
         carry.add((number1.get(0) + number2.get(0)) / 10);      //1�� �ڸ� �������� �߻��� �ø���(0 �Ǵ� 1)
         
         for(int i = 1; i < number1.size(); i++) {   //�ڸ���-1 ��ŭ �ݺ��� ����(������ 1�� �ڸ� ��� ������), �� ��(�迭)�� �ڸ����� �����༭ number1, number2 �ƹ��ų� �ᵵ ��
            carry.add((number1.get(i) + number2.get(i) + carry.get(i - 1)) / 10);      //�� �ڸ������� �߻��� �ø���(0 �Ǵ� 1)
            result.add(i, (number1.get(i) + number2.get(i) + carry.get(i - 1)) % 10);   //���� �ڸ����� �� + �տ��� �߻��� �ø���
         }
         
         if(result.get(result.size() - 1) == 0)      //������� �� ���ڸ��� 0�̸� 0����
            result.remove(result.size() - 1);
         
         for(int i = 0; i < result.size(); i++)   //����� ���
            System.out.print(result.get(result.size() - i - 1));   //1�� �ڸ����� ���������Ƿ� �ݴ�� ���
      }
      
      else if(operator.equals("-")) {   //�����ڰ� - �� �� => ����
         ArrayList<Integer> borrow = new ArrayList<Integer>();   //������(?) �迭 ����
         
         borrow.add(0);      //����� ������ ���� ù �������� 0���� ����
         
         if(num1.length() > num2.length()) {   //num1 �ڸ����� num2���� Ŭ ��, �� num1 > num2 �� ��
            for(int i = 0; i < num1.length(); i++) {
               if((number1.get(i) - borrow.get(i)) >= number2.get(i)) {   //���� �ڸ������� num1 > num2 �� ��(���ڸ����� ������ �߻��ϸ� num1-1)
                  borrow.add(0);                  //���� �ڸ������� �������� �� ����
                  result.add(number1.get(i) - borrow.get(i) - number2.get(i));    //num1 - num2�� result�� ����, ���ڸ����� ������ �߻������� -1����
               }
               else {                     //���� �ڸ������� num1 < num2 �� ��
                  borrow.add(1);            //���� �ڸ������� 10������
                  result.add(10 + number1.get(i) - borrow.get(i) - number2.get(i));   //(10+num1)-num2�� result�� ����, ���ڸ����� ������ �߻������� -1����
               }
            }
         }
         else if(num1.length() ==  num2.length()) {   //num1�� num2�� �ڸ����� ���� ��
            for(int i = number1.size() - 1; i >= 0; i--) {   //���� �ڸ������� ũ���
               if(number1.get(i) > number2.get(i)) {      //num1 > num2 �� ��
                  for(int j = 0; j < num1.length(); j++) {      //60~69��� ����
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
               
               else if(number1.get(i) == number2.get(i)) {   //num1 = num2 �� ��
                  count++;
                  if(count != number1.size())
                     continue;
                  
                  borrow.add(0);                     //������ 0
                  result.add(0);                     //result 0
               }
               else {                            //num1 < num2 �� ��
                  for(int j = 0; j < number1.size(); j++) {      //60~69��� ���� �ٸ� num2 - num1���� ����
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
         else {   //num1 �ڸ������� num2 �ڸ����� �� Ŭ ��, �� num1 < num2 �� ��
            for(int i = 0; i < number1.size(); i++) {      //60~69��� ���� �ٸ� num2 - num1���� ����
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
         if(result.size() != 1) {         //result�� ���ڸ����� �ƴҶ�
            int c = 0;
            if(result.get(result.size() - 1) == 45)   //result �� ���� '-'�̸�
               c = 1;
               for(int i = result.size() - 1 - c; i > 0; i--) {   //result �� ���� '-'�̸� �� ���� �ڸ�������~
                  if(result.get(i) == 0)      //������� ���ڸ��� 0�̸� 0����
                     result.remove(i);
                  else
                     break;
               }
         }
          
          for(int i = 0; i < result.size(); i++)  { //����� ���
             if(result.get(result.size() - i - 1) == 45)      //result �� ���ڸ��� 45, �� '-'�� ���������
                System.out.print("-");                  //����45 ��� '-' ���
             else
                System.out.print(result.get(result.size() - i - 1));   //1�� �ڸ����� ���������Ƿ� �ݴ�� ���
          }
      }
      
      
      
   }

}