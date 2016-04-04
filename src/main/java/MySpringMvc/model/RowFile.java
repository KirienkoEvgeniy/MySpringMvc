package MySpringMvc.model;


public class RowFile {
        private int id_row;
        private int id;
        private int maxwordr;
        private int minwordr;
        private float averwordr;
        private int lenghtrow;


        public RowFile() {
        }




        public RowFile(int id_row, int id, int maxwordr, int minwordr, float averwordr, int lenghtrow) {
            this.id_row = id_row;
            this.id = id;
            this.maxwordr = maxwordr;
            this.minwordr = minwordr;
            this.averwordr = averwordr;
            this.lenghtrow = lenghtrow;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_row() {
            return id_row;
        }
        public void setId_row(int id_row) {
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
