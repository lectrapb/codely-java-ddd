package com.app.steps.domain.challenge;

import com.app.steps.domain.Step;
import com.app.steps.domain.StepId;
import com.app.steps.domain.StepTitle;

public class ChallengeStep extends Step {


    private final ChallengeStepStatement statement;

    public ChallengeStep(StepId id, StepTitle title,  ChallengeStepStatement statement) {
        super(id, title);
        this.statement = statement;
    }
}
