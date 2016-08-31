/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * 项目：study
 * 包名：xyz.mrwood.study
 * 功能：
 * 时间：2016-06-20 15:52
 * 作者：Mr.Kiwi
 */
public class TestJson {

    ThreadLocal threadLocal = new ThreadLocal();

    @Test
    public void testJson() {

        String jsonStr =
            "{\"appID\":\"2016041301039011\",\"body\":\"{\\\"response\\\":\\\"{\\\\\\\"status\\\\\\\":\\\\\\\"1\\\\\\\",\\\\\\\"count\\\\\\\":\\\\\\\"1000\\\\\\\",\\\\\\\"info\\\\\\\":\\\\\\\"OK\\\\\\\",\\\\\\\"infocode\\\\\\\":\\\\\\\"10000\\\\\\\",\\\\\\\"suggestion\\\\\\\":{\\\\\\\"keywords\\\\\\\":[],\\\\\\\"cities\\\\\\\":[]},\\\\\\\"pois\\\\\\\":[{\\\\\\\"id\\\\\\\":\\\\\\\"B0FFF02ZBH\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"益乐新村南区停车场\\\\\\\",\\\\\\\"tag\\\\\\\":[],\\\\\\\"type\\\\\\\":\\\\\\\"交通设施服务;停车场;公共停车场\\\\\\\",\\\\\\\"typecode\\\\\\\":\\\\\\\"150904\\\\\\\",\\\\\\\"biz_type\\\\\\\":[],\\\\\\\"address\\\\\\\":\\\\\\\"天目山路118附近\\\\\\\",\\\\\\\"location\\\\\\\":\\\\\\\"120.147337,30.274195\\\\\\\",\\\\\\\"tel\\\\\\\":[],\\\\\\\"postcode\\\\\\\":[],\\\\\\\"website\\\\\\\":[],\\\\\\\"email\\\\\\\":[],\\\\\\\"pcode\\\\\\\":\\\\\\\"330000\\\\\\\",\\\\\\\"pname\\\\\\\":\\\\\\\"浙江省\\\\\\\",\\\\\\\"citycode\\\\\\\":\\\\\\\"0571\\\\\\\",\\\\\\\"cityname\\\\\\\":\\\\\\\"杭州市\\\\\\\",\\\\\\\"adcode\\\\\\\":\\\\\\\"330106\\\\\\\",\\\\\\\"adname\\\\\\\":\\\\\\\"西湖区\\\\\\\",\\\\\\\"shopid\\\\\\\":[],\\\\\\\"gridcode\\\\\\\":\\\\\\\"4520312122\\\\\\\",\\\\\\\"distance\\\\\\\":\\\\\\\"15\\\\\\\",\\\\\\\"navi_poiid\\\\\\\":[],\\\\\\\"entr_location\\\\\\\":[],\\\\\\\"business_area\\\\\\\":\\\\\\\"西湖\\\\\\\",\\\\\\\"exit_location\\\\\\\":[],\\\\\\\"match\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"recommend\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"timestamp\\\\\\\":[],\\\\\\\"alias\\\\\\\":[],\\\\\\\"indoor_map\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"indoor_data\\\\\\\":{\\\\\\\"cpid\\\\\\\":[],\\\\\\\"floor\\\\\\\":[],\\\\\\\"truefloor\\\\\\\":[],\\\\\\\"cmsid\\\\\\\":[]},\\\\\\\"groupbuy_num\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"discount_num\\\\\\\":\\\\\\\"0\\\\\\\",\\\\\\\"biz_ext\\\\\\\":{\\\\\\\"rating\\\\\\\":[],\\\\\\\"cost\\\\\\\":[]},\\\\\\\"event\\\\\\\":[],\\\\\\\"children\\\\\\\":[],\\\\\\\"photos\\\\\\\":[]}]}\\\",\\\"httpCode\\\":200}\",\"charset\":\"utf-8\",\"code\":\"10000\",\"invokeID\":\"2016-06-20 15:42:44\",\"method\":\"alipay.openeco.apg.opgw.amapapi\",\"msg\":\"调用成功\",\"subCode\":\"10000\",\"subMsg\":\"Success\",\"timestamp\":\"2016-06-20 15:42:44\",\"token\":\"123456789000\",\"ver\":\"1.0\"}";

        System.err.println(parseStrToJson(jsonStr));
    }

    public static String parseStrToJson(String jsonStr) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        //        JSONObject body = jsonObject.getJSONObject("body");

        String body = jsonObject.getString("body");
        JSONObject response = JSON.parseObject(body);

        JSONObject responseJson = JSON.parseObject(response.getString("response"));

        JSONArray pois = responseJson.getJSONArray("pois");
        if (!pois.isEmpty()) {

            JSONObject poisA = pois.getJSONObject(0);
            String id = poisA.getString("id");

            return id;
        } else {

            return "";
        }
    }

    @Test
    public void testJsonOne() {


        String str =
            "{\"return_value\":{\"sub_merchant_id\":\"20160831111640028849\",\"external_id\":\"1\",\"name\":\"杭州首展科技\",\"alias_name\":\"首展科技\",\"service_phone\":\"15537-541920\",\"category_id\":\"2015050700000001\",\"liquidator_name\":\"测试组专用\"},\"success\":true}\n";

//        JSONObject jsonObject = JSON.parseObject(str);
//        JSONObject return_value = jsonObject.getJSONObject("return_value");
//        String sub_merchant_id = return_value.getString("sub_merchant_id");
//        System.err.println(sub_merchant_id);

        System.err.println(getValue(str, "sub_merchant_id"));

    }


    public String getValue(String jsonStr, String key) {

        JSONObject jsonObject = JSON.parseObject(jsonStr);
        JSONObject return_value = jsonObject.getJSONObject("return_value");
        if (return_value == null) {

            return "";
        }
        return return_value.getString(key);
    }
}
