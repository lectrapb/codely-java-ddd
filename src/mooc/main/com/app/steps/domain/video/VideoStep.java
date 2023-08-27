package com.app.steps.domain.video;

import com.app.steps.domain.Step;
import com.app.steps.domain.StepId;
import com.app.steps.domain.StepTitle;

public class VideoStep extends Step {

    private final VideoUrl videoUrl;
    private final VideoStepText text;
    protected VideoStep(StepId id, StepTitle title, VideoUrl videoUrl, VideoStepText text) {
        super(id, title);
        this.videoUrl = videoUrl;
        this.text = text;
    }
}
