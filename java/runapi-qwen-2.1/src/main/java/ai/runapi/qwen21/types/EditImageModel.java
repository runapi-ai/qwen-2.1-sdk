package ai.runapi.qwen21.types;

import com.fasterxml.jackson.annotation.JsonCreator;

/** Model slug for edit image operations. */
public final class EditImageModel extends Qwen21Value {
  /** qwen-2.1-edit-image model slug. */
  public static final EditImageModel QWEN_2_1_EDIT_IMAGE = new EditImageModel("qwen-2.1-edit-image");

  /** Creates a model value from a literal model slug. */
  @JsonCreator
  public EditImageModel(String value) {
    super(value);
  }
}
