package com.app.steps.domain;

import lombok.Data;
import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class Step {

    private final StepId id;
    private final StepTitle title;

    protected Step(StepId id, StepTitle title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return id.value().equals(step.id.value()) &&
                title.value().equals(step.title.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
