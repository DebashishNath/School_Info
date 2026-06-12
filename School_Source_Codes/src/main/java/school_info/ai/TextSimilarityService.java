package school_info.ai;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TextSimilarityService {

    private static final Map<String, String> SYNONYMS = createSynonyms();

    public int calculateScore(

            String storedQuestion,

            String userQuestion

    ) {

        if (storedQuestion == null ||
                userQuestion == null) {

            return 0;

        }

        String stored =
                normalize(storedQuestion);

        String user =
                normalize(userQuestion);

        if (stored.equals(user)) {

            return 100;

        }

        Set<String> storedWords =
                tokenize(stored);

        Set<String> userWords =
                tokenize(user);

        if (storedWords.isEmpty() ||
                userWords.isEmpty()) {

            return 0;

        }

        int matched = 0;

        for (String word : storedWords) {

            if (userWords.contains(word)) {

                matched++;

            }

        }

        return (matched * 100) /
                Math.max(storedWords.size(), userWords.size());

    }

    private String normalize(

            String text

    ) {

        text = text.toLowerCase();

        text = text.replaceAll("[^a-z0-9 ]", " ");

        text = text.replaceAll("\\s+", " ").trim();

        for (Map.Entry<String, String> entry : SYNONYMS.entrySet()) {

            text = text.replace(entry.getKey(), entry.getValue());

        }

        return text;

    }

    private Set<String> tokenize(

            String text

    ) {

        return Arrays.stream(text.split("\\s+"))

                .filter(word -> word.length() > 2)

                .collect(Collectors.toSet());

    }

    private static Map<String, String> createSynonyms() {

        Map<String, String> map = new HashMap<>();

        /*
         * Bus / Transport
         */

        map.put("bus", "transport");
        map.put("vehicle", "transport");

        /*
         * Fee
         */

        map.put("fees", "fee");
        map.put("annual", "yearly");
        map.put("yearly", "yearly");

        /*
         * Admission
         */

        map.put("admission", "admission");
        map.put("admission process", "admission");

        /*
         * Documents
         */

        map.put("papers", "documents");
        map.put("paper", "documents");
        map.put("certificate", "documents");

        /*
         * School
         */

        map.put("institute", "school");

        /*
         * Class
         */

        map.put("standard", "std");
        map.put("class", "std");

        return map;

    }

}