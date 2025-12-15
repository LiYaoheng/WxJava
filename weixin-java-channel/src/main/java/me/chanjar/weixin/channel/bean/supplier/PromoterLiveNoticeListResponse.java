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
public class PromoterLiveNoticeListResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5584817726976222436L;
  /**
   * 推客的绑定参数列表
   */
  @JsonProperty("live_notice_record_list")
  private List<LiveNotice> live_notice_record_list;

  @Data
  @NoArgsConstructor
  public static class LiveNotice implements Serializable {

    @JsonProperty("notice_id")
    private String notice_id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("start_time")
    private Long start_time;

  }
}
