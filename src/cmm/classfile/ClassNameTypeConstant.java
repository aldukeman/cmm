package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import cmm.Utility;

class ClassNameTypeConstant extends Constant {
  protected byte[] classIndex;
  protected byte[] nameTypeIndex;

  public ClassNameTypeConstant(byte t, int c, int n) {
    super(t);
    classIndex = Utility.integerToTwoByteArray(c);
    nameTypeIndex = Utility.integerToTwoByteArray(n);
  }

  public void writeToFile(FileOutputStream out) throws IOException {
    super.writeToFile(out);
    for(byte b: classIndex)
      out.write(b);
    for(byte b: nameTypeIndex)
      out.write(b);
  }
}
