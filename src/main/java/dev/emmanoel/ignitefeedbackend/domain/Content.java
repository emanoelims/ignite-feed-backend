package dev.emmanoel.ignitefeedbackend.domain;


import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Content {
    private final Map<ContentType, List<String>> contents = new EnumMap<>(ContentType.class);

    public void addParagraph(final String paragraph) {
        if (paragraph.isBlank()) {
            throw new IllegalArgumentException();
        }
        contents.computeIfAbsent(ContentType.PARAGRAPH, contentType -> new ArrayList<>())
            .add(paragraph);
    }

    public int paragraphCount() {
        return contents.getOrDefault(ContentType.PARAGRAPH, new ArrayList<>()).size();
    }

    public void addAnchor(final String anchor) {
        if (anchor.isBlank()) {
            throw new IllegalArgumentException();
        }
        contents.computeIfAbsent(ContentType.ANCHOR, contentType -> new ArrayList<>())
            .add(anchor);
    }

    public int anchorCount() {
        return contents.getOrDefault(ContentType.ANCHOR, new ArrayList<>()).size();
    }
}
