package Utils;

import javax.servlet.http.Cookie;


public class CookieUtils {
    public static Cookie findCook(Cookie[] cookies,String cookeName){
        if(cookies == null || cookies.length == 0){
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookeName.equalsIgnoreCase(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
