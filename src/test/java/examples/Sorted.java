package examples;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import beans.Person;
import mockdata.MockData;

public class Sorted {

  @Test
  public void exampleSorted() throws Exception {
    List<Person> people = MockData.getPeople();
    people.stream().filter(p -> p.getAge() > 98)
        .sorted(Comparator.comparing(Person::getAge).reversed().thenComparing(Person::getGender))
        .collect(Collectors.toList()).forEach(System.out::println);
  }

  @Test
  public void exampleSortedWithLambda() throws Exception {

    Comparator<Person> nameAgeComparator = new Comparator<Person>() {

      @Override
      public int compare(Person p1, Person p2) {
        int sComp = p2.getAge().compareTo(p1.getAge());

        if (sComp != 0) {
          return sComp;
        }

        return p1.getGender().compareTo(p2.getGender());
      }
    };

    List<Person> people = MockData.getPeople();
    people.stream().filter(p -> p.getAge() > 98).sorted(nameAgeComparator)
        .collect(Collectors.toList()).forEach(System.out::println);
  }

}
