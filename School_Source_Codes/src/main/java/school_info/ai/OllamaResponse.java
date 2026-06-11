package school_info.ai;

public class OllamaResponse {

    private String model;

    private String response;

    private Boolean done;

    private Long total_duration;

    private Long load_duration;

    private Integer prompt_eval_count;

    private Integer eval_count;

    public OllamaResponse() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(
            String model
    ) {
        this.model = model;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(
            String response
    ) {
        this.response = response;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(
            Boolean done
    ) {
        this.done = done;
    }

    public Long getTotal_duration() {
        return total_duration;
    }

    public void setTotal_duration(
            Long total_duration
    ) {
        this.total_duration = total_duration;
    }

    public Long getLoad_duration() {
        return load_duration;
    }

    public void setLoad_duration(
            Long load_duration
    ) {
        this.load_duration = load_duration;
    }

    public Integer getPrompt_eval_count() {
        return prompt_eval_count;
    }

    public void setPrompt_eval_count(
            Integer prompt_eval_count
    ) {
        this.prompt_eval_count = prompt_eval_count;
    }

    public Integer getEval_count() {
        return eval_count;
    }

    public void setEval_count(
            Integer eval_count
    ) {
        this.eval_count = eval_count;
    }

    @Override
    public String toString() {

        return "OllamaResponse{" +
                "model='" + model + '\'' +
                ", done=" + done +
                ", responseLength=" +
                (response == null ? 0 : response.length()) +
                ", promptEvalCount=" + prompt_eval_count +
                ", evalCount=" + eval_count +
                '}';

    }

}