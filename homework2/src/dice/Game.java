package dice;
import java.util.Scanner;
public class Game {
	public static void main(String[] args) {
		int i=0; //반복문 변수
		int k=0; //0인지 1인지 받을 변수
		int max=0; //점수의 최대값
		int j=0; // 비교 변수
		int gamenum=1; //게임 번호 변수
		int usercount=0; //유저인원 
        int zeroscore = 0; // 동점 확인하는 변수
		Player player = new Player(); //유저 생성자
		
		System.out.println("게임 참가자의 수를 입력하시오.");  
		Scanner scanner = new Scanner(System.in); 
		usercount=scanner.nextInt();  //유저 인원 입력받음
		Player mem[] = new Player[usercount]; //mem변수 유저인원만큼 객체배열 생성
		
		for(i=0; i<mem.length;i++){ //인원받고 배열 생성 + 이름 저장
			System.out.println("게임 참가자의 이름을 차례로 입력하시오.");
			System.out.println((i+1)+"번째 참가자의 이름 : ");
			String tempname =scanner.next();
			mem[i]=new Player();
			mem[i].setname(tempname);
		}
		System.out.println("-----------지금부터 게임을 시작합니다.-------------");
		  
		while(true){
			System.out.println("Game #"+gamenum++);
			 for(i=0;i<mem.length;i++)
			 {
				 System.out.println("게임을 진행 하실거면 1을 입력하세요.  0은 게임 종료");
				 k=scanner.nextInt();
					if(k==0){
						for (i=0;i<mem.length;i++){      // 승리수 출력
				            System.out.println((gamenum-2)+"번의 게임중에서 "+mem[i].getname() + "는 " + mem[i].getwincnt() + "승하셨습니다.");
				        }
						System.exit(0);
					}
					
				 
					for (i=0;i<mem.length;i++){      // User dice 던지기 실행 + 점수 출력
						System.out.println(mem[i].getname()+"님의 차례입니다.");
						mem[i].setDice();
						
			            System.out.println(mem[i].getname() + "의 점수 :" + mem[i].getdicevalue() + " ");
			        }		
					
			         for( i=1; i<mem.length; i++){    // 이번 경기에서 최대점수를 가진 인덱스 구하기
					 if(mem[max].getdicevalue() < mem[i].getdicevalue()){
			                max = i;
			                j = i;
			            }
			         }
					 
					 for( i=0; i<mem.length; i++){    // 무승부 여부를 판단을 위한 for문
					 if(mem[j].getdicevalue() == mem[i].getdicevalue()){
				                zeroscore += 1;
				            }
					 }
				        
					 
				      if((zeroscore == usercount)){ // zeroscroe에 결과값이 게임인원수와 동일할경우 모두 같은점수 무승부
				            System.out.println("");
				            System.out.println("이번 판 무승부처리됩니다.");  
				            zeroscore=0;
				      }
				      else {
				            System.out.println("");
				            for( i=0; i<mem.length; i++){    // 이번 경기 동시 우승자 (우승자) 탐색
				                if((mem[j].getdicevalue() == mem[i].getdicevalue())){
				                	mem[i].win();
				                    System.out.println("이번 게임 승리자(동시승리자)는 " +mem[i].getname() + "입니다.");
				                }
				            }
				        }
			        System.out.println("");
					 zeroscore=0;
					 j=0;
		         }

			 }
		}
	}




		

	




