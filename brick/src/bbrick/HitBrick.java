package bbrick;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL; 
public class HitBrick extends JFrame implements  KeyListener{
	  private BallThread greenBallThread;
	  private boolean xUp,yUp,bouncing;
	  private int x,y,xDx,yDy;
	  private final int MAX_X=900,MAX_Y=1000;
	  private boolean renew;
	  private JLabel label;JLabel label1;JLabel label2;
	  private int Rx,Ry;int time=0;
	  private Brick brick[]=new Brick[100];
	  private Ball ball;
	  boolean looping = false; 
	  bgm bgm=new bgm();
	public HitBrick(){
	    super("打BRICK");    
	    Container pane=getContentPane();
	    label=new JLabel("按空白鍵開始遊戲                   注意球速不固定<玩贏多次有獎勵");
	    label.setHorizontalAlignment(JLabel.CENTER);
	    label.setVerticalAlignment(JLabel.BOTTOM);
	    label.setFont(new Font("標楷體", Font.BOLD, 26));
	    pane.add(label);
	    xUp=true;
	    yUp=false;
	    xDx=1;
	    yDy=1;
	    x=450;
	    y=950;
	    Rx=420;
	    Ry=960;
	    renew=true;
	    bouncing=false;
	    addKeyListener(this);
	    brick[0]=new Brick(0,60,50,20);
	    brick[1]=new Brick(50,60,50,20);
	    brick[2]=new Brick(100,60,50,20);
	    brick[3]=new Brick(150,60,50,20);
	    brick[4]=new Brick(200,60,50,20);
	    brick[5]=new Brick(250,60,50,20);
	    brick[6]=new Brick(300,60,50,20);
	    brick[7]=new Brick(350,60,50,20);
	    brick[8]=new Brick(400,60,50,20);
	    brick[9]=new Brick(450,60,50,20);
	    brick[10]=new Brick(500,60,50,20);
	    brick[11]=new Brick(550,60,50,20);
	    brick[12]=new Brick(600,60,50,20);
	    brick[13]=new Brick(650,60,50,20);
	    brick[14]=new Brick(700,60,50,20);
	    brick[15]=new Brick(750,60,50,20);
	    brick[16]=new Brick(800,60,50,20);
	    brick[17]=new Brick(0,90,50,20);
	    brick[18]=new Brick(50,90,50,20);
	    brick[19]=new Brick(100,90,50,20);
	    brick[20]=new Brick(150,90,50,20);
	    brick[21]=new Brick(200,90,50,20);
	    brick[22]=new Brick(250,90,50,20);
	    brick[23]=new Brick(300,110,50,20);
	    brick[24]=new Brick(350,110,50,20);
	    brick[25]=new Brick(400,110,50,20);
	    brick[26]=new Brick(450,110,50,20);
	    brick[27]=new Brick(500,110,50,20);
	    brick[28]=new Brick(550,110,50,20);
	    brick[29]=new Brick(600,110,50,20);
	    brick[30]=new Brick(650,110,50,20);
	    brick[31]=new Brick(700,110,50,20);
	    brick[32]=new Brick(750,110,50,20);
	    brick[33]=new Brick(800,110,50,20);
	    brick[34]=new Brick(50,110,50,20);
	    brick[35]=new Brick(100,130,50,20);
	    brick[36]=new Brick(150,130,50,20);
	    brick[37]=new Brick(200,110,50,20);  
	    brick[38]=new Brick(0,160,50,20);
	    brick[39]=new Brick(50,160,50,20);
	    brick[40]=new Brick(100,160,50,20);
	    brick[41]=new Brick(150,160,50,20);
	    brick[42]=new Brick(200,160,50,20);
	    brick[43]=new Brick(250,160,50,20);
	    brick[44]=new Brick(300,160,50,20);
	    brick[45]=new Brick(350,160,50,20);
	    brick[46]=new Brick(400,160,50,20);
	    brick[47]=new Brick(450,160,50,20);
	    brick[48]=new Brick(500,160,50,20);
	    brick[49]=new Brick(650,160,50,20);
	    brick[50]=new Brick(700,160,50,20);
	    brick[51]=new Brick(750,160,50,20);
	    brick[52]=new Brick(800,160,50,20);
	    brick[53]=new Brick(850,160,50,20);
	    brick[54]=new Brick(600,90,50,20);
	    brick[55]=new Brick(300,90,50,20);
	    brick[56]=new Brick(350,90,50,20);
	    brick[57]=new Brick(450,90,50,20);
	    brick[58]=new Brick(550,90,50,20);
	    brick[59]=new Brick(650,90,50,20);
	    brick[60]=new Brick(700,90,50,20);
	    brick[61]=new Brick(750,90,50,20);
	    brick[62]=new Brick(800,90,50,20);
	    brick[63]=new Brick(850,130,50,20);
	    brick[64]=new Brick(650,130,50,20);
	    brick[65]=new Brick(450,130,50,20);
	    brick[66]=new Brick(400,130,50,20);
	    for(int n=67;n<=75;n++){
	    	int x1,y1;
	    	x1=(n-66)*50;
	    	y1=(n-66)*50+160;
	    	brick[n]=new Brick(x1,y1,50,20);
	    }
	    for(int n=76;n<=84;n++){
	    	int x1,y1;
	    	x1=(n-75)*50+140;
	    	y1=(n-75)*50+200;
	    	brick[n]=new Brick(x1,y1,50,20);
	    }
	    for(int n=85;n<=93;n++){
	    	int x1,y1;
	    	x1=(n-84)*50+240;
	    	y1=(n-84)*50+200;
	    	brick[n]=new Brick(x1,y1,50,20);
	    }
	    for(int n=94;n<=99;n++){
	    	int x1,y1;
	    	x1=(n-93)*50+400;
	    	y1=(n-93)*50+200;
	    	brick[n]=new Brick(x1,y1,50,20);
	    }
	    ball=new Ball(450,950,10,10);    
	    setSize(MAX_X,MAX_Y);
	    setResizable(false);
	    setVisible( true );
	  }
	  public void keyPressed(KeyEvent e) {
	    if (e.getKeyCode() ==e.VK_SPACE) {
	      if(renew){
	        greenBallThread=new BallThread(this);
	        bouncing = true;
	        greenBallThread.start();
	        label.setVisible(false);
	      }
	      renew=false;
	    }
	    if(e.getKeyCode()==e.VK_LEFT){
	      Rx=Rx-20;
	      if(bouncing){
	        if(Rx<0){
	          Rx=0;
	        }
	      }
	      else{
	        if(Rx<0){
	          Rx=0;
	        }
	        else{
	          x=x-20;
	          ball.ball_x=x;
	        }
	      }
	      repaint();
	    }
	    if(e.getKeyCode()==e.VK_RIGHT){
	      Rx=Rx+20;
	      if(bouncing){
	        if(Rx+80>900){
	          Rx=820;
	        }
	      }
	      else{
	        if(Rx+80>900){
	          Rx=820;
	        }
	        else{
	          x=x+20;
	          ball.ball_x=x;
	        }
	      }
	      repaint();
	    }
	  }
	  public void keyReleased (KeyEvent e) {}
	  public void keyTyped (KeyEvent e){}


	  public void paint(Graphics g){
	    super.paint(g);
	    ball.rect.setLocation(x,y);
	    if(bouncing){
	      for(int i=0;i<=99;i++){
	        if(brick[i].visible==true){
	          switch(i){
	          	  case 0 :g.setColor(Color.red);
	          			  break;
			      case 1 :g.setColor(Color.red);
			              break;
			      case 2 :g.setColor(Color.red);
			              break;
			      case 3 :g.setColor(Color.red);
			              break;
			      case 4 :g.setColor(Color.red);
			              break;
			      case 5 :g.setColor(Color.red);
			              break;
			      case 6 :g.setColor(Color.red);
			              break;
			      case 7 :g.setColor(Color.red);
			              break;
			     case 8 :g.setColor(Color.red);
			              break;
			     case 9 :g.setColor(Color.red);
			              break;
			     case 10 :g.setColor(Color.red);
			              break;
			     case 11 :g.setColor(Color.red);
			              break;
			     case 12 :g.setColor(Color.red);
			              break;
			     case 13 :g.setColor(Color.red);
			              break;
			     case 14 :g.setColor(Color.red);
			              break;
			     case 15 :g.setColor(Color.red);
			              break;
			     case 16 :g.setColor(Color.red);
			              break;
			     case 17 :g.setColor(Color.yellow);
			              break;
			     case 18 :g.setColor(Color.blue);
			     	      break;
			     case 19 :g.setColor(Color.blue);
			     		  break;
			     case 20 :g.setColor(Color.blue);
			     		  break;
			     case 21 :g.setColor(Color.blue);
			      		  break;
			     case 22 :g.setColor(Color.blue);
			     			break;
			     case 23 :g.setColor(Color.yellow);
			     			break;
			     case 24 :g.setColor(Color.yellow);
			     			break;
			     case 25 :g.setColor(Color.yellow);
			     			break;
			     case 26 :g.setColor(Color.yellow);
			     			break;
			     case 27 :g.setColor(Color.yellow);
			     			break;
			     case 28 :g.setColor(Color.yellow);
			     			break;
			     case 29 :g.setColor(Color.yellow);
			     			break;
			     case 30 :g.setColor(Color.yellow);
			     			break;
			     case 31 :g.setColor(Color.yellow);
			     			break;
			     case 32 :g.setColor(Color.yellow);
			     			break;
			     case 33 :g.setColor(Color.yellow);
			     			break;
			     case 34 :g.setColor(Color.yellow);
			     			break;
			     case 35 :g.setColor(Color.green);
			     			break;
			     case 36 :g.setColor(Color.green);
			     			break;
			     case 37 :g.setColor(Color.yellow);
			     			break;
			     case 38 :g.setColor(Color.blue);
			     			break;
			     case 39 :g.setColor(Color.blue);
			     			break;
			     case 40 :g.setColor(Color.blue);
			     			break; 
			     case 41 :g.setColor(Color.blue);
							break; 
			     case 42 :g.setColor(Color.blue);
							break; 
			     case 43 :g.setColor(Color.blue);
							break; 
			     case 44 :g.setColor(Color.blue);
							break; 
			     case 45 :g.setColor(Color.blue);
							break; 
			     case 46 :g.setColor(Color.blue);
							break; 
			     case 47 :g.setColor(Color.blue);
							break; 
			     case 48 :g.setColor(Color.blue);
							break; 
			     case 49 :g.setColor(Color.blue);
							break; 
			     case 50 :g.setColor(Color.blue);
							break; 
			     case 51 :g.setColor(Color.blue);
							break; 
			     case 52 :g.setColor(Color.blue);
							break; 
			     case 53 :g.setColor(Color.blue);
							break; 
			     case 54 :g.setColor(Color.orange);
			     			break;
			     case 55 :g.setColor(Color.orange);
			     			break;
			     case 56 :g.setColor(Color.orange);
			     			break;
			     case 57 :g.setColor(Color.orange);
			     			break;
			     case 58 :g.setColor(Color.orange);
							break;
			     case 59 :g.setColor(Color.orange);
							break;
			     case 60 :g.setColor(Color.orange);
							break;
			     case 61 :g.setColor(Color.orange);
							break;
			     case 62 :g.setColor(Color.orange);
							break;
			     case 63 :g.setColor(Color.green);
							break;
			     case 64 :g.setColor(Color.green);
							break;
			     case 65 :g.setColor(Color.green);
							break;
			     case 66 :g.setColor(Color.green);
							break; 
			     case 67 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 68 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 69 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 70 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 71 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 72 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 73 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 74 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 75 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 76 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 77 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 78 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 79 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 80 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 81 :g.setColor(Color.LIGHT_GRAY);
					break; 				
			     case 82 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 83 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 84 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 85 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 86 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 87 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 88 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 89 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 90 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 91 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 92 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 93 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 94 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 95 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 96 :g.setColor(Color.LIGHT_GRAY);
					break; 
			     case 97 :g.setColor(Color.LIGHT_GRAY);
					break; 					
			     case 98 :g.setColor(Color.LIGHT_GRAY);
					break; 					
			     case 99 :g.setColor(Color.LIGHT_GRAY);
					break; 					
	           }
	        g.fill3DRect(brick[i].brick_x,brick[i].brick_y,brick[i].brick_width,brick[i].brick_height,true);
	        }
	      }
	      g.setColor(Color.red);
	      g.fillOval(x, y, 10, 10);
	      g.setColor(Color.blue);
	      g.fillRect(Rx,Ry,80,20);
	    }
	    else{
	      for(int i=0;i<=99;i++){
	        switch(i){
	            case 0 :g.setColor(Color.red);
	                    break;
	            case 1 :g.setColor(Color.red);
	                    break;
	            case 2 :g.setColor(Color.red);
	                    break;
	            case 3 :g.setColor(Color.red);
	                    break;
	            case 4 :g.setColor(Color.red);
	                    break;
	            case 5 :g.setColor(Color.red);
	                    break;
	            case 6 :g.setColor(Color.red);
	                    break;
	            case 7 :g.setColor(Color.red);
	                    break;
	           case 8 :g.setColor(Color.red);
	                    break;
	           case 9 :g.setColor(Color.red);
	                    break;
	           case 10 :g.setColor(Color.red);
	                    break;
	           case 11 :g.setColor(Color.red);
	                    break;
	           case 12 :g.setColor(Color.red);
	                    break;
	           case 13 :g.setColor(Color.red);
	                    break;
	           case 14 :g.setColor(Color.red);
	                    break;
	           case 15 :g.setColor(Color.red);
	                    break;
	           case 16 :g.setColor(Color.red);
	                    break;
	           case 17 :g.setColor(Color.yellow);
	                    break;
	           case 18 :g.setColor(Color.blue);
               			break;
	           case 19 :g.setColor(Color.blue);
	           			break;
	           case 20 :g.setColor(Color.blue);
               			break;
	           case 21 :g.setColor(Color.blue);
	            		break;
	           case 22 :g.setColor(Color.blue);
	           			break;
	           case 23 :g.setColor(Color.yellow);
	           			break;
	           case 24 :g.setColor(Color.yellow);
	           			break;
	           case 25 :g.setColor(Color.yellow);
	           			break;
	           case 26 :g.setColor(Color.yellow);
	           			break;
	           case 27 :g.setColor(Color.yellow);
	           			break;
	           case 28 :g.setColor(Color.yellow);
               			break;
	           case 29 :g.setColor(Color.yellow);
	           			break;
               case 30 :g.setColor(Color.yellow);
               			break;
               case 31 :g.setColor(Color.yellow);
               			break;
               case 32 :g.setColor(Color.yellow);
               			break;
               case 33 :g.setColor(Color.yellow);
               			break;
               case 34 :g.setColor(Color.yellow);
               			break;
               case 35 :g.setColor(Color.green);
               			break;
               case 36 :g.setColor(Color.green);
               			break;
               case 37 :g.setColor(Color.yellow);
               			break;
               case 38 :g.setColor(Color.blue);
               			break;
               case 39 :g.setColor(Color.blue);
               			break;
               case 40 :g.setColor(Color.blue);
               			break; 
               case 41 :g.setColor(Color.blue);
      					break; 
               case 42 :g.setColor(Color.blue);
      					break; 
               case 43 :g.setColor(Color.blue);
      					break; 
               case 44 :g.setColor(Color.blue);
      					break; 
               case 45 :g.setColor(Color.blue);
      					break; 
               case 46 :g.setColor(Color.blue);
      					break; 
               case 47 :g.setColor(Color.blue);
      					break; 
               case 48 :g.setColor(Color.blue);
      					break; 
               case 49 :g.setColor(Color.blue);
      					break; 
               case 50 :g.setColor(Color.blue);
      					break; 
               case 51 :g.setColor(Color.blue);
      					break; 
               case 52 :g.setColor(Color.blue);
      					break; 
               case 53 :g.setColor(Color.blue);
      					break; 
               case 54 :g.setColor(Color.orange);
               			break;
               case 55 :g.setColor(Color.orange);
               			break;
               case 56 :g.setColor(Color.orange);
               			break;
               case 57 :g.setColor(Color.orange);
               			break;
               case 58 :g.setColor(Color.orange);
      					break;
               case 59 :g.setColor(Color.orange);
      					break;
               case 60 :g.setColor(Color.orange);
      					break;
               case 61 :g.setColor(Color.orange);
      					break;
               case 62 :g.setColor(Color.orange);
      					break;
               case 63 :g.setColor(Color.green);
      					break;
               case 64 :g.setColor(Color.green);
						break;
               case 65 :g.setColor(Color.green);
						break;
               case 66 :g.setColor(Color.green);
						break;
               case 67 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 68 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 69 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 70 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 71 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 72 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 73 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 74 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 75 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 76 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 77 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 78 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 79 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 80 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 81 :g.setColor(Color.LIGHT_GRAY);
				break; 				
		     case 82 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 83 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 84 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 85 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 86 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 87 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 88 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 89 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 90 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 91 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 92 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 93 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 94 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 95 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 96 :g.setColor(Color.LIGHT_GRAY);
				break; 
		     case 97 :g.setColor(Color.LIGHT_GRAY);
				break; 					
		     case 98 :g.setColor(Color.LIGHT_GRAY);
				break; 					
		     case 99 :g.setColor(Color.LIGHT_GRAY);
				break; 					
	         }
	         g.fill3DRect(brick[i].brick_x,brick[i].brick_y,brick[i].brick_width,brick[i].brick_height,true);
	      }
	      g.setColor(Color.red);
	      g.fillOval(x, y, 10, 10);
	      g.setColor(Color.blue);
	      g.fillRect(Rx, Ry, 80, 20);
	    }
	  }
	  public void move(){
	    while(true){
	      try{
	        Thread.currentThread().sleep(25);
	      }
	      catch(InterruptedException exception){
	        System.err.println(exception.toString());
	      }
	      for(int i=0;i<=99;i++){
	        if(ball.rect.intersects(brick[i].rect)&&brick[i].visible){
	          brick[i].visible=false;
	          yUp=!yUp;
	        }
	      }
	      if(x+5>Rx&&x+5<Rx+80&&y+10>=Ry){
	        yUp=false;
	        xDx=(int)(Math.random()*10+2);
	        yDy=(int)(Math.random()*10+2);
	      }
	      if(xUp==true){
	        x+=xDx;
	      }
	      else{
	        x-=xDx;
	      }
	      if(yUp==true){
	        y+=yDy;
	      }
	      else{
	        y-=yDy;
	      }
	      if(y<=60){
	        y=60;
	        ball.ball_y=y;
	        yUp=true;
	        xDx=(int)(Math.random()*10+2);
	        yDy=(int)(Math.random()*10+2);
	      }
	      else if(y>=MAX_Y-15){
	        yDy=(int)(Math.random()*10+2);
	        yUp=false;
	        break;
	      }
	      if(x<=0){
	        x=0;
	        ball.ball_x=x;
	        xUp=true;
	        xDx=(int)(Math.random()*10+2);
	        yDy=(int)(Math.random()*10+2);
	      }
	      else if(x>=MAX_X-10){
	        x=MAX_X-10;
	        ball.ball_x=x;
	        xDx=(int)(Math.random()*10+2);
	        yDy=(int)(Math.random()*10+2);
	        xUp=false;
	      }
	      ball.rect.setLocation(ball.ball_x,ball.ball_y);
	      repaint();
	      int i;                                       
	      for(i=0;i<=99&&brick[i].visible==false;i++){   
	      }
	      if(i==100){
	        break;
	      }                                          
	    }
	    bgm.run();
        int ran = (int)(Math.random()*100+0);
        if(ran<50){
        	time=time+1;
        	System.out.println(time);
        	Frame frame = new Frame("AWTDemo");
	        frame.addWindowListener(new AdapterDemo());
	        frame.setLayout(new FlowLayout());
	        frame.setSize(320, 200);
	        Dialog dialog = new Dialog(frame, "你目前收集到的死亡印章");
	        dialog.setSize(320, 200);
	        dialog.add(new Label("U DEAD"));
	        dialog.setFont(new Font("標楷體", Font.BOLD, 72));
	        dialog.setVisible(true);
        	if(time==7){
        		this.setVisible(false);  
        		kkk ccc = new kkk();
        	}
        
		}
	    renew=true;        
	    bouncing=false;
	    for(int i=0;i<=99;i++){
	      brick[i].visible=true;
	    }
	    xUp=true;
	    yUp=false;
	    xDx=1;
	    yDy=1;
	    x=450;
	    y=950;
	    Rx=420;
	    Ry=960;         
	    repaint();
	    repaint();
	    label.setVisible(true);
	    bgm.run();
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
	  public static void main(String[] args) {
	    HitBrick mar=new HitBrick();
	    
	  }
	}
	class BallThread extends Thread{
	  private HitBrick m;
	  BallThread(HitBrick a){
	    //super();
	    m=a;
	  }
	  public void  run(){
	    m.move();
	    m.repaint();
	  }
	}
	class Brick{
	  Rectangle rect=null;
	  int brick_x,brick_y;
	  int brick_width,brick_height; 
	  boolean visible;
	  public Brick(int x,int y,int w,int h)
	      {
	      brick_x=x;brick_y=y;
	      brick_width=w;brick_height=h;
	      visible=true;
	      rect=new Rectangle(x,y,w,h); 
	  }
	}
	class Ball{
	  Rectangle rect=null;
	  int ball_x,ball_y;
	  int ball_width,ball_height;
	  public Ball(int x,int y,int w,int h){
	    ball_x=x;
	    ball_y=y;
	    ball_width=w;
	    ball_height=h;
	    rect=new Rectangle(x,y,w,h);
	  }
	}