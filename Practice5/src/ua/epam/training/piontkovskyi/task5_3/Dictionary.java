package ua.epam.training.piontkovskyi.task5_3;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    public void addTranslate(String key, String value) {
        dictionary.put(key, value);
    }

    public String translate(String text) {
        String[] words = text.toLowerCase().split("[^А-Яа-яё0-9]");
        StringBuilder translatedText = new StringBuilder();
        for (String word : words) {
            String translated = dictionary.get(word);
            if (translated == null) {
                translatedText.append(word).append(" ");
            } else {
                translatedText.append(translated).append(" ");
            }
        }
        return translatedText.toString();
    }
}
