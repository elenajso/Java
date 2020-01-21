package die;
import java.util.*;

class User{
    private String name;
    private int dicevalue;
    private int wincnt;
   
    public User(){
        wincnt = 0;
    }
    
    public void setname(String input){
        name = input;
    }
    public String getname(){
        return name;
    }    

    public void setdicevalue(){
        int firstdice = (int)(Math.random()*6)+1;
        System.out.print("ù��° �ֻ��� : "+firstdice);
        int seconddice = (int)(Math.random()*6)+1;
        System.out.print(" �ι�° �ֻ��� : "+seconddice + " ");
        dicevalue = firstdice + seconddice;
    }
    public int getdicevalue(){
        return dicevalue;
    }
    public void win(){
        wincnt +=1;
    }
    public int getwincnt(){
        return wincnt;
    }
}


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int usercnt = 0; // �����ο����� ���� ���� 
        int i = 0; // �ܼ� for���� ����
        int max = 0; // �� ��� 
        int j = 0 ; //��ġ ã�� ���� ����
        int zeroscore = 0;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("�ο����� ?");
        usercnt = sc.nextInt(); //�ο��� �Է¹ް� ����
        
        if( usercnt < 2 || usercnt > 6){
            System.out.println("�ο����� 2~6������ ���ѵǾ��ֽ��ϴ�. �����մϴ�");
            System.exit(0);
        }
        
        User [] user = new User[usercnt]; // �Է¹��� �ο�����ŭ �迭 ����
        for (i=0;i<user.length;i++){      // User �⺻���� ����
            System.out.print("�̸��� ?");
            String tempname = sc.next();
            user[i] = new User();
            user[i].setname(tempname);
        }
        
        
		        for (i=0;i<user.length;i++){      // User dice ������ ���� + ���� ���
		            user[i].setdicevalue();
		            System.out.println(user[i].getname() + "�� ���� :" + user[i].getdicevalue() + " ");
		        }
		        
		        for( i=1; i<user.length; i++){    // �̹� ��⿡�� �ִ������� ���� �ε��� ���ϱ�
		            if(user[max].getdicevalue() < user[i].getdicevalue()){
		                max = i;
		                j = i;
		            }
		        }
		    
    
        
        for( i=0; i<user.length; i++){    // ���º� ���θ� �Ǵ��� ���� for��
            if(user[j].getdicevalue() == user[i].getdicevalue()){
                zeroscore += 1;
            }
        }
        if(zeroscore == usercnt){ // zeroscroe�� ������� �����ο����� �����Ұ�� ��� �������� ���º�
            System.out.println("");
            System.out.println("�̹� �� ���º�ó���˴ϴ�.");  
        }
        else{
            System.out.println("");
            for( i=0; i<user.length; i++){    // �̹� ��� ���� ����� (�����) Ž��
                if(user[j].getdicevalue() == user[i].getdicevalue()){
                    user[i].win();
                    System.out.println("�̹� ���� �¸���(���ý¸���)�� " +user[i].getname() + "�Դϴ�.");
                }
            }
        }
        
        System.out.println("");
        for (i=0;i<user.length;i++){      // �¸��� ���
            System.out.println(user[i].getname() + "�� " + user[i].getwincnt() + "���ϼ̽��ϴ�.");
        }
   }
}