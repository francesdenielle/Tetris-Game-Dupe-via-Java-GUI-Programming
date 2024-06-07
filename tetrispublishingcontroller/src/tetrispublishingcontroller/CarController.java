package tetrispublishingcontroller;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tetrispssfx.*;
import tetrispsswsimpl.MessengerImpl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CarController extends JFrame implements ActionListener{
	String subscriberName = "carview";
	JButton btnRight = new JButton("Right");
	JButton btnLeft = new JButton("Left");
	JButton btnUp = new JButton("Up");
	JButton btnDown= new JButton("Down");
	JButton btnFaster= new JButton("Faster");
	JButton btnSlower= new JButton("Slower");
	JButton btnRotate= new JButton("Rotate");
	JLabel label = new JLabel("sjflsjfklslj");
	
	
	Messenger  messenger; 
	
	public void init() {
		try {
			messenger = new MessengerImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
	}
	
	
	public void initUI() {
		BufferedImage background = null,
					  down = null,
					  left = null,
					  right = null,
					  up = null;
		try {
			background = ImageIO.read(new File("src/images/ui_bg.png"));
			down = ImageIO.read(new File("src/images/down.png"));
			up = ImageIO.read(new File("src/images/up.png"));
			left = ImageIO.read(new File("src/images/left.png"));
			right = ImageIO.read(new File("src/images/right.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image scaleddown = down.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		Image scaledup = up.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		Image scaledleft = left.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		Image scaledright = right.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		
		ImageIcon buttdown = new ImageIcon(scaleddown);
		ImageIcon buttup = new ImageIcon(scaledup);
		ImageIcon buttleft = new ImageIcon(scaledleft);
		ImageIcon buttright = new ImageIcon(scaledright);
		ImageIcon bg = new ImageIcon(background);
		
		label.setIcon(bg);
		label.setBounds(0,0,500,400);
		label.setPreferredSize(new Dimension(500,400));
		
		btnRight = noBG(btnRight, buttright);
		btnLeft = noBG(btnLeft, buttleft);
		btnUp = noBG(btnUp, buttup);
		btnDown = noBG(btnDown, buttdown);
		
		btnRight.setBounds(200,100,100,100);
		btnLeft.setBounds(10,100,100,100);
		btnUp.setBounds(100,10,100,100);
		btnDown.setBounds(100,200,100,100);
		btnFaster.setBounds(320,50,100,100);
		btnSlower.setBounds(320,170,100,100);
		btnRotate.setBounds(320, 280, 100, 50);
		
		RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);

		Area area = new Area(new Rectangle(0, 0, getWidth(), getHeight()));
		area.subtract(new Area(roundedRectangle));

		JPanel panel = new JPanel() {
		    @Override
		    protected void paintComponent(Graphics g) {
		        Graphics2D g2d = (Graphics2D) g.create();
		        g2d.setColor(getBackground());
		        g2d.fill(roundedRectangle);
		        g2d.dispose();
		    }
		};
		panel.setBounds(0, 0, getWidth(), getHeight());
		setContentPane(panel);
		    
		panel.add(btnRight);
		panel.add(btnLeft);
		panel.add(btnUp);
		panel.add(btnDown);
		panel.add(btnFaster);
		panel.add(btnSlower);
		panel.add(btnRotate);
		panel.add(label);
		
		btnRight.addActionListener(this);
		btnLeft.addActionListener(this);
		btnUp.addActionListener(this);
		btnDown.addActionListener(this);
		btnFaster.addActionListener(this);
	 	btnSlower.addActionListener(this);
	 	btnRotate.addActionListener(this);
		
		
		setLayout(null);
		setVisible(true);
		setBounds(500,10,500,400);
	}

	public JButton noBG (JButton button, ImageIcon img) {
		button.setIcon(img);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {			
			Message message = new Message();
			message.setTopic(subscriberName);
			if(e.getSource() == btnRight)
			{
				message.setPayload("Right");
					messenger.publish(message);
			}
			else if(e.getSource() == btnLeft)
			{
				message.setPayload("Left");
				messenger.publish(message);
			}
			else if(e.getSource() == btnUp)
			{
				message.setPayload("Up");
				messenger.publish(message);
			}
			else if(e.getSource() == btnDown)
			{
				message.setPayload("Down");
				messenger.publish(message);
			}			
			else if(e.getSource() == btnFaster)
			{
				message.setPayload("Faster");
				messenger.publish(message);
			}			
			else if(e.getSource() == btnSlower)
			{
				message.setPayload("Slower");
				messenger.publish(message);
			}	
			else if(e.getSource() == btnRotate)
			{
				message.setPayload("Rotate");
				messenger.publish(message);
			}	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

