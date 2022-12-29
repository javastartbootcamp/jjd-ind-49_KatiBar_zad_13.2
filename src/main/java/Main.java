import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run(new Scanner(System.in));
    }

    public void run(Scanner scanner) {
        try {
            List<Integer> numbersArray = createNumbersArray(scanner);
            List<Integer> invertedList = invertList(numbersArray);
            printList(invertedList);
            int sum = calculateSum(numbersArray);
            printSumResults(numbersArray, sum);
            int biggestNumber = calculateBiggestNumber(numbersArray);
            int smallestNumber = calculateSmallestNumber(numbersArray);
            System.out.println("Najmniejsza liczba w liście to " + smallestNumber);
            System.out.println("Największa liczba w liście to " + biggestNumber);
        } catch (InputMismatchException e) {
            System.err.println("Nie podałeś liczby całkowitej");
        } finally {
            scanner.close();
        }
    }

    private static List<Integer> createNumbersArray(Scanner scanner) throws InputMismatchException {
        List<Integer> numbersList = new ArrayList<Integer>();
        int number = -1;
        do {
            System.out.println("Podaj dodatnią liczbę całkowitą: ");
            number = scanner.nextInt();
            if (number >= 0) {
                numbersList.add(number);
            }
        } while (number >= 0);
        return numbersList;
    }

    private static List<Integer> invertList(List<Integer> list) {
        List<Integer> invertedList = new ArrayList<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            invertedList.add(list.get(list.size() - 1 - i));
        }
        return invertedList;
    }

    private static void printList(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            stringBuilder.append(list.get(i));
            stringBuilder.append(", ");
        }
        stringBuilder.append(list.get(list.size() - 1));
        System.out.println(stringBuilder);
    }

    private static int calculateSum(List<Integer> list) {
        int sum = 0;
        for (Integer number : list) {
            sum += number;
        }
        return sum;
    }

    private static void printSumResults(List<Integer> list, int sum) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            stringBuilder.append(list.get(i));
            stringBuilder.append(" + ");
        }
        stringBuilder.append(list.get(list.size() - 1) + " = " + sum);
        System.out.println(stringBuilder);
    }

    private static int calculateBiggestNumber(List<Integer> list) {
        int biggestNumber = 0;
        for (Integer number : list) {
            if (number > biggestNumber) {
                biggestNumber = number;
            }
        }
        return biggestNumber;
    }

    private static int calculateSmallestNumber(List<Integer> list) {
        int smallestNumber = list.get(0);
        for (Integer number : list) {
            if (number < smallestNumber) {
                smallestNumber = number;
            }
        }
        return smallestNumber;
    }
}
