package teamProject.block;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import teamProject.frame.MainFrame;

public class Block1 extends JLabel{
	
	MainFrame main;
	
	// 이미지
	private ImageIcon block;
	
	// 위치
	private int blockX;
	private int blockY;

	public Block1(MainFrame main) {
		initData();
		setInitLayout();
	}

	private void initData() {
		block = new ImageIcon("images/target.png");
		blockX = 800;
		blockY = 400;
		
	}

	private void setInitLayout() {
		setIcon(block);
		setLocation(blockX, blockY);
		setSize(50, 50);
		
	}
}
