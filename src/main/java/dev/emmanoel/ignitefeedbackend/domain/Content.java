package dev.emmanoel.ignitefeedbackend.domain;


import java.util.*;

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

    public Map<ContentType, List<String>> getContents() {
        return Collections.unmodifiableMap(contents);
    }
}
