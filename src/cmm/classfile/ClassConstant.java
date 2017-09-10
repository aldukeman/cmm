package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import cmm.Utility;

class ClassConstant extends Constant {
  private static final byte TAG = 7;
  protected byte[] nameIndex;

  public ClassConstant(int i) {
    super(TAG);
    nameIndex = Utility.integerToTwoByteArray(i);;
  }

  public void writeToFile(FileOutputStream out) throws IOException {
    super.writeToFile(out);
    for(byte b: nameIndex)
      out.write(b);
  }
}
