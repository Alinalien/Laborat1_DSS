/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import creation.Prepod;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import smirnoff1.NewExcelProvider;

/**
 *
 * @author Alina
 */
public class Prepod_Fabric implements Polzovatel_Fabric {
    
    NewExcelProvider Provider = new NewExcelProvider("src\\main\\java\\smirnoff1\\ФИО.xlsx");

    @Override
    public Prepod createNewPolzovatel() {
        StringBuilder stringBuilder = new StringBuilder();
        String Name = null;
        String Surname = null;
        String Otchestvo = null;
        String CompleteName = null;
        String Ending = null;
        Random random = new Random();
        
        try { 
            this.Provider.loadFile();                               // грузим файл - грузить заранее
            Otchestvo = this.Provider.getValues("Otchestvo");       // считываем отчества

            int s = random.nextInt(1);                              // s - рандомное первое отчество
            if (s == 0) {                                           // сравниваем считанное значение с нулём, то есть, если ячейка не пустая, то смотрим на её окончание, опр пол преподавателя
                Ending = "ич";
                Name = this.Provider.getValues("MaleName");
                Surname = this.Provider.getValues("MaleSurnamePr");

            } else {
                Ending = "на";
                Name = this.Provider.getValues("FemaleName");
                Surname = this.Provider.getValues("FemaleSurnamePr");
            }
        
             CompleteName = stringBuilder.append(Name)
             .append("  ")
             .append(Otchestvo)
             .append(Ending)
             .append("  ")
             .append(Surname)
             .toString();
      
            this.Provider.Close();
        } catch (IOException ex) {
            Logger.getLogger(Prepod_Fabric.class.getName()).log(Level.SEVERE, null, ex);
        }


         return new Prepod(CompleteName);
    }
       
}
        
    

