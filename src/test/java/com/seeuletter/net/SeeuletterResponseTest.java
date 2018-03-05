package com.seeuletter.net;

import com.seeuletter.BaseTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SeeuletterResponseTest extends BaseTest {

    @Test
    public void testSeeuletterResponse() {
        final SeeuletterResponse<String> response = new SeeuletterResponse<String>(200, "{}");

        assertEquals(200, response.getResponseCode());
        assertEquals("{}", response.getResponseBody());
        assertNull(response.getResponseHeaders());
    }

    @Test
    public void testSeeuletterResponseWithHeaders() {
        HashMap<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("User-Agent", Arrays.asList("SeeuletterBindingsTest"));

        final SeeuletterResponse<String> response = new SeeuletterResponse<String>(200, "{}", headers);

        assertEquals(200, response.getResponseCode());
        assertEquals("{}", response.getResponseBody());
        assertEquals(Arrays.asList("SeeuletterBindingsTest"), response.getResponseHeaders().get("User-Agent"));
    }

}
