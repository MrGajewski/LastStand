import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main extends Window {
	private static final long serialVersionUID = 1L;
    private String message = "Hello window!";

    private Person hero;
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    private static Cursor c = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);

    //Constructor
    public Main() {
		super();
		
		BG_COLOR = Color.DARK_GRAY;
		WIDTH = 1600;
		HEIGHT = 848;
		setCursor(c);
		
		hero = new Hero(200, 600, 10, Color.CYAN);
    }

    //Methods Section
    public void update() {
    	hero.update();
    	for(int i = 0; i < bullets.size(); i++) {
    		Bullet b = bullets.get(i);
    		b.update();
    		if( b.isOffscreen()==true) {
    			bullets.remove(b);
    			i--;
    		}
    	}
    	for(int j=0;j<zombies.size();j++){
    		Zombie z  = zombies.get(j);
    		z.update(hero.getxPos(), hero.getyPos());
    		boolean hit = false;
    		for(int i=0;i<bullets.size();i++){
    			Bullet b = bullets.get(i);
    			if(z.hit(b.getInfo())){
    				hit = true;
    			}
    		}
    		if(hit){
    			zombies.remove(j);
    		}
    	}
    }

    public void paint(Graphics g) {
		super.paint(g);
		
        g.setColor(Window.FONT_COLOR);
        g.drawString(message, 20, 20);
        
        message = hero.getMagazine() + " / " + hero.getAmmo();
        hero.paint(g);
    	for(Bullet b : bullets) {
    		b.paint(g);
    	}
    	for(Zombie z : zombies) {
    		z.paint(g);
    	}
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == Hero.LEFT)
            hero.setxDir(-1);
        else if (keyCode == Hero.RIGHT)
            hero.setxDir(1);
        else if (keyCode == Hero.UP)
        	hero.setyDir(-1);
        else if (keyCode == Hero.DOWN)
        	hero.setyDir(1);
        else if (keyCode == Hero.BURST)
        	hero.setBurst(true);
        else if (keyCode == KeyEvent.VK_Z) {
        	if (hero instanceof Hero) hero = new Zombie(hero.getxPos(), hero.getyPos());
        	else hero = new Hero(200, 600, 10, Color.CYAN);
        	//Temp fix to make zombies have no ammo so they can not shoot
        	hero.setAmmo(0);
        	hero.setMagazine(0);
        }
        if(keyCode == Hero.RELOAD){
        	hero.reload();
        }
        if(keyCode == 'C'){
        	zombies.add(new Zombie(0,0));
        }
        	
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == Hero.LEFT || keyCode == Hero.RIGHT)
            hero.setxDir(0);
        else if (keyCode == Hero.UP || keyCode == Hero.DOWN)
            hero.setyDir(0);
        else if (keyCode == Hero.BURST)
        	hero.setBurst(false);
    }

	public void mouseReleased(MouseEvent e) {
    	if(hero.getMagazine() >= 1){
		bullets.add(new Bullet(hero.getxPos(), hero.getyPos(), e.getX(), e.getY()));
		//message = "(" + e.getX() + ", " + e.getY() + ")";
    	hero.setMagazine(hero.getMagazine() -1);
    	}
	}

     public static void main(String args[]) {
    	Main window = new Main();
        JFrame jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(30, 30, WIDTH + 20, HEIGHT + 40);
        jframe.getContentPane().add(window);
        jframe.setVisible(true);
        window.start();
    }
}