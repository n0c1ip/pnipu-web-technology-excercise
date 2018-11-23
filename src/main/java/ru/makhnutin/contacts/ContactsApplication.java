package ru.makhnutin.contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import ru.makhnutin.contacts.bot.BirthDayBot;
import ru.makhnutin.contacts.configuration.JpaConfiguration;
import ru.makhnutin.contacts.configuration.TelegramConfiguration;

import java.time.ZoneId;


@Import({JpaConfiguration.class, TelegramConfiguration.class})
@SpringBootApplication(scanBasePackages={"ru.makhnutin.contacts"})
public class ContactsApplication {
	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}
}
