package com.example.demo.model.ObjectMother;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.LinkedList;

import com.example.demo.model.history.Handler;
import com.example.demo.model.history.HistoricalPrice;
import com.example.demo.model.history.RateFromFiveToSix;
import com.example.demo.model.history.RateFromNineToTen;
import com.example.demo.model.history.RateFromSevenToEight;
import com.example.demo.model.history.RateFromThreeToFour;
import com.example.demo.model.history.RateFromZeroToTwo;
import com.example.demo.model.phone.Phone;
import com.example.demo.utiles.Utiles;

public class HistoryPhoneMother {
	
	private static final int MIN_RATE = 0;
	private static final int MAX_RATE = 10;
	private static LinkedList<Handler> handlersRate = new LinkedList<>() ;
	private static Handler initial;
	private static int indice = 0;
	private static final int MAX_HISTORICAL_PRICE = 4;
	private static int year = Year.now().getValue();
	private static int month = Calendar.MONTH;
	private static int day = 1;
	
	public static LinkedList<HistoricalPrice> getListHistoricalPrice(Iterable<Phone> phoneList) {
		prepareHandlersRate();
		LinkedList<HistoricalPrice> historicalPrices = new LinkedList<>();
		phoneList.forEach((phone)->{
			historicalPrices.add(new HistoricalPrice(phone, phone.getPrice(), Date.valueOf(LocalDate.of(year, month, day))));
			for (int i = 0; i < MAX_HISTORICAL_PRICE; i++) {
				HistoricalPrice historicalRealizedPrice = getHistoricalPrice(historicalPrices, phone);
				historicalPrices.add(historicalRealizedPrice);
			}
			putByDefault();
		});
		return historicalPrices;
	}

	private static void putByDefault() {
		month = Calendar.MONTH;
		year = Year.now().getValue();
		day = 1;
	}
	
	private static void prepareHandlersRate() {
		fillHandlersRate();
		setNext();
	}

	private static HistoricalPrice getHistoricalPrice(LinkedList<HistoricalPrice> historicalPrices, Phone phone) {
		int rateUser = Utiles.getRandomWholeNumber(MIN_RATE, MAX_RATE);
		float applyPercentage = initial.handle(rateUser);
		float percentage = Float.valueOf(applyPercentage / 100);
		float priceApplyDescount = 0;
		if (applyPercentage <= 10.0 ) {
			priceApplyDescount = phone.getPrice() + (phone.getPrice() * percentage);
		}else {
			priceApplyDescount = phone.getPrice() - (phone.getPrice() * percentage);
		}
		Float priceTwoDecimalsApplyDescount = Utiles.convertNumberTwoDecimals(priceApplyDescount);
		day++;
		month = month - 1;
		if (month <= 0) {
			month = 12;
			--year;
		}
		return new HistoricalPrice(phone,priceTwoDecimalsApplyDescount,Date.valueOf(LocalDate.of(year
				, month,day)));
	}
	
	private static void fillHandlersRate() {
		handlersRate.add(new RateFromZeroToTwo());
		handlersRate.add(new RateFromThreeToFour());
		handlersRate.add(new RateFromFiveToSix());
		handlersRate.add(new RateFromSevenToEight());
		handlersRate.add(new RateFromNineToTen());
	}
	
	private static void setNext() {
		initial = handlersRate.get(0);
		handlersRate.forEach((handlerRate)->{
			if (indice != 4) {
				handlerRate.setNext(handlersRate.get(++indice));
			}
		});
	}

}
