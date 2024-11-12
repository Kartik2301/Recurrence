package ZJava.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperations {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i + 1);
        }

        long output = list.stream().filter((x) -> x >= 8).count();
        System.out.println(output);

        List<Integer> modifiedList1 = list.stream().map((x) -> x * 2).collect(Collectors.toList());
        for(int val: modifiedList1) {
            System.out.print(val + ", ");
        }
        System.out.println();

        List<Integer> list2 = Arrays.asList(2, 2, 5, 7, 7, 18, 22, 22);
        List<Integer> modifiedList2 = list2.stream().distinct().collect(Collectors.toList());
        for(int val: modifiedList2) {
            System.out.print(val + ", ");
        }
        System.out.println();

        Integer [] values = {23, 5, 432, 663, 4, 235, 56, 1, 2, 1, 45};
        System.out.println(Arrays.stream(values).sorted().collect(Collectors.toList()));
        
        List<Integer> list3 = Arrays.asList(3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> list3Stream = list3.stream().map((Integer value) -> value * value).peek((Integer value) -> System.out.println(value));
        System.out.println(list3Stream.collect(Collectors.toList()));

        List<Integer> list4 = Arrays.asList(34, 1, 3, 3 , 5, 56, 3, 45, 10);
        System.out.println(list4.stream().limit(5).collect(Collectors.toList()));

        int [] primitiveValues = {1, 2, 3, 4, 5, 6, 10, 11, 12, 15, 20};
        IntStream intStream = Arrays.stream(primitiveValues);

        intStream = intStream.filter((int val) -> (val >= 5));
        int [] modfiedIntVals = intStream.toArray();

        for(int subVal: modfiedIntVals) {
            System.out.print(subVal + " ");
        }
        System.out.println();

        List<String> names = Arrays.asList("harry", "kerddy", "Popsicle", "plaptop", "drakei");
        Stream<String> namesStream = names.stream();

        int [] lenArray = namesStream.mapToInt((String x) -> x.length()).toArray();
        for(int subVal: lenArray) {
            System.out.print(subVal + " ");
        }
        System.out.println();

        List<Integer> nums = Arrays.asList(2, 5, 3, 10, 9);
        nums.stream()
            .filter((Integer val) -> (val <= 5))
            .forEach((Integer val) -> System.out.print(val + " - "));

        System.out.println();

        IntStream intStream2 = Arrays.stream(lenArray);
        int [] modfiedInts = intStream2.filter((int val) -> (val >= 5)).toArray();

        for(int subVal: modfiedInts) {
            System.out.print(subVal + " ");
        }
        System.out.println();

        Optional<Integer> vOptional = list4.stream().reduce((Integer val1, Integer val2) -> val1 + val2);
        System.out.println(vOptional.get());

        System.out.println(list4.stream().max(Comparator.naturalOrder()).get());

        int maxElement = list4.stream().mapToInt((Integer val) -> val).max().getAsInt();
        System.out.println(maxElement);

        System.out.println(list4.stream().anyMatch((Integer val) -> (val == 40)));

        System.out.println(list4.stream().allMatch((Integer val) -> (val >= 0)));

        System.out.println(list3.stream().findAny().get());

        Optional<Integer> sum = list2.stream().reduce((Integer val1, Integer val2) -> val1 + val2);
        System.out.println(sum.get());

        List<String> modifiedNamesList = names.stream().map((String val) -> val.toUpperCase()).collect(Collectors.toList());
        System.out.println(modifiedNamesList);

        Optional<Integer> maxValueOptional = list4.stream().max(Comparator.naturalOrder());
        System.out.println(maxValueOptional.get());

        Optional<Integer> minValueOptional = list4.stream().min(Comparator.naturalOrder());
        System.out.println(minValueOptional.get());

        int minValeNonOptional = list4.stream().mapToInt((Integer val) -> val).min().getAsInt();
        System.out.println(minValeNonOptional);

        System.out.println(list3.stream().filter((Integer val) -> (val <= 10)).count());

        System.out.println(list2.stream().anyMatch((Integer x) -> x == 20));

        System.out.println(list4.stream().allMatch((x) -> (x >= 0)));

        System.out.println(list4.stream().noneMatch((x) -> (x == 10)));

        System.out.println(list3.stream().findAny().get());

        System.out.println(list4.stream().reduce((Integer x, Integer y) -> x - y).get());
        
        Arrays.stream(values).forEach((Integer x) -> System.out.print(x + " "));
        System.out.println();
    }
}
