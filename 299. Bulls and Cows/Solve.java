class Solution {
    public String getHint(String secret, String guess) {
        int nbulls = 0, ncows = 0;
        int len = secret.length();
        boolean[] bulls = new boolean[len];
        boolean[] cows = new boolean[len];
        for(int i=0; i<len; i++){
            bulls[i] = false;
            cows[i] = false;
            if(secret.charAt(i) == guess.charAt(i)){
                bulls[i] = true;
                cows[i] = true;
                nbulls ++;
            }
        }
        for(int i=0; i<len; i++){
            if(!bulls[i]){
                for(int j=0; j<len; j++){
                    if(secret.charAt(i) == guess.charAt(j) && !cows[j]){
                        cows[j] = true;
                        ncows ++;
                        break;
                    }
                }
            }
        }
        String ans = Integer.toString(nbulls) + "A" + Integer.toString(ncows) + "B";
        return ans;
    }
}