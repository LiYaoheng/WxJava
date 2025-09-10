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
public class PromoterBindSharerResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5584817726976222436L;
  /**
   * 推客的绑定参数列表
   */
  @JsonProperty("sharer_info_list")
  private List<SharerInfo> sharerInfoList;

  /**
   * 分页参数
   */
  @JsonProperty("next_key")
  private String nextKey;

  @Data
  @NoArgsConstructor
  public static class SharerInfo implements Serializable {
    /**
     * 推客的 appid
     */
    @JsonProperty("sharer_appid")
    private String sharerAppid;

    /**
     * 绑定时间戳
     */
    @JsonProperty("bind_time")
    private Long bindTime;

    /**
     * 分佣比例
     */
    @JsonProperty("commission_ratio")
    private Integer commissionRatio;

    /**
     * 分佣类型【0：平台分佣 1：机构分佣】
     */
    @JsonProperty("commission_type")
    private Integer commissionType;

    /**
     * 推客的昵称
     */
    @JsonProperty("nickname")
    private String nickname;

    /**
     * 推客的头像
     */
    @JsonProperty("head_img_url")
    private String headImgUrl;

  }

}
