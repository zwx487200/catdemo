package com.example.catdemo.entity;

import java.util.ArrayList;
import java.util.List;

/**
* 属性表 Example
*
* @author zhanhuibin
* @since 2025-05-10 14:50
*/
public class AttributeExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttributeExample() {
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

        public Criteria andAttributeKeyIsNull() {
            addCriterion("attribute_key is null");
            return (Criteria) this;
        }

        public Criteria andAttributeKeyIsNotNull() {
            addCriterion("attribute_key is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeKeyEqualTo(String value) {
            addCriterion("attribute_key =", value, "attributeKey");
            return (Criteria) this;
        }

        public Criteria andAttributeKeyNotEqualTo(String value) {
            addCriterion("attribute_key <>", value, "attributeKey");
            return (Criteria) this;
        }

        public Criteria andAttributeKeyGreaterThan(String value) {
            addCriterion("attribute_key >", value, "attributeKey");
            return (Criteria) this;
        }

        public Criteria andAttributeKeyGreaterThanOrEqualTo(String value) {
            addCriterion("attribute_key >=", value, "attributeKey");
            return (Criteria) this;
        }

        public Criteria andAttributeKeyLessThan(String value) {
            addCriterion("attribute_key <", value, "attributeKey");
            return (Criteria) this;
        }

        public Criteria andAttributeKeyLessThanOrEqualTo(String value) {
            addCriterion("attribute_key <=", value, "attributeKey");
            return (Criteria) this;
        }

        public Criteria andAttributeKeyLike(String value) {
            addCriterion("attribute_key like", value, "attributeKey");
            return (Criteria) this;
        }

        public Criteria andAttributeKeyNotLike(String value) {
            addCriterion("attribute_key not like", value, "attributeKey");
            return (Criteria) this;
        }

        public Criteria andAttributeKeyIn(List<String> values) {
            addCriterion("attribute_key in", values, "attributeKey");
            return (Criteria) this;
        }

        public Criteria andAttributeKeyNotIn(List<String> values) {
            addCriterion("attribute_key not in", values, "attributeKey");
            return (Criteria) this;
        }

        public Criteria andAttributeKeyBetween(String value1, String value2) {
            addCriterion("attribute_key between", value1, value2, "attributeKey");
            return (Criteria) this;
        }

        public Criteria andAttributeKeyNotBetween(String value1, String value2) {
            addCriterion("attribute_key not between", value1, value2, "attributeKey");
            return (Criteria) this;
        }

        public Criteria andAttributeValueIsNull() {
            addCriterion("attribute_value is null");
            return (Criteria) this;
        }

        public Criteria andAttributeValueIsNotNull() {
            addCriterion("attribute_value is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeValueEqualTo(String value) {
            addCriterion("attribute_value =", value, "attributeValue");
            return (Criteria) this;
        }

        public Criteria andAttributeValueNotEqualTo(String value) {
            addCriterion("attribute_value <>", value, "attributeValue");
            return (Criteria) this;
        }

        public Criteria andAttributeValueGreaterThan(String value) {
            addCriterion("attribute_value >", value, "attributeValue");
            return (Criteria) this;
        }

        public Criteria andAttributeValueGreaterThanOrEqualTo(String value) {
            addCriterion("attribute_value >=", value, "attributeValue");
            return (Criteria) this;
        }

        public Criteria andAttributeValueLessThan(String value) {
            addCriterion("attribute_value <", value, "attributeValue");
            return (Criteria) this;
        }

        public Criteria andAttributeValueLessThanOrEqualTo(String value) {
            addCriterion("attribute_value <=", value, "attributeValue");
            return (Criteria) this;
        }

        public Criteria andAttributeValueLike(String value) {
            addCriterion("attribute_value like", value, "attributeValue");
            return (Criteria) this;
        }

        public Criteria andAttributeValueNotLike(String value) {
            addCriterion("attribute_value not like", value, "attributeValue");
            return (Criteria) this;
        }

        public Criteria andAttributeValueIn(List<String> values) {
            addCriterion("attribute_value in", values, "attributeValue");
            return (Criteria) this;
        }

        public Criteria andAttributeValueNotIn(List<String> values) {
            addCriterion("attribute_value not in", values, "attributeValue");
            return (Criteria) this;
        }

        public Criteria andAttributeValueBetween(String value1, String value2) {
            addCriterion("attribute_value between", value1, value2, "attributeValue");
            return (Criteria) this;
        }

        public Criteria andAttributeValueNotBetween(String value1, String value2) {
            addCriterion("attribute_value not between", value1, value2, "attributeValue");
            return (Criteria) this;
        }

        public Criteria andFatherAttributeIdIsNull() {
            addCriterion("father_attribute_id is null");
            return (Criteria) this;
        }

        public Criteria andFatherAttributeIdIsNotNull() {
            addCriterion("father_attribute_id is not null");
            return (Criteria) this;
        }

        public Criteria andFatherAttributeIdEqualTo(String value) {
            addCriterion("father_attribute_id =", value, "fatherAttributeId");
            return (Criteria) this;
        }

        public Criteria andFatherAttributeIdNotEqualTo(String value) {
            addCriterion("father_attribute_id <>", value, "fatherAttributeId");
            return (Criteria) this;
        }

        public Criteria andFatherAttributeIdGreaterThan(String value) {
            addCriterion("father_attribute_id >", value, "fatherAttributeId");
            return (Criteria) this;
        }

        public Criteria andFatherAttributeIdGreaterThanOrEqualTo(String value) {
            addCriterion("father_attribute_id >=", value, "fatherAttributeId");
            return (Criteria) this;
        }

        public Criteria andFatherAttributeIdLessThan(String value) {
            addCriterion("father_attribute_id <", value, "fatherAttributeId");
            return (Criteria) this;
        }

        public Criteria andFatherAttributeIdLessThanOrEqualTo(String value) {
            addCriterion("father_attribute_id <=", value, "fatherAttributeId");
            return (Criteria) this;
        }

        public Criteria andFatherAttributeIdLike(String value) {
            addCriterion("father_attribute_id like", value, "fatherAttributeId");
            return (Criteria) this;
        }

        public Criteria andFatherAttributeIdNotLike(String value) {
            addCriterion("father_attribute_id not like", value, "fatherAttributeId");
            return (Criteria) this;
        }

        public Criteria andFatherAttributeIdIn(List<String> values) {
            addCriterion("father_attribute_id in", values, "fatherAttributeId");
            return (Criteria) this;
        }

        public Criteria andFatherAttributeIdNotIn(List<String> values) {
            addCriterion("father_attribute_id not in", values, "fatherAttributeId");
            return (Criteria) this;
        }

        public Criteria andFatherAttributeIdBetween(String value1, String value2) {
            addCriterion("father_attribute_id between", value1, value2, "fatherAttributeId");
            return (Criteria) this;
        }

        public Criteria andFatherAttributeIdNotBetween(String value1, String value2) {
            addCriterion("father_attribute_id not between", value1, value2, "fatherAttributeId");
            return (Criteria) this;
        }

        public Criteria andAttributeTypeIsNull() {
            addCriterion("attribute_type is null");
            return (Criteria) this;
        }

        public Criteria andAttributeTypeIsNotNull() {
            addCriterion("attribute_type is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeTypeEqualTo(String value) {
            addCriterion("attribute_type =", value, "attributeType");
            return (Criteria) this;
        }

        public Criteria andAttributeTypeNotEqualTo(String value) {
            addCriterion("attribute_type <>", value, "attributeType");
            return (Criteria) this;
        }

        public Criteria andAttributeTypeGreaterThan(String value) {
            addCriterion("attribute_type >", value, "attributeType");
            return (Criteria) this;
        }

        public Criteria andAttributeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("attribute_type >=", value, "attributeType");
            return (Criteria) this;
        }

        public Criteria andAttributeTypeLessThan(String value) {
            addCriterion("attribute_type <", value, "attributeType");
            return (Criteria) this;
        }

        public Criteria andAttributeTypeLessThanOrEqualTo(String value) {
            addCriterion("attribute_type <=", value, "attributeType");
            return (Criteria) this;
        }

        public Criteria andAttributeTypeLike(String value) {
            addCriterion("attribute_type like", value, "attributeType");
            return (Criteria) this;
        }

        public Criteria andAttributeTypeNotLike(String value) {
            addCriterion("attribute_type not like", value, "attributeType");
            return (Criteria) this;
        }

        public Criteria andAttributeTypeIn(List<String> values) {
            addCriterion("attribute_type in", values, "attributeType");
            return (Criteria) this;
        }

        public Criteria andAttributeTypeNotIn(List<String> values) {
            addCriterion("attribute_type not in", values, "attributeType");
            return (Criteria) this;
        }

        public Criteria andAttributeTypeBetween(String value1, String value2) {
            addCriterion("attribute_type between", value1, value2, "attributeType");
            return (Criteria) this;
        }

        public Criteria andAttributeTypeNotBetween(String value1, String value2) {
            addCriterion("attribute_type not between", value1, value2, "attributeType");
            return (Criteria) this;
        }

        public Criteria andIsCustomIsNull() {
            addCriterion("is_custom is null");
            return (Criteria) this;
        }

        public Criteria andIsCustomIsNotNull() {
            addCriterion("is_custom is not null");
            return (Criteria) this;
        }

        public Criteria andIsCustomEqualTo(Integer value) {
            addCriterion("is_custom =", value, "isCustom");
            return (Criteria) this;
        }

        public Criteria andIsCustomNotEqualTo(Integer value) {
            addCriterion("is_custom <>", value, "isCustom");
            return (Criteria) this;
        }

        public Criteria andIsCustomGreaterThan(Integer value) {
            addCriterion("is_custom >", value, "isCustom");
            return (Criteria) this;
        }

        public Criteria andIsCustomGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_custom >=", value, "isCustom");
            return (Criteria) this;
        }

        public Criteria andIsCustomLessThan(Integer value) {
            addCriterion("is_custom <", value, "isCustom");
            return (Criteria) this;
        }

        public Criteria andIsCustomLessThanOrEqualTo(Integer value) {
            addCriterion("is_custom <=", value, "isCustom");
            return (Criteria) this;
        }

        public Criteria andIsCustomIn(List<Integer> values) {
            addCriterion("is_custom in", values, "isCustom");
            return (Criteria) this;
        }

        public Criteria andIsCustomNotIn(List<Integer> values) {
            addCriterion("is_custom not in", values, "isCustom");
            return (Criteria) this;
        }

        public Criteria andIsCustomBetween(Integer value1, Integer value2) {
            addCriterion("is_custom between", value1, value2, "isCustom");
            return (Criteria) this;
        }

        public Criteria andIsCustomNotBetween(Integer value1, Integer value2) {
            addCriterion("is_custom not between", value1, value2, "isCustom");
            return (Criteria) this;
        }

        public Criteria andFamilyIdIsNull() {
            addCriterion("family_id is null");
            return (Criteria) this;
        }

        public Criteria andFamilyIdIsNotNull() {
            addCriterion("family_id is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyIdEqualTo(String value) {
            addCriterion("family_id =", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdNotEqualTo(String value) {
            addCriterion("family_id <>", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdGreaterThan(String value) {
            addCriterion("family_id >", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdGreaterThanOrEqualTo(String value) {
            addCriterion("family_id >=", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdLessThan(String value) {
            addCriterion("family_id <", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdLessThanOrEqualTo(String value) {
            addCriterion("family_id <=", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdLike(String value) {
            addCriterion("family_id like", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdNotLike(String value) {
            addCriterion("family_id not like", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdIn(List<String> values) {
            addCriterion("family_id in", values, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdNotIn(List<String> values) {
            addCriterion("family_id not in", values, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdBetween(String value1, String value2) {
            addCriterion("family_id between", value1, value2, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdNotBetween(String value1, String value2) {
            addCriterion("family_id not between", value1, value2, "familyId");
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
