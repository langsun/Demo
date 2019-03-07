package com.sun.demo.network.service.data.bean;

import java.util.List;

/**
 * Created by sun on 19/3/5.
 */

public class HomeDataBean {

    /**
     * GameShow : [{"gameList":[{"gameShowName":"分分时时彩","gameCode":"FFSSC","gameNeedTime":true,"gamePlatform":"GPCP","gameCategory":"","gameIcon":"","gameStopTime":"2019-03-05 10:26:45"},{"gameShowName":"重庆时时彩(传统)","gameCode":"CQSSC","gameNeedTime":true,"gamePlatform":"GPCP","gameCategory":"","gameIcon":"","gameStopTime":"2019-03-05 10:29:00"},{"gameShowName":"竞彩足球","gameCode":"JCZQ","gameNeedTime":false,"gamePlatform":"JJCP","gameCategory":"","gameIcon":"","gameStopTime":""},{"gameShowName":"幸运888","gameCode":"18","gameNeedTime":false,"gamePlatform":"JJCP","gameCategory":"","gameIcon":"https://img.jiangkk.com/jiang/images/gamelogo/xy888.png","gameStopTime":""},{"gameShowName":"真人游戏","gameCode":"-1","gameNeedTime":false,"gamePlatform":"YXPD","gameCategory":"3","gameIcon":"http://222.186.160.43:788/images/gamelogo/AG_Game.png","gameStopTime":""}],"platform_ShowName":"最受欢迎","platform_Code":"ZSHY"},{"gameList":[{"gameShowName":"分分时时彩","gameCode":"FFSSC","gameNeedTime":true,"gamePlatform":"GPCP","gameCategory":"","gameIcon":"","gameStopTime":"2019-03-05 10:26:45"},{"gameShowName":"重庆时时彩(传统)","gameCode":"CQSSC","gameNeedTime":true,"gamePlatform":"GPCP","gameCategory":"","gameIcon":"","gameStopTime":"2019-03-05 10:29:00"},{"gameShowName":"北京赛车","gameCode":"PK10","gameNeedTime":true,"gamePlatform":"GPCP","gameCategory":"","gameIcon":"","gameStopTime":"2019-03-05 10:30:00"},{"gameShowName":"江西11选5","gameCode":"JX11X5","gameNeedTime":true,"gamePlatform":"GPCP","gameCategory":"","gameIcon":"","gameStopTime":"2019-03-05 10:29:00"},{"gameShowName":"广东11选5","gameCode":"GD11X5","gameNeedTime":true,"gamePlatform":"GPCP","gameCategory":"","gameIcon":"","gameStopTime":"2019-03-05 10:29:00"},{"gameShowName":"山东11选5","gameCode":"SD11X5","gameNeedTime":true,"gamePlatform":"GPCP","gameCategory":"","gameIcon":"","gameStopTime":"2019-03-05 10:40:00"}],"platform_ShowName":"高频彩票","platform_Code":"GPCP"},{"gameList":[{"gameShowName":"幸运888","gameCode":"18","gameNeedTime":false,"gamePlatform":"YXPD","gameCategory":"2","gameIcon":"https://img.jiangkk.com/jiang/images/gamelogo/xy888.png","gameStopTime":""},{"gameShowName":"真人游戏","gameCode":"-1","gameNeedTime":false,"gamePlatform":"YXPD","gameCategory":"3","gameIcon":"http://222.186.160.43:788/images/gamelogo/AG_Game.png","gameStopTime":""},{"gameShowName":"香港六合彩","gameCode":"HK6","gameNeedTime":false,"gamePlatform":"YXPD","gameCategory":"10","gameIcon":"https://img.jiangkk.com/jiang/images/gamelogo/hk6.png","gameStopTime":""}],"platform_ShowName":"游戏频道","platform_Code":"YXPD"},{"gameList":[{"gameShowName":"竞彩足球","gameCode":"JCZQ","gameNeedTime":false,"gamePlatform":"JJCP","gameCategory":"","gameIcon":"","gameStopTime":""},{"gameShowName":"竞彩篮球","gameCode":"JCLQ","gameNeedTime":false,"gamePlatform":"JJCP","gameCategory":"","gameIcon":"","gameStopTime":""},{"gameShowName":"北京单场","gameCode":"BJDC","gameNeedTime":false,"gamePlatform":"JJCP","gameCategory":"","gameIcon":"","gameStopTime":""},{"gameShowName":"胜负14场","gameCode":"T14C","gameNeedTime":false,"gamePlatform":"JJCP","gameCategory":"","gameIcon":"","gameStopTime":""},{"gameShowName":"任选9","gameCode":"TR9","gameNeedTime":false,"gamePlatform":"JJCP","gameCategory":"","gameIcon":"","gameStopTime":""}],"platform_ShowName":"竞技彩票","platform_Code":"JJCP"},{"gameList":[{"gameShowName":"双色球","gameCode":"SSQ","gameNeedTime":false,"gamePlatform":"SZCP","gameCategory":"","gameIcon":"","gameStopTime":""},{"gameShowName":"大乐透","gameCode":"DLT","gameNeedTime":false,"gamePlatform":"SZCP","gameCategory":"","gameIcon":"","gameStopTime":""},{"gameShowName":"福彩3D","gameCode":"FC3D","gameNeedTime":false,"gamePlatform":"SZCP","gameCategory":"","gameIcon":"","gameStopTime":""},{"gameShowName":"排列3","gameCode":"PL3","gameNeedTime":false,"gamePlatform":"SZCP","gameCategory":"","gameIcon":"","gameStopTime":""}],"platform_ShowName":"数字彩票","platform_Code":"SZCP"}]
     * ServiceTime : 2019-03-05 10:26:25
     */

    public String ServiceTime;
    public List<GameShowBean> GameShow;


    public static class GameShowBean {
        /**
         * gameList : [{"gameShowName":"分分时时彩","gameCode":"FFSSC","gameNeedTime":true,"gamePlatform":"GPCP","gameCategory":"","gameIcon":"","gameStopTime":"2019-03-05 10:26:45"},{"gameShowName":"重庆时时彩(传统)","gameCode":"CQSSC","gameNeedTime":true,"gamePlatform":"GPCP","gameCategory":"","gameIcon":"","gameStopTime":"2019-03-05 10:29:00"},{"gameShowName":"竞彩足球","gameCode":"JCZQ","gameNeedTime":false,"gamePlatform":"JJCP","gameCategory":"","gameIcon":"","gameStopTime":""},{"gameShowName":"幸运888","gameCode":"18","gameNeedTime":false,"gamePlatform":"JJCP","gameCategory":"","gameIcon":"https://img.jiangkk.com/jiang/images/gamelogo/xy888.png","gameStopTime":""},{"gameShowName":"真人游戏","gameCode":"-1","gameNeedTime":false,"gamePlatform":"YXPD","gameCategory":"3","gameIcon":"http://222.186.160.43:788/images/gamelogo/AG_Game.png","gameStopTime":""}]
         * platform_ShowName : 最受欢迎
         * platform_Code : ZSHY
         */

        public String platform_ShowName;
        public String platform_Code;
        public List<GameListBean> gameList;


        public static class GameListBean {
            /**
             * gameShowName : 分分时时彩
             * gameCode : FFSSC
             * gameNeedTime : true
             * gamePlatform : GPCP
             * gameCategory :
             * gameIcon :
             * gameStopTime : 2019-03-05 10:26:45
             */

            public String gameShowName;
            public String gameCode;
            public boolean gameNeedTime;
            public String gamePlatform;
            public String gameCategory;
            public String gameIcon;
            public String gameStopTime;


        }
    }
}
