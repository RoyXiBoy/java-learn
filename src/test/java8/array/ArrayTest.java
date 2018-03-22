package java8.array;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by xlt on 20180322.
 */
public class ArrayTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void chunk() throws Exception {
        int[] num = {0,1,2,3,4,5,6,7,8,9};
        int[][] a = Array.chunk(num, 4);
        for (int[] b : a){
            for (int c : b){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void contact() throws Exception{
        Integer[] a = {1,2,3};
        Integer[] b = {4,5,6};

        Integer[] c = Array.concat(a,b);
        Arrays.stream(c).forEach(System.out::println);
    }



}