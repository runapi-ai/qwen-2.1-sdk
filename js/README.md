# Qwen 2.1 API JavaScript SDK for RunAPI

The Qwen 2.1 JavaScript SDK is the language-specific package for Qwen 2.1 on RunAPI. Use this package for image generation, image editing, and creative production workflows when your application needs request bodies, task status lookup, and consistent RunAPI errors in JavaScript.

This README is the JavaScript package guide inside the public `qwen-2.1-sdk` repository. For the repository overview, start at `../README.md`; for model details, use https://runapi.ai/models/qwen-2.1; for API reference, use https://runapi.ai/docs/api/qwen-2-1/text-to-image; for SDK docs, use https://runapi.ai/docs/resources/sdks.

## Install

```bash
npm install @runapi.ai/qwen-2.1
```

## Quick start

```typescript
import { Qwen21Client } from '@runapi.ai/qwen-2.1';

const client = new Qwen21Client();
const task = await client.textToImage.create({
  // Pass the Qwen 2.1 JSON request body from https://runapi.ai/docs/api/qwen-2-1/text-to-image.
});
const status = await client.textToImage.get(task.id);
```

Use `create` when you want to submit a task and return quickly, `get` when you need the latest task state, and `run` when a script should create and poll until completion. In web request handlers, prefer `create` plus webhook or later `get` polling so a worker is not held open.

RunAPI-generated file URLs are temporary. Download and store generated images, videos, audio, or other files in your own durable storage within 7 days; do not treat returned URLs as long-term assets.

## Language notes

Use the TypeScript types in `src/types.ts` and the resource classes under `src/resources` when building image applications. The available resources are `textToImage` and `editImage`. Keep `RUNAPI_API_KEY` in the environment or your secret manager; never commit API keys or callback secrets.

## Links

- Model page: https://runapi.ai/models/qwen-2.1
- SDK docs: https://runapi.ai/docs/resources/sdks
- Product docs: https://runapi.ai/docs/api/qwen-2-1/text-to-image
- Pricing and rate limits: https://runapi.ai/models/qwen-2.1/text-to-image
- Provider comparison: https://runapi.ai/providers/alibaba
- Full catalog: https://runapi.ai/models
- Repository: https://github.com/runapi-ai/qwen-2.1-sdk

## License

Licensed under the Apache License, Version 2.0.
