### Basically 
- Optional type was introduced in Java 8 to provide a clear (explicit) way to handle situations where a value may or may not be present, without using null.
  Why would we want that? 
  Well, to reduce/avoid "NullPointerExceptions" errors.
  - Optional is a wrapper class that makes a field optional, indicating that it may or may not have a value.
    Example : `Optional<Integer> op=Optional.ofNullable(null);`
  - Enhances readability by explicitly showing the possibility of absence of a value.
    
- get() on an Optional object that is empty (null) gives `NoSuchElementException`
  we need to use `isPresent()` method to use get()
  
  ```js
    if (op.isPresent()) {
        System.out.println(op.get());
    }
  ```

  - get() method works, but it's recommended to use orElse() or orElseGet() to handle cases where the value is absent.

    ```js
    // Accessing value using orElse() when value is absent
        Optional<String> emptyOptional = Optional.empty();
        String defaultValue = emptyOptional.orElse("Default Value");
        System.out.println("Default Value: " + defaultValue);
    ```
  - There are other **`orElse` statements** , 
    - orElseGet() could be used to get data from a function
     ```java
      // Using orElseGet() to provide a default value using a Supplier
        String defaultValueFromSupplier = optionalString.orElseGet(() -> "Default Value from Supplier");
        System.out.println("Default Value from Supplier: " + defaultValueFromSupplier);
      ```

    - orElseThrow() can throw an exception error
     ```java
      // Using orElseThrow() to throw an exception if value is absent
        try {
            String value = optionalString.orElseThrow(() -> new RuntimeException("Value is absent"));
        } catch (RuntimeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
      ```
  - 
      ```java
      Optional.of("some value")
      
      Optional.empty() // see nothing here
      
      String var = "some value, but could be null"
      var = null
      Optional.ofNullable(var)
      ```  
  
