package com.yjxbi.commons.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.codec.binary.Base64;

public class CoreUtils {

	public static BigDecimal ZERO = new BigDecimal(0);

	public static BigDecimal ONE = new BigDecimal("1");
	
	public static BigDecimal TWO = new BigDecimal("2");
	
	public static BigDecimal FIVE = new BigDecimal("5");

	public static BigDecimal B117 = new BigDecimal("1.17");

	public static BigDecimal B017 = new BigDecimal("0.17");

	public static BigDecimal WAN = new BigDecimal("10000");

	public static Long LONGZERO = new Long(0);

	public static Long LONGONE = new Long(1);

	public static Long LONG12 = new Long(12);

	public static final String EMPTY = "";

	public static BigDecimal K1 = new BigDecimal(1000);
	
	public static Long daysBetween(Date now, Date returnDate) {
		Calendar cNow = Calendar.getInstance();
		Calendar cReturnDate = Calendar.getInstance();
		cNow.setTime(now);
		cReturnDate.setTime(returnDate);
		setTimeToMidnight(cNow);
		setTimeToMidnight(cReturnDate);
		long todayMs = cNow.getTimeInMillis();
		long returnMs = cReturnDate.getTimeInMillis();
		long intervalMs = todayMs - returnMs;
		return new Long(millisecondsToDays(intervalMs));
	}
	private static void setTimeToMidnight(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
	}
	
	private static int millisecondsToDays(long intervalMs) {
		return (int) (intervalMs / (1000 * 86400));
	}
	
	public static String formatDate(Date val,String format) {
		
		if (val == null)
			return "";
		
		SimpleDateFormat formatter = new SimpleDateFormat(format);//"yyyy-MM-dd HH:mm:ss"
	    String dateString = formatter.format(val);

		return dateString;
		
	}

	public static Date nextDate(Date date) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		calendar.add(Calendar.DAY_OF_MONTH, 1);

		return calendar.getTime();

	}

	public static Date nextDate(Date date, int day) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		calendar.add(Calendar.DAY_OF_MONTH, day);

		return calendar.getTime();

	}

	public static Date nextMonth(Date date) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		calendar.add(Calendar.MONTH, 1);

		return calendar.getTime();

	}
	
	public static Date threeMonthago(Date date) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		calendar.add(Calendar.MONTH,-1);
		calendar.add(Calendar.MONTH,-1);
		calendar.add(Calendar.MONTH,-1);

		return calendar.getTime();

	}

	public static Date PreviousDate(Date date) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		calendar.add(Calendar.DAY_OF_MONTH, -1);

		return calendar.getTime();

	}

	public static final String ZIP_CHARSET = "ISO-8859-1";

	public static String encode64(Object obj) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			OutputStream zos = new GZIPOutputStream(baos);
			ObjectOutputStream oos = new ObjectOutputStream(zos);
			oos.writeObject(obj);
			oos.close();
			zos.close();
			baos.close();
			Base64 base64Codec = new Base64();
			return new String(base64Codec.encode(baos.toByteArray()),
					ZIP_CHARSET);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public static Object decode64(String s) {
		try {
			Base64 base64Codec = new Base64();
			ByteArrayInputStream decodedStream = new ByteArrayInputStream(
					base64Codec.decode(s.getBytes(ZIP_CHARSET)));
			InputStream unzippedStream = new GZIPInputStream(decodedStream);
			ObjectInputStream ois = new ObjectInputStream(unzippedStream);
			Object obj = ois.readObject();
			ois.close();
			unzippedStream.close();
			decodedStream.close();
			return obj;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
