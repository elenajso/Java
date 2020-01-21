package homework4;

import java.util.*;

class Phone { //전화번호부 클래스
	private String address; //주소
	private String phoneNum; //전화번호
	public Phone(String address, String phoneNum) { //주소, 전화번호 생성자
		this.address=address;
		this.phoneNum=phoneNum;
	}
	String getAddress(){ // 주소반환 메소드
		return address;
	}
	String getPhone(){ //전화번호 반환 메소드
		return phoneNum;
	}
}

public class HashMapPhone{
	public static void main(String[] args){
		//이름, 전화번호, 주소를 쌍으로 저장하는 HashMap 컬렉션 생성
		HashMap<String, Phone> map = new HashMap<String, Phone>();
		Scanner scan = new Scanner(System.in);
		Set<String> keys = map.keySet(); //해시맵의 모든 키를 담은 Set 컬렉션 리턴
		System.out.println("---------------------------------------------------------------------");
		System.out.println("전화번호 관리 프로그램을 시작합니다. 파일로 저장하지 않습니다.");
		System.out.println("---------------------------------------------------------------------");
		while(true){
			System.out.print("삽입 : 0,    삭제 : 1,    찾기 : 2,    전체보기 : 3,    종료 : 4>>");
			int n=scan.nextInt(); //번호 입력
			if(n==0){ //삽입
				System.out.print("이름>>");
				String name= scan.next();
				System.out.print("주소>>");
				String address = scan.next();
				System.out.print("전화번호>>");
				String phoneNum = scan.next();
				map.put(name, new Phone(address, phoneNum));
			}
			if(n==1){ //삭제
				System.out.print("이름>>");
				String name=scan.next();
				Phone phone = map.get(name);
				if(phone==null)
					System.out.println(name+"는 등록되지 않은 사람입니다.");
				else{
				map.remove(name);
				System.out.println(name+"는 삭제되었습니다.");
				}
			}
			if(n==2){ //찾기
				System.out.print("이름>>");
				String name = scan.next();
				Phone phone=map.get(name);
				if(phone==null)
					System.out.println(name+"은 없는 사람입니다.");
				else
					System.out.println(name +"  "+phone.getAddress()+"  "+ phone.getPhone());
			}
			if(n==3){ //이름순으로 정렬한후 출력
				Vector<String> v = new Vector<String>(); //벡터 생성
				v.addAll(keys); //벡터에 모든키 다 넣기
				Collections.sort(v); //컬렉션에 포함된 요소들을 소팅
				Iterator<String> it =v.iterator(); //순차검색
				while(it.hasNext()){//모든 요소 방문
					String name= it.next(); //다음요소 리턴
					Phone phone=map.get(name); 
					System.out.println(name+"  "+phone.getAddress()+"  "+ phone.getPhone());
				}
			}
			if(n==4) {//종료
				System.out.println("프로그램을 종료합니다.");
				break;}
		}
	}
}


