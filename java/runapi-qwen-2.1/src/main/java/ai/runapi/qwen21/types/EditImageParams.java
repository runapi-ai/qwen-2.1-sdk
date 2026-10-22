package ai.runapi.qwen21.types;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Parameters for edit image operations. */
public final class EditImageParams {
  private final String model;
  private final String prompt;
  private final List<String> sourceImageUrls;
  private final String maskUrl;
  private final String outputResolution;
  private final String aspectRatio;
  private final String background;
  private final String outputFormat;
  private final Boolean enablePromptExpansion;
  private final Long seed;
  private final String callbackUrl;

  private EditImageParams(Builder builder) {
    this.model = builder.model;
    this.prompt = builder.prompt;
    this.sourceImageUrls = Qwen21ParamUtils.strings(builder.sourceImageUrls);
    this.maskUrl = builder.maskUrl;
    this.outputResolution = builder.outputResolution;
    this.aspectRatio = builder.aspectRatio;
    this.background = builder.background;
    this.outputFormat = builder.outputFormat;
    this.enablePromptExpansion = builder.enablePromptExpansion;
    this.seed = builder.seed;
    this.callbackUrl = builder.callbackUrl;
  }

  /** Creates a new EditImageParams builder. */
  public static Builder builder() {
    return new Builder();
  }

  /** Returns the RunAPI action key for this request. */
  public String action() {
    return "qwen-2-1/edit-image";
  }

  /** Converts these parameters to the JSON request body shape. */
  public Map<String, Object> toMap() {
    Map<String, Object> raw = new LinkedHashMap<String, Object>();
    raw.put("model", Qwen21ParamUtils.wireValue(model));
    raw.put("prompt", Qwen21ParamUtils.wireValue(prompt));
    raw.put("source_image_urls", Qwen21ParamUtils.wireValue(sourceImageUrls));
    raw.put("mask_url", Qwen21ParamUtils.wireValue(maskUrl));
    raw.put("output_resolution", Qwen21ParamUtils.wireValue(outputResolution));
    raw.put("aspect_ratio", Qwen21ParamUtils.wireValue(aspectRatio));
    raw.put("background", Qwen21ParamUtils.wireValue(background));
    raw.put("output_format", Qwen21ParamUtils.wireValue(outputFormat));
    raw.put("enable_prompt_expansion", Qwen21ParamUtils.wireValue(enablePromptExpansion));
    raw.put("seed", Qwen21ParamUtils.wireValue(seed));
    raw.put("callback_url", Qwen21ParamUtils.wireValue(callbackUrl));
    return Qwen21ParamUtils.compact(raw);
  }



  /** Builder for {@link EditImageParams}. */
  public static final class Builder {
    private String model;
    private String prompt;
    private List<String> sourceImageUrls;
    private String maskUrl;
    private String outputResolution;
    private String aspectRatio;
    private String background;
    private String outputFormat;
    private Boolean enablePromptExpansion;
    private Long seed;
    private String callbackUrl;

    private Builder() {}

    /** Sets the model slug using a typed model value. */
    public Builder model(EditImageModel value) {
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

    /** Sets the source image URLs. */
    public Builder sourceImageUrls(List<String> value) {
      this.sourceImageUrls = value;
      return this;
    }

    /** Sets the mask URL. */
    public Builder maskUrl(String value) {
      this.maskUrl = value;
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

    /** Builds immutable edit image parameters. */
    public EditImageParams build() {
      return new EditImageParams(this);
    }
  }
}
