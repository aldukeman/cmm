package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import cmm.Utility;

class FloatConstant extends Constant {
  protected static final byte TAG = 4;
  protected float value;
  
  public FloatConstant(float val) {
    super(TAG);
    value = val;
  }

  public void writeToFile(FileOutputStream out) throws IOException {
    super.writeToFile(out);
    for(byte b: Utility.floatToFourByteArray(value))
      out.write(b);
  }
}
