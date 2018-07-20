package com.renory.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author smit
 */
public class TranslitUtil {
    private static final String[] ru={
    "А",
    "Б",
    "В",
    "Г",
    "Д",
    "Е",
    "Ё",
    "Ж",
    "З",
    "И",
    "Й",
    "К",
    "Л",
    "М",
    "Н",
    "О",
    "П",
    "Р",
    "С",
    "Т",
    "У",
    "Ф",
    "Х",
    "Ц",
    "Ч",
    "Ш",
    "Щ",
    "Ъ",
    "Ы",
    "Ь",
    "Э",
    "Ю",
    "Я",
    "І",
    "Ї",
    "Є",
    ",",
    ".",
    "-",
    " ",
    "_",
    "0",
    "1",
    "2",
    "3",
    "4",
    "5",
    "6",
    "7",
    "8",
    "9"
    };
    
    private static final String[] eng={
    "A",
    "B",
    "V",
    "G",
    "D",
    "E",
    "E",
    "G",
    "Z",
    "I",
    "I",
    "K",
    "L",
    "M",
    "N",
    "O",
    "P",
    "R",
    "S",
    "T",
    "U",
    "F",
    "H",
    "C",
    "CH",
    "SH",
    "SH",
    "",
    "I",
    "",
    "E",
    "YU",
    "YA",
    "I",
    "I",
    "E",
    "_",
    "_",
    "-",
    "_",
    "_",
    "0",
    "1",
    "2",
    "3",
    "4",
    "5",
    "6",
    "7",
    "8",
    "9"
    };

    public static String convert(String str){
        String trans="";
        
        str = cleanString(str);
        
        String[] string = new String[str.length()];
        
        char oneChar[] = str.toCharArray();
        for (int i=0; i<oneChar.length; i++){
            String conv = "" +oneChar[i];
            string[i] = conv;
        }
        

        for (int i=0; i<string.length; i++){
            if (isCirikic(string[i])){
                for (int y=0; y<ru.length; y++){
                    if (string[i].equalsIgnoreCase(ru[y])){
                        trans += eng[y];
                        break;
                    }
                }
            } else {
                trans += string[i];
            }
        }
        
        return trans.toLowerCase();
    }

    private static boolean isCirikic(String charOne) {
        for (int i=0; i<ru.length; i++){
            if (ru[i].equalsIgnoreCase(charOne)){
                return true;
            }
        }
        return false;
    }

    public static void printTestChars() {
        for (int i=0; i<ru.length; i++){
            System.out.println(ru[i] + " " + eng[i]);
        }
    }
    
    private static String cleanString(String str) {
        String[] string = new String[str.length()];
        
        char one[] = str.toCharArray();
        for (int i=0; i<one.length; i++){
            String conv = "" +one[i];
            string[i] = conv;
        }
        
        String validChars = "";
        
        for (int i=0; i<string.length; i++){
            String oneChar = string[i];
            if (checkValidSymbol(oneChar)){
                validChars += oneChar;
            }
        } 
        
        return validChars;
    }
    
    private static boolean checkValidSymbol(String oneChar){  
        Pattern p = Pattern.compile("^[а-яА-ЯёЁa-zA-Z0-9 ]+$");  
        Matcher m = p.matcher(oneChar);  
        return m.matches();  
    }  

    

}
