package az.com.dvx.cybernet.proxyapi.controller;

import az.com.dvx.cybernet.proxyapi.service.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import io.swagger.v3.oas.annotations.servers.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController

@OpenAPIDefinition(
    servers= {
        @Server(url="http://localhost:9091"),
        @Server(url="http://10.120.98.1:9091"),
        @Server(url="http://10.120.98.2:9091")
    }, info = @Info(title = "ProxyAPI-Admin", contact = @Contact(url = "http://cybernet.az", name = "Cəlal Muxtar", email = "celaleddin.muxtarov@cybernet.az"))
)
@RequestMapping("/v1/api/integ/proxyapi-admin")
public class ApiController {

  @Autowired
  ApiService apiService;

  @Operation(summary = "RSA public və private key qaytarır.")
  @RequestMapping(value = "/getNewRsaKeys", produces = {"application/json"}, method = RequestMethod.GET)
  ResponseEntity<?> getNewRsaKeys() {
    return ResponseEntity.ok(apiService.getNewRsaKeys());
  }

  @Operation(summary = "Daxil edilən məlumatı daxil edilən AES key ilə şifrələyir.")
  @RequestMapping(value = "/encryptsInputWithInputAesKey", produces = {"application/json"}, method = RequestMethod.GET)
  ResponseEntity<?> encryptsInputWithInputAesKey(@RequestParam String input, String aesKey) {
    return ResponseEntity.ok(apiService.encryptsInputWithInputAesKey(input, aesKey));
  }

  @Operation(summary = "Daxil edilən şifrəli məlumatı daxil edilən aes key ilə açır.")
  @RequestMapping(value = "/decryptsInputWithInputAesKey", produces = {"application/json"}, method = RequestMethod.GET)
  ResponseEntity<?> decryptsInputWithInputAesKey(@RequestParam String encryptedText, String aesKey) {
    return ResponseEntity.ok(apiService.decryptsInputWithInputAesKey(encryptedText, aesKey));
  }

  @Operation(summary = "Daxil edilən məlumatı təsadüfü aes key ilə şifrələyib aes key və şirtələnmiş məlumatı qaytarır.")
  @RequestMapping(value = "/encryptsInputWithRandomAesKey", produces = {"application/json"}, method = RequestMethod.GET)
  ResponseEntity<?> encryptsInputWithRandomAesKey(@RequestParam String input) {
    return ResponseEntity.ok(apiService.encryptsInputWithRandomAesKey(input));
  }

  @Operation(summary = "RSA ilə şifrələnmiş məlumatı RSA privat key daxil edərək decrip edir")
  @RequestMapping(value = "/decryptingWithRsaKey", produces = {"application/json"}, method = RequestMethod.GET)
  ResponseEntity<?> decryptingWithRsaKey(@RequestParam String encryptedText, String rsaPrivateKey) {
    return ResponseEntity.ok(apiService.decryptingWithRsaKey(encryptedText, rsaPrivateKey));
  }

  @Operation(summary = "Daxil edilən RSA public key ilə daxil edilən məlumatı şifrələyir")
  @RequestMapping(value = "/encryptingWithRsaKey", produces = {"application/json"}, method = RequestMethod.GET)
  ResponseEntity<?> encryptAESKey(@RequestParam String input, String rsaPublicKey) {
    return ResponseEntity.ok(apiService.encryptingWithRsaKey(input, rsaPublicKey));
  }
}
