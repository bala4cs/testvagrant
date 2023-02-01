Feature: CheckMovieDetailsInIMDB

  @Regression
  Scenario Outline: Validate the release date of pushpa in imdb
    Given user navigate to the puspha rise "<URL>" in imdb page
    Then user check the release date "<RELEASE_DATE>" and country "<COUNTRY>" details in the imdb page
    Examples:
      | URL             | RELEASE_DATE      | COUNTRY |
      | IMDB_PUSHPA_URL | December 17, 2021 | India   |