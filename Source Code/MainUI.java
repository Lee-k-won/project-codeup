import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

//최소화 최대화 리스너 해야함.

public class MainUI extends JFrame 
{
	private JButton analysisButton;
	private JButton randomButton;
	private JButton wordsButton;
	private JButton settingButton;
	private JButton filePlusButton;
	
	private JButton minButton;
	private JButton maxButton;
	private JButton closeButton;
	private JButton startButton;
	private JButton renameButton;
	private JButton	deleteButton;
	private JButton backButton;
	private JButton printButton;

	private JLabel drag;

	private JPanel menubar;
	private JPanel optionbar;

	private JPanel mainPanel;
	
	private String[][] fileData;	
	private String selectedExCode;

	private int xMouse = 0;		
	private int yMouse = 0;

	public MainUI()
	{
		this.setTitle("CodeUP");
		this.mainPanel = new JPanel(new BorderLayout());
		this.mainPanel.setPreferredSize(new Dimension(1500,900));
		this.setUndecorated(true);//위의 도스창 없애는 것

		this.menubar = new JPanel();
		menubar.setBackground(Color.WHITE);
		this.optionbar = new JPanel();
		optionbar.setBackground(Color.WHITE);

		Image img=new ImageIcon("Icon/buttonImage/MainUI/start.png").getImage().getScaledInstance(76,40,Image.SCALE_DEFAULT);
		ImageIcon image=new ImageIcon(img);
		this.startButton = new JButton(image);
		this.startButton.setPreferredSize(new Dimension(76,45));
		this.startButton.setContentAreaFilled(false);
		this.startButton.setBorderPainted(false);
		//예제 스타트버튼

		img=new ImageIcon("Icon/buttonImage/MainUI/rename.png").getImage().getScaledInstance(76,40,Image.SCALE_DEFAULT);
		image=new ImageIcon(img);
		this.renameButton = new JButton(image);
		this.renameButton.setPreferredSize(new Dimension(76,45));
		this.renameButton.setContentAreaFilled(false);
		this.renameButton.setBorderPainted(false);
		//파일명 수정 버튼

		img=new ImageIcon("Icon/buttonImage/MainUI/delete.png").getImage().getScaledInstance(76,40,Image.SCALE_DEFAULT);
		image=new ImageIcon(img);
		this.deleteButton = new JButton(image);
		this.deleteButton.setPreferredSize(new Dimension(76,45));
		this.deleteButton.setContentAreaFilled(false);
		this.deleteButton.setBorderPainted(false);
		//파일 삭제 버튼

		img=new ImageIcon("Icon/buttonImage/MainUI/back_button.png").getImage().getScaledInstance(47,50,Image.SCALE_DEFAULT);
		image=new ImageIcon(img);
		this.backButton = new JButton(image);
		this.backButton.setPreferredSize(new Dimension(47,50));
		this.backButton.setContentAreaFilled(false);
		this.backButton.setBorderPainted(false);
		//뒤로가기 버튼.

		img=new ImageIcon("Icon/buttonImage/MainUI/printer.png").getImage().getScaledInstance(88,46,Image.SCALE_DEFAULT);
		image=new ImageIcon(img);
		this.printButton = new JButton(image);
		this.printButton.setPreferredSize(new Dimension(88,46));
		this.printButton.setContentAreaFilled(false);
		this.printButton.setBorderPainted(false);
		//프린터 퍼튼
		
		img=new ImageIcon("Icon/buttonImage/MainUI/minimize_button.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
		image=new ImageIcon(img);
		this.minButton = new JButton(image);
		this.minButton.setPreferredSize(new Dimension(40,40));
		this.minButton.setContentAreaFilled(false);
		//최소화 버튼
		
		img=new ImageIcon("Icon/buttonImage/MainUI/maximize_button.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
		image=new ImageIcon(img);
		this.maxButton = new JButton(image);
		this.maxButton.setPreferredSize(new Dimension(40,40));
		this.maxButton.setContentAreaFilled(false);		
		//최대화 버튼
	
		img=new ImageIcon("Icon/buttonImage/MainUI/close_button.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
		image=new ImageIcon(img);
		this.closeButton = new JButton(image);
		this.closeButton.setPreferredSize(new Dimension(40,40));
		this.closeButton.setContentAreaFilled(false);
		//종료 버튼.

		img=new ImageIcon("Icon/MainUI/MainTitleImage.png").getImage().getScaledInstance(1500,250,Image.SCALE_DEFAULT);
		image=new ImageIcon(img);
		JLabel titleLabel = new JLabel(image);
		mainPanel.add(titleLabel,BorderLayout.NORTH);
		//로고 이미지

		img = new ImageIcon("Icon/buttonImage/MainUI/analysisbutton.png").getImage().getScaledInstance(205,165,Image.SCALE_DEFAULT);
		image = new ImageIcon(img);
		
		this.analysisButton = new JButton(image);
		this.analysisButton.setPreferredSize(new Dimension(205,165));
		this.analysisButton.setContentAreaFilled(false);
		this.analysisButton.setBorderPainted(false);
		img = new ImageIcon("Icon/buttonImage/MainUI/analysisrollover.png").getImage().getScaledInstance(205,165,Image.SCALE_DEFAULT);
		image = new ImageIcon(img);
		this.analysisButton.setRolloverIcon(image);
		this.analysisButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.analysisButton.setToolTipText("분석 및 통계");	
		//통계버튼 

		img = new ImageIcon("Icon/buttonImage/MainUI/randombutton.png").getImage().getScaledInstance(205,165,Image.SCALE_DEFAULT);
		image = new ImageIcon(img);
		
		this.randomButton = new JButton(image);
		this.randomButton.setPreferredSize(new Dimension(205,165));
		this.randomButton.setContentAreaFilled(false);
		this.randomButton.setBorderPainted(false);
		img = new ImageIcon("Icon/buttonImage/MainUI/randomrollover.png").getImage().getScaledInstance(205,165,Image.SCALE_DEFAULT);
		image = new ImageIcon(img);
		this.randomButton.setRolloverIcon(image);
		this.randomButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.randomButton.setToolTipText("랜덤 예제 연습");	
		//랜덤버튼
	
		img = new ImageIcon("Icon/buttonImage/MainUI/wordsbutton.png").getImage().getScaledInstance(205,165,Image.SCALE_DEFAULT);
		image = new ImageIcon(img);
		
		this.wordsButton = new JButton(image);
		this.wordsButton.setPreferredSize(new Dimension(205,165));
		this.wordsButton.setContentAreaFilled(false);
		this.wordsButton.setBorderPainted(false);
		img = new ImageIcon("Icon/buttonImage/MainUI/wordsrollover.png").getImage().getScaledInstance(205,165,Image.SCALE_DEFAULT);
		image = new ImageIcon(img);
		this.wordsButton.setRolloverIcon(image);
		this.wordsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.wordsButton.setToolTipText("단어 연습");	
		//단어버튼

		img = new ImageIcon("Icon/buttonImage/MainUI/settingbutton.png").getImage().getScaledInstance(205,165,Image.SCALE_DEFAULT);
		image = new ImageIcon(img);
		this.settingButton = new JButton(image);
		this.settingButton.setPreferredSize(new Dimension(205,165));
		this.settingButton.setContentAreaFilled(false);
		this.settingButton.setBorderPainted(false);
		img = new ImageIcon("Icon/buttonImage/MainUI/settingrollover.png").getImage().getScaledInstance(205,165,Image.SCALE_DEFAULT);
		image = new ImageIcon(img);
		this.settingButton.setRolloverIcon(image);
		this.settingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.settingButton.setToolTipText("설정");	
		//설정버튼

		img = new ImageIcon("Icon/buttonImage/MainUI/fileplusbutton.png").getImage().getScaledInstance(205,165,Image.SCALE_DEFAULT);
		image = new ImageIcon(img);
		
		this.filePlusButton = new JButton(image);
		this.filePlusButton.setPreferredSize(new Dimension(205,165));
		this.filePlusButton.setContentAreaFilled(false);
		this.filePlusButton.setBorderPainted(false);
		img = new ImageIcon("Icon/buttonImage/MainUI/fileplusrollover.png").getImage().getScaledInstance(205,165,Image.SCALE_DEFAULT);
		image = new ImageIcon(img);
		this.filePlusButton.setRolloverIcon(image);
		this.filePlusButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.filePlusButton.setToolTipText("파일 추가");	
		//파일추가버튼
			
		this.add(this.mainPanel);

		setBounds(200, 50, 1500, 950);
		
		this.addComponent();
	}

	private void addComponent()
	{
		JPanel northPanel = new JPanel(new GridBagLayout());
		northPanel.setPreferredSize(new Dimension(1500,50));
		northPanel.setBackground(Color.WHITE);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
	
		Image img=new ImageIcon("Icon/buttonImage/MainUI/logo.png").getImage().getScaledInstance(87,45,Image.SCALE_DEFAULT);
		ImageIcon image=new ImageIcon(img);
		JLabel logo = new JLabel(image);
		c.gridx = 0;
		c.gridy = 0;
		northPanel.add(logo,c);
		//로고 추가.
		
		this.drag = new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                    ");
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 6;
		c.weightx = 2.0;
		northPanel.add(drag,c);
		//빈칸 추가.

		this.menubar.add(startButton);
		this.menubar.add(renameButton);
		this.menubar.add(deleteButton);
		c.gridx = 7;
		c.gridwidth = 3;
		c.weightx = 0;
		northPanel.add(menubar,c);
		//시작버튼 파일명수정버튼 파일삭제버튼 추가.
		
		this.optionbar.add(backButton);
		this.optionbar.add(printButton);
		c.gridx = 10;
		c.gridwidth = 2;
		northPanel.add(optionbar,c);
		//뒤로가기버튼 프린터버튼 추가.
		
		this.minButton.setBorderPainted(false);
		c.gridx = 12;
		c.gridwidth = 1;
		c.insets = new Insets(5,-15,5,-15);
		northPanel.add(minButton,c);
		//최소화버튼.

		this.maxButton.setBorderPainted(false);
		c.gridx = 13;
		northPanel.add(maxButton,c);
		//최대화버튼.

		this.closeButton.setBorderPainted(false);
		c.gridx = 14;
		northPanel.add(closeButton,c);
		//종료버튼.

		this.add(northPanel,BorderLayout.NORTH);
		//패널 추가.


		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		layout.setHgap(30);
		layout.setVgap(35);
		JPanel panel= new JPanel(layout);
		panel.setBackground(Color.WHITE);
				
		panel.add(analysisButton);
		panel.add(randomButton);
		panel.add(wordsButton);
		panel.add(settingButton);
		panel.add(filePlusButton);
		//버튼 추가.

		mainPanel.add(panel,BorderLayout.CENTER);
		

		//이부분이 예제에 관한 버튼들 추가하는 부분.
		panel = new JPanel(new GridBagLayout());
		c.insets = new Insets(20,15,20,15);
		panel.setBackground(Color.WHITE);
		
		String[][] data = (new FileExInitController()).getSimpleFileExInfoList((byte)3); 

		int i = 0; 
		int j = 0;
		for(String[] temp : data)
		{
			c.gridx = j;
			c.gridy = i;

			panel.add(new FileButton(this,menubar,temp[0],temp[1],temp[2]),c);

			j++;
			if(j == 6)
			{
				j = 0;
				i++;
			}
		}
		// 사용자 파일 추가.

		JScrollPane scroll = new JScrollPane(panel);
		scroll.setPreferredSize(new Dimension(450,420));
		
		// 스크롤 배경 색지정
		UIManager.put("ScrollBar.track", Color.WHITE);
		// 스크롤 바 색 지정
		UIManager.put("ScrollBar.thumb", Color.WHITE);
		// 스크롤 UI 변경(변경해야 스크롤 색이 변한다)
		scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		// 스크롤 속도 변경.
		scroll.getVerticalScrollBar().setUnitIncrement(65);    

		mainPanel.add(scroll,BorderLayout.SOUTH);

		this.addListener();
	}
	
	private void addListener()
	{
		this.analysisButton.addActionListener(new AnalysisButtonListener());
		this.randomButton.addActionListener(new RandomButtonListener());
		this.wordsButton.addActionListener(new WordsButtonListener());
		this.settingButton.addActionListener(new SettingButtonListener());
		this.filePlusButton.addActionListener(new FilePlusButtonListener());
		
		this.startButton.addActionListener(new StartButtonListener());
		this.deleteButton.addActionListener(new DeleteButtonListener());
		this.renameButton.addActionListener(new RenameButtonListener());
		this.backButton.addActionListener(new BackButtonListener());
		this.printButton.addActionListener(new PrintButtonListener());
		//this.minButton.addActionListener(new MinButtonListener());
		//this.maxButton.addMouseListener(new MaxButtonListener());
		this.closeButton.addActionListener(new CloseButtonListener());
		this.drag.addMouseMotionListener(new DragMouseListener());
		
	}
	public void display()
	{
		this.menubar.setVisible(false);
		this.optionbar.setVisible(false);
		setVisible(true);
	}

	public void setSelectedExCode(String selectedExCode)
	{
		this.selectedExCode = selectedExCode;
	}

	public static void main(String[] args)
	{
		new MainUI().display();
	}
	
	//통계버튼창 리스너
	class AnalysisButtonListener implements ActionListener 
	{
		private AnalysisManager manager;

		public AnalysisButtonListener()
		{
			this.manager = new AnalysisManager();
		}
	
		public void actionPerformed(ActionEvent e)
		{
			String[][] ranking = this.manager.provideRankingAnalysisInfo();
			String[] wpms = this.manager.provideWPMAnalysisInfo();
			String[] wordsInfo = this.manager.provideWordsAnalysisInfo();
			
			//데이터를 가지고와서 생성자의 전달인자로 보내줌!

			AnalysisUI analysisPanel = new AnalysisUI(wordsInfo[1],wordsInfo[0],wpms,ranking);
			getContentPane().add(analysisPanel);
			analysisPanel.display();
			optionbar.setVisible(true);
			menubar.setVisible(false);
			mainPanel.setVisible(false);
		}
	}
	
	//랜덤예제 리스너
	class RandomButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			FileExUI fileExUI = new FileExUI(new FileExInitController().initRandFileExContents(), selectedExCode);
			getContentPane().add(fileExUI);
			fileExUI.display();
			optionbar.setVisible(true);
			menubar.setVisible(false);
			mainPanel.setVisible(false);
		}
	}
	
	//단어예제 리스너
	class WordsButtonListener implements ActionListener
	{
		private ControlWordEx control;
		
		public WordsButtonListener()
		{
			this.control = new ControlWordEx();
		}

		public void actionPerformed(ActionEvent e)
		{
			String[] data = this.control.manageInputWordEx("java.lang");//일단 java.lang으로 바꿈
			WordsExUI wordsExUI = new WordsExUI(data);
			getContentPane().add(wordsExUI);
			wordsExUI.display();
			optionbar.setVisible(true);
			menubar.setVisible(false);
			mainPanel.setVisible(false);
		}
	}
	
	//설정 리스너
	class SettingButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			menubar.setVisible(false);
			System.out.println("설정 버튼 클릭");
		}
	}

	//파일추가 리스너
	class FilePlusButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			menubar.setVisible(false);
			System.out.println("파일 추가 버튼 클릭");
		}
	}
	
	//스타트 버튼 리스너
	class StartButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			FileExUI fileExUI = new FileExUI(new FileExInitController().initFileExContents(selectedExCode), selectedExCode);
			getContentPane().add(fileExUI);
			fileExUI.display();
			optionbar.setVisible(true);
			menubar.setVisible(false);
			mainPanel.setVisible(false);
			System.out.println("시작 버튼 클릭");
		}		
	}
	
	//파일명 수정 버튼 리스너
	class RenameButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("파일명 수정 버튼 클릭");
		}		
	}
	
	//삭제 버튼 리스너
	class DeleteButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("삭제 버튼 클릭");
		}		
	}
	
	//돌아가기 버튼
	class BackButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(getContentPane().getComponent(2).getName().equals("WordsExUI"))
			{
				ControlResultList.getInstance().controlSaveResultList();
			}
			else ;
			
			remove(getContentPane().getComponent(2));
			optionbar.setVisible(false);
			mainPanel.setVisible(true);		
		}		
	}
	
	//프린트 버튼 리스너
	class PrintButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("프린트 버튼 클릭");
		}		
	}
	
	//최소화 버튼 리스너
	class MinButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("최소화 버튼 클릭");
		}		
	}


	//윈도우 리스너
	class MaxButtonListener //implements ActionListener
	{
		public void windowActivated(WindowEvent e)
		{
		
		}			
	}
	
	//종료리스너
	class CloseButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dispose();
			System.exit(0);
		}		
	}
	
	class DragMouseListener extends MouseAdapter
	{
		public void mousePressed(MouseEvent evt)
		{
			xMouse = evt.getX();
			yMouse = evt.getY();
		}
		public void mouseDragged(MouseEvent evt)
		{
			int x = evt.getXOnScreen();
			int y = evt.getYOnScreen();
			setLocation(x-xMouse,y-yMouse);
		}
	}
	
	
}