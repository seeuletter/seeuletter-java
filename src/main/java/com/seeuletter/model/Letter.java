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
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter extends APIResource {

    public static final String RESOURCE = "letters";

    @JsonProperty private final String _id;
    @JsonProperty private final String description;
    @JsonProperty private final String mode;
    @JsonProperty private final Address to;
    @JsonProperty private final Address from;
    @JsonProperty private final String color;
    @JsonProperty private final boolean bothSides;
    @JsonProperty private final String addressPlacement;
    @JsonProperty private final String sourceFileType;
    @JsonProperty private final String postageType;
    @JsonProperty private final String postageSpeed;
    @JsonProperty private final boolean manageDeliveryProof;
    @JsonProperty private final Integer pageCount;
    @JsonProperty private final Integer pdfMargin;
    @JsonProperty private final String envelope;
    @JsonProperty private final com.seeuletter.model.File file;
    @JsonProperty private final String sourceFile2;
    @JsonProperty private final String sourceFile2Type;
    @JsonProperty private final Integer sheetCount;
    @JsonProperty private final String trackingNumber;
    @JsonProperty private final LocalDate expectedDeliveryDate;
    @JsonProperty private final ZonedDateTime createdAt;
    @JsonProperty private final ZonedDateTime updatedAt;
    @JsonProperty private final ZonedDateTime sendDate;
    @JsonProperty private final Map<String, String> metadata;
    @JsonProperty private final boolean deleted;
    @JsonProperty private final String object;

    @JsonCreator
    public Letter(
            @JsonProperty("_id") final String _id,
            @JsonProperty("description") final String description,
            @JsonProperty("mode") final String mode,
            @JsonProperty("to") final Address to,
            @JsonProperty("from") final Address from,
            @JsonProperty("color") final String color,
            @JsonProperty("both_sides") final boolean bothSides,
            @JsonProperty("address_placement") final String addressPlacement,
            @JsonProperty("source_file_type") final String sourceFileType,
            @JsonProperty("postage_type") final String postageType,
            @JsonProperty("postage_speed") final String postageSpeed,
            @JsonProperty("manage_delivery_proof") final boolean manageDeliveryProof,
            @JsonProperty("page_count") final Integer pageCount,
            @JsonProperty("sheet_count") final Integer sheetCount,
            @JsonProperty("pdf_margin") final Integer pdfMargin,
            @JsonProperty("envelope") final String envelope,
            @JsonProperty("file") final com.seeuletter.model.File file,
            @JsonProperty("source_file_2") final String sourceFile2,
            @JsonProperty("source_file_2_type") final String sourceFile2Type,
            @JsonProperty("tracking_number") final String trackingNumber,
            @JsonProperty("expected_delivery_date") final LocalDate expectedDeliveryDate,
            @JsonProperty("created_at") final ZonedDateTime createdAt,
            @JsonProperty("updated_at") final ZonedDateTime updatedAt,
            @JsonProperty("send_date") final ZonedDateTime sendDate,
            @JsonProperty("metadata") final Map<String, String> metadata,
            @JsonProperty("deleted") final boolean deleted,
            @JsonProperty("object") final String object) {
        this._id = _id;
        this.description = description;
        this.mode = mode;
        this.to = to;
        this.from = from;
        this.color = color;
        this.bothSides = bothSides;
        this.addressPlacement = addressPlacement;
        this.sourceFileType = sourceFileType;
        this.postageType = postageType;
        this.postageSpeed = postageSpeed;
        this.manageDeliveryProof = manageDeliveryProof;
        this.pageCount = pageCount;
        this.pdfMargin = pdfMargin;
        this.envelope = envelope;
        this.file = file;
        this.sourceFile2 = sourceFile2;
        this.sourceFile2Type = sourceFile2Type;
        this.sheetCount = sheetCount;
        this.trackingNumber = trackingNumber;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.sendDate = sendDate;
        this.metadata = metadata;
        this.deleted = deleted;
        this.object = object;
    }

    public String getId() {
        return _id;
    }

    public String getDescription() {
        return description;
    }

    public String getMode() {
        return mode;
    }

    public Address getTo() {
        return to;
    }

    public Address getFrom() {
        return from;
    }

    public String isColor() {
        return color;
    }

    public boolean isBothSides() {
        return bothSides;
    }

    public String getAddressPlacement() {
        return addressPlacement;
    }

    public String getPostageType() {
        return postageType;
    }

    public String getPostageSpeed() {
        return postageSpeed;
    }

    public String getSourceFileType() {
        return sourceFileType;
    }

    public boolean isManageDeliveryProof() {
        return manageDeliveryProof;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public Integer getPdfMargin() {
        return pdfMargin;
    }

    public String getEnvelope() {
        return envelope;
    }

    public com.seeuletter.model.File getFile() {
        return file;
    }

    public String getSourceFile2() {
        return sourceFile2;
    }

    public String getSourceFile2Type() {
        return sourceFile2Type;
    }

    public Integer getSheetCount() {
        return sheetCount;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public ZonedDateTime getSendDate() {
        return sendDate;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "_id='" + _id + '\'' +
                ", description='" + description + '\'' +
                ", mode='" + mode + '\'' +
                ", to=" + to +
                ", from=" + from +
                ", color=" + color +
                ", bothSides=" + bothSides +
                ", addressPlacement='" + addressPlacement + '\'' +
                ", sourceFileType='" + sourceFileType + '\'' +
                ", postageType='" + postageType + '\'' +
                ", postageSpeed='" + postageSpeed + '\'' +
                ", manageDeliveryProof=" + manageDeliveryProof +
                ", pageCount=" + pageCount +
                ", pdfMargin='" + pdfMargin + '\'' +
                ", envelope='" + envelope + '\'' +
                ", file='" + file + '\'' +
                ", sourceFile2='" + sourceFile2 + '\'' +
                ", sourceFile2Type='" + sourceFile2Type + '\'' +
                ", sheetCount='" + sheetCount + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", expectedDeliveryDate=" + expectedDeliveryDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", sendDate=" + sendDate +
                ", metadata=" + metadata +
                ", deleted=" + deleted +
                ", object='" + object + '\'' +
                '}';
    }

    public static final class RequestBuilder {
        private Map<String, Object> params = new HashMap<String, Object>();
        private boolean isMultipart = false;

        public RequestBuilder() {
        }

        public RequestBuilder setDescription(String description) {
            params.put("description", description);
            return this;
        }

        public RequestBuilder setTo(String to) {
            params.put("to", to);
            return this;
        }

        public RequestBuilder setTo(Address.RequestBuilder to) {
            params.put("to", to.build());
            return this;
        }

        public RequestBuilder setFrom(String from) {
            params.put("from", from);
            return this;
        }

        public RequestBuilder setFrom(Address.RequestBuilder from) {
            params.put("from", from.build());
            return this;
        }


        public RequestBuilder setColor(String color) {
            params.put("color", color);
            return this;
        }

        public RequestBuilder setSourceFile(String file) {
            params.put("source_file", file);
            return this;
        }

        public RequestBuilder setSourceFile(File file) {
            isMultipart = true;
            params.put("source_file", file);
            return this;
        }

        public RequestBuilder setVariables(Map<String, String> variables) {
            params.put("merge_variables", variables);
            return this;
        }

        public RequestBuilder setBothSides(boolean bothSides) {
            params.put("both_sides", bothSides);
            return this;
        }

        public RequestBuilder setAddressPlacement(String addressPlacement) {
            params.put("address_placement", addressPlacement);
            return this;
        }

        public RequestBuilder setSourceFileType(String sourceFileType) {
            params.put("source_file_type", sourceFileType);
            return this;
        }

        public RequestBuilder setPostageType(String postageType) {
            params.put("postage_type", postageType);
            return this;
        }

        public RequestBuilder setPostageSpeed(String postageSpeed) {
            params.put("postage_speed", postageSpeed);
            return this;
        }

        public RequestBuilder setManageDeliveryProof(boolean manageDeliveryProof) {
            params.put("manage_delivery_proof", manageDeliveryProof);
            return this;
        }

        public RequestBuilder setPageCount(int pageCount) {
            params.put("page_count", pageCount);
            return this;
        }

        public RequestBuilder setEnvelope(String envelope) {
            params.put("envelope", envelope);
            return this;
        }

        public RequestBuilder setPdfMargin(int pdfMargin) {
            params.put("pdf_margin", pdfMargin);
            return this;
        }

        public RequestBuilder setSendDate(String sendDate) {
            params.put("send_date", sendDate);
            return this;
        }

        public RequestBuilder setSendDate(ZonedDateTime sendDate) {
            params.put("send_date", sendDate);
            return this;
        }


        public RequestBuilder setMetadata(Map<String, String> metadata) {
            params.put("metadata", metadata);
            return this;
        }


        public SeeuletterResponse<Letter> create() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
            return create(null);
        }

        public SeeuletterResponse<Letter> create(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException  {
            if (isMultipart) {
                return request(RequestMethod.POST, RequestType.MULTIPART, RESOURCE, params, Letter.class, options);
            }

            return request(RequestMethod.POST, RequestType.NORMAL, RESOURCE, params, Letter.class, options);
        }
    }

    public static SeeuletterResponse<Letter> retrieve(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return retrieve(id, null);
    }

    public static SeeuletterResponse<Letter> retrieve(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null, Letter.class, options);
    }

    public static SeeuletterResponse<LetterCollection> list() throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, null);
    }

    public static SeeuletterResponse<LetterCollection> list(Map<String, Object> params) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(params, null);
    }

    public static SeeuletterResponse<LetterCollection> list(RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return list(null, options);
    }

    public static SeeuletterResponse<LetterCollection> list(Map<String, Object> params, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.GET, RequestType.NORMAL, RESOURCE, params, LetterCollection.class, options);
    }

    public static SeeuletterResponse<Letter> delete(String id) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return delete(id, null);
    }

    public static SeeuletterResponse<Letter> delete(String id, RequestOptions options) throws APIException, IOException, AuthenticationException, InvalidRequestException, RateLimitException {
        return request(RequestMethod.DELETE, RequestType.NORMAL, String.format("%s/%s", RESOURCE, id), null, Letter.class, options);
    }

}
