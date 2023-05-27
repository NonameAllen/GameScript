package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class EldenRing {

	private static Robot robot;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();

		try {
			robot = new Robot();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// 是否执行完一个后，再执行下一个
		// 设置为 true, 表示按添加事件的顺序执行（执行完一个再执行下一个）
//        robot.setAutoWaitForIdle(Boolean.TRUE);
		// 移动鼠标到屏幕中央
		// 睡眠指定的时间, 相当于 Thread.sleep(long ms) ,此处传的是int
		// robot.delay(1000);
		// 在生成一个事件后，自动睡眠500毫秒
		robot.setAutoDelay(500);

		// 点击到eldenRing界面
		robot.delay(2000);
		robot.mouseMove(270, 306);
		robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
		robot.delay(500);
		// 释放鼠标左键（按下后必须要释放, 一次点击操作包含了按下和释放）
		robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

		// 打开地图
		for (int i = 0; i < sum; i++) {
			
			robot.keyPress(KeyEvent.VK_G);
			robot.delay(50);
			robot.keyRelease(KeyEvent.VK_G);
			// 打开赐福点预览
			robot.keyPress(KeyEvent.VK_F);
			robot.delay(50);
			robot.keyRelease(KeyEvent.VK_F);

			// 选择到刷钱赐福点并确认
			robot.keyPress(KeyEvent.VK_E);
			robot.delay(50);
			robot.keyRelease(KeyEvent.VK_E);

			robot.keyPress(KeyEvent.VK_E);
			robot.delay(50);
			robot.keyRelease(KeyEvent.VK_E);

			// 等待加载
			robot.delay(5000);

			//吃鸡爪
			/*robot.keyPress(KeyEvent.VK_R);
			robot.delay(50);
			robot.keyRelease(KeyEvent.VK_R);*/
			
			// 走动到刷钱点位置
			robot.keyPress(KeyEvent.VK_W);
			robot.delay(2000);//若吃鸡爪变为3000
			robot.keyPress(KeyEvent.VK_A);
			robot.delay(500);
			robot.keyRelease(KeyEvent.VK_A);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_W);

			// 施放战技
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.mousePress(KeyEvent.BUTTON3_DOWN_MASK);
			robot.delay(50);
			robot.mouseRelease(KeyEvent.BUTTON3_DOWN_MASK);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			
			//等待卢恩到身上
			robot.delay(5000);
			System.out.println(sum-i-1);
		}
	}

	/*
	 * 查看屏幕长宽像素方法
	 */
	public static void getScreen() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screen.width; // 屏幕宽度，以像素为单位
		int height = screen.height; // 屏幕高度
		System.out.println(width);// 运行结果 1280
		System.out.println(height);// 运行结果 720
	}

	/*
	 * 查看鼠标位置方法
	 */
	public static void getMousePosition() {

		Point location = MouseInfo.getPointerInfo().getLocation();
		System.out.println(location);// 运行结果 java.awt.Point[x=550,y=270]
		System.out.println(location.getX());// 运行结果 550
		System.out.println(location.getY());// 运行结果 270

	}

}