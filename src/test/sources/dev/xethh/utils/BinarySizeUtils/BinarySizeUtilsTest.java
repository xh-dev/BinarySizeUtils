package dev.xethh.utils.BinarySizeUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class BinarySizeUtilsTest {

    @Test
    public void test() {
        BinarySize fd;

        fd = BinarySize.ofByte(-1L);
        assertEquals(new BigDecimal("-1.00"), fd.inBytes());
        assertEquals(new BigDecimal("0.00"), fd.inKiloBytes());
        assertEquals(new BigDecimal("0.00"), fd.inMegaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inGigaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inTeraBytes());
        assertEquals(new BigDecimal("0.00"), fd.inPetaBytes());
        assertEquals("-1.00 bytes", fd.readableString());

        fd = BinarySize.ofByte(Long.MIN_VALUE);
        assertEquals(new BigDecimal("-9223372036854775808.00"), fd.inBytes());
        assertEquals(new BigDecimal("-9007199254740992.00"), fd.inKiloBytes());
        assertEquals(new BigDecimal("-8796093022208.00"), fd.inMegaBytes());
        assertEquals(new BigDecimal("-8589934592.00"), fd.inGigaBytes());
        assertEquals(new BigDecimal("-8388608.00"), fd.inTeraBytes());
        assertEquals(new BigDecimal("-8192.00"), fd.inPetaBytes());
        assertEquals("-9223372036854775808.00 bytes", fd.readableString());

        fd = BinarySize.ofByte(0L);
        assertEquals(new BigDecimal("0.00"), fd.inBytes());
        assertEquals(new BigDecimal("0.00"), fd.inKiloBytes());
        assertEquals(new BigDecimal("0.00"), fd.inMegaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inGigaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inTeraBytes());
        assertEquals(new BigDecimal("0.00"), fd.inPetaBytes());
        assertEquals("0.00 bytes", fd.readableString());

        fd = BinarySize.ofByte(1L);
        assertEquals(new BigDecimal("1.00"), fd.inBytes());
        assertEquals(new BigDecimal("0.00"), fd.inKiloBytes());
        assertEquals(new BigDecimal("0.00"), fd.inMegaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inGigaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inTeraBytes());
        assertEquals(new BigDecimal("0.00"), fd.inPetaBytes());
        assertEquals("1.00 bytes", fd.readableString());

        fd = BinarySize.ofByte(500L);
        assertEquals(new BigDecimal("500.00"), fd.inBytes());
        assertEquals(new BigDecimal("0.49"), fd.inKiloBytes());
        assertEquals(new BigDecimal("0.00"), fd.inMegaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inGigaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inTeraBytes());
        assertEquals(new BigDecimal("0.00"), fd.inPetaBytes());
        assertEquals("500.00 bytes", fd.readableString());

        fd = BinarySize.ofByte(1000L);
        assertEquals(new BigDecimal("1000.00"), fd.inBytes());
        assertEquals(new BigDecimal("0.98"), fd.inKiloBytes());
        assertEquals(new BigDecimal("0.00"), fd.inMegaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inGigaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inTeraBytes());
        assertEquals(new BigDecimal("0.00"), fd.inPetaBytes());
        assertEquals("1000.00 bytes", fd.readableString());

        fd = BinarySize.ofByte(1024L);
        assertEquals(new BigDecimal("1024.00"), fd.inBytes());
        assertEquals(new BigDecimal("1.00"), fd.inKiloBytes());
        assertEquals(new BigDecimal("0.00"), fd.inMegaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inGigaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inTeraBytes());
        assertEquals(new BigDecimal("0.00"), fd.inPetaBytes());
        assertEquals("1.00 KB", fd.readableString());

        fd = BinarySize.ofByte(1500L);
        assertEquals(new BigDecimal("1500.00"), fd.inBytes());
        assertEquals(new BigDecimal("1.46"), fd.inKiloBytes());
        assertEquals(new BigDecimal("0.00"), fd.inMegaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inGigaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inTeraBytes());
        assertEquals(new BigDecimal("0.00"), fd.inPetaBytes());
        assertEquals("1.46 KB", fd.readableString());

        fd = BinarySize.ofByte(1024*1024L);
        assertEquals(new BigDecimal("1048576.00"), fd.inBytes());
        assertEquals(new BigDecimal("1024.00"), fd.inKiloBytes());
        assertEquals(new BigDecimal("1.00"), fd.inMegaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inGigaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inTeraBytes());
        assertEquals(new BigDecimal("0.00"), fd.inPetaBytes());
        assertEquals("1.00 MB", fd.readableString());

        fd = BinarySize.ofByte(1024*1024*1024L);
        assertEquals(new BigDecimal("1073741824.00"), fd.inBytes());
        assertEquals(new BigDecimal("1048576.00"), fd.inKiloBytes());
        assertEquals(new BigDecimal("1024.00"), fd.inMegaBytes());
        assertEquals(new BigDecimal("1.00"), fd.inGigaBytes());
        assertEquals(new BigDecimal("0.00"), fd.inTeraBytes());
        assertEquals(new BigDecimal("0.00"), fd.inPetaBytes());
        assertEquals("1.00 GB", fd.readableString());

        fd = BinarySize.ofByte(1024L*1024*1024*1024);
        assertEquals(new BigDecimal("1099511627776.00"), fd.inBytes());
        assertEquals(new BigDecimal("1073741824.00"), fd.inKiloBytes());
        assertEquals(new BigDecimal("1048576.00"), fd.inMegaBytes());
        assertEquals(new BigDecimal("1024.00"), fd.inGigaBytes());
        assertEquals(new BigDecimal("1.00"), fd.inTeraBytes());
        assertEquals(new BigDecimal("0.00"), fd.inPetaBytes());
        assertEquals("1.00 TB", fd.readableString());

        fd = BinarySize.ofByte(1024L * 1024 * 1024 * 1024 * 1024);
        assertEquals(new BigDecimal("1125899906842624.00"), fd.inBytes());
        assertEquals(new BigDecimal("1099511627776.00"), fd.inKiloBytes());
        assertEquals(new BigDecimal("1073741824.00"), fd.inMegaBytes());
        assertEquals(new BigDecimal("1048576.00"), fd.inGigaBytes());
        assertEquals(new BigDecimal("1024.00"), fd.inTeraBytes());
        assertEquals(new BigDecimal("1.00"), fd.inPetaBytes());
        assertEquals("1.00 PB", fd.readableString());

        fd = BinarySize.ofByte(Long.MAX_VALUE);
        assertEquals(new BigDecimal("9223372036854775807.00"), fd.inBytes());
        assertEquals(new BigDecimal("9007199254740992.00"), fd.inKiloBytes());
        assertEquals(new BigDecimal("8796093022208.00"), fd.inMegaBytes());
        assertEquals(new BigDecimal("8589934592.00"), fd.inGigaBytes());
        assertEquals(new BigDecimal("8388608.00"), fd.inTeraBytes());
        assertEquals(new BigDecimal("8192.00"), fd.inPetaBytes());
        assertEquals("8192.00 PB", fd.readableString());
    }
}
