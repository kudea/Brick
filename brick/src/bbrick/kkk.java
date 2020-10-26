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
		this.setTitle("開寶箱時間");
		this.setSize(800,500);
		this.setResizable(false);   //設定視窗可否被縮放
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);		//設置窗口居中顯示
		JButton btn = new JButton("我不敢開");
		btn.setForeground(Color.red);
		btn.setFont(new Font("標楷體", Font.BOLD, 60));
		btn.setBackground(Color.LIGHT_GRAY);
		btn.setBounds(100,350,300,100); 
		btn.setActionCommand("我不敢開");
		btn.addActionListener(this);
		this.add(btn);
		JButton btn1 = new JButton("我敢開");
		btn1.setForeground(Color.blue);
		btn1.setFont(new Font("標楷體", Font.BOLD, 60));
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.setBounds(450,350,250,100); 
		btn1.setActionCommand("我敢開");
		btn1.addActionListener(this);
		this.add(btn1);
		Icon i = new ImageIcon(getClass().getResource("/image/treasure.jpg"));
		//使用JLabel制作背景
		JLabel lab_bg = new JLabel(i);
		//設置要添加的組件的位置與大小
		lab_bg.setBounds(10, 10, 800, 500);
		this.add(lab_bg);	
		this.setVisible(true); 
		
	}
	  public void actionPerformed(ActionEvent e) {
		  String cmd = e.getActionCommand();
	      if (cmd == "我不敢開") {
	    	  this.setVisible(false);  
	    	  HitBrick brick = new HitBrick();	    	  
	      }
	      if (cmd == "我敢開") {
	    	  this.setVisible(false);  
	    	  gift pss = new gift();      	  
	      }	 
	  }
	  public static void main(String[] args){
		  new kkk();
		  }
}