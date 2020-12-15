package com.scotia.challenge;

import com.scotia.challenge.helper.CleanUpTest;
import com.scotia.challenge.modularTest.CarTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@RunWith(Suite.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.integration.properties")
@Suite.SuiteClasses({
    CleanUpTest.class,
    CarTest.class
})
public class GlobalTest {
}
