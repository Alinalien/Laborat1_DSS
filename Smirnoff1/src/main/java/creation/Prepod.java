/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creation;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

/**
 *
 * @author Alina
 */
public class Prepod extends Polzovatel{

    private String CompleteName;
    private ArrayList<Knigi> kniga = new ArrayList<>();
    
    
    public Prepod(String CompleteName) {
       super(CompleteName);
    }

    @Override
    public void TakeKniga(ArrayList<Knigi> kniga) {
        ArrayList<Knigi> kn = new ArrayList<>(kniga);
        
        int quanityofbooks = (int) Math.round(Math.random() * (10 - 3) + 3);
        for (int i = 1; i <= quanityofbooks; i++) {
            int NumberOfKniga = (int) Math.round(Math.random() * (kn.size() - 1));
            this.kniga.add(kn.get(NumberOfKniga));
            kn.remove(NumberOfKniga);
    }
    }
        public MutableTreeNode getNode(){
        DefaultMutableTreeNode Nodes  = new DefaultMutableTreeNode(getCompleteName());
        for (Knigi book : kniga){
            Nodes.add(new DefaultMutableTreeNode(book.getCompleteName()));
        }
        return Nodes;
    }
}

    

   
    

