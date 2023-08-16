package com.app.infraestructure;

import com.app.Starter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Starter.class)
@SpringBootTest
public abstract class InfrastructureTestCase {
}
