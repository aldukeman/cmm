package cmm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Utility {
  public static byte[] integerToTwoByteArray(int i) {
    byte[] data = new byte[2];
    data[0] = (byte)((i >> 8) & 0xFF);
    data[1] = (byte)(i & 0xFF);
    return data;
  }

  public static byte[] integerToFourByteArray(int i) {
    byte[] data = new byte[4];
    data[0] = (byte)((i >> 24) & 0xFF);
    data[1] = (byte)((i >> 16) & 0xFF);
    data[2] = (byte)((i >> 8) & 0xFF);
    data[3] = (byte)(i & 0xFF);
    return data;
  }

  public static byte[] floatToFourByteArray(float f) {
    return ByteBuffer.allocate(4).putFloat(f).array();
  }

  public static byte[] longToEightByteArray(long l) {
    return ByteBuffer.allocate(8).putLong(l).array();
  }

  public static byte[] doubleToEightByteArray(double d) {
    return ByteBuffer.allocate(8).putDouble(d).array();
  }
}
