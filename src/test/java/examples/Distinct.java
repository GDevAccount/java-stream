package examples;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.Test;
import com.google.common.collect.ImmutableList;
import beans.Person;
import mockdata.MockData;

public class Distinct {


  @Test
  public void distinct() throws Exception {
    final List<Integer> numbers =
        ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

    List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());

    assertThat(distinctNumbers).hasSize(9);
  }

  @Test
  public void distinctWithSet() throws Exception {
    final List<Integer> numbers =
        ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

    Set<Integer> distinctNumbers = numbers.stream().collect(Collectors.toSet());

    assertThat(distinctNumbers).hasSize(9);
  }


  @Test
  public void distinctWithAttribute() throws Exception {
    List<Person> people = MockData.getPeople();

    // The function distinctByKey is not native
    List<Person> result =
        people.stream().filter(distinctByKey(Person::getAge)).collect(Collectors.toList());
    assertThat(100).isEqualTo(result.size());
  }

  public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
    Set<Object> seen = ConcurrentHashMap.newKeySet();
    return t -> seen.add(keyExtractor.apply(t));
  }
}
