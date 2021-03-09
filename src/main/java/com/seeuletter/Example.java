package com.seeuletter;


import com.seeuletter.model.Address;
import com.seeuletter.model.Letter;
import com.seeuletter.model.LetterElectronic;
import com.seeuletter.net.SeeuletterResponse;

import java.util.HashMap;
import java.util.Map;

public class Example {

    public static void main(String[] args) throws Exception {
        System.out.println("Seeuletter Java Wrapper");

        Seeuletter.init("test_7a6d67a5-1922-425f-9db0-ae4e4cbbdc6d");

        System.out.println("----Paper");

        final Map<String, String> variables = new HashMap<String, String>();
        variables.put("website", "Seeuletter.com");

        SeeuletterResponse<Letter> response = new Letter.RequestBuilder()
                .setTo(
                        new Address.RequestBuilder()
                                .setName("Seeuletter")
                                .setLine1("25 passage dubail")
                                .setCity("Paris")
                                .setPostalCode("75010")
                                .setCountry("France")
                )
                .setSourceFileType("html")
                .setPostageSpeed("D1")
                .setDescription("Sent with the Java Wrapper")
                .setBothSides(false)
                .setSourceFile("<h1>Hello from {{website}}</h1>")
                .setPostageType("prioritaire")
                .setColor("bw")
                .setVariables(variables)
                .setPdfMargin(20)
                .create();

        Letter letter = response.getResponseBody();

        System.out.println(letter);
        System.out.println(letter.getChannel());
        System.out.println(letter.getCreatedAt());
        System.out.println(letter.getTo().getPostalCode());
        System.out.println(letter.getFile().getUrl());
        System.out.println(letter.getPrice());
        System.out.println(letter.getVariables());
        System.out.println(letter.getEvents());
        //System.out.println(letter.getFile());


        SeeuletterResponse<Letter> response_get = Letter.retrieve(letter.getId());
        Letter letter_get = response_get.getResponseBody();

        System.out.println(letter_get);

        System.out.println("----Electronic");

        SeeuletterResponse<LetterElectronic> responseElectronic = new LetterElectronic.RequestBuilder()
                .setTo(
                    new Address.RequestBuilder()
                        .setFirstName("Erlich")
                        .setLastName("Dumas")
                        .setEmail("seeuletter@example.com")
                        .setStatus("individual")
                )
                .setPostageType("lre")
                .setSourceFile("<h1>Hello from {{website}}</h1>")
                .setSourceFileType("html")
                .setDescription("Sent Electronic with the Java Wrapper")
                .setContent("Please review the attached documents:")
                .create();

        LetterElectronic letterElectronic = responseElectronic.getResponseBody();

        System.out.println(letterElectronic);
        System.out.println(letterElectronic.getChannel());
        System.out.println(letterElectronic.getCreatedAt());
        System.out.println(letterElectronic.getTo().getEmail());
        System.out.println(letterElectronic.getFile().getUrl());
        System.out.println(letterElectronic.getPrice());
        System.out.println(letterElectronic.getVariables());
        System.out.println(letterElectronic.getEvents());


        SeeuletterResponse<Letter> responseElectronic_get = Letter.retrieve(letterElectronic.getId());
        Letter letterElectronic_get = responseElectronic_get.getResponseBody();

        System.out.println(letterElectronic_get);


    } // end method main


}

