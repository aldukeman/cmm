package cmm.classfile;

class FieldRefConstant extends ClassNameTypeConstant {
  protected static final byte TAG = 9;

  public FieldRefConstant(int c, int n) {
    super(TAG, c, n);
  }
}
