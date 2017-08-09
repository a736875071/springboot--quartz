package com.service.cm.quartz.enums;

/**
 * 定时任务枚举常量
 *
 * @author , YangQing
 * @version 1.0.0
 */
public class QuartzEnum {

    //    启用状态
    public enum TaskStatus {
        STARTUSING("01", "启用"),
        OUTAGE("02", "停用");
        private String _value;
        private String _description;

        TaskStatus(String _value, String _description) {
            this._value = _value;
            this._description = _description;
        }

        public String value() {
            return _value;
        }

        public String description() {
            return _description;
        }
    }

    // 执行状态
    public enum ExecuteStatus {
        NORMAL_OPERATION("01", "正常运行"),
        SUSPEND("02", "暂停"),
        FINISH("03", "完成"),
        LOCK("04", "锁定");
        private String _value;
        private String _description;

        ExecuteStatus(String _value, String _description) {
            this._value = _value;
            this._description = _description;
        }

        public String value() {
            return _value;
        }

        public String description() {
            return _description;
        }
    }

    //循环扣费周期
    public enum DeduCycle {
        ONCE("00", "一次"),
        EVERYDAY("01", "按天"),
        WEEKLY("02", "按周"),
        MONTHAFTERMONTH("03", "按月"),
        YEARLY("04", "按年");
        private String _value;
        private String _description;

        DeduCycle(String _value, String _description) {
            this._value = _value;
            this._description = _description;
        }

        public String value() {
            return _value;
        }

        public String description() {
            return _description;
        }
    }

}