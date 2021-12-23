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

public class InvoiceTest extends BaseTest {

    @Test
    public void testListInvoices() throws Exception {
        SeeuletterResponse<InvoiceCollection> response = Invoice.list();

        assertEquals(200, response.getResponseCode());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Invoice.class));
    }

    @Test
    public void testListInvoiceWithParams() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", "paid");
        params.put("date_start", "2020-01-01");

        SeeuletterResponse<InvoiceCollection> response = Invoice.list(params);

        assertEquals(200, response.getResponseCode());
        assertThat(response.getResponseBody().getData().get(0), instanceOf(Invoice.class));
    }

    @Test
    public void testRetrieveInvoice() throws Exception {
        Invoice testInvoice = Invoice.list().getResponseBody().getData().get(0);

        SeeuletterResponse<Invoice> response = Invoice.retrieve(testInvoice.getId());
        Invoice invoice = response.getResponseBody();

        assertEquals(testInvoice.getId(), invoice.getId());

        System.out.println(invoice);
    }


}
