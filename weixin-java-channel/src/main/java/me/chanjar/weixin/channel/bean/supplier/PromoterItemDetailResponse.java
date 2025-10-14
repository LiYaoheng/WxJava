package me.chanjar.weixin.channel.bean.supplier;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PromoterItemDetailResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5584817726976222436L;

  /**
   * 商品详情
   */
  @JsonProperty("item")
  private ProductInfo item;

  @Data
  @NoArgsConstructor
  public static class ProductInfo implements Serializable {
    /**
     * 所属小店appid
     */
    @JsonProperty("shop_appid")
    private String shopAppid;

    /**
     * 商品id
     */
    @JsonProperty("product_id")
    private Long productId;

    /**
     * 1-商家供货；2-机构供货
     */
    @JsonProperty("spu_source")
    private Integer spuSource;

    /**
     * 商品佣金信息
     */
    @JsonProperty("commission_info")
    private CommissionInfo commission_info;

    /**
     * 供货机构信息
     */
    @JsonProperty("head_supplier_info")
    private HeadSupplierInfo head_supplier_info;

    /**
     * 商品合作信息
     */
    @JsonProperty("cooperative_info")
    private CooperativeInfo cooperative_info;
  }

  @Data
  @NoArgsConstructor
  public static class CommissionInfo implements Serializable {

    @JsonProperty("plan_type")
    private Integer plan_type;

    @JsonProperty("commission_type")
    private Integer commission_type;

    @JsonProperty("ratio")
    private Integer ratio;

    @JsonProperty("service_ratio")
    private Integer service_ratio;

    @JsonProperty("start_time")
    private Long start_time;

    @JsonProperty("end_time")
    private Long end_time;

  }

  @Data
  @NoArgsConstructor
  public static class HeadSupplierInfo implements Serializable {

    @JsonProperty("name")
    private String name;

    @JsonProperty("appid")
    private String appid;
  }

  @Data
  @NoArgsConstructor
  public static class CooperativeInfo implements Serializable {
    @JsonProperty("cooperative_status")
    private Integer cooperative_status;

    @JsonProperty("is_hidden")
    private Boolean is_hidden;

    @JsonProperty("link")
    private String link;

  }

}
