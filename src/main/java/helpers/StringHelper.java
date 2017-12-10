package helpers;

import java.util.Enumeration;

public class StringHelper {
    public static String getString(String[] strArray) {
        if (strArray != null)
        {
            String result = "";

            for (int i = 0; i < strArray.length; i++) {
                if (i == strArray.length - 1)
                    result += strArray[i];
                else
                    result += strArray[i] + ", ";
            }

            return result;
        }

        else
            return null;

    }

    public static String getString(Enumeration<String> strEnum) {
        if (strEnum != null) {
            String result = "";

            if (strEnum.hasMoreElements()) {
                result += strEnum.nextElement();
            }

            do {
                if (strEnum.hasMoreElements())
                    result += ", " + strEnum.nextElement();
            } while (strEnum.hasMoreElements());

            return result;
        }

        else
            return null;
    }

    public static String replace(String mainStr, String replacedStr, String replacementStr) {
        if (replacementStr != null)
            return mainStr.replaceAll(replacedStr, replacementStr);

        else
            return mainStr.replaceAll(replacedStr, "Missing");
    }
}
