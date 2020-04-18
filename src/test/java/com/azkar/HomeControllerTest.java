package com.azkar;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.azkar.entities.User;
import com.azkar.factories.UserFactory;
import com.azkar.payload.homecontroller.GetHomeResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;

public class HomeControllerTest extends ControllerTestBase {

  private static User user = UserFactory.getNewUser();

  @Before
  public void before() {
    addNewUser(user);
  }

  @Test
  public void getHome_authenticatedUser_shouldReturnUser() throws Exception {
    GetHomeResponse expectedResponse = new GetHomeResponse();
    expectedResponse.setData(user);

    performGetRequest(user, "/")
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().string(mapToJson(expectedResponse)));
  }
}
