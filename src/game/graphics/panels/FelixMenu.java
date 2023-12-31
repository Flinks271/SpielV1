package game.graphics.panels;

import game.controller.Playerthroughput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FelixMenu extends JPanel implements ActionListener {
    JComponent[] components;
    CardLayout crd;
    Playerthroughput put;

    public FelixMenu(CardLayout crd, Dimension d, Playerthroughput put){
        this.put = put;
        this.crd = crd;
        components = new JComponent[5];

        components[0] = new JTextField();
        components[1] = new JButton("Spielen");
        components[2] = new JButton("Rekorde");
        components[3] = new JButton("Optionen");
        components[4] = new JButton("Beenden");

        this.setSize(d);
        render();
    }

    public String getInhalt(){
        JTextField temp =(JTextField) components[0];
        return temp.getText();
    }

    public void render(){
        JPanel test = new JPanel();

        this.setLayout(new GridBagLayout());
        Dimension max = new Dimension(350,30);

        BoxLayout boxLayout = new BoxLayout(test, BoxLayout.Y_AXIS);

        for (JComponent k: components) {
            k.setMaximumSize(max);
            k.setPreferredSize(max);
            k.setMinimumSize(max);
            k.setAlignmentX(Component.RIGHT_ALIGNMENT);

            if (k.getClass() == JButton.class){
                k.setName(((JButton) k).getText());
                ((JButton) k).addActionListener(this);
            }


            test.add(k);
            test.add(Box.createRigidArea(new Dimension(0,2)));
        }

        test.setLayout(boxLayout);
        this.add(test);
        this.revalidate();
        this.repaint();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton k =(JButton) e.getSource();
        String name = k.getName();
        if (name.equals("Spielen")){
            put.setWelches(1);
            crd.next(this.getParent());

        }
        if (name.equals("Rekorde")){

        }
        if (name.equals("Optionen")){

        }
        if (name.equals("Beenden")){
            System.exit(0);
        }
    }
}
