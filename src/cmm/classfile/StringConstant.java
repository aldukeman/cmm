package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import cmm.Utility;

class StringConstant extends Constant {
  private static final byte TAG = 8;
  protected byte[] index;

  public StringConstant(int i) {
    super(TAG);
    index = Utility.integerToTwoByteArray(i);
  }

  public void writeToFile(FileOutputStream out) throws IOException {
    super.writeToFile(out);
    for(byte b: index)
      out.write(b);
  }
}
