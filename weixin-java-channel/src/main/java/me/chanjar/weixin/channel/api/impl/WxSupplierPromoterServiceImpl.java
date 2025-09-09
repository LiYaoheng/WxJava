package me.chanjar.weixin.channel.api.impl;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.channel.api.WxSupplierPromoterService;
import me.chanjar.weixin.channel.bean.supplier.PromoterRegisterResponse;
import me.chanjar.weixin.channel.util.ResponseUtils;
import me.chanjar.weixin.common.error.WxErrorException;

import static me.chanjar.weixin.channel.constant.WxChannelApiUrlConstants.Promoter.GET_PROMOTER_REGISTER_AND_BIND_STATUS_URL;

/**
 * 联盟带货机构 推客带货
 *
 * @author liyaoheng
 */
@Slf4j
public class WxSupplierPromoterServiceImpl implements WxSupplierPromoterService {

  /**
   * 微信商店服务
   */
  private final BaseWxChannelServiceImpl<?, ?> shopService;

  public WxSupplierPromoterServiceImpl(BaseWxChannelServiceImpl<?, ?> shopService) {
    this.shopService = shopService;
  }

  @Override
  public PromoterRegisterResponse getPromoterRegister(String sharerOpenid, boolean isSimpleRegister) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("sharer_openid", sharerOpenid);
    reqJson.addProperty("is_simple_register", isSimpleRegister);
    String resJson = shopService.post(GET_PROMOTER_REGISTER_AND_BIND_STATUS_URL, reqJson);
    return ResponseUtils.decode(resJson, PromoterRegisterResponse.class);
  }

}
