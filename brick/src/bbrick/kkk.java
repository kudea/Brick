package bbrick;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class kkk extends JFrame implements ActionListener{
	public kkk() {
		this.setTitle("�}�_�c�ɶ�");
		this.setSize(800,500);
		this.setResizable(false);   //�]�w�����i�_�Q�Y��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);		//�]�m���f�~�����
		JButton btn = new JButton("�ڤ����}");
		btn.setForeground(Color.red);
		btn.setFont(new Font("�з���", Font.BOLD, 60));
		btn.setBackground(Color.LIGHT_GRAY);
		btn.setBounds(100,350,300,100); 
		btn.setActionCommand("�ڤ����}");
		btn.addActionListener(this);
		this.add(btn);
		JButton btn1 = new JButton("�ڴ��}");
		btn1.setForeground(Color.blue);
		btn1.setFont(new Font("�з���", Font.BOLD, 60));
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.setBounds(450,350,250,100); 
		btn1.setActionCommand("�ڴ��}");
		btn1.addActionListener(this);
		this.add(btn1);
		Icon i = new ImageIcon(getClass().getResource("/image/treasure.jpg"));
		//�ϥ�JLabel��@�I��
		JLabel lab_bg = new JLabel(i);
		//�]�m�n�K�[���ե󪺦�m�P�j�p
		lab_bg.setBounds(10, 10, 800, 500);
		this.add(lab_bg);	
		this.setVisible(true); 
		
	}
	  public void actionPerformed(ActionEvent e) {
		  String cmd = e.getActionCommand();
	      if (cmd == "�ڤ����}") {
	    	  this.setVisible(false);  
	    	  HitBrick brick = new HitBrick();	    	  
	      }
	      if (cmd == "�ڴ��}") {
	    	  this.setVisible(false);  
	    	  gift pss = new gift();      	  
	      }	 
	  }
	  public static void main(String[] args){
		  new kkk();
		  }
}