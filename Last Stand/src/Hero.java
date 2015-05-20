import java.awt.Color;
import java.awt.event.KeyEvent;


public class Hero extends Person {
	//Member variable section
	public static int 	LEFT	= KeyEvent.VK_A,
						RIGHT	= KeyEvent.VK_D,
						UP		= KeyEvent.VK_W,
						DOWN	= KeyEvent.VK_S,
						BURST	= KeyEvent.VK_SHIFT;

	public Hero(int xPos, int yPos, int size, Color color) {
		super(xPos, yPos, size, color);
	}
	
	public void setBurst( boolean isBursting ) {
		if(isBursting == true) {
			setSpeed( getBurstSpeed() );
		} else {
			setSpeed( getBaseSpeed() );
		}
	}
}
