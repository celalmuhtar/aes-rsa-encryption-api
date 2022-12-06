# AES and RSA Encryption

1. GET
   /v1/api/integ/proxyapi-admin/getNewRsaKeys
   RSA public və private key qaytarır.

2. GET
/v1/api/integ/proxyapi-admin/encryptsInputWithRandomAesKey
Daxil edilən məlumatı təsadüfü aes key ilə şifrələyib aes key və şirtələnmiş məlumatı qaytarır.

3. GET
/v1/api/integ/proxyapi-admin/encryptsInputWithInputAesKey
Daxil edilən məlumatı daxil edilən AES key ilə şifrələyir.

4. GET
/v1/api/integ/proxyapi-admin/encryptingWithRsaKey
Daxil edilən RSA public key ilə daxil edilən məlumatı şifrələyir

5. GET
/v1/api/integ/proxyapi-admin/decryptsInputWithInputAesKey
Daxil edilən şifrəli məlumatı daxil edilən aes key ilə açır.

6. GET
/v1/api/integ/proxyapi-admin/decryptingWithRsaKey
RSA ilə şifrələnmiş məlumatı RSA privat key daxil edərək decrip edir


![Screenshot from 2022-12-06 16-59-05.png](img%2FScreenshot%20from%202022-12-06%2016-59-05.png)