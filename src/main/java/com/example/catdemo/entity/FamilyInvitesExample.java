package com.example.catdemo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
* 家庭成员邀请码表 Example
*
* @author zhanhuibin
* @since 2025-03-10 10:25
*/
public class FamilyInvitesExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FamilyInvitesExample() {
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

        public Criteria andInviteCodeIsNull() {
            addCriterion("invite_code is null");
            return (Criteria) this;
        }

        public Criteria andInviteCodeIsNotNull() {
            addCriterion("invite_code is not null");
            return (Criteria) this;
        }

        public Criteria andInviteCodeEqualTo(String value) {
            addCriterion("invite_code =", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeNotEqualTo(String value) {
            addCriterion("invite_code <>", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeGreaterThan(String value) {
            addCriterion("invite_code >", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeGreaterThanOrEqualTo(String value) {
            addCriterion("invite_code >=", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeLessThan(String value) {
            addCriterion("invite_code <", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeLessThanOrEqualTo(String value) {
            addCriterion("invite_code <=", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeLike(String value) {
            addCriterion("invite_code like", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeNotLike(String value) {
            addCriterion("invite_code not like", value, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeIn(List<String> values) {
            addCriterion("invite_code in", values, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeNotIn(List<String> values) {
            addCriterion("invite_code not in", values, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeBetween(String value1, String value2) {
            addCriterion("invite_code between", value1, value2, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andInviteCodeNotBetween(String value1, String value2) {
            addCriterion("invite_code not between", value1, value2, "inviteCode");
            return (Criteria) this;
        }

        public Criteria andFamilyGroupsIdIsNull() {
            addCriterion("family_groups_id is null");
            return (Criteria) this;
        }

        public Criteria andFamilyGroupsIdIsNotNull() {
            addCriterion("family_groups_id is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyGroupsIdEqualTo(String value) {
            addCriterion("family_groups_id =", value, "familyGroupsId");
            return (Criteria) this;
        }

        public Criteria andFamilyGroupsIdNotEqualTo(String value) {
            addCriterion("family_groups_id <>", value, "familyGroupsId");
            return (Criteria) this;
        }

        public Criteria andFamilyGroupsIdGreaterThan(String value) {
            addCriterion("family_groups_id >", value, "familyGroupsId");
            return (Criteria) this;
        }

        public Criteria andFamilyGroupsIdGreaterThanOrEqualTo(String value) {
            addCriterion("family_groups_id >=", value, "familyGroupsId");
            return (Criteria) this;
        }

        public Criteria andFamilyGroupsIdLessThan(String value) {
            addCriterion("family_groups_id <", value, "familyGroupsId");
            return (Criteria) this;
        }

        public Criteria andFamilyGroupsIdLessThanOrEqualTo(String value) {
            addCriterion("family_groups_id <=", value, "familyGroupsId");
            return (Criteria) this;
        }

        public Criteria andFamilyGroupsIdLike(String value) {
            addCriterion("family_groups_id like", value, "familyGroupsId");
            return (Criteria) this;
        }

        public Criteria andFamilyGroupsIdNotLike(String value) {
            addCriterion("family_groups_id not like", value, "familyGroupsId");
            return (Criteria) this;
        }

        public Criteria andFamilyGroupsIdIn(List<String> values) {
            addCriterion("family_groups_id in", values, "familyGroupsId");
            return (Criteria) this;
        }

        public Criteria andFamilyGroupsIdNotIn(List<String> values) {
            addCriterion("family_groups_id not in", values, "familyGroupsId");
            return (Criteria) this;
        }

        public Criteria andFamilyGroupsIdBetween(String value1, String value2) {
            addCriterion("family_groups_id between", value1, value2, "familyGroupsId");
            return (Criteria) this;
        }

        public Criteria andFamilyGroupsIdNotBetween(String value1, String value2) {
            addCriterion("family_groups_id not between", value1, value2, "familyGroupsId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNull() {
            addCriterion("creator_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNotNull() {
            addCriterion("creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdEqualTo(String value) {
            addCriterion("creator_id =", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotEqualTo(String value) {
            addCriterion("creator_id <>", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThan(String value) {
            addCriterion("creator_id >", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("creator_id >=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThan(String value) {
            addCriterion("creator_id <", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThanOrEqualTo(String value) {
            addCriterion("creator_id <=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLike(String value) {
            addCriterion("creator_id like", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotLike(String value) {
            addCriterion("creator_id not like", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIn(List<String> values) {
            addCriterion("creator_id in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotIn(List<String> values) {
            addCriterion("creator_id not in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdBetween(String value1, String value2) {
            addCriterion("creator_id between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotBetween(String value1, String value2) {
            addCriterion("creator_id not between", value1, value2, "creatorId");
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

        public Criteria andExpireAtIsNull() {
            addCriterion("expire_at is null");
            return (Criteria) this;
        }

        public Criteria andExpireAtIsNotNull() {
            addCriterion("expire_at is not null");
            return (Criteria) this;
        }

        public Criteria andExpireAtEqualTo(Date value) {
            addCriterion("expire_at =", value, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtNotEqualTo(Date value) {
            addCriterion("expire_at <>", value, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtGreaterThan(Date value) {
            addCriterion("expire_at >", value, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtGreaterThanOrEqualTo(Date value) {
            addCriterion("expire_at >=", value, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtLessThan(Date value) {
            addCriterion("expire_at <", value, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtLessThanOrEqualTo(Date value) {
            addCriterion("expire_at <=", value, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtIn(List<Date> values) {
            addCriterion("expire_at in", values, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtNotIn(List<Date> values) {
            addCriterion("expire_at not in", values, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtBetween(Date value1, Date value2) {
            addCriterion("expire_at between", value1, value2, "expireAt");
            return (Criteria) this;
        }

        public Criteria andExpireAtNotBetween(Date value1, Date value2) {
            addCriterion("expire_at not between", value1, value2, "expireAt");
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

        public Criteria andUsedByIsNull() {
            addCriterion("used_by is null");
            return (Criteria) this;
        }

        public Criteria andUsedByIsNotNull() {
            addCriterion("used_by is not null");
            return (Criteria) this;
        }

        public Criteria andUsedByEqualTo(String value) {
            addCriterion("used_by =", value, "usedBy");
            return (Criteria) this;
        }

        public Criteria andUsedByNotEqualTo(String value) {
            addCriterion("used_by <>", value, "usedBy");
            return (Criteria) this;
        }

        public Criteria andUsedByGreaterThan(String value) {
            addCriterion("used_by >", value, "usedBy");
            return (Criteria) this;
        }

        public Criteria andUsedByGreaterThanOrEqualTo(String value) {
            addCriterion("used_by >=", value, "usedBy");
            return (Criteria) this;
        }

        public Criteria andUsedByLessThan(String value) {
            addCriterion("used_by <", value, "usedBy");
            return (Criteria) this;
        }

        public Criteria andUsedByLessThanOrEqualTo(String value) {
            addCriterion("used_by <=", value, "usedBy");
            return (Criteria) this;
        }

        public Criteria andUsedByLike(String value) {
            addCriterion("used_by like", value, "usedBy");
            return (Criteria) this;
        }

        public Criteria andUsedByNotLike(String value) {
            addCriterion("used_by not like", value, "usedBy");
            return (Criteria) this;
        }

        public Criteria andUsedByIn(List<String> values) {
            addCriterion("used_by in", values, "usedBy");
            return (Criteria) this;
        }

        public Criteria andUsedByNotIn(List<String> values) {
            addCriterion("used_by not in", values, "usedBy");
            return (Criteria) this;
        }

        public Criteria andUsedByBetween(String value1, String value2) {
            addCriterion("used_by between", value1, value2, "usedBy");
            return (Criteria) this;
        }

        public Criteria andUsedByNotBetween(String value1, String value2) {
            addCriterion("used_by not between", value1, value2, "usedBy");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNull() {
            addCriterion("signature is null");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNotNull() {
            addCriterion("signature is not null");
            return (Criteria) this;
        }

        public Criteria andSignatureEqualTo(String value) {
            addCriterion("signature =", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotEqualTo(String value) {
            addCriterion("signature <>", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThan(String value) {
            addCriterion("signature >", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("signature >=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThan(String value) {
            addCriterion("signature <", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThanOrEqualTo(String value) {
            addCriterion("signature <=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLike(String value) {
            addCriterion("signature like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotLike(String value) {
            addCriterion("signature not like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureIn(List<String> values) {
            addCriterion("signature in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotIn(List<String> values) {
            addCriterion("signature not in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureBetween(String value1, String value2) {
            addCriterion("signature between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotBetween(String value1, String value2) {
            addCriterion("signature not between", value1, value2, "signature");
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
