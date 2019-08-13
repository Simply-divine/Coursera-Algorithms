package Week4Coursera;

import com.sun.org.apache.xerces.internal.util.SymbolTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyCounter {
    public static void main(String[] args) {
        int minLen = Integer.parseInt(args[0]);
        Map<String,Integer> st =new HashMap<>();
        Scanner scanner =new Scanner(System.in);
        for (int i = 0; scanner.hasNext() ; i++) {
            String word=scanner.next();
            if(word.length()<minLen){continue;}
            if(st.containsKey(word))st.put(word,(st.get(word)+1));
            else st.put(word,1);
        }
        String max="";
        st.put(max,0);
        for (String word: st.keySet()
             ) {
            if(st.get(word)>st.get(max))
                max=word;
        }
        System.out.println(max+" "+st.get(max));
    }
}
