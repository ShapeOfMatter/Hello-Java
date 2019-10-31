import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URLDecode {

    // Decodes a URL encoded string using `UTF-8`
    public static String decodeValue(String value) {
        try {
            return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            Log.log(ex.getMessage());
            return "";
        }
    }
}
