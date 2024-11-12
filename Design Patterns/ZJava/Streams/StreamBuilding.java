package ZJava.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamBuilding {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        long output = list.stream().filter((x) -> x <= 5).count();
        System.out.println(output);


        // Ways to build a stream
        Stream<Integer> streamFromList = list.stream();

        Integer[] values = {10, 20, 30, 40, 50};
        Stream<Integer> streamFromArrays = Arrays.stream(values);
        
        Stream<Integer> streamFromStaticOfMethod = Stream.of(4,5,6,7,8,9,10);

        Stream.Builder<Integer> streamFromStreamBuilder = Stream.builder();
        streamFromStreamBuilder.add(2);
        streamFromStreamBuilder.add(12);
        streamFromStreamBuilder.add(17);
        streamFromStreamBuilder.add(23);

        Stream<Integer> streamFromBuilder = streamFromStreamBuilder.build();
        
    }
}
