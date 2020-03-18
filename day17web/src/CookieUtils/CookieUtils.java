package CookieUtils;

import javax.servlet.http.Cookie;

public class CookieUtils {
    public static Cookie findAllCookies(Cookie[] cookies,String cookiesName){
        if(cookies==null || cookies.length==0){
            return null;
        }
        for (Cookie cookie:cookies
             ) {
            if(cookiesName.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
