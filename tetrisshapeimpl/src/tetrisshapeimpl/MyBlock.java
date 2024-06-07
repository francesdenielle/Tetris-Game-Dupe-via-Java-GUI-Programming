package tetrisshapeimpl;

import tetrisshapesfx.Location;
import tetrisshapesfx.MyShape;

public class MyBlock implements MyShape{
	Location location;
	Block1 block1;
	Block2 block2;
	Block3 block3;
	Block4 block4;
	Boolean isRotated;
	
	public MyBlock (Location location, Block1 block1, Block2 block2, Block3 block3, Block4 block4, Boolean isRotated) {
		this.location = location;
		this.block1 = block1;
		this.block2 = block2;
		this.block3 = block3;
		this.block4 = block4;
		this.isRotated = isRotated;
	}

	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	@Override
	public void setLocation(Location location) {
		// TODO Auto-generated method stub
		this.location = location;
	}
	
	public Block1 getBlock1() {
		return block1;
	}
	
	public Block2 getBlock2() {
		return block2;
	}
	
	public Block3 getBlock3() {
		return block3;
	}
	
	public Block4 getBlock4() {
		return block4;
	}
	
	public void Rotate() {
		
	    if (isRotated) { 
	    	Location newlocation = new Location();
			Location newlocation1 = new Location();
			Location newlocation2 = new Location();
			int block1x = block1.getLocation().getX();
			int block1y = block1.getLocation().getY();
			
			newlocation.setX(block1x);
			newlocation.setY(block1y+23);
			block2.setLocation(newlocation);
			
			newlocation1.setX(block1x);
			newlocation1.setY(block1y+46);
			block3.setLocation(newlocation1);
			
			newlocation2.setX(block1x);
			newlocation2.setY(block1y+69);
			block4.setLocation(newlocation2);
	        isRotated = false;
	    } else { 
	    	Location newlocation = new Location();
			Location newlocation1 = new Location();
			Location newlocation2 = new Location();
			int block1x = block1.getLocation().getX();
			int block1y = block1.getLocation().getY();
			
			newlocation.setX(block1x-23);
			newlocation.setY(block1y);
			block2.setLocation(newlocation);
			
			newlocation1.setX(block1x-46);
			newlocation1.setY(block1y);
			block3.setLocation(newlocation1);
			
			newlocation2.setX(block1x-69);
			newlocation2.setY(block1y);
			block4.setLocation(newlocation2);
	        isRotated = true;
	    }
	}
	  
}
