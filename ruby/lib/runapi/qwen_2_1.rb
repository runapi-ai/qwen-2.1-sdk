# frozen_string_literal: true

require "runapi/core"
require_relative "qwen_2_1/types"
require_relative "qwen_2_1/resources/text_to_image"
require_relative "qwen_2_1/resources/edit_image"
require_relative "qwen_2_1/client"

module RunApi
  module Qwen21
    AuthenticationError = RunApi::Core::AuthenticationError
    RateLimitError = RunApi::Core::RateLimitError
    InsufficientCreditsError = RunApi::Core::InsufficientCreditsError
    NotFoundError = RunApi::Core::NotFoundError
    ValidationError = RunApi::Core::ValidationError
    TaskFailedError = RunApi::Core::TaskFailedError
    TaskTimeoutError = RunApi::Core::TaskTimeoutError
  end
end
