package tetrisshapeimpl;

import tetrisshapesfx.*;

public class MyBlockMover extends Mover{
	public void move(MyShape shape, Location changeLocation)
	{
		Mover mover = new Mover();
		
		MyBlock block = (MyBlock)shape;
		super.move(block, changeLocation);
		
		Block1 block1 = block.getBlock1();
		mover.move(block1, changeLocation);
		
		Block2 block2 = block.getBlock2();
		mover.move(block2, changeLocation);
		
		Block3 block3 = block.getBlock3();
		mover.move(block3, changeLocation);
		
		Block4 block4 = block.getBlock4();
		mover.move(block4, changeLocation);
		
	}
}

