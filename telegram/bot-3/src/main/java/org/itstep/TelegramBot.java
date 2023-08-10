package org.itstep;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public TelegramBot(BotConfig botConfig) {
        this.botConfig = botConfig;
        //Меню
        List<BotCommand> botCommands = new ArrayList<>();
        botCommands.add(new BotCommand("/hello", "get a welcome message"));
        botCommands.add(new BotCommand("/help", "get an info"));
        botCommands.add(new BotCommand("/register", "get a registration"));
        try {
            execute(new SetMyCommands(botCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.error("Error occured: " + e.getMessage());
            //e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            //System.out.println("ok");
            String text = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            String firstName = update.getMessage().getChat().getFirstName();

            switch (text) {
                case "/hello":
                    hello(chatId, firstName);
                    saveUser(update.getMessage());
                    break;
                case "/register":
                    register(chatId);
                    break;
                case "/help":
                    sendMessage(chatId, "This bot is created to demonstrate");
                    break;
                default:
                    sendMessage(chatId, "Sorry, the command was not recognized");
            }
        } else if (update.hasCallbackQuery()) {
            long messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            String data = update.getCallbackQuery().getData();
            if (data.equals("YES_BUTTON"))
                text = "You pressed YES button";
            else if (data.equals("NO_BUTTON"))
                text = "You pressed NO button";
            EditMessageText message = new EditMessageText();
            message.setChatId(String.valueOf(chatId));
            message.setMessageId((int) messageId);
            message.setText(text);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                log.error("Error occured: " + e.getMessage());
            }

        }
    }

    private void register(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Do you really want to register?");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        var yesButton = new InlineKeyboardButton("Yes");
        yesButton.setCallbackData("YES_BUTTON");
        var noButton = new InlineKeyboardButton("No");
        noButton.setCallbackData("NO_BUTTON");
        row.add(yesButton);
        row.add(noButton);
        keyboard.add(row);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(inlineKeyboardMarkup);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("Error occured: " + e.getMessage());
        }
    }

    private void saveUser(Message message) {
        if (userRepository.findById(message.getChatId()).isEmpty()) {
            System.out.println("ok");
            User user = new User();
            user.setChatId(message.getChat().getId());
            user.setFirstName(message.getChat().getFirstName());
            user.setLastName(message.getChat().getLastName());
            user.setUserName(message.getChat().getUserName());
            user.setRegisteredAt(new Timestamp(System.currentTimeMillis()));

            userRepository.save(user);
            log.info("user saved: {}", user);
        }
    }

    private void hello(long chatId, String firstName) {
        String answer = "Hello, " + firstName + "!";
        sendMessage(chatId, answer);
        log.info("Replied to user: " + firstName);
    }

    private void sendMessage(long chatId, String answer) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(answer);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Error occured: " + e.getMessage());
            //e.printStackTrace();
        }
    }
}
