import java.util.*;

public class Main{
    static int ret;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            int n=sc.nextInt();
            int k=sc.nextInt();
            List<Integer>[] arr=new List[n];
            for(int i=0;i<n;i++){
                arr[i]=new ArrayList<Integer>();
            }
            for(int i=0;i<n-1;i++){
                int j=sc.nextInt();
                arr[i+1].add(j);
                arr[j].add(i+1);
            }

            ret=0;
            dfs(arr,k,0,new HashSet<>(),0);
            System.out.println(ret);

        }
    }

    private static void dfs(List<Integer>[] arr,int k,int index,Set<Integer> set,int tmp){
        ret=Math.max(ret,tmp);
        if(k<=0||index==arr.length){
            return;
        }
        for(int i=index;i<arr.length;i++){
            for(Integer j:arr[i]){
                k--;
                if(!set.contains(j)){
                    tmp++;
                    set.add(j);
                    dfs(arr,k,i+1,set,tmp);
                    tmp--;
                    set.remove(j);
                }else{
                    dfs(arr,k,i+1,set,tmp);
                }
            }
        }
    }

}

/*public class Main{
    static int ret;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            String[] str1=sc.nextLine().split(" ");
            int[] boys=new int[str1.length];
            for(int i=0;i<str1.length;i++){
                boys[i]=Integer.parseInt(str1[i]);
            }

            String[] str2=sc.nextLine().split(" ");
            int[] girls=new int[str2.length];
            for(int i=0;i<str2.length;i++){
                girls[i]=Integer.parseInt(str2[i]);
            }

            int n=sc.nextInt();
            Map<Integer,List<Integer>> map=new HashMap<>();
            for(int i=0;i<n;i++){
                int boy=sc.nextInt();
                int girl=sc.nextInt();
                if(!map.containsKey(boy)){
                    List<Integer> list=new ArrayList<>();
                    map.put(boy,list);
                }
                List<Integer> list=map.get(boy);
                list.add(girl);
            }

            ret=0;
            dfs(map,new HashSet<>(),boys,0);
            System.out.println(ret);
        }
    }

    private static void dfs(Map<Integer,List<Integer>> map,Set<Integer> set,int[] boys,int index){
        ret=Math.max(ret,set.size());
        if(index==boys.length) return;
        for(int i=index;i<boys.length;i++){
            if(map.containsKey(boys[i])){
                List<Integer> list=map.get(boys[i]);
                for(Integer girl:list){
                    if(!set.contains(girl)){
                        set.add(girl);
                        dfs(map,set,boys,i+1);
                        set.remove(girl);
                    }
                }
            }
        }
    }
}*/
/*public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            String line=sc.next();
            int ret=line.length();
            for(int i=ret;i>=0;i--){
                boolean flag=false;
                for(int j=0;j+i<=ret;j++){
                    if(isValid(line,j,j+i-1)){
                        flag=true;
                        break;
                    }
                }
                if(flag){
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    private static boolean isValid(String str,int left,int right){
        int[] arr=new int[6];
        for(int i=left;i<=right;i++){
            char c=str.charAt(i);
            if(c=='a') arr[0]++;
            else if(c=='b') arr[1]++;
            else if(c=='c') arr[2]++;
            else if(c=='x') arr[3]++;
            else if(c=='y') arr[4]++;
            else if(c=='z') arr[5]++;
        }

        for(int i=0;i<6;i++){
            if(arr[i]%2!=0) return false;
        }
        return true;
    }
}*/
/*
public class Main {
    static int ret;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int m=sc.nextInt();
            int n=sc.nextInt();
            Map<Integer,Node> map=new HashMap<>();
            Node head=null;
            for(int i=0;i<n;i++){

                int root=sc.nextInt();
                String str=sc.next();
                int child=sc.nextInt();

                if(!map.containsKey(root)){
                    Node node=new Node(root);
                    map.put(root,node);
                }
                if(!map.containsKey(child)){
                    Node node=new Node(child);
                    map.put(child,node);
                }

                Node node=map.get(root);
                Node lorr=map.get(child);
                if(root==1){
                    head=node;
                }

                if(str.equals("left")){
                    node.left=lorr;
                }else{
                    node.right=lorr;
                }
            }

            ret=0;
            inOrder(head);
            System.out.println(ret);
        }
    }


    private static void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        Node left=root.left;
        Node right=root.right;
        if(left!=null&&right!=null){
            if(left.left==null&&left.right==null&&right.left==null&&right.right==null)
            ret++;
        }
        inOrder(root.right);
    }

    static class Node{
        Node left;
        Node right;
        int val;
        public Node(){}
        public Node(int val){
            this.val=val;
        }
    }
}
*/
