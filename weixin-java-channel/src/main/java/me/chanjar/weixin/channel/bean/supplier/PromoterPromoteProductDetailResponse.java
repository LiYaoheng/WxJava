package me.chanjar.weixin.channel.bean.supplier;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.channel.bean.base.WxChannelBaseResponse;

import java.io.Serializable;
import java.util.List;

/**
 * 推客的注册状态以及和机构的绑定状态
 *
 * @author liyaoheng
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PromoterPromoteProductDetailResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5584817726976222436L;

  /**
   * 商品详情
   */
  @JsonProperty("product")
  private ProductInfo product;

  /**
   * 商品可用的公开机构券
   */
  @JsonProperty("publish_coupons")
  private Object publish_coupons;

  /**
   * 商品可用的定向机构券
   */
  @JsonProperty("cooperative_coupons")
  private Object cooperative_coupons;

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
     * 商品卡片透传参数【注意：内嵌商品卡片时一定要传，不然会归因失败】
     */
    @JsonProperty("product_promotion_link")
    private String product_promotion_link;

    /**
     * 商品信息
     */
    @JsonProperty("product_info")
    private ProductInfoDetail product_info;

    /**
     * 跟佣信息
     */
    @JsonProperty("commission_info")
    private Object commission_info;

    /**
     * 供货机构信息
     */
    @JsonProperty("head_supplier_info")
    private Object head_supplier_info;

  }

  @Data
  @NoArgsConstructor
  public static class ProductInfoDetail implements Serializable {

    @JsonProperty("title")
    private String title;

    @JsonProperty("sub_title")
    private String sub_title;

    @JsonProperty("head_imgs")
    private List<String> head_imgs;

    @JsonProperty("desc_info")
    private ProductInfoDetailDesc desc_info;

    @JsonProperty("cats")
    private Object cats;

    @JsonProperty("cats_v2")
    private Object cats_v2;

    @JsonProperty("skus")
    private List<ProductInfoDetailSku> skus;

    @JsonProperty("product_promotion_link")
    private String product_promotion_link;

    @JsonProperty("status")
    private Integer status;

  }

  @Data
  @NoArgsConstructor
  public static class ProductInfoDetailDesc implements Serializable {
    @JsonProperty("imgs")
    private List<String> imgs;

    @JsonProperty("desc")
    private String desc;
  }

  @Data
  @NoArgsConstructor
  public static class ProductInfoDetailSku implements Serializable {
    @JsonProperty("sku_id")
    private String sku_id;

    @JsonProperty("thumb_img")
    private String thumb_img;

    @JsonProperty("sale_price")
    private Double sale_price;

    @JsonProperty("stock_num")
    private Double stock_num;

    @JsonProperty("sku_attrs")
    private Object sku_attrs;

    @JsonProperty("sku_deliver_info")
    private Object sku_deliver_info;

  }

}
