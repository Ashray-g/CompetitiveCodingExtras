package AdventOfCode.year2021.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day10{
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Long> ca = new ArrayList<>();
        Scanner scan = new Scanner(new File("src/AdventOfCode/year2021/day10/input.txt"));
        int tot = 0;
        for(int i = 0;i<90;i ++){
            String h = scan.next();
            long t = 0;
            boolean v = true;

            Deque<Character> d = new LinkedList<>();
            for(int j = 0;j<h.length();j++){
                char g = h.charAt(j);
                if(d.isEmpty() || close((char)d.getLast(), g) || open(g)){
                    if(!d.isEmpty() && close((char)d.getLast(), g)){
                        d.pollLast();
                    }else {
                        d.addLast(h.charAt(j));
                    }
                }else{
                   t += (long)val(g);
                   v = false;
                   break;
                }
            }
            if(!v){
            }else{
                long sc = 0;
                if(d.size() > 0){
                    while(!d.isEmpty()){
                        char j = d.pollLast();
                        sc *= 5;
                        sc += op(j);
                    }
                }
                ca.add(sc);
            }
        }
        Collections.sort(ca);
        System.out.println(ca.size());
        System.out.println(ca);
        System.out.println(ca.get(ca.size()/2));

    }
    public static boolean close(char g, char c){
        return (g=='<'&&c=='>') || (g=='['&&c==']') || (g=='('&&c==')') || (g=='{'&&c=='}');
    }
    public static boolean open(char j){
        return (j=='{'||j=='['||j=='<'||j=='(');
    }

    public static int val(char g){
        if(g == ')') return 3;
        if(g == '>') return 25137;
        if(g == '}') return 1197;
        if(g == ']') return 57;
        return 0;
    }
    public static int op(char g){
        if(g == '(') return 1;
        if(g == '<') return 4;
        if(g == '{') return 3;
        if(g == '[') return 2;
        return 0;
    }
}