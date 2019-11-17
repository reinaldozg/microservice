package br.com.zenganet.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DataHoraUtils {
	public static final Locale PT_BR = new Locale("pt", "BR");
	static final long ONE_MINUTE_IN_MILLIS = 60000;

	public static Calendar getCalendarInstanceBrasil() {
		return Calendar.getInstance(PT_BR);
	}

	public static Date getCurrentDate() {
		return getCalendarInstanceBrasil().getTime();
	}

	public static long getCurrentDateShort() {
		SimpleDateFormat d = new SimpleDateFormat("yyyyMMdd");
		return Long.valueOf(d.format(getCurrentDate()));
	}

	public static long getCurrentDateLong() {
		SimpleDateFormat d = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return Long.valueOf(d.format(getCurrentDate()));
	}

	public static long getCurrentDateLong(int mimutosAdd) {
		Date data = getCurrentDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.MINUTE, mimutosAdd);
		data = calendar.getTime();
		SimpleDateFormat d = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return Long.valueOf(d.format(data));
	}

	public static long getCurrentDateAno() {
		SimpleDateFormat d = new SimpleDateFormat("yyyy");
		return Long.valueOf(d.format(getCurrentDate()));
	}

	public static long converteDataShort(Date data) {

		if (data == null)
			return 0;

		SimpleDateFormat d = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return Long.valueOf(d.format(data));
	}

	public static long converteDataLong(Date data) {

		if (data == null)
			return 0;

		SimpleDateFormat d = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return Long.valueOf(d.format(data));
	}

	public static String converteDataLong(long data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
		return sdf.format(data);
	}

	public static Date converte(long l) {
		return new Date(l);
	}

	public static String converteDataShort(long data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}

	public static Date converteStringParaDate(String data) {
		if (data == null || data.equals(""))
			return null;
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = (Date) formatter.parse(data);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}

	public static long converteShortDataInfoInvest(String data) {

		if (data == null || data.length() == 0)
			return 0;

		StringBuilder sb = new StringBuilder();
		sb.append(data.split("/")[1].toString());		
		sb.append("/");
		sb.append(data.split("/")[0].toString().length() == 1 ? "0" + data.split("/")[0].toString()	: data.split("/")[0].toString());
		sb.append("/");
		sb.append(data.split("/")[2].toString().length() == 1 ? "0" + data.split("/")[2].toString()	: data.split("/")[2].toString());		

		Date date = null;
		DateFormat formatter;
		try {
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = formatter.parse(sb.toString());
		} catch (ParseException e) {
			return 0;
		}
		SimpleDateFormat d = new SimpleDateFormat("yyyyMMdd");
		return Long.valueOf(d.format(date));

	}

	public static long converteShortDataUOL(String data) {

		if (data == null || data.length() == 0)
			return 0;

		switch (data.split("/")[1].toString()) {

		case "Jan.":
			data = data.replace("Jan.", "01");
			break;
		case "Feb.":
			data = data.replace("Feb.", "02");
			break;
		case "Mar.":
			data = data.replace("Mar.", "03");
			break;
		case "Apr.":
			data = data.replace("Apr.", "04");
			break;
		case "May.":
			data = data.replace("May.", "05");
			break;
		case "Jun.":
			data = data.replace("Jun.", "06");
			break;
		case "Jul.":
			data = data.replace("Jul.", "07");
			break;
		case "Aug.":
			data = data.replace("Aug.", "08");
			break;
		case "Sep.":
			data = data.replace("Sep.", "09");
			break;
		case "Oct.":
			data = data.replace("Oct.", "10");
			break;
		case "Nov.":
			data = data.replace("Nov.", "11");
			break;
		case "Dec.":
			data = data.replace("Dec.", "12");
			break;

		}

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return Long.valueOf(format.format(converteStringParaDate(data)));

	}

	public static long converteShortData(String data) {

		if (data == null || data.length() == 0)
			return 0;

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return Long.valueOf(format.format(converteStringParaDate(data)));

	}

	public static Date converteDataShort(String data) {
		try {
			if (!(data == null || data.length() == 0)) {
				SimpleDateFormat format = getSimpleDateFormatBrasil("dd/MM/yyyy");

				return (Date) format.parse(data);
			}
		} catch (ParseException e) {
			System.out.println("Erro ao formatar data: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public static String converteDateParaString(Date data, String formato) {
		SimpleDateFormat sdf = getSimpleDateFormatBrasil(formato);
		return sdf.format(data);
	}

	private static SimpleDateFormat getSimpleDateFormatBrasil(String formato) {
		return new SimpleDateFormat(formato, PT_BR);
	}

	public static Date converteStringParaDate(String strData, String formato) {
		SimpleDateFormat format = getSimpleDateFormatBrasil(formato);
		try {
			if (!(strData == null || strData.length() == 0) && (formato == null || formato.length() == 0)) {
				Date data;
				data = (Date) format.parse(strData);
				return data;
			}
		} catch (ParseException e) {
			System.out.println("Erro ao formatar data: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public static long diferenca(Date dataFim, Date dataInicio) {
		if (dataInicio == null)
			return dataFim.getTime();
		else if (dataFim == null)
			throw new NullPointerException();

		return dataFim.getTime() - dataInicio.getTime();
	}

	public static boolean isDataMaiorQue(Date data1, Date data2) {
		if (data1.after(data2)) {
			return true;
		}
		return false;
	}

	public static Date getDataAtualHoraZero() {
		Calendar c = Calendar.getInstance();
		c.setTime(getCurrentDate());
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	public static Date getDataAtualUltimaHora() {
		Calendar c = Calendar.getInstance();
		c.setTime(getCurrentDate());
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	public static Date setHoraNaData(Date data, int hora, int minuto, int segundo) {
		if (data == null)
			return null;

		Calendar c = getCalendarInstanceBrasil();
		c.setTime(data);
		c.set(Calendar.HOUR_OF_DAY, hora);
		c.set(Calendar.MINUTE, minuto);
		c.set(Calendar.SECOND, segundo);
		return c.getTime();
	}

	public static int getDiaDaSemana(Date data) {
		Calendar c = getCalendarInstanceBrasil();
		c.setTimeInMillis(data.getTime());

		int ano = c.get(Calendar.YEAR);
		int mes = c.get(Calendar.MONTH);
		int dia = c.get(Calendar.DAY_OF_MONTH);

		Calendar calendario = new GregorianCalendar(ano, mes, dia);
		int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);

		return diaSemana - 1;
	}

	public static Date getDataValidadeToken(int tempoEmMinutos) {
		Calendar c = getCalendarInstanceBrasil();
		c.add(Calendar.MINUTE, tempoEmMinutos);
		return c.getTime();
	}

	public static long getInicioDaSemana() {
		Date data = getCurrentDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.DATE, -getDiaDaSemana(data));
		data = calendar.getTime();
		SimpleDateFormat d = new SimpleDateFormat("yyyyMMdd");
		return Long.valueOf(d.format(data));
	}

	public static long getInicioDoMes() {
		String data = String.valueOf(getCurrentDateShort());
		data = data.substring(0, 6) + "01";
		return Long.valueOf(data);
	}

	public static long getInicioDoAno() {
		String data = String.valueOf(getCurrentDateShort());
		data = data.substring(0, 4) + "0101";
		return Long.valueOf(data);
	}
}
