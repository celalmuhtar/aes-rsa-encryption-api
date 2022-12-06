package az.com.dvx.cybernet.proxyapi.service;

import java.util.*;

public interface ApiService {
  Map<String, String> encryptsInputWithRandomAesKey(String input);
  Map<String, String> encryptsInputWithInputAesKey(String input, String aesKey);
  Map<String, String> getNewRsaKeys();
  String decryptingWithRsaKey(String encryptedText, String rsaPrivateKey);
  String encryptingWithRsaKey(String input, String rsaPublicKey);
  String decryptsInputWithInputAesKey(String encryptedText, String aesKey);
}
