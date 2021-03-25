import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class FileButton extends JPanel
{
	private JFrame prev;
	private JPanel menu;
	private String fileName;
	private String inputNum;
	private String code;
	private String level;
	private JButton button;
	//레벨에 따라 색 변경해주는거 추가해야한다!
	FileButton(JFrame prev,JPanel menu,String fileName,String code,String level)
	{
		this.prev = prev;
		this.menu = menu;
		this.fileName = fileName;
		this.code = code;
		this.level = level;
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(205,165));
		this.setLayout(new BorderLayout());

		Image img = null;
		ImageIcon image = null;
		Image rolloverImg = null;
		ImageIcon rolloverImage = null;

		if(level.equals("1"))
		{
			img=new ImageIcon("Icon/buttonImage/MainUI/level1.png").getImage().getScaledInstance(205,165,Image.SCALE_DEFAULT);
			image=new ImageIcon(img);
			rolloverImg = new ImageIcon("Icon/buttonImage/MainUI/rolloverlevel1.png").getImage().getScaledInstance(205,165,Image.SCALE_DEFAULT);
			rolloverImage = new ImageIcon(rolloverImg);
		}
		else if(level.equals("2"))
		{
			img=new ImageIcon("Icon/buttonImage/MainUI/level2.png").getImage().getScaledInstance(205,165,Image.SCALE_DEFAULT);
			image=new ImageIcon(img);
			rolloverImg = new ImageIcon("Icon/buttonImage/MainUI/rolloverlevel2.png").getImage().getScaledInstance(205,165,Image.SCALE_DEFAULT);
			rolloverImage = new ImageIcon(rolloverImg);
		}
		else
		{
			img=new ImageIcon("Icon/buttonImage/MainUI/level3.png").getImage().getScaledInstance(205,165,Image.SCALE_DEFAULT);
			image=new ImageIcon(img);
			rolloverImg = new ImageIcon("Icon/buttonImage/MainUI/rolloverlevel3.png").getImage().getScaledInstance(205,165,Image.SCALE_DEFAULT);
			rolloverImage = new ImageIcon(rolloverImg);
		}
		this.button = new JButton(this.fileName,image);
		this.button.setVerticalTextPosition(JButton.CENTER);
		this.button.setHorizontalTextPosition(JButton.CENTER);
		this.button.setPreferredSize(new Dimension(205,165));
		this.button.setRolloverIcon(rolloverImage);
		this.button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.button.setContentAreaFilled(false);
		this.button.setBorderPainted(false);
		this.button.setFont(new Font("fileName",Font.BOLD,15));
		this.addComponent();
	}

	private void addComponent()
	{
		this.add(this.button,BorderLayout.CENTER);
		this.addActionListener();
	}

	private void addActionListener()
	{
		this.button.addActionListener(new ExampleFileListener());
	}
	
	public void display()
	{
		this.setVisible(true);
	}

	class ExampleFileListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			menu.setVisible(true);
			((MainUI)prev).setSelectedExCode(code);
			//MainUI의 selectedExCode 멤버를 세팅하는것. 이 파일들을 저장할때, index같은 번호로 저장한 것이 아니기 때문에, 지금은 이렇게 하는데
			//다른방법을 생각해보자.
		}
	}

}