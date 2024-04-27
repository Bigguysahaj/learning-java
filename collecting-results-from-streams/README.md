### Overview

- Collecting results from streams is a common operation in Java,
  especially when you want to transform or aggregate data from a stream into
  a collection or a single result.
  
  What I think, it's kinda like how I need to take streaming data from openai or any llm into an array to showcase?

- Collecting elements into a List:
You can collect elements from a stream into a List using the Collectors.toList() method.
  ```java
    List<String> strings = Arrays.asList("foo", "bar", "baz");
        List<String> collectedList = strings.stream().collect(Collectors.toList());
        System.out.println(collectedList); // Output: [foo, bar, baz]
  ```
- Collecting elements into a Set:

  ```java
    List<String> strings = Arrays.asList("foo", "bar", "baz");
    Set<String> collectedSet = strings.stream().collect(Collectors.toSet());
    System.out.println(collectedSet); // Output: [foo, bar, baz]
  ```
- Collecting elements into a String
  ```java
  List<String> strings = Arrays.asList("apple", "banana", "cherry");
        String collectedString = strings.stream().collect(Collectors.joining(", "));
        System.out.println(collectedString); // Output: apple, banana, cherry
  ```
- Can summaries into one object
  ```java
  IntSummaryStatistics stats = strings.stream()
                .collect(Collectors.summarizingInt(String::length));
        
        double avglen = stats.getAverage();
        int maxlen = stats.getMax(); // Use int for max length, as it's an integer value.
        
```
