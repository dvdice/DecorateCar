import java.io.IOException;

class Auto implements ToSomeFile{
    public int wheels = 6;
    public int doors = 5;
    public int RPM = 8000;
    public Float maxSpeed = 120.7f;
    public int sitPlace = 7;

    public float nowAngleWheel = 0;
    public float stopWheel = 50;

    public Float nowSpeed = 0f;
    private static final float a = 9f;

    public void Forward(float go) {
        nowSpeed += go * RPM * a;
    }

    public Float GetSpeed() {
        return nowSpeed;
    }

    public void Rotate(float turn) {
        nowAngleWheel += turn * a;
    }

    @Override
    public String transform(ToSomeFile auto) throws IllegalAccessException, IOException {
        return auto.toString();
    }

    @Override
    public void writeToFile(String str, String path) {

    }
}
