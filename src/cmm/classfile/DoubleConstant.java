package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import cmm.Utility;

class DoubleConstant extends Constant {
  protected static final byte TAG = 6;
  protected double value;
  
  public DoubleConstant(double val) {
    super(TAG);
    value = val;
  }

  public void writeToFile(FileOutputStream out) throws IOException {
    super.writeToFile(out);
    for(byte b: Utility.doubleToEightByteArray(value))
      out.write(b);
  }
}
