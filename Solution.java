//Java Anagram
import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        String aUpp = a.toUpperCase();
        String bUpp = b.toUpperCase();
        
        int aLen = a.length();
        int bLen = b.length();
        
        if(aLen != bLen) {
            return false;
        }
        
        java.util.HashMap<Character, Integer> hMap = new java.util.HashMap<>();
        
        char[] aArr = aUpp.toCharArray();
        char[] bArr = bUpp.toCharArray();
        
        for(int i = 0; i < aLen; i++) {
            if(!hMap.containsKey(aArr[i])) {
                hMap.put(aArr[i], 1);
            } else {
                hMap.compute(aArr[i], (key, val) -> val+1);
            }
            
            if(!hMap.containsKey(bArr[i])) {
                hMap.put(bArr[i], -1);
            } else {
                hMap.compute(bArr[i], (key, val) -> val-1);
            }
        }
        
        

        for(java.util.Map.Entry<Character, Integer> m : hMap.entrySet()) {
            
            //System.out.println("Key = " + m.getKey() + ", Value = " + m.getValue());
            if(m.getValue() != 0) {
                return false;
            }
        }
        
        return true;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
