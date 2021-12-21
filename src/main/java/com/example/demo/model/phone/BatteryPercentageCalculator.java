package com.example.demo.model.phone;

import java.util.ArrayList;

import com.example.demo.IntervalBattery.DefaultPorcentage;
import com.example.demo.IntervalBattery.FifthInterval;
import com.example.demo.IntervalBattery.FirstInterval;
import com.example.demo.IntervalBattery.FourthInterval;
import com.example.demo.IntervalBattery.Handler;
import com.example.demo.IntervalBattery.SecondInterval;
import com.example.demo.IntervalBattery.SeventhInterval;
import com.example.demo.IntervalBattery.SixthInterval;
import com.example.demo.IntervalBattery.ThirdInterval;

public class BatteryPercentageCalculator {
	
	ArrayList<Handler> intervalListBatery;
	private Battery batery;
	Handler initial;
	
	public BatteryPercentageCalculator(Battery batery) {
		this.batery = batery;
		intervalListBatery = new ArrayList<Handler>();
		fillArrayIntervals();
		addNext(intervalListBatery);
	}

	public int calculatePercentageBatery() {
		return initial.handle(this.batery);
	}
	
	private void fillArrayIntervals() {
		intervalListBatery.add(new FirstInterval());
		intervalListBatery.add(new SecondInterval());
		intervalListBatery.add(new ThirdInterval());
		intervalListBatery.add(new FourthInterval());
		intervalListBatery.add(new FifthInterval());
		intervalListBatery.add(new SixthInterval());
		intervalListBatery.add(new SeventhInterval());
		intervalListBatery.add(new DefaultPorcentage());
	}

	private void addNext(ArrayList<Handler> intervalListBatery) {
		initial = intervalListBatery.get(0);
		for (int i = 0; i < intervalListBatery.size()-1; i++) {
			intervalListBatery.get(i).setNext(intervalListBatery.get(i+1));
		}
	}

}
