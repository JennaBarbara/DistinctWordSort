## Problem Statement

“Given a very large text file that may not fit in available memory, create a file that contains the distinct
words from the original file sorted in the ascending order.”

## Assumptions

- Only words using the English alphabet need to be counted.
- The words should be sorted alphabetically rather than by number of occurrences.
- The text in the input file has line breaks/new paragraphs throughout, so no line in the input file will overwhelm memory
- That the use case of this project is not time sensitive. I understand that in the real world, most use cases associated with this problem statement would be time sensitive. However, due to the time limit of this project I don't have time to implement the multithreading component to optimize this project, so I am making this assumption.
