package dev.emmanoel.ignitefeedbackend.domain.post;


import dev.emmanoel.ignitefeedbackend.domain.AbstractEntity;

import java.util.*;

public class Content extends AbstractEntity {
    private final Map<ContentType, List<String>> contents;

    public Content() {
        contents = new EnumMap<>(ContentType.class);
    }

    public Content(Map<ContentType, List<String>> contents) {
        this.contents = new EnumMap<>(contents);
    }

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
