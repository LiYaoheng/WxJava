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
public class PromoterSubscribeProductResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5584817726976222436L;

  /**
   * 推客的绑定参数列表
   */
  @JsonProperty("subscribe_info_list")
  private List<ProductInfo> subscribe_info_list;

  /**
   * 分页参数
   */
  @JsonProperty("next_key")
  private String nextKey;

  @JsonProperty("total_num")
  private Integer total_num;

  @JsonProperty("has_more")
  private boolean has_more;

  @Data
  @NoArgsConstructor
  public static class ProductInfo implements Serializable {
    /**
     * 店铺AppID
     */
    @JsonProperty("shop_appid")
    private String shopAppid;

    /**
     * 商品 id
     */
    @JsonProperty("product_id")
    private Long productId;

  }

}
