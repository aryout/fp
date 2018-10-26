package com.fintell.fp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FpApplicationTests {

    @Autowired
    private MockMvc mvc;

    private RestTemplate restTemplate;

    @Test
    public void contextLoads() {
    }


    @Test // 服务端测试
    public void hello_server() throws Exception {
        // mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello world"));
    }

    @Test // 客户端测试
    public void hello_client() throws Exception{
        restTemplate = new RestTemplate();
        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
        // mockServer = MockRestServiceServer.bindTo(this.restTemplate).ignoreExpectOrder(false).build();
        mockServer.expect(requestTo("/hello")).andRespond(withSuccess("hello world", MediaType.TEXT_PLAIN));

        // use RestTemplate ...
        // mockServer.verify();

    }
}
