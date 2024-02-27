import javax.swing.*;
import AdelsonVelskiLandis.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AVLGUI extends JFrame implements ActionListener {
    JPanel north, center;
    JButton insert, delete;
    JTextField newNodeValue;
    AVL avl;
    AVLGUI(){
        avl=new AVL();
        setTitle("AVL GUIIIII");
        setSize(600,400);
        setLayout(new BorderLayout());

        north=new JPanel();
        this.add(north, BorderLayout.NORTH);
        insert=new JButton("insert");
        north.add(insert);
        insert.addActionListener(this);
        newNodeValue=new JTextField(5);
        north.add(newNodeValue);
        delete=new JButton("Delete");
        north.add(delete);
        delete.addActionListener(this);

        center=new JPanel();
        this.add(center, BorderLayout.CENTER);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        AVLGUI avlgui=new AVLGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==insert){
            try{
                avl.insert(Integer.parseInt(newNodeValue.getText()));
                avl.drawAVL(center.getGraphics(),300,200);
            }
            catch (NumberFormatException err){
                System.out.println("Numeric value required.");
            }
        }
        if (e.getSource()==delete){
            try{
                avl.delete(Integer.parseInt(newNodeValue.getText()));
                avl.drawAVL(center.getGraphics(),300,200);
            }
            catch (NumberFormatException err){
                System.out.println("Numeric value required.");
            }
        }
    }
}
