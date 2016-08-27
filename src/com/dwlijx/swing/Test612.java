package com.dwlijx.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test612 extends JFrame{
 private static final int WIDTH=500;
 private static final int HEIGHT=400;
 private static JLabel label[] = {new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()};
 private static JTextField field[] = {new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField()};
 public JTabbedPane p=new JTabbedPane();
 public static JPanel pane=new JPanel();
 private static  void jlabelJTextField(){
 for(int i=0;i<5;i++){
  label[i]=new JLabel();
  field[i]=new JTextField(10);
  pane.add(label[i]);
  //pane.add(field[i]);
 }
 label[0].setText("姓名");
 label[1].setText("性别");
 label[2].setText("年龄");
 label[3].setText("出生年月");
 label[4].setText("家庭地址");
 
 }
 public Test612(){
  
  super("面板综合测试窗口");
  super.setContentPane(p);
  super.setSize(WIDTH,HEIGHT);
  super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  p.addTab("pane", pane);
  p.setEnabledAt(0,true);
  p.setTitleAt(0, "基本信息");
  jlabelJTextField();
  GridBagLayout lay=new GridBagLayout();
  pane.setLayout(lay);

  GridBagConstraints constraints=new GridBagConstraints();
  constraints.fill=GridBagConstraints.NONE;
  constraints.anchor=GridBagConstraints.EAST;
  constraints.weightx=2;
  constraints.weighty=4;
  
  add(label[0],constraints,0,0,1,1);
  add(label[1],constraints,0,1,1,1);
  add(label[2],constraints,0,2,1,1);
  add(label[3],constraints,0,3,1,1);
  add(label[4],constraints,0,4,1,1);
  add(field[0],constraints,1,0,1,1);
  add(field[1],constraints,1,1,1,1);
  add(field[2],constraints,1,2,1,1);
  add(field[3],constraints,1,3,1,1);
  add(field[4],constraints,1,4,1,1);
  super.setVisible(true);
 }
 public static void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h){
  //此方法用来添加控件到容器中
  constraints.gridx=x;
  constraints.gridy=y;
  constraints.gridwidth=w;
  constraints.gridheight=h;
  pane.add(c,constraints);
}
 public static void main(String args[]){
  try
  {
   new Test612();
  }catch(Exception e){
   e.printStackTrace();
  }
 }

}