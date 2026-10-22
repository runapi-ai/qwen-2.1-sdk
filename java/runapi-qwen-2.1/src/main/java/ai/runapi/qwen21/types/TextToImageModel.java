package ai.runapi.qwen21.types;

import com.fasterxml.jackson.annotation.JsonCreator;

/** Model slug for text to image operations. */
public final class TextToImageModel extends Qwen21Value {
  /** qwen-2.1-text-to-image model slug. */
  public static final TextToImageModel QWEN_2_1_TEXT_TO_IMAGE = new TextToImageModel("qwen-2.1-text-to-image");

  /** Creates a model value from a literal model slug. */
  @JsonCreator
  public TextToImageModel(String value) {
    super(value);
  }
}
