/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smirnoff1;

import creation.Prepod;
import creation.Student;
import factory.English_Fabric;
import factory.Prepod_Fabric;
import factory.Russian_Fabric;
import factory.Student_Fabric;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Alina
 */
public class DataManipulator {
    Library libr;
    
    public void createData(int quantityOfStudents, int quantityOfProfessors) {
        libr = new Library();
        
        English_Fabric EF = new English_Fabric();
        Russian_Fabric RF = new Russian_Fabric();
        
        for (int i = 0; i < 22; i++) {
            libr.kniga.add(EF.MakeTxtBook());
            libr.kniga.add(EF.MakeFic());
            libr.kniga.add(RF.MakeTxtBook());
            libr.kniga.add(RF.MakeFic());
        }
        
        Student_Fabric SF = new Student_Fabric();
        Prepod_Fabric PF = new Prepod_Fabric();
        
        for (int i = 0; i < quantityOfStudents; i++) {
            Student student = SF.createNewPolzovatel();
            student.TakeKniga(libr.kniga);
            libr.students.add(student);
        }
        for (int i = 0; i < quantityOfProfessors; i++) {
            Prepod prepod = PF.createNewPolzovatel();
            prepod.TakeKniga(libr.kniga);
            libr.prepods.add(prepod);

        }

    }

    public TreeNode addInfotoGUI() {
        DefaultMutableTreeNode main = new DefaultMutableTreeNode(" Пользователи библиотеки ");
        main.add(libr.getSudentNodes());
        main.add(libr.getPrepodNodes());
        return main;
    }
}
