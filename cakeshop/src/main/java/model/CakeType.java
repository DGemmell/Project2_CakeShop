package model;

public enum CakeType {

    BROWNIE(40),
    MILLIONAIRES_SHORTBREAD(20),
    ROCKY_ROAD(25),
    CARROT_CAKE(12),
    CUP_CAKES(100);

    private int portion;

    CakeType(int portion ){
        this.portion = portion;
    }

    public int getPortion(){
        return portion;
    }




}
