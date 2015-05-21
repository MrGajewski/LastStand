import java.awt.Color;
import java.awt.event.KeyEvent;


public class Hero extends Person {
	//Member variable section
	public static int 	LEFT	= KeyEvent.VK_A,
						RIGHT	= KeyEvent.VK_D,
						UP		= KeyEvent.VK_W,
						DOWN	= KeyEvent.VK_S,
						BURST	= KeyEvent.VK_SHIFT,
						RELOAD 	= KeyEvent.VK_R;
	private int magazine = 10;
	private int ammo = 120;
	private int MAXAMMO = 120;
	public int getMAXAMMO() {
		return MAXAMMO;
	}

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
