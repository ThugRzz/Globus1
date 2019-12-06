import java.util.Arrays;
import java.util.Scanner;

class Algorithm {
    private char[] symbols = new char[1200];

    void runTask(char[] progressWord, String rWord, double difficulty) {
        boolean check;
        String choose;
        String strWord;
        boolean repeat;
        char letter;
        String answer;
        char[] word = rWord.toCharArray();
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(progressWord, '*');
        System.out.println(progressWord);
        String UpperCase = rWord.substring(0, 1).toUpperCase();
        String LowerCase = rWord.substring(1).toLowerCase();
        int attempts = (int) difficulty * word.length;
        while (true) {
            System.out.println("У вас осталось "+attempts+" попыток.");
            System.out.println("(1)Ввести слово |(2)Ввести букву");
            choose = scanner.next();
            switch (choose) {
                case "1":
                    System.out.println("Введите слово");
                    answer = scanner.next().toLowerCase();
                    if (answer.equals(rWord)) {
                        System.out.println("Вы победитель!\nЗагаданное слово: " + UpperCase + LowerCase);
                        System.exit(0);
                    } else System.out.println("Неверно!");
                    attempts--;
                    break;
                case "2":
                    System.out.println("Введите букву");
                    repeat = true;
                    letter = scanner.next(".").charAt(0);
                    letter = Character.toLowerCase(letter);
                    if (repeatCheck(letter)) {
                        while (repeat) {
                            System.out.println("Вы уже вводили эту букву, повторите снова!");
                            letter = scanner.next().charAt(0);
                            letter = Character.toLowerCase(letter);
                            repeat = repeatCheck(letter);
                            symbols[(int) letter] = letter;
                        }
                    }
                    symbols[(int) letter] = letter;
                    for (int k = 0; k < word.length; k++) {
                        if (letter == word[k]) {
                            progressWord[k] = letter;
                        }
                    }
                    check = winCheck(progressWord);
                    strWord = new String(progressWord);
                    System.out.println(strWord.substring(0, 1).toUpperCase() + strWord.substring(1).toLowerCase());
                    if (!check) {
                        System.out.println("Вы победитель!\nЗагаданное слово: " + UpperCase + LowerCase);
                        break;
                    }
                    attempts--;
                    break;
                default:
                    System.out.println("Некорректный ввод, повторите попытку!");
            }
            check = winCheck(progressWord);
            if (!check || attempts == 0) {
                System.out.println("Вы проиграли!\nЗагаданное слово: " + UpperCase + LowerCase);
                System.exit(0);
            }
        }
    }

    private Boolean repeatCheck(char letter) {
        return symbols[(int) letter] == letter;
    }

    private Boolean winCheck(char[] ProgressWord) {
        char[] progressWord;
        progressWord = ProgressWord;
        for (char c : progressWord) {
            if (c == '*') {
                return true;
            }
        }
        return false;
    }
}
