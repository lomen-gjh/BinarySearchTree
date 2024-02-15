
public class BSTree {
    Node root;
    BSTree(){
        root=null;
    }

    void insert(int x, int y, int d){
        if (root!=null)
            root.insert(d);
        else
            root=new Node(x,y,d);
    }
    Node delete(int val){
        if (root!=null){
            if (root.getData()!=val){
                root.delete(val);
            }
            else {
                //FINISH: what happens when we delete ROOT
                //if prava strana => minimum na pravej


                //if lava, => maximum na pravej
                return null;
            }
        }
        return null;

    }

    public static void main(String args[]){
        BSTree tree=new BSTree();
        Integer[] values= {50,75,62,80,65,70,68};
        for (Integer i:values){
            tree.insert(1,1,i);
        }
        tree.root.inorder();
        tree.root.delete(75);
        System.out.println();
        tree.root.inorder();
        System.out.println();
        tree.root.preorder();





    }
}
