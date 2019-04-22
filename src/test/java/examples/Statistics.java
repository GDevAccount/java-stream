package examples;

import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import org.junit.Test;
import beans.Car;
import mockdata.MockData;

public class Statistics {

  @Test
  public void count() throws Exception {
    long count = MockData.getPeople().stream()
        .filter(person -> person.getGender().equalsIgnoreCase("female")).count();

    assertThat(count).isEqualTo(467);
  }


  @Test
  public void minCar() throws Exception {
    Car min = MockData.getCars().stream().filter(car -> car.getColor().equalsIgnoreCase("yellow"))
        .min(Comparator.comparing(Car::getPrice)).get();
    assertThat(min.getPrice()).isEqualTo(6600.59);
  }

  @Test
  public void minValue() throws Exception {
    double min =
        MockData.getCars().stream().filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(Car::getPrice).min().orElse(0);
    assertThat(min).isEqualTo(6600.59);
  }

  @Test
  public void maxCar() throws Exception {
    Car max = MockData.getCars().stream().filter(car -> car.getColor().equalsIgnoreCase("yellow"))
        .max(Comparator.comparing(Car::getPrice)).get();
    assertThat(99677.14).isEqualTo(max.getPrice());
  }

  @Test
  public void maxValue() throws Exception {
    double max =
        MockData.getCars().stream().filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(Car::getPrice).max().orElse(0);
    assertThat(99677.14).isEqualTo(max);
  }

  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
    double averagePrice = cars.stream().mapToDouble(Car::getPrice).average().orElse(0);
    assertThat(52693.19979).isEqualTo(averagePrice);
  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream().mapToDouble(Car::getPrice).sum();

    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);

    assertThat(5.269319979E7).isEqualTo(sum);
    assertThat(BigDecimal.valueOf(52693199.79)).isEqualTo(bigDecimalSum);
  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics =
        cars.stream().mapToDouble(Car::getPrice).summaryStatistics();
    System.out.println(statistics);
    
    /*
     * System.out.println(statistics.getAverage()); 
     * System.out.println(statistics.getCount());
     * System.out.println(statistics.getMax()); 
     * System.out.println(statistics.getMin());
     * System.out.println(statistics.getSum());
     */
  }


}
