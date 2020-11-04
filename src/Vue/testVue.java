package Vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class testVue {

    public testVue() {
        JFrame jf = new JFrame("Gestion Guagamole");    //创建一个JFrame对象
        jf.setBounds(300, 100, 400, 200);    //设置窗口大小和位置     

        JPanel jp = new JPanel();    //创建一个JPanel对象
        JLabel jl = new JLabel("Menu");    //创建一个标签
        jp.setBackground(Color.white);    //设置背景色
        jp.add(jl);    //将标签添加到面板
        jf.add(jp, BorderLayout.NORTH);

        JPanel cards = new JPanel(new CardLayout());    //卡片式布局的面板

        JPanel jp1 = new JPanel();
        JButton btn1 = new JButton("Effectuer une réservation");    //创建按钮
        JButton btn2 = new JButton("Consulter mes réservations");
        jp1.add(btn1);
        jp1.add(btn2);
        jf.add(jp1, BorderLayout.CENTER);

        JPanel jp2 = new JPanel();
        JButton btn3 = new JButton("Réserver pour un TP");
        JButton btn4 = new JButton("Réserver une machine libre");
        jp2.add(btn3);
        jp2.add(btn4);

        cards.add(jp1, "card1");    //向卡片式布局面板中添加面板1
        cards.add(jp2, "card2");    //向卡片式布局面板中添加面板2
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "card1");    //调用show()方法显示面板2
        jf.add(cards);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn1) {
                    cl.show(cards, "card2");
                }
            }
        });
        
        jf.setVisible(true);    //设置窗口可见
    }

    public static void main(String[] args) {
        new testVue();
    }
}
