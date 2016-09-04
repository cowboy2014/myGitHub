package study.developMode.observer.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by hadoop on 2016/9/4.
 */
public class SwingObserver {
    JFrame frame ;
    public static void main(String[] args) {
        SwingObserver swingObserver = new SwingObserver();
        swingObserver.go();
    }

    public void go(){
        frame = new JFrame();

        JButton button = new JButton("Should I do?");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
        frame.getContentPane().add(BorderLayout.CENTER,button);
        frame.setVisible(true);
        System.out.println("你给出回答了吗");
    }

    class AngelListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("我是天使");
        }
    }

    class DevilListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("我是恶魔");
        }
    }
}
