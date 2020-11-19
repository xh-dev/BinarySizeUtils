# BinarySizeUtils

## Maven
```xml
<dependency>
    <groupId>dev.xethh.utils</groupId>
    <artifactId>BinarySizeUtils</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Getting Start
```java

BinarySize size = BinarySize.ofByte(1025L);   //Create BinarySize object from byte
System.out.println(size);
//BinarySize[1025(~1.00 KB)]
System.out.println(size.readableString());
// 1.00 KB
System.out.println(size.inBytes());
// 1025.00
System.out.println(size.inKiloBytes());
// 1.00
System.out.println(size.inGigaBytes());
// 0.00

size = BinarySize.ofMegaByte(1025L);         //Create BinarySize object mega byte
System.out.println(size);
// BinarySize[1074790400(~1.00 GB)]
System.out.println(size.readableString());
// 1.00 GB
System.out.println(size.inBytes());
// 1074790400.00
System.out.println(size.inMegaBytes());
// 1025.00
System.out.println(size.inGigaBytes());
// 1.00
```
