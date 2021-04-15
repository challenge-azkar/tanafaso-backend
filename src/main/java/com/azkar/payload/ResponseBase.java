package com.azkar.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class ResponseBase<T> {

  T data;
  Error error;

  @Getter
  public static class Error {

    public static final int USER_ALREADY_LOGGED_IN_ERROR = 1;
    public static final int EMAIL_PASSWORD_COMBINATION_ERROR = 2;
    public static final int LOGIN_WITH_EMAIL_ERROR = 3;
    public static final int EMAIL_NOT_VERIFIED_ERROR = 4;
    public static final int USER_ALREADY_REGISTERED_ERROR = 5;
    public static final int USER_ALREADY_REGISTERED_WITH_FACEBOOK = 6;
    public static final int PIN_ALREADY_SENT_TO_USER_ERROR = 7;
    public static final int EMAIL_ALREADY_VERIFIED_ERROR = 8;
    public static final int VERIFICATION_ERROR = 9;
    public static final int AUTHENTICATION_WITH_FACEBOOK_ERROR = 10;
    public static final int SOMEONE_ELSE_ALREADY_CONNECTED_ERROR = 11;
    public static final int AUTHENTICATION_ERROR = 12;
    public static final int GROUP_NOT_FOUND_ERROR = 13;
    public static final int NOT_GROUP_MEMBER_ERROR = 14;
    public static final int CHALLENGE_NOT_FOUND_ERROR = 15;
    public static final int NON_GROUP_MEMBER_ERROR = 16;
    public static final int INCREMENTING_LEFT_REPETITIONS_ERROR = 17;
    public static final int NON_EXISTENT_SUB_CHALLENGE_ERROR = 18;
    public static final int MISSING_OR_DUPLICATED_SUB_CHALLENGE_ERROR = 19;
    public static final int CHALLENGE_EXPIRED_ERROR = 20;
    public static final int REQUIRED_FIELDS_NOT_GIVEN_ERROR = 21;
    public static final int DEFAULT_ERROR = 22;
    public static final int GROUP_INVALID_ERROR = 23;
    public static final int USER_ALREADY_MEMBER_ERROR = 24;
    public static final int USER_NOT_INVITED_ERROR = 25;
    public static final int NOT_MEMBER_IN_GROUP_ERROR = 26;
    public static final int INVITED_USER_INVALID_ERROR = 27;
    public static final int INVITING_USER_IS_NOT_MEMBER_ERROR = 28;
    public static final int INVITED_USER_ALREADY_MEMBER_ERROR = 29;
    public static final int USER_ALREADY_INVITED_ERROR = 30;
    public static final int NOT_MEMBER_ERROR = 31;
    public static final int ERROR_USER_NOT_FOUND = 32;
    public static final int USER_NOT_FOUND_ERROR = 33;
    public static final int FRIENDSHIP_ALREADY_REQUESTED_ERROR = 34;
    public static final int ADD_SELF_ERROR = 35;
    public static final int NO_FRIENDSHIP_ERROR = 36;
    public static final int SEARCH_PARAMETERS_NOT_SPECIFIED = 37;
    public static final int NO_FRIEND_REQUEST_EXIST_ERROR = 38;
    public static final int FRIEND_REQUEST_ALREADY_ACCEPTED_ERROR = 39;
    public static final int PAST_EXPIRY_DATE_ERROR = 40;
    public static final int MALFORMED_SUB_CHALLENGES_ERROR = 41;
    public static final int EMPTY_GROUP_NAME_ERROR = 42;
    public static final int EMAIL_NOT_VALID_ERROR = 43;
    public static final int NAME_EMPTY_ERROR = 44;
    public static final int PASSWORD_CHARACTERS_LESS_THAN_8_ERROR = 45;

    public final int errorCode;

    public Error(int errorCode) {
      this.errorCode = errorCode;
    }
  }
}
