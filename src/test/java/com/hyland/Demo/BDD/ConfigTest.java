package com.hyland.Demo.BDD;

import java.lang.annotation.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;


/**
 * Created by admin on 3/15/2018.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration
@ActiveProfiles("test")
@SpringBootTest(classes = {DemoBddApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public @interface ConfigTest {
}
