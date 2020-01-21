package homework3;
import java.util.Scanner;
class Goods{
	private String name; //상품이름
	private int price; //상품 가격 
	private int numberOfStock; //상품 재고량
	private int sold=0; //판매수
	
	Goods(String name, int price, int numberOfSock){ //상품 설정
		this.name=name;
		this.price=price;
		this.numberOfStock=numberOfSock;
	}
	
	public void productSold(){ //판매량 증가 메소드
		sold++;
	}
	
	public void productBuy(int buyNum){ //구매 상품 메소드
		this.numberOfStock+=buyNum;
	}
	
	void setNumber(){ //상품이 판매되면 재고 감소
		numberOfStock--;
	}
	
	String getName(){return name;} //상품이름 출력
	int getPrice(){return price;} //상품 가격 출력
	int getNumberOfStock(){return numberOfStock;} //재고량 출력
	int getsold(){return sold;} //판매개수 출력
}

public class GoodArray { 
	public static void main(String[] args) {
		int i; //반복문
		int sum=0; //판매 가격 총액 필드
		int get=100; // 상품 번호
		Scanner scan = new Scanner(System.in); 
		Goods goods[]; //goods 생성자
		System.out.print("슈퍼에서 취급하는 상품의 개수를 입력하시오.>>>");
		int num=scan.nextInt(); //상품개수 입력
		goods=new Goods[num]; //상품 객체배열
		for(i=0;i<goods.length;i++){  //상품 이름 가격 재고량 입력
			System.out.print((i+1)+"번째 상품의 이름, 가격, 재고량을 입력하시오.>>>");
			String name=scan.next(); 
			int price = scan.nextInt();
			int n=scan.nextInt();
			goods[i]=new Goods(name,price,n);
		}
		int option=5; //포스기 옵션
		while(option!=4){
			System.out.println("1) 판매\t 2) 구매\t 3) 조회\t 4) 종료"); //선택 4가 들어오면 종료
			System.out.print(">>>");
			option = scan.nextInt(); //선택 입력받고
			if(option==1){ //만약 판매라면
				while(get!=goods.length+1){
					for(i=0;i<goods.length;i++){ //모든 상품 출력
					System.out.print((i+1)+") "+ goods[i].getName()+"   "); 
					}
					System.out.println((goods.length+1)+") 계산"); //6번
					System.out.print(">>>");
					get=scan.nextInt(); //구매하는 상품 번호 입력받기
					if(get!=goods.length+1){ //계산이 아니면 구매할 상품
					goods[get-1].productSold(); //판매량 증가
					goods[get-1].setNumber();} //재고수 감소
					else{ //계산
						for(i=0;i<goods.length;i++){
							sum+=goods[i].getsold()*goods[i].getPrice();
						}//계산끝

						System.out.println("판매 가격 총액 : "+sum); //판매가격 총액
						System.out.print("받은 금액을 입력하시오.>>>"); //받은금액
						int money=scan.nextInt(); //받은 금액 입력
						System.out.println("### 영수증###"); //영수증
						System.out.println("================");
						for(i=0;i<goods.length;i++){
							if(goods[i].getPrice()*goods[i].getsold()!=0)
							System.out.println(goods[i].getName()+"\t"+goods[i].getPrice()+"x"+goods[i].getsold()+"\t"+goods[i].getPrice()*goods[i].getsold());
						}
						System.out.println("================");
						System.out.println("총액\t\t"+sum);
						System.out.println("받은금액\t"+money);
						System.out.println("================");
						System.out.println("거스름돈\t"+(money-sum));
					}
				}
			}if(option==2){
				for(i=0;i<goods.length;i++){ //모든 상품 출력
					System.out.print((i+1)+") "+ goods[i].getName());
					}
					System.out.println((goods.length+1)+") 구매종료"); //마지막은 구매종료
					System.out.print(">>>"); 
					get=scan.nextInt();//선택지 입력
					System.out.print("구매 수량을 입력하시오.>>>");
					int buyNumber=scan.nextInt(); //구매 수량 입력
					goods[get].productBuy(buyNumber); //재고수 증가
					System.out.println("##"+goods[get].getName()+"의 재고량이" +goods[get].getNumberOfStock()+"으로 증가 함.");
			}
			if(option==3){
				System.out.println(" ###   상품명   재고량    ###");
				System.out.println("===================");
				for(i=0;i<goods.length;i++){
					System.out.println(goods[i].getName()+"\t"+goods[i].getNumberOfStock()); //배고량 출력
				}
				System.out.println("===================");
			}
		}
	}
}
