package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import cmm.Utility;

class AttributePool {
  protected Vector<Attribute> attributes;

  public AttributePool() {
    attributes = new Vector<Attribute>();
  }

  public void writeToFile(FileOutputStream file) throws IOException {
    for(byte b: Utility.integerToTwoByteArray(attributes.size()))
      file.write(b);
  }
}
