package dice;
import java.util.Scanner;
public class Game {
	public static void main(String[] args) {
		int i=0; //�ݺ��� ����
		int k=0; //0���� 1���� ���� ����
		int max=0; //������ �ִ밪
		int j=0; // �� ����
		int gamenum=1; //���� ��ȣ ����
		int usercount=0; //�����ο� 
        int zeroscore = 0; // ���� Ȯ���ϴ� ����
		Player player = new Player(); //���� ������
		
		System.out.println("���� �������� ���� �Է��Ͻÿ�.");  
		Scanner scanner = new Scanner(System.in); 
		usercount=scanner.nextInt();  //���� �ο� �Է¹���
		Player mem[] = new Player[usercount]; //mem���� �����ο���ŭ ��ü�迭 ����
		
		for(i=0; i<mem.length;i++){ //�ο��ް� �迭 ���� + �̸� ����
			System.out.println("���� �������� �̸��� ���ʷ� �Է��Ͻÿ�.");
			System.out.println((i+1)+"��° �������� �̸� : ");
			String tempname =scanner.next();
			mem[i]=new Player();
			mem[i].setname(tempname);
		}
		System.out.println("-----------���ݺ��� ������ �����մϴ�.-------------");
		  
		while(true){
			System.out.println("Game #"+gamenum++);
			 for(i=0;i<mem.length;i++)
			 {
				 System.out.println("������ ���� �ϽǰŸ� 1�� �Է��ϼ���.  0�� ���� ����");
				 k=scanner.nextInt();
					if(k==0){
						for (i=0;i<mem.length;i++){      // �¸��� ���
				            System.out.println((gamenum-2)+"���� �����߿��� "+mem[i].getname() + "�� " + mem[i].getwincnt() + "���ϼ̽��ϴ�.");
				        }
						System.exit(0);
					}
					
				 
					for (i=0;i<mem.length;i++){      // User dice ������ ���� + ���� ���
						System.out.println(mem[i].getname()+"���� �����Դϴ�.");
						mem[i].setDice();
						
			            System.out.println(mem[i].getname() + "�� ���� :" + mem[i].getdicevalue() + " ");
			        }		
					
			         for( i=1; i<mem.length; i++){    // �̹� ��⿡�� �ִ������� ���� �ε��� ���ϱ�
					 if(mem[max].getdicevalue() < mem[i].getdicevalue()){
			                max = i;
			                j = i;
			            }
			         }
					 
					 for( i=0; i<mem.length; i++){    // ���º� ���θ� �Ǵ��� ���� for��
					 if(mem[j].getdicevalue() == mem[i].getdicevalue()){
				                zeroscore += 1;
				            }
					 }
				        
					 
				      if((zeroscore == usercount)){ // zeroscroe�� ������� �����ο����� �����Ұ�� ��� �������� ���º�
				            System.out.println("");
				            System.out.println("�̹� �� ���º�ó���˴ϴ�.");  
				            zeroscore=0;
				      }
				      else {
				            System.out.println("");
				            for( i=0; i<mem.length; i++){    // �̹� ��� ���� ����� (�����) Ž��
				                if((mem[j].getdicevalue() == mem[i].getdicevalue())){
				                	mem[i].win();
				                    System.out.println("�̹� ���� �¸���(���ý¸���)�� " +mem[i].getname() + "�Դϴ�.");
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




		

	




