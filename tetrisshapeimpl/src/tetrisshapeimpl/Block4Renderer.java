package tetrisshapeimpl;

import java.awt.Graphics;

import tetrisshapesfx.MyShape;
import tetrisshapesfx.Renderer;

public class Block4Renderer implements Renderer{

	@Override
	public void draw(Object context, MyShape shape) {
		// TODO Auto-generated method stub
		 Graphics g = (Graphics) context;
		 Block4 block = (Block4) shape;
		 int dx = block.getLocation().getX();
		 int dy = block.getLocation().getY();
		 int x = block.getX();
		 int y = block.getY();
		 
		 //for fill
		 g.setColor(block.getFill());
		 g.fillRect(dx, dy, x, y);
		 
		//for outline
		 g.setColor(block.getOutline());
		 g.drawRect(dx, dy, x, y);
	}

}
