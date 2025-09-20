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
public class PromoterBindTalentResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5584817726976222436L;
  /**
   * 推客的绑定参数列表
   */
  @JsonProperty("talent_list")
  private List<TalentInfo> talentList;

  /**
   * 分页参数
   */
  @JsonProperty("next_key")
  private String nextKey;

  @JsonProperty("has_more")
  private boolean hasMore;

  @Data
  @NoArgsConstructor
  public static class TalentInfo implements Serializable {
    /**
     * 带货者的id
     */
    @JsonProperty("talent_appid")
    private String talentAppid;

    /**
     * 绑定时间戳
     */
    @JsonProperty("bind_time")
    private Long bindTime;

    /**
     * 推客的昵称
     */
    @JsonProperty("talent_nickname")
    private String talent_nickname;

    /**
     * 推客的头像
     */
    @JsonProperty("talent_head_img")
    private String talent_head_img;

    /**
     * 关联的视频号username
     */
    @JsonProperty("related_finder_exportname_list")
    private List<String> related_finder_exportname_list;

    /**
     * 关联的公众号appid
     */
    @JsonProperty("related_mp_biz_appid_list")
    private List<String> related_mp_biz_appid_list;

  }

}
