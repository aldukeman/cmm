package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import cmm.Utility;

class FieldPool {
  protected Vector<Field> fields;

  public FieldPool() {
    fields = new Vector<Field>();
  }

  public void writeToFile(FileOutputStream file) throws IOException {
    for(byte b: Utility.integerToTwoByteArray(fields.size()))
      file.write(b);
  }
}
