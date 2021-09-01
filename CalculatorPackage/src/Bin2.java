import java.util.*;
public class Bin2 {

	public static void main(String[] args) {
		String num1, num2, operator;
		int flag=0; // ���� 0�϶� ������ 0�� ������ ���� �ʱ� ���� ǥ��
	    int count = 0;   //�ڸ��� ī��Ʈ
	    
		ArrayList<Integer> number1 = new ArrayList<Integer>();   //num1�� �� �迭
	    ArrayList<Integer> number2 = new ArrayList<Integer>();   //num2�� �� �迭
	    ArrayList<Integer> result = new ArrayList<Integer>();   //�����
	    
	    Scanner input=new Scanner(System.in);
	    System.out.println("num1�� �Է��Ͻÿ�: ");
	    num1=input.nextLine();
	    System.out.println("�����ڸ� �Է��Ͻÿ�: ");
	    operator=input.nextLine();
	    System.out.println("num2�� �Է��Ͻÿ�: ");
	    num2=input.nextLine();
	    
	    for(int i=0;i<num1.length();i++) {
	    	number1.add(num1.charAt(num1.length()-1-i)-'0');
	    }
	    for(int i=0;i<num2.length();i++) {
	    	number2.add(num2.charAt(num2.length()-1-i)-'0');
	    }
	    
	    if(operator.equals(">>>")) {
	    	for(int i=0;i<Integer.parseInt(num2);i++) {
	    		number1.remove(0);
		    	}
	    }
	    
	    else if(operator.equals("<<")) {
	    	
	    	for(int i=0;i<Integer.parseInt(num2);i++) {
	    	number1.add(0,0);
	    	}
	    }
	    
	    else if (operator.equals("&")) {
	    	if(number1.size()>number2.size()) {
	    		for(int i = 0; i < (num1.length() - num2.length()); i++)
	                number2.add(0);
	    		for(int i=number1.size()-1;i>=0;i--) {
	    			if(number1.get(i)==1 && number2.get(i)==1) {
	    				result.add(1);
	    			}
	    			else {
	    				result.add(0);
	    			}
	    		}
	    	}
	    	else {
	    		for(int i = 0; i < (num2.length() - num1.length()); i++)
	                number1.add(0);
	    		for(int i=number2.size()-1;i>=0;i--) {
	    			if(number1.get(i)==1 && number2.get(i)==1) {
	    				result.add(1);
	    			}
	    			else {
	    				result.add(0);
	    			}
	    		}
	    	}
	    }
	    
	    else if (operator.equals("|")) {
	    	if(number1.size()>number2.size()) {
	    		for(int i = 0; i < (num1.length() - num2.length()); i++)
	                number2.add(0);
	    		for(int i=number1.size()-1;i>=0;i--) {
	    			if(number1.get(i)==0 && number2.get(i)==0) {
	    				result.add(0);
	    			}
	    			else {
	    				result.add(1);
	    			}
	    		}
	    	}
	    	else {
	    		for(int i = 0; i < (num2.length() - num1.length()); i++)
	                number1.add(0);
	    		for(int i=number2.size()-1;i>=0;i--) {
	    			if(number1.get(i)==0 && number2.get(i)==0) {
	    				result.add(0);
	    			}
	    			else {
	    				result.add(1);
	    			}
	    		}
	    	}
	    }
	    
	    else if (operator.equals("^")) {
	    	if(number1.size()>number2.size()) {
	    		for(int i = 0; i < (num1.length() - num2.length()); i++)
	                number2.add(0);
	    		for(int i=number1.size()-1;i>=0;i--) {
	    			if(number1.get(i)!=number2.get(i)) {
	    				result.add(1);
	    			}
	    			else {
	    				result.add(0);
	    			}
	    		}
	    	}
	    	else {
	    		for(int i = 0; i < (num2.length() - num1.length()); i++)
	                number1.add(0);
	    		for(int i=number2.size()-1;i>=0;i--) {
	    			if(number1.get(i)!=number2.get(i)) {
	    				result.add(1);
	    			}
	    			else {
	    				result.add(0);
	    			}
	    		}
	    	}
	    }
	
	    for(int i=0;i<result.size();i++) {
	    	if(result.get(0)==0) {
	    		result.remove(0);
	    	}
	    	else {
	    		break;
	    	}
	    }
	    
	    System.out.print("���� ��� ��� : ");
	    System.out.println();
	    if(operator.equals(">>>")||operator.equals("<<")) {
	    for(int i=number1.size()-1;i>=0;i--) {
	    	
	    	System.out.print(number1.get(i));
	    
	    	}
	    }
	    else {
	    	 for(int i=number1.size()-1;i>=0;i--) 
	 	    	System.out.print(number1.get(i));
	   	System.out.println();
   	 for(int i=number2.size()-1;i>=0;i--) 
 	    	System.out.print(number2.get(i));
    	System.out.println();
	    
	    	if(result.size()==0) {
	    		System.out.println(0);
    		
	    	}
	    	else {
	    		for(int i=0;i<result.size();i++)
	    		System.out.print(result.get(i));
	    	}
	    }
	    
	}

}
