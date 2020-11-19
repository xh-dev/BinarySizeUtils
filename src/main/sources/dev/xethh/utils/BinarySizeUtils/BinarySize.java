package dev.xethh.utils.BinarySizeUtils;

import java.math.BigDecimal;
import java.util.Objects;

public class BinarySize {

    /**
     * create {@link BinarySize} object from number of byte
     * @param size in byte
     * @return {@link BinarySize}
     */
    public static BinarySize ofByte(Long size) {
        return new BinarySize(size);
    }
    /**
     * create {@link BinarySize} object from number of kilo byte
     * @param size in kilo byte
     * @return {@link BinarySize}
     */
    public static BinarySize ofKiloByte(Long size) {
        return ofByte(size*baseLong);
    }
    /**
     * create {@link BinarySize} object from number of mega byte
     * @param size in mega byte
     * @return {@link BinarySize}
     */
    public static BinarySize ofMegaByte(Long size) {
        return ofKiloByte(size*baseLong);
    }
    /**
     * create {@link BinarySize} object from number of giga byte
     * @param size in giga byte
     * @return {@link BinarySize}
     */
    public static BinarySize ofGigaByte(Long size) {
        return ofMegaByte(size*baseLong);
    }
    /**
     * create {@link BinarySize} object from number of tera byte
     * @param size in tera byte
     * @return {@link BinarySize}
     */
    public static BinarySize ofTeraByte(Long size) {
        return ofGigaByte(size*baseLong);
    }
    /**
     * create {@link BinarySize} object from number of peta byte
     * @param size in peta byte
     * @return {@link BinarySize}
     */
    public static BinarySize ofPetaByte(Long size) {
        return ofTeraByte(size*baseLong);
    }

    private static Long baseLong = 1024L;
    private static final BigDecimal base = BigDecimal.valueOf(baseLong);
    private static final BigDecimal zero = BigDecimal.valueOf(0);
    private static final BigDecimal kiloLimit = base;
    private static final BigDecimal megaLimit = BigDecimal.valueOf(baseLong * baseLong);
    private static final BigDecimal gigaLimit = BigDecimal.valueOf(baseLong * baseLong * baseLong);
    private static final BigDecimal teraLimit = BigDecimal.valueOf(baseLong * baseLong * baseLong * baseLong);
    private static final BigDecimal petaLimit = BigDecimal.valueOf(baseLong * baseLong * baseLong * baseLong * baseLong);
    private BigDecimal numOfBytes;

    /**
     * Constructor of {@link BinarySize}
     * @param size number size in byte
     */
    private BinarySize(Long size) {
        numOfBytes = new BigDecimal(size);
        numOfBytes = numOfBytes.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * represent binary size in byte of {@link BigDecimal}
     * @return binary size in byte
     */
    public BigDecimal inBytes() {
        return numOfBytes;
    }

    /**
     * represent binary size in kilo byte of {@link BigDecimal}
     * @return binary size in kilo byte
     */
    public BigDecimal inKiloBytes() {
        return numOfBytes.divide(kiloLimit, 2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * represent binary size in mega byte of {@link BigDecimal}
     * @return binary size in mega byte
     */
    public BigDecimal inMegaBytes() {
        return numOfBytes.divide(megaLimit, 2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * represent binary size in giga byte of {@link BigDecimal}
     * @return binary size in giga byte
     */
    public BigDecimal inGigaBytes() {
        return numOfBytes.divide(gigaLimit, 2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * represent binary size in tera byte of {@link BigDecimal}
     * @return binary size in tera byte
     */
    public BigDecimal inTeraBytes() {
        return numOfBytes.divide(teraLimit, 2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * represent binary size in peta byte of {@link BigDecimal}
     * @return binary size in peta byte
     */
    public BigDecimal inPetaBytes() {
        return numOfBytes.divide(petaLimit, 2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * represent binary size in readable string format
     * e.g. 100 bytes, 1 MB, 10 KB
     * @return binary size in readable string format
     */
    public String readableString() {
        if (numOfBytes.compareTo(zero) >= 0 && numOfBytes.compareTo(kiloLimit) < 0) {
            return numOfBytes.toString() + " bytes";
        } else if (numOfBytes.compareTo(kiloLimit) >= 0 && numOfBytes.compareTo(megaLimit) < 0) {
            return inKiloBytes().toString() + " KB";
        } else if (numOfBytes.compareTo(megaLimit) >= 0 && numOfBytes.compareTo(gigaLimit) < 0) {
            return inMegaBytes().toString() + " MB";
        } else if (numOfBytes.compareTo(gigaLimit) >= 0 && numOfBytes.compareTo(teraLimit) < 0) {
            return inGigaBytes().toString() + " GB";
        } else if (numOfBytes.compareTo(teraLimit) >= 0 && numOfBytes.compareTo(petaLimit) < 0) {
            return inTeraBytes().toString() + " TB";
        } else if (numOfBytes.compareTo(petaLimit) >= 0) {
            return inPetaBytes().toString() + " PB";
        } else {
            return numOfBytes.toString() + " bytes";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinarySize that = (BinarySize) o;
        return Objects.equals(numOfBytes, that.numOfBytes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOfBytes);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BinarySize[");
        sb.append(numOfBytes.longValue());
        sb.append("(~").append(readableString()).append(")");
        sb.append(']');
        return sb.toString();
    }
}
