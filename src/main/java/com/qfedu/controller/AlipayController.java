package com.qfedu.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.sun.deploy.net.HttpResponse;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Created by 54110 on 2020/8/19.
 */
@RestController
@CrossOrigin
public class AlipayController {

    @RequestMapping("/pay/{pstatus}")
    @ResponseBody
    public   String   pay (HttpServletRequest httpRequest,
                           HttpServletResponse httpResponse, @PathVariable int pstatus)   throws ServletException, IOException {
        AlipayClient alipayClient =  new DefaultAlipayClient( "https://openapi.alipaydev.com/gateway.do","2021000118686668", "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDktIlnjqhvWLJ4CjqIuNNeLj0AbovdEarNSltl07PqJGEOXM9LmuTttav1h52cn9UUBhAaSNWuaP2pO2+0z42g9ZZ9IKPNWB30idO1p9Dd7BbqPZHLJSylh+R9fkAENjnizj1BsFVUPHhSXDa/g+qfA+Fmkw18W+relXPygJdg5Kg8FHZiJwl/EEO5bPpKWLgI76zLEPxtPOWl7X5iJ+NG4Bypg1ChBaJ5rvswky/TWdrvPfVgYtuUKXfmIh5USziq8PnycC4g/av8JDdhGLxE2CER4B0CgNzcSQTgGvDRbiNtf5IRHd716RYzzz3CUSc5FK+IvGwf8ZE+cPec+SJ7AgMBAAECggEBAKV+/u8xDDGGvZ6fyDung0xjqUDmvc77Od3UMM8+orKMIK+D+X18WKyrCgRiXms4Pbh/qqdajUXoM6aCnBL7HkGbdYqWU/IEEakjE1AgX8Q3U12tsBKQk/40l+M3uJtTog+9rhYaw6RxHaB7miJ8Ewt+g1z2jIuw+ASZoY2Z//DcJ0OrDZrAwxyHA3bRBLeYa/5tw1YFees7wgXah6uBp03w82rG4YJiZzcDuz0TpOvDJdSQdTlBMwnKm2I/9hfawtGSIzMhEqUk3hff8KrJjOEFsiYjaYn6ol7AIiqHeE8CINWKx+PFgN4zf5dLo069meHK4eatSHYiRXMgatQh3gECgYEA/issHzWVK0vp4CZibd+VPBs978884naBESPRxgcikFdRo7WjOcuAukL9gpokfqGzL1O7c2CzV90hfWqQVYi3dunQMIsFdBAHDqkEkug2XwtFYaTBNflkCJyBUwN+5riOtkGsCsoKubgEzaH7Q6xkWnNNA4O+CymwvTe2vFtziE8CgYEA5lplT4rO20ciEg2TYeBqKItwbuKPnEq9qJ+qVHrBKb1UxSdh7EpFHUe8QU5+DiGK7+Jiq7/S3Bko8ZqD1XMLJgysxDF/xRaJbPmntxH2cmovfeTitFnCa26UNqQSWcgPiQb4VffjRYYo33xZA/ZPCsoSnvghBIcfr6Kt+l4gzBUCgYBIhPLq2LP+DYPmc61D4jZHVxJ9+OhLSTqcNFcnJGQFQRTHHA09cUYCXxjMCcT96I8iosZqLh4dpLdofF5AOWj3YdEH+LKOogARe8IVVHIm/iVGreZ+yvBy0IzJrcaod+IoOGapEWqsAMhGD8CMV4SulhVUOmOf9b46zsmxxnoZWwKBgQDcQULts4PnFzT0nhZ2V+YprmprHCbFApImUcTD0jwwdOBBQ07WaI19WcIfj7XoPRpkFMrT/i7YVRZZLa0wwze9whDP56SMBuiQUoaS/ZHwBKg0cE50s/66SpldRbRmNGzmUMvTJ5sgNw+N4ZAbwcACSQVVC1xGwA0EG0DPTIF/oQKBgQD3sRG7EmIm/m1XqdoTrJYPVth2Ep40Bygom17b0W7HRIzHYuoTrG2xXvSwLj9lFTqhotfP3S88ZS/LdE8NXohxpst5XVGS7MaXriTlvRX+T2SpQSDDK7ecwa8er2Esg4SHbSvY2LfFbSpTNKRsPpTwM9GqSnvtmE9YQmoy9I98fg==", "json", "UTF-8", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqatgRANx58kUBkr6OLT/fTePPQBBaCrPQn59Sbw+hC234HdvisaLLLOuPG7dcuBidinJQ4aWQDvJ8JkIq83+Dj1aSZCWyoyJNvQT2qtyD8mV2fd+gvPTgBb7iDxf4qNtgZJauOSvU2Ar764MIEi9Y4C449EzA0jPiwpojyp79TvzvmKphU13C3Kq+Vt+St6PRSVZvq/oi6Eulkp3dBpSwlAkEAQOBlervNeXKDfswYVoleUU8Xie9K8Wi4RQNhPA5/bFhao3ruSQ23dcCuHZgyCNxQJASKx4OynggutsOXlYwhUvA8zbkCOpmzflEWZ3yS5ANhlqiRtEbjxDmiwKkQIDAQAB", "RSA2");  //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest =  new  AlipayTradePagePayRequest(); //创建API对应的request

        //alipayRequest.setReturnUrl( "http://331t2j2729.zicp.vip/returlCallBack" );
        //支付宝的回调地址,支付结果异步通知
        alipayRequest.setNotifyUrl( "http://331t2j2729.zicp.vip/returlCallBack" ); //在公共参数中设置回跳和通知地址
        //alipayRequest.putOtherTextParam("app_auth_token", "201611BB8xxxxxxxxxxxxxxxxxxxedcecde6");//如果 ISV 代商家接入电脑网站支付能力，则需要传入 app_auth_token，使用第三方应用授权；自研开发模式请忽略

        String t = null;
        double price = 0.0;
        if (1 == pstatus) {
            t = "会员";
            price = 20.0;
        } else if (2 == pstatus) {
            t = "超级会员";
            price = 100.0;
        }

        alipayRequest.setBizContent( "{"  +
                "    \"out_trade_no\":\"" + UUID.randomUUID() + "\","  +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\","  +
                "    \"total_amount\":" + price + ","  +
                "    \"subject\":\"" + t + "\","  +
                "    \"body\":\"会员服务购买\","  +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\","  +
                "    \"extend_params\":{"  +
                "    \"sys_service_provider_id\":\"2088511833207846\""  +
                "    }" +
                "  }" ); //填充业务参数
        String form= "" ;
        try  {
            form = alipayClient.pageExecute(alipayRequest).getBody();  //调用SDK生成表单
        }  catch  (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    /*    httpResponse.setContentType( "text/html;charset="  + "utf-8");
        httpResponse.getWriter().write(form); //直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();*/
    }


    @RequestMapping("/returlCallBack")
    public String returlCallBack(HttpServletRequest request , HttpResponse httpResp) throws AlipayApiException {
        Map<String, String> paramsMap = convertRequestParamsToMap(request);
        boolean signVerified = AlipaySignature.rsaCheckV1(paramsMap, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAol4SrTwjB6RqSYQKWGiGopysy9KoHluqrsasGqDZWBm8Q4WlDYXpRpV7C53fqbChz/p/VwdGpb+bDSZU9pLEaSCzZTX6JqEeFo2fQav4mRVIY1FPgqOJ5Mn4AN/dB7j45Qy9wrIKh6+nP3dvDiN4wrHiobj4cl8Xb4vxbI3bvbj2SFYeL6u8iO49Hi4oXHvNaNzoKw8tl2hkI8N5sWU4LZAdT8odCSdpWwoMRvAapN+Doa4ceRgBmSc9D6l2qfz8Y0DIjd9wrs2fAc0XUUxb+JG1p5wGnzDagaNxFO8YkfeKlnaLtQ2ELQ2cy25db6sdNihIvXs6J3RzaU9kB4lHZwIDAQAB", "utf-8", "RSA2"); //调用SDK验证签名
        if(signVerified){
            // TODO 验签成功后，按照支付结果异步通知中的描述，对支付结果中的业务内容进行二次校验，校验成功后在response中返回success并继续商户自身业务处理，校验失败返回failure
            System.out.println(paramsMap);
            return "success";
        }else{
            // TODO 验签失败则记录异常日志，并在response中返回failure.
            return "fail";
        }
    }

    // 将request中的参数转换成Map
    private static Map<String, String> convertRequestParamsToMap(HttpServletRequest request) {
        Map<String, String> retMap = new HashMap<String, String>();

        Set<Map.Entry<String, String[]>> entrySet = request.getParameterMap().entrySet();

        for (Map.Entry<String, String[]> entry : entrySet) {
            String name = entry.getKey();
            String[] values = entry.getValue();
            int valLen = values.length;

            if (valLen == 1) {
                retMap.put(name, values[0]);
            } else if (valLen > 1) {
                StringBuilder sb = new StringBuilder();
                for (String val : values) {
                    sb.append(",").append(val);
                }
                retMap.put(name, sb.toString().substring(1));
            } else {
                retMap.put(name, "");
            }
        }

        return retMap;
    }
}

