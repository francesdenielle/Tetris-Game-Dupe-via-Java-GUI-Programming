package tetrissubscribingview;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tetrisshapeimpl.*;
import tetrisshapesfx.*;
import tetrispssfx.*;
import tetrispsswsimpl.MessengerImpl;

public class SubscriberView extends JFrame implements Subscriber {
    Messenger messenger;
    String subscriberName;
    // MyShape car;
    MyShape block;
    Mover mover;
    int speed = 10;

    Renderer renderer = new MyBlockRenderer();
    JLabel backgroundLabel;
    MyBlock myblock;
    Block1 block1;

    void init(MyShape block) {
        this.subscriberName = "carview";
        this.block = block;
        myblock = (MyBlock) block;
        block1 = myblock.getBlock1();
        mover = new MyBlockMover();
        try {
            messenger = new MessengerImpl();
            messenger.subscribe(this, getSubscriberName());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void initUI() {
        setLayout(null);
        setVisible(true);
        setSize(315,590);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 300, 550);
        panel.setLayout(null);

        backgroundLabel = new JLabel();
        backgroundLabel.setIcon(new ImageIcon("src/image/tetris.png"));
        backgroundLabel.setBounds(0, 0, 300, 550);
        
        panel.add(backgroundLabel);
        setContentPane(panel);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
    	super.paint(g);
    	renderer.draw(g, block);
    }
    
    @Override
    public String getSubscriberName() {
        return subscriberName;
    }

    @Override
    public void receive(Message message) {
        String str = (String) message.getPayload();

        Location changedLocation = new Location();
        if (str.equals("Right")) {
            changedLocation.setX(speed);
            changedLocation.setY(0);
            mover.move(block, changedLocation);
            repaint();
        } else if (str.equals("Left")) {
            changedLocation.setX(-speed);
            changedLocation.setY(0);
            mover.move(block, changedLocation);
            repaint();
        } else if (str.equals("Up")) {
            changedLocation.setX(0);
            changedLocation.setY(-speed);
            mover.move(block, changedLocation);
            repaint();
        } else if (str.equals("Down")) {
            changedLocation.setX(0);
            changedLocation.setY(speed);
            mover.move(block, changedLocation);
            repaint();
        } else if (str.equals("Faster")) {
            speed = speed + 10;
        } else if (str.equals("Slower")) {
            speed = speed - 10;
        } else if (str.equals("Rotate")) {
            myblock.Rotate();
            repaint();
        }

    }

    @Override
    public void receive(String[] topics) {
        // TODO Auto-generated method stub

    }
}
