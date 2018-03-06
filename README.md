# seeuletter-java

[![Maven Central](https://img.shields.io/maven-central/v/com.seeuletter/seeuletter-java.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.seeuletter%22%20AND%20a%3A%22seeuletter-java%22)

Seeuletter.com Java wrapper is a simple but flexible wrapper for the [Seeuletter.com](https://www.seeuletter.com) API. See full Seeuletter.com documentation [here](https://docs.seeuletter.com/). For best results, be sure that you're using the latest version of the Seeuletter API and the latest version of the PHP wrapper.

## Table of Contents

- [Getting Started](#getting-started)
  - [Registration](#registration)
  - [Installation](#installation)
  - [Usage](#usage)
- [Examples](#examples)

## Getting Started

Here's a general overview of the Seeuletter services available, click through to read more.


Please read through the official [API Documentation](https://docs.seeuletter.com/?java#) to get a complete sense of what to expect from each endpoint.

### Registration

First, you will need to first create an account at [Seeuletter.com](https://www.seeuletter.com/signup) and obtain your Test and Live API Keys.

Once you have created an account, you can access your API Keys from the [API keys Panel](https://www.seeuletter.com/app/dashboard/keys).

### Installation

Include the following in your `pom.xml` for Maven:

```xml
<dependencies>
  <dependency>
    <groupId>com.seeuletter</groupId>
    <artifactId>seeuletter-java</artifactId>
    <version>1.0.1</version>
  </dependency>
  ...
</dependencies>
```

Gradle:

```groovy
compile 'com.seeuletter:seeuletter-java:1.0.1'
```

#### Initialization and Configuration
```java
import com.seeuletter.Seeuletter;
import com.seeuletter.model.Address;
import com.seeuletter.model.Letter;
import com.seeuletter.net.SeeuletterResponse;


Seeuletter.init("yourApiKey");
```

You may optionally set an API version. This is useful for testing your code against new API versions before you upgrade.
```java
import com.seeuletter.Seeuletter;
import com.seeuletter.model.Address;
import com.seeuletter.model.Letter;
import com.seeuletter.net.SeeuletterResponse;

Seeuletter.init("yourApiKey");
```

### Usage

We've provided examples in the `seeuletter-java-examples/` package that has examples of how to use the seeuletter-java wrapper with some of our core endpoints.


#### Create a new Letter

```java
Seeuletter.init("test_12345678901234567890");

final File file = new File(getClass().getClassLoader().getResource("local_file.pdf").getPath());

SeeuletterResponse<Letter> response = new Letter.RequestBuilder()
    .setTo(
        new Address.RequestBuilder()
            .setName("Seeuletter")
            .setLine1("25 passage dubail")
            .setCity("Paris")
            .setPostalCode("75010")
            .setCountry("France")
    )
    .setSourceFileType("file")
    .setSourceFile(file)
    .setPostageSpeed("D1")
    .setDescription("Send with the Java Wrapper")
    .setBothSides(false)
    .setPostageType("prioritaire")
    .setColor("bw")
    .setVariables(variables)
    .setPdfMargin(5)
    .create();

Letter letter = response.getResponseBody();

System.out.println(letter);
```

#### Get a specific letter

```java
Seeuletter.init("test_12345678901234567890");

SeeuletterResponse<Letter> response = Letter.retrieve("LETTER_ID");
Letter Letter = response.getResponseBody();

System.out.println(Letter);
```



## Testing

You can run all tests with the command `mvn test` in the main directory.

=======================

Copyright &copy; 2018 Seeuletter.com

Released under the MIT License, which can be found in the repository in `LICENSE.txt`.
