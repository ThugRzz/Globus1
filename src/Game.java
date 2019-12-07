import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Game {
    private Algorithm algo = new Algorithm();
    private ArrayList<String> words = new ArrayList<>();
    private ArrayList<String> question = new ArrayList<>();
    private boolean run = false;

    void Start() throws FileNotFoundException {
        char[] progressWord;
        String difficulty;
        Scanner answers = new Scanner(new File("src/answers.txt"));
        Scanner questions = new Scanner(new File("src/questions.txt"));
        int i = 0;
        while (answers.hasNext()) {
            words.add(i, answers.nextLine());
            question.add(i, questions.nextLine());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        int n = (int) Math.floor(Math.random() * words.size());
        words.set(n, words.get(n).toLowerCase());
        question.set(n, question.get(n));
        progressWord = words.get(n).toCharArray();
        System.out.println("Вопрос: " + question.get(n));
        while (!run) {
            run = true;
            System.out.println("Выберите уровень сложности: (1)Легкий |(2)Средний |(3)Сложный");
            difficulty = scanner.next();
            switch (difficulty) {
                case "1":
                    algo.runTask(progressWord, words.get(n), 2);
                    break;
                case "2":
                    algo.runTask(progressWord, words.get(n), 1.5);
                    break;
                case "3":
                    algo.runTask(progressWord, words.get(n), 1);
                    break;
                default:
                    System.out.println("Некорректный ввод, повторите попытку!");
                    run = false;
            }
        }
    }
}
