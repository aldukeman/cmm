package cmm.classfile;

class MethodRefConstant extends ClassNameTypeConstant {
  protected static final byte TAG = 10;

  public MethodRefConstant(int c, int n) {
    super(TAG, c, n);
  }
}
