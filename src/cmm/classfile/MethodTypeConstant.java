package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import cmm.Utility;

class MethodTypeConstant extends Constant {
  private static final byte TAG = 16;
  private byte[] descriptorIndex;

  public MethodTypeConstant(int d) {
    super(TAG);
    descriptorIndex = Utility.integerToTwoByteArray(d);
  }

  public void writeToFile(FileOutputStream out) throws IOException {
    super.writeToFile(out);
    for(byte b: descriptorIndex)
      out.write(b);
  }
}
