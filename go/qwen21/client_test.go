package qwen21

import (
	"context"
	"encoding/json"
	"testing"

	"github.com/runapi-ai/core-sdk/go/core"
)

type stubHTTPClient struct {
	method   string
	path     string
	body     any
	response json.RawMessage
}

func (s *stubHTTPClient) Request(_ context.Context, method, path string, opts *core.HTTPRequestOptions) (json.RawMessage, error) {
	s.method = method
	s.path = path
	if opts != nil {
		s.body = opts.Body
	}
	return s.response, nil
}

func TestTextToImageCreate(t *testing.T) {
	stub := &stubHTTPClient{response: json.RawMessage(`{"id":"task_123","status":"processing"}`)}
	client := NewClientWithHTTP(stub)
	resp, err := client.TextToImage.Create(context.Background(), TextToImageParams{
		Model: "qwen-2.1-text-to-image", Prompt: "a glass city", AspectRatio: "21:9", Background: "transparent", OutputFormat: "webp"})
	if err != nil {
		t.Fatal(err)
	}
	if stub.method != "POST" || stub.path != "/api/v1/qwen_2_1/text_to_image" {
		t.Fatalf("unexpected request: %s %s", stub.method, stub.path)
	}
	body := stub.body.(map[string]any)
	if body["model"] != "qwen-2.1-text-to-image" || body["background"] != "transparent" || body["output_format"] != "webp" {
		t.Fatalf("unexpected body: %v", body)
	}
	if resp.ID != "task_123" {
		t.Fatalf("unexpected task ID: %v", resp.ID)
	}
}

func TestEditImageCreate(t *testing.T) {
	stub := &stubHTTPClient{response: json.RawMessage(`{"id":"task_123","status":"processing"}`)}
	client := NewClientWithHTTP(stub)
	resp, err := client.EditImage.Create(context.Background(), EditImageParams{
		Model: "qwen-2.1-edit-image", Prompt: "replace the sky",
		SourceImageURLs: []string{"https://cdn.runapi.ai/public/samples/input.jpg"},
		MaskURL:         "https://cdn.runapi.ai/public/samples/mask.png", OutputResolution: "2k"})
	if err != nil {
		t.Fatal(err)
	}
	if stub.method != "POST" || stub.path != "/api/v1/qwen_2_1/edit_image" {
		t.Fatalf("unexpected request: %s %s", stub.method, stub.path)
	}
	body := stub.body.(map[string]any)
	if body["model"] != "qwen-2.1-edit-image" || body["mask_url"] != "https://cdn.runapi.ai/public/samples/mask.png" {
		t.Fatalf("unexpected body: %v", body)
	}
	if len(body["source_image_urls"].([]any)) != 1 {
		t.Fatalf("unexpected source images: %v", body["source_image_urls"])
	}
	if resp.ID != "task_123" {
		t.Fatalf("unexpected task ID: %v", resp.ID)
	}
}

func TestEditImageGet(t *testing.T) {
	stub := &stubHTTPClient{response: json.RawMessage(`{"id":"task_456","status":"completed","images":[{"url":"https://file.runapi.ai/result.png"}]}`)}
	client := NewClientWithHTTP(stub)
	resp, err := client.EditImage.Get(context.Background(), "task_abc")
	if err != nil {
		t.Fatal(err)
	}
	if stub.method != "GET" || stub.path != "/api/v1/qwen_2_1/edit_image/task_abc" {
		t.Fatalf("unexpected request: %s %s", stub.method, stub.path)
	}
	if resp.ID != "task_456" || len(resp.Images) != 1 {
		t.Fatalf("unexpected response: %#v", resp)
	}
}

func TestTextToImageGet(t *testing.T) {
	stub := &stubHTTPClient{response: json.RawMessage(`{"id":"task_789","status":"completed","images":[{"url":"https://file.runapi.ai/result.png"}]}`)}
	client := NewClientWithHTTP(stub)
	resp, err := client.TextToImage.Get(context.Background(), "task_abc")
	if err != nil {
		t.Fatal(err)
	}
	if stub.method != "GET" || stub.path != "/api/v1/qwen_2_1/text_to_image/task_abc" {
		t.Fatalf("unexpected request: %s %s", stub.method, stub.path)
	}
	if resp.ID != "task_789" || len(resp.Images) != 1 {
		t.Fatalf("unexpected response: %#v", resp)
	}
}
