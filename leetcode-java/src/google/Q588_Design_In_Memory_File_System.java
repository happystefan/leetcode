package google;

import java.util.*;

public class Q588_Design_In_Memory_File_System {

    class FileSystem {

        Set<String> dirs = new HashSet<>();
        Map<String, String> files = new HashMap<>();

        public FileSystem() {
            dirs.add("/");
        }

        public List<String> ls(String path) {
            if (files.containsKey(path)) {
                String[] ss = path.split("/");
                return Arrays.asList(ss[ss.length-1]);
            }

            if (!path.endsWith("/")) path += "/";
            Set<String> set = new HashSet<>();
            for (String p : dirs) {
                if (p.startsWith(path)) {
                    String[] ss = p.replaceFirst(path, "").split("/");
                    if (!ss[0].equals("")) set.add(ss[0]);
                }
            }
            for (String p : files.keySet()) {
                if (p.startsWith(path)) {
                    String[] ss = p.replaceFirst(path, "").split("/");
                    if (!ss[0].equals("")) set.add(ss[0]);
                }
            }
            List<String> ans = new LinkedList<>(set);
            Collections.sort(ans);
            return ans;
        }

        public void mkdir(String path) {
            dirs.add(path);
        }

        public void addContentToFile(String filePath, String content) {
            if (!files.containsKey(filePath)) files.put(filePath, content);
            else files.put(filePath, files.get(filePath)+content);
        }

        public String readContentFromFile(String filePath) {
            return files.get(filePath);
        }

    }

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */

}
