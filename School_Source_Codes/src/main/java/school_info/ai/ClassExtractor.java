package school_info.ai;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ClassExtractor {

    /*
     * Matches:
     *
     * STD 1
     * STD1
     * Std 10
     * CLASS 5
     * class12
     * standard 3
     */

    private static final Pattern CLASS_PATTERN =

            Pattern.compile(

                    "\\b(?:std|standard|class)\\s*(\\d{1,2})\\b",

                    Pattern.CASE_INSENSITIVE

            );

    public String extract(

            String question

    ) {

        if (question == null ||
                question.trim().isEmpty()) {

            return null;

        }

        Matcher matcher =
                CLASS_PATTERN.matcher(question);

        if (matcher.find()) {

            return matcher.group(1);

        }

        return null;

    }

    public String extractClassName(

            String question

    ) {

        String value =
                extract(question);

        if (value == null) {

            return null;

        }

        return "STD " + value;

    }

}