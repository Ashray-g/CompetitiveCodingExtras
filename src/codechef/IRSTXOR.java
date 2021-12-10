package codechef;

import java.util.Scanner;

public class IRSTXOR {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n  = scan.nextInt();
        for(int i = 0;i<n;i++){
            int c = scan.nextInt();
            String h = Integer.toBinaryString(c);
            long num1 = 0, num2 = 0;
            for(int j = 0;j<h.length();j++){
                long g = (long)Math.pow(2, h.length() - 1 - j);
                if(h.charAt(j)== '0'){
                    num1 += g;
                    num2 += g;
                }else{
                    if(num1 > num2) num2 += g;
                    else num1 += g;
                }
            }
            System.out.println(num1 * num2);
        }

    }
}
