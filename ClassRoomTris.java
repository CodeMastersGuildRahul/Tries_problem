public class ClassRoomTris {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;

        Node(){
            for(int i = 0; i < 26 ; i++){
                children[i]= null;
            }
        }
    }
//insurt data
public static Node root = new Node();
public static void insert(String words){
Node curr = root;

for (int level =0; level<words.length();level++){
    int idx = words.charAt(level)-'a';

    if(curr.children[idx]==null){
        curr.children[idx]=new Node();
    }
    curr= curr.children[idx];
}
curr.eow=true;
}

//searching data
public static boolean search(String key){
Node curr = root;
for(int level =0;level<key.length();level++){
    int idx = key.charAt(level)-'a';
    if(curr.children[idx] == null){
        return  true;
    }
    curr=curr.children[idx];
}
return curr.eow=true;
}

//StartsWith problem
public static boolean StartsWith(String prefix){
Node curr = root;
for(int i =0; i<prefix.length();i++){
    int idx = prefix.charAt(i)-'a';

    if(curr.children[idx] == null){
        return false;
    }
    curr = curr.children[idx];
}
return true;
}

public static void main(String args[]){
        String words[] = {"apple","app","mango","man","woman"};
        String prefix1 = "app";
        String prefix2 = "moon";

        for(int i =0;i< words.length;i++){
            insert(words[i]);
        }
System.out.println(StartsWith(prefix1));
System.out.println(StartsWith(prefix2));
}
}
