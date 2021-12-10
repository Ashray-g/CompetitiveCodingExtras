package codechef;

import java.util.Scanner;

public class NOTIME {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), s = scan.nextInt(), w = scan.nextInt();
        boolean solved = false;
        for(int i = 0;i<n;i++){
            if(s + scan.nextInt() >= w){
                solved = true;
                System.out.println("YES");
                break;
            }
        }
        if(!solved)System.out.println("NO");
    }
}
