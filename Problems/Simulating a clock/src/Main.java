class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        minutes++;
        if (minutes > 59) {
            minutes = 0;
            hours = hours == 12 ? 1 : ++hours;
        }
    }
}