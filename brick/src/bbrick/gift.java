package bbrick;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class gift extends JFrame{
	JLabel jl,jl1;
	final JLabel jl2,jl3;
	JLabel jl4; 
	public String person;
	public String m;
	int j;
	int i;
	final String[]arr=new String[3];
	public void Win(String person){
		arr[0]="石頭";
		arr[1]="剪刀";
		arr[2]="布";
		person=arr[j];
		i=(int)(Math.random()*3);
		String c=arr[i];
		if(c.equals(person)){
			jl4.setText("平手");
			}
		else if(c.equals("剪刀")&&person.equals("石頭")||c.equals("石頭")&&person.equals("布")||c.equals("布")&&person.equals("剪刀")){
		jl4.setText("你赢了");
		}
		else{
		jl4.setText("你输了");
		}
	}
	public gift(){
		JFrame jf=new JFrame();
		this.setSize(890,910);
		this.setTitle("猜拳遊戲");
		this.setLayout(null);
		jl=new JLabel("電腦出的是：");
		jl.setFont(new Font("標楷體", Font.BOLD, 26));
		jl.setBounds(30,300,200,200);
		this.add(jl);
		jl1=new JLabel("我出的是：");
		jl1.setFont(new Font("標楷體", Font.BOLD, 26));
		jl1.setBounds(30,480,200,200);
		this.add(jl1);
		//computer出
		jl2=new JLabel();
		jl2.setFont(new Font("標楷體", Font.BOLD, 26));
		jl2.setBounds(250,300,200,200);
		this.add(jl2);
		//I出
		jl3=new JLabel();
		jl3.setFont(new Font("標楷體", Font.BOLD, 26));
		jl3.setBounds(250,480,200,200);
		this.add(jl3);
		jl4=new JLabel("");
		jl4.setFont(new Font("標楷體", Font.BOLD, 26));
		jl4.setBounds(276,772,100,50);
		this.add(jl4);
		//按钮
        final JButton btn=new JButton("石頭");
        btn.setFont(new Font("標楷體", Font.BOLD, 26));
		btn.setBounds(576,200,162,127);
		this.add(btn);
		final JButton btn1=new JButton("剪刀");
		btn1.setFont(new Font("標楷體", Font.BOLD, 26));
		btn1.setBounds(576,380,162,127);
		this.add(btn1);
		final JButton btn2=new JButton("布");
		btn2.setFont(new Font("標楷體", Font.BOLD, 26));
		btn2.setBounds(576,560,162,127);
		this.add(btn2);
		JButton btn3=new JButton("ㄎㄅ整我嗎??");
		btn3.setFont(new Font("標楷體", Font.BOLD, 30));
		btn3.setBounds(100,50,250,80);
		this.add(btn3);
		//按钮事件
		btn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0){
				j=0;
				String b=btn.getActionCommand();
				jl3.setText(b);
				jl3.setIcon(new ImageIcon(getClass().getResource("/image/1.jpg")));
				Win(person);
				gift.this.jl2.setText(arr[i]);
				System.out.println(arr[i]);
				if(arr[i].equals("石頭")){
					gift.this.jl2.setIcon(new ImageIcon(getClass().getResource("/image/1.jpg")));
				}
				else if(arr[i].equals("剪刀")){
					gift.this.jl2.setIcon(new ImageIcon(getClass().getResource("/image/2.jpg")));
				}
				else if(arr[i].equals("布")){
					gift.this.jl2.setIcon(new ImageIcon(getClass().getResource("/image/0.jpg")));
				}
			}
		});
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				j=1;
				String b1=btn1.getActionCommand();
				jl3.setText(b1);
				jl3.setIcon(new ImageIcon(getClass().getResource("/image/2.jpg")));
				Win(person);
				gift.this.jl2.setText(arr[i]);
				System.out.println(arr[i]);
				if(arr[i].equals("石頭")){
					gift.this.jl2.setIcon(new ImageIcon(getClass().getResource("/image/1.jpg")));
				}
				else if(arr[i].equals("剪刀")){
					gift.this.jl2.setIcon(new ImageIcon(getClass().getResource("/image/2.jpg")));
				}
				else if(arr[i].equals("布")){
					gift.this.jl2.setIcon(new ImageIcon(getClass().getResource("/image/0.jpg")));
				}
				}
		});

		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				j=2;
				String b2=btn2.getActionCommand();
				jl3.setText(b2);
				jl3.setIcon(new ImageIcon(getClass().getResource("/image/0.jpg")));
				Win(person);
				gift.this.jl2.setText(arr[i]);
				System.out.println(arr[i]);
				if(arr[i].equals("石頭")){
					gift.this.jl2.setIcon(new ImageIcon(getClass().getResource("/image/1.jpg")));
				}
				else if(arr[i].equals("剪刀")){
					gift.this.jl2.setIcon(new ImageIcon(getClass().getResource("/image/2.jpg")));
				}
				else if(arr[i].equals("布")){
					gift.this.jl2.setIcon(new ImageIcon(getClass().getResource("/image/0.jpg")));
				}
			}
		});
		btn3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){  
				System.exit(0);		
			}
		});
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	public static void main(String[] args){
		gift t=new gift();
	}
}