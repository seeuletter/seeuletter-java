package com.seeuletter.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class InvoiceCollection extends SeeuletterCollection<Invoice> {

    @JsonCreator
    public InvoiceCollection(
            @JsonProperty("invoices") final List<Invoice> invoices) {
        super(invoices);
    }

}
