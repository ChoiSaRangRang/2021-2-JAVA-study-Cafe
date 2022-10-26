import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class readyStudy extends JFrame {
	private JLabel name = new JLabel("이름 : ");
	private JTextField textname = new JTextField(10);
	private JButton namebtn = new JButton("확인");
	public static cus_info cus = new cus_info();
	private String getName;

	readyStudy() {
		setTitle("비숑 StudyRoom_입장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);

		c.add(name);
		name.setFont(new Font("a시월구일2", Font.BOLD, 20));
		name.setLocation(100, 30);
		name.setSize(100, 100);

		c.add(textname);
		textname.setFont(new Font("a시월구일2", Font.BOLD, 20));
		textname.setLocation(165, 55);
		textname.setSize(150, 50);

		c.add(namebtn);
		namebtn.setFont(new Font("a시월구일2", Font.BOLD, 20));
		namebtn.setLocation(320, 55);
		namebtn.setSize(80, 50);
		namebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getName = textname.getText();
				if (db.isName(getName))
					JOptionPane.showMessageDialog(null, "이미 존재하는 이름입니다.", "이름 확인 중", JOptionPane.PLAIN_MESSAGE);
				else {
					cus.setName(getName);
					new seatStudy();
					setVisible(false);
				}

			}
		});

		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new readyStudy();
	}
}
