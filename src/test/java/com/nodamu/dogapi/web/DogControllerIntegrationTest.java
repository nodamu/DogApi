package com.nodamu.dogapi.web;


import com.nodamu.dogapi.entity.Dog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DogControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getAllDogs(){
        ResponseEntity<List> response = this.testRestTemplate.withBasicAuth("admin","password").getForEntity("http://localhost:" + port + "/dogs",List.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogBreedById(){
        ResponseEntity<String> response = this.testRestTemplate.withBasicAuth("admin","password").getForEntity("http://localhost:" + port + "/1/breed",String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogBreed(){
        ResponseEntity<List> response = this.testRestTemplate.withBasicAuth("admin","password").getForEntity("http://localhost:" + port + "/dogs/breed/",List.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogName(){
        ResponseEntity<List> response = this.testRestTemplate.withBasicAuth("admin","password").getForEntity("http://localhost:" + port + "/dogs/name",List.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
