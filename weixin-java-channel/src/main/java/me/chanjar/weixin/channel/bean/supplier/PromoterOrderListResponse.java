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
public class PromoterOrderListResponse extends WxChannelBaseResponse {

  private static final long serialVersionUID = 5584817726976222436L;

  /**
   * 推客的绑定参数列表
   */
  @JsonProperty("list")
  private List<OrderInfo> list;

  /**
   * 分页参数
   */
  @JsonProperty("next_key")
  private String nextKey;

  @JsonProperty("has_more")
  private boolean has_more;

  @Data
  @NoArgsConstructor
  public static class OrderInfo implements Serializable {
    /**
     * 订单ID
     */
    @JsonProperty("order_id")
    private String order_id;

    /**
     * skuId
     */
    @JsonProperty("sku_id")
    private Long sku_id;

  }

}
