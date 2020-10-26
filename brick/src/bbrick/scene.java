package bbrick;
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException;

import java.applet.AudioClip;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.File; 
import java.net.URL; 
public class scene extends JFrame implements ActionListener{
	bgm bgm=new bgm();
	public scene() {
		this.setTitle("打磚塊");
		this.setSize(1600,900);
		this.setResizable(false);   //設定視窗可否被縮放
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);		//設置窗口居中顯示
		bgm.run();
		JButton btn4=new JButton("本遊戲有死亡印章，收集方式為秘密，集滿7章便可達神秘領域");
		btn4.setFont(new Font("標楷體", Font.BOLD, 36));
		btn4.setForeground(Color.black);
	    btn4.setBounds(100,100,1200,50);
	    this.add(btn4);
		JButton btn = new JButton("開始遊戲");
		btn.setForeground(Color.red);
		btn.setFont(new Font("標楷體", Font.BOLD, 72));
		btn.setBackground(Color.LIGHT_GRAY);
		btn.setBounds(100,550,400,200); 
		btn.setActionCommand("開始遊戲");
		btn.addActionListener(this);
		this.add(btn);
		JButton btn1 = new JButton("結束遊戲");
		btn1.setForeground(Color.red);
		btn1.setFont(new Font("標楷體", Font.BOLD, 30));
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.setBounds(1300,250,170,80); 
		btn1.setActionCommand("結束遊戲");
		btn1.addActionListener(this);
		this.add(btn1);
		Icon i = new ImageIcon(getClass().getResource("/image/background.png"));
		//使用JLabel制作背景
		JLabel lab_bg = new JLabel(i);
		//設置要添加的組件的位置與大小
		lab_bg.setBounds(10, 10, 1600, 900);
		this.add(lab_bg);	
		this.setVisible(true); 
		bgm.run();
	}
	  public void actionPerformed(ActionEvent e) {
		  String cmd = e.getActionCommand();
	      if (cmd == "開始遊戲") {
	    	  this.setVisible(false);  
	    	  HitBrick brick = new HitBrick();	    	  
	      }
	      if (cmd == "結束遊戲") {
	    	  this.setVisible(false);      	  
	      }	 
	  }
	  public class bgm implements Runnable {
			 URL u1 = this.getClass().getClassLoader().getResource("sound/xx.wav");
			 AudioClip co1 = JApplet.newAudioClip(u1);
			 public void run() {
				 co1.loop();
			 try {
				 Thread.sleep(1000);} catch (InterruptedException e) {
					 e.printStackTrace();
					 }
			 }
	  }
	  public static void main(String[] args){
		  new scene();
		  }
}