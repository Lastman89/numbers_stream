import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        System.out.println(intList);
        noStream(intList);
        withStream(intList);


    }

    public static void noStream(List numbers) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if ((int) numbers.get(i) > 0 && (int) numbers.get(i) % 2 == 0) {
                intList.add((int) numbers.get(i));
            } else {
                continue;
            }
        }
        int[] list = new int[intList.size()];
        for (int i = 0; i < intList.size(); i++) {
            list[i] = (int) intList.get(i);
        }
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j + 1];
                    list[j + 1] = list[j];
                    list[j] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(list));

    }

    public static void withStream(List numbers) {
        System.out.println(numbers.stream()
                .filter(x -> (int) x > 0)
                .filter(x -> (int) x % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList())
        );
    }

}