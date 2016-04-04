package MySpringMvc.model;

public class StatFile {

    private int id;
    private String name;
    private int maxf;
    private int minf;
    private float averf;
    private int lenghtfile;


    public StatFile() {
    }




    public StatFile(int id, String name, int maxf, int minf, float averf, int lenghtfile) {
        this.id = id;
        this.name = name;
        this.maxf = maxf;
        this.minf = minf;
        this.averf = averf;
        this.lenghtfile = lenghtfile;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
}

    public int getMaxf() {
        return maxf;
    }

    public void setMaxf(int maxf) {
        this.maxf = maxf;
    }

    public int getMinf() {
        return minf;
    }

    public void setMinf(int minf) {
        this.minf = minf;
    }

    public float getAverf() {
        return averf;
    }

    public void setAverf(float averf) {
        this.averf = averf;
    }

    public int getLenghtfile() {
        return lenghtfile;
    }

    public void setLenghtfile(int lenghtfile) {
        this.lenghtfile = lenghtfile;
    }
}


