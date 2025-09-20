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
public class PromoterFeedListResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5584817726976222436L;
  /**
   * 推客的绑定参数列表
   */
  @JsonProperty("feed_list")
  private List<FeedInfo> feed_list;

  /**
   * 分页参数
   */
  @JsonProperty("next_key")
  private String nextKey;

  @JsonProperty("has_more")
  private boolean hasMore;

  @Data
  @NoArgsConstructor
  public static class FeedInfo implements Serializable {
    /**
     * 短视频 id
     */
    @JsonProperty("export_id")
    private String exportId;

    /**
     * 短视频挂载的商品信息
     */
    @JsonProperty("product_info")
    private ProductInfo productInfo;

    /**
     * 预期机构结算金额【单位：分
     */
    @JsonProperty("predict_commission_amount")
    private Long predictCommissionAmount;

    /**
     * 所属的带货者 id
     */
    @JsonProperty("talent_appid")
    private String talentAppid;

  }

  @Data
  @NoArgsConstructor
  public static class ProductInfo implements Serializable {
    @JsonProperty("product_name")
    private String product_name;

    @JsonProperty("product_img_url")
    private String product_img_url;

    @JsonProperty("product_id")
    private Long product_id;

    @JsonProperty("product_mini_price")
    private Long product_mini_price;
  }

}
