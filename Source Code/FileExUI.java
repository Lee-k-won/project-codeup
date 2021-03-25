import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.border.*;

public class FileExUI extends JPanel
{

	private JPanel backgroundPanel;	 // ��� �г�(���Ƴ���� ��)
	private JPanel glassPanel;	// ���� �г�(Ÿ�̸ӿ�)
	private JLabel timerImage;	// Ÿ�̸� �̹���
	private JLabel timerLabel;		// Ÿ�̸�
	private JPanel fileExPanel;		// ���� Panel
	private JScrollPane fileExScroll;	 //  ���� ��ũ��
	private JTextArea fileExText;		// ���� textArea
	private JScrollPane inputScroll;	// ����� �Է� ��ũ��
	private JTextArea inputText;	// ����� �Է� textArea
	private JPanel inputPanel;		// ����� �Է� Panel
	private Timer timer;
	private String fileExContents;	// ���� ����
	private String selectedCode;	// ���õ� �ڵ�

	//private JPanel titleBar;			// Ÿ��Ʋ �� �г�
	
	public FileExUI()
	{
	}
	public FileExUI(String fileExContents, String selectedExCode)
	{
		this.selectedCode = new String(selectedExCode);
		this.setLayout(new OverlayLayout(this));	// ������ ������ ������ ���̾ƿ�
		this.setName("FileEX");
		backgroundPanel  = new JPanel(); 	// ��� �г�

		fileExPanel = new JPanel();	// ���� �г�
		fileExPanel.setBackground(new Color(255,255,255));
		
		fileExPanel.setBorder(new EmptyBorder(100,100,100,100));


		// ���� ��
		fileExText = new JTextArea(fileExContents);
		fileExText.setBackground(Color.WHITE);
		fileExText.setEditable(false);
		fileExText.getCaret().setSelectionVisible(true);
		fileExText.setPreferredSize(new Dimension(680,780));
		fileExText.setFont(new Font("plain",Font.PLAIN,15));
		fileExText.setTabSize(1);

		// ���� ��ũ��
		
		fileExScroll = new JScrollPane(fileExText);
		fileExScroll.setBorder(null);
		
		// ��ũ�� ��� ������
		UIManager.put("ScrollBar.track", Color.GRAY);
		// ��ũ�� �� �� ����
		UIManager.put("ScrollBar.thumb", Color.DARK_GRAY);
		// ��ũ�� UI ����(�����ؾ� ��ũ�� ���� ���Ѵ�)
		fileExScroll.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		// ��ũ�� �ӵ� ����.
		fileExScroll.getVerticalScrollBar().setUnitIncrement(65);    
	
		// ����� �Է¿� panel
		inputPanel = new JPanel();		// �Է� �г�
		inputPanel.setBackground(new Color(45,45,48));
		inputPanel.setBorder(new EmptyBorder(100,100,100,100));

		// ����� �Է¿� textArea
		
		inputText = new JTextArea();
		inputText.setSize(500,300);
		inputText.setBackground(new Color(45,45,48));
		inputText.setForeground(new Color(255,255,255));
		inputText.setFont(new Font("bold",Font.PLAIN,15));
		inputText.setPreferredSize(new Dimension(680,780));
		inputText.setBorder(null);
		inputText.setTabSize(1);
		inputText.setCaretColor(Color.WHITE);
		
		// ����� �Է¿� scroll
		inputScroll = new JScrollPane(inputText);	 // ��ũ��
		inputScroll.setBorder(null);
		// ��ũ�� ��� ������
		UIManager.put("ScrollBar.track", Color.GRAY);
		// ��ũ�� �� �� ����
		UIManager.put("ScrollBar.thumb", Color.DARK_GRAY);
		// ��ũ�� UI ����(�����ؾ� ��ũ�� ���� ���Ѵ�)
		inputScroll.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		// ��ũ�� �ӵ� ����.
		inputScroll.getVerticalScrollBar().setUnitIncrement(65);    
		
		this.setBackground(new Color(255,255,255));		// ����
	
		glassPanel = new JPanel();	// ���� �г�
		glassPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		glassPanel.setOpaque(true);
		
		// Ÿ�̸� �̹���
		timerImage = new JLabel();
		timerImage.setHorizontalAlignment(SwingConstants.CENTER);
		timerImage.setIcon(new ImageIcon(getClass().getResource("Icon/timer.png")));

		timerLabel = new JLabel("00:01");	// Ÿ�̸�
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
		
		//getGlassPane().setOpaque(false); // glassPane ����
		glassPanel.add(timerImage);	// ���� �гο� Ÿ�̸� �߰�
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
			System.out.println(System.currentTimeMillis()); // �Է½ð� üũ
			System.out.println((int)ke.getKeyChar());	// �Է� ���� üũ
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