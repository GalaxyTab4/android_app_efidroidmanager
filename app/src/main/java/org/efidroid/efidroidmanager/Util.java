package org.efidroid.efidroidmanager;

import org.efidroid.efidroidmanager.activities.OperatingSystemEditActivity;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class Util {
    public static OperatingSystemEditActivity.MultibootPartitionInfo getPartitionInfoByName(ArrayList<OperatingSystemEditActivity.MultibootPartitionInfo> list, String name) {
        for(OperatingSystemEditActivity.MultibootPartitionInfo info : list) {
            if(info.name.equals(name))
                return info;
        }

        return null;
    }

    public static String name2path(String name) {
        return name.replaceAll("\\W+", "_");
    }

    public static byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.SIZE/Byte.SIZE);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putLong(x);
        return buffer.array();
    }

    public static String byteToHexStr(byte b) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02X", b));
        return sb.toString();
    }
}
