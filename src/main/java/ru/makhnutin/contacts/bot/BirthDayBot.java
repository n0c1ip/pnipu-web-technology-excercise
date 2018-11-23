package ru.makhnutin.contacts.bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import ru.makhnutin.contacts.model.Contact;

public class BirthDayBot extends TelegramLongPollingBot {

	private String botName;
	private String botToken;
	private String chat_id;

	public BirthDayBot(String botName, String botToken, String receiver) {
		this.botName = botName;
		this.botToken = botToken;
		this.chat_id = receiver;
	}

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			SendMessage message = new SendMessage()
					.setChatId(update.getMessage().getChatId())
					.setText(update.getMessage().getText());
			try {
				execute(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getBotUsername() {
		return botName;
	}

	@Override
	public String getBotToken() {
		return botToken;
	}

	public void sendBirthDayNotification(Contact contact) {
		try {
			execute(new SendMessage(chat_id, "Сегодня день рождения: "
					+ contact.getFirstName() + " " + contact.getSecondName() ));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

}
