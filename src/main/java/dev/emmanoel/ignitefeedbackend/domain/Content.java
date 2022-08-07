package dev.emmanoel.ignitefeedbackend.domain;


import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Content {
    private final Map<ContentType, List<String>> contents = new EnumMap<>(ContentType.class);

    public void addParagraph(String paragraph) {
        if (paragraph.isBlank()) {
            throw new IllegalArgumentException();
        }
        contents.put(ContentType.PARAGRAPH, List.of(paragraph));
    }

    public int paragraphCount() {
        return contents.getOrDefault(ContentType.PARAGRAPH, new ArrayList<>()).size();
    }
}
