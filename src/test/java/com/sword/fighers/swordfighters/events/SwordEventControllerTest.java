package com.sword.fighers.swordfighters.events;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.when;

@RunWith(MockitoJUnitRunner.class)
class SwordEventControllerTest {

    @InjectMocks
    private SwordEventController swordEventController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private SwordEventService swordEventService;


    public SwordEventControllerTest(){
        RestAssuredMockMvc.standaloneSetup(swordEventController);
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    void events() {
        when(swordEventService.getSwordEvents()).
        given().when().get("/").then().statusCode(HttpStatus.OK.value());
    }

    @Test
    void showAddEventForm() {
    }

    @Test
    void addEvent() {
    }

    @Test
    void deleteEvent() {
    }

    @Test
    void updateEvent() {
    }

    @Test
    void updateEventPost() {
    }
}