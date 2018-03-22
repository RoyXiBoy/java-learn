package java8.array;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by xlt on 20180322.
 */
public class Array {

    //将数组分割成特定大小的小数组。

    public static int[][] chunk(final int[] numbers, final int size) {
        return IntStream.iterate(0, i -> i + size)
                .limit((long)Math.ceil((double)numbers.length/size))
                .mapToObj(cur -> Arrays.copyOfRange(numbers, cur, cur + size > numbers.length? numbers.length : cur + size))
                .toArray(int[][]::new);
    }

    //合并数组
    public static <T> T[] concat(T[] first, T[] second) {
        return Stream.concat(
                Stream.of(first), Stream.of(second)
        ).toArray(i -> (T[])Arrays.copyOf(new Object[0], i, first.getClass()));
    }

    public static long countOccurrences(int[] numbers, int value) {
        return Arrays.stream(numbers)
                .filter(number -> number == value)
                .count();
    }


}
