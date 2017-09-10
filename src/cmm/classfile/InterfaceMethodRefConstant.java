package cmm.classfile;

class InterfaceMethodRefConstant extends ClassNameTypeConstant {
  protected static final byte TAG = 11;

  public InterfaceMethodRefConstant(int c, int n) {
    super(TAG, c, n);
  }
}
