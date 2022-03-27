import java.util.PriorityQueue;
class Row implements Comparable<Row>{
    public int rowNum;
    public int solNum;
    public Row(int _1, int _2){
        rowNum = _1;
        solNum = _2;
    }
    @Override
    public int compareTo(Row r){
        if(solNum != r.solNum){
            return solNum - r.solNum;
        }
        if(rowNum != r.rowNum){
            return rowNum - r.rowNum;
        }
        return 0;
    }
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for(int i=0; i<mat.length; i++){
            int rowNum = i;
            int solNum = 0;
            for(int j=0; j<mat[i].length; j++){
                if(mat[i][j] == 0){
                    break;
                }
                solNum++;
            }
            pq.add(new Row(rowNum, solNum));
        }
        for(int i=0; i<k; i++){
            ans[i] = pq.poll().rowNum;
        }
        return ans;
    }
}
