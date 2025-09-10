package me.chanjar.weixin.channel.bean.supplier;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.channel.bean.base.WxChannelBaseResponse;

import java.io.Serializable;

/**
 * 推客的注册状态以及和机构的绑定状态
 *
 * @author liyaoheng
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PromoterOrderDetailResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5584817726976222436L;

  /**
   * 推客的绑定参数列表
   */
  @JsonProperty("commssion_order")
  private OrderInfo commissionOrder;

  @Data
  @NoArgsConstructor
  public static class OrderInfo implements Serializable {
    /**
     * 订单号
     */
    @JsonProperty("order_id")
    private String order_id;

    /**
     * 商品skuid
     */
    @JsonProperty("sku_id")
    private Long sku_id;

    @JsonProperty("create_time")
    private Long create_time;

    @JsonProperty("update_time")
    private Long update_time;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("order_detail")
    private OrderDetail order_detail;

  }

  @Data
  @NoArgsConstructor
  public static class OrderDetail implements Serializable {

    /**
     * 小店商家信息
     */
    @JsonProperty("shop_info")
    private JsonObject shop_info;

    /**
     * 佣金单商品信息
     */
    @JsonProperty("product_info")
    private JsonObject product_info;

    /**
     * 订单信息
     */
    @JsonProperty("order_info")
    private JsonObject order_info;

    /**
     * 分佣信息
     */
    @JsonProperty("commission_info")
    private JsonObject commission_info;

    /**
     * 买家信息
     */
    @JsonProperty("buyer_info")
    private JsonObject buyer_info;

  }

}
