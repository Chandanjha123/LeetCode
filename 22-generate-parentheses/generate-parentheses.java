class Solution {
    List<String> list=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder string=new StringBuilder();
        recFun(0,0,n,string,list);
        return list;
    }
    public void recFun(int open,int close,int n,StringBuilder string,List<String> list){
        if(open==n && close==n){
            list.add(string.toString());
            return;
        }
        //add "(" open
        if(open<n){
            string.append("(");
            recFun(open+1,close,n,string,list);
            string.deleteCharAt(string.length()-1);
        }
        if(open>close){
            string.append(")");
            recFun(open,close+1,n,string,list);
            string.deleteCharAt(string.length()-1);
        }
    }
}