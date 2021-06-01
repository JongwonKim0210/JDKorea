package biz.jdkorea.com.common;

import biz.jdkorea.com.security.Crypt;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CommonUtil {

    private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);

    /**
     * Desc : 서버 경로공격을 예방한다.
     * @param filePath 첨부파일 경로
     * @return 경로공격이 없는 경우 첨부파일 경로를 다시 반환함
     * @throws Exception 경로공격 탐지 시
     */
    public String detectPathTraversal(String filePath) throws Exception {
        if (filePath != null && !filePath.isEmpty()) {
            String parentFolder1 = "../";
            String parentFolder2 = "..\\";
            if (filePath.contains(parentFolder1) || filePath.contains(parentFolder2) || filePath.toUpperCase().contains("WEB-INF")) {
                logger.debug("PathTraversal detected. filePath=" + filePath);
                throw new Exception("PathTraversal detected.");
            }
        }

        return filePath;
    }

    /**
     * Desc : XSS 공격을 예방한다.
     * @param src 문자열 소스
     * @return XSS 공격문자 제거 된 후의 문자열
     */
    public String stripScriptTagsAndFunctions(String src) {
        if (src != null && !src.isEmpty()) {
            Pattern p = Pattern.compile("<(object|applet|script).*?>|</(object|applet|script).*?>|alert([ ]*?/\\*.*?\\*/[ ]*?)?\\(.*?\\)|confirm([ ]*?/\\*.*?\\*/[ ]*?)?\\(.*?\\)|prompt([ ]*?/\\*.*?\\*/[ ]*?)?\\(.*?\\)|window.*?location",
                    Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
            Matcher m = p.matcher(src);
            src = m.replaceAll("");
        }

        return src;
    }

    /**
     * Desc : SHA3-256으로 해시값을 만든다.
     * @param password 비밀번호를 입력받는다.
     * @return 64byte String
     * @throws NoSuchAlgorithmException 해시화 알고리즘을 찾을 수 없는경우
     */
    public String passwordToHashPassword256(String password) throws NoSuchAlgorithmException {
        byte[] haxCodes = MessageDigest.getInstance("SHA3-256").digest(password.getBytes(StandardCharsets.UTF_8));
        return convertHaxToString(haxCodes);
    }

    /**
     * Desc : SHA3-512로 해시값을 만든다
     * @param password 비밀번호를 입력받는다.
     * @return 128byte String
     * @throws NoSuchAlgorithmException 해시화 알고리즘을 찾을 수 없는경우
     */
    public String passwordToHashPassword512(String password) throws NoSuchAlgorithmException {
        byte[] haxCodes = MessageDigest.getInstance("SHA3-512").digest(password.getBytes(StandardCharsets.UTF_8));
        return convertHaxToString(haxCodes);
    }

    /**
     * Desc : Hax 코드배열을 문자열로 변환한다.
     * @param haxCodes 16진수로 된 byte 배열
     * @return 변환된 문자열
     */
    private String convertHaxToString(byte[] haxCodes) {
        StringBuilder builder = new StringBuilder();
        for (byte hax : haxCodes) {
            builder.append(Integer.toString(((int) hax & 0xff)+0x100, 16).substring(1));
        }

        return builder.toString();
    }

    /**
     * Desc : 입력받은 값으로 Cookie 생성
     * @param request id, password
     * @return 암호화 된 CookieValue
     * @throws Exception 암호화 오류 처리
     */
    public String makeCookieValue(Map<String, Object> request) throws Exception {
        Gson gson = new Gson();
        String password = request.get("password").toString();
        password = passwordToHashPassword512(password);
        request.put("password", password);
        String loginCookie = gson.toJson(request);
        return Crypt.encode(loginCookie);
    }

    /**
     * Desc : 로그인 정보를 반환한다.
     * @param loginCookie 암호화 되어있는 loginCookie
     * @return 복호화 된 loginCookie / Gson Type
     * @throws Exception 복호화 오류 처리
     */
    public String getLoginInfo(String loginCookie) throws Exception {
        String decodeValue = "";
        if (!"".equalsIgnoreCase(loginCookie)) {
            decodeValue = decodeLoginCookie(loginCookie);
        }
        
        return decodeValue;
    }

    /**
     * Desc : 로그인 쿠키를 복호화 한다.
     * @param loginCookie 암호화 되어있는 loginCookie
     * @return 복호화 된 loginCookie / Gson Type
     * @throws Exception 복호화 오류 처리
     */
    private String decodeLoginCookie(String loginCookie) throws Exception {
        return Crypt.decode(loginCookie);
    }

}
