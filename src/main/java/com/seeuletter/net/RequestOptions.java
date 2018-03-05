package com.seeuletter.net;

import java.util.Objects;

import com.seeuletter.Seeuletter;

public class RequestOptions {
    public static RequestOptions getDefault() {
        return new RequestOptions(Seeuletter.apiKey, Seeuletter.apiVersion, null);
    }

    private final String apiKey;
    private final String seeuletterVersion;
    private final String idempotencyKey;

    private RequestOptions(String apiKey, String seeuletterVersion, String idempotencyKey) {
        this.apiKey = apiKey;
        this.seeuletterVersion = seeuletterVersion;
        this.idempotencyKey = idempotencyKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSeeuletterVersion() {
        return seeuletterVersion;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        else if (o instanceof RequestOptions) {
            RequestOptions that = (RequestOptions) o;
            
            if (!Objects.equals(this.apiKey, that.getApiKey())) {
                return false;
            }
            
            if (!Objects.equals(this.seeuletterVersion, that.getSeeuletterVersion())) {
                return false;
            }
    
            if (!Objects.equals(this.idempotencyKey, that.getIdempotencyKey())) {
                return false;
            }       
            
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(apiKey, seeuletterVersion, idempotencyKey);
    }    

    public static final class Builder {
        private String apiKey;
        private String seeuletterVersion;
        private String idempotencyKey;

        public Builder() {
            this.apiKey = Seeuletter.apiKey;
            this.seeuletterVersion = Seeuletter.apiVersion;
        }

        public String getApiKey() {
            return this.apiKey;
        }

        public Builder setApiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder setSeeuletterVersion(String seeuletterVersion) {
            this.seeuletterVersion = seeuletterVersion;
            return this;
        }

        public String getSeeuletterVersion() {
            return this.seeuletterVersion;
        }

        public Builder setIdempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public String getIdempotencyKey() {
            return this.idempotencyKey;
        }

        public RequestOptions build() {
            return new RequestOptions(this.apiKey, this.seeuletterVersion, this.idempotencyKey);
        }
    }

}
