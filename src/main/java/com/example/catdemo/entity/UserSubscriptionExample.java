package com.example.catdemo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
* 用户订阅表 Example
*
* @author zhanhuibin
* @since 2025-05-21 16:09
*/
public class UserSubscriptionExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserSubscriptionExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andFeatureIdIsNull() {
            addCriterion("feature_id is null");
            return (Criteria) this;
        }

        public Criteria andFeatureIdIsNotNull() {
            addCriterion("feature_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeatureIdEqualTo(String value) {
            addCriterion("feature_id =", value, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdNotEqualTo(String value) {
            addCriterion("feature_id <>", value, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdGreaterThan(String value) {
            addCriterion("feature_id >", value, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdGreaterThanOrEqualTo(String value) {
            addCriterion("feature_id >=", value, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdLessThan(String value) {
            addCriterion("feature_id <", value, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdLessThanOrEqualTo(String value) {
            addCriterion("feature_id <=", value, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdLike(String value) {
            addCriterion("feature_id like", value, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdNotLike(String value) {
            addCriterion("feature_id not like", value, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdIn(List<String> values) {
            addCriterion("feature_id in", values, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdNotIn(List<String> values) {
            addCriterion("feature_id not in", values, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdBetween(String value1, String value2) {
            addCriterion("feature_id between", value1, value2, "featureId");
            return (Criteria) this;
        }

        public Criteria andFeatureIdNotBetween(String value1, String value2) {
            addCriterion("feature_id not between", value1, value2, "featureId");
            return (Criteria) this;
        }

        public Criteria andSubscriptionStartIsNull() {
            addCriterion("subscription_start is null");
            return (Criteria) this;
        }

        public Criteria andSubscriptionStartIsNotNull() {
            addCriterion("subscription_start is not null");
            return (Criteria) this;
        }

        public Criteria andSubscriptionStartEqualTo(Date value) {
            addCriterion("subscription_start =", value, "subscriptionStart");
            return (Criteria) this;
        }

        public Criteria andSubscriptionStartNotEqualTo(Date value) {
            addCriterion("subscription_start <>", value, "subscriptionStart");
            return (Criteria) this;
        }

        public Criteria andSubscriptionStartGreaterThan(Date value) {
            addCriterion("subscription_start >", value, "subscriptionStart");
            return (Criteria) this;
        }

        public Criteria andSubscriptionStartGreaterThanOrEqualTo(Date value) {
            addCriterion("subscription_start >=", value, "subscriptionStart");
            return (Criteria) this;
        }

        public Criteria andSubscriptionStartLessThan(Date value) {
            addCriterion("subscription_start <", value, "subscriptionStart");
            return (Criteria) this;
        }

        public Criteria andSubscriptionStartLessThanOrEqualTo(Date value) {
            addCriterion("subscription_start <=", value, "subscriptionStart");
            return (Criteria) this;
        }

        public Criteria andSubscriptionStartIn(List<Date> values) {
            addCriterion("subscription_start in", values, "subscriptionStart");
            return (Criteria) this;
        }

        public Criteria andSubscriptionStartNotIn(List<Date> values) {
            addCriterion("subscription_start not in", values, "subscriptionStart");
            return (Criteria) this;
        }

        public Criteria andSubscriptionStartBetween(Date value1, Date value2) {
            addCriterion("subscription_start between", value1, value2, "subscriptionStart");
            return (Criteria) this;
        }

        public Criteria andSubscriptionStartNotBetween(Date value1, Date value2) {
            addCriterion("subscription_start not between", value1, value2, "subscriptionStart");
            return (Criteria) this;
        }

        public Criteria andSubscriptionEndIsNull() {
            addCriterion("subscription_end is null");
            return (Criteria) this;
        }

        public Criteria andSubscriptionEndIsNotNull() {
            addCriterion("subscription_end is not null");
            return (Criteria) this;
        }

        public Criteria andSubscriptionEndEqualTo(Date value) {
            addCriterion("subscription_end =", value, "subscriptionEnd");
            return (Criteria) this;
        }

        public Criteria andSubscriptionEndNotEqualTo(Date value) {
            addCriterion("subscription_end <>", value, "subscriptionEnd");
            return (Criteria) this;
        }

        public Criteria andSubscriptionEndGreaterThan(Date value) {
            addCriterion("subscription_end >", value, "subscriptionEnd");
            return (Criteria) this;
        }

        public Criteria andSubscriptionEndGreaterThanOrEqualTo(Date value) {
            addCriterion("subscription_end >=", value, "subscriptionEnd");
            return (Criteria) this;
        }

        public Criteria andSubscriptionEndLessThan(Date value) {
            addCriterion("subscription_end <", value, "subscriptionEnd");
            return (Criteria) this;
        }

        public Criteria andSubscriptionEndLessThanOrEqualTo(Date value) {
            addCriterion("subscription_end <=", value, "subscriptionEnd");
            return (Criteria) this;
        }

        public Criteria andSubscriptionEndIn(List<Date> values) {
            addCriterion("subscription_end in", values, "subscriptionEnd");
            return (Criteria) this;
        }

        public Criteria andSubscriptionEndNotIn(List<Date> values) {
            addCriterion("subscription_end not in", values, "subscriptionEnd");
            return (Criteria) this;
        }

        public Criteria andSubscriptionEndBetween(Date value1, Date value2) {
            addCriterion("subscription_end between", value1, value2, "subscriptionEnd");
            return (Criteria) this;
        }

        public Criteria andSubscriptionEndNotBetween(Date value1, Date value2) {
            addCriterion("subscription_end not between", value1, value2, "subscriptionEnd");
            return (Criteria) this;
        }

        public Criteria andAutoRenewIsNull() {
            addCriterion("auto_renew is null");
            return (Criteria) this;
        }

        public Criteria andAutoRenewIsNotNull() {
            addCriterion("auto_renew is not null");
            return (Criteria) this;
        }

        public Criteria andAutoRenewEqualTo(Integer value) {
            addCriterion("auto_renew =", value, "autoRenew");
            return (Criteria) this;
        }

        public Criteria andAutoRenewNotEqualTo(Integer value) {
            addCriterion("auto_renew <>", value, "autoRenew");
            return (Criteria) this;
        }

        public Criteria andAutoRenewGreaterThan(Integer value) {
            addCriterion("auto_renew >", value, "autoRenew");
            return (Criteria) this;
        }

        public Criteria andAutoRenewGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_renew >=", value, "autoRenew");
            return (Criteria) this;
        }

        public Criteria andAutoRenewLessThan(Integer value) {
            addCriterion("auto_renew <", value, "autoRenew");
            return (Criteria) this;
        }

        public Criteria andAutoRenewLessThanOrEqualTo(Integer value) {
            addCriterion("auto_renew <=", value, "autoRenew");
            return (Criteria) this;
        }

        public Criteria andAutoRenewIn(List<Integer> values) {
            addCriterion("auto_renew in", values, "autoRenew");
            return (Criteria) this;
        }

        public Criteria andAutoRenewNotIn(List<Integer> values) {
            addCriterion("auto_renew not in", values, "autoRenew");
            return (Criteria) this;
        }

        public Criteria andAutoRenewBetween(Integer value1, Integer value2) {
            addCriterion("auto_renew between", value1, value2, "autoRenew");
            return (Criteria) this;
        }

        public Criteria andAutoRenewNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_renew not between", value1, value2, "autoRenew");
            return (Criteria) this;
        }

        public Criteria andIsTrialIsNull() {
            addCriterion("is_trial is null");
            return (Criteria) this;
        }

        public Criteria andIsTrialIsNotNull() {
            addCriterion("is_trial is not null");
            return (Criteria) this;
        }

        public Criteria andIsTrialEqualTo(Integer value) {
            addCriterion("is_trial =", value, "isTrial");
            return (Criteria) this;
        }

        public Criteria andIsTrialNotEqualTo(Integer value) {
            addCriterion("is_trial <>", value, "isTrial");
            return (Criteria) this;
        }

        public Criteria andIsTrialGreaterThan(Integer value) {
            addCriterion("is_trial >", value, "isTrial");
            return (Criteria) this;
        }

        public Criteria andIsTrialGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_trial >=", value, "isTrial");
            return (Criteria) this;
        }

        public Criteria andIsTrialLessThan(Integer value) {
            addCriterion("is_trial <", value, "isTrial");
            return (Criteria) this;
        }

        public Criteria andIsTrialLessThanOrEqualTo(Integer value) {
            addCriterion("is_trial <=", value, "isTrial");
            return (Criteria) this;
        }

        public Criteria andIsTrialIn(List<Integer> values) {
            addCriterion("is_trial in", values, "isTrial");
            return (Criteria) this;
        }

        public Criteria andIsTrialNotIn(List<Integer> values) {
            addCriterion("is_trial not in", values, "isTrial");
            return (Criteria) this;
        }

        public Criteria andIsTrialBetween(Integer value1, Integer value2) {
            addCriterion("is_trial between", value1, value2, "isTrial");
            return (Criteria) this;
        }

        public Criteria andIsTrialNotBetween(Integer value1, Integer value2) {
            addCriterion("is_trial not between", value1, value2, "isTrial");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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
