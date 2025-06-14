/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.glean.api_client.glean_api_client.models.operations.PostApiIndexV1ProcessallemployeesandteamsResponse;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Exception;
import org.junit.jupiter.api.Test;

public class PeopleTests {

    @Test
    public void testPeople_PostApiIndexV1Processallemployeesandteams() throws Exception {

        var testHttpClient = Utils.createTestHTTPClient("post_/api/index/v1/processallemployeesandteams");
        Glean sdk = Glean.builder()
                .serverURL(Utils.environmentVariable("TEST_SERVER_URL", "http://localhost:18080"))
                .client(testHttpClient)
                .apiToken("<YOUR_BEARER_TOKEN_HERE>")
            .build();

        PostApiIndexV1ProcessallemployeesandteamsResponse res = sdk.indexing().people().processAllEmployeesAndTeams()
                .call();
        assertEquals(200, res.statusCode());
    }
}