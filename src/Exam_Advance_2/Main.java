package Exam_Advance_2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> wordStack = new Stack<>();

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập câu");
            System.out.println("2. Đảo ngược câu");
            System.out.println("3. Thoát");
            System.out.print("Chọn một tùy chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dấu Enter

            switch (choice) {
                case 1:
                    System.out.print("Nhập câu: ");
                    String inputSentence = scanner.nextLine();
                    String[] words = inputSentence.split(" ");
                    for (String word : words) {
                        wordStack.push(word);
                    }
                    break;
                case 2:
                    System.out.print("Câu đảo ngược: ");
                    while (!wordStack.isEmpty()) {
                        System.out.print(wordStack.pop() + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại.");
            }
        }
    }
}
