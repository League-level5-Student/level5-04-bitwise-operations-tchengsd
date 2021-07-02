package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Base64Decoder {
    /*
     * Base 64 is a way of encoding binary data using text.
     * Each number 0-63 is mapped to a character. 
     * NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE ENCODING!
     * Since the numbers 0 through 63 can be represented using 6 bits, 
     * every four (4) characters will represent twenty four (24) bits of data.
     * 4 * 6 = 24
     * 
     * For this exercise, we won't worry about what happens if the total bits being converted
     * do not divide evenly by 24.
     * 
     * If one char is 8 bits, is this an efficient way of storing binary data?
     * (hint: no)
     * 
     * It is, however, useful for things such as storing media data inside an HTML file (for web development),
     * so that way a web site does not have to look for an image, sound, library, or whatever in a separate location.
     * 
     * View this link for a full description of Base64 encoding
     * https://en.wikipedia.org/wiki/Base64
     */
    
    
    final static char[] base64Chars = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };
    
    //1. Complete this method so that it returns the the element in
    //   the base64Chars array that corresponds to the passed in char.
    public static byte convertBase64Char(char c){
        for(int i = 0; i < base64Chars.length; i++) {
            if(c == base64Chars[i]) {
                return (byte)i;
            }
        }
        return 0;
    }
    
    //2. Complete this method so that it will take in a string that is 4 
    //   characters long and return an array of 3 bytes (24 bits). The byte 
    //   array should be the binary value of the encoded characters.
    public static byte[] convert4CharsTo24Bits(String s) {
        int[] charInts = new int[3];
        byte[] bytes = new byte [3];
        int char1 = (int)convertBase64Char(s.charAt(0));
        int char2 = (int)convertBase64Char(s.charAt(1));
        int char3 = (int)convertBase64Char(s.charAt(2));
        int char4 = (int)convertBase64Char(s.charAt(3));
        charInts[0] = (char1 << 2) + (char2 >> 4);
        charInts[1] = (char2 << 4) + (char3 >> 2);
        charInts[2] = (char3 << 6) + char4;
        for(int i = 0; i < 3; i++) {
            bytes[i] = (byte)charInts[i];
        }
        return bytes;
    }
    
    //3. Complete this method so that it takes in a string of any length
    //   and returns the full byte array of the decoded base64 characters.
    public static byte[] base64StringToByteArray(String file) {
        int byteLength = (file.length() * 3) / 4;
        byte[] bytes = new byte[byteLength];
        ArrayList<Byte> byteList = new ArrayList<Byte>();
        byte[][] convertReturns = new byte[file.length() / 4][3];
        for(int i = 0; i < file.length() / 4; i ++) {
            convertReturns[i] = convert4CharsTo24Bits(file.substring(i * 4, (i * 4) + 4));
        }
        for(int i = 0; i < convertReturns.length; i++) {
            for(int j = 0; j < 3; j++) {
                byteList.add(convertReturns[i][j]);
            }
        }
        for(int i = 0; i < byteList.size(); i++) {
            bytes[i] = byteList.get(i);
        }
        for(int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        return bytes;
    }
}

