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
public class PromoterSubscribeProductDetailResponse extends WxChannelBaseResponse {

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
     * 商品信息
     */
    @JsonProperty("product_info")
    private ProductInfoDetail product_info;

    /**
     * 店铺信息
     */
    @JsonProperty("shop")
    private ShopInfoDetail shop;
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

    @JsonProperty("cats_v2")
    private Object cats_v2;

    @JsonProperty("skus")
    private List<ProductInfoDetailSku> skus;

    @JsonProperty("monthly_sales_range")
    private Long monthly_sales_range;

    @JsonProperty("status")
    private Integer status;

  }

  @Data
  @NoArgsConstructor
  public static class ShopInfoDetail implements Serializable {

    @JsonProperty("name")
    private String name;

    @JsonProperty("score")
    private Integer score;

    @JsonProperty("icon")
    private String icon;
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
