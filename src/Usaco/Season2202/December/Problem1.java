package Usaco.Season2202.December;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt(); //patches
        int m = scan.nextInt(); //nhoj
        int n = scan.nextInt(); //john
        ArrayList<event> loc = new ArrayList<event>();

        for(int i = 0;i<k;i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            event e = new event(a, 0);
            e.taste = b;
            loc.add(e);
        }

        for(int i = 0;i<m;i++){
            int a = scan.nextInt();
            loc.add(new event(a, 1));
        }
        int[] r = new int[m];
        int[] l = new int[m];

        Collections.sort(loc);

        //trackers
        int lastCow = -1;
        int lastGrassStart = -1;
        int curCow = -1;

        for(int i = 0;i<m + k;i++){
            event lastEvent = (i==0)?null:loc.get(i-1);
            event thisEvent = loc.get(i);
            if(thisEvent.type == 0){ //grass
                if(lastEvent == null ||lastEvent.type == 0){ //grass
                }else{ //cow
                    lastGrassStart = i;
                }
                thisEvent.assign = lastCow;
                if(curCow >= 0){
                    thisEvent.assignLoc = loc.get(lastCow).location;
                    r[curCow] += thisEvent.taste;
                }
            }else{ //cow
                curCow++;
                lastCow = i;
                if(lastEvent != null) {


                    if (lastEvent.type == 0) { //grass
                        if (lastGrassStart != -1) {
                            for (int j = lastGrassStart; j < i; j++) {
                                event gr = loc.get(j);
                                if ((gr.assign == -1) || (gr.location - gr.assignLoc > thisEvent.location - gr.location)) {
                                    gr.assign = i;
                                    gr.assignLoc = thisEvent.location;
                                    if (curCow > 0) {
                                        r[curCow - 1] -= gr.taste;
                                    }
                                    l[curCow] += gr.taste;
                                }
                            }
                        }
                    } else { //cow
                    }
                }
            }
        }
        ArrayList<Integer> s = new ArrayList<>();
        for(int i : r) s.add(i);
        for(int i : l) s.add(i);
        long tot = 0;
        Collections.sort(s);
        for(int o = 0;o<n;o++){
            tot += s.get(s.size() - 1 - o);
        }
        System.out.println(tot);

    }
    public static class event implements Comparable{
        public int location;
        public int type; //0 = grass, 1 = cow

        public int assign = -1; //if grass then which cow is closest so far
        public int assignLoc = -1;
        public int taste;
        public event(int location, int type) {
            this.location = location;
            this.type = type;
        }

        @Override
        public int compareTo(Object o) {
            return this.location - ((event)o).location;
        }
    }
}
