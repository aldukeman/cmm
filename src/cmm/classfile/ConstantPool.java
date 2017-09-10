package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import cmm.Utility;

class ConstantPool {
  protected Vector<Constant> constants;

  public ConstantPool() {
    constants = new Vector<Constant>();
  }

  public int addClassConstant(String n) {
    addUtf8Constant(n);
    constants.add(new ClassConstant(constants.size()));
    return constants.size();
  }

  public int addUtf8Constant(String s) {
    constants.add(new Utf8Constant(s));
    return constants.size();
  }

  public int addStringConstant(String s) {
    addUtf8Constant(s);
    constants.add(new StringConstant(constants.size()));
    return constants.size();
  }

  public void writeToFile(FileOutputStream file) throws IOException {
    for(byte b: Utility.integerToTwoByteArray(constants.size() + 1))
      file.write(b);
    for(Constant c: constants)
      c.writeToFile(file);
  }
}
