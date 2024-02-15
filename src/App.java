import binaryNoParent.BSTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {
    JPanel north, center;
    JButton insert, delete;
    TextField value;
    BSTree tree;


    App(){
        tree=new BSTree();
        setTitle("App");
        setSize(600,600);
        setLayout(new BorderLayout());

        north = new JPanel();
        add(north, BorderLayout.NORTH);

        value=new TextField(5);
        insert=new JButton("Insert");
        delete=new JButton("Delete");
        insert.addActionListener(this);
        delete.addActionListener(this);

        north.add(insert); north.add(delete); north.add(value);

        center=new JPanel();
        add(center, BorderLayout.CENTER);

        setVisible(true);
        setResizable(false);


    }

    public static void main(String [] args){
        App a=new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==insert){
            tree.insert(300,50,Integer.parseInt(value.getText()));
            tree.drawTree(300,50,center.getGraphics());
        }

        if (e.getSource()==delete){
            tree.delete(Integer.parseInt(value.getText()));
            center.getGraphics().clearRect(0,0,600,600);
            tree.drawTree(300,50,center.getGraphics());

        }
    }
}
