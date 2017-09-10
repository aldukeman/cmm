package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import cmm.Utility;

class Utf8Constant extends Constant {
  private static final byte TAG = 1;
  protected String value;

  public Utf8Constant(String v) {
    super(TAG);
    value = v;
  }

  public void writeToFile(FileOutputStream out) throws IOException {
    super.writeToFile(out);
    for(byte b: Utility.integerToTwoByteArray(value.length()))
      out.write(b);
    for(byte b: value.getBytes())
      out.write(b);
  }
}
