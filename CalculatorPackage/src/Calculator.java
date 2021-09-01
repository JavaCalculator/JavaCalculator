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

public class Calculator {
   
   char operator;
   double num1=0,num2=0,result=0; // num1 �տ� ��, num2 ������ �ڿ� ���� ��, result �����
   JFrame frame; 
   //private ArrayList<String> equation=new ArrayList<String>();

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Calculator window = new Calculator();
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
   public Calculator() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   public void initialize() {
      frame = new JFrame(); //���� â ����
      frame.getContentPane().setBackground(Color.BLACK);
      frame.setBounds(100, 100, 566, 681);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      JLabel answer = new JLabel("0"); // ���� ���� Text�� �˷��ִ� answer
      answer.setBackground(Color.ORANGE);
      answer.setForeground(Color.WHITE);
      answer.setHorizontalAlignment(SwingConstants.RIGHT);
      answer.setFont(new Font("���� ���", Font.BOLD, 50));
      answer.setBounds(22, 43, 325, 170);
      frame.getContentPane().add(answer);  
      
      JButton btn7 = new JButton("7"); //button 7 ������
      btn7.setBackground(Color.GRAY);
      btn7.setForeground(Color.WHITE);
      btn7.setFont(new Font("���� ���", Font.BOLD, 30));
      btn7.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btn7.setBounds(22, 244, 98, 91);
      frame.getContentPane().add(btn7);
      
      JButton btn8 = new JButton("8"); //button 8 ������
      btn8.setBackground(Color.GRAY);
      btn8.setForeground(Color.WHITE);
      btn8.setFont(new Font("���� ���", Font.BOLD, 30));
      btn8.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
         }
      });
      btn8.setBounds(132, 244, 98, 91);
      frame.getContentPane().add(btn8);
      
      JButton btn9 = new JButton("9"); //button 9 ������
      btn9.setBackground(Color.GRAY);
      btn9.setForeground(Color.WHITE);
      btn9.setFont(new Font("���� ���", Font.BOLD, 30));
      btn9.setBounds(241, 244, 98, 91);
      frame.getContentPane().add(btn9);
      
      JButton btn4 = new JButton("4"); //button 4 ������
      btn4.setForeground(Color.WHITE);
      btn4.setBackground(Color.GRAY);
      btn4.setFont(new Font("���� ���", Font.BOLD, 30));
      btn4.setBounds(22, 345, 98, 91);
      frame.getContentPane().add(btn4);
      
      JButton btn5 = new JButton("5"); //button 5 ������
      btn5.setForeground(Color.WHITE);
      btn5.setBackground(Color.GRAY);
      btn5.setFont(new Font("���� ���", Font.BOLD, 30));
      btn5.setBounds(132, 345, 98, 91);
      frame.getContentPane().add(btn5);
      
      JButton btn6 = new JButton("6"); //button 6 ������
      btn6.setBackground(Color.GRAY);
      btn6.setForeground(Color.WHITE);
      btn6.setFont(new Font("���� ���", Font.BOLD, 30));
      btn6.setBounds(241, 345, 98, 91);
      frame.getContentPane().add(btn6);
      
      JButton btn1 = new JButton("1"); //button 1 ������
      btn1.setBackground(Color.GRAY);
      btn1.setForeground(Color.WHITE);
      btn1.setFont(new Font("���� ���", Font.BOLD, 30));
      btn1.setBounds(22, 442, 98, 91);
      frame.getContentPane().add(btn1);
      
      JButton btn2 = new JButton("2"); //button 2 ������
      btn2.setBackground(Color.GRAY);
      btn2.setForeground(Color.WHITE);
      btn2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btn2.setFont(new Font("���� ���", Font.BOLD, 30));
      btn2.setBounds(132, 442, 98, 91);
      frame.getContentPane().add(btn2);
      
      JButton btn3 = new JButton("3"); //button 3 ������
      btn3.setBackground(Color.GRAY);
      btn3.setForeground(Color.WHITE);
      btn3.setFont(new Font("���� ���", Font.BOLD, 30));
      btn3.setBounds(241, 442, 98, 91);
      frame.getContentPane().add(btn3);
      
      JButton btn0 = new JButton("0"); //button 0 ������
      btn0.setBackground(Color.GRAY);
      btn0.setForeground(Color.WHITE);
      btn0.setFont(new Font("���� ���", Font.BOLD, 30));
      btn0.setBounds(132, 543, 98, 91);
      frame.getContentPane().add(btn0);
      
      JButton btnC = new JButton("C"); //button C ������
      btnC.setForeground(Color.WHITE);
      btnC.setBackground(Color.LIGHT_GRAY);
      btnC.addActionListener(new ActionListener() {  // 'C'��ư �Է����� ��  
         public void actionPerformed(ActionEvent e) { // �߻��ϴ� �̺�Ʈ
               String operation = e.getActionCommand(); 
               if(operation.equals("C")) { 
                  answer.setText(""); // �ʱ�ȭ
               }
         }
      });
      btnC.setFont(new Font("���� ���", Font.BOLD, 30));
      btnC.setBounds(22, 543, 98, 91);
      frame.getContentPane().add(btnC);
      
      JButton btnEnter = new JButton("="); //button Enter ������
      btnEnter.setForeground(Color.WHITE);
      btnEnter.setBackground(Color.LIGHT_GRAY);
      btnEnter.addActionListener(new ActionListener() { // '='��ư �Է����� ��
         public void actionPerformed(ActionEvent e) { //�߻��ϴ� �̺�Ʈ
            num2=Double.parseDouble(answer.getText());
            switch(operator) { // �����ڿ� ���� �ٸ��� ���
            case '+':
               result=num1+num2;
               break;
            case '-':
               result=num1-num2;
               break;
            case 'X':
               result=num1*num2;
               break;
            case '��':
               result=num1/num2;
               break;
            }
            answer.setText(String.valueOf(result));
            num1=result;
         }
      });
      btnEnter.setFont(new Font("���� ���", Font.BOLD, 30));
      btnEnter.setBounds(241, 543, 98, 91);
      frame.getContentPane().add(btnEnter);
      
      JButton btnPlus = new JButton("+");
      btnPlus.setBackground(Color.ORANGE);
      btnPlus.setForeground(Color.WHITE);
      btnPlus.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            num1=Double.parseDouble(answer.getText()); // Text�� double������ ��ȯ�ؼ� num1�� ����
            operator='+'; 
				/* answer.setText("+"); */
				
				  answer.setText(""); //Text �ʱ�ȭ
				          }
      });
      btnPlus.setFont(new Font("���� ���", Font.BOLD, 30));
      btnPlus.setBounds(351, 244, 87, 91);
      frame.getContentPane().add(btnPlus);
      
      JButton btnSub = new JButton("-");
      btnSub.setBackground(Color.ORANGE);
      btnSub.setForeground(Color.WHITE);
      btnSub.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            num1=Double.parseDouble(answer.getText()); // Text�� double������ ��ȯ�ؼ� num1�� ����
            operator='-';
            answer.setText(""); //Text �ʱ�ȭ 
         }
      });
      btnSub.setFont(new Font("���� ���", Font.BOLD, 30));
      btnSub.setBounds(351, 345, 87, 91);
      frame.getContentPane().add(btnSub);
      
      JButton btnMul = new JButton("X");
      btnMul.setBackground(Color.ORANGE);
      btnMul.setForeground(Color.WHITE);
      btnMul.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            num1=Double.parseDouble(answer.getText()); // Text�� double������ ��ȯ�ؼ� num1�� ����
            operator='X';
            answer.setText("");//Text �ʱ�ȭ 
         }
      });
      btnMul.setFont(new Font("���� ���", Font.BOLD, 30));
      btnMul.setBounds(351, 442, 87, 91);
      frame.getContentPane().add(btnMul);
      
      JButton btnDiv = new JButton("\u00F7");
      btnDiv.setBackground(Color.ORANGE);
      btnDiv.setForeground(Color.WHITE);
      btnDiv.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            num1=Double.parseDouble(answer.getText()); // Text�� double������ ��ȯ�ؼ� num1�� ����
            operator='��';
            answer.setText("");//Text �ʱ�ȭ 
         }
      });
      btnDiv.setFont(new Font("���� ���", Font.BOLD, 30));
      btnDiv.setBounds(351, 543, 87, 91);
      frame.getContentPane().add(btnDiv);
      
      btn0.addActionListener(new NumberActionListener(answer,"0")); // 0�� �Է������� 0���
      btn1.addActionListener(new NumberActionListener(answer,"1")); // 1�� �Է������� 1���
      btn2.addActionListener(new NumberActionListener(answer,"2")); // 2�� �Է������� 2���
      btn3.addActionListener(new NumberActionListener(answer,"3")); // 3�� �Է������� 3���
      btn4.addActionListener(new NumberActionListener(answer,"4")); // 4�� �Է������� 4���
      btn5.addActionListener(new NumberActionListener(answer,"5")); // 5�� �Է������� 5���
      btn6.addActionListener(new NumberActionListener(answer,"6")); // 6�� �Է������� 6���
      btn7.addActionListener(new NumberActionListener(answer,"7")); // 7�� �Է������� 7���
      btn8.addActionListener(new NumberActionListener(answer,"8")); // 8�� �Է������� 8���
      btn9.addActionListener(new NumberActionListener(answer,"9")); // 9�� �Է������� 9���
      
      JButton btnL2 = new JButton("<<"); // <<������ ��ư ����
      btnL2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnL2.setForeground(Color.WHITE);
      btnL2.setFont(new Font("���� ���", Font.BOLD, 30));
      btnL2.setBackground(Color.RED);
      btnL2.setBounds(450, 244, 87, 91);
      frame.getContentPane().add(btnL2);
      
      JButton btnAnd = new JButton("&"); // And������ ��ư ����
      btnAnd.setForeground(Color.WHITE);
      btnAnd.setFont(new Font("���� ���", Font.BOLD, 30));
      btnAnd.setBackground(Color.RED);
      btnAnd.setBounds(450, 345, 87, 91);
      frame.getContentPane().add(btnAnd);
      
      JButton btnOr = new JButton("|"); // |������ ��ư ����
      btnOr.setForeground(Color.WHITE);
      btnOr.setFont(new Font("���� ���", Font.BOLD, 30));
      btnOr.setBackground(Color.RED);
      btnOr.setBounds(450, 442, 87, 91);
      frame.getContentPane().add(btnOr);
      
      JButton btnXor = new JButton("^"); // ^������ ��ư ����
      btnXor.setForeground(Color.WHITE);
      btnXor.setFont(new Font("���� ���", Font.BOLD, 30));
      btnXor.setBackground(Color.RED);
      btnXor.setBounds(450, 543, 87, 91);
      frame.getContentPane().add(btnXor);
      
      JButton btnR3 = new JButton(">>>"); /// >>>������ ��ư ����
      btnR3.setForeground(Color.WHITE);
      btnR3.setFont(new Font("���� ���", Font.BOLD, 25));
      btnR3.setBackground(Color.RED);
      btnR3.setBounds(450, 43, 87, 91);
      frame.getContentPane().add(btnR3);
      
      JButton btnR2 = new JButton(">>"); // >>������ ��ư ����
      btnR2.setForeground(Color.WHITE);
      btnR2.setFont(new Font("���� ���", Font.BOLD, 30));
      btnR2.setBackground(Color.RED);
      btnR2.setBounds(450, 143, 87, 91);
      frame.getContentPane().add(btnR2);
      
      JRadioButton btnRadioDec = new JRadioButton("Dec");
      btnRadioDec.setBounds(355, 155, 83, 23);
      frame.getContentPane().add(btnRadioDec);
      
      JRadioButton btnRadioBin = new JRadioButton("Bin");
      btnRadioBin.setBounds(355, 190, 83, 23);
      frame.getContentPane().add(btnRadioBin);
      
      JButton btnRating = new JButton("������");
      btnRating.setForeground(Color.WHITE);
      btnRating.setFont(new Font("�޸յձ�������", Font.BOLD, 13));
      btnRating.setBackground(Color.GREEN);
      btnRating.setBounds(351, 43, 87, 91);
      frame.getContentPane().add(btnRating);
   }
}
class NumberActionListener implements ActionListener{

   private JLabel label;
   private String text;
   
   public  NumberActionListener(JLabel l,String s) {
      label=l;
      text=s;
   }
   public void actionPerformed(ActionEvent e) {
      String curr=label.getText();
      if(curr.equals("0")) {
         label.setText(text);
      }else {
         label.setText(label.getText()+text);
      }
      
   }
   
}