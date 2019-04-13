import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        list.forEach(System.out::println);


        List<String> list1 = Arrays.asList("java", "c", "object-c", "c#", "ruby");
        Collections.sort(list1, String::compareTo);
//        Collections.sort(list1,(o1, o2) -> o1.toUpperCase().compareTo(o2.toUpperCase()));
        list1.forEach(System.out::print);
        System.out.println();


        List<String> list2 = Arrays.asList("java", "c", "object-c", "c#", "ruby");

        List<String> upperCaseName = list2.stream().map(String::toUpperCase).collect(Collectors.toList());
//        List<String> upperCaseName = list2.stream().map(s -> {
//            return s.toUpperCase();
//        }).collect(Collectors.toList());
        upperCaseName.forEach(System.out::print);
        System.out.println();

        List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        System.out.println("sum is:" + nums.stream().filter(integer -> integer != null).distinct()
                .mapToInt(value -> value * 2).peek(System.out::println).limit(4).sum());


        //collect使用
        nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
//        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).collect(() -> new ArrayList<Integer>(),
//                (integers, item) -> integers.add(item),
//                (integers, integers2) -> integers.addAll(integers2));
//        List<Integer> numWithOutNull = nums.stream().filter(num -> num != null).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        List<Integer> numWithOutNull = nums.stream().filter(num -> num != null).collect(Collectors.toList());
        numWithOutNull.forEach(System.out::print);
        System.out.println();

        //reduce使用
        nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("nums sum is:" + nums.stream().reduce((sum, item) -> sum + item).get());
        System.out.println("nums sum is:" + nums.stream().reduce(0,(sum, item) -> sum + item));
        System.out.println("nums count is:" + nums.stream().count());
    }
}
