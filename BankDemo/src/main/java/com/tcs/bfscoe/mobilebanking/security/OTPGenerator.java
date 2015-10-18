package com.tcs.bfscoe.mobilebanking.security;

import java.security.SecureRandom;
import java.util.Random;

public class OTPGenerator {
	
    public static int generateOTP() {
        String chars = "0123456789";

        final int PW_LENGTH = 6;
        Random rnd = new SecureRandom();
        StringBuilder pass = new StringBuilder();
        for (int i = 0; i < PW_LENGTH; i++)
            pass.append(chars.charAt(rnd.nextInt(chars.length())));
        return Integer.parseInt(pass.toString());
    }

}
