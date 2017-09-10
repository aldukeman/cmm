package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import cmm.Utility;

class LongConstant extends Constant {
  protected static final byte TAG = 5;
  protected long value;
  
  public LongConstant(long val) {
    super(TAG);
    value = val;
  }

  public void writeToFile(FileOutputStream out) throws IOException {
    super.writeToFile(out);
    for(byte b: Utility.longToEightByteArray(value))
      out.write(b);
  }
}
