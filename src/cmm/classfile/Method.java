package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import cmm.Utility;

class Method extends AccessElement {
  protected byte[] nameIndex;
  protected byte[] descriptorIndex;
  protected Vector<Attribute> attributes;

  public Method(int n, int d) {
    super();
    nameIndex = Utility.integerToTwoByteArray(n);
    descriptorIndex = Utility.integerToTwoByteArray(d);
    attributes = new Vector<Attribute>();
  }

  public void writeToFile(FileOutputStream file) throws IOException {
    super.writeToFile(file);
    for(byte b: nameIndex)
      file.write(b);
    for(byte b: descriptorIndex)
      file.write(b);
    for(byte b: Utility.integerToTwoByteArray(attributes.size()))
      file.write(b);
    for(Attribute a: attributes)
      a.writeToFile(file);
  }
}
