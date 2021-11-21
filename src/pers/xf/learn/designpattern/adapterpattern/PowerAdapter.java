package pers.xf.learn.designpattern.adapterpattern;

public class PowerAdapter extends AC220V implements IDC5V {
    @Override
    public int outputDC5V() {
        int old = super.out();
        int res = adapt(old);
        return res;
    }

    private int adapt(int V){
        System.out.println("----Adapting for DC----");
        return V/44;
    }
}
