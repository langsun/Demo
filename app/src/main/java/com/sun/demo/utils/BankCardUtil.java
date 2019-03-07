package com.sun.demo.utils;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * 参考： http://blog.csdn.net/yqwang75457/article/details/72627542
 * 调用的是支付宝的api地址，完全免费，获取的银行也是支付宝接口中的所有银行
 * <p>
 * Created by sun on 18/7/11.
 */

public class BankCardUtil {
    private static String TAG = "BankCardUtil";

    /**
     * @param cardNo 银行卡卡号  如：6217002440003397312
     * @return {"bank":"CMB","validated":true,"cardType":"DC","key":"(卡号)","messages":[],"stat":"ok"}
     * 2017年5月22日 下午4:35:23
     */
    public static String getCardDetail(String cardNo) {
        // 创建HttpClient实例
        String url = "https://ccdcapi.alipay.com/validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo=";
        url += cardNo;
        url += "&cardBinCheck=true";
        StringBuilder sb = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String getBankCode(String cardNo) {
        // 创建HttpClient实例
        String cardDetail = getCardDetail(cardNo);
        Gson gson = new Gson();
        ValidatedBean validatedBean = gson.fromJson(cardDetail, ValidatedBean.class);
        if (validatedBean.isValidated()) {
            BankCardBean bankCardBean = gson.fromJson(cardDetail, BankCardBean.class);
            return bankCardBean.getBank();
        } else {
            Log.e(TAG, "getBankCode(cardNo)返回空");
            return "";
        }

    }


    /**
     * @param cardNo 银行卡卡号  如：6217002440003397312
     * @return 银行名称
     */
    public static String getBankName(String cardNo) {
        Map<String, String> map = new HashMap<>();
        map.put("SRCB", "深圳农村商业银行");
        map.put("BGB", "广西北部湾银行");
        map.put("SHRCB", "上海农村商业银行");
        map.put("BJBANK", "北京银行");
        map.put("WHCCB", "威海市商业银行");
        map.put("BOZK", "周口银行");
        map.put("KORLABANK", "库尔勒市商业银行");
        map.put("SPABANK", "平安银行");
        map.put("SDEB", "顺德农商银行");
        map.put("HURCB", "湖北省农村信用社");
        map.put("WRCB", "无锡农村商业银行");
        map.put("BOCY", "朝阳银行");
        map.put("CZBANK", "浙商银行");
        map.put("HDBANK", "邯郸银行");
        map.put("BOC", "中国银行");
        map.put("BOD", "东莞银行");
        map.put("CCB", "中国建设银行");
        map.put("ZYCBANK", "遵义市商业银行");
        map.put("SXCB", "绍兴银行");
        map.put("GZRCU", "贵州省农村信用社");
        map.put("ZJKCCB", "张家口市商业银行");
        map.put("BOJZ", "锦州银行");
        map.put("BOP", "平顶山银行");
        map.put("HKB", "汉口银行");
        map.put("SPDB", "上海浦东发展银行");
        map.put("NXRCU", "宁夏黄河农村商业银行");
        map.put("NYNB", "广东南粤银行");
        map.put("GRCB", "广州农商银行");
        map.put("BOSZ", "苏州银行");
        map.put("HZCB", "杭州银行");
        map.put("HSBK", "衡水银行");
        map.put("HBC", "湖北银行");
        map.put("JXBANK", "嘉兴银行");
        map.put("HRXJB", "华融湘江银行");
        map.put("BODD", "丹东银行");
        map.put("AYCB", "安阳银行");
        map.put("EGBANK", "恒丰银行");
        map.put("CDB", "国家开发银行");
        map.put("TCRCB", "江苏太仓农村商业银行");
        map.put("NJCB", "南京银行");
        map.put("ZZBANK", "郑州银行");
        map.put("DYCB", "德阳商业银行");
        map.put("YBCCB", "宜宾市商业银行");
        map.put("SCRCU", "四川省农村信用");
        map.put("KLB", "昆仑银行");
        map.put("LSBANK", "莱商银行");
        map.put("YDRCB", "尧都农商行");
        map.put("CCQTGB", "重庆三峡银行");
        map.put("FDB", "富滇银行");
        map.put("JSRCU", "江苏省农村信用联合社");
        map.put("JNBANK", "济宁银行");
        map.put("CMB", "招商银行");
        map.put("JINCHB", "晋城银行JCBANK");
        map.put("FXCB", "阜新银行");
        map.put("WHRCB", "武汉农村商业银行");
        map.put("HBYCBANK", "湖北银行宜昌分行");
        map.put("TZCB", "台州银行");
        map.put("TACCB", "泰安市商业银行");
        map.put("XCYH", "许昌银行");
        map.put("CEB", "中国光大银行");
        map.put("NXBANK", "宁夏银行");
        map.put("HSBANK", "徽商银行");
        map.put("JJBANK", "九江银行");
        map.put("NHQS", "农信银清算中心");
        map.put("MTBANK", "浙江民泰商业银行");
        map.put("LANGFB", "廊坊银行");
        map.put("ASCB", "鞍山银行");
        map.put("KSRB", "昆山农村商业银行");
        map.put("YXCCB", "玉溪市商业银行");
        map.put("DLB", "大连银行");
        map.put("DRCBCL", "东莞农村商业银行");
        map.put("GCB", "广州银行");
        map.put("NBBANK", "宁波银行");
        map.put("BOYK", "营口银行");
        map.put("SXRCCU", "陕西信合");
        map.put("GLBANK", "桂林银行");
        map.put("BOQH", "青海银行");
        map.put("CDRCB", "成都农商银行");
        map.put("QDCCB", "青岛银行");
        map.put("HKBEA", "东亚银行");
        map.put("HBHSBANK", "湖北银行黄石分行");
        map.put("WZCB", "温州银行");
        map.put("TRCB", "天津农商银行");
        map.put("QLBANK", "齐鲁银行");
        map.put("GDRCC", "广东省农村信用社联合社");
        map.put("ZJTLCB", "浙江泰隆商业银行");
        map.put("GZB", "赣州银行");
        map.put("GYCB", "贵阳市商业银行");
        map.put("CQBANK", "重庆银行");
        map.put("DAQINGB", "龙江银行");
        map.put("CGNB", "南充市商业银行");
        map.put("SCCB", "三门峡银行");
        map.put("CSRCB", "常熟农村商业银行");
        map.put("SHBANK", "上海银行");
        map.put("JLBANK", "吉林银行");
        map.put("CZRCB", "常州农村信用联社");
        map.put("BANKWF", "潍坊银行");
        map.put("ZRCBANK", "张家港农村商业银行");
        map.put("FJHXBC", "福建海峡银行");
        map.put("ZJNX", "浙江省农村信用社联合社");
        map.put("LZYH", "兰州银行");
        map.put("JSB", "晋商银行");
        map.put("BOHAIB", "渤海银行");
        map.put("CZCB", "浙江稠州商业银行");
        map.put("YQCCB", "阳泉银行");
        map.put("SJBANK", "盛京银行");
        map.put("XABANK", "西安银行");
        map.put("BSB", "包商银行");
        map.put("JSBANK", "江苏银行");
        map.put("FSCB", "抚顺银行");
        map.put("HNRCU", "河南省农村信用");
        map.put("COMM", "交通银行");
        map.put("XTB", "邢台银行");
        map.put("CITIC", "中信银行");
        map.put("HXBANK", "华夏银行");
        map.put("HNRCC", "湖南省农村信用社");
        map.put("DYCCB", "东营市商业银行");
        map.put("ORBANK", "鄂尔多斯银行");
        map.put("BJRCB", "北京农村商业银行");
        map.put("XYBANK", "信阳银行");
        map.put("ZGCCB", "自贡市商业银行");
        map.put("CDCB", "成都银行");
        map.put("HANABANK", "韩亚银行");
        map.put("CMBC", "中国民生银行");
        map.put("LYBANK", "洛阳银行");
        map.put("GDB", "广东发展银行");
        map.put("ZBCB", "齐商银行");
        map.put("CBKF", "开封市商业银行");
        map.put("H3CB", "内蒙古银行");
        map.put("CIB", "兴业银行");
        map.put("CRCBANK", "重庆农村商业银行");
        map.put("SZSBK", "石嘴山银行");
        map.put("DZBANK", "德州银行");
        map.put("SRBANK", "上饶银行");
        map.put("LSCCB", "乐山市商业银行");
        map.put("JXRCU", "江西省农村信用");
        map.put("ICBC", "中国工商银行");
        map.put("JZBANK", "晋中市商业银行");
        map.put("HZCCB", "湖州市商业银行");
        map.put("NHB", "南海农村信用联社");
        map.put("XXBANK", "新乡银行");
        map.put("JRCB", "江苏江阴农村商业银行");
        map.put("YNRCC", "云南省农村信用社");
        map.put("ABC", "中国农业银行");
        map.put("GXRCU", "广西省农村信用");
        map.put("PSBC", "中国邮政储蓄银行");
        map.put("BZMD", "驻马店银行");
        map.put("ARCU", "安徽省农村信用社");
        map.put("GSRCU", "甘肃省农村信用");
        map.put("LYCB", "辽阳市商业银行");
        map.put("JLRCU", "吉林农信");
        map.put("URMQCCB", "乌鲁木齐市商业银行");
        map.put("XLBANK", "中山小榄村镇银行");
        map.put("CSCB", "长沙银行");
        map.put("JHBANK", "金华银行");
        map.put("BHB", "河北银行");
        map.put("NBYZ", "鄞州银行");
        map.put("LSBC", "临商银行");
        map.put("BOCD", "承德银行");
        map.put("SDRCU", "山东农信");
        map.put("NCB", "南昌银行");
        map.put("TCCB", "天津银行");
        map.put("WJRCB", "吴江农商银行");
        map.put("CBBQS", "城市商业银行资金清算中心");
        map.put("HBRCU", "河北省农村信用社");

        String bankCode = getBankCode(cardNo);
        if (TextUtils.isEmpty(bankCode)) {
            Log.e(TAG, "getBankCode(cardNo)返回空");
            return "";
        } else {
            if (map.containsKey(bankCode)) {
                String bankName = map.get(bankCode);
                return bankName;
            } else {
                Log.e(TAG, "getBankName(cardNo)返回空");
                return "";
            }
        }
    }

    /**
     * @param cardNo 银行卡卡号  如：6217002440003397312
     * @return icon的url，String类型的Url
     */
    public static String getBankIconUrl(String cardNo) {
        if (TextUtils.isEmpty(getBankCode(cardNo))) {
            Log.e(TAG, "getBankCode(cardNo)返回空");
            return "";
        } else {
            return "https://apimg.alipay.com/combo.png?d=cashier&t=" + getBankCode(cardNo);
        }
    }

    class ValidatedBean {
        private boolean validated;

        public ValidatedBean(boolean validated) {
            this.validated = validated;
        }

        public boolean isValidated() {
            return validated;
        }
    }


    class BankCardBean {
        private String bank;
        private boolean validated;
        private String cardType;
        private String key;
        private Object messages;
        private String stat;

        public BankCardBean(String bank, boolean validated, String cardType, String key, Array messages, String stat) {
            this.bank = bank;
            this.validated = validated;
            this.cardType = cardType;
            this.key = key;
            this.messages = messages;
            this.stat = stat;
        }

        public String getBank() {
            return bank;
        }

        public boolean isValidated() {
            return validated;
        }

        public String getCardType() {
            return cardType;
        }

        public String getKey() {
            return key;
        }

        public Object getMessages() {
            return messages;
        }

        public String getStat() {
            return stat;
        }
    }


}
