import java.awt.Color;
import java.util.Random;


public class Zombie extends Person {
	public Zombie(int xPos, int yPos) {
		super();
		Random r = new Random();
		int type = r.nextInt(3);
		if(type == 0) {
			//Big and slow zombie
			setSize(30);
			setSpeed(4);
			setColor( Color.RED );
		} else if(type == 1) {
			//Medium and medium zombie
			setSize(15);
			setSpeed(6);
			setColor( Color.YELLOW );
		} else {
			//Small and fast zombie
			setSize(10);
			setSpeed(7);
			setColor( Color.GREEN );
		}
		setxPos( xPos );
		setyPos( yPos );
	}
	
	public void update(int heroX, int heroY) {
		if( getxPos() > heroX ) {
			setxDir(-1);
		} else if( getxPos() < heroX ) {
			setxDir(1);
		} else {
			setxDir(0);
		}
		if( getyPos() > heroY ) {
			setyDir(-1);
		} else if( getyPos() < heroY ) {
			setyDir(1);
		} else {
			setyDir(0);
		}
		super.update();
	}
	
}
