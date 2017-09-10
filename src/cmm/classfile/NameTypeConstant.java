package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import cmm.Utility;

class NameTypeConstant extends Constant {
  protected static final byte TAG = 12;
  protected byte[] nameIndex;
  protected byte[] descriptorIndex;
  
  public NameTypeConstant(int n, int d) {
    super(TAG);
    nameIndex = Utility.integerToTwoByteArray(n);
    descriptorIndex = Utility.integerToTwoByteArray(d);
  }

  public void writeToFile(FileOutputStream out) throws IOException {
    super.writeToFile(out);
    for(byte b: nameIndex)
      out.write(b);
    for(byte b: descriptorIndex)
      out.write(b);
  }
}
