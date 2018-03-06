package com.seeuletter;


import com.seeuletter.model.Address;
import com.seeuletter.model.Letter;
import com.seeuletter.net.SeeuletterResponse;

import java.util.HashMap;
import java.util.Map;

public class Example {

    public static void main(String[] args) throws Exception {
        System.out.println("Seeuletter Java Wrapper");

        Seeuletter.init("test_f23ac669-f7ee-4f2a-a669-e843e9c2938c");


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
                .setDescription("Send with the Java Wrapper")
                .setBothSides(false)
                .setSourceFile("<h1>Hello from {{website}}</h1>")
                .setPostageType("prioritaire")
                .setColor("bw")
                .setVariables(variables)
                .setPdfMargin(20)
                .create();

        Letter letter = response.getResponseBody();

        System.out.println(letter);
        System.out.println(letter.getCreatedAt());
        System.out.println(letter.getTo().getPostalCode());
        System.out.println(letter.getFile().getUrl());
        System.out.println(letter.getPrice());
        System.out.println(letter.getVariables());
        System.out.println(letter.getEvents());
        //System.out.println(letter.getFile());




        SeeuletterResponse<Letter> response_get = Letter.retrieve("B18L9ljuz");
        Letter Letter = response_get.getResponseBody();


        System.out.println(Letter);

    } // end method main


}
