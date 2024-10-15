package com.example.catdemo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
* 会员权益表 Example
*
* @author zhanhuibin
* @since 2025-01-13 11:11
*/
public class MembershipBenefitExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MembershipBenefitExample() {
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

        public Criteria andBenefitIdIsNull() {
            addCriterion("benefit_id is null");
            return (Criteria) this;
        }

        public Criteria andBenefitIdIsNotNull() {
            addCriterion("benefit_id is not null");
            return (Criteria) this;
        }

        public Criteria andBenefitIdEqualTo(String value) {
            addCriterion("benefit_id =", value, "benefitId");
            return (Criteria) this;
        }

        public Criteria andBenefitIdNotEqualTo(String value) {
            addCriterion("benefit_id <>", value, "benefitId");
            return (Criteria) this;
        }

        public Criteria andBenefitIdGreaterThan(String value) {
            addCriterion("benefit_id >", value, "benefitId");
            return (Criteria) this;
        }

        public Criteria andBenefitIdGreaterThanOrEqualTo(String value) {
            addCriterion("benefit_id >=", value, "benefitId");
            return (Criteria) this;
        }

        public Criteria andBenefitIdLessThan(String value) {
            addCriterion("benefit_id <", value, "benefitId");
            return (Criteria) this;
        }

        public Criteria andBenefitIdLessThanOrEqualTo(String value) {
            addCriterion("benefit_id <=", value, "benefitId");
            return (Criteria) this;
        }

        public Criteria andBenefitIdLike(String value) {
            addCriterion("benefit_id like", value, "benefitId");
            return (Criteria) this;
        }

        public Criteria andBenefitIdNotLike(String value) {
            addCriterion("benefit_id not like", value, "benefitId");
            return (Criteria) this;
        }

        public Criteria andBenefitIdIn(List<String> values) {
            addCriterion("benefit_id in", values, "benefitId");
            return (Criteria) this;
        }

        public Criteria andBenefitIdNotIn(List<String> values) {
            addCriterion("benefit_id not in", values, "benefitId");
            return (Criteria) this;
        }

        public Criteria andBenefitIdBetween(String value1, String value2) {
            addCriterion("benefit_id between", value1, value2, "benefitId");
            return (Criteria) this;
        }

        public Criteria andBenefitIdNotBetween(String value1, String value2) {
            addCriterion("benefit_id not between", value1, value2, "benefitId");
            return (Criteria) this;
        }

        public Criteria andLevelIdIsNull() {
            addCriterion("level_id is null");
            return (Criteria) this;
        }

        public Criteria andLevelIdIsNotNull() {
            addCriterion("level_id is not null");
            return (Criteria) this;
        }

        public Criteria andLevelIdEqualTo(String value) {
            addCriterion("level_id =", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdNotEqualTo(String value) {
            addCriterion("level_id <>", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdGreaterThan(String value) {
            addCriterion("level_id >", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdGreaterThanOrEqualTo(String value) {
            addCriterion("level_id >=", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdLessThan(String value) {
            addCriterion("level_id <", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdLessThanOrEqualTo(String value) {
            addCriterion("level_id <=", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdLike(String value) {
            addCriterion("level_id like", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdNotLike(String value) {
            addCriterion("level_id not like", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdIn(List<String> values) {
            addCriterion("level_id in", values, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdNotIn(List<String> values) {
            addCriterion("level_id not in", values, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdBetween(String value1, String value2) {
            addCriterion("level_id between", value1, value2, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdNotBetween(String value1, String value2) {
            addCriterion("level_id not between", value1, value2, "levelId");
            return (Criteria) this;
        }

        public Criteria andBenefitNameIsNull() {
            addCriterion("benefit_name is null");
            return (Criteria) this;
        }

        public Criteria andBenefitNameIsNotNull() {
            addCriterion("benefit_name is not null");
            return (Criteria) this;
        }

        public Criteria andBenefitNameEqualTo(String value) {
            addCriterion("benefit_name =", value, "benefitName");
            return (Criteria) this;
        }

        public Criteria andBenefitNameNotEqualTo(String value) {
            addCriterion("benefit_name <>", value, "benefitName");
            return (Criteria) this;
        }

        public Criteria andBenefitNameGreaterThan(String value) {
            addCriterion("benefit_name >", value, "benefitName");
            return (Criteria) this;
        }

        public Criteria andBenefitNameGreaterThanOrEqualTo(String value) {
            addCriterion("benefit_name >=", value, "benefitName");
            return (Criteria) this;
        }

        public Criteria andBenefitNameLessThan(String value) {
            addCriterion("benefit_name <", value, "benefitName");
            return (Criteria) this;
        }

        public Criteria andBenefitNameLessThanOrEqualTo(String value) {
            addCriterion("benefit_name <=", value, "benefitName");
            return (Criteria) this;
        }

        public Criteria andBenefitNameLike(String value) {
            addCriterion("benefit_name like", value, "benefitName");
            return (Criteria) this;
        }

        public Criteria andBenefitNameNotLike(String value) {
            addCriterion("benefit_name not like", value, "benefitName");
            return (Criteria) this;
        }

        public Criteria andBenefitNameIn(List<String> values) {
            addCriterion("benefit_name in", values, "benefitName");
            return (Criteria) this;
        }

        public Criteria andBenefitNameNotIn(List<String> values) {
            addCriterion("benefit_name not in", values, "benefitName");
            return (Criteria) this;
        }

        public Criteria andBenefitNameBetween(String value1, String value2) {
            addCriterion("benefit_name between", value1, value2, "benefitName");
            return (Criteria) this;
        }

        public Criteria andBenefitNameNotBetween(String value1, String value2) {
            addCriterion("benefit_name not between", value1, value2, "benefitName");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
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
