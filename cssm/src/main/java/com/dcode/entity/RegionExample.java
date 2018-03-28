package com.dcode.entity;

import java.util.ArrayList;
import java.util.List;

public class RegionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RegionExample() {
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

        public Criteria andReginonidIsNull() {
            addCriterion("reginonid is null");
            return (Criteria) this;
        }

        public Criteria andReginonidIsNotNull() {
            addCriterion("reginonid is not null");
            return (Criteria) this;
        }

        public Criteria andReginonidEqualTo(Integer value) {
            addCriterion("reginonid =", value, "reginonid");
            return (Criteria) this;
        }

        public Criteria andReginonidNotEqualTo(Integer value) {
            addCriterion("reginonid <>", value, "reginonid");
            return (Criteria) this;
        }

        public Criteria andReginonidGreaterThan(Integer value) {
            addCriterion("reginonid >", value, "reginonid");
            return (Criteria) this;
        }

        public Criteria andReginonidGreaterThanOrEqualTo(Integer value) {
            addCriterion("reginonid >=", value, "reginonid");
            return (Criteria) this;
        }

        public Criteria andReginonidLessThan(Integer value) {
            addCriterion("reginonid <", value, "reginonid");
            return (Criteria) this;
        }

        public Criteria andReginonidLessThanOrEqualTo(Integer value) {
            addCriterion("reginonid <=", value, "reginonid");
            return (Criteria) this;
        }

        public Criteria andReginonidIn(List<Integer> values) {
            addCriterion("reginonid in", values, "reginonid");
            return (Criteria) this;
        }

        public Criteria andReginonidNotIn(List<Integer> values) {
            addCriterion("reginonid not in", values, "reginonid");
            return (Criteria) this;
        }

        public Criteria andReginonidBetween(Integer value1, Integer value2) {
            addCriterion("reginonid between", value1, value2, "reginonid");
            return (Criteria) this;
        }

        public Criteria andReginonidNotBetween(Integer value1, Integer value2) {
            addCriterion("reginonid not between", value1, value2, "reginonid");
            return (Criteria) this;
        }

        public Criteria andReginonnameIsNull() {
            addCriterion("reginonname is null");
            return (Criteria) this;
        }

        public Criteria andReginonnameIsNotNull() {
            addCriterion("reginonname is not null");
            return (Criteria) this;
        }

        public Criteria andReginonnameEqualTo(String value) {
            addCriterion("reginonname =", value, "reginonname");
            return (Criteria) this;
        }

        public Criteria andReginonnameNotEqualTo(String value) {
            addCriterion("reginonname <>", value, "reginonname");
            return (Criteria) this;
        }

        public Criteria andReginonnameGreaterThan(String value) {
            addCriterion("reginonname >", value, "reginonname");
            return (Criteria) this;
        }

        public Criteria andReginonnameGreaterThanOrEqualTo(String value) {
            addCriterion("reginonname >=", value, "reginonname");
            return (Criteria) this;
        }

        public Criteria andReginonnameLessThan(String value) {
            addCriterion("reginonname <", value, "reginonname");
            return (Criteria) this;
        }

        public Criteria andReginonnameLessThanOrEqualTo(String value) {
            addCriterion("reginonname <=", value, "reginonname");
            return (Criteria) this;
        }

        public Criteria andReginonnameLike(String value) {
            addCriterion("reginonname like", value, "reginonname");
            return (Criteria) this;
        }

        public Criteria andReginonnameNotLike(String value) {
            addCriterion("reginonname not like", value, "reginonname");
            return (Criteria) this;
        }

        public Criteria andReginonnameIn(List<String> values) {
            addCriterion("reginonname in", values, "reginonname");
            return (Criteria) this;
        }

        public Criteria andReginonnameNotIn(List<String> values) {
            addCriterion("reginonname not in", values, "reginonname");
            return (Criteria) this;
        }

        public Criteria andReginonnameBetween(String value1, String value2) {
            addCriterion("reginonname between", value1, value2, "reginonname");
            return (Criteria) this;
        }

        public Criteria andReginonnameNotBetween(String value1, String value2) {
            addCriterion("reginonname not between", value1, value2, "reginonname");
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