package com.seeuletter;


import com.seeuletter.model.Address;
import com.seeuletter.model.Letter;
import com.seeuletter.net.SeeuletterResponse;

public class Example {

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Java Programming!");

        Seeuletter.init("test_9de14732-7726-41c3-8e5f-daf071d2756a");

        SeeuletterResponse<Letter> response = new Letter.RequestBuilder()
                .setSourceFile("<h1>Hello from Seeuletter</h1>")
                .setTo(
                        new Address.RequestBuilder()
                                .setName("Seeuletter")
                                .setLine1("25 passage dubail")
                                .setCity("Paris")
                                .setPostalCode("75010")
                                .setCountry("France")
                )
                .setSourceFileType("html")
                .setPostageType("prioritaire")
                .setColor("bw")
                .create();

        Letter letter = response.getResponseBody();

        System.out.println(letter);
        System.out.println(letter.getCreatedAt());
        System.out.println(letter.getTo().getPostalCode());
        System.out.println(letter.getFile().getUrl());
        //System.out.println(letter.getFile());

    } // end method main

}
