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
        System.out.print("첫번째 주사위 : "+firstdice);
        int seconddice = (int)(Math.random()*6)+1;
        System.out.print(" 두번째 주사위 : "+seconddice + " ");
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
        int usercnt = 0; // 게임인원수를 위한 변수 
        int i = 0; // 단순 for문용 변수
        int max = 0; // 매 경기 
        int j = 0 ; //위치 찾기 위한 변수
        int zeroscore = 0;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("인원수는 ?");
        usercnt = sc.nextInt(); //인원수 입력받고 저장
        
        if( usercnt < 2 || usercnt > 6){
            System.out.println("인원수는 2~6명으로 제한되어있습니다. 종료합니다");
            System.exit(0);
        }
        
        User [] user = new User[usercnt]; // 입력받은 인원수만큼 배열 생성
        for (i=0;i<user.length;i++){      // User 기본정보 세팅
            System.out.print("이름은 ?");
            String tempname = sc.next();
            user[i] = new User();
            user[i].setname(tempname);
        }
        
        
		        for (i=0;i<user.length;i++){      // User dice 던지기 실행 + 점수 출력
		            user[i].setdicevalue();
		            System.out.println(user[i].getname() + "의 점수 :" + user[i].getdicevalue() + " ");
		        }
		        
		        for( i=1; i<user.length; i++){    // 이번 경기에서 최대점수를 가진 인덱스 구하기
		            if(user[max].getdicevalue() < user[i].getdicevalue()){
		                max = i;
		                j = i;
		            }
		        }
		    
    
        
        for( i=0; i<user.length; i++){    // 무승부 여부를 판단을 위한 for문
            if(user[j].getdicevalue() == user[i].getdicevalue()){
                zeroscore += 1;
            }
        }
        if(zeroscore == usercnt){ // zeroscroe에 결과값이 게임인원수와 동일할경우 모두 같은점수 무승부
            System.out.println("");
            System.out.println("이번 판 무승부처리됩니다.");  
        }
        else{
            System.out.println("");
            for( i=0; i<user.length; i++){    // 이번 경기 동시 우승자 (우승자) 탐색
                if(user[j].getdicevalue() == user[i].getdicevalue()){
                    user[i].win();
                    System.out.println("이번 게임 승리자(동시승리자)는 " +user[i].getname() + "입니다.");
                }
            }
        }
        
        System.out.println("");
        for (i=0;i<user.length;i++){      // 승리수 출력
            System.out.println(user[i].getname() + "는 " + user[i].getwincnt() + "승하셨습니다.");
        }
   }
}