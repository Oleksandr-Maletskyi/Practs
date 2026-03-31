import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Assignment3 {


    public static void main(String[] args) {
        List<Sale> sales = List.of(
                new Sale("a@ex.com", "Tea", 120),
                new Sale("b@ex.com", "Cake", 200),
                new Sale("a@ex.com", "Tea", 120),
                new Sale("c@ex.com", "Coffee", 150),
                new Sale("b@ex.com", "Cake", 200)
        );

        Map<String, Integer> revenueByProduct = sales.stream()
                .peek(sale -> System.out.println("Зайшло у стрім:" + sale.product() + ", " + sale.cents()))
                .collect(Collectors.toMap(
                        Sale::product,
                        Sale::cents,
                        Integer::sum
                ));

        System.out.println("--- Сумарна виручка за продуктами ---");
        System.out.println(revenueByProduct);



        Map<String, Long> transactionsPerCustomer = sales.stream()
                .peek(sale -> System.out.println("Зайшло у стрім:" + sale.customerEmail()))
                .collect(Collectors.groupingBy(
                        Sale::customerEmail,
                        Collectors.counting()
                ));

        System.out.println("\n--- Кількість транзакцій за клієнтами ---");
        System.out.println(transactionsPerCustomer);
        System.out.println("\n--- toMap з TreeMap ---");

        Map<String, Integer> sortedRevenueByProduct = sales.stream()
                .peek(sale -> System.out.println("Зайшло у стрім:" + sale.product() + ", " + sale.cents()))
                .collect(Collectors.toMap(
                        Sale::product,
                        Sale::cents,
                        Integer::sum,
                        TreeMap::new
                ));

        System.out.println(sortedRevenueByProduct);
    }
}
