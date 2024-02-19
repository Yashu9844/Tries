public class SUBsTRING {

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


         static  int countNode(Node root){
        if (root == null){
            return 0;

        }
        int count=0;
        for (int i=0;i<26;i++){
            if (root.children[i] != null){
                count+= countNode(root.children[i]);
            }


        }
return  count+1;
         }


    public static void main(String[] args) {

        String str="apple";
        for (int i=0;i<str.length();i++){
            String Suffix = str.substring(i);
            insert(Suffix);
        }
        System.out.println(countNode(root));
    }
}

