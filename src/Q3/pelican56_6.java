package Q3;

import com.google.common.base.Ascii;

import java.util.*;

public class pelican56_6 {
    public static void main(String[] args) {
        HashMap<String, Integer> tab = new HashMap<>(180);
        tab.put("Bush, George", hashCode("Bush, George"));
        tab.put("Clinton, Bill", hashCode("Clinton, Bill"));
        tab.put("Lincoln, Abraham", hashCode("Lincoln, Abraham"));
        tab.put("Washington, George", hashCode("Washington, George"));
        var  set = tab.keySet();
        for (String s : set) {
            System.out.println(s + ">>>>" + tab.get(s));
        }
    }


    public static int hashCode(String key) {
        key = key.toUpperCase(Locale.ROOT);
        int tot = key.substring(0, 1).hashCode() * 1000;
        tot += key.substring(1, 2).hashCode() * 100;
        tot += key.substring(key.length()-2, key.length()-1).hashCode() * 10;
        tot += key.substring(key.length()-1).hashCode();
        return tot % 180;
    }
}
//Lincoln, Abraham>>>>147
//Clinton, Bill>>>>16
//Washington, George>>>>139
//Bush, George>>>>39