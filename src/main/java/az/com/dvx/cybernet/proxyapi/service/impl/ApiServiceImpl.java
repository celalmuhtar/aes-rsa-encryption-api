package az.com.dvx.cybernet.proxyapi.service.impl;

import az.com.dvx.cybernet.proxyapi.service.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.security.*;
import java.security.spec.*;
import java.util.*;

@Slf4j
@Service
public class ApiServiceImpl implements ApiService {

  @Autowired
  UtilService utilService;
  @Override
  public String decryptsInputWithInputAesKey(String encryptedText, String aesKey) {
    return utilService.decryptsInputWithInputAesKey(encryptedText, aesKey);
  }

  @Override
  public Map<String, String> encryptsInputWithRandomAesKey(String input) {
    String aesKey = utilService.getRandomAesKey();
    return encryptsInputWithInputAesKey(input, aesKey);
  }

  @Override
  public Map<String, String> encryptsInputWithInputAesKey(String input, String aesKey) {
    String encriptedText = utilService.encryptsInputWithInputAesKey(input, aesKey);
    Map<String, String> response = new HashMap<>();
    response.put("aesKey", aesKey);
    response.put("encriptedText", encriptedText);
    return response;
  }

  @Override
  public Map<String, String> getNewRsaKeys() {
    return utilService.getNewRsaPublicPrivateKey();
  }

  @Override
  public String decryptingWithRsaKey(String encryptedText, String rsaPrivateKey) {
    PrivateKey privateKey = null;
    try {
      byte[] privateKeyBytes = Base64.getDecoder().decode(rsaPrivateKey.getBytes("utf-8"));
      PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      privateKey = keyFactory.generatePrivate(keySpec);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    } catch (InvalidKeySpecException e) {
      throw new RuntimeException(e);
    }
    return utilService.decryptingWithRsaKey(encryptedText, privateKey);
  }

  @Override
  public String encryptingWithRsaKey(String plainAESKey, String rsaPublicKey) {
    PublicKey publicKey = null;
    try {
      byte[] privateKeyBytes = Base64.getDecoder().decode(rsaPublicKey.getBytes("utf-8"));
      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(privateKeyBytes);
      KeyFactory fact = KeyFactory.getInstance("RSA");
      publicKey = fact.generatePublic(keySpec);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    } catch (InvalidKeySpecException e) {
      throw new RuntimeException(e);
    }
    return utilService.encryptAESKey(plainAESKey, publicKey);
  }
}
