package ru.makhnutin.contacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.makhnutin.contacts.bot.BirthDayBot;
import ru.makhnutin.contacts.model.Contact;
import ru.makhnutin.contacts.repositories.ContactRepository;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.ZoneId;
import java.util.Date;

@Service("birthDayService")
@EnableScheduling
public class BirthDayService {

	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private BirthDayBot birthDayBot;

	private ZoneId defaultZoneId = ZoneId.systemDefault();

	@Scheduled(cron="30 * * * * *")
	public void checkBirthDays() {
		for (Contact contact : contactRepository.findAll()) {
			if (contact.getBirthDay() != null) {
				if(isBirthDayToday(contact.getBirthDay())) {
					birthDayBot.sendBirthDayNotification(contact);
				}
			}
		}
	}

	private boolean isBirthDayToday(Date birthDay){
		LocalDate birthDayLD = birthDay.toInstant().atZone(defaultZoneId).toLocalDate();
		return MonthDay.from(birthDayLD).equals(MonthDay.from(LocalDate.now()));
	}

}
