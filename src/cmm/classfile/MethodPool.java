package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import cmm.Utility;

class MethodPool {
  protected Vector<Method> methods;

  public MethodPool() {
    methods = new Vector<Method>();
  }

  public void addMethod(Method m) {
    methods.add(m);
  }

  public void writeToFile(FileOutputStream file) throws IOException {
    for(byte b: Utility.integerToTwoByteArray(methods.size()))
      file.write(b);
    for(Method m: methods)
      m.writeToFile(file);
  }
}
