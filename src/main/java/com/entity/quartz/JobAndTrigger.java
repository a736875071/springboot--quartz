package com.entity.quartz;

import java.math.BigInteger;

public class JobAndTrigger {
	private String job_NAME;
	private String job_GROUP;
	private String job_CLASS_NAME;
	private String trigger_NAME;
	private String trigger_GROUP;
	private BigInteger repeat_INTERVAL;
	private BigInteger times_TRIGGERED;
	private String cron_EXPRESSION;
	private String time_ZONE_ID;

	public String getCron_EXPRESSION() {
		return cron_EXPRESSION;
	}

	public void setCron_EXPRESSION(String cron_EXPRESSION) {
		this.cron_EXPRESSION = cron_EXPRESSION;
	}

	public String getJob_NAME() {
		return job_NAME;
	}

	public void setJob_NAME(String job_NAME) {
		this.job_NAME = job_NAME;
	}

	public String getJob_GROUP() {
		return job_GROUP;
	}

	public void setJob_GROUP(String job_GROUP) {
		this.job_GROUP = job_GROUP;
	}

	public String getJob_CLASS_NAME() {
		return job_CLASS_NAME;
	}

	public void setJob_CLASS_NAME(String job_CLASS_NAME) {
		this.job_CLASS_NAME = job_CLASS_NAME;
	}

	public String getTrigger_NAME() {
		return trigger_NAME;
	}

	public void setTrigger_NAME(String trigger_NAME) {
		this.trigger_NAME = trigger_NAME;
	}

	public String getTrigger_GROUP() {
		return trigger_GROUP;
	}

	public void setTrigger_GROUP(String trigger_GROUP) {
		this.trigger_GROUP = trigger_GROUP;
	}

	public BigInteger getRepeat_INTERVAL() {
		return repeat_INTERVAL;
	}

	public void setRepeat_INTERVAL(BigInteger repeat_INTERVAL) {
		this.repeat_INTERVAL = repeat_INTERVAL;
	}

	public BigInteger getTimes_TRIGGERED() {
		return times_TRIGGERED;
	}

	public void setTimes_TRIGGERED(BigInteger times_TRIGGERED) {
		this.times_TRIGGERED = times_TRIGGERED;
	}

	public String getTime_ZONE_ID() {
		return time_ZONE_ID;
	}

	public void setTime_ZONE_ID(String time_ZONE_ID) {
		this.time_ZONE_ID = time_ZONE_ID;
	}
}
