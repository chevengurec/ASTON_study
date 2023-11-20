public class Park {
    String attraction;

    public Park(String attraction) {
        this.attraction = attraction;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    public class Information {
        String time;
        int price;

        public Information (String time, int price) {
            this.time = time;
            this.price = price;
        }


        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
