package com.seeuletter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SeeuletterTest {

    @Test
    public void testSeeuletterInit() {
        final String API_KEY = "test_7a6d67a5-1922-425f-9db0-ae4e4cbbdc6d";

        Seeuletter.init(API_KEY);
        assertEquals(API_KEY, Seeuletter.apiKey);
        assertNull(Seeuletter.apiVersion);
    }

}
