package me.chanjar.weixin.channel.bean.supplier;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.chanjar.weixin.channel.bean.base.WxChannelBaseResponse;

/**
 * 推客的注册状态以及和机构的绑定状态
 *
 * @author liyaoheng
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PromoterRegisterResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5584817726976222436L;
  /**
   * 和机构的绑定状态，0：未绑定 1：已绑定
   */
  @JsonProperty("bind_status")
  private Integer bindStatus;

  /**
   * 当前推客的注册状态：0：未注册 1：注册中，还未完成 2：已完成注册 3:用户未支付实名，需要把微信先支付实名才能继续注册
   */
  @JsonProperty("register_status")
  private Integer registerStatus;

  /**
   * register_status等于 0 或者 1时，调用注册流程时，openBusinessView需要的businessType
   */
  @JsonProperty("register_business_type")
  private String registerBusinessType;

  /**
   * 注册时需要的queryString参数
   */
  @JsonProperty("register_query_string")
  private String registerQueryString;

  /**
   * bind_status等于0时，调用绑定流程时，openBusinessView需要的businessType
   */
  @JsonProperty("bind_business_type")
  private String bindBusinessType;

  /**
   * 绑定时需要的queryString参数
   */
  @JsonProperty("bind_query_string")
  private String bindQueryString;

  /**
   * 如果推客和机构已经绑定，就返回对应推客的 appid
   */
  @JsonProperty("sharer_appid")
  private String sharerAppid;

}
