package com.seeuletter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SeeuletterTest {

    @Test
    public void testSeeuletterInit() {
        final String API_KEY = "test_f23ac669-f7ee-4f2a-a669-e843e9c2938c";

        Seeuletter.init(API_KEY);
        assertEquals(API_KEY, Seeuletter.apiKey);
        assertNull(Seeuletter.apiVersion);
    }

}
