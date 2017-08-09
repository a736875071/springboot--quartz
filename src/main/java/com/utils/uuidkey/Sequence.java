package com.utils.uuidkey;

/**
 * @author YangQing
 * @version 1.0.0
 */

public class Sequence {
    private long workerId;
    private long datacenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public Sequence(long workerId, long datacenterId) {
        if(workerId <= 31L && workerId >= 0L) {
            if(datacenterId <= 31L && datacenterId >= 0L) {
                this.workerId = workerId;
                this.datacenterId = datacenterId;
            } else {
                throw new IllegalArgumentException(String.format("datacenter Id can\'t be greater than %d or less than 0", new Object[]{Long.valueOf(31L)}));
            }
        } else {
            throw new IllegalArgumentException(String.format("worker Id can\'t be greater than %d or less than 0", new Object[]{Long.valueOf(31L)}));
        }
    }

    public synchronized long nextId() {
        long timestamp = SystemClock.now();
        if(timestamp < this.lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", new Object[]{Long.valueOf(this.lastTimestamp - timestamp)}));
        } else {
            if(this.lastTimestamp == timestamp) {
                this.sequence = this.sequence + 1L & 4095L;
                if(this.sequence == 0L) {
                    timestamp = this.tilNextMillis(this.lastTimestamp);
                }
            } else {
                this.sequence = 0L;
            }

            this.lastTimestamp = timestamp;
            return timestamp - 0L << 22 | this.datacenterId << 17 | this.workerId << 12 | this.sequence;
        }
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp;
        for(timestamp = SystemClock.now(); timestamp <= lastTimestamp; timestamp = SystemClock.now()) {
            ;
        }

        return timestamp;
    }
}

