package cmm.classfile;

import java.io.FileOutputStream;
import java.io.IOException;
import cmm.Utility;

public class ClassFile {
  protected static byte[] magicNumber = { (byte)0xca, (byte)0xfe, (byte)0xba, (byte)0xbe };
  protected static final int minorVersion = 0;
  protected static final int majorVersion = 52;
  protected ConstantPool constantPool;
  protected static final int access = 1;
  protected int classNameIndex;
  protected int superClassNameIndex;
  protected InterfacePool interfacePool;
  protected FieldPool fieldPool;
  protected MethodPool methodPool;
  protected AttributePool attributePool;

  public ClassFile() {
    constantPool = new ConstantPool();
    interfacePool = new InterfacePool();
    fieldPool = new FieldPool();
    methodPool = new MethodPool();
    CodeAttribute.setNameIndex(constantPool.addUtf8Constant("Code"));
    attributePool = new AttributePool();
  }

  public void setClassName(String n) {
    classNameIndex = constantPool.addClassConstant(n);
  }

  public void setSuperClassName(String n) {
    superClassNameIndex = constantPool.addClassConstant(n);
  }

  public void writeToFile(FileOutputStream file) throws IOException {
    for(byte b: magicNumber)
      file.write(b);

    for(byte b: Utility.integerToTwoByteArray(minorVersion))
      file.write(b);
    for(byte b: Utility.integerToTwoByteArray(majorVersion))
      file.write(b);

    constantPool.writeToFile(file);

    for(byte b: Utility.integerToTwoByteArray(access))
      file.write(b);

    for(byte b: Utility.integerToTwoByteArray(classNameIndex))
      file.write(b);

    for(byte b: Utility.integerToTwoByteArray(superClassNameIndex))
      file.write(b);

    interfacePool.writeToFile(file);
    fieldPool.writeToFile(file);
    methodPool.writeToFile(file);
    attributePool.writeToFile(file);
  }

  public int addUtf8Constant(String d) {
    return constantPool.addUtf8Constant(d);
  }

  public void addMethod() {
    int nameIndex = addUtf8Constant("main");
    int descriptorIndex = addUtf8Constant("([Ljava/lang/String;)V");
    Method m = new Method(nameIndex, descriptorIndex);
    m.makePublic();
    m.makeStatic();
    methodPool.addMethod(m);
  }

  public static void main(String[] args) {
    try(FileOutputStream out = new FileOutputStream("testing.class")) {
      ClassFile cf = new ClassFile();
      cf.setClassName("testing");
      cf.setSuperClassName("java/lang/Object");
      cf.addMethod();
      cf.writeToFile(out);
    }
    catch(Exception e) {
    }
  }
}
