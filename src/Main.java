import com.formdev.flatlaf.FlatDarkLaf;

public class Main {
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        new GreetingGenerator();
    }

    private static int binSearch(int[] array, int target) {
        int min = 0;
        int max = array.length - 1;
        int guess;

        while (min <= max) {
            guess = (max + min)/2;
            if (array[guess] == target) {
                return guess;
            } else if (array[guess] < target) {
                min = guess + 1;
            } else {
                max = guess - 1;
            }
        }
        return -1;
    }

    private static int binSearchRecursv(int min, int max, int[] array, int target) {
        if (min > max) {
            return -1;
        }

        int guess = (min+max)/2;
        if (array[guess] == target) {
            return guess;
        } else if (array[guess] < target) {
            return binSearchRecursv(guess+1, max, array, target);
        } else {
            return binSearchRecursv(min, guess-1, array, target);
        }
    }
}
