package AdelsonVelskiLandis;

import java.awt.*;

public class AVL {
    public Node root;
    public AVL(){
        root=null;
    }

    public void insert(int data){
        if (root==null)
            root=new Node(data);
        else
            root.insert(data,null); //placeholder
    }
    public void drawAVL(Graphics g, int x, int y){
        g.clearRect(0,0,600,400);
        if (root!=null){
            root.drawNode(g,x,y);
        }
    }
}
