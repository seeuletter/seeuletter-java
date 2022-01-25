package com.seeuletter.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.seeuletter.exception.APIException;
import com.seeuletter.exception.AuthenticationException;
import com.seeuletter.exception.InvalidRequestException;
import com.seeuletter.exception.RateLimitException;
import com.seeuletter.net.APIResource;
import com.seeuletter.net.SeeuletterResponse;
import com.seeuletter.net.RequestOptions;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

public class Invoice extends APIResource {

    public static final String RESOURCE = "invoices";

    @JsonProperty protected final String _id;
    @JsonProperty protected final Integer invoiceNumber;
    @JsonProperty protected final ZonedDateTime invoiceDate;
    @JsonProperty protected final ZonedDateTime dueDate;
    @JsonProperty protected final String name;
    @JsonProperty protected final String pack;
    @JsonProperty protected final ZonedDateTime paymentDate;
    @JsonProperty protected final String paymentType;
    @JsonProperty protected final InvoicePaymentInformations paymentInformations;
    @JsonProperty protected final Integer tva;
    @JsonProperty protected final String country;
    @JsonProperty protected final List<InvoiceLine> invoiceLines;
    @JsonProperty protected final InvoiceTotal total;
    @JsonProperty protected final InvoiceDiscount discount;
    @JsonProperty protected final String status;
    @JsonProperty protected final com.seeuletter.model.File file;

    @JsonCreator
    public Invoice(
            @JsonProperty("_id") final String _id,
            @JsonProperty("invoice_number") final Integer invoiceNumber,
            @JsonProperty("invoice_date") final ZonedDateTime invoiceDate,
            @JsonProperty("due_date") final ZonedDateTime dueDate,
            @JsonProperty("name") final String name,
            @JsonProperty("pack") final String pack,
            @JsonProperty("payment_date") final ZonedDateTime paymentDate,
            @JsonProperty("payment_type") final String paymentType,
            @JsonProperty("payment_informations") final InvoicePaymentInformations paymentInformations,
            @JsonProperty("tva") final Integer tva,
            @JsonProperty("country") final String country,
            @JsonProperty("invoice_lines") final List<InvoiceLine> invoiceLines,
            @JsonProperty("total") final InvoiceTotal total,
            @JsonProperty("discount") final InvoiceDiscount discount,
            @JsonProperty("status") final String status,
            @JsonProperty("file") final com.seeuletter.model.File file) {
        this._id = _id;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.name = name;
        this.pack = pack;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
        this.paymentInformations = paymentInformations;
        this.tva = tva;
        this.country = country;
        this.invoiceLines = invoiceLines;
        this.total = total;
        this.discount = discount;
        this.status = status;
        this.file = file;
    }

    public String getId() {
        return _id;
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public ZonedDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public ZonedDateTime getDueDate() {
        return dueDate;
    }

    public String getName() {
        return name;
    }

    public String getPack() {
        return pack;
    }

    public ZonedDateTime getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public InvoicePaymentInformations getPaymentInformations() {
        return  paymentInformations;
    }

    public Integer getTva() {
        return tva;
    }

    public String getCountry() {
        return country;
    }

    public List<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public InvoiceTotal getTotal() {
        return total;
    }

    public InvoiceDiscount getDiscount() {
        return discount;
    }

    public String getStatus() {
        return status;
    }

    public com.seeuletter.model.File getFile() {
        return file;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                " _id='" + _id + '\'' +
                ", invoiceNumber=" + invoiceNumber +
                ", invoiceDate='" + invoiceDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", name='" + name + '\'' +
                ", pack='" + pack + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", paymentInformations='" + paymentInformations + '\'' +
                ", tva='" + tva + '\'' +
                ", country='" + country + '\'' +
                ", invoiceLines='" + invoiceLines + '\'' +
                ", total='" + total + '\'' +
                ", discount='" + discount + '\'' +
                ", status='" + status + '\'' +
                ", file='" + file + '\'' +
                '}';
    }

    public static SeeuletterResponse<Invoice> retrieve(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return retrieve(id, null);
    }

    public static SeeuletterResponse<Invoice> retrieve(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null, Invoice.class, options);
    }

    public static SeeuletterResponse<InvoiceCollection> list() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, null);
    }

    public static SeeuletterResponse<InvoiceCollection> list(Map<String, Object> params) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(params, null);
    }

    public static SeeuletterResponse<InvoiceCollection> list(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, options);
    }

    public static SeeuletterResponse<InvoiceCollection> list(Map<String, Object> params, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, RESOURCE, params, InvoiceCollection.class, options);
    }

}
