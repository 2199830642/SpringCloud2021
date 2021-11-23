import java.time.ZonedDateTime;

/**
 * @author Kaibo.Chen@hand-china.com
 * @ClassName: getTimeNow
 * @Description: TODO
 * @date 2021/11/23 10:27
 */
public class getTimeNow {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now();
        System.out.println(zbj);//2021-11-23T10:27:54.184+08:00[Asia/Shanghai]
    }
}
