package ai.runapi.qwen21.types;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Parameters for text to image operations. */
public final class TextToImageParams {
  private final String model;
  private final String prompt;
  private final String outputResolution;
  private final String aspectRatio;
  private final String background;
  private final String outputFormat;
  private final Boolean enablePromptExpansion;
  private final Boolean enableSafetyChecker;
  private final Long seed;
  private final String callbackUrl;

  private TextToImageParams(Builder builder) {
    this.model = builder.model;
    this.prompt = builder.prompt;
    this.outputResolution = builder.outputResolution;
    this.aspectRatio = builder.aspectRatio;
    this.background = builder.background;
    this.outputFormat = builder.outputFormat;
    this.enablePromptExpansion = builder.enablePromptExpansion;
    this.enableSafetyChecker = builder.enableSafetyChecker;
    this.seed = builder.seed;
    this.callbackUrl = builder.callbackUrl;
  }

  /** Creates a new TextToImageParams builder. */
  public static Builder builder() {
    return new Builder();
  }

  /** Returns the RunAPI action key for this request. */
  public String action() {
    return "qwen-2-1/text-to-image";
  }

  /** Converts these parameters to the JSON request body shape. */
  public Map<String, Object> toMap() {
    Map<String, Object> raw = new LinkedHashMap<String, Object>();
    raw.put("model", Qwen21ParamUtils.wireValue(model));
    raw.put("prompt", Qwen21ParamUtils.wireValue(prompt));
    raw.put("output_resolution", Qwen21ParamUtils.wireValue(outputResolution));
    raw.put("aspect_ratio", Qwen21ParamUtils.wireValue(aspectRatio));
    raw.put("background", Qwen21ParamUtils.wireValue(background));
    raw.put("output_format", Qwen21ParamUtils.wireValue(outputFormat));
    raw.put("enable_prompt_expansion", Qwen21ParamUtils.wireValue(enablePromptExpansion));
    raw.put("enable_safety_checker", Qwen21ParamUtils.wireValue(enableSafetyChecker));
    raw.put("seed", Qwen21ParamUtils.wireValue(seed));
    raw.put("callback_url", Qwen21ParamUtils.wireValue(callbackUrl));
    return Qwen21ParamUtils.compact(raw);
  }



  /** Builder for {@link TextToImageParams}. */
  public static final class Builder {
    private String model;
    private String prompt;
    private String outputResolution;
    private String aspectRatio;
    private String background;
    private String outputFormat;
    private Boolean enablePromptExpansion;
    private Boolean enableSafetyChecker;
    private Long seed;
    private String callbackUrl;

    private Builder() {}

    /** Sets the model slug using a typed model value. */
    public Builder model(TextToImageModel value) {
      this.model = java.util.Objects.requireNonNull(value, "model").value();
      return this;
    }

    /** Sets the model slug using a string value. */
    public Builder model(String value) {
      this.model = value;
      return this;
    }


    /** Sets the text prompt. */
    public Builder prompt(String value) {
      this.prompt = value;
      return this;
    }

    /** Sets the output resolution. */
    public Builder outputResolution(String value) {
      this.outputResolution = value;
      return this;
    }

    /** Sets the output aspect ratio. */
    public Builder aspectRatio(String value) {
      this.aspectRatio = value;
      return this;
    }

    /** Sets the background. */
    public Builder background(String value) {
      this.background = value;
      return this;
    }

    /** Sets the output format. */
    public Builder outputFormat(String value) {
      this.outputFormat = value;
      return this;
    }

    /** Sets the prompt expansion toggle. */
    public Builder enablePromptExpansion(boolean value) {
      this.enablePromptExpansion = value;
      return this;
    }

    /** Sets the content safety checker toggle. */
    public Builder enableSafetyChecker(boolean value) {
      this.enableSafetyChecker = value;
      return this;
    }

    /** Sets the random seed. */
    public Builder seed(int value) {
      return seed((long) value);
    }

    /** Sets the random seed. */
    public Builder seed(long value) {
      this.seed = value;
      return this;
    }

    /** Sets the webhook URL for task completion notifications. */
    public Builder callbackUrl(String value) {
      this.callbackUrl = value;
      return this;
    }

    /** Builds immutable text to image parameters. */
    public TextToImageParams build() {
      return new TextToImageParams(this);
    }
  }
}
