package cn.xiaoyu.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 处理日期类型变量的工具类
 *
 * @author donghai
 * @version v1.0
 * @since 2017/04/20
 */
public class DateUtil {

    /**
     * 获取两个日期之间的日期
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return 日期字符串格式的集合
     */
    public static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        while (tempStart.before(tempEnd) || tempStart.equals(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }

    /**
     * 根据日期字符串返回日期
     */
    public static final Date parse(String source, String format) throws ParseException {
        DateFormat df = new SimpleDateFormat(format);
        return df.parse(source);
    }

    /**
     * 根据日期获取格式化的日期字符串
     */
    public static final String format(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 根据日期获取格式化的日期字符串，指定默认格式为：yyyy-MM-dd HH:mm:ss
     */
    public static final String format(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

    /**
     * 新增天数
     */
    public static Date addDay(Date sourceDate, Integer days) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(sourceDate);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
}
