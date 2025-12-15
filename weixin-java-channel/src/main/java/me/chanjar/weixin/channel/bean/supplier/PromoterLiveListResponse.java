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
public class PromoterLiveListResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5584817726976222436L;

  @JsonProperty("live_record_list")
  private List<ListInfo> live_record_list;

  @Data
  @NoArgsConstructor
  public static class ListInfo implements Serializable {

    @JsonProperty("export_id")
    private String export_id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("promoter_share_link")
    private String promoter_share_link;
  }

}
