package me.chanjar.weixin.channel.api.impl;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.channel.api.WxSupplierPromoterService;
import me.chanjar.weixin.channel.bean.base.WxChannelBaseResponse;
import me.chanjar.weixin.channel.bean.supplier.*;
import me.chanjar.weixin.channel.util.ResponseUtils;
import me.chanjar.weixin.common.error.WxErrorException;

import static me.chanjar.weixin.channel.constant.WxChannelApiUrlConstants.Promoter.*;

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

  @Override
  public PromoterBindSharerResponse getBindSharerList(String nextKey, Integer pageSize, String sharerOpenid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("next_key", nextKey);
    reqJson.addProperty("page_size", pageSize);
    reqJson.addProperty("sharer_openid", sharerOpenid);
    String resJson = shopService.post(GET_BIND_SHARER_LIST_URL, reqJson);
    return ResponseUtils.decode(resJson, PromoterBindSharerResponse.class);
  }

  @Override
  public PromoterBindShopResponse getBindShopList(String nextKey, Integer pageSize) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("next_key", nextKey);
    reqJson.addProperty("page_size", pageSize);
    String resJson = shopService.post(GET_BIND_SHOP_LIST_URL, reqJson);
    return ResponseUtils.decode(resJson, PromoterBindShopResponse.class);
  }

  @Override
  public PromoterProductPromotionLinkResponse getProductPromotionLinkInfo(String sharerAppid, Long productId, String shopAppid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("sharer_appid", sharerAppid);
    reqJson.addProperty("product_id", productId);
    reqJson.addProperty("shop_appid", shopAppid);
    String resJson = shopService.post(GET_PRODUCT_PROMOTION_LINK_INFO_URL, reqJson);
    return ResponseUtils.decode(resJson, PromoterProductPromotionLinkResponse.class);
  }

  @Override
  public PromoterProductPromotionLinkResponse getProductPromotionQrcodeInfo(String sharerAppid, Long productId, String shopAppid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("sharer_appid", sharerAppid);
    reqJson.addProperty("product_id", productId);
    reqJson.addProperty("shop_appid", shopAppid);
    String resJson = shopService.post(GET_PRODUCT_PROMOTION_QRCODE_INFO_URL, reqJson);
    return ResponseUtils.decode(resJson, PromoterProductPromotionLinkResponse.class);
  }

  @Override
  public PromoterProductPromotionLinkResponse getPromoterSingleProductPromotionInfo(String sharerAppid, Long productId, String shopAppid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("sharer_appid", sharerAppid);
    reqJson.addProperty("product_id", productId);
    reqJson.addProperty("shop_appid", shopAppid);
    String resJson = shopService.post(GET_PROMOTER_SINGLE_PRODUCT_PROMOTION_INFO_URL, reqJson);
    return ResponseUtils.decode(resJson, PromoterProductPromotionLinkResponse.class);
  }

  @Override
  public PromoterPromoteProductResponse getPromoteProductList(Integer planType, Integer pageSize, String nextKey, String shopAppid, String keyword) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("shop_appid", shopAppid);
    reqJson.addProperty("plan_type", planType);
    reqJson.addProperty("page_size", pageSize);
    reqJson.addProperty("next_key", nextKey);
    reqJson.addProperty("keyword", keyword);
    String resJson = shopService.post(GET_PROMOTE_PRODUCT_LIST_URL, reqJson);
    return ResponseUtils.decode(resJson, PromoterPromoteProductResponse.class);
  }

  @Override
  public PromoterPromoteProductDetailResponse getPromoteProductDetail(String shopAppid, Integer planType, Long productId, Boolean getAvailableCoupon, String headSupplierAppid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("shop_appid", shopAppid);
    reqJson.addProperty("plan_type", planType);
    reqJson.addProperty("product_id", productId);
    reqJson.addProperty("get_available_coupon", getAvailableCoupon);
    reqJson.addProperty("head_supplier_appid", headSupplierAppid);
    String resJson = shopService.post(GET_PROMOTE_PRODUCT_DETAIL_URL, reqJson);
    log.info("wechat api {},response:{}", GET_PROMOTE_PRODUCT_DETAIL_URL, resJson);
    return ResponseUtils.decode(resJson, PromoterPromoteProductDetailResponse.class);
  }

  @Override
  public WxChannelBaseResponse subscribeProduct(Long productId) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("product_id", productId);
    String resJson = shopService.post(SUBSCRIBE_PRODUCT_URL, reqJson);
    return ResponseUtils.decode(resJson, WxChannelBaseResponse.class);
  }

  @Override
  public WxChannelBaseResponse unsubscribeProduct(Long productId) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("product_id", productId);
    String resJson = shopService.post(UNSUBSCRIBE_PRODUCT_URL, reqJson);
    return ResponseUtils.decode(resJson, WxChannelBaseResponse.class);
  }

  @Override
  public PromoterSubscribeProductResponse getSubscribeProductList(Integer pageSize, String nextKey, Boolean needTotalNum) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("next_key", nextKey);
    reqJson.addProperty("page_size", pageSize);
    reqJson.addProperty("need_total_num", needTotalNum);
    String resJson = shopService.post(GET_SUBSCRIBE_PRODUCT_URL, reqJson);
    return ResponseUtils.decode(resJson, PromoterSubscribeProductResponse.class);
  }

  @Override
  public PromoterSubscribeProductDetailResponse getSubscribeProductDetail(String shopAppid, Long productId) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("shop_appid", shopAppid);
    reqJson.addProperty("product_id", productId);
    String resJson = shopService.post(GET_PRODUCT_DETAIL_URL, reqJson);
    log.info("wechat api {},response:{}", GET_PRODUCT_DETAIL_URL, resJson);
    return ResponseUtils.decode(resJson, PromoterSubscribeProductDetailResponse.class);
  }

  @Override
  public PromoterOrderListResponse getOrderList(Integer pageSize, String nextKey, String sharerAppid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("next_key", nextKey);
    reqJson.addProperty("page_size", pageSize);
    reqJson.addProperty("sharer_appid", sharerAppid);
    String resJson = shopService.post(GET_ORDER_LIST_URL, reqJson);
    return ResponseUtils.decode(resJson, PromoterOrderListResponse.class);
  }

  @Override
  public PromoterOrderDetailResponse getOrderDetail(String orderId, String skuId) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("order_id", orderId);
    reqJson.addProperty("sku_id", skuId);
    String resJson = shopService.post(GET_ORDER_URL, reqJson);
    log.info("wechat api {},response:{}", GET_ORDER_URL, resJson);
    return ResponseUtils.decode(resJson, PromoterOrderDetailResponse.class);
  }
}
