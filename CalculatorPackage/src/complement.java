public static String complement(int [] num) {
            
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
             
//                       for(int i=0;i<size;i++) {
//                          if(number2_complement.get(0)==0) {
//                             number2_complement.remove(0);
//                          }
//                          else {
//                             break;
//                          }
//                       }
//                       
//                       for(int i=0;i<number2_complement.size();i++) {
//                          s+=number2_complement.get(i);
//                       }
                     
                     return s;
         }

      
}