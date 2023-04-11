/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import creation.English_TxtBook;
import creation.English_Fic;
import creation.Knigi;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import smirnoff1.NewExcelProvider;

/**
 *
 * @author Alina
 */
public class English_Fabric implements Knigi_Fabric {
    
    NewExcelProvider Provider = new NewExcelProvider("src\\main\\java\\smirnoff1\\English_Knigi.xlsx");

    @Override
    public Knigi MakeTxtBook() {
        String Subject = null;
        String Institute = null;
        String Author = null;
        String Degree = null;
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        
        int randDegree = random.nextInt(2);
        if (randDegree == 0) {
            Degree = "Бакалаврский уровень";
        } else {
            Degree = "Магистерский уровень";
        }

        String CompleteName = null;
        try {
            this.Provider.loadFile();
            Subject = this.Provider.getValues("Subject");
            Institute = this.Provider.getValues("Institute");
            Author = this.Provider.getValues("Author");
            
            CompleteName = stringBuilder.append(Subject)
                    .append("; ")
                    .append(Institute)
                    .append("; ")
                    .append(Author)
                    .append("; ")
                    .append(Degree)
                    .toString();
            this.Provider.Close();
        } catch (IOException ex) {
            Logger.getLogger(English_Fabric.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new English_TxtBook(CompleteName);
    }

    @Override
    public Knigi MakeFic() {
        String CompleteName2 = null;
        Random random = new Random();
        String FirstWord2 = null;
        String SecondWord2 = null;
        StringBuilder stringBuilder = new StringBuilder();
        
        int index2 = random.nextInt(2);
        try {
            this.Provider.loadFile();
            
            if (index2 == 0) {
                CompleteName2 = this.Provider.getValues("CompleteName2");

            } else {
                FirstWord2 = this.Provider.getValues("FirstWord2");
                SecondWord2 = this.Provider.getValues("SecondWord2");
                
                CompleteName2 = stringBuilder.append(FirstWord2)
                        .append(" ")
                        .append(SecondWord2)
                        .toString();
            }
            this.Provider.Close();
        } catch (IOException ex) {
            Logger.getLogger(English_Fabric.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new English_Fic(CompleteName2);
       
    }
    
    }

