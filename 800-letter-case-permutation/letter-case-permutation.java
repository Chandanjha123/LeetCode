class Solution {
    List<String> list = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        StringBuilder upString = new StringBuilder();
        recFun(0, s, upString, list);
        return list;
    }

    public void recFun(int index, String s, StringBuilder upString, List<String> list) {
        if (index == s.length()) {
            list.add(upString.toString());
            return;
        }
        char ch = s.charAt(index);
        if (Character.isDigit(ch)) {
            upString.append(ch);
            recFun(index + 1, s, upString, list);
            upString.deleteCharAt(upString.length() - 1);
            return;
        }
        //uppercase
        ch = Character.toUpperCase(ch);
        upString.append(ch);
        recFun(index + 1, s, upString, list);
        //lowercase
        upString.deleteCharAt(upString.length() - 1);
        char lower = Character.toLowerCase(s.charAt(index));
        upString.append(lower);
        recFun(index + 1, s, upString, list);
        upString.deleteCharAt(upString.length() - 1);

    }
}