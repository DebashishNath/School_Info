package school_info.ai;

import java.util.HashMap;
import java.util.Map;

public class OllamaRequest {

    private String model;

    private String prompt;

    private Boolean stream;

    private Map<String, Object> options;

    public OllamaRequest() {

        this.stream = Boolean.FALSE;

        this.options = new HashMap<>();

    }

    public OllamaRequest(

            String model,

            String prompt,

            Boolean stream,

            Map<String, Object> options

    ) {

        this.model = model;

        this.prompt = prompt;

        this.stream = stream;

        this.options =
                options == null
                        ? new HashMap<>()
                        : options;

    }

    public String getModel() {

        return model;

    }

    public void setModel(

            String model

    ) {

        this.model = model;

    }

    public String getPrompt() {

        return prompt;

    }

    public void setPrompt(

            String prompt

    ) {

        this.prompt = prompt;

    }

    public Boolean getStream() {

        return stream;

    }

    public void setStream(

            Boolean stream

    ) {

        this.stream = stream;

    }

    public Map<String, Object> getOptions() {

        return options;

    }

    public void setOptions(

            Map<String, Object> options

    ) {

        this.options =
                options == null
                        ? new HashMap<>()
                        : options;

    }

    @Override
    public String toString() {

        return "OllamaRequest{" +
                "model='" + model + '\'' +
                ", stream=" + stream +
                ", promptLength=" +
                (prompt == null ? 0 : prompt.length()) +
                ", options=" + options +
                '}';

    }

}