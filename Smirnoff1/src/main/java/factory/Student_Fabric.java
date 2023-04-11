/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import creation.Student;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import smirnoff1.NewExcelProvider;


/**
 *
 * @author Alina
 */
public class Student_Fabric implements Polzovatel_Fabric {
    
    NewExcelProvider Provider = new NewExcelProvider("src\\main\\java\\smirnoff1\\ФИО.xlsx");

    @Override
    public Student createNewPolzovatel() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        String Name = null;
        String Surname = null;
        String CompleteName = null;
        
        try {
            this.Provider.loadFile();
            
            int s = random.nextInt(2);  
            if (s == 0) {
                Name = this.Provider.getValues("MaleName");
                Surname = this.Provider.getValues("MaleSurnameSt");

            } else {
                
                Name = this.Provider.getValues("FemaleName");
                Surname = this.Provider.getValues("FemaleSurnameSt");
            }
        
            CompleteName = stringBuilder.append(Name)
                    .append("  ")
                    .append(Surname)
                    .toString();
        
            this.Provider.Close();
        } catch (IOException ex) {
            Logger.getLogger(Student_Fabric.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return new Student(CompleteName);
    }
    
}
    

