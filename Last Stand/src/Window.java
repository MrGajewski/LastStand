import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Window extends JPanel implements Runnable, KeyListener, MouseListener {
	private static final long serialVersionUID = 1L;
	//Member Variables Section
    Thread thread = null;
    static int sleepTime = 33;
    
    public static int WIDTH = 500;
    public static int HEIGHT = 600;
    public static Color BG_COLOR = Color.BLACK;
    public static Color FONT_COLOR = Color.WHITE;
    public static String FONT_FACE = "Arial";
    public static int FONT_STYLE = Font.PLAIN;
    public static int FONT_SIZE = 18;

    //Constructor
    public Window() {
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
    }

    //Methods Section
    public void update() {
    }

    public void paint(Graphics g) {
        g.setColor(BG_COLOR);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        g.setFont(new Font(FONT_FACE, FONT_STYLE, FONT_SIZE));
    }

    public void keyPressed(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        thread = null;
    }

    public void run() {
        while (thread != null) {
            try {
                Thread.sleep(sleepTime);
            }
            catch (InterruptedException e) {}
            update();
            repaint();
        }
        thread = null;
    }

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}