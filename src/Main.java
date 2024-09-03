import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int req = 3549;
        String[] unitArr = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] tenArr = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hundredArr = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] thousandArr = {"","M","MM","MMM"};

        String res = "";
        res+= thousandArr[req/1000];
        req = req%1000;
        res+= hundredArr[req/100];
        req = req%100;
        res+= tenArr[req/10];
        res+= unitArr[req%10];

        System.out.println(res);


        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int resVal = 0;
        if(res.length() == 1){
            resVal+= romanMap.get(res.charAt(0));
        }
        else{
            for(int i=0;i<res.length()-1;i++){
                if(romanMap.get(res.charAt(i)) >= romanMap.get(res.charAt(i+1)))
                    resVal+= romanMap.get(res.charAt(i));
                else
                    resVal-= romanMap.get(res.charAt(i));
            }
            resVal+= romanMap.get(res.charAt(res.length()-1));
        }
        System.out.println("Hai "+resVal);

    }




}