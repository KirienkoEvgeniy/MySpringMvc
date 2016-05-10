package LuxTz.model;

public class StatFile {

    private String id;
    private String name;
    private int maxf;
    private int minf;
    private float averf;
    private int lenghtfile;
    private int kolrow;


    public StatFile() {
    }




    public StatFile(String id, String name, int maxf, int minf, float averf, int lenghtfile, int kolrow) {
        this.id = id;
        this.name = name;
        this.maxf = maxf;
        this.minf = minf;
        this.averf = averf;
        this.lenghtfile = lenghtfile;
        this.kolrow = kolrow;

    }



    public String getId() {
        return id;
    }
    public void setId(String id) {
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




    public int getKolrow() {
        return kolrow;
    }

    public void setKolrow(int kolrow) {
        this.kolrow = kolrow;
    }
}


