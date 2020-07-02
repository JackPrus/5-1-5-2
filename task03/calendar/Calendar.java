package by.jonline.module5.task03.calendar;

public class Calendar {

	private int year;
	private boolean visokosny;

	public Calendar(int year) {
		this.year = year;
		visokosny = isVisokosny(year);
		checkSentury();

	}

	// внутренний класс.
	public class Day {
		
		private int month;
		private int day;

		public Day(int day, int month) throws NotRealDateException {
			
			this.month = month;
			this.day = day;
			checkRealDate(day, month);
		}

		public int getMonth() {return month;}
		public void setMonth(int month) {this.month = month;}
		public int getDay() {return day;}
		public void setDay(int day) {this.day = day;}

		private void checkRealDate(int day, int month) throws NotRealDateException {
			
			if (month > 12 || month < 1) {
				
				throw new NotRealDateException("Месяц должен быть от 1 до 12");
				
			} else {
				
				if ((month == 1) && (day > 31 || day < 1)) {
					throw new NotRealDateException("В Январе 31 день");
				} else if ((month == 2) && (visokosny) && (day < 1 || day > 29)) {
					throw new NotRealDateException("В фавреле высокосного года 29 дней");
				} else if ((month == 2) && (!visokosny) && (day > 28 || day < 1)) {
					throw new NotRealDateException("В феврале невисокосного года 28 дней");
				} else if ((month == 3) && (day < 1 || day > 31)) {
					throw new NotRealDateException("В марте 31 день");
				} else if ((month == 4) && (day < 1 || day > 30)) {
					throw new NotRealDateException("В апреле 30 дней");
				} else if ((month == 5) && (day < 1 || day > 31)) {
					throw new NotRealDateException("В мае 31 день");
				} else if ((month == 6) && (day < 1 || day > 30)) {
					throw new NotRealDateException("В июне 30 дней");
				} else if ((month == 7) && (day < 1 || day > 31)) {
					throw new NotRealDateException("В июле 31 день");
				} else if ((month == 8) && (day < 1 || day > 31)) {
					throw new NotRealDateException("В августе 31 день");
				} else if ((month == 9) && (day < 1 || day > 30)) {
					throw new NotRealDateException("В сентябре 30 дней");
				} else if ((month == 10) && (day < 1 || day > 31)) {
					throw new NotRealDateException("В октябре 31 день");
				} else if ((month == 11) && (day < 1 || day > 30)) {
					throw new NotRealDateException("В ноябре 30 дней");
				} else if ((month == 12) && (day < 1 || day > 31)) {
					throw new NotRealDateException("В декабре 31 день");
					
				}
			}
		}

		public void isHoliday() {

			if (this.day == 01 && this.month == 01) {
				System.out.println(String.format("%d.%d - праздничный день. Новый Год", this.day, this.month));
				return;
			} else if (this.day == 07 && this.month == 01) {
				System.out.println(String.format("%d.%d - праздничный день. Рождество Христово.", this.day, this.month));
				return;
			} else if (this.day == 8 && this.month == 03) {
				System.out.println(String.format("%d.%d - праздничный день. Международный женский День", this.day, this.month));
				return;
			} else if (this.day == 01 && this.month == 05) {
				System.out.println(String.format("%d.%d - праздничный день. Праздник труда", this.day, this.month));
				return;
			} else if (this.day == 9 && this.month == 05) {
				System.out.println(String.format("%d.%d - праздничный день. День Победы", this.day, this.month));
				return;
			} else if (this.day == 03 && this.month == 07) {
				System.out.println(String.format("%d.%d - праздничный день. День Независимости Республики Беларусь.",this.day, this.month));
				return;
			} else if (this.day == 07 && this.month == 11) {
				System.out.println(String.format("%d.%d - праздничный день. День Октябрьской революции.", this.day, this.month));
				return;
			} else if (this.day == 25 && this.month == 12) {
				System.out.println(String.format("%d.%d - праздничный день. Рождество Христово (католическое).",this.day, this.month));
				return;
			}

			String dayOfWeek = checkDayOfWeek(this);

			if (dayOfWeek.equals("Суббота") || dayOfWeek.equals("Воскресенье")) {
				System.out.println(String.format("%d.%d - выходной, %s", this.day, this.month, dayOfWeek));
				return;
			}
			
			System.out.println(String.format("%d.%d - рабочий день. %s.", this.day, this.month, dayOfWeek));

		}

	} // конец внутреннего класса

	private boolean isVisokosny(int year) {// проверка является ли год високосным
		if (year % 4 != 0) {
			return false;
		} else {
			if (year % 100 != 0) {
				return true;
			} else {
				if (year % 400 == 0) {
					return true;
				} else {
					return false;
				}
			}
		}
	}

	private void checkSentury() { // проверка является ли век 21, т.к. календарь только под этот век.

		try {
			if ((year / 100 + 1) != 21) {
				throw new NotRealDateException("Календарь только для 21 века");
			}
		} catch (NotRealDateException e) {
			e.printStackTrace();
		}
	}

	private String checkDayOfWeek(Day day) {

		/*
		 * Только для 21 века. день недели = (день + код месяца + код года) % 7
		 */

		int dayOfWeek;
		int d;
		int month;
		int codeMonth;
		int codeYear;
		
		
		month = day.getMonth();
		d = day.getDay();
		codeYear = (6 + (year % 100) + (year % 100 / 4)) % 7; // специальный код года для 21 века.
		codeMonth = 0;

		// вычисляется код месяца
		
		switch (month) {
		
		case 1: codeMonth = 1; break;
		case 2: codeMonth = 4; break;
		case 3: codeMonth = 4; break;
		case 4: codeMonth = 0; break;
		case 5: codeMonth = 2; break;
		case 6: codeMonth = 5; break;
		case 7: codeMonth = 0; break;
		case 8: codeMonth = 3; break;
		case 9: codeMonth = 6; break;
		case 10: codeMonth = 1; break;
		case 11: codeMonth = 4; break;
		case 12: codeMonth = 6; break;
		
		default:
			System.out.println("Введите корректный месяц");
			break;
		}

		dayOfWeek = (d + codeMonth + codeYear) % 7;
		
		// формула выше не совсем корректна для января/февраля високосного года. Ниже корректировка.
		
		if (isVisokosny(year)&& month<=2) {
			dayOfWeek = dayOfWeek-1;
			if (dayOfWeek<0) {
				dayOfWeek=6;
			}
		}

		switch (dayOfWeek) {
		
		case 1: return "Воскресенье";
		case 2: return "Понедельник";
		case 3: return "Вторник";
		case 4: return "Среда";
		case 5: return "Четверг";
		case 6: return "Пятница";
		case 0: return "Суббота";
		
		default:
			return "Ошибка в вычислении дня недели";
		}

	}

}
