package homework3;
import java.util.Scanner;
class Goods{
	private String name; //��ǰ�̸�
	private int price; //��ǰ ���� 
	private int numberOfStock; //��ǰ ���
	private int sold=0; //�Ǹż�
	
	Goods(String name, int price, int numberOfSock){ //��ǰ ����
		this.name=name;
		this.price=price;
		this.numberOfStock=numberOfSock;
	}
	
	public void productSold(){ //�Ǹŷ� ���� �޼ҵ�
		sold++;
	}
	
	public void productBuy(int buyNum){ //���� ��ǰ �޼ҵ�
		this.numberOfStock+=buyNum;
	}
	
	void setNumber(){ //��ǰ�� �ǸŵǸ� ��� ����
		numberOfStock--;
	}
	
	String getName(){return name;} //��ǰ�̸� ���
	int getPrice(){return price;} //��ǰ ���� ���
	int getNumberOfStock(){return numberOfStock;} //��� ���
	int getsold(){return sold;} //�ǸŰ��� ���
}

public class GoodArray { 
	public static void main(String[] args) {
		int i; //�ݺ���
		int sum=0; //�Ǹ� ���� �Ѿ� �ʵ�
		int get=100; // ��ǰ ��ȣ
		Scanner scan = new Scanner(System.in); 
		Goods goods[]; //goods ������
		System.out.print("���ۿ��� ����ϴ� ��ǰ�� ������ �Է��Ͻÿ�.>>>");
		int num=scan.nextInt(); //��ǰ���� �Է�
		goods=new Goods[num]; //��ǰ ��ü�迭
		for(i=0;i<goods.length;i++){  //��ǰ �̸� ���� ��� �Է�
			System.out.print((i+1)+"��° ��ǰ�� �̸�, ����, ����� �Է��Ͻÿ�.>>>");
			String name=scan.next(); 
			int price = scan.nextInt();
			int n=scan.nextInt();
			goods[i]=new Goods(name,price,n);
		}
		int option=5; //������ �ɼ�
		while(option!=4){
			System.out.println("1) �Ǹ�\t 2) ����\t 3) ��ȸ\t 4) ����"); //���� 4�� ������ ����
			System.out.print(">>>");
			option = scan.nextInt(); //���� �Է¹ް�
			if(option==1){ //���� �ǸŶ��
				while(get!=goods.length+1){
					for(i=0;i<goods.length;i++){ //��� ��ǰ ���
					System.out.print((i+1)+") "+ goods[i].getName()+"   "); 
					}
					System.out.println((goods.length+1)+") ���"); //6��
					System.out.print(">>>");
					get=scan.nextInt(); //�����ϴ� ��ǰ ��ȣ �Է¹ޱ�
					if(get!=goods.length+1){ //����� �ƴϸ� ������ ��ǰ
					goods[get-1].productSold(); //�Ǹŷ� ����
					goods[get-1].setNumber();} //���� ����
					else{ //���
						for(i=0;i<goods.length;i++){
							sum+=goods[i].getsold()*goods[i].getPrice();
						}//��곡

						System.out.println("�Ǹ� ���� �Ѿ� : "+sum); //�ǸŰ��� �Ѿ�
						System.out.print("���� �ݾ��� �Է��Ͻÿ�.>>>"); //�����ݾ�
						int money=scan.nextInt(); //���� �ݾ� �Է�
						System.out.println("### ������###"); //������
						System.out.println("================");
						for(i=0;i<goods.length;i++){
							if(goods[i].getPrice()*goods[i].getsold()!=0)
							System.out.println(goods[i].getName()+"\t"+goods[i].getPrice()+"x"+goods[i].getsold()+"\t"+goods[i].getPrice()*goods[i].getsold());
						}
						System.out.println("================");
						System.out.println("�Ѿ�\t\t"+sum);
						System.out.println("�����ݾ�\t"+money);
						System.out.println("================");
						System.out.println("�Ž�����\t"+(money-sum));
					}
				}
			}if(option==2){
				for(i=0;i<goods.length;i++){ //��� ��ǰ ���
					System.out.print((i+1)+") "+ goods[i].getName());
					}
					System.out.println((goods.length+1)+") ��������"); //�������� ��������
					System.out.print(">>>"); 
					get=scan.nextInt();//������ �Է�
					System.out.print("���� ������ �Է��Ͻÿ�.>>>");
					int buyNumber=scan.nextInt(); //���� ���� �Է�
					goods[get].productBuy(buyNumber); //���� ����
					System.out.println("##"+goods[get].getName()+"�� �����" +goods[get].getNumberOfStock()+"���� ���� ��.");
			}
			if(option==3){
				System.out.println(" ###   ��ǰ��   ���    ###");
				System.out.println("===================");
				for(i=0;i<goods.length;i++){
					System.out.println(goods[i].getName()+"\t"+goods[i].getNumberOfStock()); //��� ���
				}
				System.out.println("===================");
			}
		}
	}
}
