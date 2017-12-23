package google;

import java.util.Stack;

/**
 * Created by mingqiangliang on 12/23/17.
 */
public class Q643_System_Longest_File_Path {

    public int lengthLongestPath(String input) {
        // write your code here
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;
        for (String str : input.split("\n")) {
            int level = str.lastIndexOf('\t')+1;    // number of "\t"
            while (level+1 < stack.size()) stack.pop();
            int len = stack.peek()+str.length()-level+1;    // remove "/t", add"/"
            stack.push(len);
            if(str.contains(".")) ans = Math.max(ans, len-1);
        }
        return ans;
    }

}
