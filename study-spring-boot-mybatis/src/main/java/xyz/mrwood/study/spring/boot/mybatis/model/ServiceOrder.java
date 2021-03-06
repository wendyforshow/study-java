package xyz.mrwood.study.spring.boot.mybatis.model;

import java.math.BigDecimal;
import java.util.Date;

public class ServiceOrder {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carlife_service_orders.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carlife_service_orders.parking_id
     *
     * @mbggenerated
     */
    private String parkingId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carlife_service_orders.in_time
     *
     * @mbggenerated
     */
    private Date inTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carlife_service_orders.out_time
     *
     * @mbggenerated
     */
    private Date outTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carlife_service_orders.pay_time
     *
     * @mbggenerated
     */
    private Date payTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carlife_service_orders.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carlife_service_orders.uid
     *
     * @mbggenerated
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carlife_service_orders.card_number
     *
     * @mbggenerated
     */
    private String cardNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carlife_service_orders.order_id
     *
     * @mbggenerated
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carlife_service_orders.money
     *
     * @mbggenerated
     */
    private BigDecimal money;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carlife_service_orders.limit_leave_time
     *
     * @mbggenerated
     */
    private String limitLeaveTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carlife_service_orders.limit_pay_time
     *
     * @mbggenerated
     */
    private String limitPayTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carlife_service_orders.gmt_modified
     *
     * @mbggenerated
     */
    private Date gmtModified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column carlife_service_orders.gmt_create
     *
     * @mbggenerated
     */
    private Date gmtCreate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carlife_service_orders.id
     *
     * @return the value of carlife_service_orders.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carlife_service_orders.id
     *
     * @param id the value for carlife_service_orders.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carlife_service_orders.parking_id
     *
     * @return the value of carlife_service_orders.parking_id
     *
     * @mbggenerated
     */
    public String getParkingId() {
        return parkingId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carlife_service_orders.parking_id
     *
     * @param parkingId the value for carlife_service_orders.parking_id
     *
     * @mbggenerated
     */
    public void setParkingId(String parkingId) {
        this.parkingId = parkingId == null ? null : parkingId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carlife_service_orders.in_time
     *
     * @return the value of carlife_service_orders.in_time
     *
     * @mbggenerated
     */
    public Date getInTime() {
        return inTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carlife_service_orders.in_time
     *
     * @param inTime the value for carlife_service_orders.in_time
     *
     * @mbggenerated
     */
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carlife_service_orders.out_time
     *
     * @return the value of carlife_service_orders.out_time
     *
     * @mbggenerated
     */
    public Date getOutTime() {
        return outTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carlife_service_orders.out_time
     *
     * @param outTime the value for carlife_service_orders.out_time
     *
     * @mbggenerated
     */
    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carlife_service_orders.pay_time
     *
     * @return the value of carlife_service_orders.pay_time
     *
     * @mbggenerated
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carlife_service_orders.pay_time
     *
     * @param payTime the value for carlife_service_orders.pay_time
     *
     * @mbggenerated
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carlife_service_orders.status
     *
     * @return the value of carlife_service_orders.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carlife_service_orders.status
     *
     * @param status the value for carlife_service_orders.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carlife_service_orders.uid
     *
     * @return the value of carlife_service_orders.uid
     *
     * @mbggenerated
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carlife_service_orders.uid
     *
     * @param uid the value for carlife_service_orders.uid
     *
     * @mbggenerated
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carlife_service_orders.card_number
     *
     * @return the value of carlife_service_orders.card_number
     *
     * @mbggenerated
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carlife_service_orders.card_number
     *
     * @param cardNumber the value for carlife_service_orders.card_number
     *
     * @mbggenerated
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carlife_service_orders.order_id
     *
     * @return the value of carlife_service_orders.order_id
     *
     * @mbggenerated
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carlife_service_orders.order_id
     *
     * @param orderId the value for carlife_service_orders.order_id
     *
     * @mbggenerated
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carlife_service_orders.money
     *
     * @return the value of carlife_service_orders.money
     *
     * @mbggenerated
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carlife_service_orders.money
     *
     * @param money the value for carlife_service_orders.money
     *
     * @mbggenerated
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carlife_service_orders.limit_leave_time
     *
     * @return the value of carlife_service_orders.limit_leave_time
     *
     * @mbggenerated
     */
    public String getLimitLeaveTime() {
        return limitLeaveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carlife_service_orders.limit_leave_time
     *
     * @param limitLeaveTime the value for carlife_service_orders.limit_leave_time
     *
     * @mbggenerated
     */
    public void setLimitLeaveTime(String limitLeaveTime) {
        this.limitLeaveTime = limitLeaveTime == null ? null : limitLeaveTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carlife_service_orders.limit_pay_time
     *
     * @return the value of carlife_service_orders.limit_pay_time
     *
     * @mbggenerated
     */
    public String getLimitPayTime() {
        return limitPayTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carlife_service_orders.limit_pay_time
     *
     * @param limitPayTime the value for carlife_service_orders.limit_pay_time
     *
     * @mbggenerated
     */
    public void setLimitPayTime(String limitPayTime) {
        this.limitPayTime = limitPayTime == null ? null : limitPayTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carlife_service_orders.gmt_modified
     *
     * @return the value of carlife_service_orders.gmt_modified
     *
     * @mbggenerated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carlife_service_orders.gmt_modified
     *
     * @param gmtModified the value for carlife_service_orders.gmt_modified
     *
     * @mbggenerated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column carlife_service_orders.gmt_create
     *
     * @return the value of carlife_service_orders.gmt_create
     *
     * @mbggenerated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column carlife_service_orders.gmt_create
     *
     * @param gmtCreate the value for carlife_service_orders.gmt_create
     *
     * @mbggenerated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}