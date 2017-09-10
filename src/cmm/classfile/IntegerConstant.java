package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import cmm.Utility;

class IntegerConstant extends Constant {
  protected static final byte TAG = 3;
  protected int value;
  
  public IntegerConstant(int val) {
    super(TAG);
    value = val;
  }

  public void writeToFile(FileOutputStream out) throws IOException {
    super.writeToFile(out);
    for(byte b: Utility.integerToFourByteArray(value))
      out.write(b);
  }
}
