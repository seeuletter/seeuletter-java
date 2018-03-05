# seeuletter-java

[![Maven Central](https://img.shields.io/maven-central/v/com.seeuletter/seeuletter-java.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.seeuletter%22%20AND%20a%3A%22seeuletter-java%22)
[![Build Status](https://secure.travis-ci.org/seeuletter/seeuletter-java.svg)](https://travis-ci.org/seeuletter/seeuletter-java)
[![Coverage Status](https://coveralls.io/repos/seeuletter/seeuletter-java/badge.svg?branch=master)](https://coveralls.io/r/seeuletter/seeuletter-java)

Java wrapper for the [Seeuletter.com](http://seeuletter.com) API. See the full Seeuletter.com [API Documentation](https://seeuletter.com/docs/java).  For best results, be sure that you're using [the latest version](https://seeuletter.com/docs/java#version) of the Seeuletter API and the latest version of the java wrapper.

## Table of Contents

- [Getting Started](#getting-started)
  - [Registration](#registration)
  - [Installation](#installation)
  - [Usage](#usage)
- [Examples](#examples)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [Testing](#testing)

## Getting Started

Here's a general overview of the Seeuletter services available, click through to read more.

- [Postcards API](https://seeuletter.com/services/postcards)
- [Letters API](https://seeuletter.com/services/letters)
- [Checks API](https://seeuletter.com/services/checks)
- [Area Mail API](https://seeuletter.com/services/area)
- [Address Verification API](https://seeuletter.com/verification/address)

Please read through the official [API Documentation](#api-documentation) to get a complete sense of what to expect from each endpoint.

### Registration

First, you will need to first create an account at [Seeuletter.com](https://dashboard.seeuletter.com/#/register) and obtain your Test and Live API Keys.

Once you have created an account, you can access your API Keys from the [Settings Panel](https://dashboard.seeuletter.com/#/settings).

### Installation

Include the following in your `pom.xml` for Maven:

```xml
<dependencies>
  <dependency>
    <groupId>com.seeuletter</groupId>
    <artifactId>seeuletter-java</artifactId>
    <version>7.0.0</version>
  </dependency>
  ...
</dependencies>
```

Gradle:

```groovy
compile 'com.seeuletter:seeuletter-java:7.0.0'
```

### Usage

We've provided examples in the `seeuletter-java-examples/` package that has examples of how to use the seeuletter-java wrapper with some of our core endpoints.

#### Initialization and Configuration
```java
import com.seeuletter;

Seeuletter.init("yourApiKey");
```

You may optionally set an API version. This is useful for testing your code against new API versions before you upgrade.
```java
import com.seeuletter;

Seeuletter.init("yourApiKey", "yourApiVersion");
```

## API Documentation

- [Introduction](https://seeuletter.com/docs/java#introduction)
- [Versioning](https://seeuletter.com/docs/java#version)
- [Errors](https://seeuletter.com/docs/java#errors)
- [Rate Limiting](https://seeuletter.com/docs/java#rate-limits)
- [Webhooks](https://seeuletter.com/docs/java#webhooks)
- [Cancellation Windows](https://seeuletter.com/docs/java#cancellation)
- [Scheduled Mailings](https://seeuletter.com/docs/java#scheduled)
- [Metadata](https://seeuletter.com/docs/java#metadata)
- [HTML Templates](https://seeuletter.com/docs/java#templates)
- [Asset URLs](https://seeuletter.com/docs/java#urls)
- **Addresses**
  - [Address Book](https://seeuletter.com/docs/java#addresses)
    - [The Address Object](https://seeuletter.com/docs/java#addresses_object)
    - [Create an Address](https://seeuletter.com/docs/java#addresses_create)
    - [Retrieve an Address](https://seeuletter.com/docs/java#addresses_retrieve)
    - [Delete an Address](https://seeuletter.com/docs/java#addresses_delete)
    - [List all Addresses](https://seeuletter.com/docs/java#addresses_list)
- **US Verification API**
  - [US Verification API](https://seeuletter.com/docs/java#us_verifications)
    - [The US Verification Object](https://seeuletter.com/docs/java#us_verifications_object)
    - [Verify a US Address](https://seeuletter.com/docs/java#us_verifications_create)
- **Int'l Verification API**
  - [International Verifications](https://seeuletter.com/docs/java#intl_verifications)
    - [Verify an International Address](https://seeuletter.com/docs/java#intl_verifications_create)
- **Postcards API**
  - [Postcards](https://seeuletter.com/docs/java#postcards)
    - [The Postcard Object](https://seeuletter.com/docs/java#postcards_object)
    - [Create a Postcard](https://seeuletter.com/docs/java#postcards_create)
    - [Retrieve a Postcard](https://seeuletter.com/docs/java#postcards_retrieve)
    - [Cancel a Postcard](https://seeuletter.com/docs/java#postcards_delete)
    - [List all Postcards](https://seeuletter.com/docs/java#postcards_list)
- **Letters API**
  - [Letters](https://seeuletter.com/docs/java#letters)
    - [The Letter Object](https://seeuletter.com/docs/java#letters_object)
    - [Create a Letter](https://seeuletter.com/docs/java#letters_create)
    - [Retrieve a Letter](https://seeuletter.com/docs/java#letters_retrieve)
    - [Cancel a Letter](https://seeuletter.com/docs/java#letters_delete)
    - [List all Letters](https://seeuletter.com/docs/java#letters_list)
- **Checks API**
  - [Checks](https://seeuletter.com/docs/java#checks)
    - [The Check Object](https://seeuletter.com/docs/java#checks_object)
    - [Create a Check](https://seeuletter.com/docs/java#checks_create)
    - [Retrieve a Check](https://seeuletter.com/docs/java#checks_retrieve)
    - [Cancel a Check](https://seeuletter.com/docs/java#checks_delete)
    - [List all Checks](https://seeuletter.com/docs/java#checks_list)
  - [Bank Accounts](https://seeuletter.com/docs/java#bank-accounts)
    - [The Bank Account Object](https://seeuletter.com/docs/java#bankaccounts_object)
    - [Create a Bank Account](https://seeuletter.com/docs/java#bankaccounts_create)
    - [Retrieve a Bank Account](https://seeuletter.com/docs/java#bankaccounts_retrieve)
    - [Delete a Bank Account](https://seeuletter.com/docs/java#bankaccounts_delete)
    - [Verify a Bank Account](https://seeuletter.com/docs/java#bankaccounts_verify)
    - [List all Bank Accounts](https://seeuletter.com/docs/java#bankaccounts_list)
- **Area Mail API**
  - [Areas](https://seeuletter.com/docs/java#areas)
    - [The Area Object](https://seeuletter.com/docs/java#areas_object)
    - [Create an Area Mailing](https://seeuletter.com/docs/java#areas_create)
    - [Retrieve an Area Mailing](https://seeuletter.com/docs/java#areas_retrieve)
    - [List all Area Mailings](https://seeuletter.com/docs/java#areas_list)
  - [Routes](https://seeuletter.com/docs/java#routes)
    - [The Routes Object](https://seeuletter.com/docs/java#routes_object)
    - [Retrieve Routes](https://seeuletter.com/docs/java#routes_retrieve)
    - [List all Routes](https://seeuletter.com/docs/java#routes_list)
- **Resources**
  - [Countries](https://seeuletter.com/docs/java#countries)
    - [List all Countries](https://seeuletter.com/docs/java#countries_list)
  - [States](https://seeuletter.com/docs/java#states)
    - [List all States](https://seeuletter.com/docs/java#states_list)
- **Appendix**
  - [API Changelog](https://seeuletter.com/docs/java#changelog)
  - [The Tracking Event Object](https://seeuletter.com/docs/java#tracking_event_object)
  - [Events](https://seeuletter.com/docs/java#events)
  - [HTML Examples](https://seeuletter.com/docs/java#html-examples)
  - [Image Prepping](https://seeuletter.com/docs/java#prepping)
  - [US Verification Details](https://seeuletter.com/docs/java#us_verification_details)


## Testing

You can run all tests with the command `mvn test` in the main directory.

=======================

Copyright &copy; 2017 Seeuletter.com

Released under the MIT License, which can be found in the repository in `LICENSE.txt`.
