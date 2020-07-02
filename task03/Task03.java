package by.jonline.module5.task03;
import by.jonline.module5.task03.calendar.Calendar;
import by.jonline.module5.task03.calendar.NotRealDateException;

public class Task03 {
	
	public static void main(String[] args) throws NotRealDateException {
		
        Calendar cl = new Calendar(2020);
        
        Calendar.Day day1 = cl.new Day (02,07);
        day1.isHoliday();
        
        Calendar.Day day2 = cl.new Day (05,07);
        day2.isHoliday();
        
        Calendar.Day day3 = cl.new Day (03,07);
        day3.isHoliday();
        
        Calendar.Day day4 = cl.new Day (01,01);
        day4.isHoliday();
        
        Calendar.Day day5 = cl.new Day (29,02);
        day5.isHoliday();
        
        Calendar.Day day6 = cl.new Day (28,03);
        day6.isHoliday();
        
        Calendar.Day day7 = cl.new Day (01,03);
        day7.isHoliday();
        
        Calendar.Day day8 = cl.new Day (28,02);
        day8.isHoliday();
		
		
	}

}
