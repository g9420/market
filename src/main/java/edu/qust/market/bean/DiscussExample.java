package edu.qust.market.bean;

import java.util.ArrayList;
import java.util.List;

public class DiscussExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int pageSize = -1;

    public DiscussExample() {
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

        public Criteria andDiscussIdIsNull() {
            addCriterion("DISCUSS_ID is null");
            return (Criteria) this;
        }

        public Criteria andDiscussIdIsNotNull() {
            addCriterion("DISCUSS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDiscussIdEqualTo(Long value) {
            addCriterion("DISCUSS_ID =", value, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdNotEqualTo(Long value) {
            addCriterion("DISCUSS_ID <>", value, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdGreaterThan(Long value) {
            addCriterion("DISCUSS_ID >", value, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DISCUSS_ID >=", value, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdLessThan(Long value) {
            addCriterion("DISCUSS_ID <", value, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdLessThanOrEqualTo(Long value) {
            addCriterion("DISCUSS_ID <=", value, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdIn(List<Long> values) {
            addCriterion("DISCUSS_ID in", values, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdNotIn(List<Long> values) {
            addCriterion("DISCUSS_ID not in", values, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdBetween(Long value1, Long value2) {
            addCriterion("DISCUSS_ID between", value1, value2, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussIdNotBetween(Long value1, Long value2) {
            addCriterion("DISCUSS_ID not between", value1, value2, "discussId");
            return (Criteria) this;
        }

        public Criteria andDiscussDescIsNull() {
            addCriterion("DISCUSS_DESC is null");
            return (Criteria) this;
        }

        public Criteria andDiscussDescIsNotNull() {
            addCriterion("DISCUSS_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andDiscussDescEqualTo(String value) {
            addCriterion("DISCUSS_DESC =", value, "discussDesc");
            return (Criteria) this;
        }

        public Criteria andDiscussDescNotEqualTo(String value) {
            addCriterion("DISCUSS_DESC <>", value, "discussDesc");
            return (Criteria) this;
        }

        public Criteria andDiscussDescGreaterThan(String value) {
            addCriterion("DISCUSS_DESC >", value, "discussDesc");
            return (Criteria) this;
        }

        public Criteria andDiscussDescGreaterThanOrEqualTo(String value) {
            addCriterion("DISCUSS_DESC >=", value, "discussDesc");
            return (Criteria) this;
        }

        public Criteria andDiscussDescLessThan(String value) {
            addCriterion("DISCUSS_DESC <", value, "discussDesc");
            return (Criteria) this;
        }

        public Criteria andDiscussDescLessThanOrEqualTo(String value) {
            addCriterion("DISCUSS_DESC <=", value, "discussDesc");
            return (Criteria) this;
        }

        public Criteria andDiscussDescLike(String value) {
            addCriterion("DISCUSS_DESC like", value, "discussDesc");
            return (Criteria) this;
        }

        public Criteria andDiscussDescNotLike(String value) {
            addCriterion("DISCUSS_DESC not like", value, "discussDesc");
            return (Criteria) this;
        }

        public Criteria andDiscussDescIn(List<String> values) {
            addCriterion("DISCUSS_DESC in", values, "discussDesc");
            return (Criteria) this;
        }

        public Criteria andDiscussDescNotIn(List<String> values) {
            addCriterion("DISCUSS_DESC not in", values, "discussDesc");
            return (Criteria) this;
        }

        public Criteria andDiscussDescBetween(String value1, String value2) {
            addCriterion("DISCUSS_DESC between", value1, value2, "discussDesc");
            return (Criteria) this;
        }

        public Criteria andDiscussDescNotBetween(String value1, String value2) {
            addCriterion("DISCUSS_DESC not between", value1, value2, "discussDesc");
            return (Criteria) this;
        }

        public Criteria andDiscussTimeIsNull() {
            addCriterion("DISCUSS_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDiscussTimeIsNotNull() {
            addCriterion("DISCUSS_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDiscussTimeEqualTo(Long value) {
            addCriterion("DISCUSS_TIME =", value, "discussTime");
            return (Criteria) this;
        }

        public Criteria andDiscussTimeNotEqualTo(Long value) {
            addCriterion("DISCUSS_TIME <>", value, "discussTime");
            return (Criteria) this;
        }

        public Criteria andDiscussTimeGreaterThan(Long value) {
            addCriterion("DISCUSS_TIME >", value, "discussTime");
            return (Criteria) this;
        }

        public Criteria andDiscussTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("DISCUSS_TIME >=", value, "discussTime");
            return (Criteria) this;
        }

        public Criteria andDiscussTimeLessThan(Long value) {
            addCriterion("DISCUSS_TIME <", value, "discussTime");
            return (Criteria) this;
        }

        public Criteria andDiscussTimeLessThanOrEqualTo(Long value) {
            addCriterion("DISCUSS_TIME <=", value, "discussTime");
            return (Criteria) this;
        }

        public Criteria andDiscussTimeIn(List<Long> values) {
            addCriterion("DISCUSS_TIME in", values, "discussTime");
            return (Criteria) this;
        }

        public Criteria andDiscussTimeNotIn(List<Long> values) {
            addCriterion("DISCUSS_TIME not in", values, "discussTime");
            return (Criteria) this;
        }

        public Criteria andDiscussTimeBetween(Long value1, Long value2) {
            addCriterion("DISCUSS_TIME between", value1, value2, "discussTime");
            return (Criteria) this;
        }

        public Criteria andDiscussTimeNotBetween(Long value1, Long value2) {
            addCriterion("DISCUSS_TIME not between", value1, value2, "discussTime");
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

        public Criteria andReceiveDiscussIdIsNull() {
            addCriterion("receive_discuss_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiveDiscussIdIsNotNull() {
            addCriterion("receive_discuss_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveDiscussIdEqualTo(Integer value) {
            addCriterion("receive_discuss_id =", value, "receiveDiscussId");
            return (Criteria) this;
        }

        public Criteria andReceiveDiscussIdNotEqualTo(Integer value) {
            addCriterion("receive_discuss_id <>", value, "receiveDiscussId");
            return (Criteria) this;
        }

        public Criteria andReceiveDiscussIdGreaterThan(Integer value) {
            addCriterion("receive_discuss_id >", value, "receiveDiscussId");
            return (Criteria) this;
        }

        public Criteria andReceiveDiscussIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("receive_discuss_id >=", value, "receiveDiscussId");
            return (Criteria) this;
        }

        public Criteria andReceiveDiscussIdLessThan(Integer value) {
            addCriterion("receive_discuss_id <", value, "receiveDiscussId");
            return (Criteria) this;
        }

        public Criteria andReceiveDiscussIdLessThanOrEqualTo(Integer value) {
            addCriterion("receive_discuss_id <=", value, "receiveDiscussId");
            return (Criteria) this;
        }

        public Criteria andReceiveDiscussIdIn(List<Integer> values) {
            addCriterion("receive_discuss_id in", values, "receiveDiscussId");
            return (Criteria) this;
        }

        public Criteria andReceiveDiscussIdNotIn(List<Integer> values) {
            addCriterion("receive_discuss_id not in", values, "receiveDiscussId");
            return (Criteria) this;
        }

        public Criteria andReceiveDiscussIdBetween(Integer value1, Integer value2) {
            addCriterion("receive_discuss_id between", value1, value2, "receiveDiscussId");
            return (Criteria) this;
        }

        public Criteria andReceiveDiscussIdNotBetween(Integer value1, Integer value2) {
            addCriterion("receive_discuss_id not between", value1, value2, "receiveDiscussId");
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