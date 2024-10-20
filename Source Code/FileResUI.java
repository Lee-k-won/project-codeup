import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.border.*;


public class FileResUI extends JPanel
{
	private JLabel wpmLabel;
	private String wpm;
	private JLabel wordsLabel;
	private String words;
	private JLabel charLabel;
	private String chars;
	private JLabel timeLabel;
	private String timeLog;
	private JLabel bestTimeLabel;
	private String bestTimeLog;

	public FileResUI()	// wpm words chars timeLog bestTimeLog 를 넘겨줘야함.
	{	
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(45,45,48));
		this.wpm = "42";
		this.words = "124";
		this.chars = "2142";
		this.timeLog = "02:32";
		this.bestTimeLog = "03:23";
		
		this.setPreferredSize(new Dimension(680,780));

		Image img=new ImageIcon("Icon/FileExUI/wpmImage.png").getImage().getScaledInstance(222,141,Image.SCALE_DEFAULT);
		ImageIcon image=new ImageIcon(img);
		this.wpmLabel = new JLabel(wpm,image,SwingConstants.CENTER);
		wpmLabel.setPreferredSize(new Dimension(222,141));
		wpmLabel.setFont(new Font(wpm,Font.PLAIN,50));
		wpmLabel.setForeground(Color.WHITE);
		wpmLabel.setVerticalTextPosition(SwingConstants.CENTER);
		wpmLabel.setHorizontalTextPosition(SwingConstants.CENTER);

		img = new ImageIcon("Icon/FileExUI/wordsImage.png").getImage().getScaledInstance(222,141,Image.SCALE_DEFAULT);
		image=new ImageIcon(img);
		this.wordsLabel = new JLabel(words,image,SwingConstants.CENTER);
		wordsLabel.setPreferredSize(new Dimension(222,141));
		wordsLabel.setFont(new Font(words,Font.PLAIN,50));
		wordsLabel.setForeground(Color.WHITE);
		wordsLabel.setVerticalTextPosition(SwingConstants.CENTER);
		wordsLabel.setHorizontalTextPosition(SwingConstants.CENTER);

		img = new ImageIcon("Icon/FileExUI/charactersImage.png").getImage().getScaledInstance(222,141,Image.SCALE_DEFAULT);
		image=new ImageIcon(img);
		this.charLabel = new JLabel(chars,image,SwingConstants.CENTER);
		charLabel.setPreferredSize(new Dimension(222,141));
		charLabel.setFont(new Font(chars,Font.PLAIN,50));
		charLabel.setForeground(Color.WHITE);
		charLabel.setVerticalTextPosition(SwingConstants.CENTER);
		charLabel.setHorizontalTextPosition(SwingConstants.CENTER);

		this.addComponent();
	}

	private void addComponent()
	{
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(new Color(45,45,48));

		JPanel panel = new JPanel(new GridLayout());
		panel.setPreferredSize(new Dimension(680,150));
		panel.setBackground(new Color(45,45,48));
		panel.add(this.wpmLabel);
		panel.add(this.wordsLabel);
		panel.add(this.charLabel);

		mainPanel.add(panel,BorderLayout.SOUTH);


		JLabel title = new JLabel("Result",SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setBackground(new Color(45,45,48));
		title.setFont(new Font("Result",Font.BOLD,30));
		title.setPreferredSize(new Dimension(680,130));
		mainPanel.add(title,BorderLayout.NORTH);

		panel = new JPanel();
		panel.setLayout(new GridLayout(5,5));
		panel.setBackground(new Color(45,45,48));

		panel.add(new JLabel());
		panel.add(new JLabel());
		
		JLabel timeTitle1 = new JLabel("최고기록",SwingConstants.CENTER);
		timeTitle1.setForeground(new Color(255,102,0));
		timeTitle1.setBackground(new Color(45,45,48));
		timeTitle1.setFont(new Font("최고기록",Font.BOLD,25));
		panel.add(timeTitle1);

		JLabel timeTitle2 = new JLabel("사용자기록",SwingConstants.CENTER);
		timeTitle2.setForeground(Color.WHITE);
		timeTitle2.setBackground(new Color(45,45,48));
		timeTitle2.setFont(new Font("사용자기록",Font.BOLD,25));
		panel.add(timeTitle2);
		
		this.timeLabel = new JLabel(timeLog,SwingConstants.CENTER);
		timeLabel.setForeground(new Color(255,102,0));
		timeLabel.setBackground(new Color(45,45,48));
		timeLabel.setFont(new Font(timeLog,Font.BOLD,30));
		panel.add(timeLabel);

		this.bestTimeLabel = new JLabel(bestTimeLog,SwingConstants.CENTER);
		bestTimeLabel.setForeground(Color.WHITE);
		bestTimeLabel.setBackground(new Color(45,45,48));
		bestTimeLabel.setFont(new Font(bestTimeLog,Font.BOLD,30));
		panel.add(bestTimeLabel);

		panel.add(new JLabel());
		panel.add(new JLabel());

		
		mainPanel.add(panel,BorderLayout.CENTER);

		this.add(mainPanel,BorderLayout.CENTER);

		Image img=new ImageIcon("Icon/FileExUI/centerBar.png").getImage().getScaledInstance(36,900,Image.SCALE_DEFAULT);
		ImageIcon image=new ImageIcon(img);
		JLabel centerbar = new JLabel(image);
		centerbar.setPreferredSize(new Dimension(36,900));

		this.add(centerbar,BorderLayout.EAST);

	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		frame.add(new FileResUI(),BorderLayout.WEST);
		frame.setPreferredSize(new Dimension(1500,900));
		frame.pack();
		frame.setVisible(true);
		
	}
}