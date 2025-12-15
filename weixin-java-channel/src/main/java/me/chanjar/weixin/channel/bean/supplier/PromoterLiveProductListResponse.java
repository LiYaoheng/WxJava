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
public class PromoterLiveProductListResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5584817726976222436L;
  /**
   * 推客的绑定参数列表
   */
  @JsonProperty("product_list")
  private List<ProductInfo> product_list;

  /**
   * 分页参数
   */
  @JsonProperty("next_key")
  private String nextKey;

  @JsonProperty("has_more")
  private boolean hasMore;

  @Data
  @NoArgsConstructor
  public static class ProductInfo implements Serializable {

    @JsonProperty("product_id")
    private Long product_id;

    @JsonProperty("product_name")
    private String product_name;

    @JsonProperty("product_img_url")
    private String product_img_url;

    @JsonProperty("product_price")
    private Long product_price;

    @JsonProperty("predict_commission_amount")
    private Long predict_commission_amount;

  }
}
