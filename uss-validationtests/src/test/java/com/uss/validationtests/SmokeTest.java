package com.uss.validationtests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmokeTest.class);

    @Before
    public void setup() {
        LOGGER.info("**Setup**");
    }

    // This was the sample test provided by Nasa, have kept it the same for sanity testing purposes
    @Test
    public void smoketest_OK() {
        LOGGER.info("------------ smoketest_OK");
    }
}
