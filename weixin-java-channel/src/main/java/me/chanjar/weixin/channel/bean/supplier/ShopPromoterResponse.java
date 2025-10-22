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
public class ShopPromoterResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5584817726976222436L;
  /**
   * 推客的绑定参数列表
   */
  @JsonProperty("promoter_list")
  private List<PromoterInfo> promoterList;

  /**
   * 分页参数
   */
  @JsonProperty("next_key")
  private String nextKey;

  @JsonProperty("has_more")
  private boolean hasMore;

  @Data
  @NoArgsConstructor
  public static class PromoterInfo implements Serializable {
    /**
     * 带货者的id
     */
    @JsonProperty("promoter_id")
    private String promoter_id;

    /**
     * 绑定时间戳
     */
    @JsonProperty("promoter_type")
    private Integer promoter_type;

    /**
     * 推客的昵称
     */
    @JsonProperty("promoter_name")
    private String promoter_name;

    /**
     * 推客的头像
     */
    @JsonProperty("avatar_image_url")
    private String avatar_image_url;

  }

}
