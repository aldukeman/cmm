package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import cmm.Utility;

abstract class AccessElement {
  private int accessFlags;

  public AccessElement() {
    accessFlags = 0;
  }

  private void clearPubPriPro() {
    accessFlags &= 0xFFF8;
  }

  public void makePublic() {
    clearPubPriPro();
    accessFlags |= 0x0001;
  }

  public void makePrivate() {
    clearPubPriPro();
    accessFlags |= 0x0002;
  }

  public void makeProtected() {
    clearPubPriPro();
    accessFlags |= 0x0004;
  }

  public void makeStatic() {
    accessFlags |= 0x0008;
  }

  public void makeFinal() {
    accessFlags |= 0x0010;
  }

  public void writeToFile(FileOutputStream file) throws IOException {
    for(byte b: Utility.integerToTwoByteArray(accessFlags))
      file.write(b);
  }
}
