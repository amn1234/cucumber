package testRunners;

import com.intuit.karate.junit5.Karate;

class KarateTestRunner {

    @Karate.Test
    Karate testLoginAPI() {
        return Karate.run("classpath:features/api_test.feature").relativeTo(getClass());
    }
}