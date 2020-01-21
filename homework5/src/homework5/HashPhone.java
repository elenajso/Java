package homework5;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

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
		jb1 = new JButton("��ȸ");
		jb2= new JButton("�˻�");
		jb3= new JButton("����");
		jb4= new JButton("����");
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
	
		jl1 = new JLabel("��  ��");
		jl2 = new JLabel("��ȭ��ȣ");
		jl3 = new JLabel("��  ��");
		
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
			Vector<String> v = new Vector<String>(); //���� ����
			Set<String> keys = map.keySet(); //�ؽø��� ��� Ű�� ���� Set �÷��� ����
			v.addAll(keys); //���Ϳ� ���Ű �� �ֱ�
			Collections.sort(v); //�÷��ǿ� ���Ե� ��ҵ��� ����
			Iterator<String> it =v.iterator(); //�����˻�
			while(it.hasNext()){//��� ��� �湮
				String name= it.next(); //������� ����
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
				jta.append("����ֽ��ϴ�. �ٽ��Է��ϼ���\n");
			}else{
				jta.append(jf1.getText()+"��(��) ��ϵǾ����ϴ�.\n");
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
				jta.append((jf1.getText()+"��(��) �����Ǿ����ϴ�.\n"));
			}else{
				jta.append(jf1.getText()+"��(��) ��ϵ��� ���� ����Դϴ�.\n");
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


