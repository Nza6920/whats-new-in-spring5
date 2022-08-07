package stream.p1;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class StreamOperationTest {

    @Test
    public void streamCollectGroupBy() {
        List<Student> students = getStudentsData();
        Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getClassName));
        System.out.println(collect);
    }

    @Test
    public void streamCollectSumming() {
        List<Student> students = getStudentsData();
        Map<String, Double> collect = students.stream()
                .collect(Collectors.groupingBy(Student::getClassName, Collectors.summingDouble(Student::getScore)));
        System.out.println(collect);
    }

    @Test
    public void streamCollectMaxBy() {
        List<Student> students = getStudentsData();
        Map<String, Optional<Student>> collect = students.stream()
                .collect(Collectors.groupingBy(Student::getClassName, Collectors.maxBy(Comparator.comparing(Student::getScore))));
        System.out.println(collect);
    }

    public List<Student> getStudentsData() {
        return Lists.newArrayList(
                Student.builder().name("A").className("CLASS-1").score(60.0).build(),
                Student.builder().name("B").className("CLASS-1").score(70.0).build(),
                Student.builder().name("C").className("CLASS-2").score(70.0).build(),
                Student.builder().name("D").className("CLASS-2").score(70.0).build(),
                Student.builder().name("E").className("CLASS-3").score(80.0).build()
        );
    }

    @Test
    void steamFlatMap() {
        String paragraph = "this is a demo paragraph to calculate char occurrences";
        String[] words = paragraph.split(" ");
        Map<String, Long> charCounting = Arrays.stream(words)
                .map(str -> str.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charCounting);

        List<String> chars = Arrays.stream(words)
                .map(str -> str.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(chars);
    }
}
