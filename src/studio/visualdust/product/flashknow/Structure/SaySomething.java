package studio.visualdust.product.flashknow.Structure;

import java.util.Vector;

public class SaySomething {
    public Vector<String> OP = new Vector<>();
    public Vector<String> ED = new Vector<>();
    public Vector<String> LE = new Vector<>();

    public SaySomething() {
//        try {
//            InputStream inputStream = Resource.class.getResourceAsStream("OPS.txt");
//            BufferedReader buffreader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
//            String tempinputString;
//            Vector<String> tmpOP = new Vector<>();
//            while ((tempinputString = buffreader.readLine()) != null) {
//                tmpOP.add(tempinputString);
//            }
//            inputStream = Resource.class.getResourceAsStream("EDS.txt");
//            buffreader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
//            Vector<String> tmpED = new Vector<>();
//            while ((tempinputString = buffreader.readLine()) != null) {
//                tmpED.add(tempinputString);
//            }
//            OP = tmpOP;
//            ED = tmpED;
//        } catch (Exception e) {
//            EventRW.WriteUTF8(e);
//        }
        OP.add("日安");
        OP.add("今天天气还不错");
        OP.add("最近怎么样");
        OP.add("欢迎回来");
        OP.add("心情怎么样");
        OP.add("上顿吃了什么");
        OP.add("是不是很想下班");
        OP.add("来上课了吗");
        OP.add("感觉如何");

        ED.add("听说星巴克的摩卡涨价了");
        ED.add("下班要不要去搓一杯");
        ED.add("最近作业质量还好吧");
        ED.add("大家状态不错");
        ED.add("接下来是你的时间");
        ED.add("干嘛不先放松一下");

        LE.add("祝你好运");
        LE.add("祝你开心");
        LE.add("下次见");
        LE.add("日安");
        LE.add("代我向其他人问好");

    }

    public String getRandOP() {
        return OP.elementAt((int) (Math.random() * (OP.size() - 1)));
    }

    public String getRandED() {
        return ED.elementAt((int) (Math.random() * (ED.size() - 1)));
    }

    public String getRandLE() {
        return LE.elementAt((int) (Math.random() * (LE.size() - 1)));
    }
}
