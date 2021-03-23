package com.seeuletter.model;

import com.seeuletter.BaseTest;
import com.seeuletter.net.SeeuletterResponse;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class LetterElectronicTest extends BaseTest {

    @Test
    public void testListLetterElectronicWithParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("channel", "electronic");

        SeeuletterResponse<LetterCollection> response = LetterElectronic.list(params);

        assertEquals(200, response.getResponseCode());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(LetterElectronic.class));
    }

    @Test
    public void testCreateFileLetterElectronic() throws Exception {
        final File file = new File(getClass().getClassLoader().getResource("PDF_Lettre_Bienvenue.pdf").getPath());

        SeeuletterResponse<LetterElectronic> responseElectronic = new LetterElectronic.RequestBuilder()
                .setTo(
                    new Address.RequestBuilder()
                        .setFirstName("Erlich")
                        .setLastName("Dumas")
                        .setEmail("seeuletter@example.com")
                        .setStatus("individual")
                )
                .setPostageType("lre")
                .setSourceFile(file, "file")
                .setDescription("Sent Electronic with the Java Wrapper")
                .setContent("Please review the attached documents:")
                .create();

        LetterElectronic letterElectronic = responseElectronic.getResponseBody();

        assertEquals(200, responseElectronic.getResponseCode());
        assertNotNull(letterElectronic.getId());
        assertEquals("letter", letterElectronic.getObject());
    }

}

