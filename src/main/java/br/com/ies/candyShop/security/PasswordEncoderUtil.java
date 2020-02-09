package br.com.ies.candyShop.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class PasswordEncoderUtil extends BCryptPasswordEncoder {
}
