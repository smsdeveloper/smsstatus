package com.slf.engine.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	/**
	 * 转换时间到string 
	 * @param date
	 * @param par
	 * @return
	 */
	public static String dateToString(Date date, String par)
	{
		if(null == date || null == par)
		{
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(par);
		
		return dateFormat.format(date);
	}
	
	//时间处理
	public static String strDate(String par)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(par);
		
		return dateFormat.format(new Date());
	}
	
	/**
	 * 根据par时间格式化转化为date日期
	 * @param str
	 * @param par
	 * @return
	 * @throws ParseException
	 */
	public static Date strToDate(String str,String par) throws ParseException
	{
		if(null == str || null == par)
		{
			return null;
		}
		DateFormat format = new SimpleDateFormat(par);
		return format.parse(str);
	}
	
	public static Date parDate(String par) throws ParseException
	{
		DateFormat format = new SimpleDateFormat(par);
		return format.parse(format.format(new Date()));
		
	}
	/**
	 * 昨天的日期
	 * @return
	 * @throws ParseException
	 */
	public static Date yestDate() throws ParseException 
	{
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.DAY_OF_WEEK, -1);
		return parseDate(rightNow.getTime(),"yyyyMMdd");
	}
	
	/**
	 * 昨天的日期
	 * @return
	 * @throws ParseException
	 */
	public static String yestStrDate() 
	{
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.DAY_OF_WEEK, -1);
		return dateToString(rightNow.getTime(),"yyyyMMdd");
	}
	
	/**
	 * 查询这个月的第一天
	 * @param str
	 * @param par
	 * @return
	 * @throws ParseException
	 */
	public static Date monthFirstDay() throws ParseException
	{
		Calendar rightNow = Calendar.getInstance();
		rightNow.set(Calendar.DATE, 1);
		return parseDate(rightNow.getTime(),"yyyyMMdd");
	}
	/**
	 * 查询上个月的第一天
	 * @param str
	 * @param par
	 * @return
	 * @throws ParseException
	 */
	public static Date lastMonthFirstDay() throws ParseException
	{
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(new Date());
		rightNow.add(Calendar.MONTH, -1);
		rightNow.set(Calendar.DATE, 1);
		Date lastMonth = rightNow.getTime();
		return parseDate(lastMonth,"yyyyMMdd");
	}
	
	public static Date parseDate(Date date, String par) throws ParseException
	{
		if(null == date || null == par)
		{
			return null;
		}
		DateFormat format = new SimpleDateFormat(par);
		return format.parse(format.format(date));
	}
	
	/**
	 * 计算两个日期间的间隔数
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int getDaysBetween(java.util.Calendar d1, java.util.Calendar d2) {
		  if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
		   java.util.Calendar swap = d1;
		   d1 = d2;
		   d2 = swap;
		  }
		  int days = d2.get(java.util.Calendar.DAY_OF_YEAR)
		    - d1.get(java.util.Calendar.DAY_OF_YEAR);
		  int y2 = d2.get(java.util.Calendar.YEAR);
		  if (d1.get(java.util.Calendar.YEAR) != y2) {
		   d1 = (java.util.Calendar) d1.clone();
		   do {

		    days += d1.getActualMaximum(java.util.Calendar.DAY_OF_YEAR);
		    d1.add(java.util.Calendar.YEAR, 1);
		   } while (d1.get(java.util.Calendar.YEAR) != y2);
		  }
		  return days;
		 }

	
	/**
	 * 获取上一个月的日期 yyyyMM
	 * @param args
	 */
	public static String prevMonth()
	{
		String month;
		if(DateUtils.strDate("MM").equals("01"))
		{
			month = String.valueOf(Integer.parseInt(DateUtils.strDate("yyyy")) - 1);
			month = month + "12";
		}else{
			month = String.valueOf(Integer.parseInt(DateUtils.strDate("yyyyMM"))-1);
		}
		return month;
	}
	
	public static String backDays(int days)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -days);
		return dateToString(calendar.getTime(),"yyyyMMdd");
	}
	
	public static String nextDays(String date,String pars,int days,String pars2) throws ParseException
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(strToDate(date,pars));
		calendar.add(Calendar.DATE, 3);
		return dateToString(calendar.getTime(),pars2);
	}
	
	
	public static String getDateString(){
		Calendar calendar = Calendar.getInstance();
		return dateToString(calendar.getTime(),"yyyyMMddHHmmss");
	}
	
	public static String getNextDateString(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		return dateToString(calendar.getTime(),"yyyyMMddHHmmss");
	}
	
	public static long dateDiff(String startTime) {		
		SimpleDateFormat sf = new SimpleDateFormat ("yyyyMMddhhmmss");
		Date d1 = new Date();
		Date d2 = null;
		try {
			d2 = sf.parse(startTime);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return d1.getTime() - d2.getTime();
	}
	
	
	
	 public static boolean getDistanceTime(String str1, String str2) {  
	        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");  
	        Date one;  
	        Date two;  
	        long day = 0;  
	        long hour = 0;  
	        long min = 0;  
	        long sec = 0;  
	        try {  
	            one = df.parse(str1);  
	            two = df.parse(str2);  
	            long time1 = one.getTime();  
	            long time2 = two.getTime();  
	            long diff ;  
	            if(time1<time2) {  
	                diff = time2 - time1;  
	            } else {  
	                diff = time1 - time2;  
	            }  
	            day = diff / (24 * 60 * 60 * 1000);  
	            hour = (diff / (60 * 60 * 1000) - day * 24);  
	            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);  
	            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        if(day>0 ||hour>4){
	        	return true;
	        }	       
	        return false;
	          
	    }  
	
	
	public static void main(String args[])
	{
		
		System.out.println(getDistanceTime(getDateString(),"20130902084852"));
//		System.out.println(3*6*10 * 60 *1000);
//		System.out.println(dateDiff("20130717104852"));
		
//		System.out.println(new DateUtils().dateDiff(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), "20130617114301", "yyyyMMddHHmmss"));
//		Calendar calendar = Calendar.getInstance();
////		try {
////			calendar.setTime(strToDate("2009-12-11","yyyy-MM-dd"));
////		} catch (ParseException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		calendar.add(Calendar.DATE, 3);
//		System.out.println(dateToString(calendar.getTime(),"yyyyMMdd"));
	}
}
