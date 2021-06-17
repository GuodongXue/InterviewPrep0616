package Knapsack;

import java.util.ArrayList;
import java.util.List;

public class knapSack {
    public static int knapsack(int[] w, int [] val, int m){
        //先进行一个初始化
        int result = 0;
        int n = val.length;
        //int[i][j] 前i行可以装入容量为j的背包的最大价值
        int[][] v = new int[n+1][m+1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i< v.length; i++){
            v[i][0] = 0;
        }
        for(int i = 0; i< v[0].length; i++){
            v[0][i] = 0;
        }

        //Start dp
        for(int i = 1; i < v.length; i++){
            for(int j = 1; j < v[0].length; j++){
                if ( w [i-1] > j){
                    v[i][j] = v[i-1][j];
                } else {
                    v[i][j] = Math.max(v[i-1][j], val[i-1]+ v[i-1][j- w[i-1]]);
                }
                if(result< v[i][j]){
                    result = v[i][j];
                }
            }
        }
        return result;
    }
}
