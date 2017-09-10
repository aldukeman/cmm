package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import cmm.Utility;

class InterfacePool {
  protected Vector<Interface> interfaces;

  public InterfacePool() {
    interfaces = new Vector<Interface>();
  }

  public void writeToFile(FileOutputStream file) throws IOException {
    for(byte b: Utility.integerToTwoByteArray(interfaces.size()))
      file.write(b);
  }
}
