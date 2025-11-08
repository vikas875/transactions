package com.transaction.transactionengines.utils;

import com.transaction.transactionengines.repository.ChannelUsersRepository;
import com.transaction.transactionengines.repository.SubscriberRepository;
import com.transaction.transactionengines.repository.ThresholdsProfilesRepository;
import com.transaction.transactionengines.repository.TransactionHeaderRepository;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RequiredArgsConstructor
@Component
public class IdGenerator {


    private final ChannelUsersRepository channelUsersRepository;
    private final SubscriberRepository subscriberRepository;
    private final ThresholdsProfilesRepository thresholdsProfilesRepository;
    private final TransactionHeaderRepository transactionHeaderRepository;

    public String generateUserId() {

        String prefix = "USR";


        String timestamp = getTimeStamp();

        // Random 2 characters (A-Z)
        String randomChars = generateRandomChars(2);

        // Sequence part
        String lastUserId = channelUsersRepository.findLastUserId();
        int nextSeq = extractNextSequence(lastUserId);

        String formattedSeq = String.format("%04d", nextSeq); // 0001, 0002, etc.

        return prefix + timestamp + randomChars + formattedSeq;
    }

    public String generateSubscriberId(){
        String prefix = "SUB";
        String timestamp = getTimeStamp();
        String randomChars = generateRandomChars(2);
        String lastSubscriberId = subscriberRepository.findLastSubscriberId();
        int nextSeq = extractNextSequence(lastSubscriberId);
        String formattedSeq = String.format("%04d", nextSeq);
        return prefix + timestamp + randomChars + formattedSeq;
    }

    public String generateTransferId(){
        String prefix = "Tfr";
        String timestamp = getTimeStamp();
        String randomChars = generateRandomChars(2);
        String lastTransferId = transactionHeaderRepository.findLastTransferId();
        int nextSeq = extractNextSequence(lastTransferId);
        String formattedSeq = String.format("%04d", nextSeq);
        return prefix + timestamp + randomChars + formattedSeq;

    }

    public String generateThresholdsId(){
        String prefix = "Thresh";
        String timestamp = getTimeStamp();
        String randomChars = generateRandomChars(2);
        String lastThresholdsId = thresholdsProfilesRepository.findLastThreshProfileId();
        int nextSeq = extractNextSequence(lastThresholdsId);
        String formattedSeq = String.format("%04d", nextSeq);
        return prefix + timestamp + randomChars + formattedSeq;

    }



    private String getTimeStamp(){
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    private String generateRandomChars(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    private int extractNextSequence(String lastUserId) {
        if (lastUserId == null || lastUserId.length() < 4) {
            return 1;
        }
        try {
            // Get last 4 digits of previous ID
            String lastSeq = lastUserId.substring(lastUserId.length() - 4);
            return Integer.parseInt(lastSeq) + 1;
        } catch (Exception e) {
            return 1;
        }
    }
}

