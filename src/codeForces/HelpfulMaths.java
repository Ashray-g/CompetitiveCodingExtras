package codeForces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        int n = a.length();
        ArrayList<Integer> s = new ArrayList<>();
        for(int i = 0;i<n;i+=2){
            s.add(a.charAt(i) - '0');
        }
        Collections.sort(s);
        for(int i = 0;i<(n+1)/2;i++){
            System.out.print(s.get(i));
            if(i != ((n+1)/2) - 1){
                System.out.print("+");
            }
        }
    }
}
