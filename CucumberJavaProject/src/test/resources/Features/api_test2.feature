Feature: API Testing for POST and GET

@risk_high
Scenario: Test the Login API
    Given url 'https://jsonplaceholder.typicode.com/posts'
    When method GET
    Then status 200
    And match response[0].id == 1
    And match response[0].title == 'sunt aut facere repellat provident occaecati excepturi optio reprehenderit'

@risk_low
Scenario: Create a New Post API
    Given url 'https://jsonplaceholder.typicode.com/posts'
    And header Content-Type = 'application/json'
    And request { "title": "foo", "body": "bar", "userId": 1 }
    When method POST
    Then status 201
    And match response.title == 'foo'
    And match response.body == 'bar'

@risk_high
Scenario: Retrieve Created Post
    Given url 'https://jsonplaceholder.typicode.com/posts/1'
    When method GET
    Then status 200
    And match response.id == 1
    And match response.title == 'sunt aut facere repellat provident occaecati excepturi optio reprehenderit'
    #comment to git trigger123

    