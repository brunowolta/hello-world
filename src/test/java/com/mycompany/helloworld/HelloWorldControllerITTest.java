/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.helloworld;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PropertySource("classpath:application.properties")
public class HelloWorldControllerITTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Value("${server.servlet.contextPath}")
    private String contextPath;
    
    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + contextPath);
    }

    @Test
    public void getHello() throws Exception {
        String expected = "<html xmlns=\"http://thymeleaf.org\">\n\n    <head>\n        <link href=\"/hello/css/layout.css\" rel=\"stylesheet\" type=\"text/css\"></link>\n    </head>\n\n    <body>\n        <div class=\"container\">\n            <p><h3>Hello world!</h3></p>\n        </div>\n    </body>\n\n</html>";
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        assertThat(response.getBody(), equalTo(expected));
    }
}