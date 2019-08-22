package edu.qust.market.bean;

import java.util.ArrayList;
import java.util.List;

public class StuffExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public StuffExample() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setPageSize(int pageSize) {
        this.pageSize=pageSize;
    }

    public int getPageSize() {
        return pageSize;
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

        public Criteria andStuffIdIsNull() {
            addCriterion("STUFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andStuffIdIsNotNull() {
            addCriterion("STUFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStuffIdEqualTo(Long value) {
            addCriterion("STUFF_ID =", value, "stuffId");
            return (Criteria) this;
        }

        public Criteria andStuffIdNotEqualTo(Long value) {
            addCriterion("STUFF_ID <>", value, "stuffId");
            return (Criteria) this;
        }

        public Criteria andStuffIdGreaterThan(Long value) {
            addCriterion("STUFF_ID >", value, "stuffId");
            return (Criteria) this;
        }

        public Criteria andStuffIdGreaterThanOrEqualTo(Long value) {
            addCriterion("STUFF_ID >=", value, "stuffId");
            return (Criteria) this;
        }

        public Criteria andStuffIdLessThan(Long value) {
            addCriterion("STUFF_ID <", value, "stuffId");
            return (Criteria) this;
        }

        public Criteria andStuffIdLessThanOrEqualTo(Long value) {
            addCriterion("STUFF_ID <=", value, "stuffId");
            return (Criteria) this;
        }

        public Criteria andStuffIdIn(List<Long> values) {
            addCriterion("STUFF_ID in", values, "stuffId");
            return (Criteria) this;
        }

        public Criteria andStuffIdNotIn(List<Long> values) {
            addCriterion("STUFF_ID not in", values, "stuffId");
            return (Criteria) this;
        }

        public Criteria andStuffIdBetween(Long value1, Long value2) {
            addCriterion("STUFF_ID between", value1, value2, "stuffId");
            return (Criteria) this;
        }

        public Criteria andStuffIdNotBetween(Long value1, Long value2) {
            addCriterion("STUFF_ID not between", value1, value2, "stuffId");
            return (Criteria) this;
        }

        public Criteria andStuffNameIsNull() {
            addCriterion("STUFF_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStuffNameIsNotNull() {
            addCriterion("STUFF_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStuffNameEqualTo(String value) {
            addCriterion("STUFF_NAME =", value, "stuffName");
            return (Criteria) this;
        }

        public Criteria andStuffNameNotEqualTo(String value) {
            addCriterion("STUFF_NAME <>", value, "stuffName");
            return (Criteria) this;
        }

        public Criteria andStuffNameGreaterThan(String value) {
            addCriterion("STUFF_NAME >", value, "stuffName");
            return (Criteria) this;
        }

        public Criteria andStuffNameGreaterThanOrEqualTo(String value) {
            addCriterion("STUFF_NAME >=", value, "stuffName");
            return (Criteria) this;
        }

        public Criteria andStuffNameLessThan(String value) {
            addCriterion("STUFF_NAME <", value, "stuffName");
            return (Criteria) this;
        }

        public Criteria andStuffNameLessThanOrEqualTo(String value) {
            addCriterion("STUFF_NAME <=", value, "stuffName");
            return (Criteria) this;
        }

        public Criteria andStuffNameLike(String value) {
            addCriterion("STUFF_NAME like", value, "stuffName");
            return (Criteria) this;
        }

        public Criteria andStuffNameNotLike(String value) {
            addCriterion("STUFF_NAME not like", value, "stuffName");
            return (Criteria) this;
        }

        public Criteria andStuffNameIn(List<String> values) {
            addCriterion("STUFF_NAME in", values, "stuffName");
            return (Criteria) this;
        }

        public Criteria andStuffNameNotIn(List<String> values) {
            addCriterion("STUFF_NAME not in", values, "stuffName");
            return (Criteria) this;
        }

        public Criteria andStuffNameBetween(String value1, String value2) {
            addCriterion("STUFF_NAME between", value1, value2, "stuffName");
            return (Criteria) this;
        }

        public Criteria andStuffNameNotBetween(String value1, String value2) {
            addCriterion("STUFF_NAME not between", value1, value2, "stuffName");
            return (Criteria) this;
        }

        public Criteria andStuffInfoIsNull() {
            addCriterion("STUFF_INFO is null");
            return (Criteria) this;
        }

        public Criteria andStuffInfoIsNotNull() {
            addCriterion("STUFF_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andStuffInfoEqualTo(String value) {
            addCriterion("STUFF_INFO =", value, "stuffInfo");
            return (Criteria) this;
        }

        public Criteria andStuffInfoNotEqualTo(String value) {
            addCriterion("STUFF_INFO <>", value, "stuffInfo");
            return (Criteria) this;
        }

        public Criteria andStuffInfoGreaterThan(String value) {
            addCriterion("STUFF_INFO >", value, "stuffInfo");
            return (Criteria) this;
        }

        public Criteria andStuffInfoGreaterThanOrEqualTo(String value) {
            addCriterion("STUFF_INFO >=", value, "stuffInfo");
            return (Criteria) this;
        }

        public Criteria andStuffInfoLessThan(String value) {
            addCriterion("STUFF_INFO <", value, "stuffInfo");
            return (Criteria) this;
        }

        public Criteria andStuffInfoLessThanOrEqualTo(String value) {
            addCriterion("STUFF_INFO <=", value, "stuffInfo");
            return (Criteria) this;
        }

        public Criteria andStuffInfoLike(String value) {
            addCriterion("STUFF_INFO like", value, "stuffInfo");
            return (Criteria) this;
        }

        public Criteria andStuffInfoNotLike(String value) {
            addCriterion("STUFF_INFO not like", value, "stuffInfo");
            return (Criteria) this;
        }

        public Criteria andStuffInfoIn(List<String> values) {
            addCriterion("STUFF_INFO in", values, "stuffInfo");
            return (Criteria) this;
        }

        public Criteria andStuffInfoNotIn(List<String> values) {
            addCriterion("STUFF_INFO not in", values, "stuffInfo");
            return (Criteria) this;
        }

        public Criteria andStuffInfoBetween(String value1, String value2) {
            addCriterion("STUFF_INFO between", value1, value2, "stuffInfo");
            return (Criteria) this;
        }

        public Criteria andStuffInfoNotBetween(String value1, String value2) {
            addCriterion("STUFF_INFO not between", value1, value2, "stuffInfo");
            return (Criteria) this;
        }

        public Criteria andStuffPriceIsNull() {
            addCriterion("STUFF_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andStuffPriceIsNotNull() {
            addCriterion("STUFF_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andStuffPriceEqualTo(Double value) {
            addCriterion("STUFF_PRICE =", value, "stuffPrice");
            return (Criteria) this;
        }

        public Criteria andStuffPriceNotEqualTo(Double value) {
            addCriterion("STUFF_PRICE <>", value, "stuffPrice");
            return (Criteria) this;
        }

        public Criteria andStuffPriceGreaterThan(Double value) {
            addCriterion("STUFF_PRICE >", value, "stuffPrice");
            return (Criteria) this;
        }

        public Criteria andStuffPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("STUFF_PRICE >=", value, "stuffPrice");
            return (Criteria) this;
        }

        public Criteria andStuffPriceLessThan(Double value) {
            addCriterion("STUFF_PRICE <", value, "stuffPrice");
            return (Criteria) this;
        }

        public Criteria andStuffPriceLessThanOrEqualTo(Double value) {
            addCriterion("STUFF_PRICE <=", value, "stuffPrice");
            return (Criteria) this;
        }

        public Criteria andStuffPriceIn(List<Double> values) {
            addCriterion("STUFF_PRICE in", values, "stuffPrice");
            return (Criteria) this;
        }

        public Criteria andStuffPriceNotIn(List<Double> values) {
            addCriterion("STUFF_PRICE not in", values, "stuffPrice");
            return (Criteria) this;
        }

        public Criteria andStuffPriceBetween(Double value1, Double value2) {
            addCriterion("STUFF_PRICE between", value1, value2, "stuffPrice");
            return (Criteria) this;
        }

        public Criteria andStuffPriceNotBetween(Double value1, Double value2) {
            addCriterion("STUFF_PRICE not between", value1, value2, "stuffPrice");
            return (Criteria) this;
        }

        public Criteria andStuffActiveIsNull() {
            addCriterion("STUFF_ACTIVE is null");
            return (Criteria) this;
        }

        public Criteria andStuffActiveIsNotNull() {
            addCriterion("STUFF_ACTIVE is not null");
            return (Criteria) this;
        }

        public Criteria andStuffActiveEqualTo(Integer value) {
            addCriterion("STUFF_ACTIVE =", value, "stuffActive");
            return (Criteria) this;
        }

        public Criteria andStuffActiveNotEqualTo(Integer value) {
            addCriterion("STUFF_ACTIVE <>", value, "stuffActive");
            return (Criteria) this;
        }

        public Criteria andStuffActiveGreaterThan(Integer value) {
            addCriterion("STUFF_ACTIVE >", value, "stuffActive");
            return (Criteria) this;
        }

        public Criteria andStuffActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("STUFF_ACTIVE >=", value, "stuffActive");
            return (Criteria) this;
        }

        public Criteria andStuffActiveLessThan(Integer value) {
            addCriterion("STUFF_ACTIVE <", value, "stuffActive");
            return (Criteria) this;
        }

        public Criteria andStuffActiveLessThanOrEqualTo(Integer value) {
            addCriterion("STUFF_ACTIVE <=", value, "stuffActive");
            return (Criteria) this;
        }

        public Criteria andStuffActiveIn(List<Integer> values) {
            addCriterion("STUFF_ACTIVE in", values, "stuffActive");
            return (Criteria) this;
        }

        public Criteria andStuffActiveNotIn(List<Integer> values) {
            addCriterion("STUFF_ACTIVE not in", values, "stuffActive");
            return (Criteria) this;
        }

        public Criteria andStuffActiveBetween(Integer value1, Integer value2) {
            addCriterion("STUFF_ACTIVE between", value1, value2, "stuffActive");
            return (Criteria) this;
        }

        public Criteria andStuffActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("STUFF_ACTIVE not between", value1, value2, "stuffActive");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNull() {
            addCriterion("CATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNotNull() {
            addCriterion("CATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCateIdEqualTo(Long value) {
            addCriterion("CATE_ID =", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotEqualTo(Long value) {
            addCriterion("CATE_ID <>", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThan(Long value) {
            addCriterion("CATE_ID >", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CATE_ID >=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThan(Long value) {
            addCriterion("CATE_ID <", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThanOrEqualTo(Long value) {
            addCriterion("CATE_ID <=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdIn(List<Long> values) {
            addCriterion("CATE_ID in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotIn(List<Long> values) {
            addCriterion("CATE_ID not in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdBetween(Long value1, Long value2) {
            addCriterion("CATE_ID between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotBetween(Long value1, Long value2) {
            addCriterion("CATE_ID not between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("MODIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("MODIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Long value) {
            addCriterion("MODIFY_TIME =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Long value) {
            addCriterion("MODIFY_TIME <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Long value) {
            addCriterion("MODIFY_TIME >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("MODIFY_TIME >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Long value) {
            addCriterion("MODIFY_TIME <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Long value) {
            addCriterion("MODIFY_TIME <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Long> values) {
            addCriterion("MODIFY_TIME in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Long> values) {
            addCriterion("MODIFY_TIME not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Long value1, Long value2) {
            addCriterion("MODIFY_TIME between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Long value1, Long value2) {
            addCriterion("MODIFY_TIME not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andPageViewIsNull() {
            addCriterion("page_view is null");
            return (Criteria) this;
        }

        public Criteria andPageViewIsNotNull() {
            addCriterion("page_view is not null");
            return (Criteria) this;
        }

        public Criteria andPageViewEqualTo(Integer value) {
            addCriterion("page_view =", value, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewNotEqualTo(Integer value) {
            addCriterion("page_view <>", value, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewGreaterThan(Integer value) {
            addCriterion("page_view >", value, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewGreaterThanOrEqualTo(Integer value) {
            addCriterion("page_view >=", value, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewLessThan(Integer value) {
            addCriterion("page_view <", value, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewLessThanOrEqualTo(Integer value) {
            addCriterion("page_view <=", value, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewIn(List<Integer> values) {
            addCriterion("page_view in", values, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewNotIn(List<Integer> values) {
            addCriterion("page_view not in", values, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewBetween(Integer value1, Integer value2) {
            addCriterion("page_view between", value1, value2, "pageView");
            return (Criteria) this;
        }

        public Criteria andPageViewNotBetween(Integer value1, Integer value2) {
            addCriterion("page_view not between", value1, value2, "pageView");
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