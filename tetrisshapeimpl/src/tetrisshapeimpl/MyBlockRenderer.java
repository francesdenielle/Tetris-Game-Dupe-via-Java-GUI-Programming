package tetrisshapeimpl;

import tetrisshapesfx.*;

public class MyBlockRenderer implements Renderer{

	@Override
	public void draw(Object context, MyShape shape) {
		// TODO Auto-generated method stub
		MyBlock myblock = (MyBlock)shape;
		
		Block1 block1 = myblock.getBlock1();
		Block1Renderer block1rend = new Block1Renderer();
		block1rend.draw(context, block1);
		
		Block2 block2 = myblock.getBlock2();
		Block2Renderer block2rend = new Block2Renderer();
		block2rend.draw(context, block2);
		
		Block3 block3 = myblock.getBlock3();
		Block3Renderer block3rend = new Block3Renderer();
		block3rend.draw(context, block3);
		
		Block4 block4 = myblock.getBlock4();
		Block4Renderer block4rend = new Block4Renderer();
		block4rend.draw(context, block4);
		
	}
}
