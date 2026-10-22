import type { AsyncTaskStatus, TaskResponse } from '@runapi.ai/core';

/** All Qwen 2.1 model variants, each dedicated to a single operation type. */
export type Qwen21Model = 'qwen-2.1-edit-image' | 'qwen-2.1-text-to-image';

/** Aspect ratio options for text-to-image generation. Default: 1:1. */
export type TextToImageAspectRatio = '1:1' | '4:3' | '3:4' | '3:2' | '2:3' | '16:9' | '9:16' | '21:9' | '9:21';
/** Aspect ratio options for edit-image. `auto` follows the source image. Default: auto. */
export type EditImageAspectRatio = 'auto' | TextToImageAspectRatio;
/** Output image encoding format. Default: png. */
export type OutputFormat = 'png' | 'webp' | 'jpeg';
/** Background treatment. `transparent` cannot be combined with `jpeg` output. Default: opaque. */
export type Background = 'opaque' | 'transparent';
/** Output image resolution. Default: 1k. */
export type OutputResolution = '1k' | '2k';

/** Parameters for text-to-image generation. Prompt up to 5000 characters. */
export interface TextToImageParams {
  model: 'qwen-2.1-text-to-image';
  /** Image description (1-5000 chars). */
  prompt: string;
  output_resolution?: OutputResolution;
  aspect_ratio?: TextToImageAspectRatio;
  /** Integer seed for reproducible results. */
  seed?: number;
  background?: Background;
  output_format?: OutputFormat;
  /** Expand the prompt before generation. */
  enable_prompt_expansion?: boolean;
  /** Toggle content safety filtering. */
  enable_safety_checker?: boolean;
  /** Webhook URL for async completion notifications. */
  callback_url?: string;
}

/** Parameters for edit-image. Applies prompt-described changes to a source image. */
export interface EditImageParams {
  model: 'qwen-2.1-edit-image';
  /** Edit instruction (1-5000 chars). */
  prompt: string;
  /** One to ten public source image URLs. */
  source_image_urls: string[];
  output_resolution?: OutputResolution;
  aspect_ratio?: EditImageAspectRatio;
  background?: Background;
  output_format?: OutputFormat;
  /** Public mask image URL. Requires exactly one source image and cannot be combined with a transparent background. */
  mask_url?: string;
  /** Expand the prompt before generation. */
  enable_prompt_expansion?: boolean;
  /** Integer seed for reproducible results. */
  seed?: number;
  /** Webhook URL for async completion notifications. */
  callback_url?: string;
}

export interface TaskCreateResponse {
  id: string;
}

/** A single generated image result. */
export interface Image {
  /** CDN-delivered image URL. */
  url: string;
}

/** Shared task result for all Qwen 2.1 image operations. */
export interface ImageTaskResponse extends TaskResponse {
  id: string;
  status: AsyncTaskStatus;
  /** Output images, populated once the task completes successfully. */
  images?: Image[];
  /** Error message when the task has failed. */
  error?: string;
  [key: string]: unknown;
}

export type TextToImageResponse = ImageTaskResponse;
export type EditImageResponse = ImageTaskResponse;

/**
 * Resolved responses returned by the `run()` methods after polling sees
 * `status: 'completed'`. Narrows the base response so `images` is
 * guaranteed non-optional in user code.
 */
export type CompletedTextToImageResponse = TextToImageResponse & {
  status: 'completed';
  images: Image[];
};

export type CompletedEditImageResponse = EditImageResponse & {
  status: 'completed';
  images: Image[];
};
