package tetrisshapeimpl;

import java.awt.Color;

import tetrisshapesfx.Location;
import tetrisshapesfx.MyShape;

public class Block4 implements MyShape {
	private Location location;
	private int x;
	private int y;
	private Color fill;
	private Color outline;
	
	public Block4 (Location location, int x, int y, Color fill, Color outline) {
		this.location = location;
		this.x = x;
		this.y = y;
		this.fill = fill;
		this.outline = outline;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Color getFill() {
		return fill;
	}
	public Color getOutline() {
		return outline;
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
}