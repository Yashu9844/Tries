public class search_substring {
    static  class  Node{
        Node children[] = new Node[26];
        boolean eow = false;

        Node(){
            for (int i=0;i<26;i++){
                children[i] = null;
            }
        }


    }
    public static Node root =new Node();

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
    static boolean Search(String word){
        Node curr = root;

        for (int level=0;level<word.length();level++){
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];

        }
        return  curr.eow == true;
    }

    static boolean sub(String word){
        if (word.length() == 0){
            return true;
        }
        for (int i=1;i<=word.length();i++){
            if (Search(word.substring(0,i)) && sub(word.substring(i))){
                return true;

            }
        }
        return false;
    }


    public static void main(String[] args) {
        String arr[]={"i","like","sam","samsung","mobile","ice"};
        for (int i=0;i< arr.length;i++){
                     insert(arr[i]);
         }
        String key="ilikesumsung";
        System.out.println(sub(key));

    }
}
