package com.app.mooc.controller.health_check;

import com.app.ApplicationTestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthCheckGetControllerTest extends ApplicationTestCase {

    @Test
    void check_health_check_is_working() throws  Exception {
        //given
        //when
        //then
        assertResponse("/health-check", 200, "{'status': 'ok'}");
    }
}