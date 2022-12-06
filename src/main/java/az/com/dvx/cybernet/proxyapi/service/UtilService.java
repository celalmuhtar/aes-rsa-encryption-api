package az.com.dvx.cybernet.proxyapi.service;

import java.security.*;
import java.util.*;

public interface UtilService {
  String getRandomAesKey();
  String encryptsInputWithInputAesKey(String input, String aesKey);
  Map<String, String> getNewRsaPublicPrivateKey();
  String decryptingWithRsaKey(String encryptedText, PrivateKey privateKey);
  String encryptAESKey(String plainAESKey, PublicKey publicKey);

  String decryptsInputWithInputAesKey(String encryptedText, String aesKey);
}
