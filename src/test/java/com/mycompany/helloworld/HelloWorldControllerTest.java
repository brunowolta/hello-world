/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.helloworld;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerTest {
    

    @Autowired
    private MockMvc mvc;
    
    /**
     * Test of viewHome method, of class HelloWorldController.
     */
    @Test
    public void testViewHome() throws Exception {
        String expected = "<html xmlns=\"http://thymeleaf.org\">\n\n    <head>\n        <link href=\"/css/layout.css\" rel=\"stylesheet\" type=\"text/css\"></link>\n    </head>\n\n    <body>\n        <div class=\"container\">\n            <p><h3>Hello world!</h3></p>\n        </div>\n    </body>\n\n</html>";
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(expected)));       
    }
    
}
