package com.example.catdemo.entity;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

/**
*  Example
*
* @author zhanhuibin
* @since 2024-12-10 10:44
*/
public class TransfersExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransfersExample() {
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

        public Criteria andTransferIdIsNull() {
            addCriterion("transfer_id is null");
            return (Criteria) this;
        }

        public Criteria andTransferIdIsNotNull() {
            addCriterion("transfer_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransferIdEqualTo(String value) {
            addCriterion("transfer_id =", value, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdNotEqualTo(String value) {
            addCriterion("transfer_id <>", value, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdGreaterThan(String value) {
            addCriterion("transfer_id >", value, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdGreaterThanOrEqualTo(String value) {
            addCriterion("transfer_id >=", value, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdLessThan(String value) {
            addCriterion("transfer_id <", value, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdLessThanOrEqualTo(String value) {
            addCriterion("transfer_id <=", value, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdLike(String value) {
            addCriterion("transfer_id like", value, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdNotLike(String value) {
            addCriterion("transfer_id not like", value, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdIn(List<String> values) {
            addCriterion("transfer_id in", values, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdNotIn(List<String> values) {
            addCriterion("transfer_id not in", values, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdBetween(String value1, String value2) {
            addCriterion("transfer_id between", value1, value2, "transferId");
            return (Criteria) this;
        }

        public Criteria andTransferIdNotBetween(String value1, String value2) {
            addCriterion("transfer_id not between", value1, value2, "transferId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdIsNull() {
            addCriterion("out_account_id is null");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdIsNotNull() {
            addCriterion("out_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdEqualTo(String value) {
            addCriterion("out_account_id =", value, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdNotEqualTo(String value) {
            addCriterion("out_account_id <>", value, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdGreaterThan(String value) {
            addCriterion("out_account_id >", value, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("out_account_id >=", value, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdLessThan(String value) {
            addCriterion("out_account_id <", value, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdLessThanOrEqualTo(String value) {
            addCriterion("out_account_id <=", value, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdLike(String value) {
            addCriterion("out_account_id like", value, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdNotLike(String value) {
            addCriterion("out_account_id not like", value, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdIn(List<String> values) {
            addCriterion("out_account_id in", values, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdNotIn(List<String> values) {
            addCriterion("out_account_id not in", values, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdBetween(String value1, String value2) {
            addCriterion("out_account_id between", value1, value2, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdNotBetween(String value1, String value2) {
            addCriterion("out_account_id not between", value1, value2, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andInAccountIdIsNull() {
            addCriterion("in_account_id is null");
            return (Criteria) this;
        }

        public Criteria andInAccountIdIsNotNull() {
            addCriterion("in_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andInAccountIdEqualTo(String value) {
            addCriterion("in_account_id =", value, "inAccountId");
            return (Criteria) this;
        }

        public Criteria andInAccountIdNotEqualTo(String value) {
            addCriterion("in_account_id <>", value, "inAccountId");
            return (Criteria) this;
        }

        public Criteria andInAccountIdGreaterThan(String value) {
            addCriterion("in_account_id >", value, "inAccountId");
            return (Criteria) this;
        }

        public Criteria andInAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("in_account_id >=", value, "inAccountId");
            return (Criteria) this;
        }

        public Criteria andInAccountIdLessThan(String value) {
            addCriterion("in_account_id <", value, "inAccountId");
            return (Criteria) this;
        }

        public Criteria andInAccountIdLessThanOrEqualTo(String value) {
            addCriterion("in_account_id <=", value, "inAccountId");
            return (Criteria) this;
        }

        public Criteria andInAccountIdLike(String value) {
            addCriterion("in_account_id like", value, "inAccountId");
            return (Criteria) this;
        }

        public Criteria andInAccountIdNotLike(String value) {
            addCriterion("in_account_id not like", value, "inAccountId");
            return (Criteria) this;
        }

        public Criteria andInAccountIdIn(List<String> values) {
            addCriterion("in_account_id in", values, "inAccountId");
            return (Criteria) this;
        }

        public Criteria andInAccountIdNotIn(List<String> values) {
            addCriterion("in_account_id not in", values, "inAccountId");
            return (Criteria) this;
        }

        public Criteria andInAccountIdBetween(String value1, String value2) {
            addCriterion("in_account_id between", value1, value2, "inAccountId");
            return (Criteria) this;
        }

        public Criteria andInAccountIdNotBetween(String value1, String value2) {
            addCriterion("in_account_id not between", value1, value2, "inAccountId");
            return (Criteria) this;
        }

        public Criteria andTransferTypeIsNull() {
            addCriterion("transfer_type is null");
            return (Criteria) this;
        }

        public Criteria andTransferTypeIsNotNull() {
            addCriterion("transfer_type is not null");
            return (Criteria) this;
        }

        public Criteria andTransferTypeEqualTo(String value) {
            addCriterion("transfer_type =", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeNotEqualTo(String value) {
            addCriterion("transfer_type <>", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeGreaterThan(String value) {
            addCriterion("transfer_type >", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeGreaterThanOrEqualTo(String value) {
            addCriterion("transfer_type >=", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeLessThan(String value) {
            addCriterion("transfer_type <", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeLessThanOrEqualTo(String value) {
            addCriterion("transfer_type <=", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeLike(String value) {
            addCriterion("transfer_type like", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeNotLike(String value) {
            addCriterion("transfer_type not like", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeIn(List<String> values) {
            addCriterion("transfer_type in", values, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeNotIn(List<String> values) {
            addCriterion("transfer_type not in", values, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeBetween(String value1, String value2) {
            addCriterion("transfer_type between", value1, value2, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeNotBetween(String value1, String value2) {
            addCriterion("transfer_type not between", value1, value2, "transferType");
            return (Criteria) this;
        }

        public Criteria andScheduledTransferTimeIsNull() {
            addCriterion("scheduled_transfer_time is null");
            return (Criteria) this;
        }

        public Criteria andScheduledTransferTimeIsNotNull() {
            addCriterion("scheduled_transfer_time is not null");
            return (Criteria) this;
        }

        public Criteria andScheduledTransferTimeEqualTo(Date value) {
            addCriterion("scheduled_transfer_time =", value, "scheduledTransferTime");
            return (Criteria) this;
        }

        public Criteria andScheduledTransferTimeNotEqualTo(Date value) {
            addCriterion("scheduled_transfer_time <>", value, "scheduledTransferTime");
            return (Criteria) this;
        }

        public Criteria andScheduledTransferTimeGreaterThan(Date value) {
            addCriterion("scheduled_transfer_time >", value, "scheduledTransferTime");
            return (Criteria) this;
        }

        public Criteria andScheduledTransferTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("scheduled_transfer_time >=", value, "scheduledTransferTime");
            return (Criteria) this;
        }

        public Criteria andScheduledTransferTimeLessThan(Date value) {
            addCriterion("scheduled_transfer_time <", value, "scheduledTransferTime");
            return (Criteria) this;
        }

        public Criteria andScheduledTransferTimeLessThanOrEqualTo(Date value) {
            addCriterion("scheduled_transfer_time <=", value, "scheduledTransferTime");
            return (Criteria) this;
        }

        public Criteria andScheduledTransferTimeIn(List<Date> values) {
            addCriterion("scheduled_transfer_time in", values, "scheduledTransferTime");
            return (Criteria) this;
        }

        public Criteria andScheduledTransferTimeNotIn(List<Date> values) {
            addCriterion("scheduled_transfer_time not in", values, "scheduledTransferTime");
            return (Criteria) this;
        }

        public Criteria andScheduledTransferTimeBetween(Date value1, Date value2) {
            addCriterion("scheduled_transfer_time between", value1, value2, "scheduledTransferTime");
            return (Criteria) this;
        }

        public Criteria andScheduledTransferTimeNotBetween(Date value1, Date value2) {
            addCriterion("scheduled_transfer_time not between", value1, value2, "scheduledTransferTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTransferTimeIsNull() {
            addCriterion("periodic_transfer_time is null");
            return (Criteria) this;
        }

        public Criteria andPeriodicTransferTimeIsNotNull() {
            addCriterion("periodic_transfer_time is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodicTransferTimeEqualTo(String value) {
            addCriterion("periodic_transfer_time =", value, "periodicTransferTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTransferTimeNotEqualTo(String value) {
            addCriterion("periodic_transfer_time <>", value, "periodicTransferTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTransferTimeGreaterThan(String value) {
            addCriterion("periodic_transfer_time >", value, "periodicTransferTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTransferTimeGreaterThanOrEqualTo(String value) {
            addCriterion("periodic_transfer_time >=", value, "periodicTransferTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTransferTimeLessThan(String value) {
            addCriterion("periodic_transfer_time <", value, "periodicTransferTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTransferTimeLessThanOrEqualTo(String value) {
            addCriterion("periodic_transfer_time <=", value, "periodicTransferTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTransferTimeLike(String value) {
            addCriterion("periodic_transfer_time like", value, "periodicTransferTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTransferTimeNotLike(String value) {
            addCriterion("periodic_transfer_time not like", value, "periodicTransferTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTransferTimeIn(List<String> values) {
            addCriterion("periodic_transfer_time in", values, "periodicTransferTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTransferTimeNotIn(List<String> values) {
            addCriterion("periodic_transfer_time not in", values, "periodicTransferTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTransferTimeBetween(String value1, String value2) {
            addCriterion("periodic_transfer_time between", value1, value2, "periodicTransferTime");
            return (Criteria) this;
        }

        public Criteria andPeriodicTransferTimeNotBetween(String value1, String value2) {
            addCriterion("periodic_transfer_time not between", value1, value2, "periodicTransferTime");
            return (Criteria) this;
        }

        public Criteria andTransferCountIsNull() {
            addCriterion("transfer_count is null");
            return (Criteria) this;
        }

        public Criteria andTransferCountIsNotNull() {
            addCriterion("transfer_count is not null");
            return (Criteria) this;
        }

        public Criteria andTransferCountEqualTo(Integer value) {
            addCriterion("transfer_count =", value, "transferCount");
            return (Criteria) this;
        }

        public Criteria andTransferCountNotEqualTo(Integer value) {
            addCriterion("transfer_count <>", value, "transferCount");
            return (Criteria) this;
        }

        public Criteria andTransferCountGreaterThan(Integer value) {
            addCriterion("transfer_count >", value, "transferCount");
            return (Criteria) this;
        }

        public Criteria andTransferCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("transfer_count >=", value, "transferCount");
            return (Criteria) this;
        }

        public Criteria andTransferCountLessThan(Integer value) {
            addCriterion("transfer_count <", value, "transferCount");
            return (Criteria) this;
        }

        public Criteria andTransferCountLessThanOrEqualTo(Integer value) {
            addCriterion("transfer_count <=", value, "transferCount");
            return (Criteria) this;
        }

        public Criteria andTransferCountIn(List<Integer> values) {
            addCriterion("transfer_count in", values, "transferCount");
            return (Criteria) this;
        }

        public Criteria andTransferCountNotIn(List<Integer> values) {
            addCriterion("transfer_count not in", values, "transferCount");
            return (Criteria) this;
        }

        public Criteria andTransferCountBetween(Integer value1, Integer value2) {
            addCriterion("transfer_count between", value1, value2, "transferCount");
            return (Criteria) this;
        }

        public Criteria andTransferCountNotBetween(Integer value1, Integer value2) {
            addCriterion("transfer_count not between", value1, value2, "transferCount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountIsNull() {
            addCriterion("transfer_amount is null");
            return (Criteria) this;
        }

        public Criteria andTransferAmountIsNotNull() {
            addCriterion("transfer_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTransferAmountEqualTo(BigDecimal value) {
            addCriterion("transfer_amount =", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountNotEqualTo(BigDecimal value) {
            addCriterion("transfer_amount <>", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountGreaterThan(BigDecimal value) {
            addCriterion("transfer_amount >", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("transfer_amount >=", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountLessThan(BigDecimal value) {
            addCriterion("transfer_amount <", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("transfer_amount <=", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountIn(List<BigDecimal> values) {
            addCriterion("transfer_amount in", values, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountNotIn(List<BigDecimal> values) {
            addCriterion("transfer_amount not in", values, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("transfer_amount between", value1, value2, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("transfer_amount not between", value1, value2, "transferAmount");
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
