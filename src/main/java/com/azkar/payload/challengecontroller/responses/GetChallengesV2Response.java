package com.azkar.payload.challengecontroller.responses;

import com.azkar.entities.challenges.AzkarChallenge;
import com.azkar.entities.challenges.MeaningChallenge;
import com.azkar.payload.ResponseBase;
import com.azkar.payload.challengecontroller.responses.GetChallengesV2Response.Challenge;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class GetChallengesV2Response extends ResponseBase<List<Challenge>> {

  // This class holds an instance of one of the challenge types.
  @Builder
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  @Setter
  public static class Challenge implements Comparable<Challenge> {

    AzkarChallenge azkarChallenge;
    MeaningChallenge meaningChallenge;

    // Sorts in the descending order of modifiedAt.
    @Override public int compareTo(Challenge o) {
      long firstModifiedAt = azkarChallenge != null ? azkarChallenge.getModifiedAt()
          : meaningChallenge.getModifiedAt();
      long secondModifiedAt = o.azkarChallenge != null ? o.azkarChallenge.getModifiedAt()
          : o.meaningChallenge.getModifiedAt();
      return -Long.compare(firstModifiedAt, secondModifiedAt);
    }
  }
}
