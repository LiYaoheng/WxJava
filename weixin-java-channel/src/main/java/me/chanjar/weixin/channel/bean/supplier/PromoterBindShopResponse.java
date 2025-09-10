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
public class PromoterBindShopResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5584817726976222436L;
  /**
   * 推客的绑定参数列表
   */
  @JsonProperty("shop_list")
  private List<ShopInfo> shopList;

  /**
   * 分页参数
   */
  @JsonProperty("next_key")
  private String nextKey;

  /**
   * 是否还有下一页
   */
  @JsonProperty("has_more")
  private boolean hasMore;

  @Data
  @NoArgsConstructor
  public static class ShopInfo implements Serializable {
    /**
     * 小店的 appid
     */
    @JsonProperty("shop_appid")
    private String shopAppid;

    /**
     * 绑定时间戳
     */
    @JsonProperty("bind_time")
    private Long bindTime;

    /**
     * 小店的名称
     */
    @JsonProperty("shop_nickname")
    private String shopNickname;

    /**
     * 小店的头像
     */
    @JsonProperty("shop_head_img")
    private String shopHeadImg;

  }

}
