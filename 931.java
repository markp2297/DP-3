
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] memo=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0){
                    memo[i][j]=matrix[i][j];
                    continue;
                }
                int min=memo[i-1][j];
                if(j-1>=0){
                    min=Math.min(min,memo[i-1][j-1]);
                }
                if(j+1<matrix[0].length){
                    min=Math.min(min,memo[i-1][j+1]);
                }
                memo[i][j]=matrix[i][j]+min;
            }
        }
        int sum=Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            sum=Math.min(memo[matrix.length-1][i],sum);
        }
        return sum;
    }
}

class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return result;
        helper(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1);
        return result;
    }
    public void helper(int[][] matrix, int left, int right, int top, int bottom){
        // Base case : If pointers cross each other terminate
        if(left > right || top > bottom) return;
        // top row
        for(int i = left; i <= right; i++){
            result.add(matrix[top][i]);
        }
        top++;
        //right column
        for(int i = top; i <= bottom; i++){
            result.add(matrix[i][right]);
        }
        right--;
        // We need to check top <= bottom because original position of top has increased
        if(top <= bottom){
              //Bottom row
            for(int i = right; i >= left; i--){
                result.add(matrix[bottom][i]);
            }
        }
        bottom--;
           // We need to check left <= right because original position of left has changed
        if(left <= right){
              //left column
            for(int i = bottom; i >= top; i--){
                result.add(matrix[i][left]);
            }
        }
        left++;
        helper(matrix,left, right, top, bottom); 
    }
}