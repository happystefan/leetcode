package Y2019.parser;

import java.util.LinkedList;
import java.util.List;


public class Q0722_Remove_Comments {

    class solution1 {

        public List<String> removeComments(String[] source) {
            List<String> result = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            boolean isBlockComment = false;
            for (String src : source) {
                char[] line = src.toCharArray();
                if (!isBlockComment) sb.delete(0, sb.length());
                int i = 0;
                while (i < line.length) {
                    if (!isBlockComment && i + 1 < line.length && line[i] == '/' && line[i + 1] == '*') {
                        isBlockComment = true;
                        i++;
                    } else if (!isBlockComment && i + 1 < line.length && line[i] == '/' && line[i + 1] == '/') {
                        break;
                    } else if (!isBlockComment) {
                        sb.append(line[i]);
                    } else if (isBlockComment && i + 1 < line.length && line[i] == '*' && line[i + 1] == '/') {
                        isBlockComment = false;
                        i++;
                    }
                    i++;
                }
                if (!isBlockComment && sb.length() != 0) result.add(sb.toString());
            }
            return result;
        }

    }

    static class solution2 {

        public List<String> removeComments(String[] source) {
            char[] ss = String.join("\n", source).toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ss.length; ) {
                if (i < ss.length - 1 && ss[i] == '/' && ss[i + 1] == '*') {
                    int j = i + 2;
                    for (; j < ss.length; j++) if (ss[j] == '*' && ss[j + 1] == '/') break;
                    i = j + 2;
                } else if (i < ss.length - 1 && ss[i] == '/' && ss[i + 1] == '/') {
                    int j = i + 2;
                    for (; j < ss.length; j++) if (ss[j] == '\n') break;
                    i = j;
                } else {
                    sb.append(ss[i++]);
                }
            }
            List<String> result = new LinkedList<>();
            for (String line : sb.toString().split("\n")) {
                if (!line.equals("")) result.add(line);
            }
            return result;
        }

    }

}
