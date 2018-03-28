package com.dcode.entity;

import java.util.ArrayList;
import java.util.List;

public class MonitorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonitorExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMonitorIsNull() {
            addCriterion("monitor is null");
            return (Criteria) this;
        }

        public Criteria andMonitorIsNotNull() {
            addCriterion("monitor is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorEqualTo(String value) {
            addCriterion("monitor =", value, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorNotEqualTo(String value) {
            addCriterion("monitor <>", value, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorGreaterThan(String value) {
            addCriterion("monitor >", value, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorGreaterThanOrEqualTo(String value) {
            addCriterion("monitor >=", value, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorLessThan(String value) {
            addCriterion("monitor <", value, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorLessThanOrEqualTo(String value) {
            addCriterion("monitor <=", value, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorLike(String value) {
            addCriterion("monitor like", value, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorNotLike(String value) {
            addCriterion("monitor not like", value, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorIn(List<String> values) {
            addCriterion("monitor in", values, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorNotIn(List<String> values) {
            addCriterion("monitor not in", values, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorBetween(String value1, String value2) {
            addCriterion("monitor between", value1, value2, "monitor");
            return (Criteria) this;
        }

        public Criteria andMonitorNotBetween(String value1, String value2) {
            addCriterion("monitor not between", value1, value2, "monitor");
            return (Criteria) this;
        }

        public Criteria andRtspstreamurlIsNull() {
            addCriterion("rtspStreamurl is null");
            return (Criteria) this;
        }

        public Criteria andRtspstreamurlIsNotNull() {
            addCriterion("rtspStreamurl is not null");
            return (Criteria) this;
        }

        public Criteria andRtspstreamurlEqualTo(String value) {
            addCriterion("rtspStreamurl =", value, "rtspstreamurl");
            return (Criteria) this;
        }

        public Criteria andRtspstreamurlNotEqualTo(String value) {
            addCriterion("rtspStreamurl <>", value, "rtspstreamurl");
            return (Criteria) this;
        }

        public Criteria andRtspstreamurlGreaterThan(String value) {
            addCriterion("rtspStreamurl >", value, "rtspstreamurl");
            return (Criteria) this;
        }

        public Criteria andRtspstreamurlGreaterThanOrEqualTo(String value) {
            addCriterion("rtspStreamurl >=", value, "rtspstreamurl");
            return (Criteria) this;
        }

        public Criteria andRtspstreamurlLessThan(String value) {
            addCriterion("rtspStreamurl <", value, "rtspstreamurl");
            return (Criteria) this;
        }

        public Criteria andRtspstreamurlLessThanOrEqualTo(String value) {
            addCriterion("rtspStreamurl <=", value, "rtspstreamurl");
            return (Criteria) this;
        }

        public Criteria andRtspstreamurlLike(String value) {
            addCriterion("rtspStreamurl like", value, "rtspstreamurl");
            return (Criteria) this;
        }

        public Criteria andRtspstreamurlNotLike(String value) {
            addCriterion("rtspStreamurl not like", value, "rtspstreamurl");
            return (Criteria) this;
        }

        public Criteria andRtspstreamurlIn(List<String> values) {
            addCriterion("rtspStreamurl in", values, "rtspstreamurl");
            return (Criteria) this;
        }

        public Criteria andRtspstreamurlNotIn(List<String> values) {
            addCriterion("rtspStreamurl not in", values, "rtspstreamurl");
            return (Criteria) this;
        }

        public Criteria andRtspstreamurlBetween(String value1, String value2) {
            addCriterion("rtspStreamurl between", value1, value2, "rtspstreamurl");
            return (Criteria) this;
        }

        public Criteria andRtspstreamurlNotBetween(String value1, String value2) {
            addCriterion("rtspStreamurl not between", value1, value2, "rtspstreamurl");
            return (Criteria) this;
        }

        public Criteria andRtsppsdIsNull() {
            addCriterion("rtsppsd is null");
            return (Criteria) this;
        }

        public Criteria andRtsppsdIsNotNull() {
            addCriterion("rtsppsd is not null");
            return (Criteria) this;
        }

        public Criteria andRtsppsdEqualTo(String value) {
            addCriterion("rtsppsd =", value, "rtsppsd");
            return (Criteria) this;
        }

        public Criteria andRtsppsdNotEqualTo(String value) {
            addCriterion("rtsppsd <>", value, "rtsppsd");
            return (Criteria) this;
        }

        public Criteria andRtsppsdGreaterThan(String value) {
            addCriterion("rtsppsd >", value, "rtsppsd");
            return (Criteria) this;
        }

        public Criteria andRtsppsdGreaterThanOrEqualTo(String value) {
            addCriterion("rtsppsd >=", value, "rtsppsd");
            return (Criteria) this;
        }

        public Criteria andRtsppsdLessThan(String value) {
            addCriterion("rtsppsd <", value, "rtsppsd");
            return (Criteria) this;
        }

        public Criteria andRtsppsdLessThanOrEqualTo(String value) {
            addCriterion("rtsppsd <=", value, "rtsppsd");
            return (Criteria) this;
        }

        public Criteria andRtsppsdLike(String value) {
            addCriterion("rtsppsd like", value, "rtsppsd");
            return (Criteria) this;
        }

        public Criteria andRtsppsdNotLike(String value) {
            addCriterion("rtsppsd not like", value, "rtsppsd");
            return (Criteria) this;
        }

        public Criteria andRtsppsdIn(List<String> values) {
            addCriterion("rtsppsd in", values, "rtsppsd");
            return (Criteria) this;
        }

        public Criteria andRtsppsdNotIn(List<String> values) {
            addCriterion("rtsppsd not in", values, "rtsppsd");
            return (Criteria) this;
        }

        public Criteria andRtsppsdBetween(String value1, String value2) {
            addCriterion("rtsppsd between", value1, value2, "rtsppsd");
            return (Criteria) this;
        }

        public Criteria andRtsppsdNotBetween(String value1, String value2) {
            addCriterion("rtsppsd not between", value1, value2, "rtsppsd");
            return (Criteria) this;
        }

        public Criteria andRtspusernameIsNull() {
            addCriterion("rtspusername is null");
            return (Criteria) this;
        }

        public Criteria andRtspusernameIsNotNull() {
            addCriterion("rtspusername is not null");
            return (Criteria) this;
        }

        public Criteria andRtspusernameEqualTo(String value) {
            addCriterion("rtspusername =", value, "rtspusername");
            return (Criteria) this;
        }

        public Criteria andRtspusernameNotEqualTo(String value) {
            addCriterion("rtspusername <>", value, "rtspusername");
            return (Criteria) this;
        }

        public Criteria andRtspusernameGreaterThan(String value) {
            addCriterion("rtspusername >", value, "rtspusername");
            return (Criteria) this;
        }

        public Criteria andRtspusernameGreaterThanOrEqualTo(String value) {
            addCriterion("rtspusername >=", value, "rtspusername");
            return (Criteria) this;
        }

        public Criteria andRtspusernameLessThan(String value) {
            addCriterion("rtspusername <", value, "rtspusername");
            return (Criteria) this;
        }

        public Criteria andRtspusernameLessThanOrEqualTo(String value) {
            addCriterion("rtspusername <=", value, "rtspusername");
            return (Criteria) this;
        }

        public Criteria andRtspusernameLike(String value) {
            addCriterion("rtspusername like", value, "rtspusername");
            return (Criteria) this;
        }

        public Criteria andRtspusernameNotLike(String value) {
            addCriterion("rtspusername not like", value, "rtspusername");
            return (Criteria) this;
        }

        public Criteria andRtspusernameIn(List<String> values) {
            addCriterion("rtspusername in", values, "rtspusername");
            return (Criteria) this;
        }

        public Criteria andRtspusernameNotIn(List<String> values) {
            addCriterion("rtspusername not in", values, "rtspusername");
            return (Criteria) this;
        }

        public Criteria andRtspusernameBetween(String value1, String value2) {
            addCriterion("rtspusername between", value1, value2, "rtspusername");
            return (Criteria) this;
        }

        public Criteria andRtspusernameNotBetween(String value1, String value2) {
            addCriterion("rtspusername not between", value1, value2, "rtspusername");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRegionidIsNull() {
            addCriterion("regionid is null");
            return (Criteria) this;
        }

        public Criteria andRegionidIsNotNull() {
            addCriterion("regionid is not null");
            return (Criteria) this;
        }

        public Criteria andRegionidEqualTo(Integer value) {
            addCriterion("regionid =", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidNotEqualTo(Integer value) {
            addCriterion("regionid <>", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidGreaterThan(Integer value) {
            addCriterion("regionid >", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("regionid >=", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidLessThan(Integer value) {
            addCriterion("regionid <", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidLessThanOrEqualTo(Integer value) {
            addCriterion("regionid <=", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidIn(List<Integer> values) {
            addCriterion("regionid in", values, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidNotIn(List<Integer> values) {
            addCriterion("regionid not in", values, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidBetween(Integer value1, Integer value2) {
            addCriterion("regionid between", value1, value2, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidNotBetween(Integer value1, Integer value2) {
            addCriterion("regionid not between", value1, value2, "regionid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}