package com.utils.uuidkey;

import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @author YangQing
 * @version 1.0.0
 */

public class UUIDUtil {
    private static Sequence sequence = null;

    public UUIDUtil() {
    }

    public static long genSequenceUUID() {
        return sequence.nextId();
    }

    public static long genSequenceUUID(long workId, long datacenterId) {
        return (new Sequence(workId, datacenterId)).nextId();
    }

    public static String genTimeBeginUUID(int length) {
        if(length >= 15 && length <= 32) {
            StringBuffer sb = new StringBuffer();
            SimpleDateFormat sf = new SimpleDateFormat("yyMMddHHmmssSSS");
            sb.append(sf.format(Long.valueOf(SystemClock.now())));
            sb.append(UUID.randomUUID().toString().replace("-", "").substring(15, length));
            return sb.toString();
        } else {
            throw new IllegalArgumentException(String.format("length can\'t be greater than 32 or less than %d", new Object[]{Integer.valueOf(15)}));
        }
    }

    public static String gen32RandomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
    }

    static {
        if(sequence == null) {
            sequence = new Sequence(0L, 0L);
        }

    }
}

