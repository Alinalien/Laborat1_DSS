/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smirnoff1;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Alina
 */
public class NewExcelProvider {
    private File file;
    private XSSFWorkbook wb;
    
    
    public NewExcelProvider(String path) {       // конструктор без входных аргументов, который вызывает метод инициализации
//      init();
//    }
//    private void init() {                      // указываем файл с оценками, который хотим закачивать
//    setFile(new File("Статистика_свод_2022.xlsx"));
//    }
        setFile(path);
      }
    
    private void setFile(String path) {
        this.file = new File(path);
       }
           
     
    public void loadFile()  {                                                             //создание вб из файла
        try {    
            wb = new XSSFWorkbook(file);
        } catch (IOException | InvalidFormatException ex) {                                                        // ошибка чтения файла
             Logger.getLogger(NewExcelProvider.class.getName()).log(Level.SEVERE, null, ex);       
        }
        // ошибка POI, если файл другого формата, не того, который нужен, т.е. не XLSX
 
        
    }
    
    public String getValues(String sheetName) throws IOException {                         // этот метод выдает в качестве результата значение в ячейке
        Random random = new Random();
        XSSFSheet sheet = this.wb.getSheet(sheetName);                                     // считываем имя листа из воркбука
        int RowNumb = random.nextInt(sheet.getLastRowNum() + 1);                           // ввожу переменную RowNumb, которая содержит инфу про количество строк на листе, +1, так как начинаем с 0
        String Value = sheet.getRow(RowNumb).getCell(0).getStringCellValue();              // из первой ячейки получаем информацию о пользователе; и записываем в Value
        return Value;

    }

    public void Close() throws IOException {
        this.wb.close();
    }
    }

 



