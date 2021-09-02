import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FileRenaming {
    public static void main(String[] args) {
        String newName = "abcdefg";
        String oldName = "aaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbEEEEEEEEEEEE73468924242bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbcccccccccccccccccccccccdddddddddddddddddddddddddddeeeeeeeeeeeeeeeeeeeefffffffffffffffggggggggggggggggggggggaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbcccccccccccccccccccccccdddddddddddddddddddddddddddeeeeeeeeeeeeeeeeeeeefffffffffffffffgggggggggggggggggggggg";
        System.out.println(renameFile(newName, oldName));
    }
    public static int renameFile(String newName, String oldName) {

        long[] locations = new long[newName.length()+1];
        locations[0] = 1;
        //a   b   a   b   a
        //1   1   2   2   3
        //0   1   1   3   3
        //0   0   1   1   4

        HashMap<Character, ArrayList<Integer>> mapping = new HashMap<>();
        for(int i = 0;i<newName.length();i++){
            char a = newName.charAt(i);
            if(!mapping.containsKey(a)) mapping.put(a,  new ArrayList<>());
            mapping.get(a).add(i);
        }
        ArrayList<Integer> g;
        for(int i = 0;i<oldName.length();i++){
            if(mapping.containsKey(oldName.charAt(i))){
                g = mapping.get(oldName.charAt(i));
                for(int index = g.size()-1;index>=0;index--){
                    locations[g.get(index)+1] += locations[g.get(index)]%1_000_000_007;
                    locations[g.get(index)+1]%=1_000_000_007;
                }
            }
        }

        return (int)(locations[newName.length()]%1_000_000_007);
    }
}
