package com.example.catdemo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
* 用户会员表 Example
*
* @author zhanhuibin
* @since 2025-01-12 16:03
*/
public class UserMembershipExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserMembershipExample() {
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

        public Criteria andMembershipIdIsNull() {
            addCriterion("membership_id is null");
            return (Criteria) this;
        }

        public Criteria andMembershipIdIsNotNull() {
            addCriterion("membership_id is not null");
            return (Criteria) this;
        }

        public Criteria andMembershipIdEqualTo(String value) {
            addCriterion("membership_id =", value, "membershipId");
            return (Criteria) this;
        }

        public Criteria andMembershipIdNotEqualTo(String value) {
            addCriterion("membership_id <>", value, "membershipId");
            return (Criteria) this;
        }

        public Criteria andMembershipIdGreaterThan(String value) {
            addCriterion("membership_id >", value, "membershipId");
            return (Criteria) this;
        }

        public Criteria andMembershipIdGreaterThanOrEqualTo(String value) {
            addCriterion("membership_id >=", value, "membershipId");
            return (Criteria) this;
        }

        public Criteria andMembershipIdLessThan(String value) {
            addCriterion("membership_id <", value, "membershipId");
            return (Criteria) this;
        }

        public Criteria andMembershipIdLessThanOrEqualTo(String value) {
            addCriterion("membership_id <=", value, "membershipId");
            return (Criteria) this;
        }

        public Criteria andMembershipIdLike(String value) {
            addCriterion("membership_id like", value, "membershipId");
            return (Criteria) this;
        }

        public Criteria andMembershipIdNotLike(String value) {
            addCriterion("membership_id not like", value, "membershipId");
            return (Criteria) this;
        }

        public Criteria andMembershipIdIn(List<String> values) {
            addCriterion("membership_id in", values, "membershipId");
            return (Criteria) this;
        }

        public Criteria andMembershipIdNotIn(List<String> values) {
            addCriterion("membership_id not in", values, "membershipId");
            return (Criteria) this;
        }

        public Criteria andMembershipIdBetween(String value1, String value2) {
            addCriterion("membership_id between", value1, value2, "membershipId");
            return (Criteria) this;
        }

        public Criteria andMembershipIdNotBetween(String value1, String value2) {
            addCriterion("membership_id not between", value1, value2, "membershipId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andMembershipLevelIsNull() {
            addCriterion("membership_level is null");
            return (Criteria) this;
        }

        public Criteria andMembershipLevelIsNotNull() {
            addCriterion("membership_level is not null");
            return (Criteria) this;
        }

        public Criteria andMembershipLevelEqualTo(Integer value) {
            addCriterion("membership_level =", value, "membershipLevel");
            return (Criteria) this;
        }

        public Criteria andMembershipLevelNotEqualTo(Integer value) {
            addCriterion("membership_level <>", value, "membershipLevel");
            return (Criteria) this;
        }

        public Criteria andMembershipLevelGreaterThan(Integer value) {
            addCriterion("membership_level >", value, "membershipLevel");
            return (Criteria) this;
        }

        public Criteria andMembershipLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("membership_level >=", value, "membershipLevel");
            return (Criteria) this;
        }

        public Criteria andMembershipLevelLessThan(Integer value) {
            addCriterion("membership_level <", value, "membershipLevel");
            return (Criteria) this;
        }

        public Criteria andMembershipLevelLessThanOrEqualTo(Integer value) {
            addCriterion("membership_level <=", value, "membershipLevel");
            return (Criteria) this;
        }

        public Criteria andMembershipLevelIn(List<Integer> values) {
            addCriterion("membership_level in", values, "membershipLevel");
            return (Criteria) this;
        }

        public Criteria andMembershipLevelNotIn(List<Integer> values) {
            addCriterion("membership_level not in", values, "membershipLevel");
            return (Criteria) this;
        }

        public Criteria andMembershipLevelBetween(Integer value1, Integer value2) {
            addCriterion("membership_level between", value1, value2, "membershipLevel");
            return (Criteria) this;
        }

        public Criteria andMembershipLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("membership_level not between", value1, value2, "membershipLevel");
            return (Criteria) this;
        }

        public Criteria andMembershipStartDateIsNull() {
            addCriterion("membership_start_date is null");
            return (Criteria) this;
        }

        public Criteria andMembershipStartDateIsNotNull() {
            addCriterion("membership_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andMembershipStartDateEqualTo(Date value) {
            addCriterion("membership_start_date =", value, "membershipStartDate");
            return (Criteria) this;
        }

        public Criteria andMembershipStartDateNotEqualTo(Date value) {
            addCriterion("membership_start_date <>", value, "membershipStartDate");
            return (Criteria) this;
        }

        public Criteria andMembershipStartDateGreaterThan(Date value) {
            addCriterion("membership_start_date >", value, "membershipStartDate");
            return (Criteria) this;
        }

        public Criteria andMembershipStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("membership_start_date >=", value, "membershipStartDate");
            return (Criteria) this;
        }

        public Criteria andMembershipStartDateLessThan(Date value) {
            addCriterion("membership_start_date <", value, "membershipStartDate");
            return (Criteria) this;
        }

        public Criteria andMembershipStartDateLessThanOrEqualTo(Date value) {
            addCriterion("membership_start_date <=", value, "membershipStartDate");
            return (Criteria) this;
        }

        public Criteria andMembershipStartDateIn(List<Date> values) {
            addCriterion("membership_start_date in", values, "membershipStartDate");
            return (Criteria) this;
        }

        public Criteria andMembershipStartDateNotIn(List<Date> values) {
            addCriterion("membership_start_date not in", values, "membershipStartDate");
            return (Criteria) this;
        }

        public Criteria andMembershipStartDateBetween(Date value1, Date value2) {
            addCriterion("membership_start_date between", value1, value2, "membershipStartDate");
            return (Criteria) this;
        }

        public Criteria andMembershipStartDateNotBetween(Date value1, Date value2) {
            addCriterion("membership_start_date not between", value1, value2, "membershipStartDate");
            return (Criteria) this;
        }

        public Criteria andMembershipEndDateIsNull() {
            addCriterion("membership_end_date is null");
            return (Criteria) this;
        }

        public Criteria andMembershipEndDateIsNotNull() {
            addCriterion("membership_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andMembershipEndDateEqualTo(Date value) {
            addCriterion("membership_end_date =", value, "membershipEndDate");
            return (Criteria) this;
        }

        public Criteria andMembershipEndDateNotEqualTo(Date value) {
            addCriterion("membership_end_date <>", value, "membershipEndDate");
            return (Criteria) this;
        }

        public Criteria andMembershipEndDateGreaterThan(Date value) {
            addCriterion("membership_end_date >", value, "membershipEndDate");
            return (Criteria) this;
        }

        public Criteria andMembershipEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("membership_end_date >=", value, "membershipEndDate");
            return (Criteria) this;
        }

        public Criteria andMembershipEndDateLessThan(Date value) {
            addCriterion("membership_end_date <", value, "membershipEndDate");
            return (Criteria) this;
        }

        public Criteria andMembershipEndDateLessThanOrEqualTo(Date value) {
            addCriterion("membership_end_date <=", value, "membershipEndDate");
            return (Criteria) this;
        }

        public Criteria andMembershipEndDateIn(List<Date> values) {
            addCriterion("membership_end_date in", values, "membershipEndDate");
            return (Criteria) this;
        }

        public Criteria andMembershipEndDateNotIn(List<Date> values) {
            addCriterion("membership_end_date not in", values, "membershipEndDate");
            return (Criteria) this;
        }

        public Criteria andMembershipEndDateBetween(Date value1, Date value2) {
            addCriterion("membership_end_date between", value1, value2, "membershipEndDate");
            return (Criteria) this;
        }

        public Criteria andMembershipEndDateNotBetween(Date value1, Date value2) {
            addCriterion("membership_end_date not between", value1, value2, "membershipEndDate");
            return (Criteria) this;
        }

        public Criteria andMembershipStatusIsNull() {
            addCriterion("membership_status is null");
            return (Criteria) this;
        }

        public Criteria andMembershipStatusIsNotNull() {
            addCriterion("membership_status is not null");
            return (Criteria) this;
        }

        public Criteria andMembershipStatusEqualTo(Integer value) {
            addCriterion("membership_status =", value, "membershipStatus");
            return (Criteria) this;
        }

        public Criteria andMembershipStatusNotEqualTo(Integer value) {
            addCriterion("membership_status <>", value, "membershipStatus");
            return (Criteria) this;
        }

        public Criteria andMembershipStatusGreaterThan(Integer value) {
            addCriterion("membership_status >", value, "membershipStatus");
            return (Criteria) this;
        }

        public Criteria andMembershipStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("membership_status >=", value, "membershipStatus");
            return (Criteria) this;
        }

        public Criteria andMembershipStatusLessThan(Integer value) {
            addCriterion("membership_status <", value, "membershipStatus");
            return (Criteria) this;
        }

        public Criteria andMembershipStatusLessThanOrEqualTo(Integer value) {
            addCriterion("membership_status <=", value, "membershipStatus");
            return (Criteria) this;
        }

        public Criteria andMembershipStatusIn(List<Integer> values) {
            addCriterion("membership_status in", values, "membershipStatus");
            return (Criteria) this;
        }

        public Criteria andMembershipStatusNotIn(List<Integer> values) {
            addCriterion("membership_status not in", values, "membershipStatus");
            return (Criteria) this;
        }

        public Criteria andMembershipStatusBetween(Integer value1, Integer value2) {
            addCriterion("membership_status between", value1, value2, "membershipStatus");
            return (Criteria) this;
        }

        public Criteria andMembershipStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("membership_status not between", value1, value2, "membershipStatus");
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
