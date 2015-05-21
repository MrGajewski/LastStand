import java.awt.Color;
import java.awt.Graphics;


public class Person {
	//Member variable section
	private int		xPos		= 0,
					yPos		= 0,
					xDir		= 0,
					yDir		= 0,
					size		= 0,
					speed		= 0,
					baseSpeed	= 5,
					burstSpeed	= 8;
	private Color	color		= Color.WHITE;
	private int magazine = 10;
	private int ammo = 120;
	private int MAXAMMO = 120;
	
	//Constructor
	public Person() {
		
	}
	
	public Person(int xPos, int yPos, int size, Color color) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.size = size;
		this.color = color;
		speed = baseSpeed;
	}
	
	//Methods section
	public void update() {
		xPos += speed * xDir;
		yPos += speed * yDir;
	}
	
	public Graphics paint(Graphics g) {
		g.setColor(color);
		g.fillRect(xPos, yPos, size, size);
		
		return g;
	}
	
	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public int getBaseSpeed() {
		return baseSpeed;
	}

	public int getBurstSpeed() {
		return burstSpeed;
	}

	public void setxDir(int xDir) {
		if(xDir >= -1 && xDir <= 1)
			this.xDir = xDir;
	}

	public void setyDir(int yDir) {
		if(yDir >= -1 && yDir <= 1)
			this.yDir = yDir;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public void setBurst(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public void reload(){
		if(ammo >= 10){
		magazine = 10;
		ammo -= 10;
		}
	}
	public int getMagazine() {
		return magazine;
	}

	public void setMagazine(int magazine) {
		this.magazine = magazine;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}


}

