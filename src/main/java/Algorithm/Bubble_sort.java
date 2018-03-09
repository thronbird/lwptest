package Algorithm;

import java.util.Arrays;

/**
 * Created by liwanping on 2018-03-09
 */
public class Bubble_sort {
    public static void main(String[] args) {
        int[] x = {1, 2,9, 3, 6};
        int i,j;
        System.out.println(x.length);
        for(j = x.length-1; j >0; j--){
            for (i = 0; i < j; i++) {
                if (x[i+1] > x[i]) {
                    int temp = x[i] ;
                    x[i] = x[i+1] ;
                    x[i+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(x));
    }
}
