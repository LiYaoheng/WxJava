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
public class PromoterFeedInfoResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5584817726976222436L;
  /**
   * 推客的绑定参数列表
   */
  @JsonProperty("feed_list")
  private List<FeedInfo> feedList;

  @Data
  @NoArgsConstructor
  public static class FeedInfo implements Serializable {
    /**
     * 短视频 id
     */
    @JsonProperty("export_id")
    private String exportId;

    /**
     * 内嵌短视频的卡片信息
     */
    @JsonProperty("feed_token")
    private String feedToken;

    /**
     * 推广推客信息
     */
    @JsonProperty("promoter_share_link")
    private String promoterShareLink;

  }

}
