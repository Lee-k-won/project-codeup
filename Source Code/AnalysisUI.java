import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class AnalysisUI extends JPanel
{
	private JButton	wordAnalysisButton;
	private JButton wpmAnalysisButton;
	private JLabel totalChar;
	private JLabel totalWord;

	private String totalChars;
	private String totalWords;
	private String[] wpms;
	private int wpmAve;
	
	private JPanel wpmPanel;
	private JPanel wordPanel;
	private String[][] ranking;
 
	public AnalysisUI(String totalChars, String totalWords, String[] wpms, String[][] ranking)//전체 단어수, 문자수, wpm 기록들 넘어와야함
	{
		setBounds(200, 100, 1500, 900);
		this.setLayout(new BorderLayout());
		this.setName("AnalysisUI");

		this.totalChars = totalChars;
		this.totalWords = totalWords;
		this.wpms = wpms;
		this.ranking = ranking;

		for(int i = 0 ; i < wpms.length ; i++)
		{
			this.wpmAve += Integer.parseInt(wpms[i]);
		}
		this.wpmAve = wpmAve / wpms.length;

		//단어 통계쪽 데이터
		
		Image img = new ImageIcon("Icon/buttonImage/AnalysisUI/WPMAnalysisButton.png").getImage().getScaledInstance(230,130,Image.SCALE_DEFAULT);
		ImageIcon image = new ImageIcon(img);		
		this.wpmAnalysisButton = new JButton(image);
		this.wpmAnalysisButton.setPreferredSize(new Dimension(230,130));
		this.wpmAnalysisButton.setContentAreaFilled(false);
		this.wpmAnalysisButton.setBorderPainted(false);

		img = new ImageIcon("Icon/buttonImage/AnalysisUI/WordAnalysisButton.png").getImage().getScaledInstance(230,130,Image.SCALE_DEFAULT);
		image = new ImageIcon(img);	
		this.wordAnalysisButton = new JButton(image);
		this.wordAnalysisButton.setPreferredSize(new Dimension(230,130));
		this.wordAnalysisButton.setContentAreaFilled(false);
		this.wordAnalysisButton.setBorderPainted(false);

		img = new ImageIcon("Icon/buttonImage/AnalysisUI/untilNow.png").getImage().getScaledInstance(230,130,Image.SCALE_DEFAULT);
		image = new ImageIcon(img);
		JLabel until = new JLabel(image);
		until.setPreferredSize(new Dimension(230,130));
		
		img = new ImageIcon("Icon/buttonImage/AnalysisUI/charactersImage.png").getImage().getScaledInstance(199,65,Image.SCALE_DEFAULT);
		image = new ImageIcon(img);
		JLabel characters = new JLabel(image);
		characters.setPreferredSize(new Dimension(199,65));

		img = new ImageIcon("Icon/buttonImage/AnalysisUI/wordsImage.png").getImage().getScaledInstance(199,65,Image.SCALE_DEFAULT);
		image = new ImageIcon(img);
		JLabel words = new JLabel(image);
		words.setPreferredSize(new Dimension(199,65));

		this.totalChar = new JLabel(totalChars,SwingConstants.CENTER);
		this.totalChar.setFont(new Font(totalChars,Font.PLAIN,35));
		// 총 문자수
		this.totalWord = new JLabel(totalWords,SwingConstants.CENTER);
		this.totalWord.setFont(new Font(totalWords,Font.PLAIN,35));
		// 총 문자수 초기화 하는 부분.

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(1500,200));
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		panel.add(this.wpmAnalysisButton,c);
		// wpm 통계 버튼

		c.gridx = 1;
		panel.add(this.wordAnalysisButton,c);
		// 단어 통계 버튼

		c.gridx = 2;
		c.gridwidth = 2;
		c.weightx = 1.0;
		JLabel blank = new JLabel();
		blank.setPreferredSize(new Dimension(250,130));
		panel.add(blank,c);
		// 공백 
		
		c.gridx = 4;
		c.gridwidth = 1;
		c.weightx = 0.0;
		panel.add(until,c);
		// 사진

		c.gridx = 5;
		c.insets = new Insets(-60,10,10,10);
		panel.add(this.totalChar,c);
		// 총 문자수 

		c.gridy = 1;
		c.insets = new Insets(0,10,0,10);
		panel.add(this.totalWord,c);
		// 총 단어수
		
		c.insets = new Insets(10,10,0,10);
		c.gridx = 6;
		c.gridy = 0;
		c.gridheight = 1;
		panel.add(characters,c);
		// 그림
		
		c.insets = new Insets(0,10,0,10);
		c.gridy = 1;
		panel.add(words,c);
		// 그림

		this.add(panel,BorderLayout.SOUTH);

		this.setWPMAnalysis();

		this.setWordsAnalysis();

		this.add(wordPanel,BorderLayout.CENTER);
		this.add(wpmPanel,BorderLayout.CENTER);

		this.addComponent();
	}

	private void setWPMAnalysis()
	{
		this.wpmPanel = new JPanel(new BorderLayout());
		
		Image img = new ImageIcon("Icon/AnalysisUI/AnalysisImage.png").getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
		ImageIcon image = new ImageIcon(img);
		JLabel analysisImage = new JLabel(image);
		analysisImage.setPreferredSize(new Dimension(400,500)); 
		//왼쪽 이미지
		
		img = new ImageIcon("Icon/AnalysisUI/WPMImage.png").getImage().getScaledInstance(155,150,Image.SCALE_DEFAULT);
		image = new ImageIcon(img);
		JLabel wpmLabel = new JLabel(wpmAve+"",image,SwingConstants.CENTER);
		wpmLabel.setFont(new Font(wpmAve+"",Font.PLAIN,50));
		wpmLabel.setForeground(Color.WHITE);
		wpmLabel.setVerticalTextPosition(SwingConstants.CENTER);
		wpmLabel.setHorizontalTextPosition(SwingConstants.CENTER);

		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.setBackground(new Color(45,45,48));
		panel1.add(analysisImage,BorderLayout.CENTER);
		panel1.add(wpmLabel,BorderLayout.SOUTH);
		
		this.wpmPanel.add(panel1,BorderLayout.WEST);

		this.wpmPanel.add(new Graph(),BorderLayout.CENTER);
		wpmPanel.setBackground(new Color(45,45,48));
	
	}
	
	private void setWordsAnalysis()
	{
		this.wordPanel=new JPanel(new BorderLayout());
		
		JPanel rankingPanel=new JPanel(new GridLayout(3,5));
		rankingPanel.setBackground(new Color(45,45,48));
		rankingPanel.setPreferredSize(new Dimension(1500,700));

		Image tempImg=new ImageIcon("Icon/AnalysisUI/wordAnalysis.png").getImage().getScaledInstance(1500,200,Image.SCALE_DEFAULT);
		ImageIcon icon=new ImageIcon(tempImg);
		JLabel wordLabel=new JLabel(icon);
		wordLabel.setBackground(new Color(45,45,48));
		wordLabel.setPreferredSize(new Dimension(1500,200));	
		//JTextPane & String[][]

		wordPanel.add(wordLabel,BorderLayout.NORTH);


		JLabel top1=new JLabel(ranking[0][1]+"%",SwingConstants.CENTER);
		JLabel top2=new JLabel(ranking[1][1]+"%",SwingConstants.CENTER);		
		JLabel top3=new JLabel(ranking[2][1]+"%",SwingConstants.CENTER);
		JLabel top4=new JLabel(ranking[3][1]+"%",SwingConstants.CENTER);
		JLabel top5=new JLabel(ranking[4][1]+"%",SwingConstants.CENTER);
		
		top1.setPreferredSize(new Dimension(200,200));
		top2.setPreferredSize(new Dimension(200,200));
		top3.setPreferredSize(new Dimension(200,200));
		top4.setPreferredSize(new Dimension(200,200));
		top5.setPreferredSize(new Dimension(200,200));

		top1.setBackground(new Color(45,45,48));
		top2.setBackground(new Color(45,45,48));
		top3.setBackground(new Color(45,45,48));
		top4.setBackground(new Color(45,45,48));
		top5.setBackground(new Color(45,45,48));
		
		top1.setForeground(new Color(252,51,4));
		top2.setForeground(new Color(252,86,20));
		top3.setForeground(new Color(248,151,8));
		top4.setForeground(new Color(252,222,4));
		top5.setForeground(new Color(213,255,1));

		top1.setFont(new Font(ranking[0][1],Font.BOLD,60));
		top2.setFont(new Font(ranking[1][1],Font.BOLD,60));
		top3.setFont(new Font(ranking[2][1],Font.BOLD,60));
		top4.setFont(new Font(ranking[3][1],Font.BOLD,60));
		top5.setFont(new Font(ranking[4][1],Font.BOLD,60));

		rankingPanel.add(top1);
		rankingPanel.add(top2);
		rankingPanel.add(top3);
		rankingPanel.add(top4);
		rankingPanel.add(top5);

		JLabel content1=new JLabel(ranking[0][0],SwingConstants.CENTER);
		JLabel content2=new JLabel(ranking[1][0],SwingConstants.CENTER);
		JLabel content3=new JLabel(ranking[2][0],SwingConstants.CENTER);
		JLabel content4=new JLabel(ranking[3][0],SwingConstants.CENTER);
		JLabel content5=new JLabel(ranking[4][0],SwingConstants.CENTER);
		
		content1.setPreferredSize(new Dimension(200,200));
		content2.setPreferredSize(new Dimension(200,200));
		content3.setPreferredSize(new Dimension(200,200));
		content4.setPreferredSize(new Dimension(200,200));
		content5.setPreferredSize(new Dimension(200,200));

		content1.setBackground(new Color(45,45,48));
		content2.setBackground(new Color(45,45,48));
		content3.setBackground(new Color(45,45,48));
		content4.setBackground(new Color(45,45,48));
		content5.setBackground(new Color(45,45,48));
		
		content1.setForeground(new Color(252,51,4));
		content2.setForeground(new Color(252,86,20));
		content3.setForeground(new Color(248,151,8));
		content4.setForeground(new Color(252,222,4));
		content5.setForeground(new Color(213,255,1));

		content1.setFont(new Font(ranking[0][0],Font.BOLD,25));
		content2.setFont(new Font(ranking[1][0],Font.BOLD,25));
		content3.setFont(new Font(ranking[2][0],Font.BOLD,25));
		content4.setFont(new Font(ranking[3][0],Font.BOLD,25));
		content5.setFont(new Font(ranking[4][0],Font.BOLD,25));

		rankingPanel.add(content1);
		rankingPanel.add(content2);
		rankingPanel.add(content3);
		rankingPanel.add(content4);
		rankingPanel.add(content5);

		rankingPanel.add(new JLabel());
		rankingPanel.add(new JLabel());
		rankingPanel.add(new JLabel());
		rankingPanel.add(new JLabel());
		rankingPanel.add(new JLabel());

		wordPanel.add(rankingPanel,BorderLayout.CENTER);
		
		wordPanel.setVisible(false);
	}


	private void addComponent()
	{
		this.addActionListener();
	}

	private void addActionListener()
	{
		WordAnalysisButtonListener listener1 = new WordAnalysisButtonListener();
		WPMAnalysisButtonListener listener2 = new WPMAnalysisButtonListener();
		this.wordAnalysisButton.addActionListener(listener1);
		this.wordAnalysisButton.addMouseListener(listener1);
		this.wpmAnalysisButton.addActionListener(listener2);
		this.wpmAnalysisButton.addMouseListener(listener2);
	}
	
	public void display()
	{
		this.setVisible(true);
	}
	
	class WordAnalysisButtonListener extends MouseAdapter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			add(wordPanel,BorderLayout.CENTER);
			wpmPanel.setVisible(false);
			wordPanel.setVisible(true);
		}
		public void mouseEntered(MouseEvent evt) 
		{
			System.out.println("wordAnalysisButton");
		}

		public void mouseExited(java.awt.event.MouseEvent evt)
		{
			;
		}
	}

	class WPMAnalysisButtonListener extends MouseAdapter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			add(wpmPanel,BorderLayout.CENTER);
			wordPanel.setVisible(false);
			wpmPanel.setVisible(true);
		}
		public void mouseEntered(MouseEvent evt) 
		{
			System.out.println("WPMAnalysisButton");
		}

		public void mouseExited(java.awt.event.MouseEvent evt)
		{
			;
		}
	}

	public class Graph extends JPanel
	{
		private int[] calWpms;
		private int maxWpm;		// 최대 wpm 저장
		private int cases;		// wpm 기록들의 개수 저장.

		public Graph()		// wpm 기록들
		{	
			this.cases = wpms.length;
			this.calWpms = new int[15];
			this.maxWpm = 0;
			
			if(cases < 15)
			{
				for(int i= 0 ; i< cases ; i++)
				{
					calWpms[i] = Integer.parseInt(wpms[i]);
				}
				for(int i= cases ; i < 15 ; i++)
				{
					calWpms[i] = -50;
				}
			}
			else
			{			
				for(int i = 0; i < 15 ; i++)
				{
					for(int j = i*(cases/15) ; j < i*(cases/15) + cases/15 ; j++)
					{
						calWpms[i] += Integer.parseInt(wpms[j]);
					}
					calWpms[i] /= (cases/15);
				}
			}
			
			for(int i = 0 ; i< 15 ; i++)
			{
				if(maxWpm < calWpms[i])
				{
					maxWpm = calWpms[i];
				}
			}	

			this.setPreferredSize(new Dimension(1100,700));
			this.setVisible(true);
			this.setBackground(new Color(45,45,48));
		}

		public void paint(Graphics g)
		{
			g.setColor(new Color(127,127,127));
			g.drawLine(20,600,1050,600);
			g.drawLine(50,20,50,630);
			//선 그리는거	

			((Graphics2D)g).setBackground(new Color(45,45,48));
			//배경색 지정		

			g.setColor(Color.WHITE);
			g.setFont(new Font("bold",Font.BOLD,25));
			g.drawString(cases+" cases",900,630);
			g.drawString(maxWpm+"",10,55);
			g.setFont(new Font("bold",Font.BOLD,15));
			g.drawString("wpm",7,70);
			//글씨
			
			for(int i = 0 ; i < 15 ; i++)
			{	
				g.setColor(new Color(255,130-i*5,50-i*2));
				g.fillRect(100+i*60,550-500*calWpms[i]/maxWpm,50,50+500*calWpms[i]/maxWpm);
			}
		}
	}
}