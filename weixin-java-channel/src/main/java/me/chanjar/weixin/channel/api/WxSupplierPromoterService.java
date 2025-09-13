package me.chanjar.weixin.channel.api;

import me.chanjar.weixin.channel.bean.base.WxChannelBaseResponse;
import me.chanjar.weixin.channel.bean.supplier.*;
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

  /**
   * 获取机构绑定的推客信息
   *
   * @param nextKey      分页参数，第一页为空，后面返回前面一页返回的数据
   * @param pageSize     一页获取多少个推客，最大 20
   * @param sharerOpenid 查询某个推客，传入推客的小程序openid。 必须是机构绑定小程序的用户openid，而不能是其他小程序的用户openid。
   * @return
   */
  PromoterBindSharerResponse getBindSharerList(String nextKey, Integer pageSize, String sharerOpenid) throws WxErrorException;

  /**
   * 获取合作的小店列表
   *
   * @param nextKey
   * @param pageSize
   * @return
   */
  PromoterBindShopResponse geBindShopList(String nextKey, Integer pageSize) throws WxErrorException;

  /**
   * 获取推客对某个商品的推广短链
   *
   * @param sharerAppid 推客在小程序中的openid。 必须是机构绑定小程序的用户openid，而不能是其他小程序的用户openid
   * @param productId   商品 id，如果使用该参数，需要传入shop_appid
   * @param shopAppid   商品所属店铺 appid
   * @return
   */
  PromoterProductPromotionLinkResponse getProductPromotionLinkInfo(String sharerAppid, Long productId, String shopAppid) throws WxErrorException;

  /**
   * 获取推客对某个商品的推广二维码
   *
   * @param sharerAppid 推客在小程序中的openid。 必须是机构绑定小程序的用户openid，而不能是其他小程序的用户openid
   * @param productId   商品 id，如果使用该参数，需要传入shop_appid
   * @param shopAppid   商品所属店铺 appid
   * @return
   */
  PromoterProductPromotionLinkResponse getProductPromotionQrcodeInfo(String sharerAppid, Long productId, String shopAppid) throws WxErrorException;

  /**
   * 获取某个推客某个商品的内嵌商品卡片product_promotion_link
   *
   * @param sharerAppid 推客 appid
   * @param productId   商品 id
   * @param shopAppid   商品所属店铺 appid
   * @return
   * @throws WxErrorException
   */
  PromoterProductPromotionLinkResponse getPromoterSingleProductPromotionInfo(String sharerAppid, Long productId, String shopAppid) throws WxErrorException;

  /**
   * 获取可推广的商品id列表
   * https://developers.weixin.qq.com/doc/store/leagueheadsupplier/api/sharer/getshop/api_getpromoteproductlist.html
   *
   * @param planType 商品的计划类型 1：定向计划 2：公开计划 3: 机构定向计划 4: 机构普通计划
   * @param pageSize 一页获取多少个商品，最大 20
   * @param nextKey  分页参数，第一页为空，后面返回前面一页返回的数据
   * @return
   */
  PromoterPromoteProductResponse getPromoteProductList(Integer planType, Integer pageSize, String nextKey, String shopAppid, String keyword) throws WxErrorException;

  /**
   * 获取合作商品详情
   *
   * @param shopAppid          机构商品 所属小店appid
   * @param planType           商品的计划类型 1：定向计划 2：公开计划 3: 机构定向计划 4: 机构普通计划
   * @param productId          商品id
   * @param getAvailableCoupon 填true返回商品可用的机构券
   * @param headSupplierAppid  商品所属供货机构appid【当plan_type为 3 和 4 时，这个参数必传】
   * @return
   */
  PromoterPromoteProductDetailResponse getPromoteProductDetail(String shopAppid, Integer planType, Long productId, Boolean getAvailableCoupon, String headSupplierAppid) throws WxErrorException;

  /**
   * 商品订阅
   *
   * @param productId 要订阅的商品ID
   * @return
   */
  WxChannelBaseResponse subscribeProduct(Long productId) throws WxErrorException;

  /**
   * 取消商品订阅
   *
   * @param productId 要取消订阅的商品ID
   * @return
   */
  WxChannelBaseResponse unsubscribeProduct(Long productId) throws WxErrorException;

  /**
   * 获取订阅的商品列表
   *
   * @param pageSize     每页数量(不超过1000)
   * @param nextKey      翻页参数，从第二页开始传，来源于上一页的返回值
   * @param needTotalNum 否需要返回符合条件的记录总数
   * @return
   */
  PromoterSubscribeProductResponse getSubscribeProductList(Integer pageSize, String nextKey, Boolean needTotalNum) throws WxErrorException;

  /**
   * 获取商品基础详情
   *
   * @param shopAppid 机构商品 所属小店appid
   * @param productId 商品id
   * @return
   */
  PromoterSubscribeProductDetailResponse getSubscribeProductDetail(String shopAppid, Long productId) throws WxErrorException;

  /**
   * 获取佣金单列表
   * https://developers.weixin.qq.com/doc/store/leagueheadsupplier/api/order/api_getorderlist.html
   *
   * @param pageSize    单页佣金单数（不超过30）
   * @param nextKey     由上次请求返回，顺序翻页时需要传入, 会从上次返回的结果往后翻一页
   * @param sharerAppid 用于查询推客，或者达人平台产生的订单数据
   * @return
   */
  PromoterOrderListResponse getOrderList(Integer pageSize, String nextKey, String sharerAppid) throws WxErrorException;

  /**
   * 获取佣金单详情
   * https://developers.weixin.qq.com/doc/store/leagueheadsupplier/api/order/api_getorder.html
   *
   * @param orderId 订单号，可从获取佣金单列表接口获得
   * @param skuId   商品skuid，可从获取佣金单列表接口获得
   * @return
   */
  PromoterOrderDetailResponse getOrderDetail(Long orderId, Long skuId) throws WxErrorException;

}
