import java.io.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

// Online Music Interface

public class OnlineMusic extends Frame  implements Runnable,ActionListener{
	
	Image  img1,img2;
	Button b1,b2,b3,b4,b5,b6,b7,bs,bp,b8,bc,br,be,bso;  
	Label l1,l2,l3,l4,l5,l6,l7,l8,ll,lp; 
	Checkbox cbw1,cbw2,cbw3,cbw4;
	Checkbox cbc1,cbc2,cbc3,cbc4;
	Checkbox cbj1,cbj2,cbj3,cbj4;
	Checkbox cbp1,cbp2,cbp3,cbp4;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	ImageIcon imgi1,imgi2,imgi3,imgi4,imgi5,imgi6;
	Thread t;
	String s1uname;
	TextField tf,tl,tp ; 
	int count,temp;
	AudioFormat af;
  	AudioInputStream ais;
  	SourceDataLine sdl;
  	boolean stopPlayback = false;
   	Choice ch;
	Connection con;
   	PreparedStatement stat;
  	Statement stmt,stmt1;
  	ResultSet rs,rs1;
	int enter=0;
	Panel p = new Panel();
	Panel p1 = new Panel();	
	Panel p2 = new Panel();	
	Panel p3 = new Panel();	
	Panel p4 = new Panel();	
	Panel p5 = new Panel();
	String sw1,sw2,sw3,sw4;
	String sc1,sc2,sc3,sc4;
	String sj1,sj2,sj3,sj4;
	String sp1,sp2,sp3,sp4;
		
	OnlineMusic(){
		super("ONLINE MUSIC STORE");
		
   		setVisible(true);
		setSize(1000,680);
		setLayout(null);
		System.out.println("");		
		System.out.println("WELCOME TO WWW.ONLINE MUSIC STORE.COM");
		MediaTracker mt1=new MediaTracker(this);
		img1=Toolkit.getDefaultToolkit().getImage("bkgrnd.png");
		mt1.addImage(img1,0);
				
		MediaTracker mt2=new MediaTracker(this);
		img2=Toolkit.getDefaultToolkit().getImage("mply2.gif");
		mt2.addImage(img2,1);
		
		setFont(new Font("sansserif",Font.PLAIN,18));

		b1=new Button("CATEGORY");
		b2=new Button("WESTERN");
		b3=new Button("CLASSIC");
		b4=new Button(" JAZZ  ");
		b5=new Button(" POP ");
		b6=new Button("ADD TO CART");
	
		b1.setFont(new Font("dialog",Font.PLAIN,18));
		b2.setFont(new Font("dialog",Font.BOLD,18));
		b3.setFont(new Font("dialog",Font.BOLD,18));
		b4.setFont(new Font("dialog",Font.BOLD,18));
		b5.setFont(new Font("dialog",Font.BOLD,18));
		b6.setFont(new Font("dialog",Font.PLAIN,18));
		
		b1.setBounds(15,235,140,40);
		b2.setBounds(15,315,140,35);
		b3.setBounds(15,365,140,35);
		b4.setBounds(15,415,140,35);
		b5.setBounds(15,465,140,35);
		b6.setBounds(770,630,150,35);
		
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.red);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.green);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.green);
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.green);
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.green);
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.red);
		
		cbw1=new Checkbox("Games For Brass - Quintet");
		cbw2=new Checkbox("Anything Goes - Cole Porter");
		cbw3=new Checkbox("Milestones - Holly Dunn");
		cbw4=new Checkbox("Play On - Carrie Underwood");
		
		cbw1.setFont(new Font("sansserif",Font.BOLD,16));
		cbw2.setFont(new Font("sansserif",Font.BOLD,16));
		cbw3.setFont(new Font("sansserif",Font.BOLD,16));
		cbw4.setFont(new Font("sansserif",Font.BOLD,16));
	
		cbc1=new Checkbox("Masters Of Indian Classical");
		cbc2=new Checkbox("Best Of Classical Masterpiece");
		cbc3=new Checkbox("Greatest Classical Masterpiece");
		cbc4=new Checkbox("Pleasant Classical Music");
		
		cbc1.setFont(new Font("sansserif",Font.BOLD,16));
		cbc2.setFont(new Font("sansserif",Font.BOLD,16));
		cbc3.setFont(new Font("sansserif",Font.BOLD,16));
		cbc4.setFont(new Font("sansserif",Font.BOLD,16));

		cbj1=new Checkbox("Kind of Blue - Miles Davis");
		cbj2=new Checkbox("Your Love - Boney James");
		cbj3=new Checkbox("Only Thrill - Melody Gardot");
		cbj4=new Checkbox("Good Day - Peter White");
		
		cbj1.setFont(new Font("sansserif",Font.BOLD,16));
		cbj2.setFont(new Font("sansserif",Font.BOLD,16));
		cbj3.setFont(new Font("sansserif",Font.BOLD,16));
		cbj4.setFont(new Font("sansserif",Font.BOLD,16));

		cbp1=new Checkbox("The Fame - Lady Gaga");
		cbp2=new Checkbox("Crazy Love - Michael Buble");
		cbp3=new Checkbox("All I Wanted - Kelly Clarkson");
		cbp4=new Checkbox("Battelfield - Jordin Sparks");
		
		cbp1.setFont(new Font("sansserif",Font.BOLD,16));
		cbp2.setFont(new Font("sansserif",Font.BOLD,16));
		cbp3.setFont(new Font("sansserif",Font.BOLD,16));
		cbp4.setFont(new Font("sansserif",Font.BOLD,16));		

		l1= new Label( "MUSIC ONLINE STORE" );
		l1.setBounds(140,0,260,40);
		l1.setForeground(Color.magenta);

		p.setBounds(260,235,480,270);
		p.setBackground(Color.BLACK);
		
		imgi5=new ImageIcon(getClass().getResource("main2.jpg"));
		jl6=new JLabel("",imgi5,JLabel.RIGHT);
		jl6.setBounds(80,40,320,250);	
		
		b8=new Button("ENTER >>");
		b8.setFont(new Font("dialog",Font.BOLD,16));
		b8.setBounds(220,208,100,23); 
		b8.setBackground(Color.WHITE);
		b8.setForeground(Color.red);
		p.add(b8);
		p.add(jl6);
		p.add( l1 );
		add(p);
		p.setVisible(true);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);	
		b8.addActionListener(this);
		l8=new Label("      TOP 10 SONGS   ");
		bs = new Button("II STOP");	
	 	bp = new Button("I> PLAY");
		bs.setFont(new Font("dialog",Font.BOLD,16));
		bp.setFont(new Font("dialog",Font.BOLD,16));
		bs.setBackground(Color.BLACK);
		bs.setForeground(Color.red);
		bp.setBackground(Color.BLACK);
		bp.setForeground(Color.green);
	  	
		ch=new Choice();
		ch.setFont(new Font("sansserif",Font.PLAIN,16));
		ch.add("21Guns-GreenDay");
		ch.add("Addicted-Enrique");
		ch.add("IfEverMeetAgain-KatePerry");
		ch.add("SayItRight-NellyFurtado");
		ch.add("TheWayIAre-KeriHilson");
		ch.add("JustDance-LadyGaga");
		ch.add("TikTok-Kehsa");
		ch.add("WeRWhoWeR-Kesha");
		ch.add("WhenImGone-Eminem");
		ch.add("WhoOwnsMyHeart-Miley");

   		bs.setEnabled(false);
                	bp.setEnabled(true);

		bp.addActionListener(this);
		bs.addActionListener(this);
		
		l8.setBounds(745,235,230,30);
		l8.setBackground(Color.BLACK);
		l8.setForeground(Color.magenta);
		ch.setBounds(750,300,200,30);
		ch.setBackground(Color.BLACK);
		ch.setForeground(Color.cyan);
		bp.setBounds(750,335,100,30);
		bs.setBounds(850,335,100,30);
		
		add(bp);
		add(l8);
		add(bs);
		add(ch);
	
		l6= new Label( "MUSIC ON WEB" );
		l7=new Label("ENJOY THE MUSIC");
		l6.setBackground(Color.BLACK);
		l6.setForeground(Color.red);
  		l7.setBackground(Color.BLACK);
		l7.setForeground(Color.green);	
		l6.setBounds(410,520,145,30);
		l7.setBounds(400,560,175,30);
		
		add(l6);
		add(l7);

		tf=new TextField(20);
		tf.setBounds(50,635,200,30);
		tf.setBackground(Color.BLACK);
		tf.setForeground(Color.red);
		add(tf);
	
		bc=new Button("CLOSE");
		bc.setBackground(Color.BLACK);
		bc.setForeground(Color.red);
		bc.setFont(new Font("dialog",Font.BOLD,14));
		bc.setBounds(930,30,60,25);
		add(bc);
		bc.addActionListener(this);
		
		bso=new Button("SIGN OUT");
		bso.setBackground(Color.BLACK);
		bso.setForeground(Color.red);
		bso.setFont(new Font("dialog",Font.BOLD,14));
		bso.setBounds(915,30,75,25);
		bso.addActionListener(this);

		// code for new module
		
		br=new Button("  SIGN UP FREE !!  ");
		br.setBackground(Color.BLACK);
		br.setForeground(Color.green);
		br.setFont(new Font("dialog",Font.BOLD,16));
		br.setBounds(750,60,200,40);
		add(br);
		br.addActionListener(this);

		be=new Button("SIGN IN");
		be.setBackground(Color.BLACK);
		be.setForeground(Color.green);
		be.setFont(new Font("dialog",Font.BOLD,14));
		be.setBounds(800,180,100,25);
		add(be);
		be.addActionListener(this);
		ll= new Label( "USERNAME" );
		ll.setFont(new Font("dialog",Font.BOLD,14));
		ll.setBounds(750,137,85,15);
		ll.setBackground(Color.BLACK);
		ll.setForeground(Color.red);
		add(ll);

		lp= new Label( "PASSWORD" );
		lp.setFont(new Font("dialog",Font.BOLD,14));
		lp.setBounds(750,157,85,15);
		lp.setBackground(Color.BLACK);
		lp.setForeground(Color.red);
		add(lp);

		tl=new TextField(10);
		tl.setFont(new Font("dialog",Font.BOLD,10));
		tl.setBounds(835,137,120,15);
		tl.setBackground(Color.WHITE);
		tl.setForeground(Color.black);
		add(tl);

		tp=new TextField(20);
		tp.setEchoChar('*');
		tp.setFont(new Font("dialog",Font.BOLD,10));
		tp.setBounds(835,157,120,15);
		tp.setBackground(Color.WHITE);
		tp.setForeground(Color.black);
		add(tp);

		t=new Thread(this);
		t.start();	
	}
	public void run(){
	try{
			int  k=1;
			int  a=410;
			int   b=400;
			int   p=1;	
			
			while(true){
			
			remove(l6);
			remove(l7);
			remove(tf);
			
			 if(a==260){
				k=2;
				}
			if(a==580){
				k=1;
				}
	
	
			if(a>260 && a<=580 &&  k%2!=0 ){
				a=a-10;
							
			}
			if ( a>=260 && a<580 && k%2==0){
				a=a+10;
			}
			l6.setBounds(a,520,145,30);
			add( l6);	
			
			if(b==260){
				p=1;
			}
			if(b==560){
				p=2;
			}
	
	
			if(b>=260 && b<560 &&  p%2!=0 ){
				b=b+10;
							
			}
			if (b<=560 && b>260 && p%2==0){
				b=b-10;
			}
			l7.setBounds(b,560,175,30);
			add( l7);	
			 
			Calendar currentDate = Calendar.getInstance();
  			SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
  			String s = formatter.format(currentDate.getTime());
				
			tf.setText(" "+s);
			add(tf);
			
			Thread.sleep(1000);
			}	
		}
		catch(InterruptedException e){
		}
	}
	public void update(Graphics g){
	    	paint(g);	
	}
	public void paint(Graphics g){
		g.drawImage(img1,0,28,this);
		g.drawImage(img2,775,370,this);
	}
	private void playAudio() {
    		try{
			String s=ch.getSelectedItem();
			s=s+".wav";
      			File sf =new File(s);
      			ais= AudioSystem.
                  		getAudioInputStream(sf);
      			af = ais.getFormat();
      			

      		DataLine.Info dli =new DataLine.Info(SourceDataLine.class,af);
      		sdl =(SourceDataLine)AudioSystem.getLine( dli);
      			new PlayThread().start();
    		}
		catch (Exception e) {
  		 }
	  }
	public void actionPerformed(ActionEvent ae){
		
		String s=ae.getActionCommand();
		
		// code for registeration
		if(s.equals("  SIGN UP FREE !!  ")){
			new Registeration();
			}
		// code for sign in 
		if(s.equals("SIGN IN")){
			Connection con = null;
		 	try{    
          			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          			con=DriverManager.getConnection("jdbc:odbc:dbase1");
				System.out.println("");
          			System.out.println("CONNECTED TO LOGIN DATABASE");
       			}
       			catch(Exception e){
          			System.out.println("Connection not made");
       			}
				
			try{String s1,s2;
			int count=0;
			s1uname=tl.getText();
			s2=tp.getText();
					stmt1=con.createStatement();
					rs1=stmt1.executeQuery("Select rloginid,rpassword from registeration");
					while (rs1.next()){
						String uname=rs1.getString("rloginid");
						String pass=rs1.getString("rpassword");
						if(s1uname.equals(uname) && s2.equals(pass)){
						enter=1;
						System.out.println("YOU ARE REGISTERED MEMBER");
						JOptionPane.showMessageDialog(null,"NOW ENTER THE MUSIC STORE");
						count++;
							}
						}
						if(count!=1)
						JOptionPane.showMessageDialog(null,"INVALID USERNAME AND PASSWORD");
					}
				catch(Exception e){
                  				System.out.println("never connect registeration");
              				}
			}
		if(s.equals("I> PLAY")){
			bs.setEnabled(true);
          			bp.setEnabled(false);
         			playAudio();
		}
		if(s.equals("II STOP")){
			  stopPlayback = true;
		}
		if((s.equals("CATEGORY") || s.equals("ENTER >>")) && enter==0){
			JOptionPane.showMessageDialog(null,"YOU ARE NOT A REGISTERED MEMBER");
			
		}
		if((s.equals("CATEGORY") || s.equals("ENTER >>")) && enter==1){
			
			remove(br);
			remove(be);
			remove(ll);
			remove(lp);
			remove(tl);
			remove(tp);
			remove(b2);
			remove(b3);
			remove(b4);
			remove(b5);
			remove(bc);
			add(b1);
			add(b6);
			add(b2);
			add(b3);
			add(b4);
			add(b5);
			add(bso);
		remove(p);
		remove(p2);
		remove(p3);
		remove(p4);
		remove(p5);
		               
		Label lh1=new Label("  hi,");
		lh1.setBackground(Color.BLACK );
		lh1.setForeground(Color.red);
		lh1.setBounds(750,80,30,20);
		add(lh1);
		Label lh2=new Label(tl.getText());
		lh2.setBackground(Color.BLACK );
		lh2.setForeground(Color.green);
		lh2.setBounds(780,80,200,20);
		add(lh2);
					
		imgi6=new ImageIcon(getClass().getResource("home.jpg"));
		jl6=new JLabel("",imgi6,JLabel.RIGHT);
		jl6.setBounds(0,0,480,270);	
		p1.add(jl6);
		p1.setBounds(260,235,480,270);
		add(p1);
		p1.setVisible(true);		
		}
		if(s.equals("WESTERN")){
		remove(p);
		remove(p1);
		remove(p3);
		remove(p4);
		remove(p5);
		l2= new Label( "WESTERN" );
		l2.setForeground(Color.red);
		l2.setBounds(200,10,200,40);
		
		p2.setVisible(true);
		p2.setBounds(260,235,480,270);
		p2.setBackground(Color.MAGENTA );
			
		imgi1=new ImageIcon(getClass().getResource("westernmusic.png"));
		jl1=new JLabel("",imgi1,JLabel.RIGHT);
		jl1.setBounds(280,60,180,180);	
		p2.add(jl1);
		imgi4=new ImageIcon(getClass().getResource("newanima.gif"));
		jl5=new JLabel("",imgi4,JLabel.RIGHT);
		jl5.setBounds(230,165,25,15);	
		p2.add(jl5);
		
		cbw1.setBounds(20,50,250,40);
		cbw2.setBounds(20,100,250,40);
		cbw3.setBounds(20,150,210,40);
		cbw4.setBounds(20,200,250,40);
		
		p2.add(cbw1);
		p2.add(cbw2);
		p2.add(cbw3);
		p2.add(cbw4);
		p2.add( l2 ); 
		add(p2);
		}
		if(s.equals("CLASSIC")){
		remove(p);
		remove(p1);
		remove(p2);
		remove(p4);
		remove(p5);
		l3= new Label( "CLASSIC" );
		l3.setForeground(Color.red);
		l3.setBounds(200,10,200,40);
		
		p3.setVisible(true);
		p3.setBounds(260,235,480,270);
		p3.setBackground(Color.CYAN);
		
		imgi2=new ImageIcon(getClass().getResource("classicmusic.png"));
		jl2=new JLabel("",imgi2,JLabel.RIGHT);
		jl2.setBounds(280,60,180,180);	
		p3.add(jl2);
		imgi4=new ImageIcon(getClass().getResource("newanima.gif"));
		jl5=new JLabel("",imgi4,JLabel.RIGHT);
		jl5.setBounds(235,210,25,15);	
		p3.add(jl5);

		cbc1.setBounds(20,50,250,40);
		cbc2.setBounds(20,100,250,40);
		cbc3.setBounds(20,150,250,40);
		cbc4.setBounds(20,200,210,40);
		p3.add(cbc1);
		p3.add(cbc2);
		p3.add(cbc3);
		p3.add(cbc4);
		p3.add( l3 ); 
		add(p3);
		} 
		if(s.equals(" JAZZ  ")){
		remove(p);
		remove(p1);
		remove(p2);
		remove(p3);
		remove(p5);
		l4= new Label( "JAZZ" );
		l4.setForeground(Color.red);
		l4.setBounds(200,10,200,40);
		
		p4.setVisible(true);
		p4.setBounds(260,235,480,270);
		p4.setBackground(Color.GREEN);
		imgi3=new ImageIcon(getClass().getResource("jazzmusic.png"));
		jl3=new JLabel("",imgi3,JLabel.RIGHT);
		jl3.setBounds(280,60,180,180);	
		p4.add(jl3);
		imgi4=new ImageIcon(getClass().getResource("newanima.gif"));
		jl5=new JLabel("",imgi4,JLabel.RIGHT);
		jl5.setBounds(225,210,25,15);	
		p4.add(jl5);
		
		cbj1.setBounds(20,50,250,40);
		cbj2.setBounds(20,100,250,40);
		cbj3.setBounds(20,150,250,40);
		cbj4.setBounds(20,200,205,40);
		p4.add(cbj1);
		p4.add(cbj2);
		p4.add(cbj3);
		p4.add(cbj4);
		p4.add( l4 ); 
		add(p4);
		} 

		if(s.equals(" POP ")){
		remove(p);
		remove(p1);
		remove(p2);
		remove(p3);
		remove(p4);
		l5= new Label( "POP" );
		l5.setForeground(Color.red);
		l5.setBounds(200,10,200,40);
		
		p5.setVisible(true);
		p5.setBounds(260,235,480,270);
		p5.setBackground(Color.YELLOW);
		imgi4=new ImageIcon(getClass().getResource("popmusic.png"));
		jl4=new JLabel("",imgi4,JLabel.RIGHT);
		jl4.setBounds(280,60,180,180);	
		p5.add(jl4);
		imgi4=new ImageIcon(getClass().getResource("newanima.gif"));
		jl5=new JLabel("",imgi4,JLabel.RIGHT);
		jl5.setBounds(225,60,25,15);	
		p5.add(jl5);

		cbp1.setBounds(20,50,205,40);
		cbp2.setBounds(20,100,250,40);
		cbp3.setBounds(20,150,250,40);
		cbp4.setBounds(20,200,250,40);
		p5.add(cbp1);
		p5.add(cbp2);
		p5.add(cbp3);
		p5.add(cbp4);
		p5.add( l5 );  
		add(p5);
		}
		if(s.equals("CLOSE")){
			JOptionPane.showMessageDialog(null,"THANX FOR VISIT");
			System.out.println("THANX FOR VISIT");
			System.exit(0);
		}
		if(s.equals("SIGN OUT")){
			JOptionPane.showMessageDialog(null,"YOU ARE SUCCESSFULLY LOGGED OUT");
			System.out.println("THANX FOR VISIT");
			System.exit(0);
		}
		if(s.equals("ADD TO CART")){
		count=0;
		temp=0;
			if(cbw1.getState()==true){
				sw1=cbw1.getLabel();
				count++;
			}
			if(cbw2.getState()==true){
				sw2=cbw2.getLabel();	
				count++;
			}
			if(cbw3.getState()==true){
				sw3=cbw3.getLabel();	
				count++;
			}
			if(cbw4.getState()==true){
				sw4=cbw4.getLabel();	
				count++;			
			}
			if(cbc1.getState()==true){
				sc1=cbc1.getLabel();	
				count++;
			}
			if(cbc2.getState()==true){
				sc2=cbc2.getLabel();	
				count++;
			}
			if(cbc3.getState()==true){
				sc3=cbc3.getLabel();	
				count++;
			}
			if(cbc4.getState()==true){
				sc4=cbc4.getLabel();	
				count++;
			}
			if(cbj1.getState()==true){
				sj1=cbj1.getLabel();	
				count++;
			}
			if(cbj2.getState()==true){
				sj2=cbj2.getLabel();	
				count++;
			}
			if(cbj3.getState()==true){
				sj3=cbj3.getLabel();	
				count++;
			}
			if(cbj4.getState()==true){
				sj4=cbj4.getLabel();	
				count++;
			}
			if(cbp1.getState()==true){
				sp1=cbp1.getLabel();	
				count++;
			}
			if(cbp2.getState()==true){	
				sp2=cbp2.getLabel();
				count++;
			}
			if(cbp3.getState()==true){
				sp3=cbp3.getLabel();	
				count++;
			}
			if(cbp4.getState()==true){
				sp4=cbp4.getLabel();	
				count++;
			}
		
			if(count>=1 && count<=5){
				String std="You have select "+count+" Albums CDs.";
				JOptionPane.showMessageDialog(null,std);
				
				new ShoppingCart(this);
				} 
			if(count>5)
				JOptionPane.showMessageDialog(null,"Sorry ! Select Maximum 5 Album CDs.");
			if(count==0)
				JOptionPane.showMessageDialog(null,"Please ! Select Minimum 1 Album CDs.");
		}	
		
	}
	class PlayThread extends Thread{
  		byte tempBuffer[] = new byte[10000];
		public void run(){
    			try{
      				sdl.open(af);
      				sdl.start();

				int cnt;
 
      			while((cnt = ais.read(
           			tempBuffer,0,tempBuffer.length)) != -1
                       		&& stopPlayback == false){
        				if(cnt > 0){
          			sdl.write(tempBuffer, 0, cnt);
        					}
      				}
      			sdl.drain();
      			sdl.close();
      			bs.setEnabled(false);
      			bp.setEnabled(true);
      			stopPlayback = false;
    			}
		catch (Exception e) {
			}
  		}
	}
	public static void main(String[] args){
		new OnlineMusic();
		try{
			Thread.sleep(100000000);
		}
		catch(InterruptedException e){
		}
	}
}

//Shopping Cart Interface

class ShoppingCart extends Frame implements ItemListener,ActionListener{
	
	TextField stf1,stf2,stf3,stf4,stf5;
	TextField ptf1,ptf2,ptf3,ptf4,ptf5;
	TextField itf1,itf2,itf3,itf4,itf5;
	TextField atf1,atf2,atf3,atf4,atf5;
	TextField ttf;
	Image  img1,img2;
   	Label l1,l2,l3,l4,l5,l6,l7;
	Choice ch1,ch2,ch3,ch4,ch5;
	Button b1,bc;
	int cnt1,price1,price2,price3,price4,price5;
	OnlineMusic om;
	int amt;
	String uname2;	
	ShoppingCart(OnlineMusic om){
		super("SHOPPING CART");
		setSize(650,350);
		setVisible(true);
		setLayout(null);
		
		setFont(new Font("dialog",Font.BOLD,14));
	
		this.om=om;
		uname2=om.s1uname;
		MediaTracker mt1=new MediaTracker(this);
		img1=Toolkit.getDefaultToolkit().getImage("scbk21.jpg");
		mt1.addImage(img1,0);
		
		MediaTracker mt2=new MediaTracker(this);
		img2=Toolkit.getDefaultToolkit().getImage("note.gif");
		mt2.addImage(img1,1);
		l1=new Label("SHOPPING CART");
		l2=new Label("CD TITLE");
		l3=new Label("NO. OF CDs");
		l4=new Label("PRICE/CD");
		l5=new Label("AMOUNT");
		l6=new Label("S.NO.");
		l1.setBackground(Color.BLACK);
		l1.setForeground(Color.blue);
		l2.setBackground(Color.BLACK);
		l2.setForeground(Color.red);
		l3.setBackground(Color.BLACK);
		l3.setForeground(Color.red);
		l4.setBackground(Color.BLACK);
		l4.setForeground(Color.red);
		l5.setBackground(Color.BLACK);
		l5.setForeground(Color.red);
		l6.setBackground(Color.BLACK);
		l6.setForeground(Color.red);

		l1.setBounds(250,40,200,20);
		l1.setFont(new Font("dialog",Font.BOLD,20));
		l2.setBounds(120,80,100,20);
		l2.setFont(new Font("dialog",Font.BOLD,16));
		l3.setBounds(300,80,100,20);
		l3.setFont(new Font("dialog",Font.BOLD,16));
		l4.setBounds(450,80,80,20);
		l4.setFont(new Font("dialog",Font.BOLD,16));
		l5.setBounds(550,80,80,20);
		l5.setFont(new Font("dialog",Font.BOLD,16));
		l6.setBounds(10,80,40,20);
		l6.setFont(new Font("dialog",Font.BOLD,16));	
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
			
		stf1=new TextField(2);
		stf1.setBounds(10,110,30,20);
		add(stf1);
		stf2=new TextField(2);
		stf2.setBounds(10,140,30,20);
		add(stf2);
		stf3=new TextField(2);
		stf3.setBounds(10,170,30,20);
		add(stf3);
		stf4=new TextField(2);
		stf4.setBounds(10,200,30,20);
		add(stf4);
		stf5=new TextField(2);
		stf5.setBounds(10,230,30,20);
		add(stf5);

		int sno=om.count;
		if(sno==1){
			stf1.setText("1");
			}
		if(sno==2){
			stf1.setText("1");
			stf2.setText("2");
			}
		if(sno==3){
			stf1.setText("1");
				stf2.setText("2");
			stf3.setText("3");
			}
		if(sno==4){
			stf1.setText("1");
			stf2.setText("2");
			stf3.setText("3");
			stf4.setText("4");
			}
		if(sno==5){
			stf1.setText("1");
			stf2.setText("2");
			stf3.setText("3");
			stf4.setText("4");
			stf5.setText("5");
			}			
				
		stf1.setEditable(false);
		stf2.setEditable(false);
		stf3.setEditable(false);
		stf4.setEditable(false);
		stf5.setEditable(false);
		
		itf1=new TextField(15);
		itf1.setBounds(60,110,220,20);
		add(itf1);
		itf2=new TextField(15);
		itf2.setBounds(60,140,220,20);
		add(itf2);
		itf3=new TextField(15);
		itf3.setBounds(60,170,220,20);
		add(itf3);
		itf4=new TextField(15);
		itf4.setBounds(60,200,220,20);
		add(itf4);
		itf5=new TextField(15);
		itf5.setBounds(60,230,220,20);
		add(itf5);
		
		int cnt1;
		for(int i=1;i<=sno;i++){
			if(i==1){
				 cnt1=0;
				price1=0;
				if(om.sw1!=null && cnt1==0){
				itf1.setText(om.sw1);
				price1=200;
				om.sw1=null;
				cnt1++;}
				if(om.sw2!=null && cnt1==0){
				itf1.setText(om.sw2);
				price1=350;
				om.sw2=null;
				cnt1++;}
				if(om.sw3!=null && cnt1==0){
				itf1.setText(om.sw3);
				price1=450;
				om.sw3=null;
				cnt1++;}
				if(om.sw4!=null && cnt1==0){
				itf1.setText(om.sw4);
				price1=250;
				om.sw4=null;
				cnt1++;}
				if(om.sc1!=null && cnt1==0){
				itf1.setText(om.sc1);
				price1=650;
				om.sc1=null;
				cnt1++;}
				if(om.sc2!=null && cnt1==0){
				itf1.setText(om.sc2);
				price1=400;
				om.sc2=null;
				cnt1++;}
				if(om.sc3!=null && cnt1==0){
				itf1.setText(om.sc3);
				price1=550;
				om.sc3=null;
				cnt1++;}
				if(om.sc4!=null && cnt1==0){
				itf1.setText(om.sc4);
				price1=450;
				om.sc4=null;
				cnt1++;}
				if(om.sj1!=null && cnt1==0){
				itf1.setText(om.sj1);
				price1=150;
				om.sj1=null;
				cnt1++;}
				if(om.sj2!=null && cnt1==0){
				itf1.setText(om.sj2);
				price1=200;
				om.sj2=null;
				cnt1++;}
				if(om.sj3!=null && cnt1==0){
				itf1.setText(om.sj3);
				price1=250;
				om.sj3=null;
				cnt1++;}
				if(om.sj4!=null && cnt1==0){
				itf1.setText(om.sj4);
				price1=300;
				om.sj4=null;
				cnt1++;}
				if(om.sp1!=null && cnt1==0){
				itf1.setText(om.sp1);
				price1=550;
				om.sp1=null;
				cnt1++;}
				if(om.sp2!=null && cnt1==0){
				itf1.setText(om.sp2);
				price1=350;
				om.sp2=null;
				cnt1++;}
				if(om.sp3!=null && cnt1==0){
				itf1.setText(om.sp3);
				price1=400;
				om.sp3=null;
				cnt1++;}
				if(om.sp4!=null && cnt1==0){
				itf1.setText(om.sp4);
				price1=250;
				om.sp4=null;
				cnt1++;}
				}
			if(i==2){
				price2=0;
				 cnt1=0;
				
				if(om.sw1!=null && cnt1==0){
				itf2.setText(om.sw1);
				price2=200;
				om.sw1=null;
				cnt1++;}
				if(om.sw2!=null && cnt1==0){
				itf2.setText(om.sw2);
				price2=350;
				om.sw2=null;
				cnt1++;}
				if(om.sw3!=null && cnt1==0){
				itf2.setText(om.sw3);
				price2=450;
				om.sw3=null;
				cnt1++;}
				if(om.sw4!=null && cnt1==0){
				itf2.setText(om.sw4);
				price2=250;
				om.sw4=null;
				cnt1++;}
				if(om.sc1!=null && cnt1==0){
				itf2.setText(om.sc1);
				price2=650;
				om.sc1=null;
				cnt1++;}
				if(om.sc2!=null && cnt1==0){
				itf2.setText(om.sc2);
				price2=400;
				om.sc2=null;
				cnt1++;}
				if(om.sc3!=null && cnt1==0){
				itf2.setText(om.sc3);
				price2=550;
				om.sc3=null;
				cnt1++;}
				if(om.sc4!=null && cnt1==0){
				itf2.setText(om.sc4);
				price2=450;
				om.sc4=null;
				cnt1++;}
				if(om.sj1!=null && cnt1==0){
				itf2.setText(om.sj1);
				price2=150;
				om.sj1=null;
				cnt1++;}
				if(om.sj2!=null && cnt1==0){
				itf2.setText(om.sj2);
				price2=200;
				om.sj2=null;
				cnt1++;}
				if(om.sj3!=null && cnt1==0){
				itf2.setText(om.sj3);
				price2=250;
				om.sj3=null;
				cnt1++;}
				if(om.sj4!=null && cnt1==0){
				itf2.setText(om.sj4);
				price2=300;
				om.sj4=null;
				cnt1++;}
				if(om.sp1!=null && cnt1==0){
				itf2.setText(om.sp1);
				price2=550;
				om.sp1=null;
				cnt1++;}
				if(om.sp2!=null && cnt1==0){
				itf2.setText(om.sp2);
				price2=350;
				om.sp2=null;
				cnt1++;}
				if(om.sp3!=null && cnt1==0){
				itf2.setText(om.sp3);
				price2=400;
				om.sp3=null;
				cnt1++;}
				if(om.sp4!=null && cnt1==0){
				itf2.setText(om.sp4);
				price2=250;
				om.sp4=null;
				cnt1++;}
				}
			if(i==3){
				price3=0;
				cnt1=0;
				
				if(om.sw1!=null && cnt1==0){
				itf3.setText(om.sw1);
				price3=200;
				om.sw1=null;
				cnt1++;}
				if(om.sw2!=null && cnt1==0){
				itf3.setText(om.sw2);
				price3=350;
				om.sw2=null;
				cnt1++;}
				if(om.sw3!=null && cnt1==0){
				itf3.setText(om.sw3);
				price3=450;
				om.sw3=null;
				cnt1++;}
				if(om.sw4!=null && cnt1==0){
				itf3.setText(om.sw4);
				price3=250;
				om.sw4=null;
				cnt1++;}
				if(om.sc1!=null && cnt1==0){
				itf3.setText(om.sc1);
				price3=650;
				om.sc1=null;
				cnt1++;}
				if(om.sc2!=null && cnt1==0){
				itf3.setText(om.sc2);
				price3=400;
				om.sc2=null;
				cnt1++;}
				if(om.sc3!=null && cnt1==0){
				itf3.setText(om.sc3);
				price3=550;
				om.sc3=null;
				cnt1++;}
				if(om.sc4!=null && cnt1==0){
				itf3.setText(om.sc4);
				price3=450;
				om.sc4=null;
				cnt1++;}
				if(om.sj1!=null && cnt1==0){
				itf3.setText(om.sj1);
				price3=150;
				om.sj1=null;
				cnt1++;}
				if(om.sj2!=null && cnt1==0){
				itf3.setText(om.sj2);
				price3=200;
				om.sj2=null;
				cnt1++;}
				if(om.sj3!=null && cnt1==0){
				itf3.setText(om.sj3);
				price3=250;
				om.sj3=null;
				cnt1++;}
				if(om.sj4!=null && cnt1==0){
				itf3.setText(om.sj4);
				price3=300;
				om.sj4=null;
				cnt1++;}
				if(om.sp1!=null && cnt1==0){
				itf3.setText(om.sp1);
				price3=550;
				om.sp1=null;
				cnt1++;}
				if(om.sp2!=null && cnt1==0){
				itf3.setText(om.sp2);
				price3=350;
				om.sp2=null;
				cnt1++;}
				if(om.sp3!=null && cnt1==0){
				itf3.setText(om.sp3);
				price3=400;
				om.sp3=null;
				cnt1++;}
				if(om.sp4!=null && cnt1==0){
				itf3.setText(om.sp4);
				price3=250;
				om.sp4=null;
				cnt1++;}
				}
			if(i==4){
				price4=0;
				 cnt1=0;
				
				if(om.sw1!=null && cnt1==0){
				itf4.setText(om.sw1);
				price4=200;
				om.sw1=null;
				cnt1++;}
				if(om.sw2!=null && cnt1==0){
				itf4.setText(om.sw2);
				price4=350;
				om.sw2=null;
				cnt1++;}
				if(om.sw3!=null && cnt1==0){
				itf4.setText(om.sw3);
				price4=450;
				om.sw3=null;
				cnt1++;}
				if(om.sw4!=null && cnt1==0){
				itf4.setText(om.sw4);
				price4=250;
				om.sw4=null;
				cnt1++;}
				if(om.sc1!=null && cnt1==0){
				itf4.setText(om.sc1);
				price4=650;
				om.sc1=null;
				cnt1++;}
				if(om.sc2!=null && cnt1==0){
				itf4.setText(om.sc2);
				price4=400;
				om.sc2=null;
				cnt1++;}
				if(om.sc3!=null && cnt1==0){
				itf4.setText(om.sc3);
				price4=550;
				om.sc3=null;
				cnt1++;}
				if(om.sc4!=null && cnt1==0){
				itf4.setText(om.sc4);
				price4=450;
				om.sc4=null;
				cnt1++;}
				if(om.sj1!=null && cnt1==0){
				itf4.setText(om.sj1);
				price4=150;
				om.sj1=null;
				cnt1++;}
				if(om.sj2!=null && cnt1==0){
				itf4.setText(om.sj2);
				price4=200;
				om.sj2=null;
				cnt1++;}
				if(om.sj3!=null && cnt1==0){
				itf4.setText(om.sj3);
				price4=250;
				om.sj3=null;
				cnt1++;}
				if(om.sj4!=null && cnt1==0){
				itf4.setText(om.sj4);
				price4=300;
				om.sj4=null;
				cnt1++;}
				if(om.sp1!=null && cnt1==0){
				itf4.setText(om.sp1);
				price4=550;
				om.sp1=null;
				cnt1++;}
				if(om.sp2!=null && cnt1==0){
				itf4.setText(om.sp2);
				price4=350;
				om.sp2=null;
				cnt1++;}
				if(om.sp3!=null && cnt1==0){
				itf4.setText(om.sp3);
				price4=400;
				om.sp3=null;
				cnt1++;}
				if(om.sp4!=null && cnt1==0){
				itf4.setText(om.sp4);
				price4=250;
				om.sp4=null;
				cnt1++;}
				}
			if(i==5){
				price5=0;
				  cnt1=0;
				
				if(om.sw1!=null && cnt1==0){
				itf5.setText(om.sw1);
				price5=200;
				om.sw1=null;
				cnt1++;}
				if(om.sw2!=null && cnt1==0){
				itf5.setText(om.sw2);
				price5=350;
				om.sw2=null;
				cnt1++;}
				if(om.sw3!=null && cnt1==0){
				itf5.setText(om.sw3);
				price5=450;
				om.sw3=null;
				cnt1++;}
				if(om.sw4!=null && cnt1==0){
				itf5.setText(om.sw4);
				price5=250;
				om.sw4=null;
				cnt1++;}
				if(om.sc1!=null && cnt1==0){
				itf5.setText(om.sc1);
				price5=650;
				om.sc1=null;
				cnt1++;}
				if(om.sc2!=null && cnt1==0){
				itf5.setText(om.sc2);
				price5=400;
				om.sc2=null;
				cnt1++;}
				if(om.sc3!=null && cnt1==0){
				itf5.setText(om.sc3);
				price5=550;
				om.sc3=null;
				cnt1++;}
				if(om.sc4!=null && cnt1==0){
				itf5.setText(om.sc4);
				price5=450;
				om.sc4=null;
				cnt1++;}
				if(om.sj1!=null && cnt1==0){
				itf5.setText(om.sj1);
				price5=150;
				om.sj1=null;
				cnt1++;}
				if(om.sj2!=null && cnt1==0){
				itf5.setText(om.sj2);
				price5=200;
				om.sj2=null;
				cnt1++;}
				if(om.sj3!=null && cnt1==0){
				itf5.setText(om.sj3);
				price5=250;
				om.sj3=null;
				cnt1++;}
				if(om.sj4!=null && cnt1==0){
				itf5.setText(om.sj4);
				price5=300;
				om.sj4=null;
				cnt1++;}
				if(om.sp1!=null && cnt1==0){
				itf5.setText(om.sp1);
				price5=550;
				om.sp1=null;
				cnt1++;}
				if(om.sp2!=null && cnt1==0){
				itf5.setText(om.sp2);
				price5=350;
				om.sp2=null;
				cnt1++;}
				if(om.sp3!=null && cnt1==0){
				itf5.setText(om.sp3);
				price5=400;
				om.sp3=null;
				cnt1++;}
				if(om.sp4!=null && cnt1==0){
				itf5.setText(om.sp4);
				price5=250;
				om.sp4=null;
				cnt1++;}
				}
		}
		itf1.setEditable(false);
		itf2.setEditable(false);
		itf3.setEditable(false);
		itf4.setEditable(false);
		itf5.setEditable(false);

		ch1=new Choice();
		ch1.add("0");
		ch1.add("1");
		ch1.add("2");			
		ch1.add("3");
		ch1.add("4");
		ch1.add("5");
		ch1.setBounds(320,110,40,20);
		add(ch1);
		ch1.addItemListener(this);

		ch2=new Choice();
		ch2.add("0");
		ch2.add("1");
		ch2.add("2");			
		ch2.add("3");
		ch2.add("4");
		ch2.add("5");
		ch2.setBounds(320,140,40,20);
		add(ch2);
		ch2.addItemListener(this);

		ch3=new Choice();
		ch3.add("0");
		ch3.add("1");
		ch3.add("2");			
		ch3.add("3");
		ch3.add("4");
		ch3.add("5");
		ch3.setBounds(320,170,40,20);
		add(ch3);
		ch3.addItemListener(this);

		ch4=new Choice();
		ch4.add("0");
		ch4.add("1");
		ch4.add("2");			
		ch4.add("3");
		ch4.add("4");
		ch4.add("5");
		ch4.setBounds(320,200,40,20);
		add(ch4);
		ch4.addItemListener(this);

		ch5=new Choice();
		ch5.add("0");
		ch5.add("1");
		ch5.add("2");			
		ch5.add("3");
		ch5.add("4");
		ch5.add("5");
		ch5.setBounds(320,230,40,20);
		add(ch5);
		ch5.addItemListener(this);
			
		ptf1=new TextField(15);ptf1.setText(""+price1);
		ptf1.setBounds(460,110,50,20);
		add(ptf1);
		ptf2=new TextField(15);ptf2.setText(""+price2);
		ptf2.setBounds(460,140,50,20);
		add(ptf2);
		ptf3=new TextField(15);ptf3.setText(""+price3);
		ptf3.setBounds(460,170,50,20);
		add(ptf3);
		ptf4=new TextField(15);ptf4.setText(""+price4);
		ptf4.setBounds(460,200,50,20);
		add(ptf4);
		ptf5=new TextField(15);ptf5.setText(""+price5);
		ptf5.setBounds(460,230,50,20);
		add(ptf5);
		
		ptf1.setEditable(false);
		ptf2.setEditable(false);
		ptf3.setEditable(false);
		ptf4.setEditable(false);
		ptf5.setEditable(false);
	
		atf1=new TextField(15);atf1.setText("0");
		atf1.setBounds(560,110,50,20);
		add(atf1);
		atf2=new TextField(15);atf2.setText("0");
		atf2.setBounds(560,140,50,20);
		add(atf2);
		atf3=new TextField(15);atf3.setText("0");
		atf3.setBounds(560,170,50,20);
		add(atf3);
		atf4=new TextField(15);atf4.setText("0");
		atf4.setBounds(560,200,50,20);
		add(atf4);
		atf5=new TextField(15);atf5.setText("0");
		atf5.setBounds(560,230,50,20);
		add(atf5);
			
		atf1.setEditable(false);
		atf2.setEditable(false);
		atf3.setEditable(false);
		atf4.setEditable(false);
		atf5.setEditable(false);
		l7=new Label("TOTAL AMOUNT : Rs. ");
		l7.setBounds(405,260,150,20);
		l7.setBackground(Color.BLACK);
		l7.setForeground(Color.yellow);
		l7.setFont(new Font("dialog",Font.BOLD,14));
		add(l7);
		ttf=new TextField(15);ttf.setText("0");
		ttf.setBounds(560,260,50,20);
		add(ttf);
		ttf.setEditable(false);
		
		b1=new Button("  BUY NOW  ");
		b1.setBounds(260,290,200,30);
		b1.setFont(new Font("dialog",Font.BOLD,14));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.red);
		 
		add(b1);	
		b1.addActionListener(this);
		bc=new Button("SIGN OUT");
		bc.setBackground(Color.BLACK);
		bc.setForeground(Color.red);
		bc.setFont(new Font("dialog",Font.BOLD,14));
		bc.setBounds(560,30,75,25);
		add(bc);
		bc.addActionListener(this);	
	}    
	public void update(Graphics g){
	    	paint(g);	
	}
	public void paint(Graphics g){
		g.drawImage(img1,5,0,this);
		g.drawImage(img2,345,100,this);
	}                                                                                 
	public void actionPerformed(ActionEvent ae){
		 	amt=Integer.parseInt(ttf.getText());
			String s=ae.getActionCommand();
			if(s.equals("  BUY NOW  ")){
			if(amt!=0)
				new PlaceOrder(this);
			if(amt==0)
				JOptionPane.showMessageDialog(null,"You have to select no. of CDs.");	
			}
			if(s.equals("SIGN OUT")){
				JOptionPane.showMessageDialog(null,"YOU ARE SUCCESSFULLY LOGGED OUT");
			System.out.println("THANX FOR VISIT");
				System.exit(0);
			}
		}
	            	public void itemStateChanged(ItemEvent e) {
			
			String s1=ch1.getSelectedItem();
			int a1=Integer.parseInt(s1);
			int b1=Integer.parseInt(ptf1.getText());
			int c1=a1*b1;
			s1=""+c1;
			atf1.setText(s1);
			
			String s2=ch2.getSelectedItem();
			int a2=Integer.parseInt(s2);
			int b2=Integer.parseInt(ptf2.getText());
			int c2=a2*b2;
			s2=""+c2;
			atf2.setText(s2);
			
			String s3=ch3.getSelectedItem();
			int a3=Integer.parseInt(s3);
			int b3=Integer.parseInt(ptf3.getText());
			int c3=a3*b3;
			s3=""+c3;
			atf3.setText(s3);
			
			String s4=ch4.getSelectedItem();
			int a4=Integer.parseInt(s4);
			int b4=Integer.parseInt(ptf4.getText());
			int c4=a4*b4;
			s4=""+c4;
			atf4.setText(s4);
			
			String s5=ch5.getSelectedItem();
			int a5=Integer.parseInt(s5);
			int b5=Integer.parseInt(ptf5.getText());
			int c5=a5*b5;
			s5=""+c5;
			atf5.setText(s5);
			
			int t=c1+c2+c3+c4+c5;
			String st=""+t;
			ttf.setText(st);					
		}	
}

//Place Order interface

class PlaceOrder extends Frame implements ItemListener,ActionListener{
	
	Image img1,img2;
	
    	Label l1,l2;
	
	Checkbox cb1,cb2,cb3;
	CheckboxGroup cbg;
	Button b1,bc;
	String uname3;
	ShoppingCart sc;
	int bill;
	PlaceOrder(ShoppingCart sc){
		super("PLACE YOUR ORDER");
		setSize(580,305);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Times New Roman",Font.BOLD,16));
		
		this.sc=sc;
		uname3=sc.uname2;
		bill=sc.amt;
			
		MediaTracker mt1=new MediaTracker(this);
		img1=Toolkit.getDefaultToolkit().getImage("pobk6.png");
		mt1.addImage(img1,0);
		MediaTracker mt2=new MediaTracker(this);
		img2=Toolkit.getDefaultToolkit().getImage("m1.gif");
		mt2.addImage(img2,0);
		
		l1=new Label("PLACE YOUR ORDER");
		l2=new Label("SELECT PAYMENT MODE");
		l1.setFont(new Font("Times New Roman",Font.BOLD,18));
		
		l1.setBackground(Color.BLACK);
		l1.setForeground(Color.blue);
		l2.setBackground(Color.BLACK);
		l2.setForeground(Color.red);
		l1.setBounds(180,40,200,20);
		l2.setBounds(140,100,200,20);
		
		add(l1);
		add(l2);
				
		cbg=new CheckboxGroup();
		cb1=new Checkbox("CREDIT CARD",false,cbg);
		cb2=new Checkbox("DEMAND DRAFT",false,cbg);
		cb3=new Checkbox("CASH ON DELIVERY",false,cbg);
		
		cb1.setBounds(140,140,200,20);
		cb2.setBounds(140,170,200,20);
		cb3.setBounds(140,200,200,20);
		cb1.setBackground(Color.BLACK);
		cb1.setForeground(Color.yellow);
		cb2.setBackground(Color.BLACK);
		cb2.setForeground(Color.yellow);
		cb3.setBackground(Color.BLACK);
		cb3.setForeground(Color.yellow);
		
		add(cb1);
		add(cb2);
		add(cb3);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		b1=new Button("OK");
		b1.setBounds(220,250,130,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.red);
		add(b1);
		b1.addActionListener(this);

		bc=new Button("SIGN OUT");
		bc.setBackground(Color.BLACK);
		bc.setForeground(Color.red);
		bc.setFont(new Font("dialog",Font.BOLD,14));
		bc.setBounds(490,30,75,25);
		add(bc);
		bc.addActionListener(this);
		}
		public void actionPerformed(ActionEvent ae){
			String s=ae.getActionCommand();
			if(s.equals("SIGN OUT")){
				JOptionPane.showMessageDialog(null,"YOU ARE SUCCESSFULLY LOGGED OUT");
			System.out.println("THANX FOR VISIT");
				System.exit(0);
			}
			if (cb1.getState())
				new CreditCard(this);
			if(cb2.getState())
				new DemandDraft(this);
			if(cb3.getState())
				new CashDelivery(this);
			
		}
		public void itemStateChanged(ItemEvent ie){
			//if (cb1.getState())
			//JOptionPane.showMessageDialog(null,"You have to enter ur Name,City,CardAccount");
			//if(cb2.getState())
			//JOptionPane.showMessageDialog(null,"You have to enter ur Name,City,BankAccount");
			//if(cb3.getState())
			//JOptionPane.showMessageDialog(null,"You have to enter ur Name,City,PhoneNumber");
		}
		public void update(Graphics g){
	    	paint(g);	
	}
	public void paint(Graphics g){
		g.drawImage(img1,0,29,this);
		g.drawImage(img2,370,220,this);
	}	
	
}

// Credit Card User Details Interface

class CreditCard extends Frame implements ActionListener,ItemListener{
	Image img1,img2;
	Label l1,l2,l3,l4,l5,l6,l7;
	TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	Button b1,bc;
	
	Connection con;
   	PreparedStatement stat;
  	Statement stmt,stmt1;
  	ResultSet rs,rs1;
   	int count,x;
	int d=0;
	long a;
	String uname41,s3,st2,st1;
	PlaceOrder po;
	int billamt;
	int temp=0;
	int cont=0;
	Choice ch1,ch2;
	String sbr5,sbr1,sbr2,sbr7;
	CreditCard(PlaceOrder po){
		super("USER DETAILS");
		setSize(640,400);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Times New Roman",Font.BOLD,16));

		this.po=po;
		uname41=po.uname3;
		billamt=po.bill;
		
		MediaTracker mt1=new MediaTracker(this);
		img1=Toolkit.getDefaultToolkit().getImage("bkdisp.jpg");
		mt1.addImage(img1,0);
	
		MediaTracker mt2=new MediaTracker(this);
		img2=Toolkit.getDefaultToolkit().getImage("musicmov.gif");
		mt2.addImage(img2,1);
		
		l1=new Label("FILL THE REQUIRED INFORMATION");
		l2=new Label("NAME  ");
		l3=new Label("CITY  ");
		l4=new Label("CARD ACCOUNT");
		l5=new Label("EMAIL ID*");
		l6=new Label("CUSTOMER ID");
		l7=new Label("BILL AMOUNT");
		
		l2.setBackground(Color.BLACK);
		l2.setForeground(Color.blue);
		l3.setBackground(Color.BLACK);
		l3.setForeground(Color.blue);
		l4.setBackground(Color.BLACK);
		l4.setForeground(Color.blue);		
		l5.setBackground(Color.BLACK);
		l5.setForeground(Color.blue);

		l1.setBackground(Color.BLACK);
		l1.setForeground(Color.blue);
		l6.setBackground(Color.BLACK);
		l6.setForeground(Color.red);
		l7.setBackground(Color.BLACK);
		l7.setForeground(Color.red);
		
		l1.setBounds(170,40,280,20);
		l6.setBounds(320,75,150,20);
		l7.setBounds(320,105,150,20);
		l2.setBounds(320,190,150,20);
		l3.setBounds(320,220,150,20);
		l4.setBounds(320,250,150,20);
		l5.setBounds(320,280,150,20);
		
		add(l1);
		add(l6);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l7);

		tf1=new TextField(10);
		tf3=new TextField(10);
		tf5=new TextField(10);
		tf5.setEditable(false);
		tf6=new TextField(10);
		tf7=new TextField(10);		
		tf7.setEditable(false);	
		
		tf7.setText("Rs. "+billamt);

		tf5.setBounds(480,75,150,20);
		tf7.setBounds(480,105,150,20);
		tf1.setBounds(480,190,150,20);
		tf3.setBounds(480,250,150,20);
				
		add(tf5);
		add(tf1);
		add(tf3);
		add(tf7);
		
		ch1=new Choice();
		ch1.add("None");
		ch1.add("Delhi");
		ch1.add("Mumbai");			
		ch1.add("Patna");
		ch1.add("Hyderabad");
		ch1.add("Goa");
		ch1.add("Chandigarh");
		ch1.add("Jaipur");
		ch1.add("Chennai");
		ch1.add("Lucknow");
		ch1.add("Banglore");
		ch1.setBounds(480,220,150,20);
		add(ch1);
		ch1.addItemListener(this);
		
		 ch2=new Choice();
		ch2.add("None");
		ch2.add("GoogleMail");
		ch2.add("YahooMail");			
		ch2.add("IndiatimesMail");
		ch2.add("RediffMail");
		ch2.add("HotMail");
		ch2.add("AOLMail");
		ch2.add("FastMail");
		ch2.setBounds(480,280,150,20);
		add(ch2);
		ch2.addItemListener(this);
		
		Connection con = null;
		 try{    
          			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          			con=DriverManager.getConnection("jdbc:odbc:dbase1");
			System.out.println("");
          			System.out.println("CONNECTED TO DATABASE");
       		}
       		catch(Exception e){
          			System.out.println("Connection not made");
       		}
		try{
                   		stmt=con.createStatement();
                   		rs=stmt.executeQuery("Select count(*) from musiconweb");
                   		rs.next();
             	   		count=rs.getInt(1);
                   		count++; 
                    		tf5.setText(" "+count);
              		}
              		catch(Exception e){
                  		System.out.println("Unable to count");
              		}
		
		b1=new Button("OK");
		b1.setBounds(320,325,130,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.red);
		add(b1);
		b1.addActionListener(this);

		bc=new Button("SIGN OUT");
		bc.setBackground(Color.BLACK);
		bc.setForeground(Color.red);
		bc.setFont(new Font("dialog",Font.BOLD,14));
		bc.setBounds(550,30,75,25);
		add(bc);
		bc.addActionListener(this);
	}
	public void update(Graphics g){
	    	paint(g);	
	}
	public void paint(Graphics g){
		g.drawImage(img1,0,28,this);
		g.drawImage(img2,530,140,this);
		
	}
	public void itemStateChanged(ItemEvent e) {
			
		 	st1=ch1.getSelectedItem();
			st2=ch2.getSelectedItem();
		}
	public void actionPerformed(ActionEvent ae){
		
		String s=ae.getActionCommand();
			if(s.equals("SIGN OUT")){
				JOptionPane.showMessageDialog(null,"YOU ARE SUCCESSFULLY LOGGED OUT");
			System.out.println("THANX FOR VISIT");
				System.exit(0);
			}
			if(s.equals("OK")){
			temp=0;

			String s1=tf1.getText();
			if(s1.equals(""))
				JOptionPane.showMessageDialog(null,"Name Field cannot be Empty Space !!");
			else
				temp++;
					
			 s3=tf3.getText();
			if(s3.equals(""))
				JOptionPane.showMessageDialog(null,"Card Account Field cannot be Empty Space !!");
			else 
				temp++;
			
			if(s3.length()!=10 &&  s3!=null)
				JOptionPane.showMessageDialog(null,"Card Account Field cannot be more or less than 10 !!");
			else
				temp++;
		
			try{
				if(s3.length()==10){
		 		a=Long.parseLong(s3);
		 		String b=""+a;
				tf6.setText(b);
				}
			}
			catch(Exception e){
				temp--;
				JOptionPane.showMessageDialog(null,"ERROR : Card Account Field must be  numeric only !!");	
			}
		
		
			if(temp==3){
				temp=0;		
				Connection con = null;
					
		 		try{    
          					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          					con=DriverManager.getConnection("jdbc:odbc:dbase1");
          				}
       				catch(Exception e){
          					System.out.println("Connection not made");
       				}
		
		 		try{
                   				stmt=con.createStatement();
                   				rs=stmt.executeQuery("Select count(*) from musiconweb");
                   				rs.next();
             	   				count=rs.getInt(1);
                   				count++; 
                    				tf5.setText(" "+count);
              				}
              				catch(Exception e){
                  				System.out.println("Unable to count");
              				}
	 			try{
					stmt1=con.createStatement();
					rs1=stmt1.executeQuery("Select rloginid,rcardaccount from registeration");
					while (rs1.next() ){
						
						String s11=rs1.getString("rloginid");
						String s21=rs1.getString("rcardaccount");
						if(uname41.equals(s11) && s3.equals(s21)){
						JOptionPane.showMessageDialog(null,"VALID CARD ACCOUNT");
						cont++;
						}
					}
				}
				catch(Exception e){
                  				System.out.println("never connect to registeration");
              				}
				
              				if(cont==1) {
					cont=0;	
					try{
                				stat = con.prepareStatement("INSERT INTO musiconweb VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
						
						sbr5=tf5.getText();
						stat.setInt(1,Integer.parseInt(tf5.getText().trim())); 
						
						sbr1=tf1.getText();
         	 				stat.setString(2,tf1.getText());
						
						sbr2=st1;
						stat.setString(3,st1); 
						
						stat.setString(4,""+a);
						
						stat.setInt(5,d);

						stat.setInt(6,d);
	
						stat.setInt(7,billamt);

						Calendar currentDate = Calendar.getInstance();
  						SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
  						String dt = formatter.format(currentDate.getTime());
						stat.setString(8,dt);
						stat.setString(9,st2);
						stat.executeUpdate();
						
						System.out.println("INSERTED TO DATABSE");     
              				}
              				catch(Exception e){
                  				System.out.println("Insertion not done");
              					}
					new BillReport1(this);
				}
				else
					JOptionPane.showMessageDialog(null,"INVALID CARD ACCOUNT");
			}
		}
	}
}

// Demand Draft User Details Interface

class DemandDraft extends Frame implements ActionListener,ItemListener{
	Image img1,img2;
	Label l1,l2,l3,l4,l5,l6,l7;
	TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	Button b1,bc;
	
	Connection con;
   	PreparedStatement stat;
  	Statement stmt,stmt1;
  	ResultSet rs,rs1;
   	int count,x;
	int d=0;
	long a;
	String uname42,s3,st1,st2;
	PlaceOrder po;
	int billamt;
	int temp=0;
	int cont=0;
	Choice ch1,ch2;
	String sbr5,sbr1,sbr2,sbr7;
	DemandDraft(PlaceOrder po){
		super("USER DETAILS");
		setSize(640,400);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Times New Roman",Font.BOLD,16));

		this.po=po;
		uname42=po.uname3;
		billamt=po.bill;
		
		MediaTracker mt1=new MediaTracker(this);
		img1=Toolkit.getDefaultToolkit().getImage("bkdisp.jpg");
		mt1.addImage(img1,0);
	
		MediaTracker mt2=new MediaTracker(this);
		img2=Toolkit.getDefaultToolkit().getImage("musicmov.gif");
		mt2.addImage(img2,1);
		
		l1=new Label("FILL THE REQUIRED INFORMATION");
		l2=new Label("NAME  ");
		l3=new Label("CITY  ");
		l4=new Label("BANK ACCOUNT");
		l5=new Label("EMAIL ID (optional)");
		l6=new Label("CUSTOMER ID");
		l7=new Label("BILL AMOUNT");
		
		l2.setBackground(Color.BLACK);
		l2.setForeground(Color.blue);
		l3.setBackground(Color.BLACK);
		l3.setForeground(Color.blue);
		l4.setBackground(Color.BLACK);
		l4.setForeground(Color.blue);		
		l5.setBackground(Color.BLACK);
		l5.setForeground(Color.blue);

		l1.setBackground(Color.BLACK);
		l1.setForeground(Color.blue);
		l6.setBackground(Color.BLACK);
		l6.setForeground(Color.red);
		l7.setBackground(Color.BLACK);
		l7.setForeground(Color.red);
		
		l1.setBounds(170,40,280,20);
		l6.setBounds(320,75,150,20);
		l7.setBounds(320,105,150,20);
		l2.setBounds(320,190,150,20);
		l3.setBounds(320,220,150,20);
		l4.setBounds(320,250,150,20);
		l5.setBounds(320,280,150,20);
		
		add(l1);
		add(l6);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l7);

		tf1=new TextField(10);
		tf3=new TextField(10);
		tf5=new TextField(10);
		tf5.setEditable(false);
		tf6=new TextField(10);
		tf7=new TextField(10);		
		tf7.setEditable(false);	
		
		tf7.setText("Rs. "+billamt);

		tf5.setBounds(480,75,150,20);
		tf7.setBounds(480,105,150,20);
		tf1.setBounds(480,190,150,20);
		tf3.setBounds(480,250,150,20);
				
		add(tf5);
		add(tf1);
		add(tf3);
		add(tf7);
	
		ch1=new Choice();
		ch1.add("None");
		ch1.add("Delhi");
		ch1.add("Mumbai");			
		ch1.add("Patna");
		ch1.add("Hyderabad");
		ch1.add("Goa");
		ch1.add("Chandigarh");
		ch1.add("Jaipur");
		ch1.add("Chennai");
		ch1.add("Lucknow");
		ch1.add("Banglore");
		ch1.setBounds(480,220,150,20);
		add(ch1);
		ch1.addItemListener(this);
		
		 ch2=new Choice();
		ch2.add("None");
		ch2.add("GoogleMail");
		ch2.add("YahooMail");			
		ch2.add("IndiatimesMail");
		ch2.add("RediffMail");
		ch2.add("HotMail");
		ch2.add("AOLMail");
		ch2.add("FastMail");
		ch2.setBounds(480,280,150,20);
		add(ch2);
		ch2.addItemListener(this);
		
		Connection con = null;
		
		 try{    
          			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          			con=DriverManager.getConnection("jdbc:odbc:dbase1");
			System.out.println("");
          			System.out.println("CONNECTED TO DATABASE");
       		}
       		catch(Exception e){
          			System.out.println("Connection not made");
       		}
		
		 try{
                   		stmt=con.createStatement();
                   		rs=stmt.executeQuery("Select count(*) from musiconweb");
                   		rs.next();
             	   		count=rs.getInt(1);
                   		count++; 
                    		tf5.setText(" "+count);
              		}
              		catch(Exception e){
                  		System.out.println("Unable to count");
              		}
		
		
		b1=new Button("OK");
		b1.setBounds(320,325,130,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.red);
		add(b1);
		b1.addActionListener(this);

		bc=new Button("SIGN OUT");
		bc.setBackground(Color.BLACK);
		bc.setForeground(Color.red);
		bc.setFont(new Font("dialog",Font.BOLD,16));
		bc.setBounds(550,30,75,25);
		add(bc);
		bc.addActionListener(this);
	}
	public void update(Graphics g){
	    	paint(g);	
	}
	public void paint(Graphics g){
		g.drawImage(img1,0,28,this);
		g.drawImage(img2,530,140,this);
		
	}
	public void itemStateChanged(ItemEvent e) {
			
		 	st1=ch1.getSelectedItem();
			st2=ch2.getSelectedItem();
		}
	public void actionPerformed(ActionEvent ae){
		
		String s=ae.getActionCommand();
			if(s.equals("SIGN OUT")){
			JOptionPane.showMessageDialog(null,"YOU ARE SUCCESSFULLY LOGGED OUT");
			System.out.println("THANX FOR VISIT");
				System.exit(0);
			}
		if(s.equals("OK")){
			temp=0;
			
			String s1=tf1.getText	();
			if(s1.equals(""))
				JOptionPane.showMessageDialog(null,"Name Field cannot be Empty Space !!");
			else
				temp++;
		
			s3=tf3.getText();
			if(s3.equals(""))
				JOptionPane.showMessageDialog(null,"Bank Account Field cannot be Empty Space !!");
			else
				temp++;
		
			if(s3.length()!=10)
				JOptionPane.showMessageDialog(null,"Bank Account Field cannot be more or less than 10 !!");
			else
				temp++;
			try{
				if(s3.length()==10){
		 		a=Long.parseLong(s3);
		 		String b=""+a;
				tf6.setText(b);
				}
			}
			catch(Exception e){
				temp--;
				JOptionPane.showMessageDialog(null,"ERROR : Bank Account Field must be  numeric only !!");	
			}
	
			if(temp==3){
				temp=0;
				Connection con = null;
				 try{    
          					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          					con=DriverManager.getConnection("jdbc:odbc:dbase1");
          				}
       				catch(Exception e){
          					System.out.println("Connection not made");
       				}
		
		 		try{
                   				stmt=con.createStatement();
                   				rs=stmt.executeQuery("Select count(*) from musiconweb");
                   				rs.next();
             	   				count=rs.getInt(1);
                   				count++; 
                    				tf5.setText(" "+count);
              				}
              				catch(Exception e){
                  				System.out.println("Unable to count");
              				}
				try{
					stmt1=con.createStatement();
					rs1=stmt1.executeQuery("Select rloginid,rbankaccount from registeration");
					while (rs1.next() ){
						String s11=rs1.getString("rloginid");
						String s21=rs1.getString("rbankaccount");
						if(uname42.equals(s11) && s3.equals(s21)){
						JOptionPane.showMessageDialog(null,"VALID BANK ACCOUNT");
						cont++;
						}
					}
				}
				catch(Exception e1){
                  				System.out.println("never connect to registeration");
              				}
				
              				if(cont==1) {
					try{
                				 	cont=0;
						stat = con.prepareStatement("INSERT INTO musiconweb VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
				 
						sbr5=tf5.getText();
						stat.setInt(1,Integer.parseInt(tf5.getText().trim()));
				 
					 	sbr1=tf1.getText();
         	 					stat.setString(2,tf1.getText());
				 
						sbr2=st1;
						stat.setString(3,st1);
				 
						stat.setInt(4,d);
				 
						stat.setString(5,""+a);
							 
						stat.setInt(6,d);
				 
						sbr7=""+billamt;
						stat.setInt(7,billamt);
				 
						Calendar currentDate = Calendar.getInstance();
  						SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
  						String dt = formatter.format(currentDate.getTime());
						stat.setString(8,dt);
				 
						stat.setString(9,st2);
				 
						stat.executeUpdate();
				 		
			              			System.out.println("INSERTED TO DATABASE");     
              					}
              					catch(Exception e){
                  					System.out.println("Insertion not done");
              					}
					new BillReport2(this);
				}
				else
					JOptionPane.showMessageDialog(null,"INVALID BANK ACCOUNT");
			}
		}
	}
}

// Cash Delivery User Details Interface

class CashDelivery extends Frame implements ActionListener,ItemListener{
	Image img1,img2;
	Label l1,l2,l3,l4,l5,l6,l7;
	TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	Button b1,bc;
	
	Connection con;
   	PreparedStatement stat;
  	Statement stmt,stmt1;
  	ResultSet rs,rs1;
   	int count,x;
	int d=0;
	long a;
	String uname43,s3,st1,st2;
	PlaceOrder po;
	int billamt;
	String sbr5,sbr1,sbr2,sbr7;
	int temp=0;
	int cont=0;
	Choice ch1,ch2;
	CashDelivery(PlaceOrder po){
		super("USER DETAILS");
		setSize(640,400);
		setVisible(true);
		setLayout(null);
		setFont(new Font("Times New Roman",Font.BOLD,16));

		this.po=po;
		uname43=po.uname3;
		billamt=po.bill;
		
		MediaTracker mt1=new MediaTracker(this);
		img1=Toolkit.getDefaultToolkit().getImage("bkdisp.jpg");
		mt1.addImage(img1,0);
	
		MediaTracker mt2=new MediaTracker(this);
		img2=Toolkit.getDefaultToolkit().getImage("musicmov.gif");
		mt2.addImage(img2,1);
						
		l1=new Label("FILL THE REQUIRED INFORMATION");
		l2=new Label("NAME  ");
		l3=new Label("CITY  ");
		l4=new Label("PHONE NUMBER");
		l5=new Label("EMAIL ID (optional)");
		l6=new Label("CUSTOMER ID");
		l7=new Label("BILL AMOUNT");
		
		l2.setBackground(Color.BLACK);
		l2.setForeground(Color.blue);
		l3.setBackground(Color.BLACK);
		l3.setForeground(Color.blue);
		l4.setBackground(Color.BLACK);
		l4.setForeground(Color.blue);		
		l5.setBackground(Color.BLACK);
		l5.setForeground(Color.blue);

		l1.setBackground(Color.BLACK);
		l1.setForeground(Color.blue);
		l6.setBackground(Color.BLACK);
		l6.setForeground(Color.red);
		l7.setBackground(Color.BLACK);
		l7.setForeground(Color.red);
		
		l1.setBounds(170,40,280,20);
		l6.setBounds(320,75,150,20);
		l7.setBounds(320,105,150,20);
		l2.setBounds(320,190,150,20);
		l3.setBounds(320,220,150,20);
		l4.setBounds(320,250,150,20);
		l5.setBounds(320,280,150,20);
		
		add(l1);
		add(l6);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l7);

		tf1=new TextField(10);
		tf3=new TextField(10);
		tf5=new TextField(10);
		tf5.setEditable(false);
		tf6=new TextField(10);
		tf7=new TextField(10);		
		tf7.setEditable(false);	
		
		tf7.setText("Rs. "+billamt);

		tf5.setBounds(480,75,150,20);
		tf7.setBounds(480,105,150,20);
		tf1.setBounds(480,190,150,20);
		tf3.setBounds(480,250,150,20);
			
		add(tf5);
		add(tf1);
		add(tf3);
		add(tf7);
	
		ch1=new Choice();
		ch1.add("None");
		ch1.add("Delhi");
		ch1.add("Mumbai");			
		ch1.add("Patna");
		ch1.add("Hyderabad");
		ch1.add("Goa");
		ch1.add("Chandigarh");
		ch1.add("Jaipur");
		ch1.add("Chennai");
		ch1.add("Lucknow");
		ch1.add("Banglore");
		ch1.setBounds(480,220,150,20);
		add(ch1);
		ch1.addItemListener(this);
		
		 ch2=new Choice();
		ch2.add("None");
		ch2.add("GoogleMail");
		ch2.add("YahooMail");			
		ch2.add("IndiatimesMail");
		ch2.add("RediffMail");
		ch2.add("HotMail");
		ch2.add("AOLMail");
		ch2.add("FastMail");
		ch2.setBounds(480,280,150,20);
		add(ch2);
		ch2.addItemListener(this);
		
		Connection con = null;
		
		 try{    
          			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          			con=DriverManager.getConnection("jdbc:odbc:dbase1");
			System.out.println("");
          			System.out.println("CONNECTED TO DATABASE");
       		}
       		catch(Exception e){
          			System.out.println("Connection not made");
       		}
		
		 try{
                   		stmt=con.createStatement();
                   		rs=stmt.executeQuery("Select count(*) from musiconweb");
                   		rs.next();
             	   		count=rs.getInt(1);
                   		count++; 
                    		tf5.setText(" "+count);
              		}
              		catch(Exception e){
                  		System.out.println("Unable to count");
              		}
		
		
		b1=new Button("OK");
		b1.setBounds(320,325,130,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.red);
		add(b1);
		b1.addActionListener(this);

		bc=new Button("SIGN OUT");
		bc.setBackground(Color.BLACK);
		bc.setForeground(Color.red);
		bc.setFont(new Font("dialog",Font.BOLD,14));
		bc.setBounds(550,30,75,25);
		add(bc);
		bc.addActionListener(this);
	}
	public void update(Graphics g){
	    	paint(g);	
	}
	public void paint(Graphics g){
		g.drawImage(img1,0,28,this);
		g.drawImage(img2,530,140,this);
		
	}
	public void itemStateChanged(ItemEvent e) {
			
		 	st1=ch1.getSelectedItem();
			st2=ch2.getSelectedItem();
		}
	public void actionPerformed(ActionEvent ae){
		
		String s=ae.getActionCommand();
			if(s.equals("SIGN OUT")){
			JOptionPane.showMessageDialog(null,"YOU ARE SUCCESSFULLY LOGGED OUT");
			System.out.println("THANX FOR VISIT");
				System.exit(0);
			}
		if(s.equals("OK")){
			temp=0;
			String s1=tf1.getText();
			if(s1.equals(""))
				JOptionPane.showMessageDialog(null,"Name Field cannot be Empty Space !!");
			else
				temp++;
			
			s3=tf3.getText();
			if(s3.equals(""))
				JOptionPane.showMessageDialog(null,"Phone Number Field cannot be Empty Space !!");
			else
				temp++;
			
			if(s3.length()!=10)
				JOptionPane.showMessageDialog(null,"Phone Number Field cannot be more or less than 10 !!");
			else
				temp++;
			
			try{
				if(s3.length()==10){
		 		a=Long.parseLong(s3);
		 		String b=""+a;
				tf6.setText(b);
				}
			}
			catch(Exception e){
				temp--;
				JOptionPane.showMessageDialog(null,"ERROR : Phone Number Field must be  numeric only !!");	
			}
			if(temp==3){
				temp=0;
				Connection con = null;
		
				 try{    
          					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          					con=DriverManager.getConnection("jdbc:odbc:dbase1");
          				}
       				catch(Exception e){
          					System.out.println("Connection not made");
       				}
		
		 		try{
                   				stmt=con.createStatement();
                   				rs=stmt.executeQuery("Select count(*) from musiconweb");
                   				rs.next();
             	   				count=rs.getInt(1);
                   				count++; 
                    				tf5.setText(" "+count);
			
              				}
				catch(Exception e){
                	  			System.out.println("Unable to count");	
				}
				try{
					stmt1=con.createStatement();
					rs1=stmt1.executeQuery("Select rloginid,rphonenumber from registeration");
					while (rs1.next() ){
						String s11=rs1.getString("rloginid");
						String s21=rs1.getString("rphonenumber");
						if(uname43.equals(s11) && s3.equals(s21)){
						JOptionPane.showMessageDialog(null,"VALID PHONE NUMBER");
						cont++;
						}
					}
				}
				catch(Exception e1){
                  				System.out.println("never connect to registeration");
              				}
				
              				if(cont==1) {
					try{
						cont=0;
                					stat = con.prepareStatement("INSERT INTO musiconweb VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
							
				 		sbr5=tf5.getText();
						stat.setInt(1,Integer.parseInt(tf5.getText().trim()));
						
						sbr1=tf1.getText();
						stat.setString(2,tf1.getText());
						
				 		sbr2=st1;
	 					stat.setString(3,st1);
						
						stat.setInt(4,d);
				
						stat.setInt(5,d);
				
						stat.setString(6,""+a);
				
						sbr7=""+billamt;
				
						stat.setInt(7,billamt);
				
						Calendar currentDate = Calendar.getInstance();
  						SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
  						String dt = formatter.format(currentDate.getTime());
				
						stat.setString(8,dt);
						
						stat.setString(9,st2);
				
						stat.executeUpdate();
						
						System.out.println("INSERTED TO DATABASE");  
					}
                 				catch(Exception e){
						System.out.println("Insertion not done");
                  				}
			              	   	new BillReport3(this);
				}
				else
					JOptionPane.showMessageDialog(null,"INVALID PHONE NUMBER");
			}
		}
	}
}

//Invoice Interface for CreditCard customers

class BillReport1 extends Frame implements ActionListener{
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	TextField tf3,tf4,tf5,tf6,tf7,tf8;
	Button b1;
	Image  img1,img2;
	CreditCard cc;
	BillReport1(CreditCard cc){
		super("INVOICE");
		setVisible(true);
		setSize(580,290);
		setLayout(null);
		setFont(new Font("Times New Roman",Font.BOLD,16));
		
		this.cc=cc;

		MediaTracker mt1=new MediaTracker(this);
		img1=Toolkit.getDefaultToolkit().getImage("invoice2.jpg");
		mt1.addImage(img1,0);
	
		MediaTracker mt2=new MediaTracker(this);
		img2=Toolkit.getDefaultToolkit().getImage("musicnote.gif");
		mt2.addImage(img2,1);

		l1=new Label("www.OnlineMusicStore.com");
		l1.setFont(new Font("Times New Roman",Font.BOLD,18));
		l2= new Label( "INVOICE" );
		l3= new Label( "Customer Id : " );
		l4= new Label( "Invoice No : " );
		l5=new Label("Name : ");
		l6=new Label("City : ");
		l7=new Label("Amount : ");
		l8=new Label("Date : ");
		l9=new Label("*Product will be delivered within 10 days.");
		l9.setFont(new Font("Times New Roman",Font.PLAIN,14));
		l10=new Label("Thanx for Visting");
		
		tf3 =new TextField(20);
		tf4=new TextField(20);
		tf5 =new TextField(20);
		tf6 =new TextField(20);
		tf7 =new TextField(20);		
		tf8=new TextField(20);
	
		l1.setBounds(170,40,300,20);
		l2.setBounds(250,70,100,20);
		l3.setBounds(40,100,110,20);
		l4.setBounds(350,100,95,20);
		l5.setBounds(40,130,60,20);
		l6.setBounds(40,160,50,20);
		l7.setBounds(350,130,80,20);
		l8.setBounds(350,160,50,20);
		l9.setBounds(40,260,300,20);
		l10.setBounds(40,220,150,20);
		
		tf3.setBounds(150,100,90,20);
		tf4.setBounds(450,100,90,20);
		tf5.setBounds(100,130,140,20);
		tf6.setBounds(90,160,150,20);
		tf7.setBounds(430,130,110,20);
		tf8.setBounds(400,160,140,20);

		tf3.setEditable(false);
		tf4.setEditable(false);
		tf5.setEditable(false);
		tf6.setEditable(false);
		tf7.setEditable(false);
		tf8.setEditable(false);


		l1.setBackground(Color.BLACK);
		l1.setForeground(Color.blue);
		l2.setBackground(Color.BLACK);
		l2.setForeground(Color.red);
		l3.setBackground(Color.BLACK);
		l3.setForeground(Color.yellow);
		l4.setBackground(Color.BLACK);
		l4.setForeground(Color.yellow);
		l5.setBackground(Color.BLACK);
		l5.setForeground(Color.yellow);
		l6.setBackground(Color.BLACK);
		l6.setForeground(Color.yellow);
		l7.setBackground(Color.BLACK);
		l7.setForeground(Color.yellow);
		l8.setBackground(Color.BLACK);
		l8.setForeground(Color.yellow);
		l9.setBackground(Color.BLACK);
		l9.setForeground(Color.yellow);		
		l10.setBackground(Color.BLACK);
		l10.setForeground(Color.green);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);		
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		
		tf3.setBackground(Color.BLACK);
		tf3.setForeground(Color.white);
		tf4.setBackground(Color.BLACK);
		tf4.setForeground(Color.white);
		tf5.setBackground(Color.BLACK);
		tf5.setForeground(Color.white);
		tf6.setBackground(Color.BLACK);
		tf6.setForeground(Color.white);
		tf7.setBackground(Color.BLACK);
		tf7.setForeground(Color.white);
		tf8.setBackground(Color.BLACK);
		tf8.setForeground(Color.white);
		
		
		String si3=cc.sbr5;
		int in=Integer.parseInt(si3.trim());
		in=in+19993;
		
		
		tf3.setText(si3);
		tf4.setText(""+in);
		tf5.setText(cc.sbr1);
		tf6.setText(cc.sbr2);
		tf7.setText(""+cc.billamt);
		Calendar currentDate = Calendar.getInstance();
  		SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
  		String dt = formatter.format(currentDate.getTime());
		tf8.setText(dt);
			
		add(tf3);
		add(tf4);
		add(tf5);
		add(tf6);		
		add(tf7);
		add(tf8);
			
		b1=new Button("ACCEPT & PRINT");
		b1.setBounds(190,220,180,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.red);
		
		add(b1);
		b1.addActionListener(this);
		}
		public void actionPerformed(ActionEvent ae){
			System.out.println("");
			System.out.println("THANX FOR VISIT");
			System.exit(0);
		}
		public void update(Graphics g){
	    	paint(g);	
	}
	public void paint(Graphics g){
		g.drawImage(img1,0,28,this);
		g.drawImage(img2,280,100,this);
	}
}

//Invoice Interface for DemandDraft customers

class BillReport2 extends Frame implements ActionListener{
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	TextField tf3,tf4,tf5,tf6,tf7,tf8;
	Button b1;
	Image  img1,img2;
	DemandDraft dd;
	BillReport2(DemandDraft dd){
		super("INVOICE");
		setVisible(true);
		setSize(580,290);
		setLayout(null);
		setFont(new Font("Times New Roman",Font.BOLD,16));
		
		this.dd=dd;

		MediaTracker mt1=new MediaTracker(this);
		img1=Toolkit.getDefaultToolkit().getImage("invoice2.jpg");
		mt1.addImage(img1,0);
	
		MediaTracker mt2=new MediaTracker(this);
		img2=Toolkit.getDefaultToolkit().getImage("musicnote.gif");
		mt2.addImage(img2,1);

		l1=new Label("www.OnlineMusicStore.com");
		l1.setFont(new Font("Times New Roman",Font.BOLD,18));
		l2= new Label( "INVOICE" );
		l3= new Label( "Customer Id : " );
		l4= new Label( "Invoice No : " );
		l5=new Label("Name : ");
		l6=new Label("City : ");
		l7=new Label("Amount : ");
		l8=new Label("Date : ");
		l9=new Label("*Product will be delivered within 10 days.");
		l9.setFont(new Font("Times New Roman",Font.PLAIN,14));
		l10=new Label("Thanx for Visting");
		
		tf3 =new TextField(20);
		tf4=new TextField(20);
		tf5 =new TextField(20);
		tf6 =new TextField(20);
		tf7 =new TextField(20);		
		tf8=new TextField(20);
	
		l1.setBounds(170,40,300,20);
		l2.setBounds(250,70,100,20);
		l3.setBounds(40,100,110,20);
		l4.setBounds(350,100,95,20);
		l5.setBounds(40,130,60,20);
		l6.setBounds(40,160,50,20);
		l7.setBounds(350,130,80,20);
		l8.setBounds(350,160,50,20);
		l9.setBounds(40,260,300,20);
		l10.setBounds(40,220,150,20);
		
		tf3.setBounds(150,100,90,20);
		tf4.setBounds(450,100,90,20);
		tf5.setBounds(100,130,140,20);
		tf6.setBounds(90,160,150,20);
		tf7.setBounds(430,130,110,20);
		tf8.setBounds(400,160,140,20);

		tf3.setEditable(false);
		tf4.setEditable(false);
		tf5.setEditable(false);
		tf6.setEditable(false);
		tf7.setEditable(false);
		tf8.setEditable(false);


		l1.setBackground(Color.BLACK);
		l1.setForeground(Color.blue);
		l2.setBackground(Color.BLACK);
		l2.setForeground(Color.red);
		l3.setBackground(Color.BLACK);
		l3.setForeground(Color.yellow);
		l4.setBackground(Color.BLACK);
		l4.setForeground(Color.yellow);
		l5.setBackground(Color.BLACK);
		l5.setForeground(Color.yellow);
		l6.setBackground(Color.BLACK);
		l6.setForeground(Color.yellow);
		l7.setBackground(Color.BLACK);
		l7.setForeground(Color.yellow);
		l8.setBackground(Color.BLACK);
		l8.setForeground(Color.yellow);
		l9.setBackground(Color.BLACK);
		l9.setForeground(Color.white);		
		l10.setBackground(Color.BLACK);
		l10.setForeground(Color.green);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);		
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		
		tf3.setBackground(Color.BLACK);
		tf3.setForeground(Color.white);
		tf4.setBackground(Color.BLACK);
		tf4.setForeground(Color.white);
		tf5.setBackground(Color.BLACK);
		tf5.setForeground(Color.white);
		tf6.setBackground(Color.BLACK);
		tf6.setForeground(Color.white);
		tf7.setBackground(Color.BLACK);
		tf7.setForeground(Color.white);
		tf8.setBackground(Color.BLACK);
		tf8.setForeground(Color.white);
		
		
		String si3=dd.sbr5;
		int in=Integer.parseInt(si3.trim());
		in=in+19993;
				
		tf3.setText(si3);
		tf4.setText(""+in);
		tf5.setText(dd.sbr1);
		tf6.setText(dd.sbr2);
		tf7.setText(""+dd.billamt);
		Calendar currentDate = Calendar.getInstance();
  		SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
  		String dt = formatter.format(currentDate.getTime());
		tf8.setText(dt);
			
		add(tf3);
		add(tf4);
		add(tf5);
		add(tf6);		
		add(tf7);
		add(tf8);
			
		b1=new Button("ACCEPT & PRINT");
		b1.setBounds(190,220,180,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.red);
		
		add(b1);
		b1.addActionListener(this);
		}
		public void actionPerformed(ActionEvent ae){
			System.out.println("");
			System.out.println("THANX FOR VISIT");
			System.exit(0);
		}
		public void update(Graphics g){
	    	paint(g);	
	}
	public void paint(Graphics g){
		g.drawImage(img1,0,28,this);
		g.drawImage(img2,280,100,this);
	}
}

//Invoice Interface for PhoneNumbers customers

class BillReport3 extends Frame implements ActionListener{
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	TextField tf3,tf4,tf5,tf6,tf7,tf8;
	Button b1;
	Image  img1,img2;
	CashDelivery cd;
	BillReport3(CashDelivery cd){
		super("INVOICE");
		setVisible(true);
		setSize(580,290);
		setLayout(null);
		setFont(new Font("Times New Roman",Font.BOLD,16));
		
		this.cd=cd;

		MediaTracker mt1=new MediaTracker(this);
		img1=Toolkit.getDefaultToolkit().getImage("invoice2.jpg");
		mt1.addImage(img1,0);
	
		MediaTracker mt2=new MediaTracker(this);
		img2=Toolkit.getDefaultToolkit().getImage("musicnote.gif");
		mt2.addImage(img2,1);

		l1=new Label("www.OnlineMusicStore.com");
		l1.setFont(new Font("Times New Roman",Font.BOLD,18));
		l2= new Label( "INVOICE" );
		l3= new Label( "Customer Id : " );
		l4= new Label( "Invoice No : " );
		l5=new Label("Name : ");
		l6=new Label("City : ");
		l7=new Label("Amount : ");
		l8=new Label("Date : ");
		l9=new Label("*Product will be delivered within 10 days.");
		l9.setFont(new Font("Times New Roman",Font.PLAIN,14));
		l10=new Label("Thanx for Visting");
		
		tf3 =new TextField(20);
		tf4=new TextField(20);
		tf5 =new TextField(20);
		tf6 =new TextField(20);
		tf7 =new TextField(20);		
		tf8=new TextField(20);
	
		l1.setBounds(170,40,300,20);
		l2.setBounds(250,70,100,20);
		l3.setBounds(40,100,110,20);
		l4.setBounds(350,100,95,20);
		l5.setBounds(40,130,60,20);
		l6.setBounds(40,160,50,20);
		l7.setBounds(350,130,80,20);
		l8.setBounds(350,160,50,20);
		l9.setBounds(40,260,300,20);
		l10.setBounds(40,220,150,20);
		
		tf3.setBounds(150,100,90,20);
		tf4.setBounds(450,100,90,20);
		tf5.setBounds(100,130,140,20);
		tf6.setBounds(90,160,150,20);
		tf7.setBounds(430,130,110,20);
		tf8.setBounds(400,160,140,20);

		tf3.setEditable(false);
		tf4.setEditable(false);
		tf5.setEditable(false);
		tf6.setEditable(false);
		tf7.setEditable(false);
		tf8.setEditable(false);


		l1.setBackground(Color.BLACK);
		l1.setForeground(Color.blue);
		l2.setBackground(Color.BLACK);
		l2.setForeground(Color.red);
		l3.setBackground(Color.BLACK);
		l3.setForeground(Color.yellow);
		l4.setBackground(Color.BLACK);
		l4.setForeground(Color.yellow);
		l5.setBackground(Color.BLACK);
		l5.setForeground(Color.yellow);
		l6.setBackground(Color.BLACK);
		l6.setForeground(Color.yellow);
		l7.setBackground(Color.BLACK);
		l7.setForeground(Color.yellow);
		l8.setBackground(Color.BLACK);
		l8.setForeground(Color.yellow);
		l9.setBackground(Color.BLACK);
		l9.setForeground(Color.white);		
		l10.setBackground(Color.BLACK);
		l10.setForeground(Color.green);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);		
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		
		tf3.setBackground(Color.BLACK);
		tf3.setForeground(Color.white);
		tf4.setBackground(Color.BLACK);
		tf4.setForeground(Color.white);
		tf5.setBackground(Color.BLACK);
		tf5.setForeground(Color.white);
		tf6.setBackground(Color.BLACK);
		tf6.setForeground(Color.white);
		tf7.setBackground(Color.BLACK);
		tf7.setForeground(Color.white);
		tf8.setBackground(Color.BLACK);
		tf8.setForeground(Color.white);
				
		String si3=cd.sbr5;
		int in=Integer.parseInt(si3.trim());
		in=in+19993;
				
		tf3.setText(si3);
		tf4.setText(""+in);
		tf5.setText(cd.sbr1);
		tf6.setText(cd.sbr2);
		tf7.setText(""+cd.billamt);
		Calendar currentDate = Calendar.getInstance();
  		SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
  		String dt = formatter.format(currentDate.getTime());
		tf8.setText(dt);
			
		add(tf3);
		add(tf4);
		add(tf5);
		add(tf6);		
		add(tf7);
		add(tf8);
			
		b1=new Button("ACCEPT & PRINT");
		b1.setBounds(190,220,180,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.red);
		
		add(b1);
		b1.addActionListener(this);
		}
		public void actionPerformed(ActionEvent ae){
			System.out.println("");
			System.out.println("THANX FOR VISIT");
			System.exit(0);
		}
		public void update(Graphics g){
	    	paint(g);	
	}
	public void paint(Graphics g){
		g.drawImage(img1,0,28,this);
		g.drawImage(img2,280,100,this);
	}
}

// Registeration interface

class Registeration extends Frame implements ActionListener,ItemListener{
	
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
	Button b2,bc;
	TextArea txa;	
	Image  img1;
	String st1,st2;
	Choice ch1,ch2;
	long a;
	Connection con;
   	PreparedStatement stat;
  	Statement stmt,stmt1;
  	ResultSet rs,rs1;
	 	int count,x;
	Registeration(){
		super("REGISTERATION");
	
		setVisible(true);
		setSize(400,700);
		setLayout(null);

		MediaTracker mt1=new MediaTracker(this);
		img1=Toolkit.getDefaultToolkit().getImage("register.png");
		mt1.addImage(img1,0);
		
		
		l1=new Label("USERNAME");
		l2=new Label("PASSWORD");
		l3=new Label("NAME  ");
		l4=new Label("CITY*  ");
		l5=new Label("EMAIL ID*");
		l6=new Label("CARD ACCOUNT");
		l7=new Label("BANK ACCOUNT");
		l8=new Label("PHONE NUMBER");
		l9=new Label("TERMS OF SERVICE");
		l10=new Label("By clicking on 'ACCEPT' below you are agreeing to the");
		l11=new Label("TERMS OF SERVICE above & the PROGRAM POLICY.");
		l12=new Label("WWW.ONLINE_MUSIC_STORE.COM");
		
		tf1=new TextField(15);
		tf2=new TextField(15);
		tf2.setEchoChar('*');
		tf3=new TextField(15);
		tf4=new TextField(15);
		tf5=new TextField(15);
		tf6=new TextField(15);
		tf7=new TextField(15);
		tf8=new TextField(15);
		tf9=new TextField(15);
		tf10=new TextField(15);

		txa=new TextArea("",300,108, TextArea.SCROLLBARS_VERTICAL_ONLY);
		txa.setBounds(60,460,300,108);
		txa.setBackground(Color.BLACK);
		txa.setForeground(Color.white);
		txa.setEditable(false);
		
		String s1="       WELCOME TO ONLINE MUSIC STORE  ";
		String s2="              RULES & REGULATIONS      ";
		String s3="                                   1-> login id and password must be of minimum of six(6) characters only.               ";
		String s4="                                        2-> card account ,bank account and phone number must be of 10 digit number. "; 
		String s5="                      3-> login id must be CHECK for uniqueness. ";
		txa.setText(s1+s2+s3+s4+s5);
		
		add(txa);
		
		ch1=new Choice();
		ch1.add("None");
		ch1.add("Delhi");
		ch1.add("Mumbai");			
		ch1.add("Patna");
		ch1.add("Hyderabad");
		ch1.add("Goa");
		ch1.add("Chandigarh");
		ch1.add("Jaipur");
		ch1.add("Chennai");
		ch1.add("Lucknow");
		ch1.add("Banglore");
		
		ch1.setBounds(210,272,150,20);
		add(ch1);
		ch1.addItemListener(this);
		
		ch2=new Choice();
		ch2.add("None");
		ch2.add("GoogleMail");
		ch2.add("YahooMail");			
		ch2.add("IndiatimesMail");
		ch2.add("RediffMail");
		ch2.add("HotMail");
		ch2.add("AOLMail");
		ch2.add("FastMail");
		ch2.setBounds(210,302,150,20);
		add(ch2);
		ch2.addItemListener(this);
		
		l1.setBounds(60,182,120,20);
		l2.setBounds(60,212,120,20);
		l3.setBounds(60,242,120,20);
		l4.setBounds(60,272,120,20);
		l5.setBounds(60,302,120,20);
		l6.setBounds(60,332,120,20);
		l7.setBounds(60,362,120,20);
		l8.setBounds(60,392,120,20);
		l9.setBounds(150,430,120,20);
		l10.setBounds(60,575,300,20);
		l11.setBounds(60,595,300,20);
		l12.setBounds(95,670,210,20);

		l1.setBackground(Color.BLACK);
		l1.setForeground(Color.red);
		l2.setBackground(Color.BLACK);
		l2.setForeground(Color.red);
		l3.setBackground(Color.BLACK);
		l3.setForeground(Color.red);
		l4.setBackground(Color.BLACK);
		l4.setForeground(Color.red);
		l5.setBackground(Color.BLACK);
		l5.setForeground(Color.red);
		l6.setBackground(Color.BLACK);
		l6.setForeground(Color.red);
		l7.setBackground(Color.BLACK);
		l7.setForeground(Color.red);
		l8.setBackground(Color.BLACK);
		l8.setForeground(Color.red);
		l9.setBackground(Color.BLACK);
		l9.setForeground(Color.green);
		l10.setBackground(Color.BLACK);
		l10.setForeground(Color.cyan);
		l11.setBackground(Color.BLACK);
		l11.setForeground(Color.cyan);	
		l12.setBackground(Color.BLACK);
		l12.setForeground(Color.red);
			
		tf1.setBounds(210,183,150,20);
		tf2.setBounds(210,212,150,20);
		tf3.setBounds(210,242,75,20);
		tf4.setBounds(210,272,150,20);
		tf5.setBounds(210,302,150,20);
		tf6.setBounds(210,332,150,20);
		tf7.setBounds(210,362,150,20);
		tf8.setBounds(210,392,150,20);
		tf9.setBounds(290,242,70,20);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(l11);
		add(l12);

		add(tf1);
		add(tf2);
		add(tf3);
		add(tf6);
		add(tf7);
		add(tf8);
		add(tf9);

		b2=new Button("ACCEPT & CREATE ACCOUNT");
		b2.setFont(new Font("dialog",Font.PLAIN,14));
		b2.setBounds(90,630,220,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.green);
		add(b2);
		b2.addActionListener(this);
	
		bc=new Button("X");
		bc.setBackground(Color.RED);
		bc.setForeground(Color.white);
		bc.setFont(new Font("dialog",Font.BOLD,14));
		bc.setBounds(370,30,25,25);
		add(bc);
		bc.addActionListener(this);
		Connection con = null;
		 try{    
          			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          			con=DriverManager.getConnection("jdbc:odbc:dbase1");
			System.out.println("");
          			System.out.println("CONNECTED TO REGISTERATION DATABASE");
       		}
       		catch(Exception e){
          			System.out.println("Connection not made");
       		}
		
		}
		public void paint(Graphics g){
			g.drawImage(img1,0,28,this);
		}
		public void itemStateChanged(ItemEvent e) {
			
		 	st1=ch1.getSelectedItem();
			st2=ch2.getSelectedItem();
		}
		public void actionPerformed(ActionEvent ae){
		
		String s=ae.getActionCommand();
			if(s.equals("X")){
				System.out.println("CLOSED FROM REGISTERATION DATABASE");
				System.exit(0);
				}
			
			if(s.equals("ACCEPT & CREATE ACCOUNT")){
				int temp=0;
			
				Connection con = null;
		
				 try{    
          					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          					con=DriverManager.getConnection("jdbc:odbc:dbase1");
          				}
       				catch(Exception e){
          				}
				String s1,s2,s3,s4,s5,s6,s7,s8;
				s1=tf1.getText();
				s2=tf2.getText();
				s3=tf3.getText();
				
				s6=tf6.getText();
				s7=tf7.getText();
				s8=tf8.getText();
				
				if(s1.length()>=6)
					temp++;
				else{
					temp--;
					JOptionPane.showMessageDialog(null,"LOGIN ID IS MINIMUM OF 6 CHARACTERS.");
					}
				if(s2.length()>=6)
					temp++;
				else{
					temp--;
					JOptionPane.showMessageDialog(null,"PASSWORD IS MINIMUM OF 6 CHARACTERS.");
					}
			
				if(s3.equals("")){temp--;
					JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR NAME.");
					}
				else
					temp++;
					
					
				
				try{
					if(s6.length()==10){
					a=Long.parseLong(s6);
			 		String b=""+a;
					tf10.setText(b);
					temp++;
					}
					else
						JOptionPane.showMessageDialog(null,"CARD ACCOUNT MUST BE OF 10 NUMERALS.");
				}
				catch(Exception e){				
					temp--;
					JOptionPane.showMessageDialog(null,"CARD ACCOUNT MUST BE NUMERICAL WITHOUT ANY BLANK SPACES AND SPECIAL CHARACTERS.");	
				}
				try{
					if(s7.length()==10){
					a=Long.parseLong(s7);
			 		String b=""+a;
					tf10.setText(b);
					temp++;
					}
					else
						JOptionPane.showMessageDialog(null,"BANK ACCOUNT MUST BE OF 10 NUMERALS.");
				}
				catch(Exception e){				
					temp--;
					JOptionPane.showMessageDialog(null,"BANK ACCOUNT MUST BE NUMERICAL WITHOUT ANY BLANK SPACES AND SPECIAL CHARACTERS.");	
				}
				try{
					if(s8.length()==10){
					a=Long.parseLong(s8);
			 		String b=""+a;
					tf10.setText(b);
					temp++;
					}
					else
						JOptionPane.showMessageDialog(null,"PHONE NUMBER MUST BE OF 10 NUMERALS.");
				}
				catch(Exception e){				
					temp--;
					JOptionPane.showMessageDialog(null,"PHONE NUMBER MUST BE NUMERICAL WITHOUT ANY BLANK SPACES AND SPECIAL CHARACTERS.");	
				}
					
				if(temp==6){
					
				try{    
										
				stat = con.prepareStatement("INSERT INTO registeration VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
				
				try{		
					
					stat.setString(1,tf1.getText());
					stat.setString(2,tf2.getText());
					stat.setString(3,tf3.getText());
					stat.setString(4,st1);
					stat.setString(5,st2);
					stat.setString(6,tf6.getText().trim());
					stat.setString(7,tf7.getText().trim());
					stat.setString(8,tf8.getText().trim());
					try{
						stat.executeUpdate();
						JOptionPane.showMessageDialog(null,"ACCOUNT IS SUCCESSFULLY CREATED.");
						JOptionPane.showMessageDialog(null,"AGAIN START FROM LOGIN PAGE.");
						System.out.println("CLOSED FROM REGISTERATION DATABASE");	
						System.exit(0);
						}
								
					catch(Exception e){
						JOptionPane.showMessageDialog(null,"PLEASE ENTERED UNIQUE ENTERIES AS WELL AS USERNAME.");
						}
					}
				catch(Exception e){
					JOptionPane.showMessageDialog(null,"LOGIN ID NOT AVIALABLE.IT IS ALREADY EXISTS.");
					}
				}
                 		catch(Exception e){
					JOptionPane.showMessageDialog(null,"ACCOUNT IS CANNOT BE CREATED.LOGIN ID ALREADY EXISTS.");
					}		
				}
			
			}
			
		}
		
}
		

// END OF PROGRAM (WWW.ONLINE_MUSIC_STORE.COM)