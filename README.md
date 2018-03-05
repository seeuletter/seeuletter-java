# seeuletter-java

[![Maven Central](https://img.shields.io/maven-central/v/com.seeuletter/seeuletter-java.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.seeuletter%22%20AND%20a%3A%22seeuletter-java%22)
[![Build Status](https://secure.travis-ci.org/seeuletter/seeuletter-java.svg)](https://travis-ci.org/seeuletter/seeuletter-java)
[![Coverage Status](https://coveralls.io/repos/seeuletter/seeuletter-java/badge.svg?branch=master)](https://coveralls.io/r/seeuletter/seeuletter-java)

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
    <version>1.0.0</version>
  </dependency>
  ...
</dependencies>
```

Gradle:

```groovy
compile 'com.seeuletter:seeuletter-java:1.0.0'
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

Seeuletter.init("yourApiKey");
```


## Testing

You can run all tests with the command `mvn test` in the main directory.

=======================

Copyright &copy; 2017 Seeuletter.com

Released under the MIT License, which can be found in the repository in `LICENSE.txt`.
