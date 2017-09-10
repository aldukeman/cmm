package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;

class CodeAttribute extends Attribute {
  protected byte[] code;
  protected static int nameIndex;

  public CodeAttribute() {
    super(0);
  }

  public static void setNameIndex(int n) {
    nameIndex = n;
  }
}
