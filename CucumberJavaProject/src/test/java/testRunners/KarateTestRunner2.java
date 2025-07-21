package testRunners;  // Ensure the correct package

import com.intuit.karate.junit5.Karate;

class KarateTestRunner2 {

    @Karate.Test
    Karate testLoginAndCreatePostAPI() {
        return Karate.run("classpath:Features/api_test2.feature").relativeTo(getClass());
    }
}
