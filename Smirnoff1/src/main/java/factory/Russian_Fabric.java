/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import creation.Knigi;
import creation.Russian_Fic;
import creation.Russian_TxtBook;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import smirnoff1.NewExcelProvider;

/**
 *
 * @author Alina
 */
public class Russian_Fabric implements Knigi_Fabric {
    NewExcelProvider Provider = new NewExcelProvider("src\\main\\java\\smirnoff1\\Russian_Knigi.xlsx");

    
    
    @Override
    public Knigi MakeTxtBook() {
        StringBuilder stringBuilder = new StringBuilder();
        String CompleteName = null;
        String Type = null;
        String Predmet = null;
        
        try {
            this.Provider.loadFile();
            Type = Provider.getValues("Type");
            Predmet = Provider.getValues("Predmet");
            this.Provider.Close();
        } catch (IOException ex) {
            Logger.getLogger(English_Fabric.class.getName()).log(Level.SEVERE, null, ex);
        }
        CompleteName = stringBuilder.append(Type)
                .append(" по ")
                .append(Predmet)
                .toString();
        return new Russian_TxtBook(CompleteName);
    }
    
    
    @Override
    public Knigi MakeFic() {
        
        String CompleteName = null;
        Random random = new Random();
        String FirstWord = null;
        String SecondWord = null;
        StringBuilder stringBuilder = new StringBuilder();
        int index1 = random.nextInt(2);
        
        try {
            this.Provider.loadFile();
            
            if (index1 == 0) {
                CompleteName = this.Provider.getValues("CompleteName");

            } else {
                FirstWord = this.Provider.getValues("FirstWord");
                SecondWord = this.Provider.getValues("SecondWord");
                
                CompleteName = stringBuilder.append(FirstWord)
                        .append(" ")
                        .append(SecondWord)
                        .toString();
            }
            this.Provider.Close();
        } catch (IOException ex) {
            Logger.getLogger(English_Fabric.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Russian_Fic(CompleteName);
    }

}
    

