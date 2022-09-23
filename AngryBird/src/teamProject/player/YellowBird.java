package teamProject.player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import teamProject.frame.MainFrame;
import teamProject.interfaces.Moveable;

public class YellowBird extends JLabel implements Moveable {
	MainFrame main;

	// 위치상태
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean move;
	private boolean down;

	// 속도 상태
	private final int SPEED = 4;

	// 이미지
	private ImageIcon player;

	// 생성
	public YellowBird(MainFrame main) {
		this.main = main;
		initData();
		setInitLayout();

	}

	// 초기
	private void initData() {
		player = new ImageIcon("player.png");
		x = 180;
		y = 530;
		move = false;

	}

	private void setInitLayout() {
		setIcon(player);
		setLocation(x, y);
		setSize(80, 65);
	}

	public void move() {
		move = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				// while (move) {
				// 기울기
				double a = main.getPressX() - main.getReleaseX();
				double b = main.getPressY() - main.getReleaseY();
				int c = ((Number) Math.sqrt((a * a) + (b * b))).intValue();

				double slope = (b / a);
//						System.out.println(slope);
				if (slope == -1) {
					System.out.println("기울기 -1 이다 " + slope);
					System.out.println("빗변의 길이 : " + c);
					for (int i = 0; i < c; i++) {
						// System.out.println("dfas");
						x += 1;
						y -= 1;
						setLocation(x, y);
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
					for (int j = 0; j < c; j++) {
						// System.out.println("dfas");
						x += 1;
						y += 1;
						setLocation(x, y);
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				} else if (slope < -1) {
					System.out.println("기울기 -1보다 작 다  " + slope);
					System.out.println("빗변의 길이 : " + c);
					for (int i = 0; i < c; i++) {
						// System.out.println("dfas");
						x += 1;
						y -= 2;
						setLocation(x, y);
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int j = 0; j < c; a++) {
						// System.out.println("dfas");
						x += 1;
						y += 2;
						setLocation(x, y);
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} else if (slope > -1) {
					System.out.println("기울기 -1보다 크다  " + slope);
					System.out.println("빗변의 길이 : " + c);
					for (int i = 0; i < c; i++) {
						// System.out.println("dfas");
						x += 2;
						y -= 1;
						setLocation(x, y);
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int j = 0; j < c; j++) {
						// System.out.println("dfas");
						x += 2;
						y += 1;
						setLocation(x, y);
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

			}
		}).start();
	}

}