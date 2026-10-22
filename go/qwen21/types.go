package qwen21

import "github.com/runapi-ai/core-sdk/go/core"

// TaskStatus represents the lifecycle state of an async task.
type TaskStatus string

// TextToImageParams configures a text-to-image generation request.
type TextToImageParams struct {
	Model                 string `json:"model" help:"required; RunAPI model identifier"`
	Prompt                string `json:"prompt" help:"required; image generation prompt; 1 to 5000 characters"`
	OutputResolution      string `json:"output_resolution,omitempty" help:"optional; output image resolution; Default: 1k"`
	AspectRatio           string `json:"aspect_ratio,omitempty" help:"optional; output aspect ratio; Default: 1:1"`
	Background            string `json:"background,omitempty" help:"optional; background type; a transparent background requires output_format png or webp; describe only the subject in the prompt; Default: opaque"`
	OutputFormat          string `json:"output_format,omitempty" help:"optional; output image format; jpeg cannot be combined with a transparent background; Default: png"`
	EnablePromptExpansion *bool  `json:"enable_prompt_expansion,omitempty" help:"optional; expand the prompt before generation; Default: true"`
	EnableSafetyChecker   *bool  `json:"enable_safety_checker,omitempty" help:"optional; check generated content for safety; Default: false"`
	Seed                  *int   `json:"seed,omitempty" help:"optional; integer seed for reproducible results; omit for a random seed"`
	CallbackURL           string `json:"callback_url,omitempty" help:"optional; webhook URL for asynchronous task updates"`
}

// EditImageParams configures an image editing request that applies prompt-described changes
// to one or more source images.
type EditImageParams struct {
	Model                 string   `json:"model" help:"required; RunAPI model identifier"`
	Prompt                string   `json:"prompt" help:"required; image editing prompt; 1 to 5000 characters; with mask_url, describes what to generate inside the white area of the mask"`
	SourceImageURLs       []string `json:"source_image_urls" help:"required; one to ten public source image URLs, in the order the prompt refers to them"`
	MaskURL               string   `json:"mask_url,omitempty" help:"optional; public mask image URL for local editing: white marks the area to change, black is kept; requires exactly one source image and cannot be combined with a transparent background; aspect_ratio and enable_prompt_expansion are ignored"`
	OutputResolution      string   `json:"output_resolution,omitempty" help:"optional; output image resolution; Default: 1k"`
	AspectRatio           string   `json:"aspect_ratio,omitempty" help:"optional; output aspect ratio; auto follows the first source image; ignored when mask_url is set; Default: auto"`
	Background            string   `json:"background,omitempty" help:"optional; background type; a transparent background requires output_format png or webp and cannot be combined with mask_url; describe only the subject in the prompt; Default: opaque"`
	OutputFormat          string   `json:"output_format,omitempty" help:"optional; output image format; jpeg cannot be combined with a transparent background; Default: png"`
	EnablePromptExpansion *bool    `json:"enable_prompt_expansion,omitempty" help:"optional; expand the prompt before generation; ignored when mask_url is set; Default: true"`
	Seed                  *int     `json:"seed,omitempty" help:"optional; integer seed for reproducible results; omit for a random seed"`
	CallbackURL           string   `json:"callback_url,omitempty" help:"optional; webhook URL for asynchronous task updates"`
}

// AsyncTaskResponse implements core.TaskResponse for async task polling.
type AsyncTaskResponse struct {
	Usage  *core.TaskUsage `json:"usage,omitempty"`
	ID     string          `json:"id"`
	Status TaskStatus      `json:"status"`
	Error  string          `json:"error,omitempty"`
}

func (r AsyncTaskResponse) GetID() string     { return r.ID }
func (r AsyncTaskResponse) GetStatus() string { return string(r.Status) }
func (r AsyncTaskResponse) GetError() string  { return r.Error }

// Image holds a CDN URL for a generated image.
type Image struct {
	URL string `json:"url"`
}

// ImageTaskResponse is the base response for all Qwen 2.1 image operations.
type ImageTaskResponse struct {
	AsyncTaskResponse
	Images []Image `json:"images,omitempty"`
}

// TextToImageResponse is an alias for ImageTaskResponse.
type TextToImageResponse = ImageTaskResponse

// EditImageResponse is an alias for ImageTaskResponse.
type EditImageResponse = ImageTaskResponse
