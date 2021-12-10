package codechef;

import java.util.Scanner;

public class MEET {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int t = scan.nextInt();
        scan.nextLine();
        for(int i = 0;i<t;i++) System.out.println(solve());
    }
    public static String solve(){
        String ans = "";
        String mTime = scan.nextLine();
        int mA = (mTime.charAt(0) - '0')*10 + (mTime.charAt(1) - '0');
        int mB = (mTime.charAt(3) - '0')*10 + (mTime.charAt(4) - '0');
        if(mA == 12) mA = 0;
        if(mTime.charAt(6) == 'P') mA += 12;

        int m = mA * 60 + mB;
        int friends = scan.nextInt();
        scan.nextLine();
        for(int i = 0;i<friends;i++){
            mTime = scan.nextLine();
            int cA1 = (mTime.charAt(0) - '0')*10 + (mTime.charAt(1) - '0');
            int cB1 = (mTime.charAt(3) - '0')*10 + (mTime.charAt(4) - '0');
            if(cA1 == 12) cA1 = 0;
            if(mTime.charAt(6) == 'P') cA1 += 12;

            int m1 = cA1 * 60 + cB1;

            mTime = mTime.substring(9);
            int cA2 = (mTime.charAt(0) - '0')*10 + (mTime.charAt(1) - '0');
            int cB2 = (mTime.charAt(3) - '0')*10 + (mTime.charAt(4) - '0');
            if(cA2 == 12) cA2 = 0;
            if(mTime.charAt(6) == 'P') cA2 += 12;

            int m2 = cA2 * 60 + cB2;
            if((m <= m2 && m >= m1) || (m <= m1 && m >= m2)) ans += '1';
            else ans += '0';
        }
        return ans;
    }
}
