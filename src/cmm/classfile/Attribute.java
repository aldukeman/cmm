package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import cmm.Utility;

abstract class Attribute {
  protected byte[] nameIndex;

  public Attribute(int i) {
    nameIndex = Utility.integerToTwoByteArray(i);
  }
  
  public void writeToFile(FileOutputStream file) throws IOException {
    for(byte b: nameIndex)
      file.write(b);
  }
}
