package me.chanjar.weixin.channel.api.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.channel.api.WxSupplierPromoterService;
import me.chanjar.weixin.channel.bean.base.WxChannelBaseResponse;
import me.chanjar.weixin.channel.bean.supplier.*;
import me.chanjar.weixin.channel.util.ResponseUtils;
import me.chanjar.weixin.common.error.WxErrorException;

import java.util.List;

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
  public WxChannelBaseResponse headsupplierUnbindPromoter(String sharerAppid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("sharer_appid", sharerAppid);
    String resJson = shopService.post(HEADSUPPLIER_UNBIND_PROMOTER_URL, reqJson);
    return ResponseUtils.decode(resJson, WxChannelBaseResponse.class);
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
  public PromoterOrderListResponse getOrderList(Integer pageSize, String nextKey, String sharerAppid, String orderId) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("next_key", nextKey);
    reqJson.addProperty("page_size", pageSize);
    reqJson.addProperty("sharer_appid", sharerAppid);
    reqJson.addProperty("order_id", orderId);
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

  @Override
  public PromoterBindTalentResponse getBindTalentList(String nextKey, Integer pageSize, String talentAppid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("next_key", nextKey);
    reqJson.addProperty("page_size", pageSize);
    reqJson.addProperty("talent_appid", talentAppid);
    String resJson = shopService.post(GET_BIND_TALENT_LIST_URL, reqJson);
    return ResponseUtils.decode(resJson, PromoterBindTalentResponse.class);
  }

  @Override
  public PromoterFeedListResponse getFeedList(String nextKey, Integer pageSize, String talentAppid, String finderExportUsername) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("next_key", nextKey);
    reqJson.addProperty("page_size", pageSize);
    reqJson.addProperty("talent_appid", talentAppid);
    reqJson.addProperty("finder_exportusername", finderExportUsername);
    String resJson = shopService.post(GET_FEED_LIST_URL, reqJson);
    return ResponseUtils.decode(resJson, PromoterFeedListResponse.class);
  }

  @Override
  public PromoterFeedInfoResponse getFeedPromotionInfo(List<String> feedList, String miniProgramAppid, String talentAppid, String sharerAppid) throws WxErrorException {
    JsonArray feedListJson = new JsonArray();
    for (String exportId : feedList) {
      JsonObject reqJson = new JsonObject();
      reqJson.addProperty("export_id", exportId);
      feedListJson.add(reqJson);
    }
    JsonObject reqJson = new JsonObject();
    reqJson.add("feed_list", feedListJson);
    reqJson.addProperty("mini_program_appid", miniProgramAppid);
    reqJson.addProperty("talent_appid", talentAppid);
    reqJson.addProperty("sharer_appid", sharerAppid);
    String resJson = shopService.post(GET_FEED_PROMOTION_INFO_URL, reqJson);
    return ResponseUtils.decode(resJson, PromoterFeedInfoResponse.class);
  }

  @Override
  public PromoterItemDetailResponse getItemPromotionDetail(String headSupplierItemLink) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("head_supplier_item_link", headSupplierItemLink);
    String resJson = shopService.post(GET_ITEM_PROMOTION_DETAIL_URL, reqJson);
    return ResponseUtils.decode(resJson, PromoterItemDetailResponse.class);
  }

  @Override
  public ShopPromoterResponse getBindShopPromoterList(String nextKey, Integer pageSize, String shop_appid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("next_key", nextKey);
    reqJson.addProperty("page_size", pageSize);
    reqJson.addProperty("shop_appid", shop_appid);
    String resJson = shopService.post(GET_BIND_SHOP_PROMOTER_LIST, reqJson);
    return ResponseUtils.decode(resJson, ShopPromoterResponse.class);
  }

  @Override
  public PromoterFeedListResponse getShopFeedList(String nextKey, Integer pageSize, String shop_appid, String promoter_id) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("next_key", nextKey);
    reqJson.addProperty("page_size", pageSize);
    reqJson.addProperty("shop_appid", shop_appid);
    reqJson.addProperty("promoter_id", promoter_id);
    reqJson.addProperty("promoter_type", 1);
    String resJson = shopService.post(GET_SHOP_FEED_LIST, reqJson);
    return ResponseUtils.decode(resJson, PromoterFeedListResponse.class);
  }

  @Override
  public PromoterFeedInfoResponse getShopFeedPromotionInfo(List<String> feedList, String miniProgramAppid, String shopAppid, String promoterId, String sharerAppid) throws WxErrorException {
    JsonArray feedListJson = new JsonArray();
    for (String exportId : feedList) {
      JsonObject reqJson = new JsonObject();
      reqJson.addProperty("export_id", exportId);
      feedListJson.add(reqJson);
    }
    JsonObject reqJson = new JsonObject();
    reqJson.add("feed_list", feedListJson);
    reqJson.addProperty("mini_program_appid", miniProgramAppid);
    reqJson.addProperty("shop_appid", shopAppid);
    reqJson.addProperty("promoter_id", promoterId);
    reqJson.addProperty("sharer_appid", sharerAppid);
    reqJson.addProperty("promoter_type", 1);
    String resJson = shopService.post(GET_SHOP_FEED_PROMOTION_INFO, reqJson);
    return ResponseUtils.decode(resJson, PromoterFeedInfoResponse.class);
  }

  @Override
  public PromoterLiveProductListResponse getLiveCommissionProductList(String talent_appid, String next_key, String page_size) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("talent_appid", talent_appid);
    reqJson.addProperty("next_key", next_key);
    reqJson.addProperty("page_size", page_size);
    String resJson = shopService.post("https://api.weixin.qq.com/channels/ec/promoter/get_live_commission_product_list", reqJson);
    return ResponseUtils.decode(resJson, PromoterLiveProductListResponse.class);
  }

  @Override
  public PromoterLiveProductListResponse getShopLiveCommissionProductList(String shop_appid, String promoter_id, Integer promoter_type, String next_key, String page_size) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("shop_appid", shop_appid);
    reqJson.addProperty("promoter_id", promoter_id);
    reqJson.addProperty("promoter_type", promoter_type);
    reqJson.addProperty("next_key", next_key);
    reqJson.addProperty("page_size", page_size);
    String resJson = shopService.post("https://api.weixin.qq.com/channels/ec/promoter/get_shop_live_commission_product_list", reqJson);
    return ResponseUtils.decode(resJson, PromoterLiveProductListResponse.class);
  }

  @Override
  public PromoterLiveNoticeListResponse getLiveNoticeRecordList(String talent_appid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("talent_appid", talent_appid);
    String resJson = shopService.post("https://api.weixin.qq.com/channels/ec/promoter/get_live_notice_record_list", reqJson);
    return ResponseUtils.decode(resJson, PromoterLiveNoticeListResponse.class);
  }

  @Override
  public PromoterLiveNoticeListResponse getShopLiveNoticeRecordList(String shop_appid, String promoter_id, Integer promoter_type) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("shop_appid", shop_appid);
    reqJson.addProperty("promoter_id", promoter_id);
    reqJson.addProperty("promoter_type", promoter_type);
    String resJson = shopService.post("https://api.weixin.qq.com/channels/ec/promoter/get_shop_live_notice_record_list", reqJson);
    return ResponseUtils.decode(resJson, PromoterLiveNoticeListResponse.class);
  }

  @Override
  public PromoterLiveQrcodeResponse getLiveNoticeRecordQrcode(String talent_appid, String notice_id, String sharer_appid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("talent_appid", talent_appid);
    reqJson.addProperty("notice_id", notice_id);
    reqJson.addProperty("sharer_appid", sharer_appid);
    String resJson = shopService.post("https://api.weixin.qq.com/channels/ec/promoter/get_live_notice_record_qr_code", reqJson);
    return ResponseUtils.decode(resJson, PromoterLiveQrcodeResponse.class);
  }

  @Override
  public PromoterLiveQrcodeResponse getShopLiveNoticeRecordQrcode(String shop_appid, String promoter_id, Integer promoter_type, String notice_id, String sharer_appid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("shop_appid", shop_appid);
    reqJson.addProperty("promoter_id", promoter_id);
    reqJson.addProperty("promoter_type", promoter_type);
    reqJson.addProperty("notice_id", notice_id);
    reqJson.addProperty("sharer_appid", sharer_appid);
    String resJson = shopService.post("https://api.weixin.qq.com/channels/ec/promoter/get_shop_live_notice_record_qr_code", reqJson);
    return ResponseUtils.decode(resJson, PromoterLiveQrcodeResponse.class);
  }

  @Override
  public PromoterLiveListResponse getLiveRecordList(String talent_appid, String mini_program_appid, String sharer_appid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("talent_appid", talent_appid);
    reqJson.addProperty("mini_program_appid", mini_program_appid);
    reqJson.addProperty("sharer_appid", sharer_appid);
    String resJson = shopService.post("https://api.weixin.qq.com/channels/ec/promoter/get_live_record_list", reqJson);
    return ResponseUtils.decode(resJson, PromoterLiveListResponse.class);
  }

  @Override
  public PromoterLiveListResponse getShopLiveRecordList(String shop_appid, String promoter_id, Integer promoter_type, String mini_program_appid, String sharer_appid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("shop_appid", shop_appid);
    reqJson.addProperty("promoter_id", promoter_id);
    reqJson.addProperty("promoter_type", promoter_type);
    reqJson.addProperty("mini_program_appid", mini_program_appid);
    reqJson.addProperty("sharer_appid", sharer_appid);
    String resJson = shopService.post("https://api.weixin.qq.com/channels/ec/promoter/get_shop_live_record_list", reqJson);
    return ResponseUtils.decode(resJson, PromoterLiveListResponse.class);
  }

  @Override
  public PromoterLiveQrcodeResponse getLiveRecordQrcode(String talent_appid, String export_id, String sharer_appid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("talent_appid", talent_appid);
    reqJson.addProperty("export_id", export_id);
    reqJson.addProperty("sharer_appid", sharer_appid);
    String resJson = shopService.post("https://api.weixin.qq.com/channels/ec/promoter/get_live_record_qr_code", reqJson);
    return ResponseUtils.decode(resJson, PromoterLiveQrcodeResponse.class);
  }

  @Override
  public PromoterLiveQrcodeResponse getShopLiveRecordQrcode(String shop_appid, String promoter_id, Integer promoter_type, String export_id, String sharer_appid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("shop_appid", shop_appid);
    reqJson.addProperty("promoter_id", promoter_id);
    reqJson.addProperty("promoter_type", promoter_type);
    reqJson.addProperty("export_id", export_id);
    reqJson.addProperty("sharer_appid", sharer_appid);
    String resJson = shopService.post("https://api.weixin.qq.com/channels/ec/promoter/get_shop_live_record_qr_code", reqJson);
    return ResponseUtils.decode(resJson, PromoterLiveQrcodeResponse.class);
  }

  @Override
  public PromoterLiveShareLinkResponse getLiveNoticePromoterShareLink(String mini_program_appid, String talent_appid, String notice_id, String sharer_appid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("mini_program_appid", mini_program_appid);
    reqJson.addProperty("talent_appid", talent_appid);
    reqJson.addProperty("notice_id", notice_id);
    reqJson.addProperty("sharer_appid", sharer_appid);
    String resJson = shopService.post("https://api.weixin.qq.com/channels/ec/promoter/get_shop_live_record_qr_code", reqJson);
    return ResponseUtils.decode(resJson, PromoterLiveShareLinkResponse.class);
  }

  @Override
  public PromoterLiveShareLinkResponse getShopLiveNoticePromoterShareLink(String shop_appid, String promoter_id, Integer promoter_type, String notice_id, String sharer_appid) throws WxErrorException {
    JsonObject reqJson = new JsonObject();
    reqJson.addProperty("shop_appid", shop_appid);
    reqJson.addProperty("promoter_id", promoter_id);
    reqJson.addProperty("promoter_type", promoter_type);
    reqJson.addProperty("notice_id", notice_id);
    reqJson.addProperty("sharer_appid", sharer_appid);
    String resJson = shopService.post("https://api.weixin.qq.com/channels/ec/promoter/get_shop_live_notice_promoter_share_link", reqJson);
    return ResponseUtils.decode(resJson, PromoterLiveShareLinkResponse.class);
  }
}
