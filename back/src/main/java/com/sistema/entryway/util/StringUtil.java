package com.sistema.entryway.util;

import java.text.Normalizer;

public class StringUtil {
    public static String removeAccentLower(String text) {
        if (text == null) {
            return null;
        }

        var validatedText = Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");

        return validatedText.toLowerCase();
    }
}
