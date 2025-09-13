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
public class PromoterProductPromotionLinkResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5584817726976222436L;

  /**
   * 推广短链
   */
  @JsonProperty("short_link")
  private String shortLink;

  /**
   * 推广二维码
   */
  @JsonProperty("qrcode_url")
  private String qrcodeUrl;

  /**
   * 内嵌商品卡片的推广参数
   */
  @JsonProperty("product_promotion_link")
  private String productPromotionLink;

}
