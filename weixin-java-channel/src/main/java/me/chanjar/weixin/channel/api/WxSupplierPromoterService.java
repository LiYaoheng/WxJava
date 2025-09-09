package me.chanjar.weixin.channel.api;

import me.chanjar.weixin.channel.bean.supplier.PromoterRegisterResponse;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 联盟带货机构 推客带货
 *
 * @author liyaoheng
 */
public interface WxSupplierPromoterService {

  /**
   * 获取推客的注册状态以及和机构的绑定状态
   *
   * @param sharerOpenid     推客在小程序中的 openid， 必须是机构绑定小程序的用户openid，而不能是其他小程序的用户openid。 和 sharer_appid 二选一
   * @param isSimpleRegister 是否走简易版本注册【当走简易版本注册时，可以不要求推客开通商户号，但分佣只能走机构自己分佣；如果不走简易注册流程时，要求推客开通商户号作为收款账户，可以平台分佣】
   * @return
   * @throws WxErrorException
   */
  PromoterRegisterResponse getPromoterRegister(String sharerOpenid, boolean isSimpleRegister) throws WxErrorException;

}
