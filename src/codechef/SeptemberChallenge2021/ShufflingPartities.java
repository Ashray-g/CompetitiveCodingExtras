package codechef.SeptemberChallenge2021;

import java.util.Scanner;

public class ShufflingPartities {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-->0){
            int n = scan.nextInt();

            int e = 0,o = 0;
            for(int i  =0;i<n;i++){
               if(scan.nextInt()%2 == 1) o++;
               else e++;
            }
            int onesAdded = (n +1)/ 2;

            if(onesAdded <= e){
                o+=onesAdded;
            }else{
                o += e;
                o -= onesAdded - e;
            }

            System.out.println(o);

        }
    }
}
