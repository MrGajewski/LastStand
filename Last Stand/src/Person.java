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
	private final int MAXAMMO = 120;
	
	public int getMAXAMMO() {
		return MAXAMMO;
	}

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
	
	public boolean hit(float[] bInfo){//bInfo is xpos, ypos, xspeed, yspeed
		float bx=bInfo[0],by=bInfo[1],xpd=bInfo[2],ypd=bInfo[3];
        int sx = (int)bx,sy=(int)by,ex=(int)(bx+xpd),ey=(int)(by+ypd);
        //print("shot in your area " + commu.getAddr());
        /*float PX = xPos,PY=yPos;
        double opme = angleBP(sx,sy,(int)PX,(int)PY);
        double shotang = angleBP(sx,sy,ex,ey);
        //println(" difang " + opme + " ashot" + shotang);
        double angle = min(min(abd(opme-shotang),abd(opme+(2*Math.PI)-shotang)),abd(opme-((2*Math.PI)+shotang)));
        double distance = DBP((int)PX,(int)PY,sx,sy)*Math.sin((float)angle);
        //println("distance to bullet path " + distance + " angle " + angle + " hyp " + DBP((int)PX,(int)PY,sx,sy));
        if(distance<10){
        	return true; 
        }
        return false;*/
        if((sx>xPos && sx < xPos+size) || (ex>xPos && ex< xPos+size)){
        	if((sy>yPos && sy < yPos+size) || (ey>yPos && ey< yPos+size)){
            	return true;
            }
        }
        return false;
     }
	 private double angleBP(int cx, int cy, int ex, int ey){
	    //println("dy " + (ey-cy) + " dx " + (ex-cx) + " dy/dx " + (((float)ey-cy)/(ex-cx)));  
	   return Math.atan2(((float)ey-cy),((float)ex-cx));
	 }
	 double DBP(int sx, int sy, int ex, int ey){
		  return Math.sqrt(Math.pow(sx-ex,2)+Math.pow(sy-ey,2)); 
	}
	 double min(double in1, double in2){
	  return ((in1>in2)?in2:in1); 
	}
		double abd(double in){
		  return (in<0)?in*-1:in; 
		}


}

