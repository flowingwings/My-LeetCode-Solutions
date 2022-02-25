class Solution{
    // This function is abundant, 
    // because it's already implemented by Character.isLetter(c).
    public boolean isAlphabet(char c){
        if((c - 'a' >= 0 && 'z' - c >= 0)
           || (c - 'A' >= 0 && 'Z' - c >= 0)){
               return true;
        }
        return false;
    }
    public String reverseOnlyLetters(String s){
        String ans = "";
        String abs = "";
        int len = s.length();
        boolean[] notAlphabet = new boolean[len];
        for(int i=0; i<len; i++){
            if(isAlphabet(s.charAt(i))){
                abs += s.charAt(i);
                notAlphabet[i] = false;
            }
            else{
                notAlphabet[i] = true;
            }
        }
        int abindex = abs.length() - 1;
        for(int i=0; i<len; i++){
            if(notAlphabet[i]){
                ans += s.charAt(i);
            }
            else{
                ans += abs.charAt(abindex);
                abindex --;
            }
        }
        return ans;
    }
}