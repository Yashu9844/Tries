public class simplePrefix {

    static class Node{
        Node[] children = new Node[26];
        boolean eow =false;

        Node(){
            for (int i=0;i< children.length;i++){
                children[i] = null;
            }

        }
    }
    public  static Node root = new Node();
    static void insert(String word){
      Node curr = root;

        for (int level=0;level<word.length();level++){
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];

        }
        curr.eow = true;
    }

static boolean startWith(String pre){
        Node curr = root;
        for (int i=0;i<pre.length();i++){
            int idx = pre.charAt(i) -'a';
            if (curr.children[idx] == null){
                return false;
            }
           curr =  curr.children[idx];
        }
        return true;
}






    public static void main(String[] args) {
 String word[] ={"apple","app","mango","man","woman"};
 String prefix1 = "app";
 String prefix2 = "appl";
 String prefix3 = "sw";

 for (int i=0;i< word.length;i++){
     insert(word[i]);
 }

        System.out.println(startWith(prefix1));
        System.out.println(startWith(prefix2));
        System.out.println(startWith(prefix3));

    }
}

