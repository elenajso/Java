package homework5;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

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

public class HashPhone extends JFrame{ 
	private JTextField jf1, jf2, jf3;
	private JButton jb1, jb2, jb3, jb4;
	private JTextArea jta;
	private JLabel jl1, jl2, jl3;
	HashMap<String, Phone> map = new HashMap<String, Phone>();
	
	public HashPhone(){
		setTitle("Phone Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(1,4));
		jp1.setSize(400,30);
		jp1.setLocation(460,50);
		jb1 = new JButton("조회");
		jb2= new JButton("검색");
		jb3= new JButton("삽입");
		jb4= new JButton("삭제");
		ContactA listenerA = new ContactA();
		ContactB listenerB = new ContactB();
		ContactC listenerC = new ContactC();
		ContactD listenerD = new ContactD();
		jb1.addActionListener(listenerA);
		jb2.addActionListener(listenerB);
		jb3.addActionListener(listenerC);
		jb4.addActionListener(listenerD);
		
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(3,1));
		jp2.setSize(320, 90);
		jp2.setLocation(540, 150);
		
		jf1 = new JTextField();
		jf2 = new JTextField();
		jf3 = new JTextField();
		
		jp2.add(jf1);
		jp2.add(jf2);
		jp2.add(jf3);
		
		JPanel jp3 = new JPanel();
		jp3.setLayout(new GridLayout(3,1));
		jp3.setSize(80,90);
		jp3.setLocation(470, 150);
	
		jl1 = new JLabel("이  름");
		jl2 = new JLabel("전화번호");
		jl3 = new JLabel("주  소");
		
		jp3.add(jl1);
		jp3.add(jl2);
		jp3.add(jl3);
		
		jta= new JTextArea();
		JScrollPane js = new JScrollPane(jta);
		js.setSize(430,300);
		js.setLocation(10,10);
		add(js);
		
		add(jp1);
		add(jp2);
		add(jp3);

		setSize(900,450);
		setVisible(true);
		
	}
	
	class ContactA implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Vector<String> v = new Vector<String>(); //벡터 생성
			Set<String> keys = map.keySet(); //해시맵의 모든 키를 담은 Set 컬렉션 리턴
			v.addAll(keys); //벡터에 모든키 다 넣기
			Collections.sort(v); //컬렉션에 포함된 요소들을 소팅
			Iterator<String> it =v.iterator(); //순차검색
			while(it.hasNext()){//모든 요소 방문
				String name= it.next(); //다음요소 리턴
				Phone phone=map.get(name); 
				jta.append(name+" : "+phone.getPhone()+" "+phone.getAddress()+"\n");
			}
			jf1.setText("");
			jf2.setText("");
			jf3.setText("");
		}
	}
	
	class ContactB implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String ToFindName = jf1.getText();
			if(map.containsKey(ToFindName)){
				Phone phone = map.get(ToFindName);
				jta.append(ToFindName+" : " + phone.getPhone()+ " "+phone.getAddress()+" \n");
				 
			}
			jf1.setText("");
			jf2.setText("");
			jf3.setText("");
		}
	}
	class ContactC implements ActionListener{
		public void actionPerformed(ActionEvent e){
			map.put(jf1.getText(), new Phone(jf2.getText(), jf3.getText()));
			if(jf1.getText()==" "){
				jta.append("비어있습니다. 다시입력하세요\n");
			}else{
				jta.append(jf1.getText()+"는(은) 등록되었습니다.\n");
			}
			jf1.setText("");
			jf2.setText("");
			jf3.setText("");
		}
	}
	
	class ContactD implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String ToRemoveName = jf1.getText();
			if(map.containsKey(ToRemoveName)){
				map.remove(ToRemoveName);
				jta.append((jf1.getText()+"는(은) 삭제되었습니다.\n"));
			}else{
				jta.append(jf1.getText()+"는(은) 등록되지 않은 사람입니다.\n");
			}
			jf1.setText("");
			jf2.setText("");
			jf3.setText("");
		}
	}
	public static void main(String[] args){
		new HashPhone();
	}
}


