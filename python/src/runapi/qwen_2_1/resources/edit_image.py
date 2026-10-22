"""Qwen 2.1 edit-image resource."""

from __future__ import annotations

from typing import Any, Optional

from runapi.core import Resource, RequestOptions

from ..types import (
    CompletedEditImageResponse,
    EditImageResponse,
)


class EditImage(Resource):
    """Image to images with natural-language prompts."""

    ENDPOINT = "/api/v1/qwen_2_1/edit_image"

    RESPONSE_CLASS = EditImageResponse
    COMPLETED_RESPONSE_CLASS = CompletedEditImageResponse

    def run(self, options: Optional[RequestOptions] = None, **params: Any) -> Any:
        """Create an edit-image task and poll until it completes.

        Args:
            **params: Image-to-image parameters (model, prompt, source_image_urls, ...).

        Returns:
            The completed (narrowed) response.
        """
        task = self.create(options=options, **params)
        return self._poll_until_complete(lambda: self.get(task.id, options=options))

    def create(self, options: Optional[RequestOptions] = None, **params: Any) -> Any:
        """Create an edit-image task and return immediately with an ``id``.

        Args:
            **params: Image-to-image parameters (model, prompt, source_image_urls, ...).

        Returns:
            The task creation result with an id.
        """
        compacted = self._compact_params(params)
        return self._request("post", self.ENDPOINT, body=compacted, options=options)

    def get(self, id: str, options: Optional[RequestOptions] = None) -> Any:
        """Fetch the current status of an edit-image task.

        Args:
            id: The task id.

        Returns:
            The current status.
        """
        return self._request("get", f"{self.ENDPOINT}/{id}", options=options)
