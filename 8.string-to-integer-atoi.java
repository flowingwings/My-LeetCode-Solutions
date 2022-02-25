
// @lc app=leetcode id=8 lang=java
// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int iSpace = 0;
        while(iSpace < s.length() && s.charAt(iSpace) == ' '){
            iSpace ++;
        }
        boolean isPosi = true;
        if(iSpace < s.length() && s.charAt(iSpace) == '-'){
            isPosi = false;
        }
        int iNum = iSpace;
        if(iNum<s.length() && (s.charAt(iNum) == '-' || s.charAt(iNum) == '+' )){
            iNum ++;
        }
        while(iNum < s.length() && s.charAt(iNum) == '0'){
            iNum ++;
        }
        int numEnd = iNum;
        while(numEnd < s.length() && Character.isDigit(s.charAt(numEnd))){
            numEnd ++;
        }
        String value = s.substring(iNum, numEnd);
        if(value.length()==0){
            return 0;
        }
        boolean posiOf = false;
        String maxInt = "2147483647";
        System.out.println("value: "+value);
        if(isPosi){
            if(value.length()>maxInt.length()){
                posiOf = true;
            }
            else if(value.length() == maxInt.length()){
                boolean flag = false;
                for(int i=0; i<maxInt.length(); i++){
                    if(value.charAt(i) == maxInt.charAt(i)){
                        continue;
                    }
                    else if(value.charAt(i)>maxInt.charAt(i)){
                        flag = true;
                        break;
                    }
                    else{ // value.charAt(i)<maxInt.charAt(i)
                        break;
                    }
                }
                if(flag)
                    posiOf = true;
            }
        }
        if(posiOf){
            return Integer.MAX_VALUE;
        }
        boolean negaOf = false;
        String minInt = "2147483648";
        if(!isPosi){
            if(value.length()>minInt.length()){
                negaOf = true;
            }
            else if(value.length()==minInt.length()){
                boolean flag = false;
                for(int i=0; i<minInt.length(); i++){
                    if(value.charAt(i) == minInt.charAt(i)){
                        continue;
                    }
                    else if(value.charAt(i)>minInt.charAt(i)){
                        flag = true;
                        break;
                    }
                    else{ // value.charAt(i)<minInt.charAt(i)
                        break;
                    }
                }
                if(flag)
                    negaOf = true;
            }
        }
        if(negaOf){
            return Integer.MIN_VALUE;
        }
        if(!isPosi && value.equals("2147483648")){
            return Integer.MIN_VALUE;
        }
        return isPosi ? Integer.parseInt(value) : -Integer.parseInt(value);
    }
}
// @lc code=end

