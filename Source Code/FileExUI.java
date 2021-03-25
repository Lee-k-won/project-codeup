import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.border.*;

public class FileExUI extends JPanel
{

	private JPanel backgroundPanel;	 // 배경 패널(갈아끼우기 용)
	private JPanel glassPanel;	// 투명 패널(타이머용)
	private JLabel timerImage;	// 타이머 이미지
	private JLabel timerLabel;		// 타이머
	private JPanel fileExPanel;		// 예제 Panel
	private JScrollPane fileExScroll;	 //  예제 스크롤
	private JTextArea fileExText;		// 예제 textArea
	private JScrollPane inputScroll;	// 사용자 입력 스크롤
	private JTextArea inputText;	// 사용자 입력 textArea
	private JPanel inputPanel;		// 사용자 입력 Panel
	private Timer timer;
	private String fileExContents;	// 예제 내용
	private String selectedCode;	// 선택된 코드

	//private JPanel titleBar;			// 타이틀 바 패널
	
	public FileExUI()
	{
	}
	public FileExUI(String fileExContents, String selectedExCode)
	{
		this.selectedCode = new String(selectedExCode);
		this.setLayout(new OverlayLayout(this));	// 계층적 구조를 가지는 레이아웃
		this.setName("FileEX");
		backgroundPanel  = new JPanel(); 	// 배경 패널

		fileExPanel = new JPanel();	// 예제 패널
		fileExPanel.setBackground(new Color(255,255,255));
		
		fileExPanel.setBorder(new EmptyBorder(100,100,100,100));


		// 예제 라벨
		fileExText = new JTextArea(fileExContents);
		fileExText.setBackground(Color.WHITE);
		fileExText.setEditable(false);
		fileExText.getCaret().setSelectionVisible(true);
		fileExText.setPreferredSize(new Dimension(680,780));
		fileExText.setFont(new Font("plain",Font.PLAIN,15));
		fileExText.setTabSize(1);

		// 예제 스크롤
		
		fileExScroll = new JScrollPane(fileExText);
		fileExScroll.setBorder(null);
		
		// 스크롤 배경 색지정
		UIManager.put("ScrollBar.track", Color.GRAY);
		// 스크롤 바 색 지정
		UIManager.put("ScrollBar.thumb", Color.DARK_GRAY);
		// 스크롤 UI 변경(변경해야 스크롤 색이 변한다)
		fileExScroll.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		// 스크롤 속도 변경.
		fileExScroll.getVerticalScrollBar().setUnitIncrement(65);    
	
		// 사용자 입력용 panel
		inputPanel = new JPanel();		// 입력 패널
		inputPanel.setBackground(new Color(45,45,48));
		inputPanel.setBorder(new EmptyBorder(100,100,100,100));

		// 사용자 입력용 textArea
		
		inputText = new JTextArea();
		inputText.setSize(500,300);
		inputText.setBackground(new Color(45,45,48));
		inputText.setForeground(new Color(255,255,255));
		inputText.setFont(new Font("bold",Font.PLAIN,15));
		inputText.setPreferredSize(new Dimension(680,780));
		inputText.setBorder(null);
		inputText.setTabSize(1);
		inputText.setCaretColor(Color.WHITE);
		
		// 사용자 입력용 scroll
		inputScroll = new JScrollPane(inputText);	 // 스크롤
		inputScroll.setBorder(null);
		// 스크롤 배경 색지정
		UIManager.put("ScrollBar.track", Color.GRAY);
		// 스크롤 바 색 지정
		UIManager.put("ScrollBar.thumb", Color.DARK_GRAY);
		// 스크롤 UI 변경(변경해야 스크롤 색이 변한다)
		inputScroll.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		// 스크롤 속도 변경.
		inputScroll.getVerticalScrollBar().setUnitIncrement(65);    
		
		this.setBackground(new Color(255,255,255));		// 배경색
	
		glassPanel = new JPanel();	// 투명 패널
		glassPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		glassPanel.setOpaque(true);
		
		// 타이머 이미지
		timerImage = new JLabel();
		timerImage.setHorizontalAlignment(SwingConstants.CENTER);
		timerImage.setIcon(new ImageIcon(getClass().getResource("Icon/timer.png")));

		timerLabel = new JLabel("00:01");	// 타이머
		//timer.setPreferredSize(new Dimension(80,50));
		timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		setBounds(200, 100, 1500, 900);
		
		this.addComponent();	
	}

	private void addComponent()
	{	
		backgroundPanel.setLayout(new GridLayout(1,2));
		
		fileExPanel.add(fileExScroll);
		inputPanel.add(inputScroll);
		backgroundPanel.add(fileExPanel);
		backgroundPanel.add(inputPanel);
		
		//getGlassPane().setOpaque(false); // glassPane 투명
		glassPanel.add(timerImage);	// 투명 패널에 타이머 추가
		glassPanel.setOpaque(false);
		timerImage.add(timerLabel);

		this.add(glassPanel);
		this.add(backgroundPanel);
		this.addActionListener();
	}
	public void addActionListener()
	{
		InputTextKeyListener keyListener = new InputTextKeyListener();
		inputText.addKeyListener(keyListener);
		timer = new Timer(0,keyListener);
	}
	class InputTextKeyListener implements KeyListener, ActionListener
	{
		FileExController fileExController;

		public InputTextKeyListener()
		{
			fileExController = new FileExController(selectedCode);
		}
		public void actionPerformed(ActionEvent ae)
		{
			
		}
		public void keyTyped(KeyEvent ke)
		{
			timer.start();
			long time = System.currentTimeMillis();
			int data = (int)ke.getKeyChar();
			System.out.println(System.currentTimeMillis()); // 입력시간 체크
			System.out.println((int)ke.getKeyChar());	// 입력 문자 체크
			fileExController.saveTempResult(data, time);
		}
		public void keyReleased(KeyEvent ke)
		{
		}
		public void keyPressed(KeyEvent ke)
		{
		}
		public void checkStart()
		{
			
		}
	}
	public void display()
	{
		setVisible(true);
		inputText.requestFocusInWindow();
	}

}