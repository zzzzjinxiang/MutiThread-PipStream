import java.util.*;

public class test {
    public static void main(String[] args){

        for(int i=0;i<4;i++){
            if(i==1) continue;
            System.out.println(i);
        }
        int[] num = {2,1,0,4,3};
        char[] c = {'3','.','e','4'};
        String s = "ABCESFCSADEE";
        String b = "ABCCED";
        String cd = "abbc";
        for(String x:Permutation(cd))
            System.out.println(x);
        int row = 3, col = 4;
        System.out.println(hasPath(s.toCharArray(),row,col,b.toCharArray()));
        LinkedList<Integer> list = new LinkedList<>();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        for(int x:maxInWindows(nums,3))
            System.out.println(x);
        System.out.println(isNumeric(c));
        System.out.println(minStock(num));
        StringBuffer n = new StringBuffer();

        StringBuffer m = new StringBuffer();
        m.append("s");
        String a = "student. a am I";
        ReverseSentence(a);
        int[] tmp = {2,1,3,1,4};
        int[] save = {};
        duplicate(num,num.length,save);
        System.out.println(isContinuous(num));
        solution(10,5);
    }

    public static int minStock(int[] num){
        int length = num.length;
        int min = num[0];
        int maxD = num[1] - min;
        for(int i =2;i<length;i++){
            if(num[i-1]<min)
                min = num[i-1];
            int tmp = num[i]-min;
            if(tmp>maxD)
                maxD = tmp;
        }
        return maxD;
    }

    public static boolean isContinuous(int [] numbers) {
        int numGap = 0;
        int numZero = 0;
        Arrays.sort(numbers);
        for(int i =0;i<numbers.length-1;i++){
            if(numbers[i]==0){
                numZero++;
                continue;
            }
            if(numbers[i]==numbers[i+1])
                return false;
            numGap+=numbers[i+1]-numbers[i]-1;
        }
        if(numGap<=numZero)
            return true;
        return false;
    }

    public static int solution(int n,int m){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i =0;i<n;i++){
            list.add(i);
        }
        int index=0;
        while(list.size()>1){
            index = (index+m-1)%list.size();
            list.remove(index);
            int i = list.size();
        }
        return list.size()==1?list.get(0):-1;
    }

    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        int index = 0;
        for (int i = 0; i < length; i++) {
            index = numbers[i];
            if(index>=length)
                index-=length;
            if (numbers[index] > length) {
                numbers[i] = numbers[i] - length;
                duplication[0] = numbers[i];
                System.out.println(duplication[0]);
                return true;
            } else numbers[index] += length;
        }

        return false;
    }

    public static String ReverseSentence(String str) {
        char[] st = str.toCharArray();
        StringBuffer tmp = new StringBuffer();
        StringBuffer res = new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(st[i]==' ') {
                tmp.append(res);
                res = new StringBuffer();
                res.append(" ");
                res.append(tmp);
                tmp = new StringBuffer();
            }
            else tmp.append(st[i]);
        }
        return res.toString();
    }

    public static String ReverseSentence2(String str){
        char[] st = str.toCharArray();
        int index = 0;
        reverse(st,0,st.length-1);
        int blank = -1;
        while(index<st.length){
            if(st[index]==' '){
                int nextBlank = index;
                reverse(st,blank+1,nextBlank-1);
                blank = nextBlank;
            }
        }
        reverse(st,blank+1,st.length-1);
        return new String(st);
    }

    public static void reverse(char[] str,int low,int high){
        while(low<high){
            char tmp = str[low];
            str[low] = str[high];
            str[high] = tmp;
            low++;
            high--;
        }
}
    private static int index = 0;

    public static boolean isNumeric(char[] str) {
        if(str.length<1)
            return false;
        boolean flag = scanInteger(str);
        if(index<str.length && str[index]=='.'){
            index++;
            if(str[index]=='e' || str[index]=='E'){
                return false;
            }
            flag = scanUnsignedInteger(str) || flag;
        }
        if(index<str.length && (str[index]=='e' || str[index]=='E')){
            index++;
            flag = flag && scanInteger(str);
        }
        return flag && index == str.length;
    }

    public static boolean scanInteger(char[] str){
        if(index<str.length && (str[index] == '+' || str[index] == '-')){
            index++;
        }
        return scanUnsignedInteger(str);
    }

    public static boolean scanUnsignedInteger(char[] str){
        int start = index;
        while(index<str.length && str[index]>='0'&&str[index]<='9')
            index++;
        return start<index;
    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(size>num.length ||size==0)
            return res;
        for(int i = 0;i<num.length-size;i++)
        {
            int max = num[i];
            for(int j=i+1;j<i+size;j++){
                if(num[j]>max){
                    max=num[j];
                }
            }
            res.add(max);
        }
        return res;
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[] visited = new boolean[rows*cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(canWalk(matrix,rows,cols,i,j,str,visited,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canWalk(char[] matrix,int rows, int cols,int row,int col, char[] str,boolean[] visited,int index){
        int indexCur = row*cols+col;
        if(row<0 || row>=rows || col<0 || col>=cols || matrix[indexCur]!=str[index])
            return false;
        if(index == str.length-1)
            return true;
        if(canWalk(matrix,rows,cols,row+1,col,str,visited,index+1) ||
                canWalk(matrix,rows,cols,row,col+1,str,visited,index+1) ||
                canWalk(matrix,rows,cols,row-1,col,str,visited,index+1) ||
                canWalk(matrix,rows,cols,row,col-1,str,visited,index+1))
            return true;
        visited[indexCur] = false;
        return false;
    }

    public static ArrayList<String> Permutation(String str){
        ArrayList<String> list = new ArrayList<>();
        if(str!=null && str.length()>0){
            Permutation(str.toCharArray(),0,list);
            int n=0;
            Collections.sort(list);
        }
        return list;
    }

    public static void Permutation(char[] ch,int index,ArrayList<String> list){
        if(index == ch.length-1){
            list.add(String.valueOf(ch));
        }else {
            Set<Character> charSet = new HashSet<>();
            for(int j=index;j<ch.length;j++){
                if(j==index||!charSet.contains(ch[j])){
                    charSet.add(ch[j]);
                    swap(ch,index,j);
                    Permutation(ch,index+1,list);
                    swap(ch,j,index);
                }
            }
        }
    }

    public static void swap(char[] ch, int i,int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

}
