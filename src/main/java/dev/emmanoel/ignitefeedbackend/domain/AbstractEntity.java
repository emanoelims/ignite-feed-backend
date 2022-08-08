package dev.emmanoel.ignitefeedbackend.domain;

import java.util.UUID;

public class AbstractEntity {
    private final UUID id;

    public AbstractEntity() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity that)) return false;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s[id=%s]", getClass().getSimpleName(), id.toString());
    }
}
