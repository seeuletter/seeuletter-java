package com.seeuletter.model;

import com.seeuletter.BaseTest;
import com.seeuletter.net.SeeuletterResponse;
import org.junit.Test;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class LetterTest extends BaseTest {

    @Test
    public void testListLetters() throws Exception {
        SeeuletterResponse<LetterCollection> response = Letter.list();

        assertEquals(200, response.getResponseCode());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Letter.class));
    }

    @Test
    public void testListLetterWithParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("limit", 1);

        SeeuletterResponse<LetterCollection> response = Letter.list(params);

        assertEquals(200, response.getResponseCode());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Letter.class));
    }

    @Test
    public void testRetrieveLetter() throws Exception {
        Letter testLetter = Letter.list().getResponseBody().getData().get(0);

        SeeuletterResponse<Letter> response = Letter.retrieve(testLetter.getId());
        Letter Letter = response.getResponseBody();

        assertEquals(testLetter.getId(), Letter.getId());
    }

    @Test
    public void testCreateFileLetter() throws Exception {
        final File file = new File(getClass().getClassLoader().getResource("PDF_Lettre_Bienvenue.pdf").getPath());

        SeeuletterResponse<Letter> response = new Letter.RequestBuilder()
                .setDescription("Test Letter")
                .setSourceFile(file)
                .setTo(new Address.RequestBuilder()
                        .setName("Seeuletter")
                        .setLine1("25 passage dubail")
                        .setCity("Paris")
                        .setPostalCode("75010")
                        .setCountry("France"))
                .setSourceFileType("file")
                .setColor("bw")
                .setPostageType("prioritaire")
                .create();

        Letter letter = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(letter.getId());
        assertEquals("letter", letter.getObject());
    }

    @Test
    public void testCreateCertifiedLetter() throws Exception {

        final File file = new File(getClass().getClassLoader().getResource("PDF_Lettre_Bienvenue.pdf").getPath());

        final Map<String, String> variables = new HashMap<String, String>();
        variables.put("name", "Seeuletter.com");

        SeeuletterResponse<Letter> response = new Letter.RequestBuilder()
                .setTo(new Address.RequestBuilder()
                        .setName("Seeuletter")
                        .setLine1("25 passage dubail")
                        .setCity("Paris")
                        .setPostalCode("75010")
                        .setCountry("France"))
                .setSourceFile("<h1>Hello from {{name}}</h1>")
                .setSourceFileType("html")
                .setSourceFile2(file)
                .setSourceFile2Type("file")
                .setPostageType("prioritaire")
                .setPdfMargin(20)
                .setVariables(variables)
                .setColor("bw")
                .create();

        Letter letter = response.getResponseBody();

        assertEquals(200, response.getResponseCode());
        assertNotNull(letter.getId());
        assertEquals("letter", letter.getObject());
        assertEquals(Integer.valueOf(2), letter.getPageCount());
        assertEquals(Integer.valueOf(1), letter.getSheetCount());
        assertEquals("test", letter.getMode());
        assertEquals("75010", letter.getTo().getPostalCode());
    }

}
