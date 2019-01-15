package com.test.testboot.repository;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class URLTest2 {

    private static String url = "http://www.wuhuark.com/hz/ctc1/ctc1_cndt/t20190115_11830.htm";


    public static String accessRrl(String urlString) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlString);
            InputStream in = url.openStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader bufr = new BufferedReader(isr);
            String str;


            while ((str = bufr.readLine()) != null) {
//                System.out.println(str);
                sb.append(str);
            }
            bufr.close();
            isr.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    public static String accessRrl2(String urlString) {
        String result = "";// 访问返回结果
        BufferedReader read = null;// 读取访问结果


        try {
            // 创建url
            URL realurl = new URL(url);
            // 打开连接
//            URLConnection connection = realurl.openConnection();
            HttpURLConnection connection = (HttpURLConnection) realurl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestMethod("GET");


            // 建立连接
            connection.connect();


            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段，获取到cookies等
            for (String key : map.keySet()) {
                int a = 0;
                a++;
                if (a > 5) {
                    System.out.println(key + "--->" + map.get(key));
                }


            }
            // 定义 BufferedReader输入流来读取URL的响应
            read = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;// 循环读取
            while ((line = read.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            System.out.println("中断");
            e.printStackTrace();
        } finally {
            if (read != null) {// 关闭流
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return result;

    }

    public static final String[] ipArrays = {
            "66.102.251.", "112.211.0.", "141.8.225.", "159.106.121.",
            "216.58.221.", "61.244.148.", "59.125.39.", "58.30.15.", "114.80.166.",
            "202.96.134.", "58.19.24.", "119.39.23.", "58.195.128.", "124.236.223.",
            "183.221.217.", "222.182.90.", "58.194.96.", "211.138.161.",
            "112.112.13.", "219.159.82.", "202.98.226.", " 61.128.101.",
            "130.039.000.", "130.039.255.", "131.230.000.", "131.230.255.",
            "144.092.000.", "144.092.255.", "151.000.000.", "152.255.255.",
            "161.058.000.", "161.058.255.", "169.208.000.", "169.223.255.",
            "171.208.000.", "171.220.255.", "195.010.040.", "195.010.040.",
            "195.010.062.", "195.010.063.", "195.010.194.", "195.010.194.",
            "195.063.159.", "195.063.159.", "195.090.044.", "195.090.046.",
            "195.090.047.", "195.090.048.", "195.090.049.", "195.090.051.",
            "195.090.052.", "195.090.053.", "195.100.066.", "195.112.164.",
            "195.112.172.", "195.112.173."};


    public static String accessabc(String urlString) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlString);
            URLConnection con = url.openConnection();


            con.setDoOutput(true);
            con.setDoInput(true);

            Random r = new Random();
            Integer counter = r.nextInt(255);

            int index = r.nextInt(34);

//            System.out.println("index==:"+index);
            String ip = ipArrays[index];
            System.out.println("ip==:"+ip);

            con.setRequestProperty("X-Forwarded-For", ip + counter);
            System.out.println(ip + counter);
            con.setRequestProperty("cache-control", "max-age=0");
            if (r.nextInt(10) % 2 == 0)
                con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.142 Safari/535.19");
            else
                con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0");

            con.setUseCaches(false);
            OutputStream out = con.getOutputStream();
            out.write(("data=2222" ).getBytes());
            out.flush();
            out.close();

//            InputStream in = url.openStream();
            InputStream in =con.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader bufr = new BufferedReader(isr);
            String str;


            while ((str = bufr.readLine()) != null) {
//                System.out.println(str);
                sb.append(str);
            }
            bufr.close();
            isr.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String args[]) throws Exception {
        for (int i = 0; i < 30; i++) {
            String accessabc = URLTest2.accessabc(url);
            System.out.println(i + "ssss:" + accessabc);
            System.out.println(i);

        }


        System.out.println("======end=======");
//        System.out.println(ssss);
//        Mozilla Mozilla = Mozilla.getInstance();

    }
}