package ru.makhnutin.contacts.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import ru.makhnutin.contacts.bot.BirthDayBot;

@Configuration
public class TelegramConfiguration {

	@Value("${telegram.bot_name}")
	private String botName;
	@Value("${telegram.bot_token}")
	private String botToken;
	@Value("${telegram.chat_id}")
	private String chat_id;


	@Bean
	public BirthDayBot birthDayBot() {
		ApiContextInitializer.init();
		TelegramBotsApi botsApi = new TelegramBotsApi();
		BirthDayBot birthDayBot = new BirthDayBot(botName, botToken, chat_id);
		try {
			botsApi.registerBot(birthDayBot);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
		return birthDayBot;
	}


}
