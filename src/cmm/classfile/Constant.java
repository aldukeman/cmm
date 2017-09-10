package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;

abstract class Constant {
  protected byte tag;

  public Constant(byte t) {
    tag = t;
  }

  public void writeToFile(FileOutputStream out) throws IOException {
    out.write(tag);
  }
}
