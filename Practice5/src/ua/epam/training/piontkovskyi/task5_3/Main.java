package ua.epam.training.piontkovskyi.task5_3;

import java.util.Scanner;

public class Main {
    private static Dictionary dictionary = new Dictionary();

    public static void main(String[] args) {
        fillDictionary();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to translate : ");
        String translated = dictionary.translate(sc.nextLine());
        System.out.println(String.format("Translated text:\n%s", translated));
    }

    private static void fillDictionary() {
        dictionary.addTranslate("последовательность", "sequence");
        dictionary.addTranslate("действие", "action");
        dictionary.addTranslate("работа", "work");
        dictionary.addTranslate("выражение", "expression");
        dictionary.addTranslate("мяч", "ball");
        dictionary.addTranslate("ванна", "bath");
        dictionary.addTranslate("лезвие", "blade");
        dictionary.addTranslate("книга", "book");
        dictionary.addTranslate("ботинок", "boot");
        dictionary.addTranslate("торт", "cake");
        dictionary.addTranslate("подбородок", "chin");
        dictionary.addTranslate("подушка", "cushion");
        dictionary.addTranslate("двигатель", "engine");
    }
}
