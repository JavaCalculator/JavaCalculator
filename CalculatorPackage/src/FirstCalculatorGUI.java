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

public class FirstCalculatorGUI {
   
   char operator;
   double num1=0,num2=0,result=0; // num1 앞에 값, num2 연산자 뒤에 나올 값, result 결과값
   private JFrame frame; 
   //private ArrayList<String> equation=new ArrayList<String>();

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               FirstCalculatorGUI window = new FirstCalculatorGUI();
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
   public FirstCalculatorGUI() {
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
      answer.setFont(new Font("맑은 고딕", Font.BOLD, 50));
      answer.setBounds(22, 43, 325, 170);
      frame.getContentPane().add(answer);  
      
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
            num2=Double.parseDouble(answer.getText());
            switch(operator) { // 연산자에 따라 다르게 계산
            case '+':
               result=num1+num2;
               break;
            case '-':
               result=num1-num2;
               break;
            case 'X':
               result=num1*num2;
               break;
            case '÷':
               result=num1/num2;
               break;
            }
            answer.setText(String.valueOf(result));
            num1=result;
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
            num1=Double.parseDouble(answer.getText()); // Text를 double형으로 변환해서 num1에 저장
            operator='+'; 
            answer.setText(""); //Text 초기화 
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
            num1=Double.parseDouble(answer.getText()); // Text를 double형으로 변환해서 num1에 저장
            operator='-';
            answer.setText(""); //Text 초기화 
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
            num1=Double.parseDouble(answer.getText()); // Text를 double형으로 변환해서 num1에 저장
            operator='X';
            answer.setText("");//Text 초기화 
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
            num1=Double.parseDouble(answer.getText()); // Text를 double형으로 변환해서 num1에 저장
            operator='÷';
            answer.setText("");//Text 초기화 
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
}