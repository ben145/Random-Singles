# Random-Singles
Single-paged programs that do not rely on other files

## Cryptoquip
* Based on the game found in your local newspaper, where a punny answer is masked with different letters and an initial letter-to-letter hint is provided to help solve the puzzle.
* An initial set of characters to remain unmasked is established, while all letter characters are converted to another letter, but kept consistent throughout the puzzle (ie. if "A" is "Q" in the word "WH<strong>A</strong>T", then it is also "Q" in "S<strong>A</strong>Y", etc.)
* Provides a "warning" to the user if a letter only occurs once in the puzzle. If the answer was "TO BE OR NOT TO BE", a message would appear stating that "R" and "N" only occur once. (This would be an issue regarding cross-referencing a letter in the puzzle; if a letter occurs at least twice, one can verify the letter-to-letter conversion makes sense, but if only one instance of a letter is present, this cannot be done.)

## Hangman
Wordbank of puzzle answers are Pokemon (easily changeable). You receive five (5) guesses, with an available one-time-only hint that costs 1 guess. Records user's guesses and alerts user if a wrong letter is guessed, providing user with number of remaining guesses available. Provides answer when user has run out of guesses.
