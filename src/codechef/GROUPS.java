package codechef;

import java.util.Scanner;

public class GROUPS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0;i<n;i++){
            String a = scan.next() + "0";
            char last = 0;
            int tot = 0;
            for(int j = 0;j<a.length();j++){
                if(a.charAt(j) == '0' && last == '1') tot++;
                last = a.charAt(j);
            }
            System.out.println(tot);
        }
    }
}
