package com.dwlijx.mouseClick;

import java.awt.*;
import java.awt.event.*;

public class Util extends Thread{
	Robot rb;
	boolean flag;
	int time;
	
	public Util(){
		try {
			rb = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag = false;
	}
	public void run(){
		while(flag == true){
			try {
				sleep(time*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rb.mousePress(InputEvent.BUTTON1_MASK);
			rb.mouseRelease(InputEvent.BUTTON1_MASK);
		}
	}
	public void go(boolean flag, int time){
		this.flag = flag;
		this.time = time;
	}
}
