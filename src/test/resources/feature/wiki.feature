Feature: CheckMovieDetailsInWiki

  @Regression
  Scenario Outline: Validate the release date of pushpa in wiki
    Given user navigate to the puspha rise "<URL>" in wiki page
    Then user check the release date "<RELEASE_DATE>" and country "<COUNTRY>" details in the wiki page
    Examples:
      | URL             | RELEASE_DATE     | COUNTRY |
      | WIKI_PUSHPA_URL | 17 December 2021 | India   |