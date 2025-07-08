package com.example.catdemo.entity;

import java.util.ArrayList;
import java.util.List;

/**
* 烹饪步骤表 Example
*
* @author zhanhuibin
* @since 2025-06-03 11:15
*/
public class CookingStepsExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CookingStepsExample() {
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

        public Criteria andCookingStepIdIsNull() {
            addCriterion("cooking_step_id is null");
            return (Criteria) this;
        }

        public Criteria andCookingStepIdIsNotNull() {
            addCriterion("cooking_step_id is not null");
            return (Criteria) this;
        }

        public Criteria andCookingStepIdEqualTo(String value) {
            addCriterion("cooking_step_id =", value, "cookingStepId");
            return (Criteria) this;
        }

        public Criteria andCookingStepIdNotEqualTo(String value) {
            addCriterion("cooking_step_id <>", value, "cookingStepId");
            return (Criteria) this;
        }

        public Criteria andCookingStepIdGreaterThan(String value) {
            addCriterion("cooking_step_id >", value, "cookingStepId");
            return (Criteria) this;
        }

        public Criteria andCookingStepIdGreaterThanOrEqualTo(String value) {
            addCriterion("cooking_step_id >=", value, "cookingStepId");
            return (Criteria) this;
        }

        public Criteria andCookingStepIdLessThan(String value) {
            addCriterion("cooking_step_id <", value, "cookingStepId");
            return (Criteria) this;
        }

        public Criteria andCookingStepIdLessThanOrEqualTo(String value) {
            addCriterion("cooking_step_id <=", value, "cookingStepId");
            return (Criteria) this;
        }

        public Criteria andCookingStepIdLike(String value) {
            addCriterion("cooking_step_id like", value, "cookingStepId");
            return (Criteria) this;
        }

        public Criteria andCookingStepIdNotLike(String value) {
            addCriterion("cooking_step_id not like", value, "cookingStepId");
            return (Criteria) this;
        }

        public Criteria andCookingStepIdIn(List<String> values) {
            addCriterion("cooking_step_id in", values, "cookingStepId");
            return (Criteria) this;
        }

        public Criteria andCookingStepIdNotIn(List<String> values) {
            addCriterion("cooking_step_id not in", values, "cookingStepId");
            return (Criteria) this;
        }

        public Criteria andCookingStepIdBetween(String value1, String value2) {
            addCriterion("cooking_step_id between", value1, value2, "cookingStepId");
            return (Criteria) this;
        }

        public Criteria andCookingStepIdNotBetween(String value1, String value2) {
            addCriterion("cooking_step_id not between", value1, value2, "cookingStepId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdIsNull() {
            addCriterion("recipe_id is null");
            return (Criteria) this;
        }

        public Criteria andRecipeIdIsNotNull() {
            addCriterion("recipe_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecipeIdEqualTo(String value) {
            addCriterion("recipe_id =", value, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdNotEqualTo(String value) {
            addCriterion("recipe_id <>", value, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdGreaterThan(String value) {
            addCriterion("recipe_id >", value, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdGreaterThanOrEqualTo(String value) {
            addCriterion("recipe_id >=", value, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdLessThan(String value) {
            addCriterion("recipe_id <", value, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdLessThanOrEqualTo(String value) {
            addCriterion("recipe_id <=", value, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdLike(String value) {
            addCriterion("recipe_id like", value, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdNotLike(String value) {
            addCriterion("recipe_id not like", value, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdIn(List<String> values) {
            addCriterion("recipe_id in", values, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdNotIn(List<String> values) {
            addCriterion("recipe_id not in", values, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdBetween(String value1, String value2) {
            addCriterion("recipe_id between", value1, value2, "recipeId");
            return (Criteria) this;
        }

        public Criteria andRecipeIdNotBetween(String value1, String value2) {
            addCriterion("recipe_id not between", value1, value2, "recipeId");
            return (Criteria) this;
        }

        public Criteria andStepOrderIsNull() {
            addCriterion("step_order is null");
            return (Criteria) this;
        }

        public Criteria andStepOrderIsNotNull() {
            addCriterion("step_order is not null");
            return (Criteria) this;
        }

        public Criteria andStepOrderEqualTo(Integer value) {
            addCriterion("step_order =", value, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderNotEqualTo(Integer value) {
            addCriterion("step_order <>", value, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderGreaterThan(Integer value) {
            addCriterion("step_order >", value, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("step_order >=", value, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderLessThan(Integer value) {
            addCriterion("step_order <", value, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderLessThanOrEqualTo(Integer value) {
            addCriterion("step_order <=", value, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderIn(List<Integer> values) {
            addCriterion("step_order in", values, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderNotIn(List<Integer> values) {
            addCriterion("step_order not in", values, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderBetween(Integer value1, Integer value2) {
            addCriterion("step_order between", value1, value2, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("step_order not between", value1, value2, "stepOrder");
            return (Criteria) this;
        }

        public Criteria andStepImageIsNull() {
            addCriterion("step_image is null");
            return (Criteria) this;
        }

        public Criteria andStepImageIsNotNull() {
            addCriterion("step_image is not null");
            return (Criteria) this;
        }

        public Criteria andStepImageEqualTo(String value) {
            addCriterion("step_image =", value, "stepImage");
            return (Criteria) this;
        }

        public Criteria andStepImageNotEqualTo(String value) {
            addCriterion("step_image <>", value, "stepImage");
            return (Criteria) this;
        }

        public Criteria andStepImageGreaterThan(String value) {
            addCriterion("step_image >", value, "stepImage");
            return (Criteria) this;
        }

        public Criteria andStepImageGreaterThanOrEqualTo(String value) {
            addCriterion("step_image >=", value, "stepImage");
            return (Criteria) this;
        }

        public Criteria andStepImageLessThan(String value) {
            addCriterion("step_image <", value, "stepImage");
            return (Criteria) this;
        }

        public Criteria andStepImageLessThanOrEqualTo(String value) {
            addCriterion("step_image <=", value, "stepImage");
            return (Criteria) this;
        }

        public Criteria andStepImageLike(String value) {
            addCriterion("step_image like", value, "stepImage");
            return (Criteria) this;
        }

        public Criteria andStepImageNotLike(String value) {
            addCriterion("step_image not like", value, "stepImage");
            return (Criteria) this;
        }

        public Criteria andStepImageIn(List<String> values) {
            addCriterion("step_image in", values, "stepImage");
            return (Criteria) this;
        }

        public Criteria andStepImageNotIn(List<String> values) {
            addCriterion("step_image not in", values, "stepImage");
            return (Criteria) this;
        }

        public Criteria andStepImageBetween(String value1, String value2) {
            addCriterion("step_image between", value1, value2, "stepImage");
            return (Criteria) this;
        }

        public Criteria andStepImageNotBetween(String value1, String value2) {
            addCriterion("step_image not between", value1, value2, "stepImage");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeIsNull() {
            addCriterion("estimated_time is null");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeIsNotNull() {
            addCriterion("estimated_time is not null");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeEqualTo(Integer value) {
            addCriterion("estimated_time =", value, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeNotEqualTo(Integer value) {
            addCriterion("estimated_time <>", value, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeGreaterThan(Integer value) {
            addCriterion("estimated_time >", value, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("estimated_time >=", value, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeLessThan(Integer value) {
            addCriterion("estimated_time <", value, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeLessThanOrEqualTo(Integer value) {
            addCriterion("estimated_time <=", value, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeIn(List<Integer> values) {
            addCriterion("estimated_time in", values, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeNotIn(List<Integer> values) {
            addCriterion("estimated_time not in", values, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeBetween(Integer value1, Integer value2) {
            addCriterion("estimated_time between", value1, value2, "estimatedTime");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("estimated_time not between", value1, value2, "estimatedTime");
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
