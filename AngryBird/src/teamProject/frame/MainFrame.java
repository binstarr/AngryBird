package teamProject.frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import teamProject.block.Block1;
import teamProject.player.BlackBird;
import teamProject.player.RedBird;
import teamProject.player.YellowBird;

public class MainFrame extends JFrame {

	private JLabel background;
	private RedBird redBird;
	private YellowBird yellowBird;
	private BlackBird blackBird;
	private Block1 block1;
	private MyMouseAdapter myAdapter;

	private double pressX;
	private double pressY;
	private double releaseX;
	private double releaseY;

	public double getPressX() {
		return pressX;
	}

	public void setPressX(double pressX) {
		this.pressX = pressX;
	}

	public double getPressY() {
		return pressY;
	}

	public void setPressY(double pressY) {
		this.pressY = pressY;
	}

	public double getReleaseX() {
		return releaseX;
	}

	public void setReleaseX(double releaseX) {
		this.releaseX = releaseX;
	}

	public double getReleaseY() {
		return releaseY;
	}

	public void setReleaseY(double releaseY) {
		this.releaseY = releaseY;
	}

	public MainFrame() {
		initData();
		setInitLayout();
		addEventListenr();
	}

	private void initData() {
		setTitle("Angry Bird");
		setSize(1000, 570);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		background = new JLabel(new ImageIcon("images/bg1.png"));
		setContentPane(background);

		redBird = new RedBird(this);
		yellowBird = new YellowBird(this);
		block1 = new Block1(this);
		myAdapter = new MyMouseAdapter();

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);
		add(redBird);
		add(block1);
	}

	private void addEventListenr() {
		addMouseListener(myAdapter);
		addMouseMotionListener(myAdapter);
	}

	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("마우스 누름");
			pressX = ((Number) e.getX()).doubleValue();
			pressY = ((Number) e.getY()).doubleValue();

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			System.out.println("마우스 드래그");
			new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println(123);
					try {
						Thread.sleep(100);
						redBird.setLocation(e.getX() - 80 / 2, e.getY() - 65);

					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}).start();
			;

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			System.out.println("마우스 끝");
			releaseX = ((Number) e.getX()).doubleValue();
			releaseY = ((Number) e.getY()).doubleValue();
			redBird.move();

			add(yellowBird);
			yellowBird.move();

		}

	}

}
