import java.awt.Color;
import static java.lang.Math.*;

public class Bullet extends Person {
	//Member variables
	private static int size	= 4;
	private int speed	= 10;
	private static Color color = Color.ORANGE;
	private float xpd=0,ypd=0;
	private float pX=0,pY=0;
	//Constructor
	public Bullet(int xPos, int yPos, int endX, int endY) {
		super(xPos, yPos, size, color);
		float dist = (float)sqrt((pow(xPos-endX,2)+pow(yPos-endY,2)));
		xpd = (xPos-endX)*speed/dist;
		ypd = (yPos-endY)*speed/dist;
		pX = xPos;
		pY = yPos;
		setSpeed(speed);
		setyDir(-1);
	}
	public void update(){
		pX-=xpd;
		pY-=ypd;
		super.setxPos((int)pX);
		super.setyPos((int)pY);
	}
	
	public boolean isOffscreen() {
		return getyPos() < 0;
	}
	public float[] getInfo(){
		float[] info = {pX,pY,xpd,ypd};
		return info;
	}
}