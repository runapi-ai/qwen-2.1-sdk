<p align="center">
  <a href="https://runapi.ai"><img src="https://runapi.ai/icon.svg" height="56" alt="RunAPI"></a>
</p>

<h3 align="center">
  <a href="https://github.com/runapi-ai/qwen-2.1-sdk">Qwen 2.1 API SDK for RunAPI</a>
</h3>

<p align="center">
  Qwen 2.1 API SDKs for JavaScript, Python, Ruby, Go, Java, and PHP on RunAPI.
</p>

<div align="center">

[![npm](https://img.shields.io/npm/v/@runapi.ai/qwen-2.1)](https://www.npmjs.com/package/@runapi.ai/qwen-2.1)
[![PyPI](https://img.shields.io/pypi/v/runapi-qwen-2-1)](https://pypi.org/project/runapi-qwen-2-1/)
[![RubyGems](https://img.shields.io/gem/v/runapi-qwen-2.1)](https://rubygems.org/gems/runapi-qwen-2.1)
[![Go Reference](https://pkg.go.dev/badge/github.com/runapi-ai/qwen-2.1-sdk/go.svg)](https://pkg.go.dev/github.com/runapi-ai/qwen-2.1-sdk/go)
[![Maven Central](https://img.shields.io/maven-central/v/ai.runapi/runapi-qwen-2.1)](https://central.sonatype.com/artifact/ai.runapi/runapi-qwen-2.1)
[![License](https://img.shields.io/github/license/runapi-ai/qwen-2.1-sdk)](https://github.com/runapi-ai/qwen-2.1-sdk/blob/main/LICENSE)

</div>
<br/>

The Qwen 2.1 API SDK packages JavaScript, Python, Ruby, Go, Java, and PHP clients for Qwen 2.1 on RunAPI. Use it for text-to-image and edit-image workflows when your app needs typed request builders, predictable task polling, file upload helpers, account helpers, and consistent RunAPI errors.

Qwen 2.1 is listed in the RunAPI model catalog at https://runapi.ai/models/qwen-2.1. Variant pages below carry pricing, rate-limit, and commercial-usage details. The public `qwen-2.1-sdk` repository groups the non-PHP language packages, examples, CI, and release tags for this model. The PHP package is released from a split Composer repository.

## Install

```bash
npm install @runapi.ai/qwen-2.1
pip install runapi-qwen-2-1
gem install runapi-qwen-2.1
go get github.com/runapi-ai/qwen-2.1-sdk/go@latest
```

Gradle:

```kotlin
dependencies {
  implementation("ai.runapi:runapi-qwen-2.1:0.1.0")
}
```

Maven:

```xml
<dependency>
  <groupId>ai.runapi</groupId>
  <artifactId>runapi-qwen-2.1</artifactId>
  <version>0.1.0</version>
</dependency>
```

Use the Java BOM when installing multiple RunAPI Java modules:

```kotlin
dependencies {
  implementation(platform("ai.runapi:runapi-bom:0.10.0"))
  implementation("ai.runapi:runapi-qwen-2.1")
}
```

The PHP package is published from the split Composer repository as `runapi-ai/qwen-2.1`; see https://github.com/runapi-ai/qwen-2.1-php for PHP install and examples.

## What you can build

- Build apps, agent workflows, batch jobs, and production services around Qwen 2.1 requests.
- Install only the language package your app needs while keeping one model-specific repository for docs and releases.
- Use `create` for submit-only jobs, `get` for status lookup, and `run` for submit-and-poll scripts.
- Upload local files, URL files, or base64 files through shared RunAPI file helpers.
- Handle validation, authentication, rate limits, insufficient credits, task failures, and polling timeouts through RunAPI SDK errors.

## Java quick start

```java
import ai.runapi.qwen21.Qwen21Client;
import ai.runapi.qwen21.types.TextToImageParams;
import ai.runapi.qwen21.types.CompletedTextToImageResponse;
import ai.runapi.qwen21.types.TextToImageModel;

Qwen21Client client = Qwen21Client.builder()
    .apiKey(System.getenv("RUNAPI_API_KEY"))
    .build();

CompletedTextToImageResponse result = client.textToImage().run(
    TextToImageParams.builder()
        .model(TextToImageModel.QWEN_2_1_TEXT_TO_IMAGE)
        .prompt("A minimal app icon for a media API")
        .aspectRatio("1:1")
        .build()
);
```

Java packages target Java 8 bytecode and are tested on Java 8, 11, 17, and 21. Each model artifact depends on `ai.runapi:runapi-core`, so application code normally installs only `ai.runapi:runapi-qwen-2.1`.

## Task lifecycle

Most media endpoints are asynchronous. `create()` submits a task and returns its id, `get(id)` fetches the latest task state, and `run(params)` creates the task and polls until it reaches a terminal state. In web request handlers, prefer `create()` plus webhook or later `get()` polling so the server does not hold a worker open.

## Repository layout

- `js/` publishes `@runapi.ai/qwen-2.1`.
- `python/` publishes `runapi-qwen-2-1`.
- `ruby/` publishes `runapi-qwen-2.1`.
- `go/` publishes `github.com/runapi-ai/qwen-2.1-sdk/go` and depends on `github.com/runapi-ai/core-sdk/go`.
- `java/` publishes `ai.runapi:runapi-qwen-2.1` and depends on `ai.runapi:runapi-core`.

## Public links

- Model page: https://runapi.ai/models/qwen-2.1
- SDK docs: https://runapi.ai/docs/resources/sdks
- Product docs: https://runapi.ai/docs/api/qwen-2-1/text-to-image
- SDK repository: https://github.com/runapi-ai/qwen-2.1-sdk
- PHP package repository: https://github.com/runapi-ai/qwen-2.1-php
- Skill repository: https://github.com/runapi-ai/qwen-2.1
- Provider comparison: https://runapi.ai/providers/alibaba
- Full catalog: https://runapi.ai/models

## Pricing and variants

Use the most specific Qwen 2.1 variant page for pricing, rate limits, and commercial usage:
- [Text to image](https://runapi.ai/models/qwen-2.1/text-to-image)
- [Image edit](https://runapi.ai/models/qwen-2.1/edit-image)

Default pricing link for the Qwen 2.1 SDK: https://runapi.ai/models/qwen-2.1/text-to-image

## File storage

RunAPI-generated file URLs are temporary. Download and store generated images, videos, audio, or other files in your own durable storage within 7 days; do not treat returned URLs as long-term assets.

## FAQ

### Which package should I install for Qwen 2.1 work?

Install the model package for your language: `@runapi.ai/qwen-2.1` on npm, `runapi-qwen-2-1` on PyPI, `runapi-qwen-2.1` on RubyGems, `github.com/runapi-ai/qwen-2.1-sdk/go`, `ai.runapi:runapi-qwen-2.1` on Maven Central, or `runapi-ai/qwen-2.1` on Packagist. Install core SDK packages only when you are building shared SDK infrastructure.

### Where should public links point?

Primary Qwen 2.1 links point to https://runapi.ai/models/qwen-2.1. Pricing and usage-policy links point to variant pages such as https://runapi.ai/models/qwen-2.1/text-to-image. Provider comparisons point to https://runapi.ai/providers/alibaba, and broad browsing points to https://runapi.ai/models.

## License

Licensed under the Apache License, Version 2.0.
