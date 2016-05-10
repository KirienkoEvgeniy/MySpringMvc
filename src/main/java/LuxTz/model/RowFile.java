package LuxTz.model;


public class RowFile {
        private String id_row;
        private String id;
        private int maxwordr;
        private int minwordr;
        private float averwordr;
        private int lenghtrow;

        public RowFile() {
        }

        public RowFile(String id_row, String id, int maxwordr, int minwordr, float averwordr, int lenghtrow) {
            this.id_row = id_row;
            this.id = id;
            this.maxwordr = maxwordr;
            this.minwordr = minwordr;
            this.averwordr = averwordr;
            this.lenghtrow = lenghtrow;
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_row() {
            return id_row;
        }
        public void setId_row(String id_row) {
            this.id_row = id_row;
        }

        public int getMaxwordr() {
            return maxwordr;
        }

        public void setMaxwordr(int maxwordr) {
            this.maxwordr = maxwordr;
        }

        public int getMinwordr() {
            return minwordr;
        }

        public void setMinwordr(int minwordr) {
            this.minwordr = minwordr;
        }

        public float getAverwordr() {
            return averwordr;
        }

        public void setAverwordr(float averwordr) {
            this.averwordr = averwordr;
        }

        public int getLenghtrow() {
            return lenghtrow;
        }

        public void setLenghtrow(int lenghtrow) {
            this.lenghtrow = lenghtrow;
        }
    }
