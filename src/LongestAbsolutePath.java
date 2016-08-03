
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: LongestAbsolutePath Function: TODO
 *
 * @Author: dtang
 * @Date: 7/29/16, 1:28 PM
 */
public class LongestAbsolutePath {
    public static class Dir {
        String name;
        List<Dir> subDirs = new ArrayList<>();
        List<String> files = new ArrayList<>();

        @Override
        public String toString() {
            return "Dir{" +
                    "name='" + name + '\'' +
                    ", subDirs=" + subDirs +
                    ", files=" + files +
                    '}';
        }
    }
    String increSeperator = "\\t";
    int max = 0;
    public int longestAbsolutePath(String s){
        String seperator = "\\n\\t";

        Dir dir = longestAbsolutePath(s, seperator, 0);
        System.out.println(dir);
        return max;
    }

    public Dir longestAbsolutePath(String s, String seperator, int cumulativeSum){
        List<Integer> indexList = new ArrayList<>();
        int start = 0;
        while(start < s.length()){
            int index = s.indexOf(seperator, start);
            if(index == -1) break;
            if (index + seperator.length() + increSeperator.length() < s.length() && !s.substring(index + seperator.length(), index + seperator.length() + increSeperator.length()).equals(increSeperator)){
                indexList.add(index);
                start = index + seperator.length();
            }else{
                start = index + seperator.length() + increSeperator.length();
            }

        }
        Dir dir = new Dir();
        if(indexList.size() ==0){
            dir.name = s;
            max = Math.max(max, cumulativeSum + dir.name.length());
            return dir;
        }

        dir.name = s.substring(0, indexList.get(0));
        //TODO
        int newCumulatvieSum = cumulativeSum + dir.name.length();
        max = Math.max(max, newCumulatvieSum);
        for(int i=0; i<indexList.size(); i++){
            String sub;
            if(i == indexList.size()-1){
                sub = s.substring(indexList.get(i) + seperator.length());
            }else{
                sub = s.substring(indexList.get(i) + seperator.length(), indexList.get(i+1));
            }
            if(sub.contains(seperator+increSeperator)){
                //TODO
                dir.subDirs.add(longestAbsolutePath(sub, seperator + increSeperator, newCumulatvieSum + 1));
            }else{
                dir.files.add(sub);
                max = Math.max(max, newCumulatvieSum + sub.length() +1);
            }
        }
        return dir;
    }

    public int longestAbsolutePath2nd(String s){
        String[] items = s.split("\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int lastLevel = -1;
        int max = 0;
        for(String item: items){
            String stripped = strip(item);
            int level = item.length() - stripped.length();
            while(level<=lastLevel){
                stack.pop();
                lastLevel --;
            }
            stack.push(stripped.length() + 1 + stack.peek());
            lastLevel = level;
            if(stripped.contains(".")){
                max = Math.max(max, stack.peek());
            }
        }
        return max;

    }

    public String strip(String s){
        for(int i =0; i<s.length(); i++){
            if(!s.substring(i, i+1).equals("\t")){
                return s.substring(i);
            }
        }
        return "";
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.longestAbsolutePath("dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext"));
        System.out.println(solution.longestAbsolutePath2nd("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}
