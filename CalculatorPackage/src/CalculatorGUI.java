import java.awt.EventQueue;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JRadioButton;

public class CalculatorGUI {
   
   char operator;
   double num1=0.0,num2=0.0,result=0.0; // num1 앞에 값, num2 연산자 뒤에 나올 값, result 결과값
   String num11,num22,result11;
   private JFrame frame; 
   //private ArrayList<String> equation=new ArrayList<String>();

   /**
    * Launch the application.
    */
 
   
   
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               CalculatorGUI window = new CalculatorGUI();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public CalculatorGUI() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   public void initialize() {
      frame = new JFrame(); //계산기 창 생성
      frame.getContentPane().setBackground(Color.BLACK);
      frame.setBounds(100, 100, 566, 681);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
     
      
      JLabel answer = new JLabel("0"); // 현재 상태 Text를 알려주는 answer
      answer.setBackground(Color.ORANGE);
      answer.setForeground(Color.WHITE);
      answer.setHorizontalAlignment(SwingConstants.RIGHT);
      answer.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      answer.setBounds(22, 43, 325, 170);
      frame.getContentPane().add(answer);  
      
      JLabel preventValue = new JLabel("0"); // 현재 상태 Text를 알려주는 answer
      preventValue.setBackground(Color.ORANGE);
      preventValue.setForeground(Color.WHITE);
      preventValue.setHorizontalAlignment(SwingConstants.RIGHT);
      preventValue.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      preventValue.setBounds(22, 43, 325, 60);
      frame.getContentPane().add(preventValue); 
      
      
      JButton btn7 = new JButton("7"); //button 7 디자인
      btn7.setBackground(Color.GRAY);
      btn7.setForeground(Color.WHITE);
      btn7.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btn7.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btn7.setBounds(22, 244, 98, 91);
      frame.getContentPane().add(btn7);
      
      JButton btn8 = new JButton("8"); //button 8 디자인
      btn8.setBackground(Color.GRAY);
      btn8.setForeground(Color.WHITE);
      btn8.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btn8.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
         }
      });
      btn8.setBounds(132, 244, 98, 91);
      frame.getContentPane().add(btn8);
      
      JButton btn9 = new JButton("9"); //button 9 디자인
      btn9.setBackground(Color.GRAY);
      btn9.setForeground(Color.WHITE);
      btn9.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btn9.setBounds(241, 244, 98, 91);
      frame.getContentPane().add(btn9);
      
      JButton btn4 = new JButton("4"); //button 4 디자인
      btn4.setForeground(Color.WHITE);
      btn4.setBackground(Color.GRAY);
      btn4.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btn4.setBounds(22, 345, 98, 91);
      frame.getContentPane().add(btn4);
      
      JButton btn5 = new JButton("5"); //button 5 디자인
      btn5.setForeground(Color.WHITE);
      btn5.setBackground(Color.GRAY);
      btn5.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btn5.setBounds(132, 345, 98, 91);
      frame.getContentPane().add(btn5);
      
      JButton btn6 = new JButton("6"); //button 6 디자인
      btn6.setBackground(Color.GRAY);
      btn6.setForeground(Color.WHITE);
      btn6.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btn6.setBounds(241, 345, 98, 91);
      frame.getContentPane().add(btn6);
      
      JButton btn1 = new JButton("1"); //button 1 디자인
      btn1.setBackground(Color.GRAY);
      btn1.setForeground(Color.WHITE);
      btn1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btn1.setBounds(22, 442, 98, 91);
      frame.getContentPane().add(btn1);
      
      JButton btn2 = new JButton("2"); //button 2 디자인
      btn2.setBackground(Color.GRAY);
      btn2.setForeground(Color.WHITE);
      btn2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btn2.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btn2.setBounds(132, 442, 98, 91);
      frame.getContentPane().add(btn2);
      
      JButton btn3 = new JButton("3"); //button 3 디자인
      btn3.setBackground(Color.GRAY);
      btn3.setForeground(Color.WHITE);
      btn3.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btn3.setBounds(241, 442, 98, 91);
      frame.getContentPane().add(btn3);
      
      JButton btn0 = new JButton("0"); //button 0 디자인
      btn0.setBackground(Color.GRAY);
      btn0.setForeground(Color.WHITE);
      btn0.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btn0.setBounds(132, 543, 98, 91);
      frame.getContentPane().add(btn0);
      
      JButton btnC = new JButton("C"); //button C 디자인
      btnC.setForeground(Color.WHITE);
      btnC.setBackground(Color.LIGHT_GRAY);
      btnC.addActionListener(new ActionListener() {  // 'C'버튼 입력했을 때  
         public void actionPerformed(ActionEvent e) { // 발생하는 이벤트
               String operation = e.getActionCommand(); 
               if(operation.equals("C")) { 
                  answer.setText(""); // 초기화
               }
         }
      });
      btnC.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btnC.setBounds(22, 543, 98, 91);
      frame.getContentPane().add(btnC);
      
      JButton btnEnter = new JButton("="); //button Enter 디자인
      btnEnter.setForeground(Color.WHITE);
      btnEnter.setBackground(Color.LIGHT_GRAY);
      btnEnter.addActionListener(new ActionListener() { // '='버튼 입력했을 때
         public void actionPerformed(ActionEvent e) { //발생하는 이벤트
            num22=answer.getText().toString();
            switch(operator) { // 연산자에 따라 다르게 계산
            case '+':
               result11= BinAdd(num11,num22,0,0);
               break;
            case '-':
               result11=BinSub(num11,num22);
               break;
            case 'X':
               result11=BinMul(num11,num22,0,0);
               break;
            case '÷':
               result11=BinDiv(num11,num22,0,0);
               break;
            }
            answer.setText(result11);
            preventValue.setText(result11);  //check를 사용해서 두번째 계산부턴 이전의 식의 "계산한"값을 넣어줘야함 
          
           num11=result11;
         }
      });
      btnEnter.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btnEnter.setBounds(241, 543, 98, 91);
      frame.getContentPane().add(btnEnter);
      
      JButton btnPlus = new JButton("+");
      btnPlus.setBackground(Color.ORANGE);
      btnPlus.setForeground(Color.WHITE);
      btnPlus.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	
            num11=(answer.getText().toString()); // Text를 string형으로 변환해서 num1에 저장
            operator='+'; 
            answer.setText(""); //Text 초기화 
        
            preventValue.setText(num11+"+");
 
         }
      });
      btnPlus.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btnPlus.setBounds(351, 244, 87, 91);
      frame.getContentPane().add(btnPlus);
      
      JButton btnSub = new JButton("-");
      btnSub.setBackground(Color.ORANGE);
      btnSub.setForeground(Color.WHITE);
      btnSub.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            num11=(answer.getText().toString()); // Text를 string형으로 변환해서 num11에 저장
            operator='-';
            answer.setText(""); //Text 초기화
          preventValue.setText(num11+"-");
         }
      });
      btnSub.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btnSub.setBounds(351, 345, 87, 91);
      frame.getContentPane().add(btnSub);
      
      JButton btnMul = new JButton("X");
      btnMul.setBackground(Color.ORANGE);
      btnMul.setForeground(Color.WHITE);
      btnMul.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 num11=(answer.getText().toString()); // Text를 string형으로 변환해서 num1에 저장
             operator='X'; 
             answer.setText(""); //Text 초기화 
         
             preventValue.setText(num11+"*");
         }
      });
      btnMul.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btnMul.setBounds(351, 442, 87, 91);
      frame.getContentPane().add(btnMul);
      
      JButton btnDiv = new JButton("\u00F7");
      btnDiv.setBackground(Color.ORANGE);
      btnDiv.setForeground(Color.WHITE);
      btnDiv.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 num11=(answer.getText().toString()); // Text를 string형으로 변환해서 num1에 저장
             operator='÷'; 
             answer.setText(""); //Text 초기화 
         
             preventValue.setText(num11+"/");
         }
      });
      btnDiv.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btnDiv.setBounds(351, 543, 87, 91);
      frame.getContentPane().add(btnDiv);
      
      btn0.addActionListener(new NumberActionListener(answer,"0")); // 0을 입력했을때 0출력
      btn1.addActionListener(new NumberActionListener(answer,"1")); // 1을 입력했을때 1출력
      btn2.addActionListener(new NumberActionListener(answer,"2")); // 2을 입력했을때 2출력
      btn3.addActionListener(new NumberActionListener(answer,"3")); // 3을 입력했을때 3출력
      btn4.addActionListener(new NumberActionListener(answer,"4")); // 4을 입력했을때 4출력
      btn5.addActionListener(new NumberActionListener(answer,"5")); // 5을 입력했을때 5출력
      btn6.addActionListener(new NumberActionListener(answer,"6")); // 6을 입력했을때 6출력
      btn7.addActionListener(new NumberActionListener(answer,"7")); // 7을 입력했을때 7출력
      btn8.addActionListener(new NumberActionListener(answer,"8")); // 8을 입력했을때 8출력
      btn9.addActionListener(new NumberActionListener(answer,"9")); // 9을 입력했을때 9출력
      
      JButton btnL2 = new JButton("<<"); // <<연산자 버튼 생성
      btnL2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnL2.setForeground(Color.WHITE);
      btnL2.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btnL2.setBackground(Color.RED);
      btnL2.setBounds(450, 244, 87, 91);
      frame.getContentPane().add(btnL2);
      
      JButton btnAnd = new JButton("&"); // And연산자 버튼 생성
      btnAnd.setForeground(Color.WHITE);
      btnAnd.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btnAnd.setBackground(Color.RED);
      btnAnd.setBounds(450, 345, 87, 91);
      frame.getContentPane().add(btnAnd);
      
      JButton btnOr = new JButton("|"); // |연산자 버튼 생성
      btnOr.setForeground(Color.WHITE);
      btnOr.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btnOr.setBackground(Color.RED);
      btnOr.setBounds(450, 442, 87, 91);
      frame.getContentPane().add(btnOr);
      
      JButton btnXor = new JButton("^"); // ^연산자 버튼 생성
      btnXor.setForeground(Color.WHITE);
      btnXor.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btnXor.setBackground(Color.RED);
      btnXor.setBounds(450, 543, 87, 91);
      frame.getContentPane().add(btnXor);
      
      JButton btnR3 = new JButton(">>>"); /// >>>연산자 버튼 생성
      btnR3.setForeground(Color.WHITE);
      btnR3.setFont(new Font("맑은 고딕", Font.BOLD, 25));
      btnR3.setBackground(Color.RED);
      btnR3.setBounds(450, 43, 87, 91);
      frame.getContentPane().add(btnR3);
      
      JButton btnR2 = new JButton(">>"); // >>연산자 버튼 생성
      btnR2.setForeground(Color.WHITE);
      btnR2.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btnR2.setBackground(Color.RED);
      btnR2.setBounds(450, 143, 87, 91);
      frame.getContentPane().add(btnR2);
      
      JRadioButton btnRadioDec = new JRadioButton("Dec");
      btnRadioDec.setBounds(355, 155, 83, 23);
      frame.getContentPane().add(btnRadioDec);
      
      JRadioButton btnRadioBin = new JRadioButton("Bin");
      btnRadioBin.setBounds(355, 190, 83, 23);
      frame.getContentPane().add(btnRadioBin);
      
      JButton btnRating = new JButton("\uB4F1\uC218\uACC4\uC0B0");
      btnRating.setForeground(Color.WHITE);
      btnRating.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 13));
      btnRating.setBackground(Color.GREEN);
      btnRating.setBounds(351, 43, 87, 91);
      frame.getContentPane().add(btnRating);
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
                      if(i1>=num1.length()) {   //두수가 완전히 같음 flag=2
                         flag=2;
                         break;
                      }
                      
                   if(number1.get(number1.size()-i1)>number2.get(number2.size()-i1)) { //num1이 num2보다 큰 수 일때
                     flag=0;
                      break;}
                   
                   else if(number2.get(number2.size()-i1)>number1.get(number1.size()-i1)) {//num2이 num1보다 큰 수 일때 
                      flag=1;
                      break;}
                   i1++; }
             }
             if(number1.size() >= number2.size()) {      //두 숫자의 자릿수를 맞추기위해 0을 넣어줌
               for(int i =0 ; i < num1.length() -num2.length(); i++)
                number2.add(0); }
           else {
                for(int i = 0; i < num2.length() - num1.length(); i++)
                   number1.add(0); }
             
          
            
            
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
                    
                    if(result.get(result.size()-1)==0)  //맨 앞자리가 0이면 0제거
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
                  for(int i = 1; i < number2.size(); i++) //  number2에 1의 보수에 1을 더하기 위한 과정
                       carryNumber1.add(0);
                
                     carryNum=0;
                     
                for(int i =  0; i <number2.size() ; i++) {   //1의 보수에 +1
                   number2_complement.add((carryNum+number2.get(i)+carryNumber1.get(i))%2);
                      if(carryNum+carryNumber1.get(i)+number2.get(i)>=2) {
                         carryNum=1;
                      }
                      else 
                         carryNum=0;
                  }


                
                
                carryNum=0;
              
                for(int i = 0; i < number2.size(); i++) {   //number1과   2의보수 취해준 number2와의 덧셈
                   result.add((carryNum+number1.get(i)+ number2_complement.get(i))%2); //result에 자릿수+이전 자릿수 올림수 한다음 2로 나눈 나머지
                      if(carryNum+number1.get(i)+ number2_complement.get(i)>=2)
                         carryNum=(carryNum+number1.get(i)+ number2_complement.get(i))/2;
                      else 
                         carryNum=0;
                  }
               }


             else if(flag==2)  //두 수가 완전히 같을 때
                result.add(0);
     
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
    		return complement1(result);
  

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
       
        
               
                  for(int i=0;i<number2_complement.size();i++) {
                     s+=number2_complement.get(i);
                  }

                return s;
    }
   
	 public static String BinDiv(String num1,String num2, int chk1,int chk2) {

        
            
          if(num1.equals(num2))  //두수가 같을 때는 1
               return "1";
         
         if(num2.equals("1")) {
            return num1;
         }
         
         if(num2.equals("0"))
        	 return "0으로 나눌 수 없습니다"; 
   
         
         ArrayList<Integer> number1=new ArrayList<Integer>();
         ArrayList<Integer> number2=new ArrayList<Integer>();

         for(int i = 0; i < num1.length(); i++) //num1을 number1 배열에 가장 큰자리 수부터 넣음 
               number1.add( num1.charAt(num1.length() - 1 - i)-'0');
          for(int i = 0; i < num2.length(); i++) //num2를 number2 배열에 1의자리 수부터 넣음 
               number2.add( num2.charAt(num2.length() - 1 - i)-'0');
        

         

       if(num1.length()<num2.length()) {//num2이 num1보다 큰 수 일때 
              return "0";      }
          
          
             else {
                 int i1=1;
                 while(true) {
                    if(i1>num1.length()) {   //두수가 완전히 같음 flag=2
                       return "1";
                    }
                    
                 if(number1.get(number1.size()-i1)>number2.get(number2.size()-i1)) { //num1이 num2보다 큰 수 일 때
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
         
//           System.out.println(strDividend);
           
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
                  return 1;   }
               
                 else if(num1.length()<num2.length()) {//num2이 num1보다 큰 수 일때 
                    return -1;      }
                
                
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
	 
	 
	
}