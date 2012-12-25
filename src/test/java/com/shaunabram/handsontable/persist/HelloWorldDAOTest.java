package com.shaunabram.handsontable.persist;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class HelloWorldDAOTest {

    HelloWorldDAO helloWorldDAO;

    @Before
    public void initialize() {
        helloWorldDAO = new HelloWorldDAOImpl();
    }

    @Test
    public void getGreeting_returns_unchanged_argument() {
        String msg = "msg";
        String greeting = helloWorldDAO.getGreeting(msg);
        assertThat(greeting).isEqualTo(msg);
    }
}
