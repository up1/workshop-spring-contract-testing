## Step to run

### Step 1 :: Build and Run Service with Gradle
```
$gradelw clean
$gradelw bootRun
```

Test API from url = http://localhost:8080/customers

### Step 2 :: Internal tests
* Spring Boot testing
* MockMvc testing
* Integration testing 
* Component testing
* Unit testing
```
$gradlew clean test
```

### Step 3 :: Run contract test (Contract Verify test)
* Use contract file to verify service
* Automatic generate test cases from contract files
```
$gradlew clean contractTest
```

### Step 4 :: Create and Upload contract and stubs to Stub storage
```

```