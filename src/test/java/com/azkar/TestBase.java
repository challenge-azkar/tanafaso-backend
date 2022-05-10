package com.azkar;


import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.azkar.controllers.utils.AzkarApi;
import com.azkar.controllers.utils.HttpClient;
import com.azkar.controllers.utils.JsonHandler;
import com.azkar.entities.User;
import com.azkar.entities.challenges.AzkarChallenge;
import com.azkar.factories.entities.ChallengeFactory;
import com.azkar.factories.entities.UserFactory;
import com.azkar.services.NotificationsService;
import com.azkar.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.mongobee.Mongobee;
import com.github.mongobee.exception.MongobeeException;
import java.io.UnsupportedEncodingException;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public abstract class TestBase {

  // This is needed instead of adding @beforeClass because @beforeClass requires the method to be
  // static which doesn't work with Autowired objects.
  public static boolean BEFORE_ALL_DONE = false;

  // After a new user is created, some starting challenges are added to them automatically to get
  // them started. As these are integration tests, so as we are testing some controllers, we will
  // be creating the user in the same way they will be created by in production. So these counts
  // need to be taken in consideration. Honestly, I don't like this so much as these introduce
  // non-interesting info to some tests.
  public static int STARTING_AZKAR_CHALLENGES_COUNT = 1;
  public static int STARTING_MEANING_CHALLENGES_COUNT = 1;
  public static int STARTING_READING_QURAN_CHALLENGES_COUNT = 1;
  public static int STARTING_MEMORIZATION_CHALLENGES_COUNT = 0;
  public static int STARTING_CHALLENGES_COUNT = 3;

  @Autowired
  public AzkarApi azkarApi;
  @Autowired
  protected HttpClient httpClient;
  @Autowired
  UserService userService;
  @Autowired
  MongoTemplate mongoTemplate;
  @Autowired
  Mongobee mongobee;
  @MockBean
  NotificationsService notificationsService;

  @Before
  public final void beforeBase() throws MongobeeException {
    Mockito.doNothing().when(notificationsService).
        sendNotificationToUser(any(), any(), any());

    if (BEFORE_ALL_DONE) {
      return;
    }
    BEFORE_ALL_DONE = true;
    mongoTemplate.getCollectionNames().stream().forEach(name -> {
      mongoTemplate.dropCollection(name);
    });
    mongobee.execute();
  }

  protected void addNewUser(User user) {
    userService.addNewUser(user);
  }

  //TODO(#118): All perform.*Request methods should be moved to httpClient.
  // If you need to use any of these methods, a corresponding method to your use case should be
  // created in AzkarApi and called instead or use HttpClient.perform.*Request if the use case
  // should not belong to AzkarApi.
  @Deprecated
  protected ResultActions performGetRequest(String token, String path) throws Exception {
    return httpClient.performGetRequest(token, path);
  }

  @Deprecated
  protected ResultActions performGetRequest(User user, String path) throws Exception {
    return httpClient.performGetRequest(user, path);
  }

  @Deprecated
  protected ResultActions performPostRequest(User user, String path, String body) throws Exception {
    return httpClient.performPostRequest(user, path, body);
  }

  @Deprecated
  protected ResultActions performPutRequest(String path, String body) throws Exception {
    return httpClient.performPutRequest(path, body);
  }

  @Deprecated
  protected ResultActions performPutRequest(User user, String path, String body) throws Exception {
    return httpClient.performPutRequest(user, path, body);
  }

  @Deprecated
  protected ResultActions performDeleteRequest(User user, String path) throws Exception {
    return httpClient.performDeleteRequest(user, path);
  }

  protected <T> T getResponse(ResultActions resultActions, Class<T> cls)
      throws JsonProcessingException, UnsupportedEncodingException {
    String jsonResponse = resultActions.andReturn().getResponse().getContentAsString();
    return JsonHandler.fromJson(jsonResponse, cls);
  }

  protected User getNewRegisteredUser() {
    User newUser = UserFactory.getNewUser();
    addNewUser(newUser);
    return newUser;
  }

  // TODO(issue#156): Think about a place for helper functions for tests
  protected AzkarChallenge createGroupChallenge(User user, String groupId) throws Exception {
    AzkarChallenge challenge = ChallengeFactory.getNewChallenge(groupId);
    azkarApi.addAzkarChallenge(user, challenge).andExpect(status().isOk());
    return challenge;
  }

  protected AzkarChallenge createGroupChallenge(User user, AzkarChallenge challenge)
      throws Exception {
    azkarApi.addAzkarChallenge(user, challenge).andExpect(status().isOk());
    return challenge;
  }
}
