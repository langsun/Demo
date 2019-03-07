package com.sun.demo.utils;

/**
 * Created by sun on 17/12/15.
 */

public class Constants {

    //SP字段
    public static final String SP_IS_NOT_FIRST_START = "sp_is_not_first_start";
    public static final String SP_USER_INFO = "sp_user_info";
    public static final String SP_BANK_TYPE_LIST = "sp_bank_type_list";
    public static final String SP_DCB_BETTING_LIST = "sp_dcb_betting_list";//双色球支付页面保存已选的球的list
    public static final String SP_BIG_LOTTERY_BETTING_LIST = "sp_big_lottery_betting_list";//大乐透支付页面保存已选的球的list
    public static final String SP_FU_CAI_BETTING_LIST = "sp_fu_cai_betting_list";//福彩3d和排列三支付页面保存已选的球的list
    public static final String SP_CQSSC_BETTING_LIST = "sp_cqssc_betting_list";//重庆时时彩支付页面保存已选的球的list
    public static final String SP_ELEVEN_FIVE_BETTING_LIST = "sp_eleven_five_betting_list";//十一选五支付页面保存已选的球的list
    public static final String SP_TR9_BETTING_LIST = "sp_tr9_betting_list";//任选九支付页面保存已选的球的list
    public static final String SP_T14C_BETTING_LIST = "sp_t14c_betting_list";//胜负14场支付页面保存已选的球的list
    public static final String SP_QF_ONE_BETTING_LIST = "sp_qf_one_betting_list";//竞彩足球胜负场支付页面保存已选的球的list
    public static final String SP_QF_TWO_BETTING_LIST = "sp_qf_two_betting_list";//竞彩足球让球胜负场支付页面保存已选的球的list
    public static final String SP_QF_THREE_BETTING_LIST = "sp_qf_three_betting_list";//竞彩足球比分支付页面保存已选的球的list
    public static final String SP_QF_FOUR_BETTING_LIST = "sp_qf_four_betting_list";//竞彩足球总进球支付页面保存已选的球的list
    public static final String SP_QF_FIVE_BETTING_LIST = "sp_qf_five_betting_list";//竞彩足球半全场支付页面保存已选的球的list
    public static final String SP_QF_SIX_BETTING_LIST = "sp_qf_six_betting_list";//竞彩足球混合支付页面保存已选的球的list
    public static final String SP_BJDC_BETTING_LIST = "sp_bjdc_betting_list";//北京单场支付页面保存已选的球的list
    public static final String SP_QB_ONE_BETTING_LIST = "sp_qb_one_betting_list";//篮球胜负支付页面保存已选的球的list
    public static final String SP_QB_TWO_BETTING_LIST = "sp_qb_two_betting_list";//篮球让球胜负支付页面保存已选的球的list
    public static final String SP_QB_THREE_BETTING_LIST = "sp_qb_three_betting_list";//篮球大小分支付页面保存已选的球的list
    public static final String SP_QB_FOUR_BETTING_LIST = "sp_qb_four_betting_list";//篮球胜分差支付页面保存已选的球的list
    public static final String SP_QB_FIVE_BETTING_LIST = "sp_qb_five_betting_list";//篮球混合过关支付页面保存已选的球的list

    //选择场次上限处理
    public static final int SP_SELECTED_NUM_BJDC = 15;//用于北京单场上限
    public static final int SP_SELECTED_NUM_LQ_ZQ = 10;//用于篮球足球上限
    public static final String SP_QF_ONE_SELECTED_NUM = "sp_qf_one_selected_num";//竞彩足球胜负场已选择场次数量
    public static final String SP_QF_TWO_SELECTED_NUM = "sp_qf_two_selected_num";//竞彩足球让球胜负场已选择场次数量
    public static final String SP_QF_THREE_SELECTED_NUM = "sp_qf_three_selected_num";//竞彩足球比分已选择场次数量
    public static final String SP_QF_FOUR_SELECTED_NUM = "sp_qf_four_selected_num";//竞彩足球总进球已选择场次数量
    public static final String SP_QF_FIVE_SELECTED_NUM = "sp_qf_five_selected_num";//竞彩足球半全场已选择场次数量
    public static final String SP_QF_SIX_SELECTED_NUM = "sp_qf_six_selected_num";//竞彩足球混合已选择场次数量
    public static final String SP_BJDC_SELECTED_NUM = "sp_bjdc_selected_num";//北京单场已选择场次数量
    public static final String SP_QB_ONE_SELECTED_NUM = "sp_qb_one_selected_num";//篮球胜负已选择场次数量
    public static final String SP_QB_TWO_SELECTED_NUM = "sp_qb_two_selected_num";//篮球让球胜负已选择场次数量
    public static final String SP_QB_THREE_SELECTED_NUM = "sp_qb_three_selected_num";//篮球大小分已选择场次数量
    public static final String SP_QB_FOUR_SELECTED_NUM = "sp_qb_four_selected_num";//篮球胜分差已选择场次数量
    public static final String SP_QB_FIVE_SELECTED_NUM = "sp_qb_five_selected_num";//篮球混合投注已选择场次数量

    //数据的缓存
    public static final String SP_BONUS_LIST = "sp_bonus_list";//bonusList
    public static final String SP_BANNER_LIST = "sp_banner_list";//bannerList
    public static final String SP_IMAGE_URL_LIST = "sp_image_url_list";//启动页URl
    public static final String SP_ABOUT_BIG_PRIZE_IMAGE = "sp_about_big_prize_image";//关于大奖图片
    public static final String SP_ABOUT_BIG_PRIZE_DESC = "sp_about_big_prize_desc";//关于大奖描述
    public static final String SP_APP_RECHARGE_ACTIVITY_URL = "sp_app_recharge_activity_url";//充值活动
    public static final String SP_APP_NORMAL_SHARE_ABLE = "sp_app_normal_share_able";//是否可以分享
    public static final String SP_HEMAI_HELP_PAGE = "sp_hemai_help_page";//合买帮助页
    public static final String SP_NEW_COMER_HELP_PAGE = "sp_new_comer_help_page";//新手帮助页
    public static final String SP_GAME_LIST_DATA1 = "sp_game_list_data1";//电玩城游戏列表缓存
    public static final String SP_GAME_LIST_DATA2 = "sp_game_list_data2";//街机游戏列表缓存
    public static final String SP_GAME_LIST_DATA3 = "sp_game_list_data3";//彩票小游戏游戏列表缓存

    public static final String SP_IS_ALREADY_PLAY_GAME = "sp_is_already_play_game";//是否已经玩过游戏了，玩过了就不用引导了
    public static final String SP_IS_BUY_CQSSC = "sp_is_buy_cqssc";//重庆时时彩引导
    public static final String SP_MGGAMETYPE0 = "sp_mggametype0";//  "MGGameType": 0,是否可以玩，false不可以玩，true可以
    public static final String SP_MGGAMETYPE_MSG0 = "sp_mggametype_msg0";//  不可玩提示文案
    public static final String SP_MGGAMETYPE1 = "sp_mggametype1";//  "MGGameType": 1,是否可以玩，false不可以玩，true可以
    public static final String SP_MGGAMETYPE_MSG1 = "sp_mggametype_msg1";//  不可玩提示文案
    public static final String SP_GAME_PLAY_RULE_BJPK = "sp_game_play_rule_bjpk";//  北京pk10玩法说明
    public static final String SP_GAME_PLAY_RULE_FFSSC = "sp_game_play_rule_ffssc";//  纷纷时时彩玩法说明
    public static final String SP_GAME_PLAY_RULE_LHC = "sp_game_play_rule_lhc";//  六合彩玩法说明




    public static final String SP_DATE = "sp_date";//储存今天的日期，用于送红包


    public static final String SP_SCORE_URL = "sp_score_url";//scoreUrl

    public static final String SP_IS_BUY_AGAIN = "sp_is_buy_again";//是否是继续购彩


    //Intent字段
    public static final String IS_FU_CAI_3D = "is_fu_cai_3d";
    public static final String ELEVEN_SELECT_FIVE_TAG = "eleven_select_five_tag";
    public static final String ELEVEN_SELECT_ISSUE_NUM = "eleven_select_issue_num";
    public static final String GUANG_DONG = "GD11X5";
    public static final String SHAN_DONG = "SD11X5";
    public static final String JIANG_XI = "JX11X5";

    public static final String ELEVEN_SELECT_FIVE_LOTTERY_TYPE = "eleven_select_five_lottery_type";


    public static final String HOME_FRAGMENT_REFRESH_TIME = "home_fragment_refresh_time";

    //登录用于保存用户名和密码
    public static final String USER_PHONE = "user_phone";
    public static final String USER_PASSWORD = "user_password";

    //区分哪一种数字彩
    public static final String LOTTERY_TYPE = "number_lottery_type";
    public static final String LOTTERY_CODE = "number_lottery_code";

    public static final String LOTTERY_SCHEME_ID = "lottery_scheme_id";

    public static final String QF_TYPE = "qf_type";
    public static final String QB_TYPE = "qb_type";


    public static final String CQ_TIME_LOTTERY_TICKET_DATA = "cq_time_lottery_ticket_data";
    public static final String CQ_TIME_LOTTERY_ISSUE_NUM = "cq_time_lottery_issue_num";
    public static final String QF_DATA = "QF_DATA";
    public static final String QF_TB = "qf_tb";//投倍


    public static final String NOTICE_ID = "notice_id";
    public static final String MAIL_ID = "mail_id";

    //双色球购买球码

    public static final String SELECTED_NUM_DCB = "selected_num_dcb";//双色球支付列表bean
    public static final String SELECTED_NUM_DCB_BETTING_ISSUE = "selected_num_dcb_betting_issue";//双色球当前期号
    public static final String SELECTED_NUM_DCB_PAYMENT_BEAN = "selected_num_dcb_payment_bean";//双色球最终支付Bean
    public static final String SELECTED_NUM_DIG_LOTTERY = "selected_num_dig_lottery";//大乐透
    public static final String SELECTED_NUM_DIG_LOTTERY_BETTING_ISSUE = "selected_num_dig_lottery_betting_issue";//大乐透当前期号
    public static final String SELECTED_NUM_FU_CAI = "selected_num_fu_cai";//福彩3d
    public static final String SELECTED_NUM_FU_CAI_BETTING_ISSUE = "selected_num_fu_cai_betting_issue";//福彩3d期号
    public static final String SELECTED_NUM_ELEVEN_FIVE_BEAN = "selected_num_eleven_five_bean";//十一选五支付列表bean
    public static final String SELECTED_NUM_TR9_BEAN_LIST = "selected_num_tr9_bean_list";//任选九Bean的list
    public static final String SELECTED_NUM_TR9_BETTING_ISSUE = "selected_num_tr9_betting_issue";//任选九当前期号
    public static final String SELECTED_NUM_TR9_PAYMENT_BEAN = "selected_num_tr9_payment_bean";//任选九最终支付Bean
    public static final String SELECTED_NUM_T14C_BEAN_LIST = "selected_num_t14c_bean_list";//胜负14场Bean的list
    public static final String SELECTED_NUM_T14C_BETTING_ISSUE = "selected_num_t14c_betting_issue";//胜负14场当前期号
    public static final String SELECTED_NUM_T14C_PAYMENT_BEAN = "selected_num_t14c_payment_bean";//胜负14场最终支付Bean


    public static final String PAYMENT_MONEY = "payment_money";//支付所需钱


    //refresh And LoadMore
    public static final int DATA_COMMON_LOAD = 0;//数据正常加载，通常是第一次进入，或者没有获取到数据后的再次加载
    public static final int DATA_REFRESH = 1;//数据刷新
    public static final int DATA_LOAD_MORE = 2;//数据加载更多
    public static final int DATA_COMMON_NOT_LOAD = 3;//数据正常加载，通常是第一次进入，或者没有获取到数据后的再次加载   但是不显示loading


    public static final String GAME_TYPE = "game_type";
    public static final String GAME_CODE = "game_code";

    public static final String GAME_QCSSC = "CQSSC";//重庆时时彩
    public static final String GAME_GD11X5 = "GD11X5";//重庆时时彩
    public static final String GAME_SD11X5 = "SD11X5";//重庆时时彩
    public static final String GAME_JX11X5 = "JX11X5";//重庆时时彩
    public static final String GAME_SSQ = "SSQ";//重庆时时彩
    public static final String GAME_DLT = "DLT";//重庆时时彩
    public static final String GAME_FC3D = "FC3D";//重庆时时彩
    public static final String GAME_PL3 = "PL3";//重庆时时彩
    public static final String GAME_SDKLPK3 = "SDKLPK3";//山东快乐扑克3
    public static final String GAME_GDKLSF = "GDKLSF";//广东快乐十分
    public static final String GAME_JSKS = "JSKS";//江苏快三
    public static final String GAME_BJDC = "BJDC";//北京单场
    public static final String GAME_JCLQ = "JCLQ";//精彩篮球
    public static final String GAME_JCZQ = "JCZQ";//精彩足球
    public static final String GAME_TR9 = "TR9";//任选9
    public static final String GAME_T14C = "T14C";//胜负14场
    public static final String GAME_T6BQC = "T6BQC";//六场半全场
    public static final String GAME_T4CJQ = "T4CJQ";//四场全进球
    public static final String GAME_CTZQ = "CTZQ";//四场全进球
    public static final String GAME_BJPK10 = "BJPK10";//北京pk10
    public static final String GAME_FFSSC = "FFSSC";//分分时时彩
    public static final String GAME_HK6 = "HK6";//香港6合菜
    public static final String GAME_CQSSC = "CQSSC";//重庆时时彩
    public static final String GAME_PK10 = "PK10";//重庆时时彩


    public static final String LOTTERY_TYPE_ZSHY = "ZSHY";//最受欢迎
    public static final String LOTTERY_TYPE_GPCP = "GPCP";//高频彩票
    public static final String LOTTERY_TYPE_YXPD = "YXPD";//游戏频道
    public static final String LOTTERY_TYPE_JJCP = "JJCP";//竞技彩票
    public static final String LOTTERY_TYPE_SZCP = "SZCP";//数字彩票


    public static final String ORDER_DETAIL_SCHEME_ID = "order_detail_scheme_id";//投注详情页的id
    public static final String PRIZE_TYPE = "prize_type";//开奖类别
    public static final String PRIZE_ISSUE = "prize_issue";//开奖期号
    public static final String PRIZE_DATE = "prize_date";//开奖日期
    public static final String PRIZE_SELECTED_NUM = "prize_selected_num";//开奖号码


    public static final String WEBVIEW_URL = "webview_url";//webview   Url
    public static final String WEBVIEW_DATA = "webview_data";//webview   Url
    public static final String WEBVIEW_TITLE = "webview_title";//webview   Url


    //队伍名字显示不全时，截取长度
    public static final int NAME_LENGTH = 4;

    public static final String WITHDRAW_NUM = "withdraw_num";//提现的账号
    public static final String WITHDRAW_MONEY = "withdraw_money";//提现的钱
    public static final String REAL_MONEY = "real_money";//到手的钱
    public static final String PAY_MONEY = "pay_money";//手续费


    public static final String HOME_INDEX = "home_index";//0Home，1Prize，2score，3person
    public static final String HOME_TYPE = "home_type";//需要token的地方触发登录，登录玩需要finish

    public static final String RECHARGE_MONEY = "RECHARGE_MONEY";//充值的钱


    public static final String GAME_NUMBER = "game_number";//选择的 场次，合买的时候需要
    public static final String PAYMENT_BUY_TOGETHER_ORDER_BEAN = "payment_buy_together_order_bean";//合买支付的bean


    public static final String NEWS_ID = "news_id";//新闻id
    public static final String IS_SET_BALANCE_PWD = "is_set_balance_pwd";//是否已经设置资金密码
    public static final String BALANCE_PWD = "balance_pwd";//已经设置资金密码,设置了哪一种或者两种




    public static final String BALL_EVENT_DLT1 = "ball_event_dlt1";
    public static final String BALL_EVENT_DLT2 = "ball_event_dlt2";
    public static final String MARK_SIX_LOTTERY_OREDE_DETAIL = "mark_six_lottery_orede_detail";
    public static final String MARK_SIX_LOTTERY_BETTING_LIST = "mark_six_lottery_betting_list";


    public static boolean HOME_THREAD_STOP_TAG = true;//首页线程停止标志

}
