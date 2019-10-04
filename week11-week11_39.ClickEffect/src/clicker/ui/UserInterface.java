package clicker.ui;

import clicker.applicationlogic.Calculator;
import clicker.applicationlogic.PersonalCalculator;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calculator;

    public UserInterface(){
        this.calculator = new PersonalCalculator();
    }
    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(2,1);
        frame.setLayout(layout);
        JLabel label = new JLabel("0");
        JButton button = new JButton("Click!");
        ClickListener listener = new ClickListener(this.calculator, label);
        button.addActionListener(listener);
        container.add(label);
        container.add(button);
    }

    public JFrame getFrame() {
        return frame;
    }
}

