package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import cmm.Utility;

class MethodHandleConstant extends Constant {
  private static final byte TAG = 15;
  private byte referenceKind;
  private byte[] referenceIndex;

  public MethodHandleConstant(byte rk, byte ri) {
    super(TAG);
    referenceKind = rk;
    referenceIndex = Utility.integerToTwoByteArray(ri);
  }

  public void writeToFile(FileOutputStream out) throws IOException {
    super.writeToFile(out);
    out.write(referenceKind);
    for(byte b: referenceIndex)
      out.write(b);
  }
}
