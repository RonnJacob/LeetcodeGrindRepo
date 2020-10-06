import java.util.*;
class File{
    boolean isFile = false;
    Map<String, File> files = new TreeMap<>();
    String content = "";
}

public class FileSystem {
    public FileSystem() {
        root = new File();
    }

    static File root;
    private static boolean isFilePath(String path){
        return true;
    }

    // If it is a file path, we need to just output that file. 
        // we would need to check if something is a file path
    // If it isn't, we need to output everything in that level.

    // Check if the element in a Trie Level is a file or document.
    public static List<String> ls(String path) {
        File t = root;
        List<String> result = new ArrayList<>();
        String[] dirs = path.split("/");
        if(!path.equals("/")){
            for(int i=1; i<dirs.length; i++){
                t = t.files.get(dirs[i]);
            }
            if(t.isFile){
                result.add(dirs[dirs.length-1]);
                return result;
            }
        }
        result.addAll(t.files.keySet());
        return result;
    }
    
    public static void mkdir(String path) {
        File t = root;
        String[] dirs = path.split("/");
        for(int i=1; i<dirs.length; i++){
            if(!t.files.containsKey(dirs[i])){
                t.files.put(dirs[i], new File());
            }
            t = t.files.get(dirs[i]);
        }
    }
    
    public static void addContentToFile(String filePath, String content) {
        File t = root;
        String[] dirs = filePath.split("/");
        for(int i=1; i<dirs.length; i++){
            if(!t.files.containsKey(dirs[i])){
                t.files.put(dirs[i], new File());
            }
            t = t.files.get(dirs[i]);
        }


        t.isFile = true;
        t.content = t.content + content;
    }
    
    public static String readContentFromFile(String filePath) {
        File t = root;
        String[] dirs = filePath.split("/");
        for(int i=1; i<dirs.length; i++){
            if(!t.files.containsKey(dirs[i])){
                t.files.put(dirs[i], new File());
            }
            t = t.files.get(dirs[i]);
        }
        return t.content;
    }

    public static void main(String[] args){
       System.out.println("\n588. Design In-Memory File System\n");
       FileSystem fs = new FileSystem();
       System.out.println(fs.ls("/").toString());
       fs.mkdir("/a/b/c");
       fs.addContentToFile("/a/b/c/d","hello");
       System.out.println(fs.ls("/").toString());
       System.out.println(fs.readContentFromFile("/a/b/c/d"));
       
    }
}
