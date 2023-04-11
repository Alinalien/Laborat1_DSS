/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smirnoff1;

import creation.Student;
import creation.Knigi;
import creation.Prepod;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

/**
 *
 * @author Alina
 */
public class Library {
    
    public ArrayList<Knigi> kniga = new ArrayList<>();
    public ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Prepod> prepods = new ArrayList<>();
    
    public MutableTreeNode getSudentNodes() {
        DefaultMutableTreeNode studentnodes = new DefaultMutableTreeNode(" Студенты ");
        for (Student student : students) {
            studentnodes.add(student.getNode());
        }
        return studentnodes;
    }

    public MutableTreeNode getPrepodNodes() {
        DefaultMutableTreeNode professornodes = new DefaultMutableTreeNode(" Профессура ");
        for (Prepod prepod : prepods) {
            professornodes.add(prepod.getNode());
        }
        return professornodes;
    }
    
}
