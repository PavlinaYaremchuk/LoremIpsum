Feature: Lorem
  As a user
  I want to test the proper text generation on https://www.lipsum.com
  So that I can be sure that site works correctly

  Background:
    Given User opens home page
    |https://www.lipsum.com|

  Scenario: Check that the word "рыба" appears in the first paragraph
    When User clicks on language link Russian
    Then User checks that the first paragraph contains the keyword
    | рыба |

  Scenario: Check that the first paragraph starts with particular phrase
    When User clicks on Generate Lorem Ipsum button
    Then User checks that the first paragraph starts with phrase
      | Lorem ipsum dolor sit amet, consectetur adipiscing elit |

  Scenario Outline: Check that Lorem Ipsum is generated with correct size
    When User clicks on '<button>'
    And User inputs '<number>' into the number field
    And User clicks on Generate Lorem Ipsum button
    Then User checks that the result has correct number of words '<expectedNumber>' '<button>'
    Examples:
      | button | number | expectedNumber |
      | words  | 10     | 10             |
      | words  | 0      | 5              |
      | words  | -1     | 5              |
      | words  | 5      | 5              |
      | words  | 20     | 20             |
      | bytes  | 10     | 10             |
      | bytes  | -1     | 5              |
      | bytes  | 0      | 5              |
      | bytes  | 1      | 3              |
      | bytes  | 2      | 3              |
      | bytes  | 3      | 3              |

  Scenario: Check the checkbox
    When User unchecks start with Lorem Ipsum checkbox
    And User clicks on Generate Lorem Ipsum button
    Then User result no longer starts with phrase
      |Lorem ipsum |

  Scenario Outline: Check that generated paragraphs contain "lorem" with probability of more than 40%
    When User counts the paragraphs containing '<word>' clicking on Generate Lorem Ipsum button <times>
    Then User checks that the average paragraphs number containing word <times>
    Examples:
      |word  |times|
      |lorem |10   |


