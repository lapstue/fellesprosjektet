package client.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import temp.TestObjects;

import data.Notification;

@SuppressWarnings("serial")
public class NotificationWindow extends JPanel implements ActionListener { // TODO This needs a fix
	private static final String FRAME_NAME = "Beskjed"; 
	private static final String BUTTON_CLOSE = "Lukk";

	private static final int LINE_START = GridBagConstraints.LINE_START;
	private static final int LINE_END = GridBagConstraints.LINE_END;

	private Notification notification;
	private JFrame frame;
	private JTextArea notificationTextArea; // TODO?
	private JButton closeButton;
	private GridBagConstraints c;
	
	public NotificationWindow(Notification notification) {
		this.notification = notification;
		
		initFrame();
		initPanel();
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private void initFrame() {
		frame = new JFrame(FRAME_NAME);
		frame.setPreferredSize(new Dimension(250, 150)); // TODO?
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void initPanel() {
		c = new GridBagConstraints();
		setLayout(new GridBagLayout());
		
		notificationTextArea = new JTextArea(notification.getMessage());
		notificationTextArea.setEditable(false);
		notificationTextArea.setBackground(frame.getBackground());
		closeButton = new JButton(BUTTON_CLOSE);
		
		c.insets = new Insets(0,0,5,0);
		c.ipadx = 10;
		
		addComponent(notificationTextArea, 0, 0, 1, LINE_START);
		addComponent(closeButton, 0, 1, 1, LINE_END);
		
		closeButton.addActionListener(this);
	}
	private void addComponent(JComponent component, int gridx, int gridy, int gridwidth, int anchor) {
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.anchor = anchor;
		add(component, c);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(closeButton)) {
			frame.dispose();
		}
	}

	public static void main(String[] args) {
		new NotificationWindow(TestObjects.getNotification01());
	}
	
}
