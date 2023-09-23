package com.app.courses_counter.domain.value;

import com.app.domain.LongValueObject;
//java-ddd/src/mooc/main/com/app/courses_counter/domain/CoursesCounter.java
public class CoursesCounterTotal extends LongValueObject {
    public CoursesCounterTotal(Long value) {
        super(value);
    }

    public static CoursesCounterTotal initialize() {
        return new CoursesCounterTotal(0L);
    }

    public CoursesCounterTotal increment() {
        return new CoursesCounterTotal(value() + 1L);
    }
}
