import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.*;
import java.lang.reflect.*;

public class WordsExUI extends JPanel
{
	private JButton mistypo,lang,io,util;
	private JTextField typingField;
	private JTextPane counts,AC;
	private JPanel mainPanel,center,left,leftBorder,buttonPanel1;
	private JLabel leftLabel,upper;
	private JLabel area;
	private String[] providingArr;
	private String[] langArr;
	private String[] ioArr;
	private String[] utilArr;
	private String[] mistypoArr;
	private boolean logAccuracy;//기록에 남길 accuracy true false
	int randomIndex;

	private int accuracyNo,countsNo,accuracyPer;//사용자에게 보여줄 accuracy
	//private 

	public WordsExUI(String[] wordsArr)
	{ 
		this.providingArr=wordsArr;
		this.setName("WordsExUI");
		this.setLayout(new BorderLayout());
		wordsArr=null;
		mainPanel=new JPanel(new BorderLayout());
		
		setBackground(Color.white);
		accuracyNo=0;
		countsNo=0;
//Panel
		buttonPanel1=new JPanel();
		buttonPanel1.setBorder(new EmptyBorder(10,10,10,10));
		leftBorder=new JPanel(new BorderLayout());
		left=new JPanel(new BorderLayout());
		left.setBackground(new Color(45,45,48));
		
//버튼이미지
		Image misImg=new ImageIcon("Icon/WordsExUI/MisTyped.png").getImage().getScaledInstance(150,40,Image.SCALE_DEFAULT);
		ImageIcon image=new ImageIcon(misImg);
		mistypo=new JButton(image);
		mistypo.setName("mistypo");
		mistypo.setContentAreaFilled(false);
		mistypo.setBorderPainted(false);

		Image langImg=new ImageIcon("Icon/WordsExUI/Lang.png").getImage().getScaledInstance(150,40,Image.SCALE_DEFAULT);
		image=new ImageIcon(langImg);
		lang=new JButton(image);
		lang.setName("java.lang");
		lang.setContentAreaFilled(false);
		lang.setBorderPainted(false);

		Image ioImg =new ImageIcon("Icon/WordsExUI/io.png").getImage().getScaledInstance(150,40,Image.SCALE_DEFAULT);
		image=new ImageIcon(ioImg);
		io=new JButton(image);
		io.setName("java.io");
		io.setContentAreaFilled(false);
		io.setBorderPainted(false);

		Image utilImg =new ImageIcon("Icon/WordsExUI/Util.png").getImage().getScaledInstance(150,40,Image.SCALE_DEFAULT);
		image=new ImageIcon(utilImg);
		util=new JButton(image);
		util.setName("java.util");
		util.setContentAreaFilled(false);
		util.setBorderPainted(false);

//center
		center=new JPanel(new GridBagLayout());
		center.setBackground(Color.white);

//TextField
		typingField=new JTextField(30);
		//typingField.setEnabled(true);
		typingField.setFont(new Font("plain",Font.PLAIN,24));
		//typingField.requestFocus(true);

//TextArea

		if(providingArr!=null)
		{
			randomIndex= getRandomInt();
			area=new JLabel(providingArr[randomIndex],SwingConstants.LEFT);
		}	
		area.setPreferredSize(new Dimension(700,200));
		area.setFont(new Font("bold",Font.BOLD,30));
		//area.setText("System.out.println");//test용 method호출해야하게찡
//		area.setEditable(false);

//JTextPane
		counts=new JTextPane();
		AC=new JTextPane();
		counts.setFont(new Font("bold",Font.ITALIC,36));
		int i=50;//test
		counts.setText("COUNTS\n"+countsNo);
		counts.setEditable(false);

		AC.setFont(new Font("bold",Font.ITALIC,36));
		AC.setText("AC\n"+accuracyNo);
		AC.setEditable(false);

//왼쪽 panel과 왼쪽label
	;
		Icon menu=new ImageIcon("Icon/WordsExUI/menuname.png");//.getImage().getScaledInstance(314,100,Image.SCALE_DEFAULT);
		
		upper=new JLabel(menu);
		upper.setPreferredSize(new Dimension(314,100));
		
		left.setPreferredSize(new Dimension(314,900));
		left.setLayout(new GridBagLayout());

		buttonPanel1.setBackground(new Color(45,45,48));
		
//Component에 add
		addComponent();
	}

	public void display()
	{
		setVisible(true);
		typingField.requestFocusInWindow();
	}

	public void addComponent()
	{

		setLocation(200,100);
		setPreferredSize(new Dimension(1500,900));

//버튼을 패널에 붙이기
		buttonPanel1.add(mistypo);
		buttonPanel1.add(lang);
		buttonPanel1.add(io);
		buttonPanel1.add(util);
		buttonPanel1.setBorder(new EmptyBorder(0,0,0,0));
		left.add(buttonPanel1);
//JTextField
		/*this.addWindowFocusListener(new WindowAdapter(){
			public void windowGainedFocus(WindowEvent e){
				typingField.requestFocusInWindow();
			}
		});*/

//GridBagConstraints 설정
		GridBagConstraints c=new GridBagConstraints();
		c.insets=new Insets(5,5,5,5);
	
//JTextPane: AC,Counts
		c.gridx=0;
		c.gridy=0;
		c.weightx=1;
		c.anchor=GridBagConstraints.SOUTHWEST;
		c.fill=GridBagConstraints.NONE;
		c.gridwidth=1;
		center.add(counts,c);
		
		c.gridx=0;
		c.gridy=1;
		c.anchor=GridBagConstraints.NORTHWEST;
		center.add(AC,c);

//center에 JTextField
		c.gridx=0;
		c.gridy=2;
		c.gridwidth=2;
		c.weighty=1;
		c.gridwidth=0;
		c.anchor=GridBagConstraints.NORTH;//NORTH;
		
		center.add(typingField,c);

//JLabel :단어예제 문제
		c.gridx=1;
		c.gridy=1;
		c.gridwidth=2;
		c.anchor=GridBagConstraints.SOUTH;//SOUTHWEST;
		center.add(area,c);

//세로로 버튼나열
		buttonPanel1.setLayout(new BoxLayout(buttonPanel1,BoxLayout.Y_AXIS));
		
		//Container pane=getContentPane();
		leftBorder.add(upper,BorderLayout.NORTH);
		leftBorder.add(left,BorderLayout.CENTER);
		mainPanel.add(leftBorder,BorderLayout.WEST);
		mainPanel.add(center,BorderLayout.CENTER);

		this.add(mainPanel,BorderLayout.CENTER);

		addActionListener();
	} 

//addActionListener
	public void addActionListener()
	{
		typingField.addKeyListener(new TypingFieldListener());
		mistypo.addActionListener(new WordTypeListener());
		lang.addActionListener(new WordTypeListener());
		io.addActionListener(new WordTypeListener());
		util.addActionListener(new WordTypeListener());
	}

	class WordTypeListener implements ActionListener
	{
		private ControlWordEx control;
		public WordTypeListener()
		{
			control=new ControlWordEx();
		}

		public void actionPerformed(ActionEvent e)
		{			
			String type=((JComponent)e.getSource()).getName();
			
			switch(type)
			{
				case "mistypo": if(mistypoArr==null)
					{
						mistypoArr=control.manageInputWordEx(type);
					}
					providingArr=mistypoArr;break;
				case "java.lang": if(langArr==null)
					{
						langArr=control.manageInputWordEx(type);
					}
					providingArr=langArr;break;
				case "java.io" : if(ioArr==null)
					{
						ioArr=control.manageInputWordEx(type);
					}
					providingArr=ioArr;break;
				case "java.util":if(utilArr==null)
					{
						//System.out.println("비었어");
						utilArr=control.manageInputWordEx(type);
					}
					providingArr=utilArr;break;
			}

			if(providingArr!=null)
			{
				randomIndex= getRandomInt();
				if(providingArr.length!=0) area.setText(providingArr[randomIndex]);
			}
			else{
				area.setText("");
			}
		}
	}

	public int getRandomInt()
	{
		if(providingArr!=null)
		{
			int limit=providingArr.length;
			Random tempRandom=new Random();
			return tempRandom.nextInt(limit);
		}
		else return -1;
	}

	class TypingFieldListener implements KeyListener
	{
		public void keyTyped(KeyEvent e)
		{

		}
		public void keyPressed(KeyEvent e)
		{
			long time=System.currentTimeMillis();
			ControlResultList control=ControlResultList.getInstance();
			boolean isRight=false;

			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				
				if(providingArr==null){
					area.setText("data없음!");
					typingField.setText("");
					return;}
				System.out.println(typingField.getText().trim());//test용
				countsNo+=1;
				counts.setText("COUNTS\n"+countsNo);

				if(providingArr[randomIndex].equals(typingField.getText().trim()))
				{
					isRight=true;
					accuracyNo+=1;
				}
				else
				{
					isRight=false;
				}
				accuracyPer=(int)(((double)accuracyNo/countsNo)*100);
				AC.setText("AC\n"+accuracyPer+"%");
				control.controlAddTempResult(providingArr[randomIndex],isRight);
				typingField.setText("");
				
				if(providingArr==null)
				{
					area.setText("");
					typingField.setText("");
					return;
				}
				int limit=Array.getLength(providingArr);
				Random tempRandom=new Random();
				randomIndex=tempRandom.nextInt(limit);
				if(providingArr!=null)area.setText(providingArr[randomIndex]);
			
			}
			else{
					if(providingArr==null)
					{
						return;
					}
				control.controlCharResult(time);
			}

		}
		public void keyReleased(KeyEvent e)
		{

		}
	}
}
