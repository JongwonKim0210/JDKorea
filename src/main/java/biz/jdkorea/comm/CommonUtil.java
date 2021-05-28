package biz.jdkorea.comm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CommonUtil {

    private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);

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

    public String stripScriptTagsAndFunctions(String src) {
        if (src != null && !src.isEmpty()) {
            Pattern p = Pattern.compile("<(object|applet|script).*?>|</(object|applet|script).*?>|alert([ ]*?/\\*.*?\\*/[ ]*?)?\\(.*?\\)|confirm([ ]*?/\\*.*?\\*/[ ]*?)?\\(.*?\\)|prompt([ ]*?/\\*.*?\\*/[ ]*?)?\\(.*?\\)|window.*?location",
                    Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
            Matcher m = p.matcher(src);
            src = m.replaceAll("");
        }

        return src;
    }

    public String passwordToHashPassword(String password) throws NoSuchAlgorithmException {
        byte[] result = MessageDigest.getInstance("SHA3-256").digest(password.getBytes(StandardCharsets.UTF_8));
        return Arrays.toString(result);
    }
}
