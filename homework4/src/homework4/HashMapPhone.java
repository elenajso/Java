package homework4;

import java.util.*;

class Phone { //��ȭ��ȣ�� Ŭ����
	private String address; //�ּ�
	private String phoneNum; //��ȭ��ȣ
	public Phone(String address, String phoneNum) { //�ּ�, ��ȭ��ȣ ������
		this.address=address;
		this.phoneNum=phoneNum;
	}
	String getAddress(){ // �ּҹ�ȯ �޼ҵ�
		return address;
	}
	String getPhone(){ //��ȭ��ȣ ��ȯ �޼ҵ�
		return phoneNum;
	}
}

public class HashMapPhone{
	public static void main(String[] args){
		//�̸�, ��ȭ��ȣ, �ּҸ� ������ �����ϴ� HashMap �÷��� ����
		HashMap<String, Phone> map = new HashMap<String, Phone>();
		Scanner scan = new Scanner(System.in);
		Set<String> keys = map.keySet(); //�ؽø��� ��� Ű�� ���� Set �÷��� ����
		System.out.println("---------------------------------------------------------------------");
		System.out.println("��ȭ��ȣ ���� ���α׷��� �����մϴ�. ���Ϸ� �������� �ʽ��ϴ�.");
		System.out.println("---------------------------------------------------------------------");
		while(true){
			System.out.print("���� : 0,    ���� : 1,    ã�� : 2,    ��ü���� : 3,    ���� : 4>>");
			int n=scan.nextInt(); //��ȣ �Է�
			if(n==0){ //����
				System.out.print("�̸�>>");
				String name= scan.next();
				System.out.print("�ּ�>>");
				String address = scan.next();
				System.out.print("��ȭ��ȣ>>");
				String phoneNum = scan.next();
				map.put(name, new Phone(address, phoneNum));
			}
			if(n==1){ //����
				System.out.print("�̸�>>");
				String name=scan.next();
				Phone phone = map.get(name);
				if(phone==null)
					System.out.println(name+"�� ��ϵ��� ���� ����Դϴ�.");
				else{
				map.remove(name);
				System.out.println(name+"�� �����Ǿ����ϴ�.");
				}
			}
			if(n==2){ //ã��
				System.out.print("�̸�>>");
				String name = scan.next();
				Phone phone=map.get(name);
				if(phone==null)
					System.out.println(name+"�� ���� ����Դϴ�.");
				else
					System.out.println(name +"  "+phone.getAddress()+"  "+ phone.getPhone());
			}
			if(n==3){ //�̸������� �������� ���
				Vector<String> v = new Vector<String>(); //���� ����
				v.addAll(keys); //���Ϳ� ���Ű �� �ֱ�
				Collections.sort(v); //�÷��ǿ� ���Ե� ��ҵ��� ����
				Iterator<String> it =v.iterator(); //�����˻�
				while(it.hasNext()){//��� ��� �湮
					String name= it.next(); //������� ����
					Phone phone=map.get(name); 
					System.out.println(name+"  "+phone.getAddress()+"  "+ phone.getPhone());
				}
			}
			if(n==4) {//����
				System.out.println("���α׷��� �����մϴ�.");
				break;}
		}
	}
}


